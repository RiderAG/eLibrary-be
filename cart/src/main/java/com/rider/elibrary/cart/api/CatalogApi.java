package com.rider.elibrary.cart.api;

import com.rider.elibrary.cart.api.response.ItemInfoResponse;
import com.rider.elibrary.cart.config.feign.CatalogApiFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "catalog", configuration = CatalogApiFeignConfiguration.class)
public interface CatalogApi {

    @GetMapping("/api/catalog/books/with-ids")
    List<ItemInfoResponse> productsByIds(@RequestParam("ids") List<String> ids);

}
