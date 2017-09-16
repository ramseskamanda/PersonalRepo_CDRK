import pygame
from Constants import *

#IMAGES
def background():
    BACKGROUND = pygame.image.load(PATH + '/background0.png').convert()
    x, y = BACKGROUND.get_size()
    BACKGROUND = pygame.transform.scale(BACKGROUND, (int(x * RATIO), int(y * RATIO)))
    return BACKGROUND


def ground():
    IMG = pygame.image.load(PATH + '/Ground.png').convert()
    IMG = pygame.transform.scale(IMG, (TILE_SIZE, TILE_SIZE))
    GROUND = []
    for y in range(BACKGROUND_HEIGHT - 2 * TILE_SIZE, BACKGROUND_HEIGHT, TILE_SIZE):
        for x in range(0, BACKGROUND_WIDTH, TILE_SIZE):
            GROUND.append((x, y))
    return {'img': IMG, 'array' : GROUND}


def castle():
    IMG = [pygame.image.load(PATH + '/Castle{}.png'.format(i)).convert_alpha() for i in range(1, 3)]
    CASTLE = []


def clouds():
    IMG = pygame.image.load(PATH + '/WalkableClouds.png').convert_alpha()
    IMG = pygame.transform.scale(IMG, (TILE_SIZE, TILE_SIZE))
    BG_CLOUDS = []
    CLOUDS = []
    for x in range(0, BACKGROUND_WIDTH, TILE_SIZE):
        BG_CLOUDS.append((x, 2*TILE_SIZE))
    for x in range(0, BACKGROUND_WIDTH, TILE_SIZE):
        CLOUDS.append((x, 4*TILE_SIZE))
    return {'img': IMG, 'array_bg' : BG_CLOUDS, 'array_w' : CLOUDS}


def pipes():
    IMG = [pygame.image.load(PATH + '/Pipes{}.png'.format(i)).convert_alpha() for i in range(7)]
    IMG = [pygame.transform.scale(img, (TILE_SIZE, (int(img.get_size()[1] / 16))*TILE_SIZE)) for img in IMG]
    PIPES = [(x, BACKGROUND_HEIGHT - 3 * TILE_SIZE) for x in range(0, BACKGROUND_WIDTH, TILE_SIZE) for img in IMG]
    return {'img' : IMG, 'array' : PIPES}


def bricks():
    IMG = [pygame.image.load(PATH + '/l0_Bricks{}.png'.format(i)).convert() for i in range(1, 6)]
    return IMG


def coin():
    IMG = [pygame.image.load(PATH + '/l0_sprite_coin{}.png'.format(i)).convert_alpha() for i in range(1, 5)]
    return IMG


def peach():
    IMG = [pygame.image.load(PATH + '/l0_sprite_peach{}.png'.format(i)).convert_alpha() for i in range(1, 3)]
    return IMG


def bowser():
    IMG = [pygame.image.load(PATH + 'l0_Bowser{}'.format(i)).convert_alpha() for i in range(1, 7)]
    return IMG


def mario():
    IMG = [pygame.image.load(PATH + 'l0_sprite_smallmario{}'.format(i)).convert_alpha() for i in range(1, 7)]
    return IMG