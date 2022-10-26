package week1.day1;

public class Car {

		
		public void applyBrake() {
			System.out.println("***Applying break***");
		}
		public void soundHorn() {
			System.out.println("*** Horn***");
		}
		public void isPuncture() {
			System.out.println("***punctured***");
		}
		public void driveCar() {
			System.out.println("***Driving Car***");
		}
		public static void main(String[] args) {
			Car obj2= new Car(); {
		obj2.driveCar();
		obj2.applyBrake();
		obj2.soundHorn();
		obj2.isPuncture();
			}
		
			
		}

	}
