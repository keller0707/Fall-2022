# Name          : Keller Sedillo-Garrido
# Date          : 09/07/22
# Input         : N/A
# Output        : Output a false but no
# 		  evaluation is printed.
# PreCondition  : No input from user 
# 		  needed.
# PostCondition : This program will print
# 		  either a true or a 
# 		  false.

sub func1 {
	print("I have been evaluated\n");
	return 1;
}

my $i = 1;
if($i == 0 & func1){
	print("True\n");
}else{
	print("False\n");

}

