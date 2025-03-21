package p286h;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p286h.p288f2.EnumC5231a;
import p286h.p288f2.EnumC5232b;
import p286h.p288f2.InterfaceC5235e;
import p286h.p288f2.InterfaceC5236f;
import p286h.p309q2.InterfaceC5481e;

/* compiled from: Metadata.kt */
@Target({ElementType.TYPE})
@InterfaceC5236f(allowedTargets = {EnumC5232b.CLASS})
@InterfaceC5610t0(version = "1.3")
@Retention(RetentionPolicy.RUNTIME)
@InterfaceC5235e(EnumC5231a.RUNTIME)
/* renamed from: h.y */
/* loaded from: classes2.dex */
public @interface InterfaceC5713y {
    @InterfaceC5481e(name = "bv")
    /* renamed from: bv */
    int[] m23544bv() default {};

    @InterfaceC5481e(name = "d1")
    /* renamed from: d1 */
    String[] m23545d1() default {};

    @InterfaceC5481e(name = "d2")
    /* renamed from: d2 */
    String[] m23546d2() default {};

    @InterfaceC5481e(name = "k")
    /* renamed from: k */
    int m23547k() default 1;

    @InterfaceC5481e(name = "mv")
    /* renamed from: mv */
    int[] m23548mv() default {};

    @InterfaceC5481e(name = "pn")
    /* renamed from: pn */
    String m23549pn() default "";

    @InterfaceC5481e(name = "xi")
    /* renamed from: xi */
    int m23550xi() default 0;

    @InterfaceC5481e(name = "xs")
    /* renamed from: xs */
    String m23551xs() default "";
}
