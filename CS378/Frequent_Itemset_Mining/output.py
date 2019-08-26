################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

class Output():
	def __init__(self, results, output_file):
		with open(output_file, 'w') as f:
			self.write_results(results, f)
			f.close()

	############################################################################
	# Writes the results of Apriori to output file
	############################################################################
	def write_results(self, results, file):
		# from pprint import pprint
		cumulative = {}
		for key in results:
			for itemset in results[key]:
				cumulative[itemset] = results[key][itemset]
		keys = self.sort_first_index(cumulative.keys())
		# pprint(keys)
		for key in keys:
			line = self.tuple_to_string(key)
			line += "(" + str(cumulative[key]) + ")" + "\n"
			file.write(line)

	############################################################################
	# Converts given tuple to a string of space-separated values
	############################################################################
	def tuple_to_string(self, itemset):
		line = ""
		for num in itemset:
			line += str(num) + " "
		return line
	############################################################################
	# Sorts keys based on first index
	############################################################################
	def sort_first_index(self, keys):
		return sorted(keys, key=lambda x: x[0])