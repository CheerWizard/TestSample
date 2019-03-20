package ch.iterial.recrutment.java.expressions.utils.containers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class KeyContainer {

    private static List<String> keyList = new LinkedList<>();

    public static void add(String key) {
        keyList.add(key);
    }

    public static void add(double key) {
        keyList.add(String.valueOf(key));
    }

    public static void addAll(String[] keys) {
        keyList.addAll(Arrays.asList(keys));
    }

    public static String get(int index) {
        return keyList.get(index);
    }

    public static void remove(int index) {
        keyList.remove(index);
    }

    public static boolean isEmpty() {
        return keyList.isEmpty();
    }

    public static String[] getKeys() {
        return keyList.toArray(new String[]{});
    }

    public static List<String> getKeyList() {
        return keyList;
    }

    public static void clear() {
        keyList.clear();
    }

    public static synchronized double evaluate() {
        double key = 0;
        for (String k:keyList) key = key + Double.valueOf(k);
        return key;
    }
}
