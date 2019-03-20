package ch.iterial.recrutment.java.expressions.map_reduce.reducers;

import ch.iterial.recrutment.java.expressions.map_reduce.mappers.AddExpressionMapper;

import java.util.Iterator;

public class AddExpressionReducer implements Reducer<AddExpressionMapper, Double> {
    @Override
    public synchronized Double reduce(AddExpressionMapper addExpressionMapper) {
        double d = 0;
        final Iterator<String> valueIterator = addExpressionMapper.keySet().iterator();
        while (valueIterator.hasNext()) {
            final String key = valueIterator.next();
            d += (Double.valueOf(key) * addExpressionMapper.get(key));
        }
        return d;
    }
}
