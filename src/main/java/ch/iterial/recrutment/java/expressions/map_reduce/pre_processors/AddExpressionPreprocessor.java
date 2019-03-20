package ch.iterial.recrutment.java.expressions.map_reduce.pre_processors;

public class AddExpressionPreprocessor extends AbstractPreProcessor {

    public AddExpressionPreprocessor(String[] preProcessed, String process) {
        super(preProcessed, process);
    }

    public AddExpressionPreprocessor(String process) {
        super(process);
    }

    public AddExpressionPreprocessor(String[] preProcessed) {
        super(preProcessed);
    }

    @Override
    public synchronized void preProcess() {
        //empty method
    }
}
