/*
 * KIP-17 API
 *   # Error Codes  ## 400: Bad Request   | Code | Messages |   | --- | --- |   | 1100050 | incorrect request 1100101 | data don't exist 1100251 | its value is out of range; size 1104401 | failed to get an account |   ## 404: Not Found   | Code | Messages |   | --- | --- |   | 1104404 | Token not found |   ## 409: Conflict   | Code | Messages |   | --- | --- |   | 1104400 | Duplicate alias - test |  
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package xyz.groundx.caver_ext_kas.rest_client.io.swagger.client.api.kip17.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * ApproveKip17TokenRequest
 */


public class ApproveKip17TokenRequest {
  @SerializedName("from")
  private String from = null;

  @SerializedName("to")
  private String to = null;

  public ApproveKip17TokenRequest from(String from) {
    this.from = from;
    return this;
  }

   /**
   * Owner EOA address
   * @return from
  **/
  @Schema(example = "0x9EaF20b40E0f1ced5dbba6f5Cfb0D3E12B0534f4", required = true, description = "Owner EOA address")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public ApproveKip17TokenRequest to(String to) {
    this.to = to;
    return this;
  }

   /**
   * EOA address receiving the approval
   * @return to
  **/
  @Schema(example = "0xDc277E2D89b92336A4ee80be3c7142443FDaDE47", required = true, description = "EOA address receiving the approval")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApproveKip17TokenRequest approveKip17TokenRequest = (ApproveKip17TokenRequest) o;
    return Objects.equals(this.from, approveKip17TokenRequest.from) &&
        Objects.equals(this.to, approveKip17TokenRequest.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApproveKip17TokenRequest {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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
