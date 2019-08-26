################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

import random, math, time
from pprint import pprint

class K_Means():
	def __init__(self, data, class_col, k):
		self.data = data
		self.class_col = class_col - 1
		self.k = k
		self.trans_length = len(data[0])
		self.current_clusters = {}
		self.old_clusters = {}
		self.old_centroids = []
		self.centroids = self.get_random_centroids()
		for i in range(len(self.centroids)):
			self.current_clusters[i] = [] # Key is index of centroid in
										  # centnroids list
		self.cluster_data()
		while not self.update_centroids():
			self.cluster_data()

	############################################################################
	# returns a tuple
	# 	Clusters
	#	Centroids
	############################################################################
	def get_clusters(self):
		return (self.old_clusters, self.centroids)

	############################################################################
	# Clusters data by minimum euclidean distance to the centroids
	############################################################################
	def cluster_data(self):
		start = time.time()
		for item in self.data:
			minimum = float('inf')
			min_key = None
			for key in self.current_clusters:
				dist = self.euclidean_distance(item, self.centroids[key])
				if dist < minimum:
					minimum = dist
					min_key = key
			self.current_clusters[min_key].append(item)
		end = time.time()
		print "1 Clustering Iteration took %.2f" % (end - start)


	############################################################################
	# Finds the averages of each of the clusters
	############################################################################
	def get_averages(self):
		avgs = []
		for key in self.current_clusters:
			avgs.append([0 for i in range(len(self.data[0]))])
			count = 0
			for item in self.current_clusters[key]:
				for i in range(len(item)):
					if i == self.class_col:
						continue
					avgs[key][i] += float(item[i])
				count += 1
			if count != 0:
				for i in range(len(avgs[key])):
					avgs[key][i] /= float(count)
		return avgs

	############################################################################
	# Updates the centroids with the averages
	############################################################################
	def update_centroids(self):
		self.old_centroids = self.centroids
		self.centroids = self.get_averages()
		self.old_clusters = self.current_clusters
		self.current_clusters = {}
		for key in self.old_clusters:
			# If multiple avgs == [0, 0, ..., 0], it will override and cause
			# smaller number of clusters in next iteration...
			self.current_clusters[key] = []
		for item in self.centroids:
			if sum(item) == 0:
				# A cluster has no items
				# restart from random centroids
				# return False to keep clustering
				print "Restarting"
				self.centroids = self.get_random_centroids()
				return False

		# Check distances from old to new centroids, if all of them are less
		# than 1 point away from each other, clusters aren't going to change
		# (much), so answer is good enough
		# small_dist = 0
		# for i in range(len(self.centroids)):
		#	dist = self.euclidean_distance(self.centroids[i], self.old_centroids[i])
		#	if dist > 1:
		#		break
		#	else:
		#		small_dist += 1
		# if small_dist == self.k:
		#	return True 

		count = 0
		old = self.old_centroids
		new = self.centroids
		for i in range(len(old)):
			if self.euclidean_distance(old[i], new[i]) == 0:
				count += 1
		return count == self.k

	############################################################################
	# Takes mins and maxes of each dimension and finds k random centroid between
	# [0, max]
	############################################################################
	def get_random_centroids(self):
		length = len(self.data)
		randoms = []
		for j in range(self.k):
			r = int(random.random() * length)
			randoms.append(self.data[r])
		return randoms

	############################################################################
	# Finds euclidean distance between two points
	############################################################################
	def euclidean_distance(self, p1, p2):
		total = 0.0
		for i in range(len(p1)):
			if i == self.class_col:
				continue
			diff = (float(p1[i]) - float(p2[i]))
			total += math.pow(diff, 2)
		return math.sqrt(total)
