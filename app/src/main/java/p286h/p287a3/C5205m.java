package p286h.p287a3;

import java.util.concurrent.TimeUnit;
import p286h.InterfaceC5610t0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: MonoTimeSource.kt */
@InterfaceC5202j
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.a3.m */
/* loaded from: classes2.dex */
public final class C5205m extends AbstractC5194b implements InterfaceC5208p {

    /* renamed from: c */
    public static final C5205m f20073c = new C5205m();

    private C5205m() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // p286h.p287a3.AbstractC5194b
    /* renamed from: c */
    protected long mo18671c() {
        return System.nanoTime();
    }

    @InterfaceC5816d
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
