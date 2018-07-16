import java.util.*;

public class Exercise9 {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        try{
            System.out.println("Enter n: ");  
            int userInput = sc.nextInt();
            int summation;        

            if (userInput < 0)
                System.out.println("Negative values cannot be entered");
            else if(userInput > 1){
                summation = summationOfFibonacci(userInput);
                System.out.println("\nSum = " + summation);   
            }else{    
                switch(userInput){
                    case 0 : 
                        System.out.println("Sum = 0");
                        break;
                    case 1 :
                        System.out.println("Sum = 1");       
                        break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Input is incorrect. Please re-execute program.");
        }  
    }

    public static int summationOfFibonacci(int terms)
    {   
        System.out.print("\n1 ");
        int sum =1 ,current = 1, previous = 1, previous2 = 0;
        for(int i = 1; i < terms; i++){
            current = previous + previous2;        
            System.out.print(current + " ");
            sum += current; 
            previous2 = previous;
            previous  = current;                   
        }
        return sum;
    }
}