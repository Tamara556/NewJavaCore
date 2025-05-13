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

    private static boolean isDataEmpty(String data){
        return data.equals("");
    }

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command){
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
                    if (authorStorage.getSize() == 0){
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
                    if (authorStorage.getSize() == 0){
                        System.out.println("there is no author");
                    } else {
                        authorStorage.printAuthors();
                        System.out.println("Choose author for delete");
                        String id = scanner.nextLine();
                    }
                    break;

                case DELETE_BOOK_BY_ID:
                    if (bookStorage.getBookSize() == 0){
                        System.out.println("there is no book");
                    } else {
                        bookStorage.printBooks();
                        System.out.println("choose book for delete");
                        String id = scanner.nextLine();
                    }
                    break;

                case PRINT_ALL_BOOKS:
                    if (bookStorage.getBookSize() == 0){
                        System.out.println("there is no book bro");
                    } else {
                        bookStorage.printBooks();
                    }

                case PRINT_ALL_AUTHORS:
                    if (authorStorage.getSize() == 0){
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

        if (authorById == null ){
            System.out.println(authorById);
        } else {
            System.out.println("there's no author by id");
        }
    }

    private static void addBook() {
        if (authorStorage.getSize() >= 1){
        System.out.println("input book id ");
        String bookId = scanner.nextLine();
        while (isDataEmpty(bookId) || !bookStorage.checkId(bookId)){
            if (isDataEmpty(bookId)){
                System.out.println("id can't be empty ");
                System.out.print("please input id ");
                bookId = scanner.nextLine();
            }

            if (bookStorage.checkId(bookId)){
                System.out.println("book with " + bookId + " already exist");
                System.out.print("input other id");
                bookId = scanner.nextLine();
            }

            System.out.println("input title ");
            String bookTitle = scanner.nextLine();
            while (isDataEmpty(bookTitle)){
                System.out.println("title can't be empty");
                System.out.print("input other title");
                bookTitle = scanner.nextLine();
            }
            authorStorage.printAuthors();
            System.out.println("choose author for book ");
            System.out.print("input id ");
            String bookAuthorId = scanner.nextLine();
            Author bookAuthor = authorStorage.getAuthorById(bookAuthorId);
            while (isDataEmpty(bookAuthorId)){
                System.out.println("book's author can't be empty ");
                System.out.print("input author id");
                authorStorage.printAuthors();
                bookAuthorId = scanner.nextLine();
                bookAuthor = authorStorage.getAuthorById(bookAuthorId);
            }

            System.out.println("input description ");
            String bookDescription = scanner.nextLine();
            while (isDataEmpty(bookDescription)){
                System.out.print("description can be empty");
            }

            System.out.println("input book price");
            String bookPrice = scanner.nextLine();
            while (isDataEmpty(bookPrice)){
                System.out.println("price can't be empty");
                System.out.print("input price ");
                bookPrice = scanner.nextLine();
            }

            System.out.println("input qty");
            String bookQty = scanner.nextLine();
            while (isDataEmpty(bookQty)){
                System.out.println("input qty or else input 0");
                bookQty = scanner.nextLine();
            }

        }
    }



        }
    private static void addAuthor() {
        System.out.println("input id for author");
        String authorId = scanner.nextLine();
        while (isDataEmpty(authorId) || !authorStorage.idChecker(authorId)){
            if (isDataEmpty(authorId)){
                System.out.println("id can't be empty");
                System.out.print("please input id ");
                authorId = scanner.nextLine();
            }
            if (authorStorage.idChecker(authorId)){
                System.out.println("author with" + authorId + "already exist");
                System.out.println("input another id");
                authorId = scanner.nextLine();
            }
        }
        System.out.println("input name ");
        String authorName = scanner.nextLine();
        while (isDataEmpty(authorName)){
            System.out.println("author name can't be empty");
            System.out.print("input name");
            authorName = scanner.nextLine();
        }

        System.out.println("input surname");
        String authorSurname = scanner.nextLine();
        while (isDataEmpty(authorSurname)){
            System.out.println("Author surname can't be empty");
            System.out.print("input surname ");
            authorSurname = scanner.nextLine();
        }

        System.out.println("input author age");
        String authorAge = scanner.nextLine();
        while (isDataEmpty(authorAge)){
            System.out.println("Author age can't be empty");
            System.out.print("input author age bro");
            authorAge = scanner.nextLine();
        }

        System.out.println("input author gender");
        for (Gender value : values) {
            System.out.println(value);
        }
        System.out.println("input gender");
        String authorGender = scanner.nextLine();

        Author newAuthor;

        try {
            newAuthor = new Author(authorId, authorName, authorSurname, authorAge, Gender.valueOf(authorGender));
        } catch (IllegalArgumentException e) {
            System.out.println("wrong gender");
            return;
        }
    }


}
