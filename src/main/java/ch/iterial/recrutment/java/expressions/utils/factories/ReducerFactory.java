package ch.iterial.recrutment.java.expressions.utils.factories;

import ch.iterial.recrutment.java.expressions.map_reduce.reducers.AddExpressionReducer;
import ch.iterial.recrutment.java.expressions.map_reduce.reducers.ContentReducer;
import ch.iterial.recrutment.java.expressions.map_reduce.reducers.FileReducer;
import ch.iterial.recrutment.java.expressions.map_reduce.reducers.MultiplyExpressionReducer;

public final class ReducerFactory {

    private static AddExpressionReducer addExpressionReducer;
    private static ContentReducer contentReducer;
    private static FileReducer fileReducer;
    private static MultiplyExpressionReducer multiplyExpressionReducer;

    public static synchronized AddExpressionReducer getAddExpressionReducer() {
        if (addExpressionReducer == null) addExpressionReducer = new AddExpressionReducer();
        return addExpressionReducer;
    }

    public static synchronized ContentReducer getContentReducer() {
        if (contentReducer == null) contentReducer = new ContentReducer();
        return contentReducer;
    }

    public static synchronized FileReducer getFileReducer() {
        if (fileReducer == null) fileReducer = new FileReducer();
        return fileReducer;
    }

    public static synchronized MultiplyExpressionReducer getMultiplyExpressionReducer() {
        if (multiplyExpressionReducer == null) multiplyExpressionReducer = new MultiplyExpressionReducer();
        return multiplyExpressionReducer;
    }
}
