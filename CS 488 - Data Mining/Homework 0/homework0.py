#Import Libray
import pandas as pd
import matplotlib.pyplot as plt

#Load CSV file
df = pd.read_csv('titanic_train.csv')

#Print the names and data types of all the columns.
print(df.info())

#Calculate and print the number of rows and columns
print("\nPrinting the number of rows and columns:\n(Rows, Cols):",df.shape)

#Calculate and print the distinct values of the last column
print("\nPrinting the values of the last column:\n",df['Embarked'])

#Calculate and print the distinct values of the “Survived” column
print("\nPrinting the values of the Survived column:\n",df['Survived'])

#Calculate and print the number of rows when the value of the 2nd column is 1
print("\nNumber of rows with a Survived value of 1:\n",df['Survived'].value_counts()[1])

#Calculate and print the number of rows that do not have missing values in the 6th column
print("\nNumber of rows that is not missing values:\n",df['Age'].notnull().sum())

#Calculate the average value of the 6th column
agedf = df['Age'].dropna()
print("\nAverage Value of the Age Column:\n",agedf.sum()/len(agedf))

#Calculate the average value of the 6th column when the 2nd column has value 1.
survdf = df[df.Survived == 1].dropna()
print("\nAverage Value of the Age Column with the Value 1 in the Survived Column\n",survdf['Age'].sum()/len(survdf))

#Draw a scatter plot with the data of the 6th column (“Age” column) and the 10th column(“Fare” column).
df.plot()
plt.show()

