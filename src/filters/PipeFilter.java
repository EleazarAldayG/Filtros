package filters;

import java.io.*;

/**
 *
 * @author eleaz
 */
public abstract class PipeFilter extends Pipe{
    
    public PipeFilter(Pipe nextPipe) throws IOException{
        super(nextPipe);
    }
    
    abstract public void filter(Reader inputReader, Writer outputWriter) throws IOException;
    
    public void run() {
      try { filter(inputReader, outputWriter); } 
      catch (IOException e) {}
      finally { try { inputReader.close(); outputWriter.close(); } catch (IOException e) {} }
    }

}
