// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: branchCommitResponse.proto

package com.jef.transaction.serializer.protobuf.generated;

public final class BranchCommitResponse {
  private BranchCommitResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_seata_protocol_protobuf_BranchCommitResponseProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_seata_protocol_protobuf_BranchCommitResponseProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\032branchCommitResponse.proto\022\032io.seata.p" +
      "rotocol.protobuf\032\037abstractBranchEndRespo" +
      "nse.proto\"z\n\031BranchCommitResponseProto\022]" +
      "\n\031abstractBranchEndResponse\030\001 \001(\0132:.io.s" +
      "eata.protocol.protobuf.AbstractBranchEnd" +
      "ResponseProtoB@\n&io.seata.serializer.pro" +
      "tobuf.generatedB\024BranchCommitResponseP\001b" +
      "\006proto3"
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
          AbstractBranchEndResponse.getDescriptor(),
        }, assigner);
    internal_static_io_seata_protocol_protobuf_BranchCommitResponseProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_seata_protocol_protobuf_BranchCommitResponseProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_seata_protocol_protobuf_BranchCommitResponseProto_descriptor,
        new String[] { "AbstractBranchEndResponse", });
    AbstractBranchEndResponse.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
