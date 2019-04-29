package filters;

import java.io.*;

public class Step4 extends PipeFilter {

    public Step4(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }
    //Removes consecutive white spaces (=more than one white space in a row) from a file, so that e.g. original 3 spaces are replaced with just one space.
    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[300];
        char[] buffer2 = new char[300];
        int chars, index = 0;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if ((buffer[i] == 32  || buffer[i] == 9) && (buffer[i - 1] == 32  || buffer[i - 1] == 9)) {
                    buffer2[i - 1 - index] = buffer[i];
                    index++;
                }
                buffer2[i - index] = buffer[i];
            }
            outputWriter.write(buffer2, 0, chars);
        }
    }
}
