import sys

args = sys.argv[1:]

if len(args) != 1:
	print "Usage: python convert_to_tsv.py <name of csv file>"
	sys.exit()

final = open(args[0][:-4] + "_final.csv", "w")
with open(args[0],'r') as f:
	for line in f:
		d = line.split('\n')[0].split('\r')[0].split(',')
		i = 0
		while i < len(d):
			string = d[i]
			if string[0] == " ":
				d[i - 1] = d[i - 1] + d[i]
				d.pop(i)
				i -= 1
			i += 1
		final.write(d + '\n')