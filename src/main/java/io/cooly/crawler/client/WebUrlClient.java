package io.cooly.crawler.client;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * A WebUrl.
 */

@AuthorizedFeignClient(name = "fetcher")
public interface WebUrlClient {
    @RequestMapping("/api/web-urls")
    List<WebUrl> getFetches();

    // send back urls to fetcher
}
