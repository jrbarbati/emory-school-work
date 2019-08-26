import sys
import time
import math

def sort(alist):
    if len(alist) > 1:
        mid = len(alist)//2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        sort(lefthalf)
        sort(righthalf)

        i=0
        j=0
        k=0
        while i < len(lefthalf) and j < len(righthalf):
            if lefthalf[i] < righthalf[j]:
                alist[k]=lefthalf[i]
                i=i+1
            else:
                alist[k]=righthalf[j]
                j=j+1
            k=k+1

        while i < len(lefthalf):
            alist[k]=lefthalf[i]
            i=i+1
            k=k+1

        while j < len(righthalf):
            alist[k]=righthalf[j]
            j=j+1
            k=k+1

def mean(nums):
	return float(sum(nums)) / float(len(nums))

def variance(nums):
    avg = float(mean(nums))
    total = 0.0
    for num in nums:
        total += ((float(num) - avg) ** 2)
    return (1.0 / float((len(nums) - 1))) * total

def standardDeviation(nums):
    var = variance(nums)
    return math.sqrt(var)

def nullBin(nums, freq):
	return nums

def equalFreqBin(nums, freq):
	numOfBins = len(nums) / freq
	print "Numbers per bin: " + str(numOfBins)
	bins = []
	for i in range(numOfBins):
		bins.append([])
	j = 0
	for i in range(len(nums)):
		if i != 0 and i % freq == 0:
			j += 1
		bins[j].append(nums[i])

	for arr in bins:
		print "From: " + str(arr[0]) + " to: " + str(arr[freq - 1])
	return bins

def equalWidthBin(nums, width):
	bins = []
	bins.append([])
	widths = []
	i = 1
	while (width * i) <= (len(nums) + width - 1):
		widths.append(width * i)
		i += 1
	i = 0
	for j in range(len(nums)):
		if  nums[j] < widths[i]:
			bins[i].append(nums[j])
		else:
			i += 1
			bins.append([])
			bins[i].append(nums[j])
	for arr in bins:
		print "From: " + str(arr[0]) + " to: " + str(arr[len(arr) - 1]) + " Size: " + str(len(arr))
	return bins

def dataSmoothing(nums, f, b=nullBin):
	means = []
	bins = b(nums, f)
	for arr in bins:
		means.append(mean(arr))
	return means

def minMaxNormalization(nums):
	minNum = min(nums)
	maxNum = max(nums)
	normal = []
	for num in nums:
		normal.append(float(num - minNum) / float(maxNum - minNum))
	for num in normal:
		print str(num) + "\t",
	print ""

def zScoreNormalization(nums):
	avg = mean(nums)
	stdDev = standardDeviation(nums)
	normal = []
	for num in nums:
		normal.append(float(num - avg) / float(stdDev))
	for num in normal:
		print str(num) + "\t",
	print ""

args = sys.argv[1:]

if len(args) != 1:
    print "Usage: python preprocess.py dataFilename.ext"
    sys.exit()

classes = []
with open(args[0],'r') as f:
	i = 0
	for line in f:
		if i == 100:
			break
		line = line.split('\r')[0]
		nums = line.split('\n')[0]
		if ".csv" in args[0]:
		    nums = line.split(',')
		else:
		    nums = line.split(' ')
		classes.append(float(nums[1]))
		i += 1
	f.close()

print("Sorting array...")
start = time.time()
sort(classes)
end = time.time()
print("Done. --- %1.1fs" % (end - start))

print str(dataSmoothing(classes, 10, equalFreqBin))
print str(dataSmoothing(classes, 3, equalWidthBin))
minMaxNormalization(classes)
print "" 
print ""
zScoreNormalization(classes)