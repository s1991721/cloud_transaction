// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: heartbeatMessage.proto

package com.jef.transaction.serializer.protobuf.generated;

public final class HeartbeatMessage {
  private HeartbeatMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\026heartbeatMessage.proto\022\032io.seata.proto" +
      "col.protobuf\"%\n\025HeartbeatMessageProto\022\014\n" +
      "\004ping\030\001 \001(\010B<\n&io.seata.serializer.proto" +
      "buf.generatedB\020HeartbeatMessageP\001b\006proto" +
      "3"
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
        }, assigner);
    internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_seata_protocol_protobuf_HeartbeatMessageProto_descriptor,
        new String[] { "Ping", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
