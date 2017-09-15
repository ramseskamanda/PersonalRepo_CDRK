import pygame
from Constants import PATH_CD, PATH_RK

class Pipes(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()

    def pipes_config(self):
        self.pipes_images = []
        for i in range(1, 8):
            self.pipes_images.append(pygame.image.load(PATH_RK + '/l0_Pipes{}.png'.format(i)).convert())

class WalkableClouds(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()

    def walkable_clouds_cofig(self):
        self.walkable_clouds = pygame.image.load(PATH_RK + '/WalkableClouds.png').convert()

class Bricks(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()

    def bricks_config(self):
        self.bricks_images = []
        for i in range(1, 6):
            self.bricks_images.append(pygame.image.load(PATH_RK + '/l0_Bricks{}.png'.format(i)).convert())

class Coin(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__():

    def coin_cofig(self):
        self.coin_images = []
        for i in range(1,5):
            self.coin_images.append(pygame.image.load(PATH_RK + '/l0_sprite_coin{}.png'.format(i)).convert())

class Peach(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__():

    def peach_config(self):
        self.peach_images = []
        for i in range(1,3):
            self.peach_images.append(pygame.image.load(PATH_RK + '/l0_sprite_peach{}.png'.format(i)).convert())