package py.com.daas.adamspayintegration.model;

import java.util.Objects;
import javax.validation.constraints.*;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TMetaBadRequest
 */
@Validated
public class TMetaBadRequest   {
  /**
   * Estado de la respuesta.
   */
  public enum StatusEnum {
    SUCCESS("success"),
    
    ERROR("error");

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

  @JsonProperty("description")
  private String description = null;

  public TMetaBadRequest status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Estado de la respuesta.
   * @return status
   **/
  @Schema(example = "error", description = "Estado de la respuesta.")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TMetaBadRequest code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Código de información cuya semántica que depende de la operación solicitada
   * @return code
   **/
  @Schema(example = "missing.field", description = "Código de información cuya semántica que depende de la operación solicitada")
  
    public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public TMetaBadRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Descripción del resultado de la operación
   * @return description
   **/
  @Schema(example = "La propiedad target require un numDoc", description = "Descripción del resultado de la operación")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TMetaBadRequest tMetaBadRequest = (TMetaBadRequest) o;
    return Objects.equals(this.status, tMetaBadRequest.status) &&
        Objects.equals(this.code, tMetaBadRequest.code) &&
        Objects.equals(this.description, tMetaBadRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, code, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TMetaBadRequest {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
