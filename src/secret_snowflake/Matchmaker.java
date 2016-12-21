package secret_snowflake;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import interfaces.IMatchmaker;

public class Matchmaker implements IMatchmaker{
	public List<String> longer;
	public List<String> shorter;
	public Map<String, String> snowflakes;
	
	public Matchmaker(List<String> first, List<String> second){
		setList(first, second);
		snowflakes = new TreeMap<String, String>();
	}
	
	@Override
	public void generateSnowflakes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printSnowflakes() {
		for(String key: snowflakes.keySet()){
			System.out.println(key + " -> " + snowflakes.get(key));
		}
	}

	private void setList(List<String> first, List<String> second) {
		if(first.size() >= second.size()){
			longer = first;
			shorter = second;
		}
		else{
			longer = second;
			shorter = first;
		}
		Collections.shuffle(longer);
		Collections.shuffle(shorter);
	}

}
