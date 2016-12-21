package general;

public class Main {
	public static void main(String[] args){
		MainController controller = new MainController("data/" + args[0]);
		controller.generateSnowflakes();
	}
}
