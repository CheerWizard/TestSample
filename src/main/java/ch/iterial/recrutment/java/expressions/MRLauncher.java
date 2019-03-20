package ch.iterial.recrutment.java.expressions;

import ch.iterial.recrutment.java.expressions.constants.FileConstants;
import ch.iterial.recrutment.java.expressions.utils.factories.MapperFactory;
import ch.iterial.recrutment.java.expressions.utils.factories.ReducerFactory;
import ch.iterial.recrutment.java.expressions.map_reduce.mappers.FileMapper;
import ch.iterial.recrutment.java.expressions.map_reduce.reducers.FileReducer;
import ch.iterial.recrutment.java.expressions.utils.writers.OutputWriter;
/**MR - means Map - Reduce.
 * Plays core role in launching all program ,
 * calling several classes in appropriate sequence ,
 * to execute correctly.*/
public final class MRLauncher {
    public static synchronized void run(String resultFileName) {
        //ask factory to create mapper and give the data directory
        final FileMapper fileMapper =  MapperFactory.fileMapper(FileConstants.FILES_DIR);
        //ask factory to create reducer
        final FileReducer fileReducer = ReducerFactory.getFileReducer();
        //start reducing sequence with single file mapper
        final double value = fileReducer.reduce(fileMapper);
        //ask file writer class to write the result in single file
        OutputWriter.write(String.valueOf(value), resultFileName);
        //write the total result in console
        System.out.println("Total result :" + value);
    }
}
