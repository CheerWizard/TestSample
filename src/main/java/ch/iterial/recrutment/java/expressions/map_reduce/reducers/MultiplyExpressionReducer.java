package ch.iterial.recrutment.java.expressions.map_reduce.reducers;

import ch.iterial.recrutment.java.expressions.map_reduce.mappers.MultiplyExpressionMapper;

import java.util.Iterator;

public class MultiplyExpressionReducer implements Reducer<MultiplyExpressionMapper, Double> {
    @Override
    public synchronized Double reduce(MultiplyExpressionMapper multiplyExpressionMapper) {
        double d = 1;
        final Iterator<String> keyIterator = multiplyExpressionMapper.keySet().iterator();
        while (keyIterator.hasNext()) {
            final String key = keyIterator.next();
            d *= Math.pow(Double.parseDouble(key), multiplyExpressionMapper.get(key));
        }
        return d;
    }
}
