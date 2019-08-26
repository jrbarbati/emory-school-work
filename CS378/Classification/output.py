################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

class Output():
	def __init__(self, file):
		self.file_name = file
		self.f = open(self.file_name, 'w')

	def write_file(self, method, test_data, results, acc):
		self.f.write("\t" + method + "\n")
		for i in range(len(test_data)):
			self.f.write("Class: " + str(test_data[i][0]))
			self.f.write("\tGuess: " + results[i]+"\n")
		self.f.write("Accuracy: " + acc + "\n\n")
		return self.f
