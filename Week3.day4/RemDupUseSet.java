package week3.day4;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class RemDupUseSet  {

	public static void main(String[] args) {
		String lengthyString = "We learn java basics as part of java sessions in java week1";
		String[] splitString = lengthyString.split(" ");
		List<String> list = new ArrayList<String> ();

		for (String eachString : splitString) {
			list.add(eachString);
		}
		System.out.println("Size of the list is: "+list.size());
		System.out.println("Words added in list: "+list);	


		Set<String> set = new LinkedHashSet<String> (list);
		System.out.println("Size of the set is: "+set.size());
		System.out.println("Removed duplicate words using Set: "+set);

	}

}