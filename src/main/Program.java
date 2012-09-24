package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;
    private static String savedLibraryNumber = "";

    public static void main(String[] args) {
        while (true) {
            printMenu();

            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStream);
            int userOption = getUserOption(reader);

            if (userOption == 1) {
                printBookList();
                continue;
            }
            if (userOption == 2) {
                reserveBook(reader);
                continue;
            }
            if (userOption == 3) {
                showLibraryNumber();
                continue;
            }
            if (userOption == 4) {
                printMovieDetails();
                continue;
            }
            if (userOption == 5) {
                clearLogin();
                performLogin(reader);
                continue;

            }
            if (userOption == 9) {
                System.out.println("Quitting...");
                break;
            }
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
        }
    }

    private static void performLogin(BufferedReader reader) {
        System.out.println("Enter your library number");
        try {
            String libraryNumber = reader.readLine();
            if (validLibraryNumber(libraryNumber)) {
                checkUsernameAndPassword(reader, libraryNumber);
            }
        } catch (Exception e) {

        }
    }

    private static void checkUsernameAndPassword(BufferedReader reader, String libraryNumber) {
        try {
            System.out.println("Enter your Password: ");
            String password = reader.readLine();
            if (validPassword(password)) {
                loggedIn = true;
                savedLibraryNumber = libraryNumber;
            }
        } catch (Exception e) {

        }
    }

    private static void printMovieDetails() {
        System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
        System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
        System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
        System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
        System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
        System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
        System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
        System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
        System.out.println(createMovie("Inception", "Frank Darabont", "10"));
        System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
    }

    private static void showLibraryNumber() {
        if (loggedIn()) {
            System.out.println("\n");
            System.out.println("Your library number is " + savedLibraryNumber);
            return;
        }
            System.out.println("\n");
            System.out.println("Please talk to Librarian. Thank you.");
    }

    private static int getUserOption(BufferedReader reader) {
        int userOption = 0;
        try {
            String value = reader.readLine();
            userOption = Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");
        }
        return userOption;
    }

    private static void reserveBook(BufferedReader reader) {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int userOption = 0;
        try {
            userOption = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");

        }
        reserve(userOption);
    }

    private static void reserve(int userOption) {
        switch (userOption) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("\n");
                System.out.println(" Thank You! Enjoy the book.");
                break;
            default:
                System.out.println("\n");
                System.out.println("Sorry we don't have that book yet.");
        }
    }

    private static void printBookList() {
        System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
        System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
        System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
        System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
    }

    private static void printMenu() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private static boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private static boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }

    private static boolean loggedIn() {
        return loggedIn;
    }


    private static void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

