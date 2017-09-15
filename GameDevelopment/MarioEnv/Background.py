import pygame
import os
from Constants import RATIO, BACKGROUND_HEIGHT, BACKGROUND_WIDTH, TILE_SIZE, PATH_CD, PATH_RK

class Basic_config:
    def __init__(self, username):
        if username == 'CD':
            self.path = PATH_CD
        else:
            self.path = PATH_RK
        self.background_config()
        self.ground_config()
        self.clouds_config()

    def show(self, img, screen, array=None, coords=None):
        if array is not None:
            for i in array:
                screen.blit(img, i)
        else:
            screen.blit(img, coords)

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

    def clouds_config(self):
       self.cloud_img = pygame.image.load(self.path + '/WalkableClouds.png').convert_alpha()
       self.cloud_img = pygame.transform.scale(self.cloud_img, (TILE_SIZE, TILE_SIZE))
       self.cloud = []
       for x in range(0, BACKGROUND_WIDTH, TILE_SIZE):
            self.cloud.append((x, 2*TILE_SIZE))