with open('steam-200k.csv','r') as f:
	other = open('steam-200k_final.csv','w')
	for line in f:
		d = line.split('\n')[0].split('\r')[0]
		if 'purchase' in d:
			continue
		other.write(d + "\n")