package artists;

import library.Library;

//This class represents Artists, which are creating Products on this audio stream platform.
public class Artist {
    String nameOfTheArtist;
    private int likesCount;

    //Constructor automatically adds the Artist into the set SetOfArtists.
    public Artist(String nameOfTheArtist) {
        this.nameOfTheArtist = nameOfTheArtist;
        Library.addArtistToTheSetOfArtists(this);
    }

    public String getNameOfTheArtist() {
        return nameOfTheArtist;
    }

    public void setNameOfTheArtist(String nameOfTheArtist) {
        this.nameOfTheArtist = nameOfTheArtist;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void addOneLikeToTheLikesCount() {
        this.likesCount = this.likesCount+1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (likesCount != artist.likesCount) return false;
        return nameOfTheArtist != null ? nameOfTheArtist.equals(artist.nameOfTheArtist) : artist.nameOfTheArtist == null;
    }

    @Override
    public int hashCode() {
        int result = nameOfTheArtist != null ? nameOfTheArtist.hashCode() : 0;
        result = 31 * result + likesCount;
        return result;
    }
}
