package week1.day3;

public class FindCharCount {

	public static void main(String[] args) {
		String str = "cognizant";
		char ch = 'c';
		int count = 0;
		char[] array = str.toCharArray();
		int len = array.length;

		for (int i = 0; i < len; i++) {
			if (array[i] == ch) {
				count++;
			}
		}
		System.out.println("Length of the array is " + len);
		System.out.println("Given character is avaiable " + count + " times in the string");
	}
}