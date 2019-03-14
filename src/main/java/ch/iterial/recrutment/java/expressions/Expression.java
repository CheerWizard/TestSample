package ch.iterial.recrutment.java.expressions;

public interface Expression {
    /**In any situation , this method will always returns the result of expression*/
    int toInteger();
    /**The method , which returns the string form of appropriate expression*/
    String format();
}
