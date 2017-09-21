import os
import sys
from pygame.locals import *
from Constants import VELOCITY, Y_VELOCITY, GRAVITY, STARTING_POSITION

# Check what keys are being pressed
# And call associated functions.
def input_handler(keys, character, camera):
    event = [0, 0, None]
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
        if character._state is 'Falling' and character.rect.y <= STARTING_POSITION[1]:
            event[1] = GRAVITY
        else:
            event[1] = Y_VELOCITY
            event[2] = 'Jumping'
            character._state = 'Jumping'
    elif keys[K_DOWN]:
        if character._state is 'Falling' and character.rect.y <= STARTING_POSITION[1]:
            event[1] = GRAVITY
        else:
            event[2] = 'Crouching'
    elif not keys[K_UP]:
        if character.rect.y > STARTING_POSITION[1]:
            event[1] = 0
            character._state = 'On the ground'
        else:
            character._state = 'Falling'
            event[1] = GRAVITY

    character.update(event)
    camera.update(event)