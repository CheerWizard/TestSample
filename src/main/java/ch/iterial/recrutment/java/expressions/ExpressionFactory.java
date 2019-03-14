package ch.iterial.recrutment.java.expressions;

public final class ExpressionFactory {

    public static synchronized Expression literal(final int value) {
        return new LiteralExpression(value);
    }

    public static synchronized Expression add(final Expression... expressions) {
        return new AdditiveExpression(expressions);
    }

    public static synchronized Expression multiply(final Expression... expressions) {
        return new MultiplicativeExpression(expressions);
    }

}
