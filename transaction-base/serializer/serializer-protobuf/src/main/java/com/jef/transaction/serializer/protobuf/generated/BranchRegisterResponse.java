// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: branchRegisterResponse.proto

package com.jef.transaction.serializer.protobuf.generated;

public final class BranchRegisterResponse {
  private BranchRegisterResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_seata_protocol_protobuf_BranchRegisterResponseProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_seata_protocol_protobuf_BranchRegisterResponseProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\034branchRegisterResponse.proto\022\032io.seata" +
      ".protocol.protobuf\032!abstractTransactionR" +
      "esponse.proto\"\222\001\n\033BranchRegisterResponse" +
      "Proto\022a\n\033abstractTransactionResponse\030\001 \001" +
      "(\0132<.io.seata.protocol.protobuf.Abstract" +
      "TransactionResponseProto\022\020\n\010branchId\030\002 \001" +
      "(\003BB\n&io.seata.serializer.protobuf.gener" +
      "atedB\026BranchRegisterResponseP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          AbstractTransactionResponse.getDescriptor(),
        }, assigner);
    internal_static_io_seata_protocol_protobuf_BranchRegisterResponseProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_seata_protocol_protobuf_BranchRegisterResponseProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_seata_protocol_protobuf_BranchRegisterResponseProto_descriptor,
        new String[] { "AbstractTransactionResponse", "BranchId", });
    AbstractTransactionResponse.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
