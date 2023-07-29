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
 * TSetObjStatus
 */
@Validated

public class TSetObjStatus   {
  /**
   * Estado de un objeto en el sistema
   */
  public enum StatusEnum {
    DELETED("deleted"),
    
    ERROR("error"),
    
    EXPIRED("expired"),
    
    CANCELED("canceled"),
    
    REVERSED("reversed"),
    
    INACTIVE("inactive"),
    
    ACTIVE("active"),
    
    ALERT("alert"),
    
    SUCCESS("success");

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

  public TSetObjStatus status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Estado de un objeto en el sistema
   * @return status
   **/
  @Schema(example = "success", description = "Estado de un objeto en el sistema")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TSetObjStatus code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Información adicional del estado
   * @return code
   **/
  @Schema(example = "00", description = "Información adicional del estado")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public TSetObjStatus time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Fecha del estado
   * @return time
   **/
  @Schema(example = "2019-07-30T19:30Z", description = "Fecha del estado")
  
    @Valid
    public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public TSetObjStatus text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Información adicional acerca del estado
   * @return text
   **/
  @Schema(example = "Por conciliación", description = "Información adicional acerca del estado")
  
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
    TSetObjStatus tSetObjStatus = (TSetObjStatus) o;
    return Objects.equals(this.status, tSetObjStatus.status) &&
        Objects.equals(this.code, tSetObjStatus.code) &&
        Objects.equals(this.time, tSetObjStatus.time) &&
        Objects.equals(this.text, tSetObjStatus.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, code, time, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TSetObjStatus {\n");
    
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
