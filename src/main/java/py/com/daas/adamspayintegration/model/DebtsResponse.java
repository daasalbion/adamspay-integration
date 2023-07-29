package py.com.daas.adamspayintegration.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DebtsReponse
 */
@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebtsResponse {
  @JsonProperty("meta")
  private TMetaSuccess meta = null;

  @JsonProperty("debt")
  private TDebtDoc debt = null;

  public DebtsResponse meta(TMetaSuccess meta) {
    this.meta = meta;
    return this;
  }

  /**
   * Get meta
   * @return meta
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TMetaSuccess getMeta() {
    return meta;
  }

  public void setMeta(TMetaSuccess meta) {
    this.meta = meta;
  }

  public DebtsResponse debt(TDebtDoc debt) {
    this.debt = debt;
    return this;
  }

  /**
   * Get debt
   * @return debt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TDebtDoc getDebt() {
    return debt;
  }

  public void setDebt(TDebtDoc debt) {
    this.debt = debt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DebtsResponse DebtsResponse = (DebtsResponse) o;
    return Objects.equals(this.meta, DebtsResponse.meta) &&
        Objects.equals(this.debt, DebtsResponse.debt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meta, debt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DebtsReponse {\n");
    
    sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
    sb.append("    debt: ").append(toIndentedString(debt)).append("\n");
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
