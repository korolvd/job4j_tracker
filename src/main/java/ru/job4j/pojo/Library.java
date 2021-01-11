package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book war = new Book("Война и мир", 960);
        Book clean = new Book("Clean code", 464);
        Book professional = new Book("Java. Библиотека професионала", 864);
        Book hobbit = new Book("The Hobbit", 389);
        Book[] books = {war, clean, professional, hobbit};
        for (int index = 0; index < books.length; index++) {
            System.out.println((index + 1) + ". " +
                    books[index].getName() + " - " + books[index].getPages() + " стр.");
        }
        System.out.println();
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int index = 0; index < books.length; index++) {
            System.out.println((index + 1) + ". " +
                    books[index].getName() + " - " + books[index].getPages() + " стр.");
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals("Clean code")) {
                System.out.println((index + 1) + ". " +
                        books[index].getName() + " - " + books[index].getPages() + " стр.");
            }
        }
    }
}
