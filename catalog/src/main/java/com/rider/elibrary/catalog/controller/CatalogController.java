package com.rider.elibrary.catalog.controller;

import com.rider.elibrary.catalog.controller.model.BookCard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getCatalogPage() {
        List<BookCard> bookCards = new ArrayList<>();
        bookCards.add(new BookCard("Java 8", "Programming"));
        bookCards.add(new BookCard("Vinny Pooh", "Tales"));
        bookCards.add(new BookCard("Art of War", "Philosophy"));
        bookCards.add(new BookCard("The Lost World", "Adventure"));
        return ResponseEntity.ok(bookCards);
    }

}
