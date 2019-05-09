package io.cooly.crawler.client;


import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * A WebUrl.
 */

@AuthorizedFeignClient(name = "fetcher")
public interface FetcherServiceClient {
    @RequestMapping("/api/web-urls")
    List<WebUrl> getFetches();
    
    @PostMapping("api/web-urls")
    WebUrl createWebUrl(WebUrl webUrl);

}
