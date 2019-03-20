package ch.iterial.recrutment.java.expressions.map_reduce.mappers;

import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.AddExpressionPreprocessor;
import ch.iterial.recrutment.java.expressions.models.LiteralExpression;

public class AddExpressionMapper extends AbstractMapper<AddExpressionPreprocessor, LiteralExpression, String> implements ExpressionMapper {

    public AddExpressionMapper(AddExpressionPreprocessor preProcessor) {
        super(preProcessor);
    }

    @Override
    public void map() {
        preProcessor.preProcess();
        final String[] expressions = preProcessor.getPreProcessed();
        for (String s : expressions) smartPut(s);
    }
}
