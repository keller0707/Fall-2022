from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.neighbors import KNeighborsClassifier
from scipy.spatial.distance import cityblock
from sklearn.model_selection import KFold
import matplotlib.pyplot as plt
from sklearn import metrics
from sklearn.svm import SVR
import pandas as pd
import numpy as np

glass = pd.read_csv('glass.data', header=None)
glass = glass.to_numpy()
print("Here is glass Array")
print(glass)

glass_x = glass[:, :-1]
glass_y = glass[:, -1]

#print("Here is the split_X")
#print(glass_x)
#print("Here is the split_Y")
#print(glass_y)

glass_x_train, glass_x_test, glass_y_train, glass_y_test = train_test_split(glass_x, glass_y, train_size=0.8, test_size=0.2)

train = np.concatenate((glass_x_train, glass_y_train),axis=None)
test  = np.concatenate((glass_x_test, glass_y_test),axis=None)
np.savetxt('train.csv', train, delimiter=',', fmt='%d')
np.savetxt('test.csv', test, delimiter=',', fmt='%d')

k = [1, 3, 5, 7, 9, 11]
euclidean=[]
manhattan=[]

for i in k:
    classifier = KNeighborsClassifier(n_neighbors = i)
    classifier.fit(glass_x_train, glass_y_train)
    predicted = classifier.predict(glass_x_test)
    euclidean.append(np.linalg.norm(predicted - glass_y_test))
    manhattan.append(cityblock(predicted, glass_y_test))


print(euclidean)
print(manhattan)

plt.plot(k,euclidean,color='blue', linestyle='dashed', label="Euclidean")
plt.plot(k,manhattan,color='red' ,label="Manhattan")
plt.legend()
plt.show()

kf = KFold(n_splits=2)
nfold = kf.get_n_splits(glass_x)

logisticRegr = LogisticRegression()
regressor = SVR(kernel='rbf')
accuracy_logisticRegr=[]
accuracy_SVRRegr=[]

train_index, test_index = 0, 0
for train_index, test_index in kf.split(glass_x):
    print("TRAIN:", train_index, "TEST:", test_index)
    glass_x_train, glass_x_test = glass_x[train_index], glass_x[test_index]
    glass_y_train, glass_y_test = glass_y[train_index], glass_y[test_index]
    logisticRegr.fit(glass_x_train, glass_y_train)
    predictions = logisticRegr.predict(glass_x_test)
    accuracy_logisticRegr.append(logisticRegr.score(glass_x_test, glass_y_test))
    regressor.fit(glass_x_train, glass_y_train)
    accuracy_SVRRegr.append(regressor.predict(glass_x_test) - glass_y_test)
    plt.scatter(glass_x, glass_y, color = 'magenta')

#plt.plot(glass_x[:, 0], accuracy_logisticRegr,color='blue', label="LogisticRegression")
#plt.plot(glass_x[:, 0], accuracy_SVRRegr,color='red' ,label="SVR")
plt.legend()
plt.show()
#print("Predicted Values:")
#print(predicted)
#print("Target Values:")
#print(glass_y_test)
#print(metrics.accuracy_score(glass_y_test, predicted))
#print("Euclidean distance")
#dist = np.linalg.norm(predicted - k)
#print(dist)