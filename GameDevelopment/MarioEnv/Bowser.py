import pygame
from Images import bowser

class Bowser(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.bowser = bowser()
        self.image = self.bowser[2]
        self.rect = self.image.get_rect()
