package py.com.daas.adamspayintegration.model;

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
 * TPayStatus
 */
@Validated
public class TPayStatus   {
  /**
   * Estado del pago
   */
  public enum StatusEnum {
    PENDING("pending"),
    
    PAID("paid");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("time")
  private OffsetDateTime time = null;

  @JsonProperty("text")
  private String text = null;

  public TPayStatus status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Estado del pago
   * @return status
   **/
  @Schema(example = "pending", required = true, description = "Estado del pago")
      @NotNull

    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TPayStatus code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Información adicional del estado
   * @return code
   **/
  @Schema(example = "204", description = "Información adicional del estado")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public TPayStatus time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Fecha de actualización del estado
   * @return time
   **/
  @Schema(example = "2019-07-30T19:30Z", description = "Fecha de actualización del estado")
  
    @Valid
    public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public TPayStatus text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Texto de información adicional del estado
   * @return text
   **/
  @Schema(example = "Rechazado por emisor", description = "Texto de información adicional del estado")
  
    public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TPayStatus tPayStatus = (TPayStatus) o;
    return Objects.equals(this.status, tPayStatus.status) &&
        Objects.equals(this.code, tPayStatus.code) &&
        Objects.equals(this.time, tPayStatus.time) &&
        Objects.equals(this.text, tPayStatus.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, code, time, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TPayStatus {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
