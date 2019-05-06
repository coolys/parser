package io.cooly.crawler.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A WebPage.
 */
@Document(collection = "web_page")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "webpage")
public class WebPage implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;

    @Field("url")
    private String url;

    @Field("domain")
    private String domain;

    @Field("fetched")
    private Boolean fetched;

    @Field("created")
    private Instant created;

    @Field("engine")
    private String engine;

    @Field("data")
    private String data;

    @Field("html")
    private String html;

    @Field("links")
    private String links;

    @Field("level")
    private Integer level;

    // coolybot-needle-entity-add-field - Coolybot will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public WebPage url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    public WebPage domain(String domain) {
        this.domain = domain;
        return this;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Boolean isFetched() {
        return fetched;
    }

    public WebPage fetched(Boolean fetched) {
        this.fetched = fetched;
        return this;
    }

    public void setFetched(Boolean fetched) {
        this.fetched = fetched;
    }

    public Instant getCreated() {
        return created;
    }

    public WebPage created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getEngine() {
        return engine;
    }

    public WebPage engine(String engine) {
        this.engine = engine;
        return this;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getData() {
        return data;
    }

    public WebPage data(String data) {
        this.data = data;
        return this;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHtml() {
        return html;
    }

    public WebPage html(String html) {
        this.html = html;
        return this;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getLinks() {
        return links;
    }

    public WebPage links(String links) {
        this.links = links;
        return this;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public Integer getLevel() {
        return level;
    }

    public WebPage level(Integer level) {
        this.level = level;
        return this;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    // coolybot-needle-entity-add-getters-setters - Coolybot will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WebPage webPage = (WebPage) o;
        if (webPage.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), webPage.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WebPage{" +
            "id=" + getId() +
            ", url='" + getUrl() + "'" +
            ", domain='" + getDomain() + "'" +
            ", fetched='" + isFetched() + "'" +
            ", created='" + getCreated() + "'" +
            ", engine='" + getEngine() + "'" +
            ", data='" + getData() + "'" +
            ", html='" + getHtml() + "'" +
            ", links='" + getLinks() + "'" +
            ", level=" + getLevel() +
            "}";
    }
}
