package py.com.daas.adamspayintegration.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DebtsBody
 */
@Validated
public class DebtsBody   {
  @JsonProperty("debt")
  private DebtsDebt debt = null;

  public DebtsBody debt(DebtsDebt debt) {
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
    public DebtsDebt getDebt() {
    return debt;
  }

  public void setDebt(DebtsDebt debt) {
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
    DebtsBody debtsBody = (DebtsBody) o;
    return Objects.equals(this.debt, debtsBody.debt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(debt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DebtsBody {\n");
    
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
