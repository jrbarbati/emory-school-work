################################################################################
# Builds 2 arrays
# 	builds data array (2D)
# 	build genres array (1D)
################################################################################
def get_data(filename):
	data = []
	genres = None
	i = 0
	with open(filename,'r') as f:
		for line in f:
			if i == 0:
				d = line.split('\n')[0].split('\r')[0].split(',')
				genres = d
			else:
				d = line.split('\n')[0].split('\r')[0].split(',')
				data.append(d)
			i += 1
	return (data, genres)

################################################################################
# Builds dict of the following format:
# {'game_name':
#              {'totalHours':float, 
#               'freq':int, 
#               'genres':[list, of, genres]}
# }
################################################################################
def build_dict(data, genres):
	d = {}
	for row in data:
		if row[0] not in d:
			d[row[0]] = {}
			d[row[0]]["totalHours"] = float(row[1])
			d[row[0]]["freq"] = 1
			d[row[0]]["genres"] = []
			for i in range(2, len(row)):
				if "T" in row[i]:
					d[row[0]]["genres"].append(genres[i])
		else:
			d[row[0]]["totalHours"] +=  float(row[1])
			d[row[0]]["freq"] += 1
	return d

def main():
	data, genres = get_data('/Users/josephbarbati/Documents/codefiles/Emory/CS378/Final_Project/data/vg_dataTrimmed.csv')
	d = build_dict(data, genres)
	return d

main()