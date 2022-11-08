# Name          : Keller Sedillo-Garrido
# Date          : 10/18/2022
# Input         : No User Input
# Output        : Prints out File content
# PreCondition  : No Precondition since no 
# 		        : user input.
# PostCondition : This program will print
# 		        : out the content of the 
# 		        : given file.
# Referance     :
#   ASCII TABLE : https://lwp.interglacial.com/appf_01.htm

# Modules used
use strict;
use warnings;

# Variables
my $filename = 'control-char.txt'; # Name of the file
my $ctrlB = 2;                     # DEC value of ^B
my $ctrlC = 3;                     # DEC value of ^C
my $string = "";                   # Var to hold string
my $char;                          # Charater from inputed string
my $flag = 1;                      # Flag to print

# Open File
open(FH, '<', $filename) or die $!;

# Loop through file
while(<FH>){

    # Get first line
    my $line = $_;

    # Loop through char in line
    foreach $char (split //, $line) {

        if(ord($char) == $ctrlC){     # Check if ^C
            $flag = 0;                # Set flag FALSE
        }elsif(ord($char) == $ctrlB){ # Check if ^B
            $flag = 1;                # Set flag TRUE
        }                             # END elseIf

        # Input char IF flag is true
        $string = $string.$char if($flag);
    } # END forEach

                       # Print out set of charater
    if($flag){         # Check if flag is TRUE
        print $string; # Print string
        $string = "";  # Clean string
    }                  # END if
}# END while
print("\n");
close(FH);