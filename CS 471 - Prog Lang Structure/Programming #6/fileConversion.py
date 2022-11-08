# Name          : Keller Sedillo-Garrido
# Date          : 10/18/2022
# Input         : No User Input
# Output        : Prints out File content
# PreCondition  : No Precondition since no 
# 		          : user input.
# PostCondition : This program will print
# 		          : out the content of the 
# 		          : given file.

with open('control-char.txt') as f:
    # Init Var
    printOn = True # Value that determineds if we should print
    String = ""    # Holds String to print

    # Loop through file input
    while True:
        # Read in char
        c = f.read(1)

        # Check if empty
        if not c: break

        if ascii(c) == ascii('\x03') :  # Check ^C
          printOn = False               # Turn Printing OFF
        elif ascii(c) == ascii('\x02'): # Check ^B
          printOn = True                # Turn Printing ON
        elif printOn :                  # Check if Printing is ON
          if ascii(c) == ascii('\n'):   # Check for New Line
            print(String)               # Print String
            String = ""                 # Empty String
          else:                         # Else
            String = String + c         # Add String