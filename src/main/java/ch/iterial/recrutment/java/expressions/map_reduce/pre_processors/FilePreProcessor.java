package ch.iterial.recrutment.java.expressions.map_reduce.pre_processors;

import ch.iterial.recrutment.java.expressions.utils.readers.DataLister;

public class FilePreProcessor extends AbstractPreProcessor {

    public FilePreProcessor(String process) {
        super(process);
    }

    public FilePreProcessor(String[] preProcessed, String process) {
        super(preProcessed, process);
    }

    @Override
    public synchronized void preProcess() {
        preProcessed = DataLister.listFilesFromFolder(process);
    }

}
