import java.util.*;

public class Exercise3
{    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please select:");
        System.out.println("1 - Using Is Prime");
        System.out.println("2 - Using Sieve of Eratosthenes");
        int choice = sc.nextInt();
        
        System.out.println("Enter Number: ");  
        int checkInput = sc.nextInt();
        
        boolean isPrimeNumber = false;
        switch (choice) {
            case 1 :
                isPrimeNumber = isPrime(checkInput);
                break;
            case 2 :
                isPrimeNumber = sieveOfEratosthenes(checkInput);
                break;
        }
        
        if (isPrimeNumber == true) {
            System.out.println("Number " + checkInput + " is prime");  
        } else {
            System.out.println("Number " + checkInput + " is not prime");    
        }
    }
    
    //set up the primesieve
    public static boolean sieveOfEratosthenes(int checkInput)
    {
        int upperBoundSquareRoot = (int)Math.sqrt(checkInput);
        boolean[] numbers = new boolean[checkInput + 1];
        Arrays.fill(numbers, Boolean.TRUE);
        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (numbers[m]) {
                for (int k = m * m; k <= checkInput; k += m)
                    numbers[k] = false;
            }
        }
        return numbers[checkInput];
    }

    public static boolean isPrime(int n)
    {            
        //check if n is a multiple of 2
        if (n == 2) return true;
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3; i*i<=n; i+=2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}