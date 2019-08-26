################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

class Data():
	def __init__(self, data_file):
		self.data_file = data_file
		self.data = []
		self.total_transactions = 0

	############################################################################
	# Gets data from the file and puts it into a 2D array
	############################################################################
	def get_data(self):
		with open(self.data_file, 'r') as f:
			i = 0
			for line in f:
				self.data.append([])
				values = line.split('\n')[0]

				values = values.split('\t')

				for value in values:
					if len(value) > 0:
						self.data[i].append(value)
				################################################################
				# Remove this when testing is done
				# if i == 99:
				# 	break
				################################################################
				i += 1
			f.close()
		return self.data

	############################################################################
	# Returns dictionary of the number of times an attribute occurs in a certain
	# class.
	############################################################################
	def get_data_numbers(self):
		# {col_num:{'attr':{'count':n, 'c1':m, 'c2':p, ...'cN':q}}}

		if len(self.data) == 0:
			self.data = self.get_data()

		# Initialize col_num keys
		summary = {}
		for i in range(1, len(self.data[0])):
			summary[i] = {}

		for row in self.data:
			for i in range(1, len(row)):
				if row[i] not in summary[i]:
					summary[i][row[i]] = {}
				if row[0] in summary[i][row[i]]:
					summary[i][row[i]][row[0]] += 1
				else:
					summary[i][row[i]][row[0]] = 1
		return summary