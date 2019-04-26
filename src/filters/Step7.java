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

    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[300];
        char[] buffer2 = new char[300];
        int chars, index = 0, openBlockComments = 0;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if (buffer[i] == 47 && buffer[i + 1] == 42) {
                    openBlockComments++;
                    i++;
                    index++;
                    for (int x = i; openBlockComments != 0; x++) {
                        i++;
                        index++;
                        if (buffer[x] == 47 && buffer[x + 1] == 42) {
                            openBlockComments++;
                        }
                        if (buffer[x] == 42 && buffer[x + 1] == 47) {
                            openBlockComments--;
                        }
                    }
                    //These +3 are used to ignore the remaining chars, the CR and the LF
                    i += 3;
                    index += 3;
                }
                buffer2[i - index] = buffer[i];
            }
            outputWriter.write(buffer2, 0, chars);
        }
    }
    
    

}
