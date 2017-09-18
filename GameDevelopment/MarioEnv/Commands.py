from pygame.locals import *
from Constants import VELOCITY

# Check what keys are being pressed
# And call associated functions.
def input_handler(keys, character):
    event = [0, 0, None]
    if keys[K_q] or keys[K_ESCAPE]:
        return False
    if keys[K_LEFT]:
        event[0] = -VELOCITY
        event[2] = 'Walking'
        character._direction = 'Left'

    elif keys[K_RIGHT]:
        event[0] = VELOCITY
        event[2] = 'Walking'
        character._direction = 'Right'
    if keys[K_UP]:
        event[1] = -VELOCITY
        event[2] = 'Jumping'
    elif keys[K_DOWN]:
        event[2] = 'Crouching'

    character.update(event)