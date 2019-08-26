################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

import math

class Quality_Metrics():
	def __init__(self, centroids, clusters, class_col):
		self.centroids = centroids
		self.clusters = clusters
		self.class_col = class_col - 1

	############################################################################
	# Measures within SSE and between SSE (Cohesion and Separation)
	############################################################################
	def sum_squared_error(self):
		within = 0.0
		for i in range(len(self.centroids)):
			for item in self.clusters[i]:
				within += math.pow(self.e_distance(item, self.centroids[i]), 2)

		between = 0.0
		for key in self.clusters:
			for k in self.clusters:
				if k == key:
					continue
				for p1 in self.clusters[key]:
					for p2 in self.clusters[k]:
						between += math.pow(self.e_distance(p1, p2), 2)

		return (within, between)

	############################################################################
	# Measures BCubed Precision and Recall and returns the average of the 
	# precision and recall
	############################################################################
	def b_cubed(self):
		stats = self.get_cluster_stats()
		total = self.find_total(stats)
		precision = self.find_precision(stats)
		precision /= float(total)
		recall = self.find_recall(stats)
		recall /= float(total)
		return (precision, recall)

	############################################################################
	# Calculates precision
	############################################################################
	def find_precision(self, stats):
		precision = 0.0
		for key in self.clusters:
			for item in self.clusters[key]:
				class_key = item[self.class_col]
				class_num = float(stats[key][class_key])
				denominator = float(sum([stats[key][c] for c in stats[key]]))
				precision += float(class_num / denominator)
		return precision

	############################################################################
	# Calculates recall
	############################################################################
	def find_recall(self, stats):
		recall = 0.0
		for key in self.clusters:
			for item in self.clusters[key]:
				class_key = item[self.class_col]
				class_num = float(stats[key][class_key])
				denominator = 0.0
				for k in stats:
					if class_key in stats[k]:
						denominator += float(stats[k][class_key])
					else:
						denominator += 0.0
				recall += float(class_num / denominator)
		return recall

	############################################################################
	# Calculates totals of the classes
	############################################################################
	def find_total(self, stats):
		total = 0
		for key in stats:
			for k in stats[key]:
				total += stats[key][k]
		return total

	############################################################################
	# Finds euclidean distance between two points
	############################################################################
	def e_distance(self, p1, p2):
		total = 0.0
		for i in range(len(p1)):
			if i == self.class_col:
				continue
			diff = (float(p1[i]) - float(p2[i]))
			total += math.pow(diff, 2)
		return math.sqrt(total)

	############################################################################
	# Gets the statistics on classes within and between clusters
	# Used in calculating precison and recall
	############################################################################
	def get_cluster_stats(self):
		stats = {}
		for key in self.clusters:
			stats[key] = {}
			for item in self.clusters[key]:
				if item[self.class_col] in stats[key]:
					stats[key][item[self.class_col]] += 1
				else:
					stats[key][item[self.class_col]] = 1
		return stats


################################################################################
# Returns True if the quality of the clusters is good, based on quality 
# metrics (within and between SSE, b_cubed)
################################################################################
def is_good(centroids, clusters, class_col):
	qm = Quality_Metrics(centroids, clusters, class_col)
	cohesion, separation = qm.sum_squared_error()
	precision, recall = qm.b_cubed()
	return (cohesion, separation, precision, recall)