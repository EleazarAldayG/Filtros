package filters;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eleaz
 */
public class FiltersProgram {

    public static void main(String[] args) throws IOException {
        URL path = Step1.class.getResource("Source.txt");
        File f = new File(path.getFile());
        Writer outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader inputReader = new BufferedReader(new FileReader(f));
        LastPipeWriter lastPipe = new LastPipeWriter(outputWriter);
        PipeFilter step7Filter = new Step7(lastPipe);
        PipeFilter step1Filter = new Step1(step7Filter);
        PipeSource source = new PipeSource(step1Filter, inputReader);
        source.startThisPipe();
        System.out.println(inputReader.readLine());
        try {
            source.joinPipe();
        } catch (InterruptedException e) {}
    }

}
