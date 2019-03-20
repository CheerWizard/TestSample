package ch.iterial.recrutment.java.expressions.map_reduce.reducers;

import ch.iterial.recrutment.java.expressions.utils.containers.KeyContainer;
import ch.iterial.recrutment.java.expressions.utils.factories.ReducerFactory;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.AddExpressionMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.ExpressionMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.MultiplyExpressionMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.ContentMapper;

import java.util.Iterator;
import java.util.List;

public class ContentReducer implements Reducer<ContentMapper, Double> {
    @Override
    public synchronized Double reduce(ContentMapper contentMapper) {
        double d = 0;
        final Iterator<String> keyIterator = contentMapper.keySet().iterator();
        final List<ExpressionMapper> expressionMapperList = contentMapper.getNextMapperList();
        KeyContainer.clear();
        for (ExpressionMapper expressionMapper:expressionMapperList) {
            double key = 0;
            if (expressionMapper instanceof MultiplyExpressionMapper) {
                final MultiplyExpressionReducer multiplyExpressionReducer = ReducerFactory.getMultiplyExpressionReducer();
                key = multiplyExpressionReducer.reduce((MultiplyExpressionMapper) expressionMapper);
            }
            if (expressionMapper instanceof AddExpressionMapper) {
                final AddExpressionReducer addExpressionReducer = ReducerFactory.getAddExpressionReducer();
                key = addExpressionReducer.reduce((AddExpressionMapper) expressionMapper);
            }
            KeyContainer.add(key);
        }
        while (keyIterator.hasNext()) {
            final String key = keyIterator.next();
            d += KeyContainer.evaluate() * contentMapper.get(key);
        }
        KeyContainer.clear();
        return d;
    }
}
