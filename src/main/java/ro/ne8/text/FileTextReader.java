package ro.ne8.text;

import java.io.*;

public class FileTextReader {

    public void readFromFile(final String fileName) {
        final File file = new File(fileName);

        final FileReader fileReader = getFileReaderForFile(file);
        final BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = tryToReadLine(bufferedReader);
        while (line != null) {
            System.out.println("Content: " + line);
            line = tryToReadLine(bufferedReader);
        }
        tryToCloseFile(bufferedReader);
    }

    private void tryToCloseFile(final BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private String tryToReadLine(final BufferedReader bufferedReader) {
        try {
            return bufferedReader.readLine();
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private FileReader getFileReaderForFile(final File file) {
        try {
            return new FileReader(file);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
