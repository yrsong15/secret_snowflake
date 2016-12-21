package general;

import secret_snowflake.Matchmaker;
import secret_snowflake.Parser;

public class MainController {
	
	private Parser myParser;
	
	public MainController(String filepath){
		runParser(filepath);
	}
	
	public void generateSnowflakes(){
		Matchmaker match = new Matchmaker(myParser.getGroupOne(), myParser.getGroupTwo());
		match.generateSnowflakes();
		match.printSnowflakes();
	}
	
	private void runParser(String filepath){
		myParser = new Parser();
		myParser.readFile(filepath);
	}
}
