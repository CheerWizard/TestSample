package ch.iterial.recrutment.java.expressions;

public class AdditiveExpression implements Expression {

    private int sum;
    private Expression[] expressions;

    public AdditiveExpression(Expression... expressions) {
        this.expressions = expressions;
    }

    private AdditiveExpression() {
        //lock default constructor
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Expression[] getExpressions() {
        return expressions;
    }

    public void setExpressions(Expression[] expressions) {
        this.expressions = expressions;
    }

    @Override
    public int toInteger() {
        addition();
        return sum;
    }

    @Override
    public String format() {
        final String formattedExpressions = ExpressionFormatter.format(expressions);
        return "(+ " + formattedExpressions + ")";
    }

    private void addition() {
        sum = 0;
        for (Expression expression:expressions) sum = sum + expression.toInteger();
    }
}
