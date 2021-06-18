/*
 * KIP-7 API
 * # Introduction KIP-7 API is a RESTful API for managing KIP-7 contracts and tokens that follow the [KIP-7 Fungible Token Standard](https://kips.klaytn.com/KIPs/kip-7).   You can deploy contracts and send tokens using the default contract managing account (`deployer`) and an `alias`. And by using SDK like caver,  you can manage your contracts and tokens using [Wallet API](https://refs.klaytnapi.com/en/wallet/latest) for contracts created on the Klaytn Network.     # Error Codes  ## 400: Bad Request   | Code | Messages |   | --- | --- |  | 1130050 | incorrect request; spender 1130107 | incorrect bookmark 1134410 | invalid address; to</br>invalid address; owner</br>invalid address; address 1134411 | invalid amount; amount |  ## 404: Not Found   | Code | Messages |  | --- | --- |  | 1134504 | contract not found 1134506 | deployer not found |   ## 409: Conflict   | Code | Messages |   | --- | --- |   | 1134900 | duplicate alias 1134902 | contract already paused 1134903 | contract already unpaused |  
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package xyz.groundx.caver_ext_kas.rest_client.io.swagger.client.api.kip7.model;

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
 * Kip7ContractMetadataResponse
 */


public class Kip7ContractMetadataResponse {
  @SerializedName("address")
  private String address = null;

  @SerializedName("decimals")
  private Long decimals = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("symbol")
  private String symbol = null;

  @SerializedName("totalSupply")
  private String totalSupply = null;

  public Kip7ContractMetadataResponse address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Contract address
   * @return address
  **/
  @Schema(example = "0x0f73bb170deb398180f02e60d7ea154c270b8fb9", required = true, description = "Contract address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Kip7ContractMetadataResponse decimals(Long decimals) {
    this.decimals = decimals;
    return this;
  }

   /**
   * Token decimal place
   * @return decimals
  **/
  @Schema(example = "8", required = true, description = "Token decimal place")
  public Long getDecimals() {
    return decimals;
  }

  public void setDecimals(Long decimals) {
    this.decimals = decimals;
  }

  public Kip7ContractMetadataResponse name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Contract name
   * @return name
  **/
  @Schema(example = "MyKIP7", required = true, description = "Contract name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Kip7ContractMetadataResponse symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

   /**
   * Contract symbol
   * @return symbol
  **/
  @Schema(example = "MSK7", required = true, description = "Contract symbol")
  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Kip7ContractMetadataResponse totalSupply(String totalSupply) {
    this.totalSupply = totalSupply;
    return this;
  }

   /**
   * Total supply (in hexadecimal)
   * @return totalSupply
  **/
  @Schema(example = "0x500", required = true, description = "Total supply (in hexadecimal)")
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
    Kip7ContractMetadataResponse kip7ContractMetadataResponse = (Kip7ContractMetadataResponse) o;
    return Objects.equals(this.address, kip7ContractMetadataResponse.address) &&
        Objects.equals(this.decimals, kip7ContractMetadataResponse.decimals) &&
        Objects.equals(this.name, kip7ContractMetadataResponse.name) &&
        Objects.equals(this.symbol, kip7ContractMetadataResponse.symbol) &&
        Objects.equals(this.totalSupply, kip7ContractMetadataResponse.totalSupply);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, decimals, name, symbol, totalSupply);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Kip7ContractMetadataResponse {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    decimals: ").append(toIndentedString(decimals)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
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
