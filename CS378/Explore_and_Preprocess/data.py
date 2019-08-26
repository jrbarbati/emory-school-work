import sys

args = sys.argv[1:]

if len(args) != 2:
	print "Usage: python data.py dataFilename.ext <column to remove>"
	sys.exit()

with open(args[0],'r') as f:
	data = open('poker-hand-data.csv','w')
	for line in f:
		line = line.split('\r')[0]
		nums = line.split('\n')[0]
		if ".csv" in args[0]:
			nums = line.split(',')
		else:
			nums = line.split(' ')
		nums.pop(int(args[1]))
		for i in range(len(nums)):
			if i < len(nums) - 1:
				data.write(str(nums[i]) + ',')
			else:
				data.write(str(nums[i]) + '\n')
	f.close()