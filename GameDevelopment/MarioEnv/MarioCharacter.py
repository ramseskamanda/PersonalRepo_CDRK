import pygame
from Images import mario

class Character(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.mario = mario()
        self.image = self.mario[0]
        self.rect = self.image.get_rect()

    def update(self):
        #Override of the update function for Mario Character
        pass