package filters;

import java.io.*;

public class Step5 extends PipeFilter {

    public Step5(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }

    //Removes one white space chars from a file.
    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[300];
        char[] buffer2 = new char[300];
        int chars;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if (buffer[i] == 32  || buffer[i] == 9) {
                    continue;
                }
                buffer2[i] = buffer[i];
            }
            outputWriter.write(buffer2, 0, chars);
        }
    }
}
