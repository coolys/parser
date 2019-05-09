package io.cooly.crawler.client;


import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DataFeed.
 */

public class DataFeed implements Serializable {

    private static final long serialVersionUID = 1L;
    
   
    private String id;

   
    private String url;

   
    private String domain;

   
    private Boolean fetched;

   
    private Instant created;

   
    private String engine;

   
    private String data;

   
    private String html;

   
    private String links;

   
    private Integer level;

   
    private String fileName;

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

    public DataFeed url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    public DataFeed domain(String domain) {
        this.domain = domain;
        return this;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Boolean isFetched() {
        return fetched;
    }

    public DataFeed fetched(Boolean fetched) {
        this.fetched = fetched;
        return this;
    }

    public void setFetched(Boolean fetched) {
        this.fetched = fetched;
    }

    public Instant getCreated() {
        return created;
    }

    public DataFeed created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getEngine() {
        return engine;
    }

    public DataFeed engine(String engine) {
        this.engine = engine;
        return this;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getData() {
        return data;
    }

    public DataFeed data(String data) {
        this.data = data;
        return this;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHtml() {
        return html;
    }

    public DataFeed html(String html) {
        this.html = html;
        return this;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getLinks() {
        return links;
    }

    public DataFeed links(String links) {
        this.links = links;
        return this;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public Integer getLevel() {
        return level;
    }

    public DataFeed level(Integer level) {
        this.level = level;
        return this;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getFileName() {
        return fileName;
    }

    public DataFeed fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
        DataFeed dataFeed = (DataFeed) o;
        if (dataFeed.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), dataFeed.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DataFeed{" +
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
            ", fileName='" + getFileName() + "'" +
            "}";
    }
}
