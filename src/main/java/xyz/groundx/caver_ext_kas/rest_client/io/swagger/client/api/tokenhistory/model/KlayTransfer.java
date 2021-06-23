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
 * KlayTransfer
 */


public class KlayTransfer implements AnyOfTransferArrayItems {
  @SerializedName("feePayer")
  private String feePayer = null;

  @SerializedName("feeRatio")
  private Integer feeRatio = null;

  @SerializedName("fee")
  private String fee = null;

  @SerializedName("from")
  private String from = null;

  @SerializedName("to")
  private String to = null;

  @SerializedName("transactionHash")
  private String transactionHash = null;

  @SerializedName("transactionIndex")
  private Integer transactionIndex = null;

  @SerializedName("transferType")
  private String transferType = null;

  @SerializedName("typeInt")
  private Integer typeInt = null;

  @SerializedName("value")
  private String value = null;

  public KlayTransfer feePayer(String feePayer) {
    this.feePayer = feePayer;
    return this;
  }

   /**
   * Fee delegation account address (20-byte)
   * @return feePayer
  **/
  @Schema(example = "0xd0ea3e0eabaea095ea3ba231c043dbf8c0feb40a", required = true, description = "Fee delegation account address (20-byte)")
  public String getFeePayer() {
    return feePayer;
  }

  public void setFeePayer(String feePayer) {
    this.feePayer = feePayer;
  }

  public KlayTransfer feeRatio(Integer feeRatio) {
    this.feeRatio = feeRatio;
    return this;
  }

   /**
   * Fee delegation ratio
   * @return feeRatio
  **/
  @Schema(example = "100", required = true, description = "Fee delegation ratio")
  public Integer getFeeRatio() {
    return feeRatio;
  }

  public void setFeeRatio(Integer feeRatio) {
    this.feeRatio = feeRatio;
  }

  public KlayTransfer fee(String fee) {
    this.fee = fee;
    return this;
  }

   /**
   * Gas fee
   * @return fee
  **/
  @Schema(example = "0xa455", required = true, description = "Gas fee")
  public String getFee() {
    return fee;
  }

  public void setFee(String fee) {
    this.fee = fee;
  }

  public KlayTransfer from(String from) {
    this.from = from;
    return this;
  }

   /**
   * Sender EOA (20-byte)
   * @return from
  **/
  @Schema(example = "0x5e47b195eeb11d72f5e1d27aebb6d341f1a9bedb", required = true, description = "Sender EOA (20-byte)")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public KlayTransfer to(String to) {
    this.to = to;
    return this;
  }

   /**
   * Receiver EOA (20-byte)
   * @return to
  **/
  @Schema(example = "0xb4bf60383c64d47f2e667f2fe8f7ed0c9380f770", required = true, description = "Receiver EOA (20-byte)")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public KlayTransfer transactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
    return this;
  }

   /**
   * Transaction hash
   * @return transactionHash
  **/
  @Schema(example = "0xc4a32f41e829f50c4e8774be68864f522120a2047db2143b59b3919ebd9234f8", required = true, description = "Transaction hash")
  public String getTransactionHash() {
    return transactionHash;
  }

  public void setTransactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
  }

  public KlayTransfer transactionIndex(Integer transactionIndex) {
    this.transactionIndex = transactionIndex;
    return this;
  }

   /**
   * Transaction index
   * @return transactionIndex
  **/
  @Schema(example = "1", required = true, description = "Transaction index")
  public Integer getTransactionIndex() {
    return transactionIndex;
  }

  public void setTransactionIndex(Integer transactionIndex) {
    this.transactionIndex = transactionIndex;
  }

  public KlayTransfer transferType(String transferType) {
    this.transferType = transferType;
    return this;
  }

   /**
   * Transactino type
   * @return transferType
  **/
  @Schema(example = "klay", required = true, description = "Transactino type")
  public String getTransferType() {
    return transferType;
  }

  public void setTransferType(String transferType) {
    this.transferType = transferType;
  }

  public KlayTransfer typeInt(Integer typeInt) {
    this.typeInt = typeInt;
    return this;
  }

   /**
   * Transaction type
   * @return typeInt
  **/
  @Schema(example = "50", required = true, description = "Transaction type")
  public Integer getTypeInt() {
    return typeInt;
  }

  public void setTypeInt(Integer typeInt) {
    this.typeInt = typeInt;
  }

  public KlayTransfer value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Amount of KLAY transferred (in hexadecimal)
   * @return value
  **/
  @Schema(example = "0xa", required = true, description = "Amount of KLAY transferred (in hexadecimal)")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KlayTransfer klayTransfer = (KlayTransfer) o;
    return Objects.equals(this.feePayer, klayTransfer.feePayer) &&
        Objects.equals(this.feeRatio, klayTransfer.feeRatio) &&
        Objects.equals(this.fee, klayTransfer.fee) &&
        Objects.equals(this.from, klayTransfer.from) &&
        Objects.equals(this.to, klayTransfer.to) &&
        Objects.equals(this.transactionHash, klayTransfer.transactionHash) &&
        Objects.equals(this.transactionIndex, klayTransfer.transactionIndex) &&
        Objects.equals(this.transferType, klayTransfer.transferType) &&
        Objects.equals(this.typeInt, klayTransfer.typeInt) &&
        Objects.equals(this.value, klayTransfer.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feePayer, feeRatio, fee, from, to, transactionHash, transactionIndex, transferType, typeInt, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KlayTransfer {\n");
    
    sb.append("    feePayer: ").append(toIndentedString(feePayer)).append("\n");
    sb.append("    feeRatio: ").append(toIndentedString(feeRatio)).append("\n");
    sb.append("    fee: ").append(toIndentedString(fee)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    transactionHash: ").append(toIndentedString(transactionHash)).append("\n");
    sb.append("    transactionIndex: ").append(toIndentedString(transactionIndex)).append("\n");
    sb.append("    transferType: ").append(toIndentedString(transferType)).append("\n");
    sb.append("    typeInt: ").append(toIndentedString(typeInt)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
