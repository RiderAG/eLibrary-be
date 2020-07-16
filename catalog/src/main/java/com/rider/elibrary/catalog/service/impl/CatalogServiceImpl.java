package com.rider.elibrary.catalog.service.impl;

import com.rider.elibrary.catalog.entity.Book;
import com.rider.elibrary.catalog.error.exception.CatalogApiException;
import com.rider.elibrary.catalog.error.exception.ErrorModel;
import com.rider.elibrary.catalog.model.BookModel;
import com.rider.elibrary.catalog.model.Category;
import com.rider.elibrary.catalog.model.request.CreateBookRequest;
import com.rider.elibrary.catalog.model.response.CatalogBookPageResponse;
import com.rider.elibrary.catalog.repository.CatalogRepository;
import com.rider.elibrary.catalog.service.CatalogService;
import com.rider.elibrary.catalog.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private Validator validator;

    @Override
    public String addBook(CreateBookRequest request) {
        validator.validate(request);
        Book book = Book.from(request);
        book = catalogRepository.save(book);
        return book.getId();
    }

    @Override
    public CatalogBookPageResponse getBooks(Integer pageIndex, Integer onPage) {
        Pageable pageable = PageRequest.of(pageIndex - 1, onPage);
        return CatalogBookPageResponse.from(catalogRepository.findAll(pageable));
    }

    @Override
    public CatalogBookPageResponse getByCategory(String categoryStr, Integer pageIndex, Integer onPage) {
        Category category = Category.getByName(categoryStr);
        if (Objects.isNull(category)) {
            throw new CatalogApiException("Incorrect category", ErrorModel.CATEGORY_NOT_FOUND);
        }
        Pageable pageable = PageRequest.of(pageIndex - 1, onPage);
        Page<Book> result = catalogRepository.findAllByCategory(category, pageable);
        return CatalogBookPageResponse.from(result);
    }

    @Override
    public List<BookModel> getBooksByIds(List<String> ids) {
        if (Objects.isNull(ids) || ids.isEmpty()) {
            throw new CatalogApiException("No book ids to found", ErrorModel.NULL_BOOK_ID);
        }
        return catalogRepository.findAllById(ids).stream()
                .map(book -> new BookModel(book.getId(), book.getName(), book.getPrice()))
                .collect(Collectors.toList());
    }

}
