package py.com.daas.adamspayintegration.model;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TDebtDoc
 */
@Validated
public class TDebtDoc   {
  @JsonProperty("docId")
  private String docId = null;

  @JsonProperty("amount")
  private TPaidAmount amount = null;

  @JsonProperty("label")
  private String label = null;

  @JsonProperty("slug")
  private String slug = null;

  @JsonProperty("target")
  private TTarget target = null;

  @JsonProperty("description")
  private TDescription description = null;

  @JsonProperty("validPeriod")
  private TDatePeriod validPeriod = null;

  @JsonProperty("objStatus")
  private TObjStatus objStatus = null;

  @JsonProperty("payStatus")
  private TPayStatus payStatus = null;

  @JsonProperty("notifyStatus")
  private TNotifyStatus notifyStatus = null;

  @JsonProperty("payUrl")
  private String payUrl = null;

  @JsonProperty("returnUrl")
  private String returnUrl = null;

  @JsonProperty("refs")
  @Valid
  private Map<String, Object> refs = null;

  @JsonProperty("objId")
  private String objId = null;

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("updated")
  private OffsetDateTime updated = null;

  public TDebtDoc docId(String docId) {
    this.docId = docId;
    return this;
  }

  /**
   * Identificador único dado al crear el documento.
   * @return docId
   **/
  @Schema(example = "abc0001", required = true, description = "Identificador único dado al crear el documento.")
      @NotNull

    public String getDocId() {
    return docId;
  }

  public void setDocId(String docId) {
    this.docId = docId;
  }

  public TDebtDoc amount(TPaidAmount amount) {
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
    public TPaidAmount getAmount() {
    return amount;
  }

  public void setAmount(TPaidAmount amount) {
    this.amount = amount;
  }

  public TDebtDoc label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Concepto a cobrar
   * @return label
   **/
  @Schema(example = "Alquiler Abril Depto 83A Edificio Coliseo", required = true, description = "Concepto a cobrar")
      @NotNull

    public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public TDebtDoc slug(String slug) {
    this.slug = slug;
    return this;
  }

  /**
   * identificador opcional del documento usado para general el URL de pago
   * @return slug
   **/
  @Schema(example = "coliseo-83a-abril-2019", description = "identificador opcional del documento usado para general el URL de pago")
  
    public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public TDebtDoc target(TTarget target) {
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

  public TDebtDoc description(TDescription description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TDescription getDescription() {
    return description;
  }

  public void setDescription(TDescription description) {
    this.description = description;
  }

  public TDebtDoc validPeriod(TDatePeriod validPeriod) {
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

  public TDebtDoc objStatus(TObjStatus objStatus) {
    this.objStatus = objStatus;
    return this;
  }

  /**
   * Get objStatus
   * @return objStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TObjStatus getObjStatus() {
    return objStatus;
  }

  public void setObjStatus(TObjStatus objStatus) {
    this.objStatus = objStatus;
  }

  public TDebtDoc payStatus(TPayStatus payStatus) {
    this.payStatus = payStatus;
    return this;
  }

  /**
   * Get payStatus
   * @return payStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TPayStatus getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(TPayStatus payStatus) {
    this.payStatus = payStatus;
  }

  public TDebtDoc notifyStatus(TNotifyStatus notifyStatus) {
    this.notifyStatus = notifyStatus;
    return this;
  }

  /**
   * Get notifyStatus
   * @return notifyStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public TNotifyStatus getNotifyStatus() {
    return notifyStatus;
  }

  public void setNotifyStatus(TNotifyStatus notifyStatus) {
    this.notifyStatus = notifyStatus;
  }

  public TDebtDoc payUrl(String payUrl) {
    this.payUrl = payUrl;
    return this;
  }

  /**
   * URL de información y/o para pagar esta deuda
   * @return payUrl
   **/
  @Schema(example = "https://ejemplo.host/payment/34993949394", required = true, description = "URL de información y/o para pagar esta deuda")
      @NotNull

    public String getPayUrl() {
    return payUrl;
  }

  public void setPayUrl(String payUrl) {
    this.payUrl = payUrl;
  }

  public TDebtDoc returnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
    return this;
  }

  /**
   * URL para opcional a la cual retornar al cerrar la página especificada en \"payUrl\".
   * @return returnUrl
   **/
  @Schema(example = "default", description = "URL para opcional a la cual retornar al cerrar la página especificada en \"payUrl\".")
  
    public String getReturnUrl() {
    return returnUrl;
  }

  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public TDebtDoc refs(Map<String, Object> refs) {
    this.refs = refs;
    return this;
  }

  public TDebtDoc putRefsItem(String key, Object refsItem) {
    if (this.refs == null) {
      this.refs = new HashMap<String, Object>();
    }
    this.refs.put(key, refsItem);
    return this;
  }

  /**
   * Otros objetos referenciados por la deuda
   * @return refs
   **/
  @Schema(description = "Otros objetos referenciados por la deuda")
  
    public Map<String, Object> getRefs() {
    return refs;
  }

  public void setRefs(Map<String, Object> refs) {
    this.refs = refs;
  }

  public TDebtDoc objId(String objId) {
    this.objId = objId;
    return this;
  }

  /**
   * Identificador interno (de referencia) del documento.
   * @return objId
   **/
  @Schema(example = "5f2d9e45-f59d-49a1-b66f-aa06e2efa442", required = true, description = "Identificador interno (de referencia) del documento.")
      @NotNull

    public String getObjId() {
    return objId;
  }

  public void setObjId(String objId) {
    this.objId = objId;
  }

  public TDebtDoc created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
   **/
  @Schema(example = "2019-07-21T17:30Z", description = "")
  
    @Valid
    public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public TDebtDoc updated(OffsetDateTime updated) {
    this.updated = updated;
    return this;
  }

  /**
   * Get updated
   * @return updated
   **/
  @Schema(example = "2019-07-21T17:30Z", description = "")
  
    @Valid
    public OffsetDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(OffsetDateTime updated) {
    this.updated = updated;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TDebtDoc tDebtDoc = (TDebtDoc) o;
    return Objects.equals(this.docId, tDebtDoc.docId) &&
        Objects.equals(this.amount, tDebtDoc.amount) &&
        Objects.equals(this.label, tDebtDoc.label) &&
        Objects.equals(this.slug, tDebtDoc.slug) &&
        Objects.equals(this.target, tDebtDoc.target) &&
        Objects.equals(this.description, tDebtDoc.description) &&
        Objects.equals(this.validPeriod, tDebtDoc.validPeriod) &&
        Objects.equals(this.objStatus, tDebtDoc.objStatus) &&
        Objects.equals(this.payStatus, tDebtDoc.payStatus) &&
        Objects.equals(this.notifyStatus, tDebtDoc.notifyStatus) &&
        Objects.equals(this.payUrl, tDebtDoc.payUrl) &&
        Objects.equals(this.returnUrl, tDebtDoc.returnUrl) &&
        Objects.equals(this.refs, tDebtDoc.refs) &&
        Objects.equals(this.objId, tDebtDoc.objId) &&
        Objects.equals(this.created, tDebtDoc.created) &&
        Objects.equals(this.updated, tDebtDoc.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(docId, amount, label, slug, target, description, validPeriod, objStatus, payStatus, notifyStatus, payUrl, returnUrl, refs, objId, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TDebtDoc {\n");
    
    sb.append("    docId: ").append(toIndentedString(docId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    validPeriod: ").append(toIndentedString(validPeriod)).append("\n");
    sb.append("    objStatus: ").append(toIndentedString(objStatus)).append("\n");
    sb.append("    payStatus: ").append(toIndentedString(payStatus)).append("\n");
    sb.append("    notifyStatus: ").append(toIndentedString(notifyStatus)).append("\n");
    sb.append("    payUrl: ").append(toIndentedString(payUrl)).append("\n");
    sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
    sb.append("    refs: ").append(toIndentedString(refs)).append("\n");
    sb.append("    objId: ").append(toIndentedString(objId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    updated: ").append(toIndentedString(updated)).append("\n");
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
