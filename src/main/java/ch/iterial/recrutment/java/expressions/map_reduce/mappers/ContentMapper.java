package ch.iterial.recrutment.java.expressions.map_reduce.mappers;

import ch.iterial.recrutment.java.expressions.utils.containers.KeyContainer;
import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.AddExpressionPreprocessor;
import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.ContentPreProcessor;
import ch.iterial.recrutment.java.expressions.utils.factories.MapperFactory;

import java.util.LinkedList;
import java.util.List;

public class ContentMapper extends AbstractMapper<ContentPreProcessor, ExpressionMapper , String> {

    public ContentMapper(ContentPreProcessor preProcessor) {
        super(preProcessor);
    }

    public ContentMapper(ContentPreProcessor preProcessor, List<ExpressionMapper> expressionMappers) {
        super(preProcessor, expressionMappers);
    }

    @Override
    public synchronized void map() {
        preProcessor.preProcess();
        final String[] content = preProcessor.getPreProcessed();
        nextMapperList = new LinkedList<>();
        for (String c:content) smartPut(c);
        for (String key:this.keySet()) {
            final String[] splitted = key.split("[+]");
            for (String c : splitted) {
                if (c.contains("*")) nextMapperList.add(MapperFactory.multiplyExpressionMapper(c));
                else KeyContainer.add(c);
            }
            if (KeyContainer.getKeys().length != 0) {
                final AddExpressionPreprocessor addExpressionPreprocessor = new AddExpressionPreprocessor(KeyContainer.getKeys());
                nextMapperList.add(new AddExpressionMapper(addExpressionPreprocessor));
            }
        }
    }
}
