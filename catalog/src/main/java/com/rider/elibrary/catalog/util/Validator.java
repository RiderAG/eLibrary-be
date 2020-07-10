package com.rider.elibrary.catalog.util;

import com.rider.elibrary.catalog.error.exception.CatalogApiException;
import com.rider.elibrary.catalog.error.exception.ErrorModel;
import com.rider.elibrary.catalog.model.Category;
import com.rider.elibrary.catalog.model.request.CreateBookRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Component
public class Validator {

    public void validate(CreateBookRequest request) {
        validateName(request.getName());
        validateAuthor(request.getAuthor());
        validatePublisher(request.getPublisher());
        validateCategory(request.getCategory());
        validateYear(request.getYear());
        validatePrice(request.getPrice());
        validatePages(request.getPages());
    }

    private void validateName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new CatalogApiException("Incorrect book name", ErrorModel.INCORRECT_CREATE_BOOK_REQUEST);
        }
    }

    private void validateAuthor(String author) {
        if (Objects.isNull(author) || author.isEmpty()) {
            throw new CatalogApiException("Incorrect book author", ErrorModel.INCORRECT_CREATE_BOOK_REQUEST);
        }
    }

    private void validatePublisher(String publisher) {
        if (Objects.isNull(publisher) || publisher.isEmpty()) {
            throw new CatalogApiException("Incorrect publisher", ErrorModel.INCORRECT_CREATE_BOOK_REQUEST);
        }
    }

    private void validateCategory(String category) {
        if (Objects.isNull(Category.getByName(category))) {
            throw new CatalogApiException("Incorrect category", ErrorModel.INCORRECT_CREATE_BOOK_REQUEST);
        }
    }

    private void validateYear(int year) {
        int now = LocalDate.now().getYear();
        if (year < 0 || year > (now + 10)) {
            throw new CatalogApiException("Incorrect year", ErrorModel.INCORRECT_CREATE_BOOK_REQUEST);
        }
    }

    private void validatePrice(BigDecimal price) {
        if (price.doubleValue() < 0) {
            throw new CatalogApiException("Incorrect price", ErrorModel.INCORRECT_CREATE_BOOK_REQUEST);
        }
    }

    private void validatePages(int pages) {
        if (pages < 0 || pages > 5000 ) {
            throw new CatalogApiException("Incorrect pages number", ErrorModel.INCORRECT_CREATE_BOOK_REQUEST);
        }
    }

}
