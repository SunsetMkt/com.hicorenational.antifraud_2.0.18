package p286h.p309q2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p286h.p288f2.EnumC5231a;
import p286h.p288f2.EnumC5232b;
import p286h.p288f2.InterfaceC5233c;
import p286h.p288f2.InterfaceC5235e;
import p286h.p288f2.InterfaceC5236f;

/* compiled from: PurelyImplements.kt */
@Target({ElementType.TYPE})
@InterfaceC5233c
@InterfaceC5236f(allowedTargets = {EnumC5232b.CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@InterfaceC5235e(EnumC5231a.RUNTIME)
/* renamed from: h.q2.m */
/* loaded from: classes2.dex */
public @interface InterfaceC5489m {
    String value();
}
