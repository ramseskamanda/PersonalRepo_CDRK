import pygame
from itertools import cycle
from Images import mario
from Constants import STARTING_POSITION, BACKGROUND_HEIGHT, TILE_SIZE, BACKGROUND_WIDTH, MARGIN, GRAVITY, LIMIT

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
        self.onGround = True
        self.alive = True

    def update(self, event, collideables, enemies):
        #Override of the update function for Mario Character
        self.x_vel = event[0]
        if event[1] > 0 and self.onGround:
            self.y_vel -= event[1]
        if not self.onGround:
            self.y_vel += GRAVITY
            if self.y_vel > LIMIT:
                self.y_vel = LIMIT
        self.rect.x += self.x_vel
        self.move(self.x_vel, 0, collideables, enemies)
        self.rect.y += self.y_vel
        self.onGround = False
        self.move(0, self.y_vel, collideables, enemies)
        self._state = event[2]
        self.find_image()
        
        

    def move(self, dx, dy, collideables, enemies):
        if self.rect.y >= STARTING_POSITION[1] and not self.onGround:
            self.rect.y = STARTING_POSITION[1]
            self.onGround = True
            self.y_vel = 0
        if self.rect.x < 0:
            self.rect.x = 0
        for c in collideables:
            if self.rect.colliderect(c.rect):
                if dx > 0: # Moving right; Hit the left side of the wall
                    self.rect.right = c.rect.left
                if dx < 0: # Moving left; Hit the right side of the wall
                    self.rect.left = c.rect.right
                if dy > 0: # Moving down; Hit the top side of the wall
                    self.rect.bottom = c.rect.top
                    self._state = 'Standing'
                    self.onGround = True
                    self.y_vel = 0
                if dy < 0: # Moving up; Hit the bottom side of the wall
                    self.rect.top = c.rect.bottom
        for e in enemies:
            if self.rect.colliderect(e.rect):
                if self.rect.bottom > e.rect.top and e.rect.left < self.rect.right and e.rect.right > self.rect.left:
                    e.kill()
                else:
                    self.alive = False

    def find_image(self):
        if self._state is 'Standing':
            self.image = self._mario[self._direction][0]
        if self._state is 'Walking':
            self.image = self._mario[self._direction][self.walking_iterator.__next__()]
        if self._state is 'Jumping':
            self.image = self._mario[self._direction][3]
        if self._state is 'Crouching':
            pass

    def collide_breakables(self, breakables):
        break_list = pygame.sprite.spritecollide(self, breakables, True)
        return break_list

















