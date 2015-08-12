<h1>Yfor</h1>  


<?php
$mysql = new SaeMysql();

$sql = "SELECT * FROM `user` LIMIT 0,30";
$result = $mysql->getData( $sql );
	
	foreach ($result as $row)
	{
		foreach ($row as $key=>$value)
		{
			echo $key."=>".$value."<br/>";
		}
		echo "===================<br/>";
	}
	$mysql->closeDb();

?>