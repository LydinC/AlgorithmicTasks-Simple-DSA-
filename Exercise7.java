import java.util.*;
public class Exercise7 {
    
    public static int maximumValue(int max1,int max2) 
    {
        if(max1 > max2)
            return max1;
        else
            return max2;
    }
    
    public static int largestElement(int arr[], int size) {
        if(size == 0)
            return arr[0];
        return maximumValue(largestElement(arr,size-1) ,arr[size]);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        try{
        System.out.println("Enter the list size :");  
        int listSize = sc.nextInt();
        
        if(listSize>0){
            int[] GivenList = new int[listSize];

            for (int i=0; i < listSize; i++)
            {
                System.out.println("Number(" + (i+1) + "):");
                GivenList[i] = sc.nextInt();
            } 

            int max = largestElement(GivenList,listSize-1);
            System.out.println("Largest number is " + max);
        }
        else
            System.out.println("No list exists");
            

        }catch(InputMismatchException e){
            System.out.println("Input is incorrect. Please re-execute program");
        }     
    }
}