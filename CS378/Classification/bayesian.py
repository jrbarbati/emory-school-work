################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

class Bayesian():
	def __init__(self, data_summary, data):
		self.data_summary = data_summary
		self.data = data
		self.total = 0
		self.classes = self.get_all_classes()
		self.fill_missing()
		self.prob_C_i = self.get_class_probabilities()
		self.prob_X_given_Ci = self.get_probabilities()

	############################################################################
	# Gets all the classes from the data and returns a list of them (no repeats)
	############################################################################
	def get_all_classes(self):
		classes = []
		for row in self.data:
			if row[0] not in classes:
				classes.append(row[0])
		return classes

	############################################################################
	# Goes through all cols and attr and if a class is not represented in the
	# dict, add it with value of 1 or if it is in the dict already, add 1 to it
	# (Laplacian Correction)
	############################################################################
	def fill_missing(self):
		for col in self.data_summary:
			for attr in self.data_summary[col]:
				for item in self.classes:
					if item not in self.data_summary[col][attr]:
						# Laplacian Correction
						self.data_summary[col][attr][item] = 1
					else:
						# Laplacian Correction
						self.data_summary[col][attr][item] += 1


	############################################################################
	# Calculates C_i
	############################################################################
	def get_class_probabilities(self):
		counts = {}
		probs = {}
		for c in self.classes:
			counts[c] = 0

		for row in self.data:
			counts[row[0]] += 1
			self.total += 1
			
		for key in counts:
			probs[key] = float(counts[key]) / float(self.total)
		return probs

	############################################################################
	# Calculates all conditional probabilities
	#	Goes through all column and all attributes and calculates the
	#	conditional probabilities
	############################################################################
	def get_probabilities(self):
		cond_probs = {}
		for col in self.data_summary:
			cond_probs[col] = {}
			for attr in self.data_summary[col]:
				cond_probs[col][attr] = {}
				for k in self.data_summary[col][attr]:
					# n is |attr && C_i|/total_transactions (P(attr && C_i))
					n = float(self.data_summary[col][attr][k])/float(self.total)
					# d is P(C_i)
					d = float(self.prob_C_i[k])
					# n / d == P(attr | C_i)
					cond_probs[col][attr][k] = float(n / d)
		return cond_probs

	############################################################################
	# Gets the class
	# 	assumes class is first index in row
	# 	Finds max probability, returns class with highest probability
	############################################################################
	def get_class(self, row):
		probs = {}
		for i in range(1, len(row)):
			for k in self.prob_X_given_Ci[i][row[i]]:
				if k not in probs:
					probs[k] = self.prob_X_given_Ci[i][row[i]][k]
				else:
					probs[k] *= self.prob_X_given_Ci[i][row[i]][k]

		max_key = ""
		maxi = -1
		for key in probs:
			if probs[key] > maxi:
				maxi = probs[key]
				max_key = key
		return max_key
