package filters;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
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
        Writer outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
        Reader inputReader = new BufferedReader(new FileReader(f));
        LastPipeWriter lastPipe = new LastPipeWriter(outputWriter);
        PipeFilter step7Filter = new Step7(lastPipe);
        PipeFilter step6Filter = new Step6(step7Filter);
        PipeFilter step5Filter = new Step5(step6Filter);
        PipeFilter step4Filter = new Step4(step5Filter);
        PipeFilter step3Filter = new Step3(step4Filter);
        PipeFilter step2Filter = new Step2(step3Filter);
        PipeFilter step1Filter = new Step1(step2Filter);
        PipeSource source = new PipeSource(step1Filter, inputReader);
        source.startThisPipe();
        try {
            source.joinPipe();
        } catch (InterruptedException e) {}
    }

}
