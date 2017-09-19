import pygame
from pygame.locals import *
from Constants import SCREEN_WIDTH, SCREEN_HEIGHT
from Background import Basic_config
from Sprites_ import Sprite_init
from Commands import input_handler
from MarioCharacter import Character
from time import sleep

class MarioEnv:
    def __init__(self):
        self._running = True
        self._screen = None
        self.size = self.width, self.height = SCREEN_WIDTH, SCREEN_HEIGHT

    def on_init(self):
        pygame.init()
        self._screen = pygame.display.set_mode(self.size, pygame.HWSURFACE | pygame.DOUBLEBUF | pygame.FULLSCREEN)
        pygame.key.set_repeat(100, 100)
        self.clock = pygame.time.Clock()
        self._background = Basic_config()
        self._sprites_array = Sprite_init()
        self.char = Character()
        self.mario = pygame.sprite.Group(self.char)
        self._running = True

    def on_event(self, keys):
        #Check if window was closed.
        for event in pygame.event.get():
            if event.type == QUIT:
                self._running = False
        if input_handler(keys, self.char) == False:
            self._running = False


    def on_loop(self):
        #TO DO: MAKE AN UPDATE FUNCTION THAT MOVES ALL THE SPRITES ACCORDING TO CAMERA MOVEMENTS
        self._sprites_array.update()

    def on_render(self):
        self._background.show(self._background._background, self._screen, coords=(0, 0))
        self._background.show(self._background._ground['img'], self._screen, array=self._background._ground['array'])
        self._sprites_array.draw(self._screen)
        self.mario.draw(self._screen)
        pygame.display.flip()

    def on_cleanup(self):
        pygame.quit()

    def on_execute(self):
        if self.on_init() == False:
            self._running = False

        while (self._running):
            keys = pygame.key.get_pressed()
            self.on_event(keys)
            self.on_loop()
            self.on_render()
        self.on_cleanup()
