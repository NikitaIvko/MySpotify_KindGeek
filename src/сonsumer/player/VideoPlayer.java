package сonsumer.player;

import java.io.*;

public class VideoPlayer implements Runnable {
    private File videoFile;
    private Thread thread;

    public VideoPlayer(File videoFile) {
        this.videoFile = videoFile;
        thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public void run(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(videoFile))) {
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
