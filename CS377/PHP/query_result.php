<!-- THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
WRITTEN BY OTHER STUDENTS - Joseph Barbati -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Query Result</title>
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
		<a href="http://holland.mathcs.emory.edu/~jdbarba/php-form.html"><button class="btn btn-default">Send Another Query</button></a>
		<table align="center">
			<?php
				$conn = mysqli_connect("holland.mathcs.emory.edu","cs377","abc123", "spjDB");
				if (mysqli_connect_errno())
				{
					printf("<p>Connect failed: %s</p>", mysqli_connect_error());
					exit(1);
				}		

				$input = array('sname'  => isset($_POST['sname']) ? $_POST['sname'] : '',
						  	   'S.city' => isset($_POST['scity']) ? $_POST['scity'] : '',
						  	   'pname'  => isset($_POST['pname']) ? $_POST['pname'] : '',
						  	   'P.city' => isset($_POST['pcity']) ? $_POST['pcity'] : '',
						  	   'jname'  => isset($_POST['jname']) ? $_POST['jname'] : '',
						  	   'J.city' => isset($_POST['jcity']) ? $_POST['jcity'] : '');

				$query = 'SELECT sname "Supplier Name", S.city "Supplier City",
						  pname "Part Name", P.city "Part City", 
						  jname "Project Name", J.city "Project City", 
						  spj.qty "Quantity Shipped"
						  FROM  spj, supplier S, part P, proj J
						  WHERE spj.snum = S.snum
						  AND   spj.jnum = J.jnum
						  AND   spj.pnum = P.pnum';
				
				foreach($input as $key => $value)
				{
					if(strlen($value) != 0)
					{
						$value = replaceWildCards($value);
						$query = $query . " AND $key LIKE '$value'";
					}
				}
				
				if (!($result = mysqli_query($conn, $query)))
				{
					printf("<p>Error: %s<p>", mysqli_error($conn));
					exit(1);
				}

				$printColHeaders = true;
				while(!($tuple = mysqli_fetch_assoc($result)) == null)
				{
					if (count($tuple) == 0)
					{
						print("<p>Your query resulted in empty table</p>");
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
				
				// Replaces UNIX-style wildcards with SQL-style wild cards
				function replaceWildCards($s)
				{
					for($i = 0; $i < strlen($s); $i++)
					{
						if($s[$i] == '*')
						{
							$s[$i] = '%';
						}
						else if ($s[$i] == '?')
						{
							$s[$i] = '_';
						}
					}	
					return($s);
				}
			?>
		</table>
		<a href="http://holland.mathcs.emory.edu/~jdbarba/php-form.html"><button class="btn btn-default">Send Another Query</button></a>
	</body>
</html>
