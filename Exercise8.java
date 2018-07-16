import java.util.*;

public class Exercise8 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please select:");
        System.out.println("1 - Sine");
        System.out.println("2 - Cosine");
        System.out.println("Enter -1 to exit");
        
        try{
            int userInput = sc.nextInt();
            
            while(userInput != -1) {
                if ((userInput == 1) || (userInput == 2)) {

                    //pi value is set
                    double PI = 3.14159;
                    int numberOfTerms;
                    float degreesValue, radiansValue, total;

                    System.out.println("Enter the value for x (in degrees)");  
                    degreesValue = sc.nextFloat();
                    System.out.println("Enter the value for k ");
                    numberOfTerms = sc.nextInt();

                    //function to get degrees value between -180 and 180
                    float degreesValue2 = optimization(degreesValue);

                    radiansValue = (float)((degreesValue2* PI) / 180) ;

                    switch (userInput) {
                        //sine
                        case 1 : 
                            //sine expansion
                            total = sineExpansion(radiansValue, numberOfTerms);
                            System.out.println("Sine value of " + degreesValue + " degrees is " + total);
                            break;

                        //cosine    
                        case 2 :
                            //cosine expansion
                            total = cosineExpansion(radiansValue, numberOfTerms);
                            System.out.println("Cosine value of " + degreesValue + " degrees is " + total); 
                            break;
                    }
                    break;
                }
                else 
                    System.out.println("Choice is invalid. Please select again.");
                userInput = sc.nextInt();
            }
        }catch(InputMismatchException e){
            System.out.println("Input is incorrect. Please re-execute program");
        }
    }
  
    public static float optimization(float val)
    {
        while(val > 180)
            val = val - 360;        
        while(val < -180)
            val = val + 360;
        return val;
    }
    public static float sineExpansion(float radiansVal, int terms)
    {
        float temp    = radiansVal;
        float total   = radiansVal;
        int i         = 2;
        for(int j = 2; j <= terms; j++){   
            temp = (temp*(-1)*radiansVal*radiansVal) / (i*(i+1));
            total = total + temp;
            i = i + 2;
        }
        return total;
    }
    public static float cosineExpansion(float radiansVal, int terms)
    {
        float temp    = 1;
        float total   = 1;
        int i         = 1;
        for(int j = 2;j <= terms; j++){
            temp = ((-1)*temp*radiansVal*radiansVal) / (i*(i+1));
            total = total + temp;
            i = i + 2;
        }
        return total;
    }
}
