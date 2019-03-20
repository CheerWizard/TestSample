package ch.iterial.recrutment.java.expressions.utils.factories;

import ch.iterial.recrutment.java.expressions.models.*;

public final class ExpressionFactory {

    public static synchronized Expression literal(final int id , final String key) {
        return new LiteralExpression(id , key);
    }
}
