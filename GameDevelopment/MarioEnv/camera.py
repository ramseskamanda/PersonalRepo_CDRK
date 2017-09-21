import pygame

class Camera: #TO DO: Figure out why game moves so slowly
    def __init__(self):
        self.angle = [0, 0]

    def update(self, velocity):
        self.angle[0] = velocity[0]
        self.angle[1] = velocity[1]

    def scroll(self, array_of_surface):
        for i in range(len(array_of_surface)):
            array_of_surface[i].scroll(self.angle[0], self.angle[1])