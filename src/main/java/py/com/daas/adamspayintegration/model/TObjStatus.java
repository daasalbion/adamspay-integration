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
 * TObjStatus
 */
@Validated
public class TObjStatus   {
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

  public TObjStatus status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Estado de un objeto en el sistema
   * @return status
   **/
  @Schema(example = "success", required = true, description = "Estado de un objeto en el sistema")
      @NotNull

    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TObjStatus code(String code) {
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

  public TObjStatus time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Fecha del estado
   * @return time
   **/
  @Schema(example = "2019-07-30T19:30Z", required = true, description = "Fecha del estado")
      @NotNull

    @Valid
    public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public TObjStatus text(String text) {
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
    TObjStatus tObjStatus = (TObjStatus) o;
    return Objects.equals(this.status, tObjStatus.status) &&
        Objects.equals(this.code, tObjStatus.code) &&
        Objects.equals(this.time, tObjStatus.time) &&
        Objects.equals(this.text, tObjStatus.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, code, time, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TObjStatus {\n");
    
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
