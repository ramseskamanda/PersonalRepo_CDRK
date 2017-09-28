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
        self.step_counter = cycle(range(0, 100))
        self.possibleMovement = ['f', 'r']
        self.x_vel, self.y_vel, self.action = (0, 0, False)
        self.inBounds = True

    def update(self, char_x, char_y): #TO DO: Add jumping and mad bowser
        #Override of update function for bowser
        self.boundaries()
        dist = sqrt((char_y - self.rect.y)**2 + (char_x - self.rect.x)**2)
        if dist < ACTION_RADIUS and self.inBounds:
            self.x_vel, self.y_vel, self.action = self.action_ai()
            self.rect.x += self.x_vel
            self.image = self.bowser[self.iterator.__next__()]
    def boundaries(self):
        #TO DO: Implement a boundary function limiting Bowser to only move within his allocated space
        pass

    def action_ai(self):
        #Action chooser for bowser AI
        if self.step_counter.__next__() is 0:
            dx, dy, shoot = (0, 0, False)
            moveIndex = random.randrange(0, 2)
            movePower = random.randrange(-2, 2)
            if self.possibleMovement[moveIndex] == 'f':
                dx += BOWSER_VEL*movePower
            elif self.possibleMovement[moveIndex] == 'r':
                dx -= BOWSER_VEL*movePower
            return dx, dy, shoot
        else:
            return self.x_vel, self.y_vel, self.action

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