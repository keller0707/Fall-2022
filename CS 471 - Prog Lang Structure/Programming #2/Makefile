#Run all commands
all: allCShell allADA runPHP runPerl

#
#C Shell
#

#Run all C Shell Commands
allCShell: makeCShell runCShell

#Making C Shell
makeCShell: shortcircuit.csh
	chmod +x shortcircuit.csh
	
#Running C Shell
runCShell: shortcircuit.csh
	./shortcircuit.csh

############################################################

#
#ADA
#

#Run all ADA Commands
allADA: makeADA runADA

#Making ADA
makeADA: shortcircuit.adb gnatADA
	gcc -c shortcircuit.adb

gnatADA: shortcircuit.adb
	gnatmake --GNATBIND=gnatbind --GNATLINK=gnatlink shortcircuit.adb

#Running ADA
runADA: 
	./shortcircuit

#############################################################

#
#PHP
#

#Running PHP
runPHP: shortcircuit.php
	php shortcircuit.php

#############################################################

#
#Perl
#

#Running Perl
runPerl: shortcircuit.pl
	perl shortcircuit.pl

#############################################################

#
#Clean
#

#Clean all
clean: cleanCShell cleanADA

#Clean C Shell
cleanCShell: shortcircuit.csh
	chmod -x shortcircuit.csh

#Clean ADA
cleanADA:
	rm shortcircuit
	rm -v *.ali
	rm -v *.o
