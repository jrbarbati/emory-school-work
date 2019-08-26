
from tkinter import *
from tkinter import ttk
from recommend import Recommend

class RecommendGUI:
	def __init__(self, root):
		self.root = root
		self.create()
		self.recommender = Recommend("/Users/josephbarbati/Documents/codefiles/Emory/CS378/Final_Project/code/Frequent_Itemsets.txt")

	############################################################################
	# Creates GUI
	############################################################################
	def create(self):
		pass

	############################################################################
	# Calls recommendation code
	############################################################################
	def recommend(self):
		# self.recommender.threshold = 10
		# self.recommender.set_user_games()
		# self.recommender.by_title()
		# print(self.recommender.recommended_games)
		pass


root = Tk()
r = RecommendGUI(root)
r.recommend()
root.mainloop()