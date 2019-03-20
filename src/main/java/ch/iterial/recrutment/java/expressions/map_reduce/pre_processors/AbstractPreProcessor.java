package ch.iterial.recrutment.java.expressions.map_reduce.pre_processors;

import ch.iterial.recrutment.java.expressions.utils.containers.KeyContainer;

public abstract class AbstractPreProcessor {

    protected String[] preProcessed;
    protected String process;

    protected AbstractPreProcessor(String[] preProcessed, String process) {
        this.preProcessed = preProcessed;
        this.process = process;
    }

    protected AbstractPreProcessor(String process) {
        this.process = process;
    }

    protected AbstractPreProcessor(String[] preProcessed) {
        this.preProcessed = preProcessed;
    }

    public String[] getPreProcessed() {
        return preProcessed;
    }

    public void setPreProcessed(String[] preProcessed) {
        this.preProcessed = preProcessed;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public abstract void preProcess();

    protected void addForOtherExpressionsToContainer(String key) {
        KeyContainer.clear();
        KeyContainer.add(key);
    }
}
