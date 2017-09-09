import numpy as np
import time
import sys
import tkinter as tk
from itertools import cycle

contours = [[ 13, 13], [13, 197], [197, 197], [197,  13]]

class GameBoardMaker(tk.Tk, object):
    def __init__(self, contours, board_width, num_lines):
        super(GameBoardMaker, self).__init__()
        x = np.array([i[0] for i in contours])
        y = np.array([i[1] for i in contours])
        num_squares = num_lines - 1
        self.width = self.height = num_squares
        self.square_size = int(board_width/num_squares)
        self.stone_size = 10
        self.black = '#000000'
        self.white = '#ffffff'
        self.stones = {'black': [],
                       'white': []}

        np.random.seed(1)
        self.cycler = cycle(range(100))
        self.title('board')
        self.geometry('{0}x{1}'.format((self.height+2) * self.square_size, (self.width+2) * self.square_size))
        self.canvas = tk.Canvas(self, bg='white',
                           height=(self.height+2) * self.square_size,
                           width=(self.width+2) * self.square_size)

    def _build_board(self):
        # create grids
        for c in range(self.square_size, (self.width+2) * self.square_size, self.square_size):
            x0, y0, x1, y1 = c, self.square_size, c, (self.height+1) * self.square_size
            self.canvas.create_line(x0, y0, x1, y1)
        for r in range(self.square_size, (self.height+2) * self.square_size, self.square_size):
            x0, y0, x1, y1 = self.square_size, r, (self.height+1) * self.square_size, r
            self.canvas.create_line(x0, y0, x1, y1)

        # create origin
        self.origin = np.array([contours[0][0], contours[0][1]])

        # pack all
        self.canvas.pack()

    def add_stone(self, position, color):
        if position in self.stones['black'] or position in self.stones['white']:
            print('Stone already placed in this spot')
            return
        self.stones[color].append(position)

    def draw_stone(self, position, color):
        box_position = [position[0]-self.stone_size, position[1]-self.stone_size,
                    position[0]+self.stone_size, position[1]+self.stone_size]
        
        if color == 'black':
            self.canvas.create_oval(box_position[0], box_position[1],
                                                 box_position[2], box_position[3],
                                                 outline=self.black, fill=self.black)
        elif color == 'white':
            self.canvas.create_oval(box_position[0], box_position[1],
                                                 box_position[2], box_position[3],
                                                 outline=self.black, fill=self.white)
            
    def remove_stone(self, position):
        try:
            if position in self.stones['black']:
                self.stones['black'].remove(position)
            elif position in self.stones['white']:
                self.stones['white'].remove(position)
        except ValueError:
            print('Error, removing inexistant stone')
            return

    def event_checker(self):
        n = next(self.cycler)
        if n == 0:
            self.remove_stone((env.height*env.square_size, env.width*env.square_size))
        elif n == 35:
            self.remove_stone((env.square_size, env.square_size))
        elif n == 65:
            self.add_stone((env.height*env.square_size, env.width*env.square_size), 'white')
        elif n == 95:
            self.add_stone((env.square_size, env.square_size), 'black')
        
    def animate(self):
        self.canvas.delete('all')
        self._build_board()
        self.event_checker()
        for stone in self.stones['black']:
            self.draw_stone(stone, 'black')
        for stone in self.stones['white']:
            self.draw_stone(stone, 'white')
        self.update_idletasks()
        self.update()

if __name__ == '__main__':
    env = GameBoardMaker(contours, contours[1][1] - contours[1][0], 9)
    env.add_stone((env.square_size, env.square_size), 'white')
    env.add_stone((env.height*env.square_size, env.width*env.square_size), 'black')
    for _ in range(10000):
        env.animate()
        
