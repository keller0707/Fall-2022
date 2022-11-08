# using a for loop

for i in {1..5}
do
   time python gaussianNP.py 250
done
echo -n "-=-=-=-=-= 250 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussianNP.py 500
done
echo -n "-=-=-=-=-= 500 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussianNP.py 1000
done
echo -n "-=-=-=-=-= 1000 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussianNP.py 1500
done
echo -n "-=-=-=-=-= 1500 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussianNP.py 2000
done
echo -n "-=-=-=-=-= 2000 =-=-=-=-=-"
echo -n
