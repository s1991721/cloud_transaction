// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: abstractIdentifyResponse.proto

package com.jef.transaction.serializer.protobuf.generated;

public final class AbstractIdentifyResponse {
  private AbstractIdentifyResponse() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_seata_protocol_protobuf_AbstractIdentifyResponseProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_seata_protocol_protobuf_AbstractIdentifyResponseProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\036abstractIdentifyResponse.proto\022\032io.sea" +
      "ta.protocol.protobuf\032\033abstractResultMess" +
      "age.proto\"\256\001\n\035AbstractIdentifyResponsePr" +
      "oto\022U\n\025abstractResultMessage\030\001 \001(\01326.io." +
      "seata.protocol.protobuf.AbstractResultMe" +
      "ssageProto\022\017\n\007version\030\002 \001(\t\022\021\n\textraData" +
      "\030\003 \001(\t\022\022\n\nidentified\030\004 \001(\010BD\n&io.seata.s" +
      "erializer.protobuf.generatedB\030AbstractId" +
      "entifyResponseP\001b\006proto3"
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
          AbstractResultMessage.getDescriptor(),
        }, assigner);
    internal_static_io_seata_protocol_protobuf_AbstractIdentifyResponseProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_seata_protocol_protobuf_AbstractIdentifyResponseProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_seata_protocol_protobuf_AbstractIdentifyResponseProto_descriptor,
        new String[] { "AbstractResultMessage", "Version", "ExtraData", "Identified", });
    AbstractResultMessage.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
