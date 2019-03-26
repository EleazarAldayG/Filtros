package filters;

import java.io.*;

public class Step1 extends PipeFilter {

    String line;

    public Step1(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }

    public void filter(BufferedReader inputReader, Writer outputWriter) throws IOException {
        System.out.println("Step 1");
        System.out.println(inputReader.readLine());
    }

}
