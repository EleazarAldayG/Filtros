package filters;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author eleaz
 */
public class PipeSource extends Pipe {

    public Reader inReader;

    public PipeSource(Pipe nextPipe, Reader inputReader) throws IOException {
        super(nextPipe);
        this.inReader = inputReader;
    }

    public void run() {
        System.out.println("Source");
        ArrayList<String> lines = new ArrayList();
        BufferedReader lineReader = new BufferedReader(inReader);
        try {
            String line = lineReader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = lineReader.readLine();
            }
        } catch (IOException e) {
        } finally {
            try {
                inReader.close();
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
