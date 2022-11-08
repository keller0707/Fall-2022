# Seth Ball
# Keller Sedillo
# Shafiq Zaman
# CS488  
# Final Project Basic Analysis
# 10/13/22

import os
import math
import pandas as pd 
import numpy as np
import statistics as stat
from matplotlib import pyplot as plt
from sklearn.cluster import KMeans
from sklearn.decomposition import PCA
from sklearn.datasets import load_digits
from sklearn.metrics import classification_report, accuracy_score
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score
from sklearn.cluster import KMeans
from sklearn.decomposition import PCA
from sklearn.datasets import load_digits
from sklearn.metrics import classification_report, accuracy_score
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import train_test_split
from sklearn.metrics import confusion_matrix
from sklearn.mixture import GaussianMixture 
from sklearn.preprocessing import StandardScaler, normalize
from sklearn.metrics import silhouette_samples, silhouette_score
from sklearn import metrics
from sklearn.datasets import make_classification
from sklearn.model_selection import KFold
from sklearn.svm import SVC
from sklearn.model_selection import cross_val_score
from sklearn.linear_model import LinearRegression
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score

# import csv files
Maths = pd.read_csv("maths.csv")
Portuguese = pd.read_csv("Portuguese.csv")

# settings options to view the entire data set in terminal
pd.set_option('display.max_columns', None)
pd.set_option('display.width', None)
pd.set_option('display.max_colwidth', None)

###############   Mean values

# mean values for all entries int Maths based on 'school'
print('Mean values according to school:')
print('Math:')
print(Maths.groupby('school').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('school').mean())
print()

# mean values for all entries in Maths based on 'sex'
print('Mean values according to sex:')
print('Math:')
print(Maths.groupby('sex').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('sex').mean())
print()

# mean values for all entries in Maths based on 'absences'
print('Mean values according to absences')
print('Math:')
print(Maths.groupby('absences').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('absences').mean())
print()

# mean values for all entries in Maths based on 'failures'
print('Mean values according to failures')
print('Math:')
print(Maths.groupby('failures').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('failures').mean())
print()

# mean values for all entries in Maths based on 'study time'
print('Mean values according to study time')
print('Math:')
print(Maths.groupby('studytime').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('studytime').mean())
print()

# mean values for all entries in Maths based on 'internet'
print('Mean values according to internet')
print('Math:')
print(Maths.groupby('internet').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('internet').mean())
print()

# mean values for all entries in Maths based on 'Medu'
print('Mean values according to Mothers education')
print('Math:')
print(Maths.groupby('Medu').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('Medu').mean())
print()

# mean values for all entries in Maths based on 'Fedu'
print('Mean values according to fathers education')
print('Math:')
print(Maths.groupby('Fedu').mean())
print()
print('Portuguese:')
print(Portuguese.groupby('Fedu').mean())
print()

# plots to show correlation between differnt term scores and the final grades
Maths.plot(x = 'G1', y = 'G3', kind = 'scatter', label = 'G1 scores compared to G3 scores')
plt.show()

Maths.plot(x = 'G1', y = 'G2', kind = 'scatter', label = 'G1 scores compared to G2 scores')
plt.show()

Maths.plot(x = 'G2', y = 'G3', kind = 'scatter', label = 'G2 scores compared to G3 scores')
plt.show()

#################################### KNN

cols = [-1]

y = Maths.iloc[-1]
X = Maths.drop(Maths.columns[cols], axis=1, inplace=True)

X, y = make_classification()

# create training and test sets for kfold and svm 
x_train, x_test, y_train, y_test = train_test_split(X,y, random_state=1, test_size=0.2, shuffle=True)

E_scores = []
M_scores = []
K_vals = [1,3,5,7,9,11]

# Euclidean Distance KNN
for i in range(12):
	if i % 2 == 1:
		N = KNeighborsClassifier(n_neighbors=i)
		N.fit(x_train, y_train)

		score = N.score(x_test, y_test)
		#print(score)

		E_scores.append(score)

# Manhattan Distance KNN
for i in range(12):
	if i % 2 == 1:
		N = KNeighborsClassifier(n_neighbors=i, metric='manhattan')
		N.fit(x_train, y_train)

		score = N.score(x_test, y_test)
		#print(score)

		M_scores.append(score)

# plot for knn Euclidean Distance
plt.plot(E_scores, K_vals)
plt.title('KNN-Euclidean Distance')
plt.xlabel('Euclidean Scores')
plt.ylabel('K-Values')
plt.show()

# plot for knn Manhattan Distance
plt.plot(M_scores, K_vals)
plt.title('KNN-Manhattan Distance')
plt.xlabel('Manhattan Scores')
plt.ylabel('K-Values')
plt.show()


#################################### K Fold


cv = KFold(n_splits=5, random_state=1, shuffle=True)
# change model to linear regressions
model = LinearRegression()
# obtain accuracy scores for the dataset using kfold
scores = cross_val_score(model, X, y, scoring='neg_mean_absolute_error', cv=cv, n_jobs=-1)
print('Average Accuracy Score KFold:')
print(np.mean(np.absolute(scores)))
print()


#################################### SVM 


SVM = SVC(kernel='rbf')
SVM.fit(x_train,y_train)
predictions = SVM.predict(x_test)
print('Accuracy Score SVM:')
print(accuracy_score(y_test, predictions))
print()


print("=================================================")
print("Apply k-means clustering")
df = pd.read_csv('Maths.csv',skiprows=1, header=None, usecols=range(1, 33))
data = df.dropna(axis = 0, how ='any', thresh = None, subset = None, inplace= False)
data.to_csv('data.csv')


#Load Data
data = load_digits().data
pca = PCA(2)
 
#Transform the data
df = pca.fit_transform(data)
 
#Import KMeans module
from sklearn.cluster import KMeans
 
#Initialize the class object
kmeans = KMeans(n_clusters = 5)
 
#predict the labels of clusters.
label = kmeans.fit_predict(df)
 
#Getting unique labels
u_labels = np.unique(label)
 
#plotting the results:
for i in u_labels:
    plt.scatter(df[label == i , 0] , df[label == i , 1] , label = i)
plt.legend()

centers = np.array(kmeans.cluster_centers_)

plt.scatter(centers[:,0], centers[:,1], marker="x", color='black')
plt.title("train k-means  for best 5 k clusters and black X are the centroid of clusters")

plt.show()


print("=================================================")
print("Apply Gaussian Mixture clustering")
df = pd.read_csv('Maths.csv',skiprows=1, header=None, usecols=range(24, 33))
X = df.to_numpy()
scaler = StandardScaler()
X_scaled = scaler.fit_transform(X)
 
# Normalizing the data so that the data approximately
# follows a Gaussian distribution
X_normalized = normalize(X_scaled)
 
# Converting the numpy array into a pandas DataFrame
X_normalized = pd.DataFrame(X_normalized)

# Reducing the dimensions of the data 
pca = PCA(n_components = 2)
X_principal = pca.fit_transform(X_normalized)
X_principal = pd.DataFrame(X_principal)
X_principal.columns = ['P1', 'P2']


#returns the set of X configurations with shorter distance
def SelBest(arr:list, X:int)->list:
    dx=np.argsort(arr)[:X]
    return arr[dx]


n_clusters=np.arange(2, 7)
sils = []
sils_err = []
iterations = 10
for n in n_clusters:
    tmp_sil=[]
    for _ in range(iterations):
        # apply Gaussian Mixture clustering for  different cluster
        gmm = GaussianMixture(n, n_init=2).fit(X_principal)
        labels = gmm.predict(X_principal)
        #store  silhouette_score in an array for further calculation
        sil = metrics.silhouette_score(X_principal, labels, metric='euclidean')
        tmp_sil.append(sil)

    plt.figure(figsize =(6, 6))
    plt.scatter(X_principal['P1'], X_principal['P2'],c = GaussianMixture(n_components = n).fit_predict(X_principal), cmap ='rainbow', alpha = 0.6) 
    plt.title('Gaussian Mixture Clustering, k = '+str(n))
    plt.show() 

    #calculate average of the silhouette_score and its error rates
    val = np.mean(SelBest(np.array(tmp_sil), int(iterations/5)))
    err = np.std(tmp_sil)
    sils.append(val)
    sils_err.append(err) #store score in an array 




# Plotting a bar graph to compare the results
#Evaluating the different models and Visualizing the results to find best k according to silhouette_score
plt.bar(n_clusters, sils, yerr = sils_err)
plt.title("Silhouette Scores", fontsize=20)
plt.xticks(n_clusters)
plt.xlabel("N. of clusters")
plt.ylabel("Score")
plt.show()

