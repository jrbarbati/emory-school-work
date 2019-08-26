from pprint import pprint

def remove_quotes(array):
	for i in range(len(array)):
		array[i][1] = array[i][1].split('\"')[1]
	return array

################################################################################
# Gets data as list
# 	Used if there are possibility of multiple entries with same game name
################################################################################
def get_data_as_list(filename):
	f = open(filename,'r')
	i = 0
	data = []
	for line in f:
		if i == 0:
			i += 1
		else:
			d = line.split('\n')[0].split('\r')[0].split(',')
			data.append(d)
	f.close()
	return data

################################################################################
# Combines the data of vgsales and game-features and steam-200k
################################################################################
def combine_data(game_features, steam_200k):
	combined = []
	for row in steam_200k:
		for i in range(len(game_features)):
			if row[1] == game_features[i][3] or row[1] == game_features[i][2]:
				combined.append(row + [game_features[i][5], game_features[i][8], game_features[i][21],\
	    		 game_features[i][26], game_features[i][27], game_features[i][28], \
	    		 game_features[i][35], game_features[i][36], game_features[i][37], \
	    		 game_features[i][38], game_features[i][39], game_features[i][40], \
	    		 game_features[i][41], game_features[i][42], game_features[i][43], \
	    		 game_features[i][44], game_features[i][45], game_features[i][46], \
	    		 game_features[i][47], game_features[i][48], game_features[i][49], \
	    		 game_features[i][50], game_features[i][51], game_features[i][52], \
	    		 game_features[i][53], game_features[i][54], game_features[i][55]])
				break
	return combined

################################################################################
# Writes combined data to vg_data.csv
################################################################################
def write_to_file(d):
	f = open('vg_data.csv','w')
	for row in d:
		string = ""
		for item in row:
			string += str(item) + ","
		string = string[:-1]
		f.write(string + '\n')
	f.close()

################################################################################
# Main method
################################################################################
def main():
	game_features = get_data_as_list('../data/games-features.csv')
	steam_200k = get_data_as_list('../data/steam-200k_final.csv')
	steam_200k = remove_quotes(steam_200k)
	combined = combine_data(game_features, steam_200k)
	write_to_file(combined)

main()
