package сonsumer.player;

import java.io.*;

public class AudioPlayer implements Runnable {
    private File audioFile;
    private Thread thread;

    public AudioPlayer(File audioFile) {
        this.audioFile = audioFile;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public void run(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(audioFile))) {
            while (bufferedReader.ready()) {
                while (!thread.isInterrupted()){
                    System.out.println(bufferedReader.readLine());
                    Thread.sleep(1000);}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
