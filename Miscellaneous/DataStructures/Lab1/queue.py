from collections import deque

''' QUEUE '''
def make_queue(elements):
    return deque(elements)

''' STACK (homemade) '''
#Knowingly long winded to do the work required
class stack:
    def __init__(self, elements=None):
        if elements: self.stack = list(elements)
        else: self.stack = list()

    def __str__(self):
        return str(self.stack)

    def enqueue(self, element):
        self.stack.append(element)

    def dequeue(self):
        last = self.stack[-1]
        self.stack = self.stack[:-1]
        return last

''' QUEUE (homemade) '''
class queue: #Add update method
    def __init__(self, elements=None):
        if elements: self.stack = list(elements)
        else: self.stack = list()
        self.left = stack()
        self.right = stack()

    def __str__(self):
        return str(self.left.stack[::-1] + self.right.stack)

    def appendleft(self, element):
        self.left.enqueue(element)

    def appendright(self, element):
        self.right.enqueue(element)

    def popleft(self):
        return self.left.dequeue()

    def popright(self):
        return self.right.dequeue()

if __name__ == '__main__':
    q = queue()
    for i in range(10):
        q.appendright(i)
        q.appendleft(-i)
    print(q)
    print(q.popleft())
    print(q.popright())
    print(q)

        
