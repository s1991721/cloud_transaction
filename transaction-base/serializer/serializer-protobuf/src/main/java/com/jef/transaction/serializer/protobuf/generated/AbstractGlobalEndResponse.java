// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: abstractGlobalEndResponse.proto

package com.jef.transaction.serializer.protobuf.generated;

public final class AbstractGlobalEndResponse {
  private AbstractGlobalEndResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_seata_protocol_protobuf_AbstractGlobalEndResponseProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_seata_protocol_protobuf_AbstractGlobalEndResponseProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\037abstractGlobalEndResponse.proto\022\032io.se" +
      "ata.protocol.protobuf\032!abstractTransacti" +
      "onResponse.proto\032\022globalStatus.proto\"\310\001\n" +
      "\036AbstractGlobalEndResponseProto\022a\n\033abstr" +
      "actTransactionResponse\030\001 \001(\0132<.io.seata." +
      "protocol.protobuf.AbstractTransactionRes" +
      "ponseProto\022C\n\014globalStatus\030\002 \001(\0162-.io.se" +
      "ata.protocol.protobuf.GlobalStatusProtoB" +
      "E\n&io.seata.serializer.protobuf.generate" +
      "dB\031AbstractGlobalEndResponseP\001b\006proto3"
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
          GlobalStatus.getDescriptor(),
        }, assigner);
    internal_static_io_seata_protocol_protobuf_AbstractGlobalEndResponseProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_seata_protocol_protobuf_AbstractGlobalEndResponseProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_seata_protocol_protobuf_AbstractGlobalEndResponseProto_descriptor,
        new String[] { "AbstractTransactionResponse", "GlobalStatus", });
    AbstractTransactionResponse.getDescriptor();
    GlobalStatus.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}