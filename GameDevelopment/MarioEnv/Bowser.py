import pygame
from Images import bowser

class Bowser(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.bowser = bowser()
        self.image = self.bowser[2]
        self.rect = self.image.get_rect()

    def update(self, char_x, char_y):
        #Override of update function for bowser
        _x, _y, _a = self.action_ai(self.rect.x, self.rect.y, char_x, char_y)
        self.rect.x += _x
        self.rect.y += _y
        self.perform_action(_a)


    def action_ai(self, x, y, char_x, char_Y):
        #Action chooser for bowser AI
        _x, _y, a = 0, 0, 0
        return _x, _y, _a


    def perform_action(self, action):
        #Action taker for bowser AI
        pass