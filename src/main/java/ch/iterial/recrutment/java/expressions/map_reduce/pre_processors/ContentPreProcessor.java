package ch.iterial.recrutment.java.expressions.map_reduce.pre_processors;

public class ContentPreProcessor extends AbstractPreProcessor {

    public ContentPreProcessor(String[] preProcessed, String process) {
        super(preProcessed, process);
    }

    public ContentPreProcessor(String process) {
        super(process);
    }

    @Override
    public synchronized void preProcess() {
        StringBuilder stringBuilder = new StringBuilder();
        //making correction
        for (String s:process.split(" ")) stringBuilder.append(s);
        process = stringBuilder.toString();
        //split in lines
        preProcessed = process.split(";");
    }
}
