import cv2
import numpy as np
from statistics import mean
import matplotlib.pyplot as plt
from game_board_maker import contours

class StoneTracker:
    def __init__(self):
        self.stones_detected = None
        self.kernel = [25, 25]
        self.coordinates = []
        self.white_stones_coords = []
        self.black_stones_coords = []
        self.empty_spaces = []
        
    def white_tracking(self, frame):
            hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

            # define range of white color in HSV
            # change it according to your need !
            lower_white = np.array([0,0,0], dtype=np.uint8)
            upper_white = np.array([60,10,255], dtype=np.uint8)

            # Threshold the HSV image to get only white colors
            mask = cv2.inRange(hsv, lower_white, upper_white)
            # Bitwise-AND mask and original image
            res = cv2.bitwise_and(frame,frame, mask= mask)

            return mask, res

    def coordinates_tracker(self, frame,coords_array=None):
        self.mask, self.res = self.white_tracking(frame)
        coordinates = []
        counter = 0
        if coords_array is not None:
            for coords in coords_array:
                k = []
                for i in range(self.kernel[0]):
                    for j in range(self.kernel[1]):
                        pix = self.res[coords[0]+i][coords[1]+j]
                        pix = mean(pix)
                        k.append(pix)
                k = mean(k)
                coordinates.append(k)
                if k > 0:
                    counter +=1

        return coordinates, counter

    def norm(self, number):
        if number >= 150:
            number = 2
        elif number > 0:
            number = 1
        return number
    
    def normalize_array(self, stone_coordinates):
        normalized = list(map(self.norm, stone_coordinates))
        return normalized


if __name__ == '__main__':
    frame = cv2.imread('goban.png', 1)
    img = StoneTracker()
    coords = img.coordinates_tracker(frame)
    print(coords)
    cv2.imshow('frame',frame)
    cv2.imshow('res',img.res)
