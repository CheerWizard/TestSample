package ch.iterial.recrutment.java.expressions.utils.writers;

import java.io.*;
import java.util.concurrent.TimeUnit;

public final class OutputWriter {

    private static String class_name = "Output Writer";

    public static synchronized void write(String content , String fileName) {
        final long start = System.nanoTime();
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            bufferedWriter.write(content);
            System.out.println(class_name);
            System.out.println("Written successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(class_name);
            System.out.println("Execution time : " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " milliseconds");
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
