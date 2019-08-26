f = open("../data/steam-200k_final.csv","r")

write_to = open("../data/vg_data_FIM.csv","w")

user_id = -1
string = ""
i = 0
for line in f:
	if i == 0:
		i += 1
		continue
	d = line.split('\n')[0].split(',')
	print "Curr User_ID: " + str(user_id)
	print "Curr Line's User_ID: " + d[0]
	if user_id != int(d[0]) and user_id != -1:
		print "Writing to file..."
		write_to.write(string[:-1] + "\n")
		user_id = int(d[0])
		string = d[1] + ","
	else:
		user_id = int(d[0])
		if d[1] not in string:
			string += d[1] + ","
		print "String: " + string