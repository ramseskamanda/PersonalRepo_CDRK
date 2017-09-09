import cv2
import numpy as np
from grab_screen import grab_screen
from color_tracking import StoneTracker
from line_detector import BoardDetection
from interaction_agent import InteractionAgent
np.set_printoptions(linewidth=100)

def main():
    frame = grab_screen(region=(10, 90, 940, 1020))
    board = BoardDetection(frame)
    coordinates = board.game_board.coordinates_maker(board.game_board_edges)
    stones = StoneTracker()
    agent = InteractionAgent()
    
    while True:
        screen = grab_screen(region=(10, 90, 940, 1020))
        stone_coordinates, counter = stones.coordinates_tracker(screen, coords_array=coordinates)
        stones.normalize_array(stone_coordinates)
        stone_coordinates = np.array(stone_coordinates).reshape(19, 19)
        print(stone_coordinates)
main()

'''
-Input from computer on board
-Q-Learning algorithm
-Neural Net to drive Q-Learning
-(Maybe a genetic algorithm to keep or kill good or bad perfermances in memory)
'''
