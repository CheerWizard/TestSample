package ch.iterial.recrutment.java.expressions.models;

public interface Expression {
    /**In any situation , this method will always returns the result of expression*/
    String evaluate();
    /**The method , which returns the string form of appropriate expression*/
    String format();
}
