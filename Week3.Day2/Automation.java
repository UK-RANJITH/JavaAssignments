package week3.day2;

public class Automation extends MultipleLanguage implements Language,TestTool{

	public static void main(String[] args) {


		Automation Auto= new Automation();
		Auto.Java();
		Auto.Selenium();
		Auto.python();
		Auto.ruby();

	}

	

	
	public void Selenium() {

		System.out.println("This is Selenium Method from Interface 2 - TestTool");
	}

	public void Python() {

		System.out.println("This is Python Method Ruby from Abstract Class-Multiple Language");
	}

	@Override
	public void ruby() {

		System.out.println(" This is Un Implemented method Ruby from Abstract Class-Multiple Language");
	}


	public void Java() {
		// TODO Auto-generated method stub
		System.out.println("This is Java Method from Interface 1- Language");
	}


}