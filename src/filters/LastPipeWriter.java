package filters;

import java.io.*;

/**
 *
 * @author eleaz
 */
public class LastPipeWriter extends Pipe {

    public Writer outWriter;

    public LastPipeWriter(Writer outputWriter) throws IOException {
        super();
        this.outWriter = outputWriter;
    }

    public void runWriter() {
        try {
            inputReader.close();
            outWriter.flush();
        } catch (IOException e) {
        }
    }

}
