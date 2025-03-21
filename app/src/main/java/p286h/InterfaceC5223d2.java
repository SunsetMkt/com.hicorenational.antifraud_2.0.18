package p286h;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p286h.p288f2.EnumC5231a;
import p286h.p288f2.EnumC5232b;
import p286h.p288f2.InterfaceC5235e;
import p286h.p288f2.InterfaceC5236f;

/* compiled from: Experimental.kt */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@InterfaceC5236f(allowedTargets = {EnumC5232b.CLASS, EnumC5232b.PROPERTY, EnumC5232b.CONSTRUCTOR, EnumC5232b.FUNCTION, EnumC5232b.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@InterfaceC5235e(EnumC5231a.BINARY)
/* renamed from: h.d2 */
/* loaded from: classes2.dex */
public @interface InterfaceC5223d2 {
    Class<? extends Annotation>[] markerClass();
}
