package week1.day3;

public class DuplicateElement {  
    public static void main(String[] args) {      
          
        //Initialize array   
        int [] arr = new int [] {12, 25, 12, 56, 25, 89};   
          
        System.out.println("Duplicate elements in given array: ");  
        //Searches for duplicate element  
        for(int i = 0; i < arr.length; i++) {  
            for(int j = i + 1; j < arr.length; j++) {  
                if(arr[i] == arr[j])  
                    System.out.println(arr[j]);  
            }  
        }  
    }  
}  
