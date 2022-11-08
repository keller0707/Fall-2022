import random
from csv import writer
from csv import DictWriter
import numpy as np
import csv

            
def append_dict_as_row(file_name, dict_of_elem, field_names):
    # Open file in append mode
    with open(file_name, 'w', newline='') as write_obj:
        # Create a writer object from csv module
        dict_writer = csv.DictWriter(write_obj, fieldnames=field_names)
        # Add dictionary as wor in the csv

        for i in range(650,700,1):
            dict_writer.writerow(dict_of_elem)

        write_obj.close()

def main():
    print('*** Append new row to an existing csv file using csv.writer() in python ***')
    csv_file = 'Portuguese.csv'
    school = ['GP', 'MS']
    sex = ['M', 'F']
    address = ['U', 'R']
    famsize = ['GT3','LT3']
    Pstatus = ['A','T']
    Mjob = ['at_home','health','other','services']
    Fjob = ['teacher','health','other','services']
    reason = ['course','other','home','reputation']
    guardian = ['father','mother','other']
    yes_no = ['yes','no']
    field_names = ['school',
                        'sex',
                        'age',
                        'address',
                        'famsize',
                        'Pstatus',
                        'Medu',
                        'Fedu',
                        'Mjob',
                        'reason',
                        'guardian',
                        'traveltime',
                        'studytime',
                        'failures',
                        'schoolsup',
                        'famsup',
                        'paid',
                        'activities',
                        'nursery',
                        'higher',
                        'internet',
                        'romantic',
                        'famrel',
                        'freetime',
                        'goout',
                        'Dalc',
                        'Walc',
                        'health',
                        'absences',
                        'G1',
                        'G2',
                        'G3']
    records = {
                        'school': np.random.choice(school),
                        'sex': np.random.choice(sex),
                        'age': np.random.choice([18,19,20,21,22,34,40]),
                        'address': np.random.choice(address),
                        'famsize': np.random.choice(famsize),
                        'Pstatus': np.random.choice(Pstatus),
                        'Medu': np.random.choice(range(1, 4)),
                        'Fedu': np.random.choice(range(1, 4)),
                        'Mjob': np.random.choice(Mjob),
                        'reason': np.random.choice(sex),
                        'guardian': np.random.choice(guardian),
                        'traveltime':np.random.choice(range(1, 2)),
                        'studytime':np.random.choice(range(1, 3)),
                        'failures':np.random.choice(range(0, 2)),
                        'schoolsup':np.random.choice(yes_no),
                        'famsup':np.random.choice(yes_no),
                        'paid':np.random.choice(yes_no),
                        'activities':np.random.choice(yes_no),
                        'nursery':np.random.choice(yes_no),
                        'higher':np.random.choice(yes_no),
                        'internet':np.random.choice(yes_no),
                        'romantic':np.random.choice(yes_no),
                        'famrel':np.random.choice(range(3, 5)),
                        'freetime':np.random.choice(range(1, 5)),
                        'goout':np.random.choice(range(1, 5)),
                        'Dalc':np.random.choice(range(0, 10)),
                        'Walc':np.random.choice(range(0, 10)),
                        'health':np.random.choice(range(0, 10)),
                        'absences':np.random.choice(range(0, 10)),
                        'G1':np.random.choice(range(0, 20)),
                        'G2':np.random.choice(range(0, 20)),
                        'G3':np.random.choice(range(0, 20)),
                    } 

    append_dict_as_row(csv_file, records, field_names)



if __name__ == '__main__':
    main()


