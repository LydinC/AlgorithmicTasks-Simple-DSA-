import java.util.*;
public class Exercise2
{
    public static void main(String[] args)            
    {   
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
 
        System.out.println("Please enter a proper Postfix Expression");
        System.out.println("Use spaces between numbers");
        String userInput = sc.next();
        ArrayList postfixExpression = new ArrayList();
        
        //Convert user input to characters
        char[] initialPostfixExpression = userInput.toCharArray();
        
        organizeExpression(initialPostfixExpression, postfixExpression);
        postfixArithmetic(postfixExpression);
    }
    
    public static void organizeExpression(char[] initialPostfixExpression, ArrayList arrayList)
    {
        int position = 0;
        for(int i = 0; i < initialPostfixExpression.length; i++)
        {
            char c = initialPostfixExpression[i];
            if(Character.isDigit(c))
            {
                int a = Integer.parseInt(String.valueOf(c));
                //For multi-digit numbers
                position = (position * 10) + a;
            }
            //Add number to the ArrayList
            else if(Character.isSpaceChar(c))
            {
                arrayList.add(position);
                position=0;
            }
            //Add operator to the ArrayList
            else if((c == '+') || (c == '-') || (c == '*') || (c == '/'))
            {
                arrayList.add(c);
                i = i+1;
            }            
        }
    }
    
    public static void postfixArithmetic(ArrayList arrayList)
    {
        //Initialize Stack
        ArrayList<Integer> stack = new ArrayList();
        int stackPosition = -1;
        int result;
        
        for(int i = 0; i < arrayList.size(); i++)
        {
            String stringValue = arrayList.get(i).toString();
            char ch = stringValue.charAt(0);
            
            //If character is an operator, then compute previous 2 operands
            if((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/'))
            {
                int operand1 = stack.get(stackPosition);
                stack.remove(stackPosition);
                stackPosition--;
                
                int operand2 = stack.get(stackPosition);
                stack.remove(stackPosition);
                stackPosition--;
                
                switch(stringValue)
                {
                    case "+": result = operand2 + operand1;
                              stackPosition++;
                              stack.add(result);
                              break;
                    case "-": result = operand2 - operand1;
                              stackPosition++;
                              stack.add(result);
                              break;
                    case "*": result = operand2 * operand1;
                              stackPosition++;
                              stack.add(result);
                              break;
                    case "/": result = operand2 / operand1;
                              stackPosition++;
                              stack.add(result);
                              break;
                }
            }
            //Otherwise add number to the stack
            else
            {
                stackPosition++;
                stack.add(Integer.parseInt(stringValue));
            }
            System.out.println("Current Stack Value/s: " + stack);
        }
    }
}