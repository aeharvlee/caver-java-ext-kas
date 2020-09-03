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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PageableNftOwnershipChanges
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-09-01T02:14:40.553Z")



public class PageableNftOwnershipChanges {  @SerializedName("items")
  private List<NftOwnershipChange> items = new ArrayList<NftOwnershipChange>();

  @SerializedName("nextCursor")
  private String nextCursor = null;

  public PageableNftOwnershipChanges items(List<NftOwnershipChange> items) {
    this.items = items;
    return this;
  }

  public PageableNftOwnershipChanges addItemsItem(NftOwnershipChange itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(required = true, value = "")
  public List<NftOwnershipChange> getItems() {
    return items;
  }

  public void setItems(List<NftOwnershipChange> items) {
    this.items = items;
  }

  public PageableNftOwnershipChanges nextCursor(String nextCursor) {
    this.nextCursor = nextCursor;
    return this;
  }

   /**
   * 다음 페이지 커서
   * @return nextCursor
  **/
  @ApiModelProperty(example = "z2o87adeLbW4Aqm53gpq6VbGZg3JmE5vodrwD9XKmY5vMl4Gkw9PZO1NoBpV8LR83y0Edb3Aar7eKQqzJWDg6X2xOe1P27l4kzY0xQa8LNABMWv0VJQ6MpNlr9O1xBDE", required = true, value = "다음 페이지 커서")
  public String getNextCursor() {
    return nextCursor;
  }

  public void setNextCursor(String nextCursor) {
    this.nextCursor = nextCursor;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PageableNftOwnershipChanges pageableNftOwnershipChanges = (PageableNftOwnershipChanges) o;
    return Objects.equals(this.items, pageableNftOwnershipChanges.items) &&
        Objects.equals(this.nextCursor, pageableNftOwnershipChanges.nextCursor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(items, nextCursor);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PageableNftOwnershipChanges {\n");
    
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    nextCursor: ").append(toIndentedString(nextCursor)).append("\n");
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

