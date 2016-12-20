package secret_snowflake;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import interfaces.ISnowflake;

public class Controller implements ISnowflake{
	
	private List<String> myList;
	private Map<String, String> myResult;
	
	public Controller(String filename){
		myList = new ArrayList<String>();
		myResult = new TreeMap<String, String>();
		try {
			Scanner sc = new Scanner(new FileReader(filename));
			initializeList(sc, myList);
		} catch (FileNotFoundException e) {
			System.out.println("error in reading file");
		}
	}
	
	@Override
	public void printResult(){
		for(String key: myResult.keySet()){
			System.out.println(key + " -> " + myResult.get(key));
		}
	}
	
	@Override
	public void setPartners() {
		List<String> snowflakes = copyList(myList);
		randomize(snowflakes);
		randomize(myList);
		int count = 0;
		for(String key: myList){
//			boolean same = false;
			String value = snowflakes.get(count);
//			String originalValue = value;
			if(!checkValidMatch(key, value) && count != snowflakes.size()-1){
//				same = true;
				value = snowflakes.get(count+1);
				switchElementsInList(snowflakes, count, count+1);
			}
			count++;
//			if(same) System.out.println("key: " + key + ", value: " + value + ", original: " + originalValue);
			myResult.put(key, value);
		}
	}
	
	private void initializeList(Scanner sc, List<String> list){
		while(sc.hasNextLine()){
			list.add(sc.nextLine()); 	
		}
	}

	private List<String> copyList(List<String> original){
		List<String> copied = new ArrayList<String>();
		for(String elem: original){
			copied.add(elem);
		}
		return copied;
	}

	private List<String> randomize(List<String> list){
		Collections.shuffle(list);
		return list;
	}
	
	private boolean checkValidMatch(String str1, String str2){
		return !str1.equals(str2);
	}
	
	private void switchElementsInList(List<String> list, int indexOne, int indexTwo){
		String temp = list.get(indexOne);
		list.set(indexOne, list.get(indexTwo));
		list.set(indexTwo, temp);
	}
}
