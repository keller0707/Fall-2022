# using a for loop
for i in {1..5}
do
   time python gaussian.py 250
done
echo -n "-=-=-=-=-= 250 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussian.py 500
done
echo -n "-=-=-=-=-= 500 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussian.py 1000
done
echo -n "-=-=-=-=-= 1000 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussian.py 1500
done
echo -n "-=-=-=-=-= 1500 =-=-=-=-=-"
for i in {1..5}
do
   time python gaussian.py 2000
done
echo -n "-=-=-=-=-= 2000 =-=-=-=-=-"
