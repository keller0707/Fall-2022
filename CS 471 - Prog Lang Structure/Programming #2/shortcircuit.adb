--
-- Name          : Keller Sedillo-Garrido
-- Date          : 09/07/22
-- Input         : N/A
-- Output        : Returns a false and no
-- 		         : evaluation.
-- PreCondition  : No preconditions required 
-- 		         : by the client
-- PostCondition : This Program will always 
-- 		         : print out a false.

-- Call Libaries--
with Text_IO; use Text_IO;
with evaluated; -- Function call located in evaluated.adb

procedure shortCircuit is
	-- Create integer
	i: Integer;
begin
	--Set i to 1
	i := 1;

	Put_Line("-=-=-=-=-= No Shortcut =-=-=-=-=-");

	-- Check Evaluation
	if i = 0 and evaluated(0) then - Check Values
		Put_Line("True");		   - Print True 
	else                           - Else
		Put_Line("False");         - Print False
	end if; -- End ifElse          - End if

	Put_Line("-=-=-=-=-= Shortcut =-=-=-=-=-");

	-- Check Evaluation
	if i = 0 and then evaluated(0) then - Check Values
		Put_Line("True");		        - Print True 
	else                                - Else
		Put_Line("False");              - Print False
	end if; -- End ifElse               - End if
end shortCircuit;--End shortCircuit
