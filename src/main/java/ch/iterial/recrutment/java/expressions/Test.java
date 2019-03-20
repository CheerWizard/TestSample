package ch.iterial.recrutment.java.expressions;

import ch.iterial.recrutment.java.expressions.constants.FileConstants;

/**Here I will demonstrate how to easy use
 * only one class and it's method to execute
 * all algorithm.*/
public class Test {

    public static void main(String[] args) {
        /**As you see , all what you need is only to enter your
         * specific path of data and actually , name of result file.
         * Enjoy it =)*/
        MRLauncher.run(FileConstants.FILES_DIR + "output.txt");
    }
}
