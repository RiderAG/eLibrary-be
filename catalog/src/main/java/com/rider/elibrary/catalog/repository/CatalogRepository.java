package com.rider.elibrary.catalog.repository;

import com.rider.elibrary.catalog.entity.Book;
import com.rider.elibrary.catalog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Book, String> {

    Page<Book> findAllByCategory(Category category, Pageable pageable);

}
