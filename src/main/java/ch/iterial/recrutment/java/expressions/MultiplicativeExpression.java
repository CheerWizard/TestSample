package ch.iterial.recrutment.java.expressions;

public class MultiplicativeExpression implements Expression {

    private int multiplication;
    private Expression[] expressions;

    public MultiplicativeExpression(Expression... expressions) {
        this.expressions = expressions;
    }

    private MultiplicativeExpression() {
        //lock default constructor
    }

    public int getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(int multiplication) {
        this.multiplication = multiplication;
    }

    public Expression[] getExpressions() {
        return expressions;
    }

    public void setExpressions(Expression[] expressions) {
        this.expressions = expressions;
    }

    @Override
    public int toInteger() {
        multiply();
        return multiplication;
    }

    @Override
    public String format() {
        final String formattedExpressions = ExpressionFormatter.format(expressions);
        return "(* " + formattedExpressions + ")";
    }

    private void multiply() {
        multiplication = 1;
        for (Expression expression:expressions) multiplication = multiplication * expression.toInteger();
    }
}
