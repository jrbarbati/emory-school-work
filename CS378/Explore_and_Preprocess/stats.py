import time
import math
import sys

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
    total = 0
    for num in nums:
        total += num
    return total / len(nums)

def median(nums):
    return nums[int(len(nums) / 2)]

def mode(nums):
    ones, twos, threes, fours, fives, sixes, sevens, eights = 0,0,0,0,0,0,0,0
    nines, tens, elevens, twelves, thirteens = 0,0,0,0,0
    for num in nums:
        if num == 0:
            zeros += 1
        elif num == 1:
            ones += 1
        elif num == 2:
            twos += 1
        elif num == 3:
            threes += 1
        elif num == 4:
            fours += 1
        elif num == 5:
            fives += 1
        elif num == 6:
            sixes += 1
        elif num == 7:
            sevens += 1
        elif num == 8:
            eights += 1
        elif num == 9:
            nines += 1
        elif num == 10:
            tens += 1
        elif num == 11:
            elevens += 1
        elif num == 12:
            twelves += 1
        else:
            thirteens += 1
    i = 1
    for item in [ones,twos,threes,fours,fives,sixes,sevens,eights,nines,tens,elevens,twelves,thirteens]:
        print(str(i) + "s: " +  str(item))
        i += 1

    maxNum = max(ones,twos,threes,fours,fives,sixes,sevens,eights,nines,tens,elevens,twelves,thirteens)
    if ones == maxNum:
        return 1
    elif twos == maxNum:
        return 2
    elif threes == maxNum:
        return 3
    elif fours == maxNum:
        return 4
    elif fives == maxNum:
        return 5
    elif sixes == maxNum:
        return 6
    elif sevens == maxNum:
        return 7
    elif eights == maxNum:
        return 8
    elif nines == maxNum:
        return 9
    elif tens == maxNum:
        return 10
    elif elevens == maxNum:
        return 11
    elif twelves == maxNum:
        return 12
    else:
        return 13

def rangeOf(nums):
    return max(nums) - min(nums)

def quartile25(nums):
    idx = (25.0/100.0) * len(nums)
    return nums[int(idx)]

def quartile75(nums):
    idx = (75.0/100.0) * float(len(nums))
    return nums[int(idx)]

def variance(nums):
    avg = float(mean(nums))
    total = 0.0
    for num in nums:
        total += ((float(num) - avg) ** 2)
    return (1.0 / float((len(nums) - 1))) * total

def standardDeviation(nums):
    var = variance(nums)
    return math.sqrt(var)

args = sys.argv[1:]

if len(args) != 1:
    print "Usage: python stats.py dataFilename.ext"
    sys.exit()

classes = []
with open(args[0],'r') as f:
    for line in f:
        line = line.split('\r')[0]
        nums = line.split('\n')[0]
        if ".csv" in args[0]:
            nums = line.split(',')
        else:
            nums = line.split(' ')
        classes.append(float(nums[1]))
    f.close()

print("Sorting array...")
start = time.time()
sort(classes)
end = time.time()
print("Done. --- %1.1fs" % (end - start))

print("Mean: " + str(mean(classes)))
print("Median: " + str(median(classes)))
print("Mode: " + str(mode(classes)))
print("Range: " + str(rangeOf(classes)))
print("Q1: " + str(quartile25(classes)))
print("Q3: " + str(quartile75(classes)))
print("Variance: " + str(variance(classes)))
print("Std Dev: " + str(standardDeviation(classes)))
