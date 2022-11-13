package week3.day4;



	import java.util.LinkedHashSet;
	import java.util.Set;

	public class RemDupFromString {

		public static void main(String[] args) {
			String str = "TestLeaf";

			char c[] = str.toCharArray();

			Set<Character> set = new LinkedHashSet<Character>();

			for(Character each : c)
			{
				set.add(each);
			}
			System.out.println(set); 

		}

	}