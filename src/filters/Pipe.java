package filters;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 *
 * @author eleaz
 */
public class Pipe extends Thread {

    public PipedReader inputReader = null;
    public PipedWriter outputWriter = null;
    public Pipe nextPipe = null;

    public Pipe() {
        super();
    }

    public Pipe(Pipe nextPipe) throws IOException{
        this.nextPipe = nextPipe;
        outputWriter = new PipedWriter();
        outputWriter.connect(nextPipe.getReader());
    }

    public void startThisPipe() {
        if (nextPipe != null) {
            nextPipe.startThisPipe();
        }
        this.start();
    }

    public void joinPipe() throws InterruptedException { 
      if (nextPipe != null){
          nextPipe.joinPipe();
      } 
      this.join(); 
    }
    
    public PipedReader getReader(){
        if(inputReader == null){
            inputReader = new PipedReader();
        }
        return inputReader;
    }
}