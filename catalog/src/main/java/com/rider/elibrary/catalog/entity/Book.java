package com.rider.elibrary.catalog.entity;

import com.rider.elibrary.catalog.model.Category;
import com.rider.elibrary.catalog.model.request.CreateBookRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "BOOKS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String publisher;
    @Column(nullable = false)
    private Category category;
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private BigDecimal price;
    private int pages;

    public static Book from(CreateBookRequest request) {
        Book book = new Book();
        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setPublisher(request.getPublisher());
        book.setCategory(Category.getByName(request.getCategory()));
        book.setYear(request.getYear());
        book.setPages(request.getPages());
        book.setPrice(request.getPrice());
        return book;
    }
}
