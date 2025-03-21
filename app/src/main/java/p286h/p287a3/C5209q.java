package p286h.p287a3;

import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: TimeSource.kt */
/* renamed from: h.a3.q */
/* loaded from: classes2.dex */
public final class C5209q {
    @InterfaceC5202j
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    /* renamed from: a */
    private static final int m18795a(@InterfaceC5816d AbstractC5207o abstractC5207o, AbstractC5207o abstractC5207o2) {
        C5544i0.m22546f(abstractC5207o, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }

    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5216c(message = "Use TimeSource interface instead.", replaceWith = @InterfaceC5467o0(expression = "TimeSource", imports = {"kotlin.time.TimeSource"}))
    /* renamed from: a */
    public static /* synthetic */ void m18796a() {
    }

    @InterfaceC5202j
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    /* renamed from: b */
    private static final double m18797b(@InterfaceC5816d AbstractC5207o abstractC5207o, AbstractC5207o abstractC5207o2) {
        C5544i0.m22546f(abstractC5207o, "$this$minus");
        throw new Error("Operation is disallowed.");
    }

    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5216c(message = "Use TimeMark class instead.", replaceWith = @InterfaceC5467o0(expression = "TimeMark", imports = {"kotlin.time.TimeMark"}))
    /* renamed from: b */
    public static /* synthetic */ void m18798b() {
    }
}
