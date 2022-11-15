for i in {1..5}
do
   java concurrency 2 >> out.txt
done
for i in {1..5}
do
   java concurrency 4 >> out.txt
done
for i in {1..5}
do
   java concurrency 8 >> out.txt
done
for i in {1..5}
do
   java concurrency 16 >> out.txt
done