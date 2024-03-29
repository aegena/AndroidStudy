//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: study.proto

package com.campanula.study.proto3;

@kotlin.jvm.JvmName("-initializeperson")
inline fun person(block: com.campanula.study.proto3.PersonKt.Dsl.() -> kotlin.Unit): com.campanula.study.proto3.Person =
  com.campanula.study.proto3.PersonKt.Dsl._create(com.campanula.study.proto3.Person.newBuilder()).apply { block() }._build()
object PersonKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: com.campanula.study.proto3.Person.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: com.campanula.study.proto3.Person.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): com.campanula.study.proto3.Person = _builder.build()

    /**
     * <code>string name = 1;</code>
     */
    var name: kotlin.String
      @JvmName("getName")
      get() = _builder.getName()
      @JvmName("setName")
      set(value) {
        _builder.setName(value)
      }
    /**
     * <code>string name = 1;</code>
     */
    fun clearName() {
      _builder.clearName()
    }

    /**
     * <code>int32 id = 2;</code>
     */
    var id: kotlin.Int
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * <code>int32 id = 2;</code>
     */
    fun clearId() {
      _builder.clearId()
    }

    /**
     * <code>string email = 3;</code>
     */
    var email: kotlin.String
      @JvmName("getEmail")
      get() = _builder.getEmail()
      @JvmName("setEmail")
      set(value) {
        _builder.setEmail(value)
      }
    /**
     * <code>string email = 3;</code>
     */
    fun clearEmail() {
      _builder.clearEmail()
    }

    /**
     * <code>.google.protobuf.Timestamp timestamp = 4;</code>
     */
    var timestamp: com.google.protobuf.Timestamp
      @JvmName("getTimestamp")
      get() = _builder.getTimestamp()
      @JvmName("setTimestamp")
      set(value) {
        _builder.setTimestamp(value)
      }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 4;</code>
     */
    fun clearTimestamp() {
      _builder.clearTimestamp()
    }
    /**
     * <code>.google.protobuf.Timestamp timestamp = 4;</code>
     * @return Whether the timestamp field is set.
     */
    fun hasTimestamp(): kotlin.Boolean {
      return _builder.hasTimestamp()
    }
  }
}
@kotlin.jvm.JvmSynthetic
inline fun com.campanula.study.proto3.Person.copy(block: com.campanula.study.proto3.PersonKt.Dsl.() -> kotlin.Unit): com.campanula.study.proto3.Person =
  com.campanula.study.proto3.PersonKt.Dsl._create(this.toBuilder()).apply { block() }._build()

val com.campanula.study.proto3.PersonOrBuilder.timestampOrNull: com.google.protobuf.Timestamp?
  get() = if (hasTimestamp()) getTimestamp() else null

