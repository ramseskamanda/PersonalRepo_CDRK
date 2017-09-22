import pygame
from Constants import SCREEN_WIDTH, SCREEN_HEIGHT, HALF_SCREEN_WIDTH, HALF_SCREEN_HEIGHT

class Camera(object):
    def __init__(self, camera_func, width, height):
        self.camera_func = camera_func
        self.state = pygame.Rect(0, 0, width, height)

    def apply(self, target):
        return target.rect.move(self.state.topleft)

    def update(self, target):
        self.state = self.camera_func(self.state, target.rect)

def complex_camera(camera, target_rect):
    l, t, _, _ = target_rect
    _, _, w, h = camera
    l, t, _, _ = -l+HALF_SCREEN_WIDTH, -t+HALF_SCREEN_HEIGHT, w, h # center player

    l = min(0, l)                           # stop scrolling at the left edge
    l = max(-(camera.width-SCREEN_WIDTH), l)   # stop scrolling at the right edge
    t = max(-(camera.height-SCREEN_HEIGHT), t) # stop scrolling at the bottom
    t = min(0, t)                           # stop scrolling at the top

    return pygame.Rect(l, t, w, h)