package ch.iterial.recrutment.java.expressions.models;

/**The expression class , that plays main role in expression implementation*/
public class LiteralExpression implements Expression {
    //primary key
    private int id;
    //value
    private String value;

    public LiteralExpression() {
        //default constructor
    }

    public LiteralExpression(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj ||
                obj != null && getClass() == obj.getClass() ||
                this.hashCode() == obj.hashCode());
    }

    @Override
    public String evaluate() {
        return value;
    }

    @Override
    public String format() {
        return toString();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
