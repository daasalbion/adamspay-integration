package py.com.daas.adamspayintegration.clients.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DebtsDocIdBody
 */
@Validated
public class DebtsDocIdBody   {
  @JsonProperty("debt")
  private DebtsdocIdDebt debt = null;

  public DebtsDocIdBody debt(DebtsdocIdDebt debt) {
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
    public DebtsdocIdDebt getDebt() {
    return debt;
  }

  public void setDebt(DebtsdocIdDebt debt) {
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
    DebtsDocIdBody debtsDocIdBody = (DebtsDocIdBody) o;
    return Objects.equals(this.debt, debtsDocIdBody.debt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(debt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DebtsDocIdBody {\n");
    
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
