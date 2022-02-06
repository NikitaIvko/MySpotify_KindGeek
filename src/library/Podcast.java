package library;

import artists.Artist;
import library.interfaces.SubtitleAble;
import library.interfaces.VideoAble;

import java.io.File;

//This class represents one of the products - podcast. It can have a video and/or subtitles, in this case the link to the video and/or subtitles must be added through the specific constructor.
// Or it can have neither video, nor subtitles - there is a separate constructor for this case as well
public class Podcast extends Product implements SubtitleAble, VideoAble {

    private String linkToTheVideoFile;
    private File videoFile;
    private String linkToTheSubtitles;
    private File subtitlesFile;

    //This constructor is used when the podcast has both video and subtitles
    //Constructor creates a File subtitlesFile using the String linkToTheSubtitles
    //Also, constructor creates a File videoFile using the String linkToTheVideoFile
    public Podcast(Artist artist, String nameOfTheProduct, String linkToTheAudioFile, String linkToTheVideoFile, String linkToTheSubtitles) {
        super(artist, nameOfTheProduct, linkToTheAudioFile);
        this.linkToTheVideoFile = linkToTheVideoFile;
        videoFile = new File(linkToTheVideoFile);
        this.linkToTheSubtitles = linkToTheSubtitles;
        subtitlesFile = new File(linkToTheSubtitles);
    }

    //This constructor is used when the podcast doesn`t have subtitles - only audio and video
    public Podcast(Artist artist, String nameOfTheProduct, String linkToTheAudioFile, String linkToTheVideoFile) {
        super(artist, nameOfTheProduct, linkToTheAudioFile);
        this.linkToTheVideoFile = linkToTheVideoFile;
        videoFile = new File(linkToTheVideoFile);
    }

    //This constructor is used when the podcast doesn`t have neither subtitles, nor video
    public Podcast(Artist artist, String nameOfTheProduct, String linkToTheAudioFile) {
        super(artist, nameOfTheProduct, linkToTheAudioFile);
    }

    @Override
    public File getSubtitlesFile() {
        return subtitlesFile;
    }

    @Override
    public String getLinkToTheSubtitles() {
        return linkToTheSubtitles;
    }

    @Override
    public void setLinkToTheSubtitles(String linkToTheSubtitles) {
        this.linkToTheSubtitles = linkToTheSubtitles;
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