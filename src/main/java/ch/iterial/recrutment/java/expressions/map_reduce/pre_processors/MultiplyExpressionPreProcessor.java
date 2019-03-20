package ch.iterial.recrutment.java.expressions.map_reduce.pre_processors;

public class MultiplyExpressionPreProcessor extends AbstractPreProcessor {

    public MultiplyExpressionPreProcessor(String[] preProcessed, String process) {
        super(preProcessed, process);
    }

    public MultiplyExpressionPreProcessor(String process) {
        super(process);
    }

    @Override
    public synchronized void preProcess() {
        preProcessed = process.split("[*]");
    }
}
