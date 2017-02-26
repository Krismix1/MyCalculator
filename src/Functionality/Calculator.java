package Functionality;

import Functionality.expressionevaluator.net.objecthunter.exp4j.Expression;
import Functionality.expressionevaluator.net.objecthunter.exp4j.ExpressionBuilder;

import java.util.*;

/**
 * Created by Chris on 10-Feb-17.
 */
public class Calculator
{
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
        calculateExpression(expression);
        return value;
    }

    private String calculateExpression(String s)
    {
        int lastPar = s.indexOf(")");
        if (lastPar == -1) // Then there aren't any parenthesis
        {
            Expression exp = new ExpressionBuilder(s).build();
            return exp.evaluate() + "";
        } else
        {
            int firstPar = s.substring(0, lastPar).lastIndexOf("(");
            while (s.contains("(") || s.contains(")"))
            {
                String value = calculateExpression(s.substring(firstPar + 1, lastPar));
                s = s.substring(0, firstPar) + value + s.substring(lastPar + 1);
                lastPar = s.indexOf(")");
                if( lastPar != -1)
                {
                    firstPar = s.substring(0, lastPar).lastIndexOf("(");
                }
            }
            return s;
        }
    }
}
