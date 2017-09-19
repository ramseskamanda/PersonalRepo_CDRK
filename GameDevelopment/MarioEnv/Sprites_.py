import pygame
from itertools import cycle
from Constants import *
from Images import clouds, pipes, bricks, coin, peach, stairs

class _Sprites:
    def __init__(self):
        self.Sprite_init()

    def Sprite_init(self):
        bricks_counter = cycle(range(5))
        coin_counter = cycle(range(4))
        self.pipes = pygame.sprite.Group(Pipes(size=values[0], position=(values[1], values[2])) for values in PIPES_POSITION)
        self.wc = pygame.sprite.Group(WalkableClouds(position=pos) for pos in CLOUD_POSITIONS)
        self.bricks = pygame.sprite.Group(Bricks(counter=bricks_counter.__next__(), position=pos) for pos in BRICK_POSITIONS)
        self.coins = pygame.sprite.Group(Coin(coin_counter.__next__(), position=pos) for pos in COIN_POSITIONS)
        self.stairs = pygame.sprite.Group(Stairs(position=pos) for pos in STAIRS_POSITION)
        self.ALL_SPRITES = pygame.sprite.Group(self.pipes, self.wc, self.bricks, self.coins, self.stairs)

    def update(self): #TO DO: Deal with camera movements and add parameters: x_change
        self.ALL_SPRITES.update()

    def draw(self, screen):
        self.ALL_SPRITES.draw(screen)

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
