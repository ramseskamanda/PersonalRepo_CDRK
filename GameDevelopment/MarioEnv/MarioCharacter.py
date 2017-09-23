import pygame
from itertools import cycle
from Images import mario
from Constants import STARTING_POSITION, BACKGROUND_HEIGHT, TILE_SIZE, BACKGROUND_WIDTH, MARGIN

class Character(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self._mario = mario() #Dictionary containing all the mario images organized by direction
        self.image = self._mario['Right'][0]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = STARTING_POSITION
        self._state = 'Standing'
        self._direction = 'Right'
        self.walking_iterator = cycle(range(1, 3))
        self.x_vel, self.y_vel = (0, 0)

    def update(self, event, collideables):
        #Override of the update function for Mario Character
        self.x_vel, self.y_vel = (event[0], event[1])
        self.move(self.x_vel, 0, collideables)
        self.move(0, self.y_vel, collideables)
        self._action = event[2]
        if self.rect.x < 0:
            self.rect.x = 0
        if self.rect.y < BACKGROUND_HEIGHT - 8*TILE_SIZE:
            self._state = 'Falling'
        if self._action is 'Standing':
            self.image = self._mario[self._direction][0]
        elif self._action is 'Walking':
            self.image = self._mario[self._direction][self.walking_iterator.__next__()]
        elif self._action is 'Jumping':
            self.image = self._mario[self._direction][3]
        if self._state is 'Falling':
            self.image = self._mario[self._direction][3]

    def move(self, dx, dy, collideables):
        self.rect.x += dx
        self.rect.y += dy
        for c in collideables:
            if self.rect.colliderect(c.rect):
                if dx > 0: # Moving right; Hit the left side of the wall
                    self.rect.right = c.rect.left
                if dx < 0: # Moving left; Hit the right side of the wall
                    self.rect.left = c.rect.right
                if dy > 0: # Moving down; Hit the top side of the wall
                    self.rect.bottom = c.rect.top
                    self._state = 'Standing'
                if dy < 0: # Moving up; Hit the bottom side of the wall
                    self.rect.top = c.rect.bottom

    def collide_breakables(self, breakables):
        break_list = pygame.sprite.spritecollide(self, breakables, True)
        return break_list




















