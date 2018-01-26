package ro.ne8.binary;

import java.io.*;

public class FileBinaryReader {

    public void readFromFile(final String fileName) {
        final File file = new File(fileName);
        final FileInputStream fileInputStream = tryToGetFileInputStream(file);
        final DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        try {
            final int intValue = dataInputStream.readInt();
            final String stringValue = dataInputStream.readUTF();
            final float floatValue = dataInputStream.readFloat();
            System.out.println("int value: " + intValue + ", string value:" + stringValue + ", floatValue:" + floatValue);
        } catch (final IOException ex) {
            ex.printStackTrace();
        }

    }

    private FileInputStream tryToGetFileInputStream(final File file) {
        try {
            return new FileInputStream(file);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
