package py.com.daas.adamspayintegration.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Propiedades del documento a modificar. Si están presentes, se modifican.
 */
@Schema(description = "Propiedades del documento a modificar. Si están presentes, se modifican.")
@Validated
public class DebtsdocIdDebt   {
  @JsonProperty("label")
  private String label = null;

  @JsonProperty("slug")
  private String slug = null;

  @JsonProperty("amount")
  private TAmount amount = null;

  @JsonProperty("target")
  private TTarget target = null;

  @JsonProperty("objStatus")
  private TSetObjStatus objStatus = null;

  @JsonProperty("validPeriod")
  private TDatePeriod validPeriod = null;

  public DebtsdocIdDebt label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Concepto a cobrar
   * @return label
   **/
  @Schema(example = "Alquiler Abril Depto 83A Edificio Coliseo", description = "Concepto a cobrar")
  
    public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public DebtsdocIdDebt slug(String slug) {
    this.slug = slug;
    return this;
  }

  /**
   * Identificador para la URL de pago. Si está presente, no puede ser duplicado, si es omite es igual al ID del documento.
   * @return slug
   **/
  @Schema(example = "coliseo-83a-abril-2019", description = "Identificador para la URL de pago. Si está presente, no puede ser duplicado, si es omite es igual al ID del documento.")
  
    public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public DebtsdocIdDebt amount(TAmount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(description = "")
  
    @Valid
    public TAmount getAmount() {
    return amount;
  }

  public void setAmount(TAmount amount) {
    this.amount = amount;
  }

  public DebtsdocIdDebt target(TTarget target) {
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
   **/
  @Schema(description = "")
  
    @Valid
    public TTarget getTarget() {
    return target;
  }

  public void setTarget(TTarget target) {
    this.target = target;
  }

  public DebtsdocIdDebt objStatus(TSetObjStatus objStatus) {
    this.objStatus = objStatus;
    return this;
  }

  /**
   * Get objStatus
   * @return objStatus
   **/
  @Schema(description = "")
  
    @Valid
    public TSetObjStatus getObjStatus() {
    return objStatus;
  }

  public void setObjStatus(TSetObjStatus objStatus) {
    this.objStatus = objStatus;
  }

  public DebtsdocIdDebt validPeriod(TDatePeriod validPeriod) {
    this.validPeriod = validPeriod;
    return this;
  }

  /**
   * Get validPeriod
   * @return validPeriod
   **/
  @Schema(description = "")
  
    @Valid
    public TDatePeriod getValidPeriod() {
    return validPeriod;
  }

  public void setValidPeriod(TDatePeriod validPeriod) {
    this.validPeriod = validPeriod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DebtsdocIdDebt debtsdocIdDebt = (DebtsdocIdDebt) o;
    return Objects.equals(this.label, debtsdocIdDebt.label) &&
        Objects.equals(this.slug, debtsdocIdDebt.slug) &&
        Objects.equals(this.amount, debtsdocIdDebt.amount) &&
        Objects.equals(this.target, debtsdocIdDebt.target) &&
        Objects.equals(this.objStatus, debtsdocIdDebt.objStatus) &&
        Objects.equals(this.validPeriod, debtsdocIdDebt.validPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, slug, amount, target, objStatus, validPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DebtsdocIdDebt {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    objStatus: ").append(toIndentedString(objStatus)).append("\n");
    sb.append("    validPeriod: ").append(toIndentedString(validPeriod)).append("\n");
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
