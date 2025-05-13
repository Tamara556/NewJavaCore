package main.BookStorage.Storage;

import main.BookStorage.Model.Author;
import main.BookStorage.Model.Book;

public class BookStorage {

    private Book[] bookStorage = new Book[10];
    private int bookSize = 0;

    public int getBookSize() {
        return bookSize;
    }

    private void extend(){
        Book[] newArr = new Book[bookStorage.length + 10];
        System.arraycopy(bookStorage, 0, newArr, 0, bookStorage.length);
        bookStorage = newArr;
    }

    public void addBook(Book book){
        if (bookSize == bookStorage.length){
            extend();
        }
        bookStorage[bookSize++] = book;
    }

    public void printBooks(){
        for (int i = 0; i < bookSize; i++) {
            Book book = bookStorage[i];
            if (book instanceof Book){
                System.out.println(book);
            }
        }
    }

    public Book searchBookByAuthor(Author author){
        for (int i = 0; i < bookSize; i++) {
            Book book = bookStorage[i];
            if (bookStorage[i] instanceof Book && book.getAuthor_name().equals(author)){
                return book;
            }
        }
        return null;
    }

    public void deleteBookById(String id){
        boolean found = false;
        for (int i = 0; i < bookSize; i++) {
            Book book = bookStorage[i];
            if (book.getId().equals(id) && book instanceof Book){
                deleteBookById(String.valueOf(i));
                System.out.println("Book deleted!");
                found = true;
            }
        }
        if (!found){
            System.out.println("Book with " + id + " not found!");
        }
    }

    public boolean checkId(String idChange){
        for (int i = 0; i < bookSize; i++) {
            Book book = bookStorage[1];
            if (book.getId().equals(idChange)){
                return false;
            }
        }
        return true;
    }
   //
   // public Book getBookId(String id){
   //     for (int i = 0; i < bookSize; i++) {
   //         Book book = bookStorage[1];
   //         if (book.getId().equals(id) && book instanceof Book){
   //             return book;
   //         }
   //     }
   //     return null;
   // }

    public void printBookById(String id){
        boolean found = false;
        for (int i = 0; i < bookSize; i++) {
            Book book = bookStorage[i];
            if (book instanceof Book && book.getId().equals(id)){
                System.out.println(book);
                found = true;
            }
        }
        if (!found){
            System.out.println("There is no book with " + id);
        }
    }

}
