package filters;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author eleaz
 */
public class LastPipeWriter extends Pipe {

    public Writer outputWriter;

    public LastPipeWriter(Writer outputWriter) throws IOException {
        super();
        this.outputWriter = outputWriter;
    }

    public void run() {
        try {
            char[] buffer = new char[1024];
            int chars_read;
            while ((chars_read = inputReader.read(buffer)) != -1) {
                outputWriter.write(buffer, 0, chars_read);
            }
        } catch (IOException e) {
        } finally {
            try {
                inputReader.close();
                outputWriter.flush();
            } catch (IOException e) {
            }
        }

    }

}
