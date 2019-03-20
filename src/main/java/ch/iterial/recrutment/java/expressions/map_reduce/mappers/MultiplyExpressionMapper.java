package ch.iterial.recrutment.java.expressions.map_reduce.mappers;

import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.MultiplyExpressionPreProcessor;

import java.util.List;

public class MultiplyExpressionMapper extends AbstractMapper<MultiplyExpressionPreProcessor, ExpressionMapper , String> implements ExpressionMapper {

    public MultiplyExpressionMapper(MultiplyExpressionPreProcessor preProcessor) {
        super(preProcessor);
    }

    public MultiplyExpressionMapper(MultiplyExpressionPreProcessor preProcessor, List<ExpressionMapper> expressionMappers) {
        super(preProcessor, expressionMappers);
    }

    @Override
    public synchronized void map() {
        preProcessor.preProcess();
        final String[] expressions = preProcessor.getPreProcessed();
        for (String s : expressions) smartPut(s);
    }
}
