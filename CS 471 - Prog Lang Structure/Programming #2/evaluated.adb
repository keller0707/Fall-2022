--Name          : Keller Sedillo-Garrido
--Date          : 09/07/22
--Input         : This Function takes an 
--		        : Integer
--Output        : Outputs a True if 1
--		        : and False if 0
--PreCondition  : The Client is not
--		        : expected to input
--		        : anything.
--PostCondition : This function will return
--		        : always return True or False
--		        : depending on the input.

-- Call Libary --
with Ada.Text_IO; use Ada.Text_IO;

-- Create Function
function evaluated (N : Integer) return Boolean is
begin
	Put_Line("I have been evaluated"); -- Print eval
	if N = 1 then                      -- Check input num
		return TRUE;                   -- Return True
	end if;	                           -- Else
    return FALSE;                      -- Return False
end evaluated;                         -- end evaluated	
