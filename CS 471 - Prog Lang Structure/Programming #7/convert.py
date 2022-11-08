# Name          : Keller Sedillo-Garrido
# Date          : 10/31/2022
# Input         : No User Input
# Output        : Prints out File content
# PreCondition  : We expect a valid file input 
# 		        : under the name "ConvertCSVinput"
# PostCondition : This program will save
# 		        : the content of the process 
# 		        : to a file called "out"

# Create/Open Write File
writeFile  = open('out', 'w')

# Read in input file
with open('ConvertCSVinput') as f:
    
    # Loop through file input
    while True:
        # Read in line
        c = f.readline()

        # Check if empty
        if not c: break
        
        # Write Line 
        writeFile.write(c.strip() + " ; ")
        
        # Split Line by ','
        split = c.split(",")
        
        for i in range(len(split) - 1):                   # Loop through tokens
            writeFile.write(split[i].capitalize()+ " ; ") # Write each token

        end = split[len(split) - 1].split(".")         # Split End by '.'
        writeFile.write(end[0].capitalize() + " ;\n")  # Write End
    # Close Input File
    f.close()
#Close Output File
writeFile.close()