package week1.Dayy2.day2;

public class InputArgu {

	public void add(int a, int b) {
		int c = a + b;
		System.out.println("addtion of " + a + " " + "," + b + " " + "is" + " " + c);
	}

	void sub(int a, int b) {
		int c = a - b;
		System.out.println("subraction of " + a + " " + "," + b + " " + "is" + " " + c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputArgu obj = new InputArgu();
		obj.add(5, 10);
		obj.sub(55, 110);
	}

}
