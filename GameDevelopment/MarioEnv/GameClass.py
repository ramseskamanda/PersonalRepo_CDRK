import pygame
from pygame.locals import *
from Constants import SCREEN_WIDTH, SCREEN_HEIGHT

class MarioEnv:
    def __init__(self):
        self._running = True
        self._display_surf = None
        self.size = self.width, self.height = SCREEN_WIDTH, SCREEN_HEIGHT

    def on_init(self):
        pygame.init()
        self._display_surf = pygame.display.set_mode(self.size, pygame.HWSURFACE | pygame.DOUBLEBUF)
        self._running = True

    def on_event(self, event):
        if event.type == QUIT:
            self._running = False
        elif event.type == KEYDOWN:
            if event.key == K_q:
                self._running = False
        keys = pygame.key.get_pressed()
        if keys[K_LEFT]:
            pass
        if keys[K_RIGHT]:
            pass
        if keys[K_UP]:
            pass
        if keys[K_DOWN]:
            pass

    def on_loop(self):
        pass

    def on_render(self):
        pass

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
