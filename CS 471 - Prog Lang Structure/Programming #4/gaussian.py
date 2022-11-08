#
# Name        : Keller Sedillo-Garrido
# Date        : September 28, 2022
# Description : This program will perform Gaussian Elimination and Backward Subitution
#             : with a NxN+1 Matrix
# Input       : The size of the matrix
# Output      : A solved matrix with solutions.
#

#Libaries
import random
import sys
from array import *

#Set Vars
N = int(sys.argv[1]) # Get size of Matrix
A = []               # Create array for Matrix
x = []               # Create array for Solutions

#Create Matrix with random numbers
for i in range(N):                                             # Loop through the rows
    col = []                                                   # Create Columns  
    for j in range(N+1):                                       # Loop through the columns
        col.append(random.choice([1, 2, 3, 4, 5, 6, 7, 8, 9])) # Append a random number
    A.append(col)                                              # Add to array

#Gaussian Elimination
for i in range(N):                              # Loop Through Rows
    for j in range(i+1, N):                     # Loop Through Columns
        ratio = A[j][i]/A[i][i]                 # Get Ratio
        for k in range(N+1):                    # Loop through the rows
            A[j][k] = A[j][k] - ratio * A[i][k] # Update the elements

#Set the elements in the arrays in zero.
for i in range(N): 
    x.append(0)

#Set inital Solution
x[N-1] = A[N-1][N]/A[N-1][N-1]

#Backward Sub.
for i in range(N-2, -1, -1):       # Loop backward from end of array
    x[i] = A[i][N]                 # Set elemetns
    for j in range(i+1, N):        # Loop through columns
        x[i] = x[i] - A[i][j]*x[j] # Update elements
    x[i]=x[i]/A[i][i]              # Update element with solution
