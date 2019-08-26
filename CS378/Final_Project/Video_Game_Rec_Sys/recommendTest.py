from recommend import Recommend
from pprint import pprint

final = open("test_final.csv",'r')


games = []
final_dict = []
dct = {}
user_id = -1
i = 0
for line in final:
	d = line.split('\n')[0].split(',')
	if user_id != d[0] and user_id != -1:
		user_id = d[0]
		final_dict.append(dct)
		dct = {d[1]:d[4]}
		games.append([])
		i += 1
		if d[4] == "1":
			games[i].append(d[1])
	else:
		if len(games) < i + 1:
			games.append([])
		user_id = d[0]
		dct[d[1]] = d[4]
		if d[4] == "1":
			games[i].append(d[1])

# Correctly recommended games / all recommended games
avg_prec = 0.0
# Correctly recommended games / all games that should have been recommended
avg_recall = 0.0
j = 0
for i in range(len(games) - 1):
	if len(games[i]) < 2: continue
	r = Recommend("Frequent_Itemsets.txt")
	r.set_user_games(games[i])	
	recommended = r.recommend()
	# Caluclate Precision and recall.
	all_rec = len(recommended)
	should_rec = 0
	correct = 0
	for key in final_dict[i]:
		game = key.split('"')[1]
		if final_dict[i][key] == "0":
			should_rec += 1
			if game in recommended:
				correct += 1
	if should_rec == 0 or all_rec == 0:
		continue
	prec = float(float(correct) / float(all_rec))
	recall = float(float(correct) / float(should_rec))
	avg_prec += prec
	avg_recall += recall
	print "Precision: ", prec
	print "Recall: ", recall
	j += 1

print "Average Precision: ", (avg_prec / float(j))
print "Average Recall: ", (avg_recall / float(j))
