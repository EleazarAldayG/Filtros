package filters;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author eleaz
 */
public class PipeSource extends Pipe {

    public Reader inputReader;

    public PipeSource(Pipe nextPipe, Reader inputReader) throws IOException {
        super(nextPipe);
        this.inputReader = inputReader;
    }

    public void run() {
        try {
            char[] buffer = new char[1024];
            int charRead;
            while ((charRead = inputReader.read(buffer)) != -1) {
                outputWriter.write(buffer, 0, charRead);
            }
        } catch (IOException e) {
        } finally {
            try {
                inputReader.close();
                outputWriter.close();
            } catch (IOException e) {
            }
        }
    }

    @Override
    public PipedReader getReader() {
        throw new Error("Can't find a source");
    }

}
