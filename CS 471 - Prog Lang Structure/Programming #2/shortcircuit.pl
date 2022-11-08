# Name          : Keller Sedillo-Garrido
# Date          : 09/07/22
# Input         : N/A
# Output        : Output a false but no
# 		        : evaluation is printed.
# PreCondition  : No input from user 
# 		        : needed.
# PostCondition : This program will print
# 		        : either a true or a 
# 		        : false.

#Create Eval 
sub func1 {
	print("I have been evaluated\n"); # Print Eval
	return 1;                         # Return
}                                     # End Func1

my $i = 1;             # Set Var
if($i == 0 and func1){ # Check Values
	print("True\n");   # Print True
}else{                 # Else
	print("False\n");  # Print False
}                      # End ifElse

