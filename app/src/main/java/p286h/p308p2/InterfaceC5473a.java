package p286h.p308p2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p286h.InterfaceC5322h0;
import p286h.p288f2.EnumC5232b;
import p286h.p288f2.InterfaceC5236f;

/* compiled from: JsAnnotationsH.kt */
@InterfaceC5322h0
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@InterfaceC5236f(allowedTargets = {EnumC5232b.CLASS, EnumC5232b.FUNCTION, EnumC5232b.PROPERTY, EnumC5232b.CONSTRUCTOR, EnumC5232b.PROPERTY_GETTER, EnumC5232b.PROPERTY_SETTER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: h.p2.a */
/* loaded from: classes2.dex */
@interface InterfaceC5473a {
    String name();
}
