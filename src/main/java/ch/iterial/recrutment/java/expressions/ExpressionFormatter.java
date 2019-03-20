//package ch.iterial.recrutment.java.expressions;
//
//import ch.iterial.recrutment.java.expressions.models.Expression;
//
//public final class ExpressionFormatter {
//    public static synchronized String format(Expression... expressions) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < expressions.length; i++) {
//            if (i != expressions.length - 1) {
//                stringBuilder.append(expressions[i].format());
//                stringBuilder.append(" ");
//            }
//            else stringBuilder.append(expressions[i].format());
//        }
//        return stringBuilder.toString();
//    }
//}
