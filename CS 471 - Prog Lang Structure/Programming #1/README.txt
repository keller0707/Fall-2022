Program's Name:
	aliasing.c

Discription:
	This program is designed to show how C programming language is able to use the same data location for different data types.

Instruction:
	To run the program:
		1.) Open Terminal
		2.) Make sure your Terminal is on this file
		3.) run "make all"
		4.) Enjoy

Project Questions:
	1.) In what memory segment is the array allocated?
		The array is allocated in the Stack. When printing out the
		location of the array, the print out a higher address which
		is usally is allocated for the stack 				

	2.) In what memory segment is the pointer to the array allocated?
		The pointer to the array is allocated in the Stack. When we print
		the location of the pointer, we see that it's located near 			the higher end of memory regesters.
		
	Source: 
		https://courses.engr.illinois.edu/cs225/sp2022/resources/stack-heap/
		 
	3.) How can you make your array be in another segment?
		Moving the array outside of the fuction will cause the compiler 
		to read it as a global which will store it lower in memory.
	
	4.) What endianness was the computer you ran your problem on?
		My Computer runs little endian	
		
	5a.) Why is there a difference between little and big endian?
		The difference is that big endian stores the higher two bytes first
		while little endian stores the lower two byes first.
		
	5b.) Which one is better?
		It depends of the process you do. Big Endian is better when you
		store values since you store it as you read it. Little Endian is 
		good as numerical calucation since you don't have to shift the 
		bytes around.
		
	5c.) Source:
		https://www.techtarget.com/searchnetworking/definition/big-endian-and-little-endian
	
	6.) Do you we need to fill the entire last interger with '0', 
	    or can we just fill in the last byte with '0'.		
		Since A[5] only fills the first two bytes, the last 
		two bytes will be set as 0 thus forcing the string to terminate.  
