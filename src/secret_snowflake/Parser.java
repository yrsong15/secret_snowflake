package secret_snowflake;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.IllegalEntryException;
import interfaces.IParser;

public class Parser implements IParser{
	
	private List<String[]> myList;
	private List<String> groupOne;
	private List<String> groupTwo;
	private List<String> categories;
	
	public Parser(){
		myList = new ArrayList<String[]>();
		groupOne = new ArrayList<String>();
		groupTwo = new ArrayList<String>();
		categories = new ArrayList<String>();
	}

	@Override
	public void readFile(String input) {
		try {
			Scanner sc = new Scanner(new FileReader(input));
			List<String> tempList = initializeList(sc);
			myList = divideList(tempList);
		} catch (FileNotFoundException e) {
			System.out.println("error in reading file");
		}
	}

	@Override
	public void parse(List<String[]> list) {
		for(String[] elem: list){
			if(categories.isEmpty() || elem[1].equals(categories.get(0))){
				groupOne.add(elem[0]);
				if(categories.isEmpty()) categories.add(elem[1]);
			}
			else if(categories.size()==1 || elem[1].equals(categories.get(1))){
				groupTwo.add(elem[0]);
				if(categories.size()==1) categories.add(elem[1]);
			} else
				try {
					throw new IllegalEntryException("Error in parse() method of Parser.");
				} catch (IllegalEntryException e) {
					e.printStackTrace();
				}
		}
	}
	
	private List<String> initializeList(Scanner sc){
		List<String> result = new ArrayList<String>();
		while(sc.hasNextLine()){
			result.add(sc.nextLine()); 	
		}
		return result;
	}
	
	private List<String[]> divideList(List<String> inputList){
		List<String[]> result = new ArrayList<String[]>();
		for(String elem: inputList){
			String[] split = elem.split("\\s+");
			if(split.length != 2)
				try {
					throw new IllegalEntryException("Error in divideList() method of Parser");
				} catch (IllegalEntryException e) {
					e.printStackTrace(); // Hi Professor Duvall :)
				}
			result.add(split);
		}
		return result;
	}

	@Override
	public List<String[]> getMyList() {
		return myList;
	}

	@Override
	public List<String> getGroupOne() {
		return groupOne;
	}

	@Override
	public List<String> getGroupTwo() {
		return groupTwo;
	}
	
}
