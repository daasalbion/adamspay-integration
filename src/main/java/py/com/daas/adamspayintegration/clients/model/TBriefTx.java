package py.com.daas.adamspayintegration.clients.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TBriefTx
 */
@Validated
public class TBriefTx   {
  @JsonProperty("txId")
  private String txId = null;

  /**
   * Tipo de transacción
   */
  public enum TypeEnum {
    DEBTDOCPAY("debtDocPay"),
    
    DEBTDOCREVERSE("debtDocReverse");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("objStatus")
  private TObjStatus objStatus = null;

  @JsonProperty("provider")
  private String provider = null;

  @JsonProperty("method")
  private String method = null;

  @JsonProperty("material")
  private String material = null;

  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("origAmount")
  private TAmount origAmount = null;

  @JsonProperty("realAmount")
  private TAmount realAmount = null;

  @JsonProperty("expires")
  private OffsetDateTime expires = null;

  @JsonProperty("finalized")
  private OffsetDateTime finalized = null;

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("updated")
  private OffsetDateTime updated = null;

  public TBriefTx txId(String txId) {
    this.txId = txId;
    return this;
  }

  /**
   * Identificador único de la transacción
   * @return txId
   **/
  @Schema(example = "92263000000004", required = true, description = "Identificador único de la transacción")
      @NotNull

    public String getTxId() {
    return txId;
  }

  public void setTxId(String txId) {
    this.txId = txId;
  }

  public TBriefTx type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Tipo de transacción
   * @return type
   **/
  @Schema(example = "debtDocPay", description = "Tipo de transacción")
  
    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public TBriefTx objStatus(TObjStatus objStatus) {
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

  public TBriefTx provider(String provider) {
    this.provider = provider;
    return this;
  }

  /**
   * Identificador del provedor de pago
   * @return provider
   **/
  @Schema(example = "adams", required = true, description = "Identificador del provedor de pago")
      @NotNull

    public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public TBriefTx method(String method) {
    this.method = method;
    return this;
  }

  /**
   * Método de pago
   * @return method
   **/
  @Schema(example = "simulator", description = "Método de pago")
  
    public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public TBriefTx material(String material) {
    this.material = material;
    return this;
  }

  /**
   * Material de pago
   * @return material
   **/
  @Schema(example = "cash", description = "Material de pago")
  
    public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public TBriefTx correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * Id de transacción del proveedor de pago
   * @return correlationId
   **/
  @Schema(example = "992938383", description = "Id de transacción del proveedor de pago")
  
    public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public TBriefTx origAmount(TAmount origAmount) {
    this.origAmount = origAmount;
    return this;
  }

  /**
   * Get origAmount
   * @return origAmount
   **/
  @Schema(description = "")
  
    @Valid
    public TAmount getOrigAmount() {
    return origAmount;
  }

  public void setOrigAmount(TAmount origAmount) {
    this.origAmount = origAmount;
  }

  public TBriefTx realAmount(TAmount realAmount) {
    this.realAmount = realAmount;
    return this;
  }

  /**
   * Get realAmount
   * @return realAmount
   **/
  @Schema(description = "")
  
    @Valid
    public TAmount getRealAmount() {
    return realAmount;
  }

  public void setRealAmount(TAmount realAmount) {
    this.realAmount = realAmount;
  }

  public TBriefTx expires(OffsetDateTime expires) {
    this.expires = expires;
    return this;
  }

  /**
   * Fecha en la cual expirará la transacción si no es finalizada
   * @return expires
   **/
  @Schema(example = "2019-07-21T17:30Z", description = "Fecha en la cual expirará la transacción si no es finalizada")
  
    @Valid
    public OffsetDateTime getExpires() {
    return expires;
  }

  public void setExpires(OffsetDateTime expires) {
    this.expires = expires;
  }

  public TBriefTx finalized(OffsetDateTime finalized) {
    this.finalized = finalized;
    return this;
  }

  /**
   * Fecha en la cual se finalizó la transacción (si no está pendiente)
   * @return finalized
   **/
  @Schema(example = "2019-07-21T17:30Z", description = "Fecha en la cual se finalizó la transacción (si no está pendiente)")
  
    @Valid
    public OffsetDateTime getFinalized() {
    return finalized;
  }

  public void setFinalized(OffsetDateTime finalized) {
    this.finalized = finalized;
  }

  public TBriefTx created(OffsetDateTime created) {
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

  public TBriefTx updated(OffsetDateTime updated) {
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
    TBriefTx tBriefTx = (TBriefTx) o;
    return Objects.equals(this.txId, tBriefTx.txId) &&
        Objects.equals(this.type, tBriefTx.type) &&
        Objects.equals(this.objStatus, tBriefTx.objStatus) &&
        Objects.equals(this.provider, tBriefTx.provider) &&
        Objects.equals(this.method, tBriefTx.method) &&
        Objects.equals(this.material, tBriefTx.material) &&
        Objects.equals(this.correlationId, tBriefTx.correlationId) &&
        Objects.equals(this.origAmount, tBriefTx.origAmount) &&
        Objects.equals(this.realAmount, tBriefTx.realAmount) &&
        Objects.equals(this.expires, tBriefTx.expires) &&
        Objects.equals(this.finalized, tBriefTx.finalized) &&
        Objects.equals(this.created, tBriefTx.created) &&
        Objects.equals(this.updated, tBriefTx.updated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(txId, type, objStatus, provider, method, material, correlationId, origAmount, realAmount, expires, finalized, created, updated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TBriefTx {\n");
    
    sb.append("    txId: ").append(toIndentedString(txId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    objStatus: ").append(toIndentedString(objStatus)).append("\n");
    sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    material: ").append(toIndentedString(material)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    origAmount: ").append(toIndentedString(origAmount)).append("\n");
    sb.append("    realAmount: ").append(toIndentedString(realAmount)).append("\n");
    sb.append("    expires: ").append(toIndentedString(expires)).append("\n");
    sb.append("    finalized: ").append(toIndentedString(finalized)).append("\n");
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
