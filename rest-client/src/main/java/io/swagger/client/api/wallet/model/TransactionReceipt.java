/*
 * Wallet API
 * # Introduction Wallet API는 클레이튼 계정을 만들어 관리하고 트랜잭션을 전송하는 API입니다. Wallet API로 Klaytn 계정을 만들면 여러분은 개인키를 따로 관리할 필요가 없습니다. Wallet API는 BApp을 위해 Klaytn 계정 개인키를 안전하게 보관하는 지갑을 제공합니다. Wallet API 사용에 관한 자세한 내용은 [튜토리얼](https://docs.klaytnapi.com/v/ko/tutorial)을 확인하십시오.  Wallet API는 크게 Klaytn 계정을 만들고 관리하는 Account 파트와 여러 종류의 트랜잭션을 전송하는 Transaction 파트로 나뉩니다.  Wallet API는 Klaytn 계정을 생성, 삭제, 모니터링하고 계정을 다중 서명 계정(Multisig 계정)으로 업데이트하며 KAS에 등록된 모든 계정의 개인키를 관리합니다.  또 Wallet API는 트랜잭션을 만들어 Klaytn에 전송합니다. 이 트랜잭션에는 다중 서명 계정이 보내는 트랜잭션도 포함됩니다. 다중 서명 시 임계값\\(Threshold\\)을 만족하면 트랜잭션은 Klaytn에 자동으로 전송됩니다. 다중 서명에 관한 자세한 내용은 [다음](https://docs.klaytnapi.com/v/ko/tutorial)을 확인하십시오.  트랜잭션은 크게 기본 트랜잭션과 수수료 대납 트랜잭션으로 나뉩니다. 수수료 대납 트랜잭션은 크게 글로벌 수수료 대납 트랜잭션과 사용자 수수료 대납 트랜잭션으로 나뉩니다. 글로벌 수수료 대납 트랜잭션은 Ground X의 KAS 계정에서 트랜잭션 수수료를 일단 대납해주고 나중에 여러분에게 이 수수료를 청구하는 방식입니다. 사용자 수수료 대납 트랜잭션은 여러분이 직접 트랜잭션 수수료를 대납하는 계정을 만들고, 트랜잭션을 보낼 때 이 대납 계정이 트랜잭션 수수료를 납부하도록 하는 방식입니다.  Wallet API는 아래와 같은 기능 및 제약사항을 갖고 있습니다.  | Version | Item | Description | | :--- | :--- | :--- | | 2.0 | 제약사항 | Cypress(Mainnet), Baobab(Testnet) 지원\\(Service Chain 미지원\\) | |  |  | 외부 관리키에 대한 계정 관리 미지원 | |  |  | RLP 인코딩된 트랜잭션의 다중 서명 미지원 | |  | 계정관리 | 계정 생성, 조회, 삭제 | |  |  | 다중 서명 계정 업데이트 | |  | 트랜잭션 관리 | [Basic](https://ko.docs.klaytn.com/klaytn/design/transactions/basic) 트랜잭션 생성 및 전송 | |  |  | [FeeDelegatedWithRatio](https://ko.docs.klaytn.com/klaytn/design/transactions/partial-fee-delegation) 트랜잭션 생성 및 전송 | |  |  | RLP 인코딩된 트랜잭션\\([Legacy](https://ko.docs.klaytn.com/klaytn/design/transactions/basic#txtypelegacytransaction), [Basic](https://ko.docs.klaytn.com/klaytn/design/transactions/basic), [FeeDelegatedWithRatio](https://ko.docs.klaytn.com/klaytn/design/transactions/partial-fee-delegation)\\) 생성 및 전송 | |  |  | 다중 서명 트랜잭션 관리 및 전송 | |  | 관리자 | 리소스 풀 관리\\(생성, 풀 조회, 삭제, 계정 조회\\) |    # Error Codes  ## 400: Bad Request   | Code | Messages |   | --- | --- |   | 1061010 | data don't exist 1061510 | account has been already deleted or disabled 1061511 | account has been already deleted or enabled 1061512 | account is invalid to sign the transaction; 0xc9bFDDabf2c38396b097C8faBE9151955413995D</br>account is invalid to sign the transaction; 0x35Cc4921B17Dfa67a58B93c9F8918f823e58b77e 1061515 | the requested account must be a legacy account; if the account is multisig account, use `PUT /v2/tx/{fd|fd-user}/account` API for multisig transaction and /v2/multisig/_**_/_** APIs 1061607 | it has to start with '0x' and allows [0-9a-fA-F]; input</br>it has to start with '0x' and allows [0-9a-fA-F]; transaction-id 1061608 | cannot be empty or zero value; to</br>cannot be empty or zero value; input 1061609 | it just allow Klaytn address form; to 1061903 | failed to decode account keys 1061905 | failed to get feepayer 1061912 | rlp value and request value are not same; feeRatio</br>rlp value and request value are not same; feePayer 1061914 | already submitted transaction. Confirm transaction hash; 0xb9612ec6ec39bfd3f2841daa7ab062fc94cf33f23503606c979b2f81e50b2cb1 1061917 | AccountKeyLegacy type is not supported in AccountKeyRoleBased type 1061918 | it just allow (Partial)FeeDelegation transaction type 1061919 | PartialFeeDelegation transaction must set fee ratio to non-zero value 1061920 | FeeDelegation transaction cannot set fee ratio, use PartialFeeDelegation transaction type 1061921 | it just allow Basic transaction type 1065000 | failed to retrieve a transaction from klaytn node 1065001 | failed to send a raw transaction to klaytn node; -32000::insufficient funds of the sender for value </br>failed to send a raw transaction to klaytn node; -32000::not a program account (e.g., an account having code and storage)</br>failed to send a raw transaction to klaytn node; -32000::nonce too low</br>failed to send a raw transaction to klaytn node; -32000::insufficient funds of the fee payer for gas * price 1065100 | failed to get an account from AMS</br>failed to get an account from AMS; account key corrupted. can not use this account 1065102 | account key corrupted. can not use this account 1616 | feeration must be between 1 and 99; feeRatio 1918 | it just allow (Partial)FeeDelegation transaction type |  
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api.wallet.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * 트랜잭션 영수증
 */
@Schema(description = "트랜잭션 영수증")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-09-25T06:43:29.805Z[GMT]")
public class TransactionReceipt {
  @SerializedName("blockHash")
  private String blockHash = null;

  @SerializedName("blockNumber")
  private String blockNumber = null;

  @SerializedName("from")
  private String from = null;

  @SerializedName("gas")
  private String gas = null;

  @SerializedName("gasPrice")
  private String gasPrice = null;

  @SerializedName("gasUsed")
  private String gasUsed = null;

  @SerializedName("hash")
  private String hash = null;

  @SerializedName("input")
  private String input = null;

  @SerializedName("logs")
  private List<EventLog> logs = null;

  @SerializedName("logsBloom")
  private String logsBloom = null;

  @SerializedName("nonce")
  private String nonce = null;

  @SerializedName("senderTxHash")
  private String senderTxHash = null;

  @SerializedName("signatures")
  private List<Signature> signatures = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("to")
  private String to = null;

  @SerializedName("transactionHash")
  private String transactionHash = null;

  @SerializedName("transactionIndex")
  private String transactionIndex = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("typeInt")
  private Long typeInt = null;

  @SerializedName("value")
  private String value = null;

  @SerializedName("contractAddress")
  private String contractAddress = null;

  @SerializedName("codeFormat")
  private String codeFormat = null;

  @SerializedName("feePayer")
  private String feePayer = null;

  @SerializedName("feePayerSignatures")
  private List<FeePayerSignaturesObj> feePayerSignatures = null;

  @SerializedName("humanReadable")
  private Boolean humanReadable = null;

  public TransactionReceipt blockHash(String blockHash) {
    this.blockHash = blockHash;
    return this;
  }

   /**
   * 해당 트랜잭션이 있는 블록의 해시값
   * @return blockHash
  **/
  @Schema(example = "0x276e6efcc01b27c992b0663cc843baebc9dbb167cf0cd7e74808c21c97a74182", description = "해당 트랜잭션이 있는 블록의 해시값")
  public String getBlockHash() {
    return blockHash;
  }

  public void setBlockHash(String blockHash) {
    this.blockHash = blockHash;
  }

  public TransactionReceipt blockNumber(String blockNumber) {
    this.blockNumber = blockNumber;
    return this;
  }

   /**
   * 해당 트랜잭션이 있는 블록의 번호
   * @return blockNumber
  **/
  @Schema(example = "0x24bb088", description = "해당 트랜잭션이 있는 블록의 번호")
  public String getBlockNumber() {
    return blockNumber;
  }

  public void setBlockNumber(String blockNumber) {
    this.blockNumber = blockNumber;
  }

  public TransactionReceipt from(String from) {
    this.from = from;
    return this;
  }

   /**
   * 트랜잭션을 보낸 Klaytn 계정 주소
   * @return from
  **/
  @Schema(example = "0x3e3733b256c93f9d759e33c9939258068bd5957d", description = "트랜잭션을 보낸 Klaytn 계정 주소")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public TransactionReceipt gas(String gas) {
    this.gas = gas;
    return this;
  }

   /**
   * 해당 트랜잭션을 보낼 때 사용하도록 설정한 트랜잭션 수수료(gas)의 최대값
   * @return gas
  **/
  @Schema(example = "0xf4240", description = "해당 트랜잭션을 보낼 때 사용하도록 설정한 트랜잭션 수수료(gas)의 최대값")
  public String getGas() {
    return gas;
  }

  public void setGas(String gas) {
    this.gas = gas;
  }

  public TransactionReceipt gasPrice(String gasPrice) {
    this.gasPrice = gasPrice;
    return this;
  }

   /**
   * 해당 트랜잭션을 보낼 때 사용하도록 설정한 트랜잭션 수수료(gas) 비용
   * @return gasPrice
  **/
  @Schema(example = "0x5d21dba00", description = "해당 트랜잭션을 보낼 때 사용하도록 설정한 트랜잭션 수수료(gas) 비용")
  public String getGasPrice() {
    return gasPrice;
  }

  public void setGasPrice(String gasPrice) {
    this.gasPrice = gasPrice;
  }

  public TransactionReceipt gasUsed(String gasUsed) {
    this.gasUsed = gasUsed;
    return this;
  }

   /**
   * 해당 트랜잭션을 보낼 때 사용한 트랜잭션 수수료(gas)
   * @return gasUsed
  **/
  @Schema(example = "0x55478", description = "해당 트랜잭션을 보낼 때 사용한 트랜잭션 수수료(gas)")
  public String getGasUsed() {
    return gasUsed;
  }

  public void setGasUsed(String gasUsed) {
    this.gasUsed = gasUsed;
  }

  public TransactionReceipt hash(String hash) {
    this.hash = hash;
    return this;
  }

   /**
   * 트랜잭션 데이터 해시
   * @return hash
  **/
  @Schema(example = "0x6a3bb7c14981f04e54261a542f0acaf27433befa9619443139f288b3b07c6b05", description = "트랜잭션 데이터 해시")
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public TransactionReceipt input(String input) {
    this.input = input;
    return this;
  }

   /**
   * 보내는 트랜잭션에 첨부되며 트랜잭션 실행에 사용되는 데이터
   * @return input
  **/
  @Schema(example = "0x4867ba1500000000000000000000000000000000000000000000000000000000000000c000000000000000000000000001021e96a79de1b663753935ac856c2cfc51ce8c000000000000000000000000270f21fbf544e5f87b4988c521315a87ce24acf200000000000000000000000000000000000000000000000000000000000000009dbb36061e9a8cb752a9e8abd17e459d7577eaf614f351dfac0b3b3a2d4fca7400000000000000000000000000000000000000000000000000000000000001400000000000000000000000000000000000000000000000000000000000000041efc087a54f954b416b6d051775770336f26d65442306145f8148ee2d2181012d5d49e2d3bd51b22456bb69f5adda7e21c93750aa0c4bfd8a99e6bd17584d10a41b0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000a401db711901000000000000000000000000000000000000000000000000000000000000000000000000000000000000001c8c7395e3e64e69471ed11debbff2a0ffb89d5b00000000000000000000000000000000000000000000000000000000000000600000000000000000000000000000000000000000000000000000000000000020efefefefefefef0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", description = "보내는 트랜잭션에 첨부되며 트랜잭션 실행에 사용되는 데이터")
  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public TransactionReceipt logs(List<EventLog> logs) {
    this.logs = logs;
    return this;
  }

  public TransactionReceipt addLogsItem(EventLog logsItem) {
    if (this.logs == null) {
      this.logs = new ArrayList<EventLog>();
    }
    this.logs.add(logsItem);
    return this;
  }

   /**
   * Get logs
   * @return logs
  **/
  @Schema(description = "")
  public List<EventLog> getLogs() {
    return logs;
  }

  public void setLogs(List<EventLog> logs) {
    this.logs = logs;
  }

  public TransactionReceipt logsBloom(String logsBloom) {
    this.logsBloom = logsBloom;
    return this;
  }

   /**
   * 관련 로그를 빨리 찾기 위해 사용된 Bloom 필터
   * @return logsBloom
  **/
  @Schema(example = "0x00000000000000000000000000000000000000000040000000000000200000000000000000000000000001000000000000000000000200000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000000000800000000000000000000000000000000000000800000000000000000000000000000000000080000000000000000000000000000000000000000000800000000000800000000", description = "관련 로그를 빨리 찾기 위해 사용된 Bloom 필터")
  public String getLogsBloom() {
    return logsBloom;
  }

  public void setLogsBloom(String logsBloom) {
    this.logsBloom = logsBloom;
  }

  public TransactionReceipt nonce(String nonce) {
    this.nonce = nonce;
    return this;
  }

   /**
   * 현재 해당 트랜잭션을 보내는 이가 과거에 보냈던 모든 트랜잭션의 개수
   * @return nonce
  **/
  @Schema(example = "0x26dc3", description = "현재 해당 트랜잭션을 보내는 이가 과거에 보냈던 모든 트랜잭션의 개수")
  public String getNonce() {
    return nonce;
  }

  public void setNonce(String nonce) {
    this.nonce = nonce;
  }

  public TransactionReceipt senderTxHash(String senderTxHash) {
    this.senderTxHash = senderTxHash;
    return this;
  }

   /**
   * 대납 계정의 주소와 서명 값이 없는 트랜잭션의 해시값
   * @return senderTxHash
  **/
  @Schema(example = "0x6a3bb7c14981f04e54261a542f0acaf27433befa9619443139f288b3b07c6b05", description = "대납 계정의 주소와 서명 값이 없는 트랜잭션의 해시값")
  public String getSenderTxHash() {
    return senderTxHash;
  }

  public void setSenderTxHash(String senderTxHash) {
    this.senderTxHash = senderTxHash;
  }

  public TransactionReceipt signatures(List<Signature> signatures) {
    this.signatures = signatures;
    return this;
  }

  public TransactionReceipt addSignaturesItem(Signature signaturesItem) {
    if (this.signatures == null) {
      this.signatures = new ArrayList<Signature>();
    }
    this.signatures.add(signaturesItem);
    return this;
  }

   /**
   * Get signatures
   * @return signatures
  **/
  @Schema(description = "")
  public List<Signature> getSignatures() {
    return signatures;
  }

  public void setSignatures(List<Signature> signatures) {
    this.signatures = signatures;
  }

  public TransactionReceipt status(String status) {
    this.status = status;
    return this;
  }

   /**
   * 해당 트랜잭션의 상태. 아직 txpool에 있을 경우 &#x60;Pending&#x60;, 성공한 트랜잭션의 경우 &#x60;Committed&#x60;, 실패한 트랜잭션의 경우 &#x60;CommitError&#x60;로 표시함.
   * @return status
  **/
  @Schema(example = "Committed", description = "해당 트랜잭션의 상태. 아직 txpool에 있을 경우 `Pending`, 성공한 트랜잭션의 경우 `Committed`, 실패한 트랜잭션의 경우 `CommitError`로 표시함.")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public TransactionReceipt to(String to) {
    this.to = to;
    return this;
  }

   /**
   * KLAY를 받는 Klaytn 계정 주소
   * @return to
  **/
  @Schema(example = "0x01021e96a79de1b663753935ac856c2cfc51ce8c", description = "KLAY를 받는 Klaytn 계정 주소")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public TransactionReceipt transactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
    return this;
  }

   /**
   * 해당 트랜잭션의 해시값
   * @return transactionHash
  **/
  @Schema(example = "0x6a3bb7c14981f04e54261a542f0acaf27433befa9619443139f288b3b07c6b05", description = "해당 트랜잭션의 해시값")
  public String getTransactionHash() {
    return transactionHash;
  }

  public void setTransactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
  }

  public TransactionReceipt transactionIndex(String transactionIndex) {
    this.transactionIndex = transactionIndex;
    return this;
  }

   /**
   * 트랜잭션이 들어있는 블록 안에서 해당 트랜잭션의 순서
   * @return transactionIndex
  **/
  @Schema(example = "0x0", description = "트랜잭션이 들어있는 블록 안에서 해당 트랜잭션의 순서")
  public String getTransactionIndex() {
    return transactionIndex;
  }

  public void setTransactionIndex(String transactionIndex) {
    this.transactionIndex = transactionIndex;
  }

  public TransactionReceipt type(String type) {
    this.type = type;
    return this;
  }

   /**
   * 해당 트랜잭션 타입를 나타내는 문자값
   * @return type
  **/
  @Schema(example = "TxTypeSmartContractExecution", description = "해당 트랜잭션 타입를 나타내는 문자값")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public TransactionReceipt typeInt(Long typeInt) {
    this.typeInt = typeInt;
    return this;
  }

   /**
   * 해당 트랜잭션 타입을 나타내는 숫자값
   * @return typeInt
  **/
  @Schema(example = "48", description = "해당 트랜잭션 타입을 나타내는 숫자값")
  public Long getTypeInt() {
    return typeInt;
  }

  public void setTypeInt(Long typeInt) {
    this.typeInt = typeInt;
  }

  public TransactionReceipt value(String value) {
    this.value = value;
    return this;
  }

   /**
   * PEB 단위로 환산된 KLAY
   * @return value
  **/
  @Schema(example = "0x0", description = "PEB 단위로 환산된 KLAY")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public TransactionReceipt contractAddress(String contractAddress) {
    this.contractAddress = contractAddress;
    return this;
  }

   /**
   * 컨트랙트 주소. 만약 컨트랙트 배포가 아니면 &#x60;null&#x60; 값을 가짐.
   * @return contractAddress
  **/
  @Schema(required = true, description = "컨트랙트 주소. 만약 컨트랙트 배포가 아니면 `null` 값을 가짐.")
  public String getContractAddress() {
    return contractAddress;
  }

  public void setContractAddress(String contractAddress) {
    this.contractAddress = contractAddress;
  }

  public TransactionReceipt codeFormat(String codeFormat) {
    this.codeFormat = codeFormat;
    return this;
  }

   /**
   * 스마트 컨트랙트의 코드 포맷
   * @return codeFormat
  **/
  @Schema(example = "0x0", description = "스마트 컨트랙트의 코드 포맷")
  public String getCodeFormat() {
    return codeFormat;
  }

  public void setCodeFormat(String codeFormat) {
    this.codeFormat = codeFormat;
  }

  public TransactionReceipt feePayer(String feePayer) {
    this.feePayer = feePayer;
    return this;
  }

   /**
   * 트랜잭션 수수료를 대납할 계정 주소
   * @return feePayer
  **/
  @Schema(example = "0x85b98485444c89880cd9c48807cef727c296f2da", description = "트랜잭션 수수료를 대납할 계정 주소")
  public String getFeePayer() {
    return feePayer;
  }

  public void setFeePayer(String feePayer) {
    this.feePayer = feePayer;
  }

  public TransactionReceipt feePayerSignatures(List<FeePayerSignaturesObj> feePayerSignatures) {
    this.feePayerSignatures = feePayerSignatures;
    return this;
  }

  public TransactionReceipt addFeePayerSignaturesItem(FeePayerSignaturesObj feePayerSignaturesItem) {
    if (this.feePayerSignatures == null) {
      this.feePayerSignatures = new ArrayList<FeePayerSignaturesObj>();
    }
    this.feePayerSignatures.add(feePayerSignaturesItem);
    return this;
  }

   /**
   * Get feePayerSignatures
   * @return feePayerSignatures
  **/
  @Schema(description = "")
  public List<FeePayerSignaturesObj> getFeePayerSignatures() {
    return feePayerSignatures;
  }

  public void setFeePayerSignatures(List<FeePayerSignaturesObj> feePayerSignatures) {
    this.feePayerSignatures = feePayerSignatures;
  }

  public TransactionReceipt humanReadable(Boolean humanReadable) {
    this.humanReadable = humanReadable;
    return this;
  }

   /**
   * 해당 계정의 주소가 &#x60;humanReadable&#x60;인지 여부
   * @return humanReadable
  **/
  @Schema(example = "false", description = "해당 계정의 주소가 `humanReadable`인지 여부")
  public Boolean isHumanReadable() {
    return humanReadable;
  }

  public void setHumanReadable(Boolean humanReadable) {
    this.humanReadable = humanReadable;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionReceipt transactionReceipt = (TransactionReceipt) o;
    return Objects.equals(this.blockHash, transactionReceipt.blockHash) &&
        Objects.equals(this.blockNumber, transactionReceipt.blockNumber) &&
        Objects.equals(this.from, transactionReceipt.from) &&
        Objects.equals(this.gas, transactionReceipt.gas) &&
        Objects.equals(this.gasPrice, transactionReceipt.gasPrice) &&
        Objects.equals(this.gasUsed, transactionReceipt.gasUsed) &&
        Objects.equals(this.hash, transactionReceipt.hash) &&
        Objects.equals(this.input, transactionReceipt.input) &&
        Objects.equals(this.logs, transactionReceipt.logs) &&
        Objects.equals(this.logsBloom, transactionReceipt.logsBloom) &&
        Objects.equals(this.nonce, transactionReceipt.nonce) &&
        Objects.equals(this.senderTxHash, transactionReceipt.senderTxHash) &&
        Objects.equals(this.signatures, transactionReceipt.signatures) &&
        Objects.equals(this.status, transactionReceipt.status) &&
        Objects.equals(this.to, transactionReceipt.to) &&
        Objects.equals(this.transactionHash, transactionReceipt.transactionHash) &&
        Objects.equals(this.transactionIndex, transactionReceipt.transactionIndex) &&
        Objects.equals(this.type, transactionReceipt.type) &&
        Objects.equals(this.typeInt, transactionReceipt.typeInt) &&
        Objects.equals(this.value, transactionReceipt.value) &&
        Objects.equals(this.contractAddress, transactionReceipt.contractAddress) &&
        Objects.equals(this.codeFormat, transactionReceipt.codeFormat) &&
        Objects.equals(this.feePayer, transactionReceipt.feePayer) &&
        Objects.equals(this.feePayerSignatures, transactionReceipt.feePayerSignatures) &&
        Objects.equals(this.humanReadable, transactionReceipt.humanReadable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockHash, blockNumber, from, gas, gasPrice, gasUsed, hash, input, logs, logsBloom, nonce, senderTxHash, signatures, status, to, transactionHash, transactionIndex, type, typeInt, value, contractAddress, codeFormat, feePayer, feePayerSignatures, humanReadable);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionReceipt {\n");
    
    sb.append("    blockHash: ").append(toIndentedString(blockHash)).append("\n");
    sb.append("    blockNumber: ").append(toIndentedString(blockNumber)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    gas: ").append(toIndentedString(gas)).append("\n");
    sb.append("    gasPrice: ").append(toIndentedString(gasPrice)).append("\n");
    sb.append("    gasUsed: ").append(toIndentedString(gasUsed)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    logs: ").append(toIndentedString(logs)).append("\n");
    sb.append("    logsBloom: ").append(toIndentedString(logsBloom)).append("\n");
    sb.append("    nonce: ").append(toIndentedString(nonce)).append("\n");
    sb.append("    senderTxHash: ").append(toIndentedString(senderTxHash)).append("\n");
    sb.append("    signatures: ").append(toIndentedString(signatures)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    transactionHash: ").append(toIndentedString(transactionHash)).append("\n");
    sb.append("    transactionIndex: ").append(toIndentedString(transactionIndex)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    typeInt: ").append(toIndentedString(typeInt)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    contractAddress: ").append(toIndentedString(contractAddress)).append("\n");
    sb.append("    codeFormat: ").append(toIndentedString(codeFormat)).append("\n");
    sb.append("    feePayer: ").append(toIndentedString(feePayer)).append("\n");
    sb.append("    feePayerSignatures: ").append(toIndentedString(feePayerSignatures)).append("\n");
    sb.append("    humanReadable: ").append(toIndentedString(humanReadable)).append("\n");
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
