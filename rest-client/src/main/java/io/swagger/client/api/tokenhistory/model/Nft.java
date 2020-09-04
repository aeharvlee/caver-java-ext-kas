/*
 * th-0.7.0-v2-public
 * # Introduction  Token History API는 KLAY, FT (KIP-7, Labeled ERC-20), NFT (KIP-17, Labeled ERC-721) 토큰 정보, 이들 토큰을 주고받은 기록을 조회하는 기능을 제공합니다. 여러분은 특정 EOA가 KLAY를 주고받은 기록을 확인하거나 EOA가 가지고 있는 NFT 정보를 불러오는 등 Token History API를 다양하게 활용할 수 있습니다.   Token History API 사용에 관한 자세한 내용은 [튜토리얼](https://klaytn.com)을 확인하십시오.   이 문서 혹은 KAS에 관한 문의는 [개발자 포럼](https://forum.klaytn.com/)을 방문해 도움을 받으십시오  
 *
 * OpenAPI spec version: 0.7.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api.tokenhistory.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Nft
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-09-03T07:40:07.509Z")



public class Nft {
  @SerializedName("owner")
  private String owner = null;

  @SerializedName("previousOwner")
  private String previousOwner = null;

  @SerializedName("tokenId")
  private String tokenId = null;

  @SerializedName("tokenUri")
  private String tokenUri = null;

  @SerializedName("transactionHash")
  private String transactionHash = null;

  @SerializedName("createdAt")
  private Long createdAt = null;

  @SerializedName("updatedAt")
  private Long updatedAt = null;

  public Nft owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * 소유자 EOA 주소 (20-byte)
   * @return owner
  **/
  @ApiModelProperty(example = "5.3824395526049505E47", required = true, value = "소유자 EOA 주소 (20-byte)")
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Nft previousOwner(String previousOwner) {
    this.previousOwner = previousOwner;
    return this;
  }

   /**
   * 직전 소유자 EOA 주소 (20-byte)
   * @return previousOwner
  **/
  @ApiModelProperty(example = "1.0318861629967498E48", required = true, value = "직전 소유자 EOA 주소 (20-byte)")
  public String getPreviousOwner() {
    return previousOwner;
  }

  public void setPreviousOwner(String previousOwner) {
    this.previousOwner = previousOwner;
  }

  public Nft tokenId(String tokenId) {
    this.tokenId = tokenId;
    return this;
  }

   /**
   * 토큰 ID (16진수)
   * @return tokenId
  **/
  @ApiModelProperty(example = "1", required = true, value = "토큰 ID (16진수)")
  public String getTokenId() {
    return tokenId;
  }

  public void setTokenId(String tokenId) {
    this.tokenId = tokenId;
  }

  public Nft tokenUri(String tokenUri) {
    this.tokenUri = tokenUri;
    return this;
  }

   /**
   * 토큰 고유의 URL
   * @return tokenUri
  **/
  @ApiModelProperty(example = "https://link.to/nft/1", required = true, value = "토큰 고유의 URL")
  public String getTokenUri() {
    return tokenUri;
  }

  public void setTokenUri(String tokenUri) {
    this.tokenUri = tokenUri;
  }

  public Nft transactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
    return this;
  }

   /**
   * 마지막 트랜잭션 해시 (32-byte)
   * @return transactionHash
  **/
  @ApiModelProperty(example = "8.894164055280364E76", required = true, value = "마지막 트랜잭션 해시 (32-byte)")
  public String getTransactionHash() {
    return transactionHash;
  }

  public void setTransactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
  }

  public Nft createdAt(Long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * 토큰이 생성된 시점 (timestamp)
   * @return createdAt
  **/
  @ApiModelProperty(example = "1592180992", required = true, value = "토큰이 생성된 시점 (timestamp)")
  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public Nft updatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * 토큰 정보가 마지막으로 변경된 시점 (timestamp)
   * @return updatedAt
  **/
  @ApiModelProperty(example = "1592180992", required = true, value = "토큰 정보가 마지막으로 변경된 시점 (timestamp)")
  public Long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Nft nft = (Nft) o;
    return Objects.equals(this.owner, nft.owner) &&
        Objects.equals(this.previousOwner, nft.previousOwner) &&
        Objects.equals(this.tokenId, nft.tokenId) &&
        Objects.equals(this.tokenUri, nft.tokenUri) &&
        Objects.equals(this.transactionHash, nft.transactionHash) &&
        Objects.equals(this.createdAt, nft.createdAt) &&
        Objects.equals(this.updatedAt, nft.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, previousOwner, tokenId, tokenUri, transactionHash, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Nft {\n");
    
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    previousOwner: ").append(toIndentedString(previousOwner)).append("\n");
    sb.append("    tokenId: ").append(toIndentedString(tokenId)).append("\n");
    sb.append("    tokenUri: ").append(toIndentedString(tokenUri)).append("\n");
    sb.append("    transactionHash: ").append(toIndentedString(transactionHash)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
