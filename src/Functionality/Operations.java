package Functionality;

/**
 * Created by Chris on 25-Feb-17.
 */
public class Operations implements Comparable<Operations>
{
    private int order;
    private String operatorSign;
    public static final Operations MULTIPLICATION = new Operations(1, "*");
    public static final Operations DIVISION = new Operations(1, "/");
    public static final Operations ADDITION = new Operations(2, "+");
    public static final Operations SUBTRACTION = new Operations(2, "-");
    public static final Operations POWER = new Operations(0, "^");
    public static final Operations SQRT = new Operations(0, "sqrt");

    public static Operations getOperation(String operation)
    {
        switch (operation.toLowerCase())
        {
            case "+":
                return ADDITION;
            case "-":
                return SUBTRACTION;
            case "*":
                return MULTIPLICATION;
            case "/":
                return DIVISION;
            case "^":
                return POWER;
            case "sqrt":
                return SQRT;
            default:
                return null;
        }
    }

    private Operations(int order, String sign)
    {
        this.order = order;
        this.operatorSign = sign;
    }

    private Operations(){}

    private static Operations multiplication()
    {
        Operations temp = new Operations();
        temp.order = 1;
        temp.operatorSign = "*";
        return temp;
    }

    private static Operations division()
    {
        Operations temp = new Operations();
        temp.order = 1;
        temp.operatorSign = "/";
        return temp;
    }

    private static Operations addition()
    {
        Operations temp = new Operations();
        temp.order = 2;
        temp.operatorSign = "+";
        return temp;
    }

    private static Operations subtraction()
    {
        Operations temp = new Operations();
        temp.order = 2;
        temp.operatorSign = "-";
        return temp;
    }

    private static Operations power()
    {
        Operations temp = new Operations();
        temp.order = 0;
        temp.operatorSign = "^";
        return temp;
    }

    private static Operations sqrRoot()
    {
        Operations temp = new Operations();
        temp.order = 0;
        temp.operatorSign = "sqrt";
        return temp;
    }

    @Override
    public int compareTo(Operations o)
    {
        return order - o.order;
    }

    public String toString()
    {
        return operatorSign;
    }
}
