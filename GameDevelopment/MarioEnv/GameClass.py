import pygame
from pygame.locals import *
from Constants import SCREEN_WIDTH, SCREEN_HEIGHT, BACKGROUND_WIDTH, BACKGROUND_HEIGHT
from Background import Basic_config
from Sprites_ import _Sprites
from Commands import input_handler
from MarioCharacter import Character
from camera import Camera, complex_camera

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
        self._background = Basic_config() #TO DO: Delete background creation and instead make simple function to load an already made bg
        self._sprites_array = _Sprites()
        self.mario = Character()
        self.ALL_SPRITES = pygame.sprite.Group(self._sprites_array.ENTITIES, self.mario)
        self.camera = Camera(complex_camera, BACKGROUND_WIDTH, BACKGROUND_HEIGHT)
        self._running = True

    def on_event(self, keys):
        for event in pygame.event.get():
            if event.type == QUIT:
                self._running = False
        if input_handler(keys, self.mario, self._sprites_array.COLLIDEABLES) == False:
            self._running = False

    def on_loop(self):
        score_increment = self.mario.collide_breakables(self._sprites_array.BREAKABLES)
        self.camera.update(self.mario)
        self._sprites_array.update()

    def on_render(self):
        self._screen.blit(self._background._background, (0, 0))
        for s in self.ALL_SPRITES: self._screen.blit(s.image, self.camera.apply(s))
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
