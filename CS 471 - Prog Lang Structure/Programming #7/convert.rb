# Name          : Keller Sedillo-Garrido
# Date          : 10/31/2022
# Input         : No User Input
# Output        : Prints out File content
# PreCondition  : We expect a valid file input 
# 		        : under the name "ConvertCSVinput"
# PostCondition : This program will save
# 		        : the content of the process 
# 		        : to a file called "out"

# Read Input File
in_file = IO.readlines("ConvertCSVinput")

# Loop through each line
in_file.each do |line|

    line = line.strip                          # Strip away new lines
    File.write("out", line + " ; ", mode: "a") # Write Line into File

    split = line.split(",")                                         # Split by ','
    for i in 0..split.length - 2 do                                 # Loop through Split
        File.write("out", split[i].capitalize() + " ; ", mode: "a") # Write Split
    end                                                             # End For

    tail = split[split.length - 1]                                   # Get last split
    tailSplit = tail.split(".")                                      # Split by '.'
    File.write("out", tailSplit[0].capitalize() + " ;\n", mode: "a") # Write End
end                                                                  # End ForEach