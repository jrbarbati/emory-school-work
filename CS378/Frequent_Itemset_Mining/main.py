################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

from data import Data
from apriori import Apriori
from output import Output
import sys
import time

def main():
	# Get the command line args
	args = sys.argv[1:]
	
	# Check to make sure correct number of args were added
	if len(args) != 3:
		print "Usage: python main.py <inputFile.ext> <min_support(int)> <outputFile.ext>"
		sys.exit()
	
	# Initialize Data class with the input file
	data_class = Data(args[0])
	
	# Get the data as 2D array
	print "Getting Data from file..."
	start = time.time()
	data_array = data_class.get_data()
	end = time.time()
	print "Done - Took %1.1f seconds" % (end - start)

	min_support = int(args[1])

	a = Apriori(min_support)

	print "Performing Apriori Algorithm..."
	start = time.time()
	results = a.apriori(data_array)
	end = time.time()
	print "Done - Took %1.1f seconds" % (end - start)

	print "Writing to " + args[2] + "..."
	start = time.time()
	Output(results, args[2])
	end = time.time()
	print "Done - Took %1.1f seconds" % (end - start)

start_main = time.time()
main()
end_main = time.time()
print "*** Total time: %1.1f seconds ***" % (end_main - start_main)