import pygame
from Images import background, clouds, castle

class Basic_config: #TO DO: Make the background a single image or add more background props
    def __init__(self):
        self._background = background()
        self._clouds = clouds()
        self._castle = castle()