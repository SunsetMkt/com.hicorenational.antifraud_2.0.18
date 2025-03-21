package p286h.p304m2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p286h.EnumC5220d;
import p286h.InterfaceC5610t0;
import p286h.p288f2.EnumC5231a;
import p286h.p288f2.EnumC5232b;
import p286h.p288f2.InterfaceC5234d;
import p286h.p288f2.InterfaceC5235e;
import p286h.p288f2.InterfaceC5236f;

/* compiled from: Annotations.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@InterfaceC5236f(allowedTargets = {EnumC5232b.CLASS, EnumC5232b.FUNCTION, EnumC5232b.PROPERTY, EnumC5232b.CONSTRUCTOR, EnumC5232b.TYPEALIAS})
@InterfaceC5610t0(version = "1.2")
@InterfaceC5234d
@Retention(RetentionPolicy.SOURCE)
@InterfaceC5235e(EnumC5231a.SOURCE)
/* renamed from: h.m2.o */
/* loaded from: classes2.dex */
public @interface InterfaceC5435o {
    int errorCode() default -1;

    EnumC5220d level() default EnumC5220d.ERROR;

    String message() default "";

    String version();

    EnumC5436p versionKind() default EnumC5436p.LANGUAGE_VERSION;
}
