Programming #2
=-=-=-=-=-=-=-=-=-=
This are instructions on how to run my program.
I have made a make file in hopes that it is easier
to run each program. After unziping the file and opening
the terminal to the location of the new file, you can
call "make all(Name of language)" to run the program.

Here are the main options:
	-make allADA
	-make allCShell
	-make allPHP
	-make allPerl

There is also a make all command that will run all
of the command listed above if you would like to run 
them all at once.

	-make all

There is also a clean command that will clean the file 
once you are done with it.
	
	-make clean

There is also specific clean command if you only need 
to clean only one of the program. Note that PHP and
Perl don't create any new files but runs stright from
the terminal.
 
	-make cleanADA
	-make cleanCShell

There are more make commands found in the make file but 
you won't really need it if you just planning to run the 
program :)

