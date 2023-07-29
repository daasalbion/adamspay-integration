package py.com.daas.adamspayintegration.model;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DebtsDebt
 */
@Validated
@JsonInclude(Include.NON_NULL)
public class DebtsDebt   {
  @JsonProperty("docId")
  private String docId = null;

  @JsonProperty("amount")
  private TAmount amount = null;

  @JsonProperty("label")
  private String label = null;

  @JsonProperty("slug")
  private String slug = null;

  @JsonProperty("target")
  private TTarget target = null;

  @JsonProperty("validPeriod")
  private TDatePeriod validPeriod = null;

  @JsonProperty("objStatus")
  private TSetObjStatus objStatus = null;

  public DebtsDebt docId(String docId) {
    this.docId = docId;
    return this;
  }

  /**
   * Identificador opcional asignado por el comercio. Si está presente, no puede ser duplicado.
   * @return docId
   **/
  @Schema(example = "abc0001", description = "Identificador opcional asignado por el comercio. Si está presente, no puede ser duplicado.")

    public String getDocId() {
    return docId;
  }

  public void setDocId(String docId) {
    this.docId = docId;
  }

  public DebtsDebt amount(TAmount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TAmount getAmount() {
    return amount;
  }

  public void setAmount(TAmount amount) {
    this.amount = amount;
  }

  public DebtsDebt label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Título del documento de deuda
   * @return label
   **/
  @Schema(example = "Alquiler Abril 2020", required = true, description = "Título del documento de deuda")
      @NotNull

    public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public DebtsDebt slug(String slug) {
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

  public DebtsDebt target(TTarget target) {
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

  public DebtsDebt validPeriod(TDatePeriod validPeriod) {
    this.validPeriod = validPeriod;
    return this;
  }

  /**
   * Get validPeriod
   * @return validPeriod
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TDatePeriod getValidPeriod() {
    return validPeriod;
  }

  public void setValidPeriod(TDatePeriod validPeriod) {
    this.validPeriod = validPeriod;
  }

  public DebtsDebt objStatus(TSetObjStatus objStatus) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DebtsDebt debtsDebt = (DebtsDebt) o;
    return Objects.equals(this.docId, debtsDebt.docId) &&
        Objects.equals(this.amount, debtsDebt.amount) &&
        Objects.equals(this.label, debtsDebt.label) &&
        Objects.equals(this.slug, debtsDebt.slug) &&
        Objects.equals(this.target, debtsDebt.target) &&
        Objects.equals(this.validPeriod, debtsDebt.validPeriod) &&
        Objects.equals(this.objStatus, debtsDebt.objStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docId, amount, label, slug, target, validPeriod, objStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DebtsDebt {\n");
    
    sb.append("    docId: ").append(toIndentedString(docId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    validPeriod: ").append(toIndentedString(validPeriod)).append("\n");
    sb.append("    objStatus: ").append(toIndentedString(objStatus)).append("\n");
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
