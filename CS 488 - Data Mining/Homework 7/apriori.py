import numpy as np
import pandas as pd
from apyori import apriori

transactions = [
    ['I1', 'I2', 'I5'],
    ['I2', 'I4'],
    ['I2', 'I3'],
    ['I1', 'I2', 'I4'],
    ['I3', 'I4'],
    ['I1', 'I3'],
    ['I1', 'I2', 'I3', 'I5'],
    ['I2', 'I3', 'I4'],
    ['I2', 'I3', 'I5'],
    ['I3', 'I5']
]

minSup = 0.3
conf = 0.7
	
associationRules = apriori(transactions,
                           min_support=minSup,
                           min_confidence=conf,
                           min_lift=0.0,
                           max_length=None)
associationResults = list(associationRules)
#print(len(associationResults))
for i in range (len(associationResults)):
    print(associationResults[i])
associationResults[0].
