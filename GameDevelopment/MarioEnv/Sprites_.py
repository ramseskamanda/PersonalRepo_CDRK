import pygame
from itertools import cycle
from Constants import *
from Images import clouds, pipes, bricks, coin, peach, stairs

def Sprite_init():
    bricks_counter = cycle(range(5))
    coin_counter = cycle(range(4))
    p = pygame.sprite.Group(Pipes(size=size, position=pos) for size, pos in PIPES_POSITION)
    wc = pygame.sprite.Group(WalkableClouds(position=pos) for pos in CLOUD_POSITIONS)
    b = pygame.sprite.Group(Bricks(counter=bricks_counter.__next__(), position=pos) for pos in BRICK_POSITIONS)
    c = pygame.sprite.Group(Coin(coin_counter.__next__(), position=pos) for pos in COIN_POSITIONS)
    ALL_SPRITES = pygame.sprite.Group(p, wc, b, c)
    return ALL_SPRITES

class _Sprites(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        #TO DO: Implement wrapper class for all sprites
class Pipes(pygame.sprite.Sprite):
    def __init__(self, size, position):
        super().__init__()
        self.pipes = pipes()
        self.image = self.pipes[size]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = position


class WalkableClouds(pygame.sprite.Sprite):
    def __init__(self, position):
        super().__init__()
        self.clouds = clouds()
        self.image = self.clouds['img']
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = position


class Bricks(pygame.sprite.Sprite):
    def __init__(self, counter, position):
        super().__init__()
        self.bricks = bricks()
        self.image = self.bricks[counter]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = position


class Stairs(pygame.sprite.Sprite):
    def __init__(self, position):
        super().__init__()
        self.image = stairs()
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = position


class Coin(pygame.sprite.Sprite):
    def __init__(self, counter, position):
        super().__init__()
        self.coin = coin()
        self.image = self.coin[0]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = position

class Peach(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.peach = peach()
        self.image = self.peach[0]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = PEACH_POS
