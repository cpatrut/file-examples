import ro.ne8.binary.FileBinaryReader;
import ro.ne8.binary.FileBinaryWriter;
import ro.ne8.text.FileTextReader;
import ro.ne8.text.FileTextWriter;

public class App {

    private static final String FILE_TO_WRITE_AND_READ_FROM = "text-content.txt";
    private static final String BINARY_BIN = "binary.bin";

    public static void main(final String[] args) {
        final FileTextWriter fileTextWriter = new FileTextWriter();
        fileTextWriter.writeToFile(FILE_TO_WRITE_AND_READ_FROM);

        final FileTextReader fileTextReader = new FileTextReader();
        fileTextReader.readFromFile(FILE_TO_WRITE_AND_READ_FROM);

        final FileBinaryWriter fileBinaryWriter = new FileBinaryWriter();
        fileBinaryWriter.writeToFile(BINARY_BIN);

        final FileBinaryReader fileBinaryReader = new FileBinaryReader();
        fileBinaryReader.readFromFile(BINARY_BIN);
    }


}
