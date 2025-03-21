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
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@InterfaceC5236f(allowedTargets = {EnumC5232b.CLASS, EnumC5232b.PROPERTY, EnumC5232b.LOCAL_VARIABLE, EnumC5232b.VALUE_PARAMETER, EnumC5232b.CONSTRUCTOR, EnumC5232b.FUNCTION, EnumC5232b.PROPERTY_GETTER, EnumC5232b.PROPERTY_SETTER, EnumC5232b.EXPRESSION, EnumC5232b.FILE, EnumC5232b.TYPEALIAS})
@InterfaceC5610t0(version = "1.2")
@InterfaceC5216c(message = "Please use OptIn instead.", replaceWith = @InterfaceC5467o0(expression = "OptIn(*markerClass)", imports = {"kotlin.OptIn"}))
@Retention(RetentionPolicy.SOURCE)
@InterfaceC5235e(EnumC5231a.SOURCE)
/* renamed from: h.c2 */
/* loaded from: classes2.dex */
public @interface InterfaceC5219c2 {
    Class<? extends Annotation>[] markerClass();
}
