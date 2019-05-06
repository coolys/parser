package io.cooly.crawler.service;

import io.cooly.crawler.domain.WebPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing WebPage.
 */
public interface WebPageService {

    /**
     * Save a webPage.
     *
     * @param webPage the entity to save
     * @return the persisted entity
     */
    WebPage save(WebPage webPage);

    /**
     * Get all the webPages.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<WebPage> findAll(Pageable pageable);


    /**
     * Get the "id" webPage.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<WebPage> findOne(String id);

    /**
     * Delete the "id" webPage.
     *
     * @param id the id of the entity
     */
    void delete(String id);

    /**
     * Search for the webPage corresponding to the query.
     *
     * @param query the query of the search
     * 
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<WebPage> search(String query, Pageable pageable);
}
