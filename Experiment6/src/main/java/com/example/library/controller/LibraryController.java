package com.example.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.library.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // Home Page with clickable links
    @GetMapping("/")
    public String home() {
        return "<h2>Online Library API</h2>" +
               "<a href='/welcome'>Welcome</a><br><br>" +
               "<a href='/count'>Book Count</a><br><br>" +
               "<a href='/price'>Book Price</a><br><br>" +
               "<a href='/books'>Book List</a><br><br>" +
               "<a href='/books/1'>Book Details</a><br><br>" +
               "<a href='/search?title=Java'>Search Book</a><br><br>" +
               "<a href='/author/Ramesh'>Author</a><br><br>" +
               "<a href='/viewbooks'>View Added Books</a><br><br>" +
               "Use Postman for: /addbook (POST)";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public int bookCount() {
        return 100;
    }

    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {

        List<String> books = new ArrayList<>();

        books.add("Java Programming");
        books.add("Spring Boot Guide");
        books.add("Python Basics");

        return books;
    }

    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable int id) {
        return "Details of Book ID: " + id;
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String authorName(@PathVariable String name) {
        return "Books written by Author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {

        bookList.add(book);

        return "Book Added Successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {

        return bookList;
    }
}