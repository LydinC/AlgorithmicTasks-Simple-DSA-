import java.util.*;

public class Exercise1 {
    
    int[] specialNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] specialCodes = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter a Positive Number (1 to 1024)");
        System.out.println("Enter -1 to exit");
        int userInput = sc.nextInt();
        
        while(userInput != -1) {
            if ((userInput <= 0) || (userInput > 1024)) {
                System.out.println("Number entered is not within range!");
            }
            else {
                String romanNumeral = new Exercise1().ConvertToRomanNumeral(userInput);
                System.out.println("The equivalent Roman Number is " + romanNumeral);
                break;
            }
            userInput = sc.nextInt();
        }
    }
     
    private String ConvertToRomanNumeral(int input)
    {
        int i = 0;
        String romanNumber = "";
        
         while(input != 0) {
            if(input >= specialNumbers[i]) {
                romanNumber = romanNumber + specialCodes[i];
                input = input - specialNumbers[i];
            }
            else {
                i++;
            }
        }
        return romanNumber;
    }
}