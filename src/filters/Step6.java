package filters;

import java.io.*;

public class Step6 extends PipeFilter {

    public Step6(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }

    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[300];
        char[] buffer2 = new char[300];
        int chars, index = 0;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if (buffer[i] == 47 && buffer[i + 1] == 47) {
                    for (int x = i; buffer[x + 1] != 10; x++) {
                        i++;
                        index++;
                    }
                    //These +2 are used to ignore the last two remaining chars in a one-line comment, the CR and the LF
                    i+=2; index+=2;
                }
                buffer2[i - index] = buffer[i];
            }
            outputWriter.write(buffer2, 0, chars);
        }
    }
}
