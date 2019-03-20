package ch.iterial.recrutment.java.expressions.map_reduce.mappers;

import java.util.HashMap;
import java.util.List;

public abstract class AbstractMapper<Processor , NextMapper , K> extends HashMap<K , Integer> {

    protected Processor preProcessor;
    protected List<NextMapper> nextMapperList;

    public AbstractMapper(Processor preProcessor) {
        this.preProcessor = preProcessor;
        map();
    }

    public AbstractMapper(Processor preProcessor, List<NextMapper> nextMapperList) {
        this.preProcessor = preProcessor;
        this.nextMapperList = nextMapperList;
    }

    public List<NextMapper> getNextMapperList() {
        return nextMapperList;
    }

    public void setNextMapperList(List<NextMapper> nextMapperList) {
        this.nextMapperList = nextMapperList;
    }

    public Processor getPreProcessor() {
        return preProcessor;
    }

    public void setPreProcessor(Processor preProcessor) {
        this.preProcessor = preProcessor;
    }

    public abstract void map();

    protected void smartPut(K k) {
        if (super.containsKey(k)) {
            final int count = get(k);
            replace(k , count + 1);
        }
        else put(k , 1);
    }
}
