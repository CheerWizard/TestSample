package ch.iterial.recrutment.java.expressions.utils.factories;

import ch.iterial.recrutment.java.expressions.map_reduce.mappers.AddExpressionMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.ContentMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.FileMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.MultiplyExpressionMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.AddExpressionPreprocessor;
import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.ContentPreProcessor;
import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.FilePreProcessor;
import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.MultiplyExpressionPreProcessor;

/**Factory that supports lazy initializing*/
public final class MapperFactory {

    public static synchronized ContentMapper contentMapper(String line) {
        return new ContentMapper(new ContentPreProcessor(line));
    }

    public static synchronized FileMapper fileMapper(String dataFolder) {
        return new FileMapper(new FilePreProcessor(dataFolder));
    }

    public static synchronized AddExpressionMapper addExpressionMapper(String expression) {
        return new AddExpressionMapper(new AddExpressionPreprocessor(expression));
    }

    public static synchronized MultiplyExpressionMapper multiplyExpressionMapper(String expression) {
        return new MultiplyExpressionMapper(new MultiplyExpressionPreProcessor(expression));
    }
}
