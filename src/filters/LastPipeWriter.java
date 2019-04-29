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
            char[] buffer = new char[300];
            int chars;
            while ((chars = inputReader.read(buffer)) != -1) {
                System.out.println("Result:");
                outputWriter.write(buffer, 0, chars);
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
