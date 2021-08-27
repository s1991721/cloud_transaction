// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: branchReportResponse.proto

package com.jef.transaction.serializer.protobuf.generated;

/**
 * Protobuf type {@code io.seata.protocol.protobuf.BranchReportResponseProto}
 */
public  final class BranchReportResponseProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.seata.protocol.protobuf.BranchReportResponseProto)
    BranchReportResponseProtoOrBuilder {
  // Use BranchReportResponseProto.newBuilder() to construct.
  private BranchReportResponseProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BranchReportResponseProto() {
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private BranchReportResponseProto(
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
             AbstractTransactionResponseProto.Builder subBuilder = null;
            if (abstractTransactionResponse_ != null) {
              subBuilder = abstractTransactionResponse_.toBuilder();
            }
            abstractTransactionResponse_ = input.readMessage( AbstractTransactionResponseProto.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(abstractTransactionResponse_);
              abstractTransactionResponse_ = subBuilder.buildPartial();
            }

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
    return  BranchReportResponse.internal_static_io_seata_protocol_protobuf_BranchReportResponseProto_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return  BranchReportResponse.internal_static_io_seata_protocol_protobuf_BranchReportResponseProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
             BranchReportResponseProto.class,  BranchReportResponseProto.Builder.class);
  }

  public static final int ABSTRACTTRANSACTIONRESPONSE_FIELD_NUMBER = 1;
  private  AbstractTransactionResponseProto abstractTransactionResponse_;
  /**
   * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
   */
  public boolean hasAbstractTransactionResponse() {
    return abstractTransactionResponse_ != null;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
   */
  public  AbstractTransactionResponseProto getAbstractTransactionResponse() {
    return abstractTransactionResponse_ == null ?  AbstractTransactionResponseProto.getDefaultInstance() : abstractTransactionResponse_;
  }
  /**
   * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
   */
  public  AbstractTransactionResponseProtoOrBuilder getAbstractTransactionResponseOrBuilder() {
    return getAbstractTransactionResponse();
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
    if (abstractTransactionResponse_ != null) {
      output.writeMessage(1, getAbstractTransactionResponse());
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (abstractTransactionResponse_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getAbstractTransactionResponse());
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
    if (!(obj instanceof  BranchReportResponseProto)) {
      return super.equals(obj);
    }
     BranchReportResponseProto other = ( BranchReportResponseProto) obj;

    boolean result = true;
    result = result && (hasAbstractTransactionResponse() == other.hasAbstractTransactionResponse());
    if (hasAbstractTransactionResponse()) {
      result = result && getAbstractTransactionResponse()
          .equals(other.getAbstractTransactionResponse());
    }
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasAbstractTransactionResponse()) {
      hash = (37 * hash) + ABSTRACTTRANSACTIONRESPONSE_FIELD_NUMBER;
      hash = (53 * hash) + getAbstractTransactionResponse().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static  BranchReportResponseProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static  BranchReportResponseProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static  BranchReportResponseProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static  BranchReportResponseProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static  BranchReportResponseProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static  BranchReportResponseProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static  BranchReportResponseProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static  BranchReportResponseProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static  BranchReportResponseProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static  BranchReportResponseProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static  BranchReportResponseProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static  BranchReportResponseProto parseFrom(
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
  public static Builder newBuilder( BranchReportResponseProto prototype) {
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
   * Protobuf type {@code io.seata.protocol.protobuf.BranchReportResponseProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.seata.protocol.protobuf.BranchReportResponseProto)
       BranchReportResponseProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return  BranchReportResponse.internal_static_io_seata_protocol_protobuf_BranchReportResponseProto_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return  BranchReportResponse.internal_static_io_seata_protocol_protobuf_BranchReportResponseProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
               BranchReportResponseProto.class,  BranchReportResponseProto.Builder.class);
    }

    // Construct using  BranchReportResponseProto.newBuilder()
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
      if (abstractTransactionResponseBuilder_ == null) {
        abstractTransactionResponse_ = null;
      } else {
        abstractTransactionResponse_ = null;
        abstractTransactionResponseBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return  BranchReportResponse.internal_static_io_seata_protocol_protobuf_BranchReportResponseProto_descriptor;
    }

    public  BranchReportResponseProto getDefaultInstanceForType() {
      return  BranchReportResponseProto.getDefaultInstance();
    }

    public  BranchReportResponseProto build() {
       BranchReportResponseProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public  BranchReportResponseProto buildPartial() {
       BranchReportResponseProto result = new  BranchReportResponseProto(this);
      if (abstractTransactionResponseBuilder_ == null) {
        result.abstractTransactionResponse_ = abstractTransactionResponse_;
      } else {
        result.abstractTransactionResponse_ = abstractTransactionResponseBuilder_.build();
      }
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
      if (other instanceof  BranchReportResponseProto) {
        return mergeFrom(( BranchReportResponseProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom( BranchReportResponseProto other) {
      if (other ==  BranchReportResponseProto.getDefaultInstance()) return this;
      if (other.hasAbstractTransactionResponse()) {
        mergeAbstractTransactionResponse(other.getAbstractTransactionResponse());
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
       BranchReportResponseProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = ( BranchReportResponseProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private  AbstractTransactionResponseProto abstractTransactionResponse_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
         AbstractTransactionResponseProto,  AbstractTransactionResponseProto.Builder,  AbstractTransactionResponseProtoOrBuilder> abstractTransactionResponseBuilder_;
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public boolean hasAbstractTransactionResponse() {
      return abstractTransactionResponseBuilder_ != null || abstractTransactionResponse_ != null;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public  AbstractTransactionResponseProto getAbstractTransactionResponse() {
      if (abstractTransactionResponseBuilder_ == null) {
        return abstractTransactionResponse_ == null ?  AbstractTransactionResponseProto.getDefaultInstance() : abstractTransactionResponse_;
      } else {
        return abstractTransactionResponseBuilder_.getMessage();
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public Builder setAbstractTransactionResponse( AbstractTransactionResponseProto value) {
      if (abstractTransactionResponseBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        abstractTransactionResponse_ = value;
        onChanged();
      } else {
        abstractTransactionResponseBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public Builder setAbstractTransactionResponse(
         AbstractTransactionResponseProto.Builder builderForValue) {
      if (abstractTransactionResponseBuilder_ == null) {
        abstractTransactionResponse_ = builderForValue.build();
        onChanged();
      } else {
        abstractTransactionResponseBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public Builder mergeAbstractTransactionResponse( AbstractTransactionResponseProto value) {
      if (abstractTransactionResponseBuilder_ == null) {
        if (abstractTransactionResponse_ != null) {
          abstractTransactionResponse_ =
             AbstractTransactionResponseProto.newBuilder(abstractTransactionResponse_).mergeFrom(value).buildPartial();
        } else {
          abstractTransactionResponse_ = value;
        }
        onChanged();
      } else {
        abstractTransactionResponseBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public Builder clearAbstractTransactionResponse() {
      if (abstractTransactionResponseBuilder_ == null) {
        abstractTransactionResponse_ = null;
        onChanged();
      } else {
        abstractTransactionResponse_ = null;
        abstractTransactionResponseBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public  AbstractTransactionResponseProto.Builder getAbstractTransactionResponseBuilder() {
      
      onChanged();
      return getAbstractTransactionResponseFieldBuilder().getBuilder();
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    public  AbstractTransactionResponseProtoOrBuilder getAbstractTransactionResponseOrBuilder() {
      if (abstractTransactionResponseBuilder_ != null) {
        return abstractTransactionResponseBuilder_.getMessageOrBuilder();
      } else {
        return abstractTransactionResponse_ == null ?
             AbstractTransactionResponseProto.getDefaultInstance() : abstractTransactionResponse_;
      }
    }
    /**
     * <code>.io.seata.protocol.protobuf.AbstractTransactionResponseProto abstractTransactionResponse = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
         AbstractTransactionResponseProto,  AbstractTransactionResponseProto.Builder,  AbstractTransactionResponseProtoOrBuilder> 
        getAbstractTransactionResponseFieldBuilder() {
      if (abstractTransactionResponseBuilder_ == null) {
        abstractTransactionResponseBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
             AbstractTransactionResponseProto,  AbstractTransactionResponseProto.Builder,  AbstractTransactionResponseProtoOrBuilder>(
                getAbstractTransactionResponse(),
                getParentForChildren(),
                isClean());
        abstractTransactionResponse_ = null;
      }
      return abstractTransactionResponseBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:io.seata.protocol.protobuf.BranchReportResponseProto)
  }

  // @@protoc_insertion_point(class_scope:io.seata.protocol.protobuf.BranchReportResponseProto)
  private static final  BranchReportResponseProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new  BranchReportResponseProto();
  }

  public static  BranchReportResponseProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BranchReportResponseProto>
      PARSER = new com.google.protobuf.AbstractParser<BranchReportResponseProto>() {
    public BranchReportResponseProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BranchReportResponseProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BranchReportResponseProto> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<BranchReportResponseProto> getParserForType() {
    return PARSER;
  }

  public  BranchReportResponseProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

