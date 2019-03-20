package ch.iterial.recrutment.java.expressions.utils.readers;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**This is global class , that can read and return lines of all
 * files and folders from the inserted path of these resources*/
public final class DataLister {

    private static String class_name = "Data Lister";

    public static synchronized String[] listFilesFromFolder(final String folderDirectory) {
        final long start = System.nanoTime();
        List<String> data = new LinkedList<>();
        if (folderDirectory != null) {
            final File folder = new File(folderDirectory);
            if (folder.exists()) {
                for (final File fileEntry : folder.listFiles()) {
                    if (fileEntry.isDirectory()) listFilesFromFolder(fileEntry.getPath());
                    else {
                        DataReader.start(fileEntry);
                        data.add(DataReader.getText());
                    }
                }
            }
        }
        else throw new RuntimeException("The inputted directory does not exist!Please check your path to files...");
        System.out.println(class_name);
        System.out.println("Execution time : " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " milliseconds");
        return data.toArray(new String[]{});
    }

    private static class DataReader {

        private static String text;
        private static StringBuilder stringBuilder;

        private static synchronized void start(File file) {
            //simple init
            String line;
            BufferedReader bufferedReader = null;
            //lazy init
            lazyInit();
            //start reading process
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while((line = bufferedReader.readLine()) != null) stringBuilder.append(line);
                text += stringBuilder.toString();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                stringBuilder.delete(0 , stringBuilder.toString().length());
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private static String getText() {
            return text;
        }

        private static void lazyInit() {
            if (stringBuilder == null) stringBuilder = new StringBuilder();
            text = "";
        }
    }
}
