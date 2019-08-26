<!-- Just messing around  -->
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>CS 377 - spjDB Result</title>
		<!-- jQuery -->
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<style type="text/css">
			* {
				font-family: "Courier New";
			}
			body {
				text-align: center;
			}
			.jumbotron {
				padding: 1.5%;
			}
			table {
				margin-bottom: 3%;
			}
			td, th {
				padding: 10px;
				border: solid 1px black;
				text-align: center;
			}
			th {
				background-color: #adfaff;
			}
			.btn {
				margin: 2%;
			}
		</style>
	</head>
	<body>
		<div class="jumbotron">
			<div class="container">
				<h3>Answer to Query</h3>
			</div> <!-- /.container -->
		</div> <!-- /.jumbotron -->
		<a href="http://holland.mathcs.emory.edu/~jdbarba/spjDB/spjDB.html"><button class="btn btn-default">Send Another Query</button></a>
		<table align="center">
			<?php
				$conn = mysqli_connect("holland.mathcs.emory.edu","cs377","abc123", "spjDB");
				if (mysqli_connect_errno())
				{
					printf("<tr><td>Connect failed: %s</td></tr>", mysqli_connect_error());
					exit(1);
				}		

				$query = isset($_POST['query']) ? $_POST['query'] : '';
				
				if (strlen($query) <= 0)
				{
					print("<tr><td>Error: Empty query</td></tr>");
					exit(1);
				}

				if (!($result = mysqli_query($conn, $query)))
				{
					printf("<tr><td>Error: %s</td></tr>", mysqli_error($conn));
					exit(1);
				}

				$printColHeaders = true;
				while(true)
				{
					$tuple = mysqli_fetch_assoc($result);
					if ($tuple == null and $printColHeaders)
					{
						print("<tr><td>Your query resulted in an empty table</td></tr>");
						break;
					}
					else if ($tuple == null)
					{
						break;
					}
					
					if ($printColHeaders)
					{	
						print("<thead>\n");
						print("<tr>\n");
						foreach ($tuple as $key => $value)
						{
							print("<th>" . $key . "</th>\n");
						}
						print("</tr>\n");
						print("</thead>\n");
						$printColHeaders = false;
					}
					print("<tr>\n");
					foreach ($tuple as $key => $value)
					{
						print("<td>" .  $value . "</td>\n");
					}
					print("</tr>\n");
				}

				mysqli_close($conn);
			?>
		</table>
		<a href="http://holland.mathcs.emory.edu/~jdbarba/spjDB/spjDB.html"><button class="btn btn-default">Send Another Query</button></a>
	</body>
</html>
