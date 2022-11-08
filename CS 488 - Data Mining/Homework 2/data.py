#Imports
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df = pd.read_csv('BreastCancerCoimbra.csv')
print(df)

#For the attribute BMI, calculate its mean, standard deviation, minimum, and maximum values.
bmi = df['BMI']
print("=-=-=-=-=Q.1=-=-=-=-=")
print("BMI Mean      :", bmi.mean())
print("BMI Std. Dev. :", bmi.std())
print("BMI Min       :", bmi.min())
print("BMI Max       :", bmi.max())

#Compute Pearson’s correlation between all possible attribute pairs.
print(df.corr(method='pearson'))

#Display the histogram for each of the quantitative attributes
plt.hist(df, bins=10)
plt.show()

#Display a boxplot to show the distribution of values for each attribute.
#plt.
plt.boxplot(df)
plt.show()

#Display a scatter plot
AB = plt.scatter(df['Age'], df['BMI'])
AG = plt.scatter(df['Age'], df['Glucose'])
AI = plt.scatter(df['Age'], df['Insulin'])
BG = plt.scatter(df['BMI'], df['Glucose'])
BI = plt.scatter(df['BMI'], df['Insulin'])
GI = plt.scatter(df['Glucose'], df['Insulin'])
plt.legend((AB, AG, AI, BG, BI, GI),("Age/BMI", "Age/Glucose", "Age/Insulin", "BMI/Glucose", "BMI/Insulin", "Glucose/Insulin"))
plt.show()
