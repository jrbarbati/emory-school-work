import game_summary, sys, operator
from pprint import pprint

class Recommend:
	def __init__(self, freq_file):
		self.freq_file = freq_file
		self.played_games = None # will be a set of games user has played
		self.games = game_summary.main()
		self.threshold = 11.0 # at least n hours (avg) for a game to be
							  # recommended
		self.recommended_games = {} # key = Game value = Weight
		self.read_itemsets()

	############################################################################
	# Builds dict of frequent itemsets and their corresponding frequencies
	############################################################################
	def read_itemsets(self):
		self.freq_itemsets = {}
		with open(self.freq_file,'r') as f:
			for line in f:
				d = line.split('\n')[0].split('\r')[0].split('\"')[1:]
				if len(d) <= 2:
					continue
				i  = 0
				while(i < len(d)):
					if d[i] == ' ':
						d.pop(i)
						i -= 1
					i += 1
				freq = d[len(d) - 1]
				freq = int(freq.split(' ')[1].split('(')[1].split(')')[0])

				d = d[:-1]
				self.freq_itemsets[tuple(d)] = freq

	############################################################################
	# Sets the played games by the user
	############################################################################
	def set_user_games(self, games):
		# for i in range(len(games)):
		# 	print(games[i])
		# 	games[i] = games[i].split('"')[1]
		self.played_games = set(games)

	############################################################################
	# Recommends games based on others users
	# returns list of games to be recommended.
	############################################################################
	def by_similar_users(self):
		user_games = list(self.played_games)
		for i in range(1, len(self.played_games) + 1):
			subsets = self.get_subsets(user_games, i, dict())
			for subset in subsets:
				for key in self.freq_itemsets:
					if self.is_subset_of(subset, key) and len(list(key)) -  len(subset) <= 1:
						for item in self.get_leftovers(subset, key):
							if item not in self.recommended_games and item not in self.played_games:
								self.recommended_games[item] = 1  * self.compare_title(item) * self.compare_genre(item)

	############################################################################
	# Compares genre of recommended game to the genre's in the user's
	# played_games. Assigns weights based on how many genres match
	############################################################################
	def compare_genre(self, game):
		# Go through list(self.played_games) and compare genres of game to the
		# genres in self.played_games and assign weights accordingly.
		# Return weight (1 if no additional should be added, any other number else)
		count = 0
		game_genre = self.games[game]["genres"]
		for item in self.played_games:
			if item not in self.games:
				continue
			item_genre = self.games[item]["genres"]
			for genre in game_genre:
				if genre in item_genre:
					count += 1
		if count == 0:
			return 1
		else:
			return 2 * count

	############################################################################
	# Compares the titles and adds weight if they are similar
	############################################################################
	def compare_title(self, title):
		title_lower = title.lower()
		for game in list(self.played_games):
			game_lower = game.lower()
			if title_lower[:7] in game_lower and title_lower != game_lower:
				return 3
		return 1

	############################################################################
	# Calls all recommendation functions
	############################################################################
	def recommend(self):
		self.by_similar_users()
		games = sorted(self.recommended_games.items(), key=operator.itemgetter(1))
		rec_games = []
		if len(self.recommended_games) == 0:
			return rec_games
		i = len(games) - 1
		j = 0
		while(j < 20):
			rec_games.append(games[i][0])
			i -= 1
			if i == -1:
				break
			j += 1
		return rec_games

	############################################################################
	# Returns all length-n subsets of superset
	############################################################################
	def get_subsets(self, superset, n, res):
		self.get_subsets_helper(superset, n, 0, tuple(), res)
		return res

	############################################################################
	# Recursive helper to get_subsets()
	############################################################################
	def get_subsets_helper(self, superset, n, idx, curr, res):
		if len(curr) == n:
			# If len(curr) is n, we add it to res, as the for loop below
			# guarantees that curr is at least possibly frequent.
			# In other words, curr would not have made it this far if a subset
			# of curr is infrequent.
			res[curr] = True
			return

		if idx == len(superset):
			return

		old_curr = curr
		new_curr = curr + tuple([superset[idx]])
		# supeset[idx] is either in the superset or out
		# in
		self.get_subsets_helper(superset, n, idx + 1, new_curr, res)
		# out
		self.get_subsets_helper(superset, n, idx + 1, old_curr, res)

	############################################################################
	# Checks if subset is a subset of superset
	############################################################################
	def is_subset_of(self, subset, superset):
		count = 0
		sup = set(superset)
		for item in subset:
			if item in sup:
				count += 1
		return count == len(subset)

	############################################################################
	# Builds a list of games in superset but not in subset, returns that list.
	############################################################################
	def get_leftovers(self, subset, superset):
		leftovers = []
		subset = set(subset)
		for item in list(superset):
			if item not in subset:
				if item not in self.games:
					continue
				avg_hours = self.games[item]["totalHours"]/self.games[item]["freq"]
				if avg_hours >= self.threshold:
					leftovers.append(item)
		return leftovers

args = sys.argv[1:]
if len(args) != 0:
	r = Recommend("/Users/josephbarbati/Documents/codefiles/Emory/CS378/Final_Project/code/Frequent_Itemsets.txt")
	r.set_user_games(args)
	pprint(r.recommend())
