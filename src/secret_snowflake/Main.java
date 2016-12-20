package secret_snowflake;

public class Main {
	public static void main(String[] args){
		Controller controller = new Controller("data/" + args[0]);
		controller.setPartners();
		controller.printResult();
	}
}
