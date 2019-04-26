package filters;

import java.io.*;

public class Step2 extends PipeFilter {

    public Step2(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }

    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[300];
        char[] buffer2 = new char[300];
        int chars;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if (buffer[i] == 10 && buffer[(i + 1)] == 10) {
                    break;
                }
                buffer2[i] = buffer[i];
            }
        }

        while ((chars = inputReader.read(buffer2)) != -1) {
            outputWriter.write(buffer2, 0, chars);
        }

    }
}
