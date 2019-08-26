################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

class Apriori():
	############################################################################
	# Initializes L with None at index 0 so index corresponds to k
	############################################################################
	def __init__(self, min_sup):
		self.L = {}
		self.min_sup = min_sup

	############################################################################
	# Gets the frequent 1-itemset
	# returns 2D array of frequent itemsets
	############################################################################
	def get_freq_1_itemset(self, data):
		itemsets = {}
		freq_itemsets = {}
		# Index of itemsets acts as the item, the value acts as the frequency
		for row in data:
			for num in row:
				if num in itemsets:
					itemsets[num] += 1
				else: 
					itemsets[num] = 1

		for num in itemsets:
			# If the value at the item is greater than the minimum support
			# add the index (item) to the freq_itemsets list
			if itemsets[num] >= self.min_sup:
				freq_itemsets[tuple([num])] = itemsets[num]
		self.clean_data(freq_itemsets, data)
		return freq_itemsets

	############################################################################
	# Gets the frequent k-itemset for a given k
	# 	Traverses each row, building
	# returns 2D array of frequent itemsets
	############################################################################
	def get_freq_k_itemset(self, k, data):
		temp = {}
		for row in data:
			if len(row) < k:
				data.remove(row)
				continue
			new_keys = self.get_subsets(row, k, {})
			for new_key in new_keys:
				if new_key not in temp:
					temp[new_key] = 1
				else:
					temp[new_key] += 1

		# Cleaning up candidate k-itemsets
		# i.e. adding only frequent k-itemsets to my list of freq k-itemsets
		for key in temp:
			if temp[key] >= self.min_sup:
				self.L[k][key] = temp[key]

	############################################################################
	# Implementation of the Apriori algorithm
	############################################################################
	def apriori(self, data):
		self.L[1] = self.get_freq_1_itemset(data)
		k = 2
		while len(self.L[k - 1]) != 0:
			self.L[k] = {}
			self.get_freq_k_itemset(k, data)
			k += 1
		self.L.pop(k - 1)
		return self.L

	############################################################################
	# Removes items that are not frequent / will not contribute to future freq
	# itemsets
	############################################################################
	def clean_data(self, freq, data):
		for row in data:
			for num in row:
				if tuple([num]) not in freq:
					# if the number is not in the freq
					row.remove(num)
			if len(row) == 0:
				data.remove(row)
				
	############################################################################
	# Returns all length-n subsets of superset
	############################################################################
	def get_subsets(self, superset, n, res):
		self.get_subsets_helper(superset, n, 0, tuple(), res)
		return res

	############################################################################
	# Recursive helper to get_subsets()
	############################################################################
	def get_subsets_helper(self, superset, n, idx, curr, res):
		if len(curr) == n:
			# If len(curr) is n, we add it to res, as the for loop below
			# guarantees that curr is at least possibly frequent.
			# In other words, curr would not have made it this far if a subset
			# of curr is infrequent.
			res[curr] = True
			return

		for i in range(2, n):
			# Check for the length of curr (from 2 to n - 1)
			if len(curr) == i:
				if curr in self.L[i]:
					# Check if curr is in self.L[i]
					# If so, the superset is possibly frequent, so continue
					break
				else:
					# We know the superset of curr is not frequent, so we can
					# just return
					return

		if idx == len(superset):
			return

		old_curr = curr
		new_curr = curr + tuple([superset[idx]])
		# superset[idx] is either in the superset or out
		# in
		self.get_subsets_helper(superset, n, idx + 1, new_curr, res)
		# out
		self.get_subsets_helper(superset, n, idx + 1, old_curr, res)