package com.google.gson.p146a0;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Expose.java */
@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.google.gson.a0.a */
/* loaded from: classes.dex */
public @interface InterfaceC2001a {
    boolean deserialize() default true;

    boolean serialize() default true;
}
