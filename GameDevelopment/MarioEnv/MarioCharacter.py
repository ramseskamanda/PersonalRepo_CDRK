import pygame
from Images import mario
from Constants import STARTING_POSITION
from itertools import cycle

class Character(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self._mario = mario() #Dictionary containing all the mario images organized by direction
        self.image = self._mario['Right'][0]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = STARTING_POSITION
        self._state = None #None means no special power-ups
        self._direction = 'Right'
        self.iterator = cycle(range(1, 3))

    def update(self, event):
        #Override of the update function for Mario Character
        self.rect.x += event[0]
        self.rect.y += event[1]
        self._action = event[3]
        if event[0] != 0 or event[1] != 0:
            if self._action is not None:
                self.action_handler()
            else:
                self.image = self._mario[self._direction][self.iterator.__next__()]
        else:
            self.image = self._mario[self._direction][0]
    def action_handler(self):
        if self._state is not None:
            #Take an action and pass resulting image in self.image
            pass