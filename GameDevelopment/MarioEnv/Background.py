import pygame
import os
from PIL import Image
from resizeimage import resizeimage
from Constants import SCREEN_HEIGHT

fd_img = open('/Users/cdalenbrook/Documents/Mario/Images/background0.png', 'r')
img = Image.open(fd_img)
img = resizeimage.resize_height(img, SCREEN_HEIGHT)
img.save('background1.png', img.format)
fd_img.close()

class Background_config:
    def __init__(self):
        path = os.path.join('/Users/cdalenbrook/Documents/Mario/MarioEnv', '/Users/cdalenbrook/Documents/Mario/Images')
        self.background_color = pygame.image.load(path + '/background1.png').convert()


