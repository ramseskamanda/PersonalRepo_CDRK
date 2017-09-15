import os

SCREEN_WIDTH, SCREEN_HEIGHT = 1280, 800
RATIO = SCREEN_HEIGHT/240
BACKGROUND_WIDTH, BACKGROUND_HEIGHT = int(3400*RATIO), int(240*RATIO)
TILE_SIZE = int(16*RATIO)
PATH_CD = os.path.join('/Users/cdalenbrook/Documents/Mario/MarioEnv', '/Users/cdalenbrook/Documents/Mario/Images')
PATH_RK = os.path.join('D:/Ramses/Documents/Github/PersonalRepo_CDRK/GameDevelopment/MarioEnv/',
                             'D:/Ramses/Documents/Github/PersonalRepo_CDRK/GameDevelopment/MarioEnv/Images')