import pygame
from Constants import *
from Images import clouds, pipes, bricks, coin, peach


class Pipes(pygame.sprite.Sprite):
    def __init__(self, size):
        super().__init__()
        self.pipes = pipes()
        self.image = self.pipes[size]
        self.rect = self.image.get_rect()

class WalkableClouds(pygame.sprite.Sprite):
    def __init__(self, x, y):
        super().__init__()
        self.clouds = clouds()
        self.image = self.clouds['img']
        self.rect = self.image.get_rect()

class Bricks(pygame.sprite.Sprite):
    def __init__(self, counter, x, y):
        super().__init__()
        self.bricks = bricks()
        self.image = self.bricks[counter]
        self.rect = self.image.get_rect()

class Coin(pygame.sprite.Sprite):
    def __init__(self, counter, x, y):
        super().__init__()
        self.coin = coin()
        self.image = self.coin[0]
        self.rect = self.image.get_rect()

class Peach(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.peach = peach()
        self.image = self.peach[0]
        self.rect = self.image.get_rect()
