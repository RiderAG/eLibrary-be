package com.rider.elibrary.catalog.model.response;

import com.rider.elibrary.catalog.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogBookPageResponse {

    private List<Book> books;
    private Integer pageIndex;
    private Integer totalPages;

    public static CatalogBookPageResponse from(Page<Book> page) {
        return new CatalogBookPageResponse(
                page.getContent(),
                page.getPageable().getPageNumber() + 1,
                page.getTotalPages()
        );
    }
}
