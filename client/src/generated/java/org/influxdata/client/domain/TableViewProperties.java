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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.influxdata.client.domain.DashboardColor;
import org.influxdata.client.domain.DashboardQuery;
import org.influxdata.client.domain.DecimalPlaces;
import org.influxdata.client.domain.RenamableField;
import org.influxdata.client.domain.ViewProperties;

/**
 * TableViewProperties
 */

public class TableViewProperties extends ViewProperties {
  /**
   * Gets or Sets shape
   */
  @JsonAdapter(ShapeEnum.Adapter.class)
  public enum ShapeEnum {
    CHRONOGRAF_V2("chronograf-v2");

    private String value;

    ShapeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ShapeEnum fromValue(String text) {
      for (ShapeEnum b : ShapeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ShapeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ShapeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ShapeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ShapeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_SHAPE = "shape";
  @SerializedName(SERIALIZED_NAME_SHAPE)
  private ShapeEnum shape = ShapeEnum.CHRONOGRAF_V2;

  /**
   * Gets or Sets type
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    TABLE("table");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type = TypeEnum.TABLE;

  public static final String SERIALIZED_NAME_TABLE_OPTIONS = "tableOptions";
  @SerializedName(SERIALIZED_NAME_TABLE_OPTIONS)
  private Object tableOptions = null;

  public static final String SERIALIZED_NAME_FIELD_OPTIONS = "fieldOptions";
  @SerializedName(SERIALIZED_NAME_FIELD_OPTIONS)
  private List<RenamableField> fieldOptions = new ArrayList<>();

  public static final String SERIALIZED_NAME_TIME_FORMAT = "timeFormat";
  @SerializedName(SERIALIZED_NAME_TIME_FORMAT)
  private String timeFormat;

  public static final String SERIALIZED_NAME_DECIMAL_PLACES = "decimalPlaces";
  @SerializedName(SERIALIZED_NAME_DECIMAL_PLACES)
  private DecimalPlaces decimalPlaces = null;

   /**
   * Get shape
   * @return shape
  **/
  @ApiModelProperty(value = "")
  public ShapeEnum getShape() {
    return shape;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public TypeEnum getType() {
    return type;
  }

  public TableViewProperties tableOptions(Object tableOptions) {
    this.tableOptions = tableOptions;
    return this;
  }

   /**
   * Get tableOptions
   * @return tableOptions
  **/
  @ApiModelProperty(value = "")
  public Object getTableOptions() {
    return tableOptions;
  }

  public void setTableOptions(Object tableOptions) {
    this.tableOptions = tableOptions;
  }

  public TableViewProperties fieldOptions(List<RenamableField> fieldOptions) {
    this.fieldOptions = fieldOptions;
    return this;
  }

  public TableViewProperties addFieldOptionsItem(RenamableField fieldOptionsItem) {
    if (this.fieldOptions == null) {
      this.fieldOptions = new ArrayList<>();
    }
    this.fieldOptions.add(fieldOptionsItem);
    return this;
  }

   /**
   * fieldOptions represent the fields retrieved by the query with customization options
   * @return fieldOptions
  **/
  @ApiModelProperty(value = "fieldOptions represent the fields retrieved by the query with customization options")
  public List<RenamableField> getFieldOptions() {
    return fieldOptions;
  }

  public void setFieldOptions(List<RenamableField> fieldOptions) {
    this.fieldOptions = fieldOptions;
  }

  public TableViewProperties timeFormat(String timeFormat) {
    this.timeFormat = timeFormat;
    return this;
  }

   /**
   * timeFormat describes the display format for time values according to moment.js date formatting
   * @return timeFormat
  **/
  @ApiModelProperty(value = "timeFormat describes the display format for time values according to moment.js date formatting")
  public String getTimeFormat() {
    return timeFormat;
  }

  public void setTimeFormat(String timeFormat) {
    this.timeFormat = timeFormat;
  }

  public TableViewProperties decimalPlaces(DecimalPlaces decimalPlaces) {
    this.decimalPlaces = decimalPlaces;
    return this;
  }

   /**
   * Get decimalPlaces
   * @return decimalPlaces
  **/
  @ApiModelProperty(value = "")
  public DecimalPlaces getDecimalPlaces() {
    return decimalPlaces;
  }

  public void setDecimalPlaces(DecimalPlaces decimalPlaces) {
    this.decimalPlaces = decimalPlaces;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TableViewProperties tableViewProperties = (TableViewProperties) o;
    return Objects.equals(this.shape, tableViewProperties.shape) &&
        Objects.equals(this.type, tableViewProperties.type) &&
        Objects.equals(this.tableOptions, tableViewProperties.tableOptions) &&
        Objects.equals(this.fieldOptions, tableViewProperties.fieldOptions) &&
        Objects.equals(this.timeFormat, tableViewProperties.timeFormat) &&
        Objects.equals(this.decimalPlaces, tableViewProperties.decimalPlaces) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shape, type, tableOptions, fieldOptions, timeFormat, decimalPlaces, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableViewProperties {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    shape: ").append(toIndentedString(shape)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    tableOptions: ").append(toIndentedString(tableOptions)).append("\n");
    sb.append("    fieldOptions: ").append(toIndentedString(fieldOptions)).append("\n");
    sb.append("    timeFormat: ").append(toIndentedString(timeFormat)).append("\n");
    sb.append("    decimalPlaces: ").append(toIndentedString(decimalPlaces)).append("\n");
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

}

