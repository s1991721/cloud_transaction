// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: abstractGlobalEndRequest.proto

package com.jef.transaction.serializer.protobuf.generated;

public interface AbstractGlobalEndRequestProtoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.seata.protocol.protobuf.AbstractGlobalEndRequestProto)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.io.seata.protocol.protobuf.AbstractTransactionRequestProto abstractTransactionRequest = 1;</code>
   */
  boolean hasAbstractTransactionRequest();
  /**
   * <code>.io.seata.protocol.protobuf.AbstractTransactionRequestProto abstractTransactionRequest = 1;</code>
   */
   AbstractTransactionRequestProto getAbstractTransactionRequest();
  /**
   * <code>.io.seata.protocol.protobuf.AbstractTransactionRequestProto abstractTransactionRequest = 1;</code>
   */
   AbstractTransactionRequestProtoOrBuilder getAbstractTransactionRequestOrBuilder();

  /**
   * <code>string xid = 2;</code>
   */
  String getXid();
  /**
   * <code>string xid = 2;</code>
   */
  com.google.protobuf.ByteString
      getXidBytes();

  /**
   * <code>string extraData = 3;</code>
   */
  String getExtraData();
  /**
   * <code>string extraData = 3;</code>
   */
  com.google.protobuf.ByteString
      getExtraDataBytes();
}
