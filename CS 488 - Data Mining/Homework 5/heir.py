# Python program to plot the hierarchical
# clustering dendrogram using SciPy
 
# Import the python libraries
import numpy as np
from scipy.cluster import hierarchy
import matplotlib.pyplot as plt
 
# Create an array
x = np.array([100., 200., 300., 400., 500., 250.,
              450., 280., 450., 750.])
 
# Plot the hierarchical clustering as a dendrogram.
temp = hierarchy.linkage(x, 'single')
plt.figure()
 
dn = hierarchy.dendrogram(
    temp, above_threshold_color="green", color_threshold=.7)

plt.show()