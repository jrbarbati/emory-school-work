################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

import math
import pprint

class Node():
	############################################################################
	# value -> the value of the Node (possible entry into an attribute at the 
	# 		   parent's col_num)
	# col_num -> column number this node looks at
	# results -> dict holding number for each class (None if not leaf node)
	# t_child -> Child of node where the row will go if row[col_num] == value
	# f_child -> Child of node where the row will go if row[col_num] != value
	############################################################################
	def __init__(self, value, col_num, results, t_child, f_child):
		self.value = value
		self.col_num = col_num
		self.results = results
		self.t_child = t_child
		self.f_child = f_child

	############################################################################
	# Majority votes -> returns the class with the most number in results
	############################################################################
	def get_class_guess(self):
		best_guess = None
		most = -1
		for key in results:
			if results[key] > most:
				best_guess = key
				most = results[key]
		return best_guess


class C45():
	############################################################################
	# data -> 2D list of data
	############################################################################
	def __init__(self, d):
		self.data = d

	############################################################################
	# Gets the root of the DT
	############################################################################
	def get_decision_tree(self):
		tree = self.build_tree(self.data)
		self.print_tree(tree)
		return tree

	############################################################################\
	# Calculates entropy for a given set of data
	############################################################################
	def get_entropy(self, rows):
		results = self.get_class_nums(rows)
		total = 0.0
		for key in results:
			prob = float(results[key]) / len(rows)
			total = total - (prob * self.log2(prob))
		return total

	############################################################################
	# Calculates log2(probability)
	############################################################################
	def log2(self, prob):
		return math.log10(prob) / math.log10(2)

	############################################################################	
	# Divides a set on a specific column and value
	#	Creates 2 sets, one is a set of rows with that value, the other doesn't
	# 	have that value
	############################################################################
	def divide_set(self, rows, col_num, val):
		sets = {'t':[], 'f':[]}
		for row in rows:
			if row[col_num] != val:
				sets['f'].append(row) # False set
			else:
				sets['t'].append(row) # True set
		return sets

	############################################################################
	# Recursively Builds Tree	
	# rows is the set, either whole dataset or part of it in the recursive call	
	############################################################################
	def build_tree(self, rows): 
		if len(rows) == 0:
			return Node(None, None, None, None)

		info_D = self.get_entropy(rows)

		best_gain_ratio = 0
		best_col_key = None
		best_sets = None

		for col in range(0, len(rows[0]) - 1):
			cols = {}
			for row in rows:
				cols[row[col]] = True
			for key in cols:
				################################################################
				# Calculate the gain_ratio
				sets = self.divide_set(rows, col, key)
				info_A = 0.0
				split_info = 0.0
				for s in sets:
					prob = float(len(sets[s])) / len(rows)
					if prob == 0:
						continue
					info_A += (prob * self.get_entropy(sets[s]))
					split_info = split_info - (prob * self.log2(prob))
				gain = info_D - info_A
				if split_info == 0:
					gain_ratio = 0
				else:
					gain_ratio = gain / split_info
				################################################################
				################################################################
				# Finds min_len of the sets and makes sure that it is > 0
				# then redefines the best_gain_ratio and all other criteria
				min_len = min([len(sets[s]) for s in sets])
				if gain_ratio > best_gain_ratio and min_len > 0:
					best_gain_ratio = gain_ratio
					best_col_key = (col, key)
					best_sets = sets
				################################################################
				print "Col: " + str(col) + "\t" + "Key: " + str(key)
				pprint.pprint(sets)
				print "Info_D: " + str(info_D)
				print "Info_A: " + str(info_A)
				print "Gain: " + str(gain)
				print "Split Info: " + str(split_info)
				print "Gain Ratio: " + str(gain_ratio)
		########################################################################
		# Recursively builds tree
		if best_gain_ratio > 0:
			print "Recursing"
			t = self.build_tree(best_sets['t'])
			f = self.build_tree(best_sets['f'])
			return Node(best_col_key[1], best_col_key[0], None, t, f)
		else:
			return Node('', -1, self.get_class_nums(rows), None, None)
		########################################################################

	############################################################################
	# Classifies row based on decision tree
	############################################################################
	def get_class(self, row, node):
		if node.results == None:
			dec = row[node.col_num] # gets the decision
			if dec == node.value: 
				# if the decision is equal to node's value, go down the 'true'
				# path
				return self.get_class(row, node.t_child)
			else:
				# if the decision is not equal to the node's value
				# go down the 'false' path
				return self.get_class(row, node.f_child)
		else:
			# If a result dictionary exists, get the best_guess (majority rules)
			best_guess = None
			max_num = -1
			for key in node.results:
				if node.results[key] > max_num:
					best_guess = key
					max_num = node.results[key]
			return best_guess

	############################################################################
	# Gets the division of classes among the rows
	# returns a dictionary: keys -> class; value -> frequency
	############################################################################		
	def get_class_nums(self, rows):
		res = {}
		for row in rows:
			l = len(row) - 1
			if row[l] in res:
				res[row[l]] += 1
			else: 
				res[row[l]] = 1
		return res

	def print_tree(self, tree ,indent=''):
		# Is this a leaf node?
		if tree.results != None:
			print str(tree.results)
			return
		else:
			print str(tree.col_num)+':'+str(tree.value)+'? '
		# Print the branches
		print indent+'T-> ',
		self.print_tree(tree.t_child,indent+'  ')
		print indent+'F-> ',
		self.print_tree(tree.f_child,indent+'  ')