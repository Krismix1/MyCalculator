package Functionality;

/**
 * Created by Chris on 25-Feb-17.
 */
public class Operation implements Comparable<Operation>
{
    private int order;
    private String operatorSign;

    private Operation()
    {
    }


    public static Operation multiplication()
    {
        Operation temp = new Operation();
        temp.order = 1;
        temp.operatorSign = "*";
        return temp;
    }

    public static Operation division()
    {
        Operation temp = new Operation();
        temp.order = 1;
        temp.operatorSign = "/";
        return temp;
    }

    public static Operation addition()
    {
        Operation temp = new Operation();
        temp.order = 2;
        temp.operatorSign = "+";
        return temp;
    }

    public static Operation subtraction()
    {
        Operation temp = new Operation();
        temp.order = 2;
        temp.operatorSign = "-";
        return temp;
    }

    public static Operation power()
    {
        Operation temp = new Operation();
        temp.order = 0;
        temp.operatorSign = "^";
        return temp;
    }

    public static Operation sqrRoot()
    {
        Operation temp = new Operation();
        temp.order = 0;
        temp.operatorSign = "sqrt";
        return temp;
    }

    @Override
    public int compareTo(Operation o)
    {
        return order - o.order;
    }

    public String toString()
    {
        return operatorSign;
    }
}
