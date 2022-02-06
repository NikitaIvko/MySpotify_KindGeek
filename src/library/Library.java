package library;

import artists.Artist;
import library.exceptions.NoSuchArtistException;
import library.exceptions.NoSuchProductException;

import java.util.*;

//This class contains static collections containing all the products and artists.
public class Library {
    //listOfAllProducts and mapOfProductsAndArtists are interchangeable, it is not necessary to keep both. I used both only to practice using both collections.
    private static List<Product> listOfAllProducts = new ArrayList<>();
    private static Map<Product, Artist> mapOfProductsAndArtists = new HashMap<>();

    //It is not necessary to use this set, since it is possible to get the same information either from listOfAllProducts or mapOfProductsAndArtists. I used this set only to practice using this collection.
    private static Set <Artist> setOfArtists = new HashSet<>();

    public static void addProductToTheListOfAllProducts(Product product){
        listOfAllProducts.add(product);
    }

    public static void addProductToTheMapOfProductsAndArtists(Product product){
        mapOfProductsAndArtists.put(product, product.getArtist());
    }

    public static void addArtistToTheSetOfArtists(Artist artist){
        setOfArtists.add(artist);
    }


    public static List<Product> getListOfAllProducts() {
        return listOfAllProducts;
    }

    public static Map<Product, Artist> getMapOfProductsAndArtists() {
        return mapOfProductsAndArtists;
    }

    public static Set<Artist> getSetOfArtists() {
        return setOfArtists;
    }

    public static Artist searchTheArtistByName(String nameOfTheArtist) throws NoSuchArtistException {
        Artist searchResult = setOfArtists.stream().filter(a -> a.getNameOfTheArtist().equals(nameOfTheArtist)).findFirst().get();

        if (searchResult==null){
            throw new NoSuchArtistException();
        }
        else{
            return searchResult;
        }
    }

    public static Product searchTheProductByName(String nameOfTheProduct) throws NoSuchProductException {
        Product searchResult = listOfAllProducts.stream().filter(a -> a.getNameOfTheProduct().equals(nameOfTheProduct)).findFirst().get();

        if (searchResult==null){
            throw new NoSuchProductException();
        }
        else{
            return searchResult;
        }
    }

    public static void printAllTheProductsOfTheArtist(String nameOfTheArtist){
        Artist searchResult = null;
        try {
            searchResult = searchTheArtistByName(nameOfTheArtist);
        } catch (NoSuchArtistException e) {
            e.printStackTrace();
        }

        System.out.println("List of all the products of " + searchResult.getNameOfTheArtist() + " :");

        Artist finalSearchResult = searchResult;
        mapOfProductsAndArtists.keySet().stream().filter((a -> a.getArtist().equals(finalSearchResult))).forEach(a -> System.out.println(a.getNameOfTheProduct()));
    }
}
