################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

import sys

class Data():
	def __init__(self, data_file):
		self.data_file = data_file
		self.data = []

	############################################################################
	# Gets data from the file and puts it into a 2D array
	############################################################################
	def get_data(self):
		with open(self.data_file, 'r') as f:
			ext = self.detect_extension()

			if len(ext) > 3:
				print "Error: " + ext
				sys.exit()

			i = 0
			for line in f:
				self.data.append([])
				nums = line.split('\n')[0]

				if ext is 'csv':
					nums = nums.split(',')
				else:
					nums = nums.split('\t')

				for num in nums:
					if len(num) > 0:
						self.data[i].append(int(num))
				################################################################
				# Remove this when testing is done
				# if i == 99:
				# 	break
				################################################################
				i += 1
			f.close()
		return self.data

	############################################################################
	# Get's the extension of the file
	############################################################################
	def detect_extension(self):
		if '.csv' in self.data_file:
			return 'csv'
		elif '.txt' in self.data_file:
			return 'txt'
		elif '.dat' in self.data_file:
			return 'dat'
		else:
			return 'File type not supported'
