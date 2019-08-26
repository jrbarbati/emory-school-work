################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

from c45 import C45
from bayesian import Bayesian
from output import Output
from data import Data
import time, sys

def main():
	args = sys.argv[1:] # CLA

	if len(args) != 3:
		print "Usage: python main.py <training data> <test data> <output file>"
		sys.exit()

	print "Getting Training Data..."
	start = time.time()
	# Get training data
	train = Data(args[0])
	train_set = train.get_data()
	train_set_info = train.get_data_numbers()
	end = time.time()
	print "Done - Took %.3f seconds." % (end - start)

	print "Setting up C4.5 Classifier..."
	start = time.time()
	# Initializing C45 class with training set info
	c45 = C45(train_set)
	dt = c45.get_decision_tree()
	end = time.time()
	print "Done - Took %.3f seconds." % (end - start)

	print "Setting up Bayesian Classifier..."
	start = time.time()
	# Giving Bayesian Classifiers class training set info
	bayes = Bayesian(train_set_info, train_set)
	end = time.time()
	print "Done - Took %.3f seconds." % (end - start)

	print "Getting Testing Data..."
	start = time.time()
	# Get testing data
	test = Data(args[1])
	test_set = test.get_data()
	end = time.time()
	print "Done - Took %.3f seconds." % (end - start)

	print "Classifying Data (C45)..."
	start = time.time()
	c45_results = []
	num_correct = 0
	for row in test_set:
		class_guess = c45.get_class(row, dt)
		if class_guess == row[0]:
			num_correct += 1
		c45_results.append(class_guess)
	c45_acc = float(num_correct) / float(len(test_set))
	end = time.time()
	print "Done - Took %.3f seconds." % (end - start)

	print "Classifying Data (Bayesian)..."
	start = time.time()
	results = []
	num_correct = 0
	for row in test_set:
		class_guess = bayes.get_class(row)
		if class_guess == row[0]:
			num_correct += 1
		results.append(class_guess)
	acc = float(num_correct) / float(len(test_set))
	end = time.time()
	print "Done - Took %.3f seconds." % (end - start)

	print "Writing Results to " + args[2] + "..."
	start = time.time()
	# Write answer to output file.
	output = Output(args[2])
	f = output.write_file("Bayesian", test_set, results, str(acc * 100) + "%")
	f = output.write_file("  C4.5", test_set, c45_results, str(c45_acc * 100) + "%")
	f.close()
	end = time.time()
	print "Done - Took %.3f seconds." % (end - start)

main()