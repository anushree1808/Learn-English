<?php
	ini_set('max_execution_time', 300);
	//$input_sentence = $_POST['input'];
	$input_sentence = $_GET['input'];
	//$input_sentence = "-1.03458 girl read book the girl is reading a book ";
	$output = " ";
	$cmd = "java -jar nlp1.jar ".$input_sentence;
	//echo $cmd;
	exec($cmd, $output);
	//echo sizeof($output);
	echo $output[sizeof($output)-1]
?>