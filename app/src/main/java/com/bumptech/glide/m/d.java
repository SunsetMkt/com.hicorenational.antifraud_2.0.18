package com.bumptech.glide.m;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: GlideOption.java */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface d {
    public static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3305b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3306c = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
