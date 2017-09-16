import pygame
from Constants import *
from Images import clouds, pipes

class Pipes(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.pipes = pipes()

class WalkableClouds(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.walkable_clouds_config()

    def walkable_clouds_config(self):
        self.walkable_clouds = pygame.image.load(PATH_RK + '/WalkableClouds.png').convert()

class Bricks(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.bricks_config()

    def bricks_config(self):
        self.bricks_images = []
        for i in range(1, 6):
            self.bricks_images.append(pygame.image.load(PATH_RK + '/l0_Bricks{}.png'.format(i)).convert())

class Coin(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.coin_config()

    def coin_config(self):
        self.coin_images = []
        for i in range(1,5):
            self.coin_images.append(pygame.image.load(PATH_RK + '/l0_sprite_coin{}.png'.format(i)).convert())

class Peach(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.peach_config()

    def peach_config(self):
        self.peach_images = []
        for i in range(1,3):
            self.peach_images.append(pygame.image.load(PATH_RK + '/l0_sprite_peach{}.png'.format(i)).convert())