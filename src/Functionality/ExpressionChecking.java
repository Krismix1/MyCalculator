package Functionality;

import java.util.Stack;

/**
 * Created by Chris on 10-Feb-17.
 * This class will check if the expression is written in a correct format.
 * That said, every opened parenthesis is closed, after each operation there is a number or a parenthesis etc.
 */
public class ExpressionChecking
{
    // This method will check if all opened parenthesis are closed
    public boolean checkParenthesisDebug(String s)
    {
        int closingBraces = 0;
        Stack<Character> braces = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')
            {
                braces.push(s.charAt(i));
            }
        }

        if (braces.size() % 2 == 1)
        {
            return false;
        }

        while (!braces.isEmpty())
        {
            char c = braces.pop();
            if (c == ')')
            {
                closingBraces++;
            } else if (c == '(' && closingBraces > 0)
            {
                closingBraces--;
            } else return false;
        }
        return true;
    }

    public boolean checkParenthesis(String s)
    {
        Stack<Character> braces = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                braces.push(s.charAt(i));
            }
            if (s.charAt(i) == ')')
            {
                if (!braces.isEmpty())
                {
                    braces.pop();
                }else return false;
            }
        }
        return true;
    }
}
