import pyautogui
import numpy as np
from collections import Counter

class InteractionAgent():
    def __init__(self):
        self.width, self.height = pyautogui.size()
        self.addonWidth = 10
        self.addonHeight = 90

    def checkTurn(self, board, my_color='black'):
        pass

    def interact(self, coordinates):
        pyautogui.click(coordinates[0]+self.addonWidth,
                        coordinates[1]+self.addonHeight,
                        button='left')

    def pickAction(self, stones, interval):
        a = None
        zeros = []
        for i in range(len(stones)):
            for j in range(len(stones[i])):
                if stones[i][j] == 0:
                    zeros.append([i*interval, j*interval])
        if len(zeros) >= 1:
            a = np.random.randint(len(zeros))
            action = zeros[a]
            print(action)
            return action

if __name__ == '__main__':
    coords = (176, 95)
    agent = InteractionAgent()
    agent.interact(coords)
