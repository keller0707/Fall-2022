#Import Libray
import pandas as pd
import matplotlib.pyplot as plt

#Load CSV file
print("1.) Loading CSV")
df = pd.read_csv('titanic_train.csv')
print("CSV successfully Loaded\n")

#Print the names and data types of all the columns.
print("\n2.) Printing the names and data types of all the columns:\n", df.info())

#Calculate and print the number of rows and columns
print("\n3.) Printing the number of rows and columns:\n(Rows, Cols):",df.shape)

#Calculate and print the distinct values of the last column
print("\n4.) Printing the values of the last column:\n",df['Embarked'])

#Calculate and print the distinct values of the “Survived” column
print("\n5.) Printing the values of the Survived column:\n",df['Survived'])

#Calculate and print the number of rows when the value of the 2nd column is 1
print("\n6.) Number of rows with a Survived value of 1:\n",df['Survived'].value_counts()[1])

#Calculate and print the number of rows that do not have missing values in the 6th column
print("\n7.) Number of rows that is not missing values in the Age Column:\n",df['Age'].notnull().sum())

#Calculate the average value of the 6th column
agedf = df['Age'].dropna()
print("\n8.) Average Value of the Age Column:\n",agedf.sum()/len(agedf))

#Calculate the average value of the 6th column when the 2nd column has value 1.
survdf = df[df['Survived'] == 1]
print("\n9.) Average Value of the Age Column with the Value 1 in the Survived Column\n",survdf['Age'].dropna().sum()/len(survdf['Age'].dropna()))

#Draw a scatter plot with the data of the 6th column (“Age” column) and the 10th column(“Fare” column).
newdf = df[['Age', 'Fare']].dropna().copy()
plt.xlabel('Age')
plt.ylabel('Fare')
plt.scatter(x = newdf['Age'].loc[df['Survived'] == 1], y = newdf['Fare'].loc[df['Survived'] == 1], s = 10, c = 'r', marker = "s")
plt.scatter(x = newdf['Age'].loc[df['Survived'] == 0], y = newdf['Fare'].loc[df['Survived'] == 0], s = 10, c = 'b', marker = "*")
plt.show()

