import pygame
import numpy
from math import sqrt
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
        self.frame_iterator = cycle(range(60))

    def update(self, char_x, char_y): #TO DO: Fix update function for bowser.
        #Override of update function for bowser
        if self.frame_iterator.__next__() == 0:
            x_vel, y_vel, action = self.action_ai(self.rect.x, self.rect.y, char_x, char_y)
            self.rect.x += x_vel
            #self.rect.y += y_vel
            if action and len(self.fireballs) < 2: self.perform_action(self.flame)
            self.image = self.bowser[self.iterator.__next__()]
            if action: self.image = self.bowser[self.mad_iterator.__next__()]
            for fireball in self.fireballs:
                fireball.update()
                if fireball.isOnScreen is False:
                    fireball.kill()

    def action_ai(self, x, y, char_x, char_y):
        #Action chooser for bowser AI
        dist = sqrt((char_y - y)**2 + (char_x - x)**2)
        randomness = numpy.random.uniform(0, 1.0)
        print(randomness)
        if dist < ACTION_RADIUS:
            if randomness < 0.5:
                return BOWSER_VEL, 0, True
            else:
                return -BOWSER_VEL, 0, False

    def perform_action(self, flames):
        fire = Fire(self.rect.centerx, self.rect.centery, flames)
        self.fireballs.add(fire)

class Fire(pygame.sprite.Sprite):
    def __init__(self, start_x, start_y, flames):
        super().__init__()
        self.image = flames[0]
        self.isOnScreen = True
        self.rect = self.image.get_rect()
        self.start = (start_x, start_y)
        self.rect.x, self.rect.y = start_x, start_y

    def update(self):
        self.rect.x -= FLAME_SPEED
        if self.rect.x < self.start[0] - FLAME_DISTANCE:
            self.isOnScreen = False