/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.cooly.crawler.client;

import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author hungnguyendang
 */
@AuthorizedFeignClient(name = "indexer")
public interface IndexerServiceClient {
    @PostMapping("api/data-feeds")
    DataFeed createDataFeed(DataFeed dataFeed); 
    
}
