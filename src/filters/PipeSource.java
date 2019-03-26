package filters;

import java.io.*;
/**
 *
 * @author eleaz
 */
public class PipeSource extends Pipe{
    public Reader inReader;
    
    public PipeSource(Pipe nextPipe, BufferedReader inputReader) throws IOException{
        super(nextPipe);
        this.inReader = inputReader;
    }
    public void run() {
      try { 
        inReader.close(); 
        outputWriter.close(); } 
      catch (IOException e) {}
    }

    @Override
    public PipedReader getReader() {
      throw new Error("Can't find a source");
    }

}
