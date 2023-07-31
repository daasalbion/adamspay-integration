package py.com.daas.adamspayintegration.clients.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * TDatePeriod
 */
@Validated
public class TDatePeriod   {
  @JsonProperty("start")
  private OffsetDateTime start = null;

  @JsonProperty("end")
  private OffsetDateTime end = null;

  public TDatePeriod start(OffsetDateTime start) {
    this.start = start;
    return this;
  }

  /**
   * Get start
   * @return start
   **/
  @Schema(example = "2019-07-21T17:30Z", required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getStart() {
    return start;
  }

  public void setStart(OffsetDateTime start) {
    this.start = start;
  }

  public TDatePeriod end(OffsetDateTime end) {
    this.end = end;
    return this;
  }

  /**
   * Get end
   * @return end
   **/
  @Schema(example = "2019-07-21T17:30Z", required = true, description = "")
      @NotNull

    @Valid
    public OffsetDateTime getEnd() {
    return end;
  }

  public void setEnd(OffsetDateTime end) {
    this.end = end;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TDatePeriod tDatePeriod = (TDatePeriod) o;
    return Objects.equals(this.start, tDatePeriod.start) &&
        Objects.equals(this.end, tDatePeriod.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TDatePeriod {\n");
    
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    end: ").append(toIndentedString(end)).append("\n");
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
