package library;

import artists.Artist;
import library.interfaces.VideoAble;

import java.io.File;

//This class represents one of the products - song. It can have a music video, in this case the link to this video must be added through the constructor
public class Song extends Product implements VideoAble {

    private String linkToTheVideoFile;
    private File videoFile;

    //This constructor is used when the song doesn`t have a music video
    public Song(Artist artist, String nameOfTheProduct, String linkToTheAudioFile) {
        super(artist, nameOfTheProduct, linkToTheAudioFile);
    }

    //This constructor is used when the song have a music video. Constructor creates a File videoFile using the String linkToTheVideoFile
    public Song(Artist artist, String nameOfTheProduct, String linkToTheAudioFile, String linkToTheVideoFile) {
        super(artist, nameOfTheProduct, linkToTheAudioFile);
        this.linkToTheVideoFile = linkToTheVideoFile;
        videoFile = new File(linkToTheVideoFile);
    }

    @Override
    public File getVideoFile() {
        return videoFile;
    }

    @Override
    public String getLinkToTheVideoFile() {
        return linkToTheVideoFile;
    }

    @Override
    public void setLinkToTheVideoFile(String linkToTheVideoFile) {
        this.linkToTheVideoFile = linkToTheVideoFile;
    }
}