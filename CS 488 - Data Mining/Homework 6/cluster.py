import pandas as pd
import numpy as np
from sklearn.cluster import KMeans
from sklearn.metrics import silhouette_score

# Read in file
df = pd.read_csv('google_review_ratings.csv')
print(df)

# Remove empty row
dataFile = df.dropna(axis=0)
print(dataFile)

# Save into new CSV file
np.savetxt("data.csv", dataFile, delimiter=',', fmt = "%s")
print(dataFile.dtypes)

# Edit Data to only have Floats
dataFile = dataFile.to_numpy()
users = dataFile[:,0]
data  = dataFile[:, 1:]

print(users)
print(data)

label = np.empty([24,1], dtype=object)
print(label)
for i in range(24):
    label[i, 0] = 'C' + str(i+1)
    #c = i+1
    #label.append("C"+ str(i+1))
# test = np.array([label])
print(label)
score = []
# Run K-Means
for k in range(1, 11):
    avg = [0,0]
    for loop in range(2):
        kmean = KMeans(n_clusters=k, random_state=loop)
        kpred = kmean.fit_predict(data)
        avg[loop] = silhouette_score(data, kpred, metric='euclidean')
    #score.append = avg[0] + avg[1]/2