#
# Name        : Keller Sedillo-Garrido
# Date        : September 28, 2022
# Description : This program will perform Gaussian Elimination and Backward Subitution
#             : with a NxN+1 Matrix
# Input       : The size of the matrix
# Output      : A solved matrix with solutions.
#

#Libary
import numpy as np
from scipy.linalg import lu
from scipy.linalg import solve_triangular
import random
import sys

#Set vars
N = int(sys.argv[1])                   # Get Matrix Size from user
A = np.random.randint(10, size=(N, N)) # Create NxN Matrix
b = np.random.randint(10, size=(N, 1)) # Create Nx1 Matrix 
x = np.zeros(N)                        # Create array to hold solutions

#Use LU sub.
p, l, u = lu(np.concatenate((A,b),axis=1))

#Split Solition
A = u[:, :-1] #All but last Col
b = u[:, -1]  #Just last Col

#Backwards
x = solve_triangular(A,b, lower=False)

####### OLD CODE #######
#Check for 0 in the Diagnals.
#for i in range(N): 
#    if A[i][i] == 0: 
#        A[i][i] = random.choice([1, 2, 3, 4, 5, 6, 7, 8, 9])
#    for j in range(i+1, N):
#        ratio = A[j][i]/A[i][i]
#        for k in range(N):
#            A[j][k] = A[j][k] - (ratio * A[i][k])
#        b[j] = b[j] - (ratio * b[i])
#
#x[N-1] = b[N-1]/A[N-1][N-1]
#
#for i in range(N-1, -1, -1):
#    x[i] = A[i][N-1]
#    for j in range(i, N):
#        x[i] = x[i] - A[i][j]*x[j]

#    x[i]=x[i]/A[i][i]
