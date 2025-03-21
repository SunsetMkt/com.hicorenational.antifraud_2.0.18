package com.google.gson.p146a0;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonAdapter.java */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.google.gson.a0.b */
/* loaded from: classes.dex */
public @interface InterfaceC2002b {
    boolean nullSafe() default true;

    Class<?> value();
}
