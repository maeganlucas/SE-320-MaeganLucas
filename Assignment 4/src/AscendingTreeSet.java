/** Author: Maegan Lucas
 *  AscendingTreeSet.java
 *  Assignment 4
 *  November 17, 2023
 *  SE 320 - Software Construction
 *  Dr. Akbas
 *
 *  References:
 *  [1] “Java Read Files,” Java read files, https://www.w3schools.com/java/java_files_read.asp (accessed Nov. 17, 2023).
 *  [2] “Get the filepath from filename using Java,” Stack Overflow,
 *      https://stackoverflow.com/questions/13509822/get-the-filepath-from-filename-using-java (accessed Nov. 17, 2023).
 *  Reads from a text file, words.txt, and displays the words from the text file, without duplicates, in ascending order.
 **/

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.TreeSet;

public class AscendingTreeSet {

    public static void main(String[] args) {
        TreeSet<String> words = new TreeSet<>();
        try {
            words = createTree();
        } catch (IOException e){
            System.out.println("Error: File of words not found.");
        }

        for (String word : words) {
            System.out.println(word);
        }
    }

    /**
     * Method: createTree
     * @return A TreeSet, words, of the words contained in the words.txt file.
     * @throws IOException
     */
    public static TreeSet<String> createTree() throws IOException {
        TreeSet<String> words = new TreeSet<>();
        Path path = FileSystems.getDefault().getPath(new String()).toAbsolutePath();
        File wordsFile = new File(path + "/words.txt");
        boolean read = wordsFile.canRead();
        Scanner scanner = new Scanner(wordsFile);
        while(scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();
        return words;
    }
}
