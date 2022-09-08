## Name          : Keller Sedillo-Garrido
## Date          : 09/07/22
## Input         : N/A
## Output        : Returns False and 
##		   evaluation is called.
## PreCondition  : No input from user 
##                 required.
## PostCondition : Will return either false
##		   or true.

evaluated(){
echo I have been evaluated ## Print eval
echo 1			   ## Return 1
}

#Set i
i=1

#Check values 
if [ $i = 0 ] && evaluated ; then
	echo True
else
	echo False
fi
