import random

with open('../data/steam-200k_final.csv','r') as f:
	user_id = -1
	write_to = open("test_final.csv","w")
	i = 1
	for line in f:
		d = line.split('\n')[0].split(',')
		try:
			int(d[0])
		except:
			continue
		if user_id != d[0] and user_id != -1:
			user_id = d[0]
			i = 1
		if i == 5: continue
		else:
			user_id = d[0]
			rand = random.random()
			if (rand < .33):
				string = ""
				for item in d:
					string += item + ","
				write_to.write(string[:-1] + "\n")
			else:
				d[4] = "1"
				string = ""
				for item in d:
					string += item + ","
				write_to.write(string[:-1] + "\n")
			i += 1