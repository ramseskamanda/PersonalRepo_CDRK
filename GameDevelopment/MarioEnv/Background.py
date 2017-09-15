import pygame
import os
from Constants import RATIO, BACKGROUND_HEIGHT, BACKGROUND_WIDTH, TILE_SIZE

class Sprite_config:
    def __init__(self, username):
        if username == 'CD':
            self.path = os.path.join('/Users/cdalenbrook/Documents/Mario/MarioEnv', '/Users/cdalenbrook/Documents/Mario/Images')
        elif username == 'RK':
            self.path = os.path.join('D:\Ramses\Documents\Github\PersonalRepo_CDRK\GameDevelopment\MarioEnv\', 'D:\Ramses\Documents\Github\PersonalRepo_CDRK\GameDevelopment\MarioEnv\Images')
        self.background_config()
        self.ground_config()

    def background_config(self):
        #loading the background color (blue rectangle)
        self.background_color = pygame.image.load(self.path + '/background0.png').convert()
        x, y = self.background_color.get_size()
        self.background_color = pygame.transform.scale(self.background_color, (int(x*RATIO), int(y*RATIO)))

    def ground_config(self):
        self.ground_img = pygame.image.load(self.path + '/Ground.png').convert()
        self.ground_img = pygame.transform.scale(self.ground_img, (TILE_SIZE, TILE_SIZE))
        self.ground = []
        for y in range(BACKGROUND_HEIGHT-2*TILE_SIZE, BACKGROUND_HEIGHT, TILE_SIZE):
            for x in range(0, BACKGROUND_WIDTH, TILE_SIZE):
                self.ground.append((x, y))

    def show(self, img, screen, array=None, coords=None):
        if array is not None:
            for i in array:
                screen.blit(img, i)
        else:
            screen.blit(img, coords)
