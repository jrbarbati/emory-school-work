Files:
	Datasets: 
		game-features.csv - Game Features Dataset
		steam-200k.csv - Raw Steam Video Games dataset
		steam-200k_final.csv - Preprocessed Steam Video Games dataset
		vg_data.csv - Combined dataset (Steam Video Games + Game Features)
		vg_dataTrimeed - Trimmed vg_data to be only pertinent information
			i.e. player_id, game, action, hours, [Genres]
		vg_data_FIM.csv - Dataset we performed Frequent Itemset Mining on
		test.csv - Dataset based on steam video games, added attribute for ignore (0 to ignore and 1 to not ignore)
		test_final.csv - Trimmed test.csv dataset for the 4 most played games for each player.
		testList.csv - List form of test_final.csv to input each line into our recommendation system
	Code:
		apriori.py - Apriori algorithm
		combine.py - combines steam video games and game features into vg_data.csv
		remove_commas.py - removed commas from video game names in steam video games
		remove_purchase.py - removed each line in steam video games that was 'purchase'.
		create_FIM_dataset.py - creates vg_data_FIM.csv from steam video games
		create_test_set.py - creates test files for evaluating recommendation system.
		game_summary.py - build dictionary (hashtable) for recommendation system
		recommend.py - the acutal recommendation system code
		recommendTest.py - run this to test the recommendation system over 11,000 times and gets precision and recall (WARNING: takes all day to run)
	Other:
		Report.docx - Final Report on our project
		Final Presentation.pptx - Presentation from class

How to run: 
	python recommend.py <list of games (space separated, in quotes)>
	Example: 
		python recommend.py "Grand Theft Auto V" "Call of Duty Black Ops II" "Half-Life 2"

	Running Test (Takes all day to run!): 
		python recommendTest.py
