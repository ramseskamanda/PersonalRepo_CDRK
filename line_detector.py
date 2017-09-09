import cv2
import numpy as np
import matplotlib.pyplot as plt
from game_board_maker import GameBoardMaker as gbm

class BoardDetection:
    def __init__(self, frame):
        self.original = frame
        self.game_board_corners = self.make_board_edges(frame)
        self.game_board_edges = self.game_board_corners.reshape(-1, 2)
        self.game_board = gbm(self.game_board_edges, self.width, 19)
    
    def draw_contours(self, contour):
        cv2.drawContours(self.original, contour, -1, (0, 255, 0), 5)
        return self.original

    def make_board_edges(self, frame):
        edges = self.line_detection(frame)
        edges_x = np.array([i[0][0] for i in edges])
        edges_y = np.array([i[0][1] for i in edges])
        edges_x = edges_x.tolist()
        edges_y = edges_y.tolist()

        x_left = min(edges_x)
        x_right = max(edges_x)
        y_up = min(edges_y)
        y_down = max(edges_y)
        
        edges = [[x_left, y_up], [x_left, y_down], [x_right, y_down], [x_right, y_up]]
        edges = np.array(edges).reshape(-1, 1, 2)
        self.width = x_right - x_left
        print(edges)
        return edges

    def line_detection(self, frame):
        frame = cv2.cvtColor(frame, cv2.COLOR_RGB2GRAY)
        frame = cv2.GaussianBlur(frame, (5, 5), 0)
        edges = cv2.Canny(frame, 50, 150, apertureSize=3)
        img2, contours, hierarchy = cv2.findContours(edges, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

        biggest = None
        max_area = 0
        for i in contours:
            area = cv2.contourArea(i)
            if area > 100:
                peri = cv2.arcLength(i, True)
                approx = cv2.approxPolyDP(i, 0.02*peri, True)
                if area > max_area and len(approx)==4:
                    biggest = approx
                    max_area = area
        return biggest

if __name__ == '__main__':
    frame = cv2.imread('empty_go_board.png', cv2.IMREAD_COLOR)
    board = BoardDetection(frame)
    frame = board.draw_contours(board.game_board_corners)
    board.game_board.animate()
    cv2.imshow('frame',frame)
