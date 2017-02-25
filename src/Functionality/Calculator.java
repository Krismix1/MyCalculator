package Functionality;

import java.util.*;

/**
 * Created by Chris on 10-Feb-17.
 */
public class Calculator
{
    // Make an enum to store the priority of the operations?
    // How to store everything?
    List<String> numbersDebug = new ArrayList<>();

    public double computeExpression(String expression)
    {
        double value = 0;
        ExpressionChecking checker = new ExpressionChecking();
        if (!checker.checkParenthesis(expression))
        {
            System.out.println("Mismatching parenthesis");
            // Or just add a parenthesis at the end of the expression and compute from that
        }
        // All remaining checks

        // Call if all checks are good
        doCalculations(expression);
        return value;
    }

    private String test(String s)
    {
        int firstPar = s.indexOf("(");// won't work for smth like this: (1+2*(1+2)+ 5 + (1+3)+5) and not even (1+2*(1+(2+8)+ 6)+ 5 + (1+3)+5)
        int lastPar = s.lastIndexOf(")"); // (1+2*(1+ 6)+ 5 + (1+3 / (1-2))+5)
        //if (s.length() == 0) // wrong condition
        if(firstPar == -1 && lastPar == -1)
        {
            return doCalculations(s) + "";
        } else
        {
            while (s.contains("(") || s.contains(")")) // Is there any possibility that an opening parenthesis doesn't have a closing pair? It shouldn't, because we checked
            // What if we check each time we 'create' a new expression with this method?
            {
                String value = test(s.substring(firstPar + 1, lastPar));
                s = s.substring(0, firstPar) + value + s.substring(lastPar+1);
                firstPar = s.indexOf("(");
                lastPar = s.lastIndexOf(")");
            }
            return s;

            // return doCalculation; but insert this number in the middle of the string
        }
    }

    // Put the order of the operations
    private double doCalculations(String expression)
    {
        Map<Integer, String> operations = new HashMap<>();
        int numberOfOperation = 0;
        for (int i = 0; i < expression.length(); i++)
        {
            String s = expression.charAt(i) + "";
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) // Add log, percent, remainder, power...
            {
                operations.put(numberOfOperation, s);
                numberOfOperation++;
            }
            if (s.equals("l")) // logarithms are functions?
            {
                if (expression.charAt(i + 2) == 'g')
                {
                    operations.put(numberOfOperation, s + expression.substring(i, i + 3));
                    numberOfOperation++;
                    i += 2;
                }
            }
        }
        // Sort the operations
        // Add the rest of the operations
        String[] numbers = expression.split("\\+|-|\\*|/");
        double result = 0;
        for (Integer operationNumber : operations.keySet())
        {
            double firstNumber = Double.parseDouble(numbers[operationNumber]);
            double secondNumber = Double.parseDouble(numbers[operationNumber + 1]);
            result = apply(firstNumber, secondNumber, operations.get(operationNumber));
            numbers[operationNumber + 1] = result + "";
        }
        return result;
    }

    // Effectuates the specified operation between the numbers
    private double apply(double firstNumber, double secondNumber, String operation)
    {
        double result;
        switch (operation)
        {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                result = 0;
        }
        return result;
    }

    public static void main(String[] args)
    {
        Calculator test = new Calculator();
        // System.out.println(test.test("(1+2+3+4+(1245+(90+87)+8796)+6)"));
        System.out.println(test.doCalculations("2+2*2"));
    }
}
