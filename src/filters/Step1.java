package filters;

import java.io.*;

public class Step1 extends PipeFilter {

    public Step1(Pipe nextPipe) throws IOException {
        super(nextPipe);
    }
/*
    For this program, a word is taken as any amount of letters separated by whitespaces.
    This program calculates the number of chars, white spaces, words and lines ‘from a file’.
*/
    public void filter(Reader inputReader, Writer outputWriter) throws IOException {
        char[] buffer = new char[1024];
        int chars, counter = 0, spaces = 0, lines = 0, words = 0;
        while ((chars = inputReader.read(buffer)) != -1) {
            for (int i = 0; i < chars; i++) {
                if (buffer[i] == 10) {
                    lines++;
                }
                if (buffer[i] == 32) {
                    spaces++;
                }
                if (Character.isLetter(buffer[i])) {
                    if (buffer[(i + 1)] == 10 || buffer[(i + 1)] == 32) {
                        words++;
                    }
                }
                counter = (i + 1);
                if (i == (chars - 1)) {
                    System.out.println("Chars: " + counter);
                    System.out.println("Whitespaces: " + spaces);
                    System.out.println("Lines: " + lines);
                    System.out.println("Words: " + words);
                }
            }
            outputWriter.write(buffer, 0, chars);
        }

    }
}
