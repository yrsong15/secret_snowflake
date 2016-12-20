package interfaces;

import java.util.List;

public interface IParser {
	public void readFile(String input);
	public void parse(List<String[]> list);
	public List<String[]> getMyList();
	public List<String> getGroupOne();
	public List<String> getGroupTwo();
}
