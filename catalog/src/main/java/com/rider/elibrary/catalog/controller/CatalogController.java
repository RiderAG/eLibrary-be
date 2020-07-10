package com.rider.elibrary.catalog.controller;

import com.rider.elibrary.catalog.entity.Book;
import com.rider.elibrary.catalog.model.Category;
import com.rider.elibrary.catalog.model.request.CreateBookRequest;
import com.rider.elibrary.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCatalogPage() {
        List<Book> books = new ArrayList<>();
//        bookCards.add(new Book("Java 8", "Programming"));
//        bookCards.add(new Book("Vinny The Pooh", "Tales"));
//        bookCards.add(new Book("Art of War", "Philosophy"));
//        bookCards.add(new Book("The Lost World", "Adventure"));
        return ResponseEntity.ok(books);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addBook(@RequestBody CreateBookRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(catalogService.addBook(request));
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCategories() {
        return ResponseEntity.ok(Category.getAllNames());
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getBooks(@RequestParam("pageIndex") Integer pageIndex,
                                   @RequestParam("onPage") Integer onPage) {
        return ResponseEntity.ok(catalogService.getBooks(pageIndex, onPage));
    }

    @GetMapping("/books/categories/{category}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCategory(@PathVariable("category") String category,
                                      @RequestParam("pageIndex") Integer pageIndex,
                                      @RequestParam("onPage") Integer onPage) {
        return ResponseEntity.ok(catalogService.getByCategory(category, pageIndex, onPage));
    }

}
