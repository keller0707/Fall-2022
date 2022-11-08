<?php
// Name          : Keller Sedillo-Garrido
// Date          : 09/07/22
// Input         : N/A
// Output        : Output a false and 
// 		   evaluate will be 
// 		   printed
// PreCondition  : No input from user
// 		   is required.
// PostCondition : Will print either
// 		   True or False.

// Create Function
function func1(){
	echo "I have been evaluated\n"; // Print evaluation
	return 1;                       // Return True
}                                   // End func1

// Set i
$i = 1;

// Check values
if($i == 0 && func1()){ // Check Values
	echo "True\n";      // Print True
} else {                // Else
	echo "False\n";     // Print False
}                       // End ifElse
?> 
