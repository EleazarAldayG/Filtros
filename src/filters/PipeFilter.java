package filters;

import java.io.*;

/**
 *
 * @author eleaz
 */
public abstract class PipeFilter extends Pipe{
    
    BufferedReader inReader;
    public PipeFilter(Pipe nextPipe) throws IOException{
        super(nextPipe);
    }
    
    abstract public void filter(Reader inReader, Writer outputWriter) throws IOException;
    
    public void run() {
      try { filter(inReader, outputWriter); } 
      catch (IOException e) {}
      finally { try { inputReader.close(); outputWriter.close(); } catch (IOException e) {} }
    }

}
