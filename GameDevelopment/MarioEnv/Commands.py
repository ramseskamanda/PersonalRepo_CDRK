import os
import sys
from pygame.locals import *
from Constants import VELOCITY, Y_VELOCITY, GRAVITY, STARTING_POSITION

# Check what keys are being pressed
# And return associated values.
def input_handler(keys, character, collideables):
    event = [0, 0, 'Standing']
    if keys[K_q] or keys[K_ESCAPE]:
        return False
    if keys[K_r]:
        os.execl(sys.executable, sys.executable, *sys.argv)
    if keys[K_LEFT]:
        event[0] = -VELOCITY
        event[2] = 'Walking'
        character._direction = 'Left'
    elif keys[K_RIGHT]:
        event[0] = VELOCITY
        event[2] = 'Walking'
        character._direction = 'Right'
    if keys[K_UP]:
        event[1] = Y_VELOCITY
        event[2] = 'Jumping'
    if not keys[K_UP]:
        event[1] = 0
    elif keys[K_DOWN]:
        pass

    character.update(event, collideables)
