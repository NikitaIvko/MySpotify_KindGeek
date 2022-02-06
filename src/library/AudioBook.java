package library;

import artists.Artist;
import library.interfaces.SubtitleAble;

import java.io.File;

//This class represents one of the products - Audiobook. It can have subtitles, in this case the link to this subtitles must be added through the constructor
public class AudioBook extends Product implements SubtitleAble {
    private String linkToTheSubtitles;
    private File subtitlesFile;

    //This constructor is used when the audiobook has subtitles
    //Constructor creates a File subtitlesFile using the String linkToTheSubtitles
    public AudioBook(Artist artist, String nameOfTheProduct, String linkToTheAudioFile, String linkToTheSubtitles) {
        super(artist, nameOfTheProduct, linkToTheAudioFile);
        this.linkToTheSubtitles = linkToTheSubtitles;
        subtitlesFile = new File(linkToTheSubtitles);
    }

    //This constructor is used when the audiobook doesn`t have subtitles
    public AudioBook(Artist artist, String nameOfTheProduct, String linkToTheAudioFile) {
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
}
