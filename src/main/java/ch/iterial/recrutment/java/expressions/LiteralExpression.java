package ch.iterial.recrutment.java.expressions;

/**The expression class , that plays main role in expression implementation*/
//TODO in future it is better to make several constructors for making this class more flexible ,
    //TODO as I think this class should returns not only integer value , but other various types too...
public class LiteralExpression implements Expression {

    private int value;

    public LiteralExpression(int value) {
        this.value = value;
    }

    public LiteralExpression() {
        //default constructor
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public String format() {
        return toString();
    }
}
