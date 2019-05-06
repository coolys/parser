package io.cooly.crawler.repository.search;

import io.cooly.crawler.domain.WebPage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the WebPage entity.
 */
public interface WebPageSearchRepository extends ElasticsearchRepository<WebPage, String> {
}
