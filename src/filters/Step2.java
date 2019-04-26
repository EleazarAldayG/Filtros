package filters;

import java.io.*;

public class Step2 extends PipeFilter {

    public Step2(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }
    //Removes empty lines from a file e.g. lines which have only the new line character.
    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[300];
        char[] buffer2 = new char[300];
        int chars, index = 0, value = 10;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if (buffer[i] == 13) {
                    for (int x = i; buffer[x - 1] == value; x--) {
                        //These pair of conditions will remove repeated CR and the LF
                        if (value == 13) {
                            value = 10;
                        }
                        if (value == 10) {
                            value = 13;
                        }
                        buffer2[x - 1] = buffer2[x];
                        index++;
                    }
                }
                buffer2[i - index] = buffer[i];
            }
            outputWriter.write(buffer2, 0, chars);
        }

    }
}
