import pygame
from Constants import TILE_SIZE

class Camera: #TO DO: Figure out why game moves so slowly
    def __init__(self):
        self.angle = [0, 0]

    def update(self, character_position, velocity):
        if character_position > 8*TILE_SIZE:
            self.angle[0] = velocity[0]
            self.angle[1] = velocity[1]
        else:
            self.angle[0] = 0
            self.angle[1] = 0