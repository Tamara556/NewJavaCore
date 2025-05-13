package main.BookStorage.Storage;

import main.BookStorage.Model.Author;

public class AuthorStorage {
    Author[] authorStorage = new Author[10];
    int size = 0;

    public int getSize() {
        return size;
    }

    public void extend(){
        Author[] newArr = new Author[authorStorage.length + 10];
        System.arraycopy(authorStorage, 0, newArr, 0, authorStorage.length);
        authorStorage = newArr;
    }

    public boolean idChecker(String changeId){
        for (int i = 0; i < size; i++) {
            Author author = authorStorage[i];
            if (author.getId().equals(changeId)){
                return false;
            }
        }
        return true;
    }

    public void addAuthor(Author author){
        if (size == authorStorage.length){
            extend();
        }
        authorStorage[size++] = author;
    }

    public void printAuthors(){
        for (int i = 0; i < size; i++) {
            Author author = authorStorage[i];
            if (author instanceof Author){
                System.out.println(author);
            }
        }
    }

    public Author getAuthorById(String id){
        for (int i = 0; i < size; i++) {
            Author author = authorStorage[i];
            if (author.getId().equals(id) && author instanceof Author){
                return author;
            }
        }
        return null;
    }

}
