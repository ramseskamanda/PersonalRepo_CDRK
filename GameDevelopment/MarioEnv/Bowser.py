import pygame
from math import sqrt
import random
from itertools import cycle
from Images import bowser
from Constants import BOWSER_POSITION, BOWSER_VEL, BOWSER_THRUST, ACTION_RADIUS, FLAME_SPEED, FLAME_DISTANCE

class Bowser(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.bowser, self.flame = bowser()
        self.image = self.bowser[2]
        self.rect = self.image.get_rect()
        self.rect.x, self.rect.y = BOWSER_POSITION
        self.fireballs = pygame.sprite.Group()
        self.iterator = cycle(range(4))
        self.mad_iterator = cycle(range(4, 6))
        self.possibleMovement = ['f', 'r']

    def update(self, char_x, char_y): #TO DO: Add jumping and mad bowser
        #Override of update function for bowser
        dist = sqrt((char_y - self.rect.y)**2 + (char_x - self.rect.x)**2)
        if dist < ACTION_RADIUS:
            x_vel, y_vel, action = 0, 0, True#self.action_ai()
            self.rect.x += x_vel
            #self.rect.y += y_vel
            if action is True and len(self.fireballs) < 3:
                self.perform_action()
            self.image = self.bowser[self.iterator.__next__()]
            #if action: self.image = self.bowser[self.mad_iterator.__next__()]

    def action_ai(self):
        #Action chooser for bowser AI
        dx, dy, shoot = (0, 0, False)
        moveIndex = random.randrange(0, 2)
        movePower = random.randrange(0, 4)
        if self.possibleMovement[moveIndex] == 'f':
            dx += BOWSER_VEL*movePower
        elif self.possibleMovement[moveIndex] == 'r':
            dx -= BOWSER_VEL*movePower/2
        return dx, dy, shoot

    def perform_action(self):
        fire = Fire(self.rect.x, self.rect.y, self.flame)
        self.fireballs.add(fire)

class Fire(pygame.sprite.Sprite):
    def __init__(self, start_x, start_y, flames):
        super().__init__()
        self.image = flames[0]
        self.rect = self.image.get_rect()
        self.isOnScreen = True
        self.start = (start_x, start_y)
        self.rect.x, self.rect.y = self.start

    def update(self):
        self.rect.x -= FLAME_SPEED
        #if self.rect.x < self.start[0] - FLAME_DISTANCE:
         #   self.isOnScreen = False