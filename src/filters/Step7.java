package filters;

import java.io.*;

/**
 *
 * @author eleaz
 */
public class Step7 extends PipeFilter {

    public Step7(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }

    public void filter(BufferedReader inputReader, Writer outputWriter) throws IOException {
        System.out.println("Step 7");
        outputWriter.flush();
        System.out.println("Acabo step7");
    }
}
