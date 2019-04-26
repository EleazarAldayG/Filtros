package filters;

import java.io.*;

public class Step3 extends PipeFilter {

    public Step3(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }

    public void filter(Reader inputReader, Writer outputWriter) throws IOException {

    }
}
