package ch.iterial.recrutment.java.expressions.map_reduce.reducers;

import ch.iterial.recrutment.java.expressions.utils.containers.KeyContainer;
import ch.iterial.recrutment.java.expressions.utils.factories.ReducerFactory;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.*;

import java.util.Iterator;
import java.util.List;

public class FileReducer implements Reducer<FileMapper, Double> {
    @Override
    public synchronized Double reduce(FileMapper fileMapper) {
        double d = 0;
        final Iterator<String> keyIterator = fileMapper.keySet().iterator();
        final List<ContentMapper> contentMapperList = fileMapper.getNextMapperList();
        KeyContainer.clear();
        for (ContentMapper contentMapper:contentMapperList) {
            final ContentReducer contentReducer = ReducerFactory.getContentReducer();
            final double key = contentReducer.reduce(contentMapper);
            KeyContainer.add(key);
        }
        while (keyIterator.hasNext()) {
            final String key = keyIterator.next();
            d += KeyContainer.evaluate() * fileMapper.get(key);
        }
        KeyContainer.clear();
        return d;
    }
}
