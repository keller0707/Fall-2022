#Import package
import csv

#Open file
with open('titanic_train.csv') as csv_file:
    csv_reader = csv.reader(csv_file)
    linecount = 0
    for row in csv_reader:
        print(row)
