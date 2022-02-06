package сonsumer.player;

import java.io.*;

public class SubtitlePlayer implements Runnable {
    private File subtitlesFile;
    private Thread thread;

    public SubtitlePlayer(File subtitlesFile) {
        this.subtitlesFile = subtitlesFile;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public void run(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(subtitlesFile))) {
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
