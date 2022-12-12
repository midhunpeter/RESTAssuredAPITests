package org.omni.api.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "sku",
        "itemname",
        "listprice"
})
@Generated("jsonschema2pojo")
public class Price {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sku")
    private Integer sku;
    @JsonProperty("itemname")
    private String itemname;
    @JsonProperty("listprice")
    private String listprice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("sku")
    public Integer getSku() {
        return sku;
    }

    @JsonProperty("sku")
    public void setSku(Integer sku) {
        this.sku = sku;
    }

    @JsonProperty("itemname")
    public String getItemname() {
        return itemname;
    }

    @JsonProperty("itemname")
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @JsonProperty("listprice")
    public String getListprice() {
        return listprice;
    }

    @JsonProperty("listprice")
    public void setListprice(String listprice) {
        this.listprice = listprice;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}