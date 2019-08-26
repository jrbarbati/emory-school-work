################################################################################
#                                   Honor Code
# THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
# WRITTEN BY OTHER STUDENTS - Joseph Barbati
################################################################################

import sys, time, k_means, quality_metrics

################################################################################
# Gets the percentage of dataset that is in each cluster
################################################################################
def find_percentages(clusters):
	p = {}
	total = sum([len(clusters[key]) for key in clusters])
	for key in clusters:
		p[key] = float(len(clusters[key])) / float(total)
	return p

################################################################################
# Reads data from the file into a 2D list
################################################################################
def get_data(file):
	data = []
	delim = ','

	with open(file, 'r') as f:
		for line in f:
			d = line.split('\n')[0]
			d = d.split('\r')[0]
			d = d.split(delim)
			try:
				test = float(d[0])
			except ValueError as e:
				continue
			for i in range(len(d)):
				if '$' in d[i]:
					d[i] = d[i][1:]
				elif '' == d[i]:
					d[i] = '0'
			if '/' in d[2]:
				d.pop(2)
			data.append(d)
	return data

################################################################################
# Outputs answer to the designated output file
################################################################################
def output(file, centroids, clusters, cohesion, separation, precision, recall):
	p = find_percentages(clusters)
	with open(file, 'w') as f:
		f.write("Final Clusters\n")
		f.write("=====================\n")
		for i in range(len(centroids)):
			f.write(str(i) + ":\t")
			clus = ""
			for j in range(len(centroids[i])):
				clus += str(centroids[i][j]) + "  "
			clus += "\n"
			f.write(clus)
		f.write("\n\n")
		f.write("Cluster Breakdown\n")
		f.write("=======================\n")
		for key in p:
			f.write("Cluster " + str(key) + ":\t")
			f.write("%.2f" % (p[key] * 100))
			f.write("%\n")
		f.write("\n\n")
		f.write("Cohesion: " + str(cohesion) + "\n")
		f.write("Separation: " + str(separation) + "\n")
		f.write("Precision: " + str(precision) + "\n")
		f.write("Recall: " + str(recall) + "\n")



def main():
	args = sys.argv[1:]

	if len(args) != 4:
		print "Usage: python main.py <data file> <k> <output filename> <class column number>"
		sys.exit()

	try:
		k = int(args[1])
	except:
		print "Error: k (2nd arg) must be an integer"
		print "Usage: python main.py <data file> <k> <output filename> <class column number>"
		sys.exit()

	try:
		class_col = int(args[3])
	except:
		print "Error: class column number (4th arg) must be an integer"
		print "Usage: python main.py <data file> <k> <output filename> <class column number>"
		sys.exit()

	print "Retreiving Data from " + args[0] + "..."
	start = time.time()
	dataset = get_data(args[0])
	end = time.time()
	print "Done. Took %.2f seconds" % (end - start)

	print "Clustering Data..."
	start = time.time()
	k_m = k_means.K_Means(dataset, class_col, k)
	k_clusters, k_centroids = k_m.get_clusters()
	cohesion, separation, precision, recall = quality_metrics.is_good(k_centroids, k_clusters, class_col)
	end = time.time()
	print "Done. Took %.2f seconds" % (end - start)

	print "Writing output to " + args[2] + "..."
	start = time.time()
	output(args[2], k_centroids, k_clusters, cohesion, separation, precision, recall)
	end = time.time()
	print "Done. Took %.2f seconds." % (end - start)

main()