import math

#Get input from User
x1 = int(input())
y1 = int(input())
x2 = int(input())
y2 = int(input())

vert_x = math.pow((x2-x1), 2)
vert_y = math.pow((y2-y1), 2)

eucl = math.sqrt(vert_x + vert_y)

print(eucl)