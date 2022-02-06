package сonsumer;

import artists.Artist;
import library.Product;
import library.interfaces.SubtitleAble;
import library.interfaces.VideoAble;
import сonsumer.player.AudioPlayer;
import сonsumer.player.SubtitlePlayer;
import сonsumer.player.VideoPlayer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//This class represents a subscriber to the audio stream platform. Also, the multimedia player of this audio stream platform is operated through this class (start playing, stop playing).
// The type of subscription is changed through this class (downloading is available only for premium subscribers)
public class Subscriber {
    private String NameOfTheSubscriber;
    private boolean playingNow = false;
    private TypeOfSubscription typeOfSubscription = TypeOfSubscription.REGULAR;

    public Subscriber(String nameOfTheSubscriber) {
        NameOfTheSubscriber = nameOfTheSubscriber;
    }

    public void payForTheSubscription(){
        TypeOfSubscription typeOfSubscription = TypeOfSubscription.PREMIUM;
    }

    private AudioPlayer audioPlayer;
    private SubtitlePlayer subtitlePlayer;
    private VideoPlayer videoPlayer;


    //Method StartPlaying starts playing the product. In case the product has additional media (video and/or subtitles), method startPlaying will create separate threads
    // for each type of media and will automatically start all the threads
    public void startPlaying(Product product){
        if (this.playingNow == true){
            this.stopPlaying();
        }

        //creating object AudioPlayer automatically creates and starts the thread for the Audio of the product
        audioPlayer = new AudioPlayer(product.getAudioFile());

        //creating object SubtitlePlayer automatically creates and starts the thread for the subtitles of the product
        if (product instanceof SubtitleAble) {
            File subtitlesFile = ((SubtitleAble) product).getSubtitlesFile();
            if (subtitlesFile != null) {
                subtitlePlayer = new SubtitlePlayer(subtitlesFile);
            }
        }

        //creating object VideoPlayer automatically creates and starts the thread for the video of the product
        if(product instanceof VideoAble){
            File videoFile = ((VideoAble) product).getVideoFile();
            if (videoFile != null){
                videoPlayer = new VideoPlayer(videoFile);
            }
        }

        product.addOnePlayToThePlayCount();
        this.playingNow = true;

        System.out.println("The song " + product.getNameOfTheProduct() + " is playing");
    }

    // method stopPlaying stops all the threads playing multimedia
    public void stopPlaying (){
        if (audioPlayer.getThread().isAlive()){
        audioPlayer.getThread().interrupt();}
        if (subtitlePlayer.getThread().isAlive()){
        subtitlePlayer.getThread().interrupt();}
        if (videoPlayer.getThread().isAlive()){
        videoPlayer.getThread().interrupt();}
        this.playingNow = false;
    }


    //downloadTheSong downloads the audio of the product to the destination specified in the parameter
    public void downloadTheSong(Product product, String linkToTheDownloadDestination){
        if (typeOfSubscription == TypeOfSubscription.REGULAR){
            System.out.println("Sorry, you cannot download songs with your type of subscription. Consider upgrading.");
            return;
        }
        else {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(product.getAudioFile()));
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(linkToTheDownloadDestination))) {
                while(bufferedInputStream.available()>0)
                bufferedOutputStream.write(bufferedInputStream.read());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("The song " + product.getNameOfTheProduct() + " is downloaded");
            product.addOnePlayToTheDownloadsCount();
        }}

    public void likeTheArtist(Artist artist){
        artist.addOneLikeToTheLikesCount();
    }

    private List <Product> personalProductLibrary = new ArrayList<>();

    public void likeTheProduct(Product product){
        product.addOneLikeToTheLikesCount();
        personalProductLibrary.add(product);
    }
}