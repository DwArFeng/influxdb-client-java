/*
 * Influx API Service
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.influxdata.client.domain;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.influxdata.client.domain.ViewLinks;

/**
 * View
 */

public class View {
  public static final String SERIALIZED_NAME_LINKS = "links";
  @SerializedName(SERIALIZED_NAME_LINKS)
  private ViewLinks links = null;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_PROPERTIES = "properties";
  @SerializedName(SERIALIZED_NAME_PROPERTIES)
  @JsonAdapter(ViewPropertiesAdapter.class)
  private Object properties = null;

  public View links(ViewLinks links) {
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @ApiModelProperty(value = "")
  public ViewLinks getLinks() {
    return links;
  }

  public void setLinks(ViewLinks links) {
    this.links = links;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public View name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public View properties(Object properties) {
    this.properties = properties;
    return this;
  }

   /**
   * Get properties
   * @return properties
  **/
  @ApiModelProperty(value = "")
  public Object getProperties() {
    return properties;
  }

  public void setProperties(Object properties) {
    this.properties = properties;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    View view = (View) o;
    return Objects.equals(this.links, view.links) &&
        Objects.equals(this.id, view.id) &&
        Objects.equals(this.name, view.name) &&
        Objects.equals(this.properties, view.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(links, id, name, properties);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class View {\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public class ViewPropertiesAdapter implements JsonDeserializer<Object>, JsonSerializer<Object> {

    public ViewPropertiesAdapter() {
    }

    @Override
    public Object deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

      List<String> discriminator = Arrays.asList("shape", "type");

      JsonObject jsonObject = json.getAsJsonObject();

      String[] types = discriminator.stream().map(d -> jsonObject.get(d).getAsString()).toArray(String[]::new);

      return deserialize(types, jsonObject, context);
    }

    @Override
    public JsonElement serialize(Object object, Type typeOfSrc, JsonSerializationContext context) {

      return context.serialize(object);
    }

    private Object deserialize(final String[] types, final JsonElement json, final JsonDeserializationContext context) {

      if (Arrays.equals(new String[]{ "chronograf-v2", "line-plus-single-stat" }, types)) {
        return context.deserialize(json, LinePlusSingleStatProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "xy" }, types)) {
        return context.deserialize(json, XYViewProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "single-stat" }, types)) {
        return context.deserialize(json, SingleStatViewProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "histogram" }, types)) {
        return context.deserialize(json, HistogramViewProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "gauge" }, types)) {
        return context.deserialize(json, GaugeViewProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "table" }, types)) {
        return context.deserialize(json, TableViewProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "markdown" }, types)) {
        return context.deserialize(json, MarkdownViewProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "log-viewer" }, types)) {
        return context.deserialize(json, LogViewProperties.class);
      }
      if (Arrays.equals(new String[]{ "chronograf-v2", "empty" }, types)) {
        return context.deserialize(json, EmptyViewProperties.class);
      }

      return context.deserialize(json, Object.class);
    }
  }
}

