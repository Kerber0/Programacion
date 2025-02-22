package java.Simulacro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public final class Gestor {
    private final Map<String, Album> albums;

    public Gestor() {
        this.albums = new HashMap<>();
    }

    public void showAll() {
        albums.forEach((title, album) -> System.out.println(album));
    }

    public void addAlbum(final Album album) {
        albums.put(album.getTitle(), album);
    }

    public void deleteAlbum(final String title) {
        albums.remove(title);
    }

    public Album searchAlbum(final String title) {
        return albums.get(title);
    }

    // Menus

    private final static Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("ALBUMS:");
        System.out.println("[1] Show");
        System.out.println("[2] Add");
        System.out.println("[3] Edit");
        System.out.println("[4] Delete");
        System.out.println("[0] Exit");
        String option;
        do {
            switch (option = scanner.nextLine()) {
                case "1": showAll();
                    break;
                case "2": addAlbum(addMenu());
                    break;
                case "3": // TODO!
                    break;
                case "4": deleteAlbum(input("Title: "));
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != "0");
        System.out.println("Bye!");
    }

    public Album addMenu() {
        return new Album(input("Title: "), input("Artist: "), parseInt(input("Year: ")), parseInt(input("Songs: ")));
    }

    private String input(final String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}