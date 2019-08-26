import time
import os
import sys

args = sys.argv[1:]

if len(args) != 1:
	print "Usage: python timing.py <integer [1, 32000000]>"
	sys.exit(0)

st = time.time()
os.system("./main.exe " + args[0])
end = time.time()

print "Took %4.2f seconds" % (end - st)
