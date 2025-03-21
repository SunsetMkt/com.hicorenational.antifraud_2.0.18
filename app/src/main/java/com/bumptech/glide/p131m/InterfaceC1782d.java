package com.bumptech.glide.p131m;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: GlideOption.java */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* renamed from: com.bumptech.glide.m.d */
/* loaded from: classes.dex */
public @interface InterfaceC1782d {

    /* renamed from: a */
    public static final int f5051a = 0;

    /* renamed from: b */
    public static final int f5052b = 1;

    /* renamed from: c */
    public static final int f5053c = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
