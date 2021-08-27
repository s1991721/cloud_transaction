// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: globalReportRequest.proto

package com.jef.transaction.serializer.protobuf.generated;

/**
 * Protobuf type {@code io.seata.protocol.protobuf.GlobalReportRequestProto}
 */
public  final class GlobalReportRequestProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.seata.protocol.protobuf.GlobalReportRequestProto)
    GlobalReportRequestProtoOrBuilder {
  // Use GlobalReportRequestProto.newBuilder() to construct.
  private GlobalReportRequestProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GlobalReportRequestProto() {
    globalStatus_ = 0;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private GlobalReportRequestProto(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            AbstractGlobalEndRequestProto.Builder subBuilder = null;
            if (abstractGlobalEndRequest_ != null) {
              subBuilder = abstractGlobalEndRequest_.toBuilder();
            }
            abstractGlobalEndRequest_ = input.readMessage(AbstractGlobalEndRequestProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(abstractGlobalEndRequest_);
              abstractGlobalEndRequest_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            globalStatus_ = rawValue;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GlobalReportRequestProto.class, GlobalReportRequestProto.Builder.class);
  }

  public static final int ABSTRACTGLOBALENDREQUEST_FIELD_NUMBER = 1;
  private AbstractGlobalEndRequestProto abstractGlobalEndRequest_;
  /**
   * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
   */
  public boolean hasAbstractGlobalEndRequest() {
    return abstractGlobalEndRequest_ != null;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
   */
  public AbstractGlobalEndRequestProto getAbstractGlobalEndRequest() {
    return abstractGlobalEndRequest_ == null ? AbstractGlobalEndRequestProto.getDefaultInstance() : abstractGlobalEndRequest_;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
   */
  public AbstractGlobalEndRequestProtoOrBuilder getAbstractGlobalEndRequestOrBuilder() {
    return getAbstractGlobalEndRequest();
  }

  public static final int GLOBALSTATUS_FIELD_NUMBER = 2;
  private int globalStatus_;
  /**
   * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
   */
  public int getGlobalStatusValue() {
    return globalStatus_;
  }
  /**
   * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
   */
  public GlobalStatusProto getGlobalStatus() {
    GlobalStatusProto result = GlobalStatusProto.valueOf(globalStatus_);
    return result == null ? GlobalStatusProto.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (abstractGlobalEndRequest_ != null) {
      output.writeMessage(1, getAbstractGlobalEndRequest());
    }
    if (globalStatus_ != GlobalStatusProto.UnKnown.getNumber()) {
      output.writeEnum(2, globalStatus_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (abstractGlobalEndRequest_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAbstractGlobalEndRequest());
    }
    if (globalStatus_ != GlobalStatusProto.UnKnown.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, globalStatus_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof GlobalReportRequestProto)) {
      return super.equals(obj);
    }
    GlobalReportRequestProto other = (GlobalReportRequestProto) obj;

    boolean result = true;
    result = result && (hasAbstractGlobalEndRequest() == other.hasAbstractGlobalEndRequest());
    if (hasAbstractGlobalEndRequest()) {
      result = result && getAbstractGlobalEndRequest()
          .equals(other.getAbstractGlobalEndRequest());
    }
    result = result && globalStatus_ == other.globalStatus_;
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasAbstractGlobalEndRequest()) {
      hash = (37 * hash) + ABSTRACTGLOBALENDREQUEST_FIELD_NUMBER;
      hash = (53 * hash) + getAbstractGlobalEndRequest().hashCode();
    }
    hash = (37 * hash) + GLOBALSTATUS_FIELD_NUMBER;
    hash = (53 * hash) + globalStatus_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GlobalReportRequestProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GlobalReportRequestProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GlobalReportRequestProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GlobalReportRequestProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GlobalReportRequestProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GlobalReportRequestProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GlobalReportRequestProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GlobalReportRequestProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GlobalReportRequestProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GlobalReportRequestProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GlobalReportRequestProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GlobalReportRequestProto parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GlobalReportRequestProto prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code io.seata.protocol.protobuf.GlobalReportRequestProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.seata.protocol.protobuf.GlobalReportRequestProto)
      GlobalReportRequestProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GlobalReportRequestProto.class, GlobalReportRequestProto.Builder.class);
    }

    // Construct using GlobalReportRequestProto.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequest_ = null;
      } else {
        abstractGlobalEndRequest_ = null;
        abstractGlobalEndRequestBuilder_ = null;
      }
      globalStatus_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return GlobalReportRequest.internal_static_io_seata_protocol_protobuf_GlobalReportRequestProto_descriptor;
    }

    public GlobalReportRequestProto getDefaultInstanceForType() {
      return GlobalReportRequestProto.getDefaultInstance();
    }

    public GlobalReportRequestProto build() {
      GlobalReportRequestProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public GlobalReportRequestProto buildPartial() {
      GlobalReportRequestProto result = new GlobalReportRequestProto(this);
      if (abstractGlobalEndRequestBuilder_ == null) {
        result.abstractGlobalEndRequest_ = abstractGlobalEndRequest_;
      } else {
        result.abstractGlobalEndRequest_ = abstractGlobalEndRequestBuilder_.build();
      }
      result.globalStatus_ = globalStatus_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GlobalReportRequestProto) {
        return mergeFrom((GlobalReportRequestProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GlobalReportRequestProto other) {
      if (other == GlobalReportRequestProto.getDefaultInstance()) return this;
      if (other.hasAbstractGlobalEndRequest()) {
        mergeAbstractGlobalEndRequest(other.getAbstractGlobalEndRequest());
      }
      if (other.globalStatus_ != 0) {
        setGlobalStatusValue(other.getGlobalStatusValue());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      GlobalReportRequestProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GlobalReportRequestProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private AbstractGlobalEndRequestProto abstractGlobalEndRequest_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        AbstractGlobalEndRequestProto, AbstractGlobalEndRequestProto.Builder, AbstractGlobalEndRequestProtoOrBuilder> abstractGlobalEndRequestBuilder_;
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public boolean hasAbstractGlobalEndRequest() {
      return abstractGlobalEndRequestBuilder_ != null || abstractGlobalEndRequest_ != null;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public AbstractGlobalEndRequestProto getAbstractGlobalEndRequest() {
      if (abstractGlobalEndRequestBuilder_ == null) {
        return abstractGlobalEndRequest_ == null ? AbstractGlobalEndRequestProto.getDefaultInstance() : abstractGlobalEndRequest_;
      } else {
        return abstractGlobalEndRequestBuilder_.getMessage();
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder setAbstractGlobalEndRequest(AbstractGlobalEndRequestProto value) {
      if (abstractGlobalEndRequestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        abstractGlobalEndRequest_ = value;
        onChanged();
      } else {
        abstractGlobalEndRequestBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder setAbstractGlobalEndRequest(
        AbstractGlobalEndRequestProto.Builder builderForValue) {
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequest_ = builderForValue.build();
        onChanged();
      } else {
        abstractGlobalEndRequestBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder mergeAbstractGlobalEndRequest(AbstractGlobalEndRequestProto value) {
      if (abstractGlobalEndRequestBuilder_ == null) {
        if (abstractGlobalEndRequest_ != null) {
          abstractGlobalEndRequest_ =
            AbstractGlobalEndRequestProto.newBuilder(abstractGlobalEndRequest_).mergeFrom(value).buildPartial();
        } else {
          abstractGlobalEndRequest_ = value;
        }
        onChanged();
      } else {
        abstractGlobalEndRequestBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public Builder clearAbstractGlobalEndRequest() {
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequest_ = null;
        onChanged();
      } else {
        abstractGlobalEndRequest_ = null;
        abstractGlobalEndRequestBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public AbstractGlobalEndRequestProto.Builder getAbstractGlobalEndRequestBuilder() {
      
      onChanged();
      return getAbstractGlobalEndRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    public AbstractGlobalEndRequestProtoOrBuilder getAbstractGlobalEndRequestOrBuilder() {
      if (abstractGlobalEndRequestBuilder_ != null) {
        return abstractGlobalEndRequestBuilder_.getMessageOrBuilder();
      } else {
        return abstractGlobalEndRequest_ == null ?
            AbstractGlobalEndRequestProto.getDefaultInstance() : abstractGlobalEndRequest_;
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractGlobalEndRequestProto abstractGlobalEndRequest = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        AbstractGlobalEndRequestProto, AbstractGlobalEndRequestProto.Builder, AbstractGlobalEndRequestProtoOrBuilder> 
        getAbstractGlobalEndRequestFieldBuilder() {
      if (abstractGlobalEndRequestBuilder_ == null) {
        abstractGlobalEndRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            AbstractGlobalEndRequestProto, AbstractGlobalEndRequestProto.Builder, AbstractGlobalEndRequestProtoOrBuilder>(
                getAbstractGlobalEndRequest(),
                getParentForChildren(),
                isClean());
        abstractGlobalEndRequest_ = null;
      }
      return abstractGlobalEndRequestBuilder_;
    }

    private int globalStatus_ = 0;
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public int getGlobalStatusValue() {
      return globalStatus_;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public Builder setGlobalStatusValue(int value) {
      globalStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public GlobalStatusProto getGlobalStatus() {
      GlobalStatusProto result = GlobalStatusProto.valueOf(globalStatus_);
      return result == null ? GlobalStatusProto.UNRECOGNIZED : result;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public Builder setGlobalStatus(GlobalStatusProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      globalStatus_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.GlobalStatusProto globalStatus = 2;</code>
     */
    public Builder clearGlobalStatus() {
      
      globalStatus_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:io.seata.protocol.protobuf.GlobalReportRequestProto)
  }

  // @@protoc_insertion_point(class_scope:io.seata.protocol.protobuf.GlobalReportRequestProto)
  private static final GlobalReportRequestProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GlobalReportRequestProto();
  }

  public static GlobalReportRequestProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GlobalReportRequestProto>
      PARSER = new com.google.protobuf.AbstractParser<GlobalReportRequestProto>() {
    public GlobalReportRequestProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new GlobalReportRequestProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GlobalReportRequestProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GlobalReportRequestProto> getParserForType() {
    return PARSER;
  }

  public GlobalReportRequestProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

