package ch.iterial.recrutment.java.expressions.map_reduce.reducers;

public interface Reducer<M , T> {
    T reduce(M m);
}
