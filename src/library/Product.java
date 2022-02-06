package library;

import artists.Artist;

import java.io.File;

//This abstract class describes the product on this platform in general.
// Since it is an audio stream platform, all products must have an audio file - it is represented by the object File AudioFile.
// File AudioFile is created automatically in the constructor, based on the link to this file in the String linkToTheAudioFile.
// If the product has also video file or subtitle file, it must implement interfaces Videoable and/or Subtitleable.
// Also, this class contains some ID information about the product: the name and the Artist.
// Also, we are keeping track on some statistical information: playCount, downloadsCount. They are updated automatically after each play or download.
public abstract class Product {
    private int playCount;
    private int downloadsCount;
    private Artist artist;
    private String nameOfTheProduct;
    private int likesCount;
    private String linkToTheAudioFile;
    private File AudioFile;


    //Constructor automatically adds the Product into the list ListOfAllProducts and into the map MapOfProductsAndArtists.
    // Also, constructor creates a File MusicFile using the String linkToTheMusicFile
    public Product(Artist artist, String nameOfTheProduct, String linkToTheAudioFile) {
        this.artist = artist;
        this.nameOfTheProduct = nameOfTheProduct;
        this.linkToTheAudioFile = linkToTheAudioFile;
        Library.addProductToTheListOfAllProducts(this);
        Library.addProductToTheMapOfProductsAndArtists(this);
        AudioFile = new File(linkToTheAudioFile);
    }

    public String getNameOfTheProduct() {
        return nameOfTheProduct;
    }

    public void setNameOfTheProduct(String nameOfTheProduct) {
        this.nameOfTheProduct = nameOfTheProduct;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void addOnePlayToThePlayCount() {
        this.playCount = this.playCount+1;
    }

    public void addOnePlayToTheDownloadsCount() {
        this.likesCount = this.likesCount+1;
    }

    public void addOneLikeToTheLikesCount() {
        this.downloadsCount = this.downloadsCount+1;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public File getAudioFile() {
        return AudioFile;
    }

    public String getLinkToTheAudioFile() {
        return linkToTheAudioFile;
    }

    public void setLinkToTheAudioFile(String linkToTheAudioFile) {
        this.linkToTheAudioFile = linkToTheAudioFile;
    }
}

