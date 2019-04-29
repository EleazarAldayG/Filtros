package filters;

import java.io.*;

public class Step3 extends PipeFilter {

    public Step3(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }
    //Removes white spaces from the end of the lines (trialing white spaces) in a file.
    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[300];
        char[] buffer2 = new char[300];
        int chars, index = 0;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if (buffer[i] == 13) {
                    //This for removes carriage return at the end of line
                    for (int x = i; buffer[x - 1] == 13; x--) {
                        buffer2[x - 1] = buffer2[x];
                        index++;
                    }
                    //This for removes whitespaces at the end of a line
                    for (int x = i; buffer[x - 1] == 32 || buffer[x - 1] == 9 ; x--) {
                        buffer2[x - 1] = buffer2[x];
                        index++;
                    }
                } else {
                    buffer2[i - index] = buffer[i];
                }
            }
            outputWriter.write(buffer2, 0, chars);
        }
    }
}
