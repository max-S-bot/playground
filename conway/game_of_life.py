import numpy as np
import threading

H: int = 8
W: int = 8

grid = np.zeros((H, W), dtype=bool)

#configure grid

def nextStatus(val: bool, i: int, j: int) -> bool: 
    liveNeighbors: int = 0
    for k in range(i-1, i+1):
        for l in range(j-1, j+1):
            liveNeighbors += (k != i or l != j) and inRange(k, l) and grid[k][l]
    return liveNeighbors == 3 or (val and liveNeighbors == 2)

inRange = lambda k, l: k >= 0 and k < H and l >= 0 and l < W

def printGrid():
    for i in range(H):
        for j in range(W):
            print('X' if grid[i][j] else 'O', end=' ')
        print()

def doGen():
    pass # alter array here
    printGrid(grid)

threading.Timer(5, doGen).start()