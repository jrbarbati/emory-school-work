Execution:
	To run an individual program with your own input args:

	python main.py <dataset> <minimum support> <outputfile>
	
	If you would like an automated execution of 5 different minimum
	supports, read on.
	
	Example: python main.py TestDataA2.dat 500 RESULTS_500.txt

Suppored Dataset files:
*.csv
*.txt
*.dat

I am including a shell script that will run the program on TestDataA2.dat for
minimum supports 100, 200, 500, 1000, 2000.
This program outputs the results to RESULTS_<minimum support>.txt.
This program also writes timing information for each execution into TIMING_RESULTS.txt.

shell script: run.sh
execution of shell script:
	If it has executable permissions: ./run.sh
	If not: sh run.sh
