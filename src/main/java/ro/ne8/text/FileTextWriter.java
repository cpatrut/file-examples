package ro.ne8.text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileTextWriter {

    public void writeToFile(final String fileName) {
        final File file = new File(fileName);

        if (!file.exists()) {
            tryToCreateFile(file);
        }

        final FileWriter fileWriter = getFileWriter(file, false);

        final PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Printing first line");
        printWriter.println("This is a secret message in line 3");
        printWriter.println("This is third line");
        printWriter.close();

    }

    private void tryToCreateFile(final File file) {
        try {
            file.createNewFile();
        } catch (final IOException e) {
            System.out.println("couldn't create new file");
            e.printStackTrace();
        }
    }

    private FileWriter getFileWriter(final File file, final boolean appendToFile) {
        try {
            return new FileWriter(file, appendToFile);
        } catch (final IOException e) {
            System.out.println("cannot get new instance of FileWriter");
            e.printStackTrace();
        }
        return null;
    }
}
