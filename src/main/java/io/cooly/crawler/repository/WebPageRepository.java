package io.cooly.crawler.repository;

import io.cooly.crawler.domain.WebPage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the WebPage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface WebPageRepository extends MongoRepository<WebPage, String> {

}
