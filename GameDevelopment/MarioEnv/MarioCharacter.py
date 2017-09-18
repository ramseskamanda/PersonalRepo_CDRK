import pygame
from Images import mario
from Constants import STARTING_POSITION, BACKGROUND_HEIGHT, TILE_SIZE, GRAVITY
from itertools import cycle

class Character(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self._mario = mario() #Dictionary containing all the mario images organized by direction
        self.image = self._mario['Right'][0]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = STARTING_POSITION
        self._state = 'Standing' #None means no special power-ups
        self._direction = 'Right'
        self.iterator = cycle(range(1, 3))

    def update(self, event):
        #Override of the update function for Mario Character
        self.rect.x += event[0]
        self.rect.y -= event[1]
        self._action = event[2]
        if self.rect.y < BACKGROUND_HEIGHT - 8*TILE_SIZE:
            self._state = 'Falling'
        if self._action is None:
            self.image = self._mario[self._direction][0]
        elif self._action is 'Walking':
            self.image = self._mario[self._direction][self.iterator.__next__()]
        elif self._action is 'Jumping':
            self.image = self._mario[self._direction][3]
