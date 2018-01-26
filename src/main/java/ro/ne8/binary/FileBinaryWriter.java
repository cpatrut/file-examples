package ro.ne8.binary;

import java.io.*;

public class FileBinaryWriter {

    public void writeToFile(final String fileName) {
        final File file = new File(fileName);
        if (!file.exists()) {
            tryToCreateFile(file);
        }

        final FileOutputStream fileOutputStream = getFileOutputStream(file);

        final DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        final int intValue = 10;
        final float floatValue = 23.3f;
        final String stringValue = "This is a string value test";
        try {
            dataOutputStream.writeInt(intValue);
            dataOutputStream.writeUTF(stringValue);
            dataOutputStream.writeFloat(floatValue);

        } catch (final IOException e) {
            e.printStackTrace();
        }
        tryToCloseFile(dataOutputStream);
    }

    private void tryToCloseFile(final DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private FileOutputStream getFileOutputStream(final File file) {
        try {
            return new FileOutputStream(file);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void tryToCreateFile(final File file) {
        try {
            file.createNewFile();
        } catch (final IOException e) {
            System.out.println("couldn't create new file");
            e.printStackTrace();
        }
    }
}
