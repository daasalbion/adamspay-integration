package py.com.daas.adamspayintegration.clients.model;

import java.util.Objects;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TAmount
 */
@Validated
public class TAmount   {
  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("value")
  private String value = null;

  public TAmount currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  @Schema(example = "PYG", required = true, description = "")
      @NotNull

    public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public TAmount value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @Schema(example = "300010.0000", required = true, description = "")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TAmount tAmount = (TAmount) o;
    return Objects.equals(this.currency, tAmount.currency) &&
        Objects.equals(this.value, tAmount.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TAmount {\n");
    
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
