for i in {1..5}
do
   time ./gaussian 250
done
echo -n "-=-=-=-=-= 250 =-=-=-=-=-"
for i in {1..5}
do
   time ./gaussian 500
done
echo -n "-=-=-=-=-= 500 =-=-=-=-=-"
for i in {1..5}
do
   time ./gaussian 1000
done
echo -n "-=-=-=-=-= 1000 =-=-=-=-=-"
for i in {1..5}
do
   time ./gaussian 1500
done
echo -n "-=-=-=-=-= 1500 =-=-=-=-=-"
for i in {1..5}
do
   time ./gaussian 2000
done
echo -n "-=-=-=-=-= 2000 =-=-=-=-=-"
echo -n