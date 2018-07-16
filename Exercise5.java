import java.util.*;

public class Exercise5 {
    public static void main(String args [])
    {
        Scanner sc = new Scanner(System.in);
        
        try{
        System.out.println("Enter Number : ");
        float userInput = sc.nextFloat();
        if (userInput < 0){
            System.out.println("Input is incorrect since the square \nroot of negative numbers do not exist.");
        }
        else
            newtonRaphson(userInput);
        }
        catch(InputMismatchException e){
            System.out.println("Input is incorrect. Please re-execute program");
        }
    }
    
    public static double newtonRaphson(float n)
    {
        int counter = 0;
        float x0 = n/2, x1 = 0;
        boolean stop = false;
        while(!stop && counter<1000){
            //Newton raphsons formulae
            x1 = (float) (x0 - ((Math.pow(x0, 2) - n)/(2 * x0)));
            counter++;
            if((x0 - x1) <= 0.0001){
                stop = true;
                System.out.println("Root: " + x1 + " after " + counter + " iterations.");
            }
            x0 = x1;
        }
        return x1;
    }
}