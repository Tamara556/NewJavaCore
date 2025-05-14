package main.BookStorage;

import main.BookStorage.Commands.Commands;
import main.BookStorage.Model.Author;
import main.BookStorage.Model.Book;
import main.BookStorage.Model.Gender;
import main.BookStorage.Storage.AuthorStorage;
import main.BookStorage.Storage.BookStorage;

import java.util.Scanner;

import static main.BookStorage.Commands.Commands.*;

public class BookStorageDemo {
    static final private Scanner scanner = new Scanner(System.in);
    static final private AuthorStorage authorStorage = new AuthorStorage();
    static final private BookStorage bookStorage = new BookStorage();
    static final private Gender[] values = Gender.values();

    private static boolean isDataEmpty(String data) {
        return data.equals("");
    }

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;

                case ADD_AUTHOR:
                    addAuthor();
                    break;

                case ADD_BOOK:
                    addBook();
                    break;

                case SEARCH_AUTHOR_BY_ID:
                    if (authorStorage.getSize() == 0) {
                        System.out.println("there is no author");
                    } else {
                        searchAuthorById();
                    }
                    break;

                // case SEARCH_BOOK_BY_AUTHOR:
                //     if (bookStorage.getBookSize() == 0){
                //         System.out.println("there is no book");
                //     } else {
                //         searchBookByAuthor();
                //     }
                //     break;

                case DELETE_AUTHOR_BY_ID:
                    if (authorStorage.getSize() == 0) {
                        System.out.println("there is no author");
                    } else {
                        authorStorage.printAuthors();
                        System.out.println("Choose author for delete");
                        String id = scanner.nextLine();
                    }
                    break;

                case DELETE_BOOK_BY_ID:
                    if (bookStorage.getBookSize() == 0) {
                        System.out.println("there is no book");
                    } else {
                        bookStorage.printBooks();
                        System.out.println("choose book for delete");
                        String id = scanner.nextLine();
                    }
                    break;

                case PRINT_ALL_BOOKS:
                    if (bookStorage.getBookSize() == 0) {
                        System.out.println("there is no book bro");
                    } else {
                        bookStorage.printBooks();
                    }

                case PRINT_ALL_AUTHORS:
                    if (authorStorage.getSize() == 0) {
                        System.out.println("There is no author");
                    } else {
                        authorStorage.printAuthors();
                    }
                    break;

            }
        }
    }

    // private static void searchBookByAuthor() {
    //     authorStorage.printAuthors();
    //     System.out.println("input author id");
    //     String bookByAuthor = scanner.nextLine();
//
    //     if (bookByAuthor.equals(authorStorage.getAuthorById(bookByAuthor))){
    //         bookStorage.printBookById();
    //     }
    // }

    private static void searchAuthorById() {
        authorStorage.printAuthors();
        System.out.println("input id ");
        String authorById = scanner.nextLine();

        if (authorById == null) {
            System.out.println(authorById);
        } else {
            System.out.println("there's no author by id");
        }
    }

    private static void addBook() {
        if (authorStorage.getSize() < 1) {
            System.out.println("No authors available. Please add an author first.");
            return;
        }

        System.out.println("Input book ID:");
        String bookId = scanner.nextLine().trim();

        while (isDataEmpty(bookId) || !bookStorage.checkId(bookId)) {
            if (isDataEmpty(bookId)) {
                System.out.println("ID can't be empty. Please input ID:");
            } else {
                System.out.println("Book with ID " + bookId + " already exists. Input another ID:");
            }
            bookId = scanner.nextLine().trim();
        }

        System.out.println("Input title:");
        String bookTitle = scanner.nextLine().trim();
        while (isDataEmpty(bookTitle)) {
            System.out.println("Title can't be empty. Please input title:");
            bookTitle = scanner.nextLine().trim();
        }

        authorStorage.printAuthors();
        System.out.println("Choose author by ID:");
        String bookAuthorId = scanner.nextLine().trim();
        Author bookAuthor = authorStorage.getAuthorById(bookAuthorId);

        while (bookAuthor == null) {
            System.out.println("Invalid author ID. Please try again:");
            authorStorage.printAuthors();
            bookAuthorId = scanner.nextLine().trim();
            bookAuthor = authorStorage.getAuthorById(bookAuthorId);
        }

        System.out.println("Input description:");
        String bookDescription = scanner.nextLine().trim();

        System.out.println("Input book price:");
        int bookPrice = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Input quantity:");
        int bookQty = Integer.parseInt(scanner.nextLine().trim());

        Book newBook = new Book(bookId, bookTitle, bookAuthor.getName(), bookDescription, bookPrice, bookQty);
        bookStorage.addBook(newBook);

        System.out.println("Book successfully added:");
        System.out.println(newBook);
    }


    private static void addAuthor() {
        System.out.println("Input ID for the author:");
        String authorId = scanner.nextLine().trim();

        while (isDataEmpty(authorId) || !authorStorage.idChecker(authorId)) {
            if (isDataEmpty(authorId)) {
                System.out.println("ID can't be empty. Please input ID:");
            } else {
                System.out.println("Author with ID " + authorId + " already exists. Input another ID:");
            }
            authorId = scanner.nextLine().trim();
        }

        System.out.println("Input name:");
        String authorName = scanner.nextLine().trim();
        while (isDataEmpty(authorName)) {
            System.out.println("Name can't be empty. Please input name:");
            authorName = scanner.nextLine().trim();
        }

        System.out.println("Input surname:");
        String authorSurname = scanner.nextLine().trim();
        while (isDataEmpty(authorSurname)) {
            System.out.println("Surname can't be empty. Please input surname:");
            authorSurname = scanner.nextLine().trim();
        }

        System.out.println("Input author age:");
        String authorAge = scanner.nextLine().trim();
        while (isDataEmpty(authorAge)) {
            System.out.println("Age can't be empty. Please input age:");
            authorAge = scanner.nextLine().trim();
        }

        System.out.println("Input author gender (Available options):");
        for (Gender value : Gender.values()) {
            System.out.println(value);
        }

        System.out.println("Input gender:");
        String authorGender = scanner.nextLine().trim().toUpperCase();

        try {
            Author newAuthor = new Author(authorId, authorName, authorSurname, authorAge, Gender.valueOf(authorGender));
            authorStorage.addAuthor(newAuthor);
            System.out.println("Author successfully added:");
            System.out.println(newAuthor);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender. Please try again.");
        }

    }


}
