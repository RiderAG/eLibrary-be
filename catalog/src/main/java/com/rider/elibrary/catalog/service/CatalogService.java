package com.rider.elibrary.catalog.service;

import com.rider.elibrary.catalog.model.BookModel;
import com.rider.elibrary.catalog.model.request.CreateBookRequest;
import com.rider.elibrary.catalog.model.response.CatalogBookPageResponse;

import java.util.List;

public interface CatalogService {

    String addBook(CreateBookRequest request);

    CatalogBookPageResponse getBooks(Integer pageIndex, Integer onPage);

    CatalogBookPageResponse getByCategory(String category, Integer pageIndex, Integer onPage);

    List<BookModel> getBooksByIds(List<String> ids);

}
