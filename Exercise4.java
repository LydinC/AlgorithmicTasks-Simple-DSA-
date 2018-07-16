import java.util.*;

public class Exercise4 {
    
    public static void main(String[] args) 
    {         
        int arraySize = 10;
        int[] arrayNumbers = new int[arraySize];
        Random randomNumber = new Random();
        
        //filling array with random numbers
        for(int i = 0; i < arraySize;i++)
            arrayNumbers[i] = randomNumber.nextInt(500)+1;
        
        //displaying the list generated with random numbers
        System.out.println("This is the random list generated: \n");
        for(int i = 0; i < arraySize;i++)
            System.out.print(arrayNumbers[i] + " ");
        
        int counter = arrayNumbers.length/2;
        
        //SHELL SORT ALGORITHM
        while(counter > 0){
            for(int outer = counter; outer<arrayNumbers.length;outer++) {
                int temp = arrayNumbers[outer];
                int inner = outer;
                while (inner >= counter && arrayNumbers[inner-counter] > temp) {
                    arrayNumbers[inner] = arrayNumbers[inner-counter];
                    inner = inner - counter;
                }
            arrayNumbers[inner] = temp;
            }
            
            //optimization value
            if (counter == 2)
                counter = 1;
            else
                counter /= 2.2;
        }
        //display sorted array    
        System.out.println("\n\nThis is the shell sorted list: \n");
        System.out.println(Arrays.toString(arrayNumbers));
    }
}