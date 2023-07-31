package py.com.daas.adamspayintegration.clients.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TDescription
 */
@Validated
public class TDescription   {
  @JsonProperty("summary")
  private String summary = null;

  @JsonProperty("text")
  private String text = null;

  public TDescription summary(String summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Resumen de lo que se cobra
   * @return summary
   **/
  @Schema(example = "Alquiler Abril Depto 83A Edificio Coliseo, despensas incluídas", description = "Resumen de lo que se cobra")
  
    public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public TDescription text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Opcional, texto largo describiendo lo que se cobra
   * @return text
   **/
  @Schema(description = "Opcional, texto largo describiendo lo que se cobra")
  
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
    TDescription tDescription = (TDescription) o;
    return Objects.equals(this.summary, tDescription.summary) &&
        Objects.equals(this.text, tDescription.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(summary, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TDescription {\n");
    
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
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
