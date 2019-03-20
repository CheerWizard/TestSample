package ch.iterial.recrutment.java.expressions.map_reduce.mappers;

import ch.iterial.recrutment.java.expressions.map_reduce.pre_processors.FilePreProcessor;
import ch.iterial.recrutment.java.expressions.utils.factories.MapperFactory;

import java.util.LinkedList;

public class FileMapper extends AbstractMapper<FilePreProcessor, ContentMapper, String> {

    public FileMapper(FilePreProcessor preProcessor) {
        super(preProcessor);
    }

    @Override
    public synchronized void map() {
        //make corrections with data
        preProcessor.preProcess();
        final String[] content = preProcessor.getPreProcessed();
        nextMapperList = new LinkedList<>();
        for (String c:content) smartPut(c);
        for (String key:this.keySet()) nextMapperList.add(MapperFactory.contentMapper(key));
    }
}
