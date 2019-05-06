package io.cooly.crawler.service.impl;

import io.cooly.crawler.domain.WebPage;
import io.cooly.crawler.repository.WebPageRepository;
import io.cooly.crawler.repository.search.WebPageSearchRepository;
import io.cooly.crawler.service.WebPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Service Implementation for managing WebPage.
 */
@Service
public class WebPageServiceImpl implements WebPageService {

    private final Logger log = LoggerFactory.getLogger(WebPageServiceImpl.class);

    private final WebPageRepository webPageRepository;

    private final WebPageSearchRepository webPageSearchRepository;

    public WebPageServiceImpl(WebPageRepository webPageRepository, WebPageSearchRepository webPageSearchRepository) {
        this.webPageRepository = webPageRepository;
        this.webPageSearchRepository = webPageSearchRepository;
    }

    /**
     * Save a webPage.
     *
     * @param webPage the entity to save
     * @return the persisted entity
     */
    @Override
    public WebPage save(WebPage webPage) {
        log.debug("Request to save WebPage : {}", webPage);
        WebPage result = webPageRepository.save(webPage);
        webPageSearchRepository.save(result);
        return result;
    }

    /**
     * Get all the webPages.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<WebPage> findAll(Pageable pageable) {
        log.debug("Request to get all WebPages");
        return webPageRepository.findAll(pageable);
    }


    /**
     * Get one webPage by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Optional<WebPage> findOne(String id) {
        log.debug("Request to get WebPage : {}", id);
        return webPageRepository.findById(id);
    }

    /**
     * Delete the webPage by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete WebPage : {}", id);
        webPageRepository.deleteById(id);
        webPageSearchRepository.deleteById(id);
    }

    /**
     * Search for the webPage corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    public Page<WebPage> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of WebPages for query {}", query);
        return webPageSearchRepository.search(queryStringQuery(query), pageable);    }
}
