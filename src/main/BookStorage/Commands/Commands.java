package main.BookStorage.Commands;

public interface Commands {
    String EXIT = "0";
    String ADD_AUTHOR = "1";
    String ADD_BOOK = "2";
    String SEARCH_AUTHOR_BY_ID = "3";
    String SEARCH_BOOK_BY_AUTHOR = "4";
    String DELETE_BOOK_BY_ID = "5";
    String DELETE_AUTHOR_BY_ID = "6";
    String PRINT_ALL_BOOKS = "7";
    String PRINT_ALL_AUTHORS = "8";

    static void printCommands(){
        System.out.println("input " + EXIT + " for exit");
        System.out.println("input " + ADD_AUTHOR + " for add author");
        System.out.println("input " + ADD_BOOK + " for add book");
        System.out.println("input " + SEARCH_AUTHOR_BY_ID + " for search author by id");
        System.out.println("input " + SEARCH_BOOK_BY_AUTHOR + " for search book by author");
        System.out.println("input " + DELETE_BOOK_BY_ID + " for delete book by id");
        System.out.println("input " + DELETE_AUTHOR_BY_ID + " for delete author by id");
        System.out.println("input " + PRINT_ALL_BOOKS + " for print all books");
        System.out.println("input " + PRINT_ALL_AUTHORS + " for all authors");
    }

}
