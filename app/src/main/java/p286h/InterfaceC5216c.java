package p286h;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p286h.p288f2.EnumC5232b;
import p286h.p288f2.InterfaceC5233c;
import p286h.p288f2.InterfaceC5236f;

/* compiled from: Annotations.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@InterfaceC5233c
@InterfaceC5236f(allowedTargets = {EnumC5232b.CLASS, EnumC5232b.FUNCTION, EnumC5232b.PROPERTY, EnumC5232b.ANNOTATION_CLASS, EnumC5232b.CONSTRUCTOR, EnumC5232b.PROPERTY_SETTER, EnumC5232b.PROPERTY_GETTER, EnumC5232b.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: h.c */
/* loaded from: classes2.dex */
public @interface InterfaceC5216c {
    EnumC5220d level() default EnumC5220d.WARNING;

    String message();

    InterfaceC5467o0 replaceWith() default @InterfaceC5467o0(expression = "", imports = {});
}
