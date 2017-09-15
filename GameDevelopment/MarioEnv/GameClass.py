import pygame
from pygame.locals import *
from Constants import SCREEN_WIDTH, SCREEN_HEIGHT
from Background import Sprite_config

class MarioEnv:
    def __init__(self):
        self._running = True
        self._screen = None
        self.size = self.width, self.height = SCREEN_WIDTH, SCREEN_HEIGHT

    def on_init(self):
        pygame.init()
        self._screen = pygame.display.set_mode(self.size, pygame.HWSURFACE | pygame.DOUBLEBUF | pygame.FULLSCREEN)
        pygame.key.set_repeat(100, 100)
        self._background = Sprite_config()
        self._running = True

    def on_event(self, event):
        #Check if window was closed.
        if event.type == QUIT:
            self._running = False
        #Check what keys are being pressed
        #And call associated functions.
        keys = pygame.key.get_pressed()
        if keys[K_q]:
            self.running = False
        if keys[K_LEFT]:
            pass
        elif keys[K_RIGHT]:
            pass
        if keys[K_UP]:
            pass
        elif keys[K_DOWN]:
            pass

    def on_loop(self):
        pass

    def on_render(self):
        self._background.show(self._background.background_color, self._screen,coords=(0, 0))
        self._background.show(self._background.ground_img, self._screen, array=self._background.ground)
        pygame.display.flip()

    def on_cleanup(self):
        pygame.quit()

    def on_execute(self):
        if self.on_init() == False:
            self._running = False

        while (self._running):
            for event in pygame.event.get():
                self.on_event(event)
            self.on_loop()
            self.on_render()
        self.on_cleanup()
