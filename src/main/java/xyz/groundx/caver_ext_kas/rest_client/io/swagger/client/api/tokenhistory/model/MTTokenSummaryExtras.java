/*
 * Token History API
 * # Introduction  Token History API allows you to query the transaction history of KLAY, FTs (KIP-7 and Labelled ERC-20), NFTs (KIP-17 and Labelled ERC-721), and MTs (KIP-37 and Labelled ERC-1155). You can track KLAY's transaction history or retrieve NFT-related data of a certain EOA.   For more details on using Token History API, please refer to the [Tutorial](https://docs.klaytnapi.com/tutorial).   For any inquiries on this document or KAS in general, please visit [Developer Forum](https://forum.klaytn.com/).  
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package xyz.groundx.caver_ext_kas.rest_client.io.swagger.client.api.tokenhistory.model;

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
 * MTTokenSummaryExtras
 */


public class MTTokenSummaryExtras {
  @SerializedName("tokenId")
  private String tokenId = null;

  @SerializedName("tokenUri")
  private String tokenUri = null;

  @SerializedName("totalSupply")
  private String totalSupply = null;

  public MTTokenSummaryExtras tokenId(String tokenId) {
    this.tokenId = tokenId;
    return this;
  }

   /**
   * Token ID (in hexadecimal)
   * @return tokenId
  **/
  @Schema(example = "1", description = "Token ID (in hexadecimal)")
  public String getTokenId() {
    return tokenId;
  }

  public void setTokenId(String tokenId) {
    this.tokenId = tokenId;
  }

  public MTTokenSummaryExtras tokenUri(String tokenUri) {
    this.tokenUri = tokenUri;
    return this;
  }

   /**
   * Token URL
   * @return tokenUri
  **/
  @Schema(example = "https://link.to/mt/1", description = "Token URL")
  public String getTokenUri() {
    return tokenUri;
  }

  public void setTokenUri(String tokenUri) {
    this.tokenUri = tokenUri;
  }

  public MTTokenSummaryExtras totalSupply(String totalSupply) {
    this.totalSupply = totalSupply;
    return this;
  }

   /**
   * Total issued amount (in hexadecimal)
   * @return totalSupply
  **/
  @Schema(example = "1000000000000000000", description = "Total issued amount (in hexadecimal)")
  public String getTotalSupply() {
    return totalSupply;
  }

  public void setTotalSupply(String totalSupply) {
    this.totalSupply = totalSupply;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MTTokenSummaryExtras mtTokenSummaryExtras = (MTTokenSummaryExtras) o;
    return Objects.equals(this.tokenId, mtTokenSummaryExtras.tokenId) &&
        Objects.equals(this.tokenUri, mtTokenSummaryExtras.tokenUri) &&
        Objects.equals(this.totalSupply, mtTokenSummaryExtras.totalSupply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenId, tokenUri, totalSupply);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MTTokenSummaryExtras {\n");
    
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    tokenUri: ").append(toIndentedString(tokenUri)).append("\n");
    sb.append("    totalSupply: ").append(toIndentedString(totalSupply)).append("\n");
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
