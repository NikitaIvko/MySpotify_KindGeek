package library.interfaces;

import java.io.File;

public interface SubtitleAble {
    File getSubtitlesFile();

    String getLinkToTheSubtitles();

    void setLinkToTheSubtitles(String linkToTheSubtitles);
}
