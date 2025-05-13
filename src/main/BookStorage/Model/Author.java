package main.BookStorage.Model;

import java.util.Objects;

public class Author {
    String id;
    String name;
    String surname;
    String age;
    Gender gender;
    Book book;

    public Author() {
    }

    public Author(String id, String name, String surname, String age, Gender gender, Book book) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.book = book;
    }

    public Author(String id, String name, String surname, String age, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age && Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(surname, author.surname)  && gender == author.gender && Objects.equals(book, author.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, gender, book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", book=" + book +
                '}';
    }
}
