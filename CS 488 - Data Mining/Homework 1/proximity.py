import numpy as np
import math 

### Functions ###

def euclidean(userArr, i):
    if (i >= len(userArr[0])): return 0
    if (i > 0): return math.pow(userArr[0,i] - userArr[1,i], 2) + euclidean(userArr, i+1)
    total = math.pow(userArr[0,i] - userArr[1,i], 2) + euclidean(userArr, i+1)
    return math.sqrt(total)

def manhattan(userArr, i):
    if(i >= len(userArr[0])): return 0
    return abs(userArr[0,i] - userArr[1,i]) + manhattan(userArr, i+1)

def dotProduct(arr1, arr2, i):
    if (i >= len(arr1)): return 0;
    return (arr1[i] * arr2[i]) + dotProduct(arr1, arr2, i+1)

def dist(userArr, i):
    if(i >= len(userArr)): return 0
    if(i > 0): return math.pow(userArr[i], 2) + dist(userArr, i+1)
    return math.sqrt(math.pow(userArr[i],2) + dist(userArr, i+1))

def cosineSim(userArr1, userArr2):
    #DotProduct
    dot = dotProduct(userArr1, userArr2, 0)

    #Sqrt
    d1 = dist(userArr1, 0)
    d2 = dist(userArr2, 0)

    #Calulate
    return dot / (d1 * d2)

def match(arr, num1, num2, i):
    if (i >= len(arr[0])): return 0
    num = 0
    if (arr[0, i] == num1 and arr[1, i] == num2):
        num = 1    
    return num + match(arr, num1, num2, i+1)

def smc(arr):
    #Find Matches for 11, 00
    num = match(arr, 1, 1, 0) + match(arr, 0, 0, 0)

    #Find Matched for 01, 10
    dem = match(arr, 0, 1, 0) + match(arr, 1, 0, 0)

    #Calculate
    return num / (num + dem)

def jaccard(arr):
    #Find Matches for 11
    num = match(arr, 1, 1, 0)

    #Find Matches for 01, 10
    dem = match(arr, 0, 1, 0) + match(arr, 1, 0, 0)

    #Calculate
    return num / (num + dem)

def hamming(arr, i):
    if(i >= len(arr[0])): return 0
    num = 0
    if(arr[0, i] != arr[1, i]): num = 1
    return num + hamming(arr, i+1)

def backTrack(arr, x, y):
    if x == 1 and y == 1: return "(1, 1)"
    if(x == 1): return backTrack(arr, 1, y-1) + "(1,",str(y),")"
    if(y == 1): return backTrack(arr, x-1, 1) + "(",str(x),", 1)"
    string = x,y
    
    tempArr = [abs(arr[x-1, y-1]), abs(arr[x-1, y]), abs(arr[x, y-1])]
    p = np.argmin(tempArr, axis=0)
    if   p == 0 :
        x = x-1
        y = y-1
    elif p == 1 :
        x = x-1
    else :
        y = y-1

    return backTrack(arr, x, y) + '(' + string + ')'

def dtw(s, t):
    #Create Matrix
    n, m = len(s), len(t)
    mat = np.full((n + 1,m + 1), np.inf)
    mat[0,0] = 0

    #Calculate
    for row in range(1,n + 1):
        for col in range(1,m + 1):
            mat[row, col] = abs(s[row - 1] - t[col - 1]) + min(mat[row - 1, col - 1], mat[row - 1, col], mat[row, col - 1])
    print("Distance: " + str(mat[n,m]))

    string = backTrack(mat, n, m)
    print(string)
    print(mat)

### Functions ###

arr1 = np.array([[1,2,4,5], [4,3,2,1]])
arr2 = np.array([[1,1,1,0,0],[1,0,0,0,1]])


print("Q.1)")
print("Euclidean         : " + str(euclidean(arr1, 0)))
print("Manhattan         : " + str(manhattan(arr1, 0)))
print("Cosine Similarity : " + str(cosineSim(arr1[0], arr1[1])))

print("\nQ.2)")
print("SMC                 : " + str(smc(arr2)))
print("Jaccard Coefficient : " + str(jaccard(arr2)))
print("Hamming Distance    : " + str(hamming(arr2, 0)))

print("\nQ.3)")
print(str(dtw(arr1[0], arr2[0])))
print("Distance  : ")
print("Warp Path : ")

