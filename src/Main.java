import artists.Artist;
import library.*;
import library.exceptions.NoSuchArtistException;
import library.exceptions.NoSuchProductException;
import сonsumer.Subscriber;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Artist artist1 = new Artist("Andrzej Sapkowski");
        Artist artist2 = new Artist("The Beatles");
        Artist artist3 = new Artist("Joe Rogan Experience");

        AudioBook audioBookbook1 = new AudioBook(artist1, "The Witcher", "The Witcher_audio.txt");

        Song song4 = new Song(artist2, "Yesterday", "Yesterday_audio.txt", "Yesterday_video.txt");
        Song song5 = new Song(artist2, "Help", "Help_audio.txt","Help_video.txt");
        Song song6 = new Song(artist2, "A hard days night", "A_hard_days_night_audio.txt");

        Podcast podcast7 = new Podcast(artist3, "episode №178", "episode_№178_audio.txt", "episode_№178_video.txt");


        Subscriber subscriber1 = new Subscriber("Mykyta");
        subscriber1.startPlaying(song4);


        try {
            Product product1 = Library.searchTheProductByName("Yesterday");
            System.out.println(product1.getNameOfTheProduct());
        } catch (NoSuchProductException e) {
            e.printStackTrace();
        }


        try {
            Artist artist4 = Library.searchTheArtistByName("Andrzej Sapkowski");
            System.out.println(artist4.getNameOfTheArtist());
        } catch (NoSuchArtistException e) {
            e.printStackTrace();
        }

        Library.printAllTheProductsOfTheArtist("The Beatles");

        Class <Product> productClass = Product.class;

        Field [] fields = productClass.getDeclaredFields();
        for (Field field: fields) {
            System.out.println("Type of " + field.getName() + " = " + field.getType());
        }

        Method [] methods = productClass.getDeclaredMethods();
        for (Method method: methods){
            System.out.println("Name of the method: " + method.getName() + ". return type: " + method.getReturnType()
            + ". parametr types: " + Arrays.toString(method.getParameterTypes()));
        }

        Constructor [] constructors = productClass.getDeclaredConstructors();
        for (Constructor constructor: constructors){
            System.out.println("Name of the constructor: " + constructor.getName()
                    + ". parametr types: " + Arrays.toString(constructor.getParameterTypes()));
        }

        Class <Product> songClass = Product.class;
        Field field = songClass.getDeclaredField("nameOfTheProduct");
        field.setAccessible(true);
        System.out.println(field.get(song4));
    }

}
