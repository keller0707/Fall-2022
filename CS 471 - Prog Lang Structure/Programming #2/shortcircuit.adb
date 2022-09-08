-- Name          : Keller Sedillo-Garrido
-- Date          : 09/07/22
-- Input         : N/A
-- Output        : Returns a false and no
-- 		   evaluation.
-- PreCondition  : No preconditions required 
-- 		   by the client
-- PostCondition : This Program will always 
-- 		   print out a false.

-- Call Libaries--
with Text_IO; use Text_IO;
with evaluated; -- Function call located in evaluated.adb

procedure shortCircuit is
	-- Create integer
	i: Integer;
begin
	--Set i to 1
	i := 1;

	--Check values
	if i = 0 and evaluated(0) then
		Put_Line("True");
	else
		Put_Line("False");
	end if; -- End ifElse
end shortCircuit;--End shortCircuit
