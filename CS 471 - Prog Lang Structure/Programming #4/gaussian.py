import random
import sys
from array import *

N = int(sys.argv[1])

A = []
x = []
for i in range(N):
    col = []
    for j in range(N+1):
        col.append(random.choice([1, 2, 3, 4, 5, 6, 7, 8, 9]))
    A.append(col)

for i in range(N): 
    for j in range(i+1, N):
        ratio = A[j][i]/A[i][i]
        for k in range(N+1):
            A[j][k] = A[j][k] - ratio * A[i][k]

for i in range(N):
    x.append(0)

x[N-1] = A[N-1][N]/A[N-1][N-1]

for i in range(N-2, -1, -1):
    x[i] = A[i][N]
    for j in range(i+1, N):
        x[i] = x[i] - A[i][j]*x[j]

    x[i]=x[i]/A[i][i]
