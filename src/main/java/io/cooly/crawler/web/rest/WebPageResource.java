package io.cooly.crawler.web.rest;

import io.cooly.crawler.domain.WebPage;
import io.cooly.crawler.service.WebPageService;
import io.cooly.crawler.web.rest.errors.BadRequestAlertException;
import io.cooly.crawler.web.rest.util.HeaderUtil;
import io.cooly.crawler.web.rest.util.PaginationUtil;
import io.github.coolys.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing WebPage.
 */
@RestController
@RequestMapping("/api")
public class WebPageResource {

    private final Logger log = LoggerFactory.getLogger(WebPageResource.class);

    private static final String ENTITY_NAME = "parserWebPage";

    private final WebPageService webPageService;

    public WebPageResource(WebPageService webPageService) {
        this.webPageService = webPageService;
    }

    /**
     * POST  /web-pages : Create a new webPage.
     *
     * @param webPage the webPage to create
     * @return the ResponseEntity with status 201 (Created) and with body the new webPage, or with status 400 (Bad Request) if the webPage has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/web-pages")
    public ResponseEntity<WebPage> createWebPage(@RequestBody WebPage webPage) throws URISyntaxException {
        log.debug("REST request to save WebPage : {}", webPage);
        if (webPage.getId() != null) {
            throw new BadRequestAlertException("A new webPage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WebPage result = webPageService.save(webPage);
        return ResponseEntity.created(new URI("/api/web-pages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /web-pages : Updates an existing webPage.
     *
     * @param webPage the webPage to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated webPage,
     * or with status 400 (Bad Request) if the webPage is not valid,
     * or with status 500 (Internal Server Error) if the webPage couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/web-pages")
    public ResponseEntity<WebPage> updateWebPage(@RequestBody WebPage webPage) throws URISyntaxException {
        log.debug("REST request to update WebPage : {}", webPage);
        if (webPage.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WebPage result = webPageService.save(webPage);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, webPage.getId().toString()))
            .body(result);
    }

    /**
     * GET  /web-pages : get all the webPages.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of webPages in body
     */
    @GetMapping("/web-pages")
    public ResponseEntity<List<WebPage>> getAllWebPages(Pageable pageable) {
        log.debug("REST request to get a page of WebPages");
        Page<WebPage> page = webPageService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/web-pages");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /web-pages/:id : get the "id" webPage.
     *
     * @param id the id of the webPage to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the webPage, or with status 404 (Not Found)
     */
    @GetMapping("/web-pages/{id}")
    public ResponseEntity<WebPage> getWebPage(@PathVariable String id) {
        log.debug("REST request to get WebPage : {}", id);
        Optional<WebPage> webPage = webPageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(webPage);
    }

    /**
     * DELETE  /web-pages/:id : delete the "id" webPage.
     *
     * @param id the id of the webPage to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/web-pages/{id}")
    public ResponseEntity<Void> deleteWebPage(@PathVariable String id) {
        log.debug("REST request to delete WebPage : {}", id);
        webPageService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }

    /**
     * SEARCH  /_search/web-pages?query=:query : search for the webPage corresponding
     * to the query.
     *
     * @param query the query of the webPage search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/web-pages")
    public ResponseEntity<List<WebPage>> searchWebPages(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of WebPages for query {}", query);
        Page<WebPage> page = webPageService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/web-pages");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}
