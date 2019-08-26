python main.py TestDataA2.dat 2000 RESULTS_2K.txt > TIMING_RESULTS.txt
echo "\n" >> TIMING_RESULTS.txt
python main.py TestDataA2.dat 1000 RESULTS_1K.txt >> TIMING_RESULTS.txt
echo "\n" >> TIMING_RESULTS.txt
python main.py TestDataA2.dat 500 RESULTS_500.txt >> TIMING_RESULTS.txt
echo "\n" >> TIMING_RESULTS.txt
python main.py TestDataA2.dat 200 RESULTS_200.txt >> TIMING_RESULTS.txt
echo "\n" >> TIMING_RESULTS.txt
python main.py TestDataA2.dat 100 RESULTS_100.txt >> TIMING_RESULTS.txt
