package p251g.p252a.p268y0.p281g;

import java.util.concurrent.ThreadFactory;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p263t0.InterfaceC4546f;

/* compiled from: NewThreadScheduler.java */
/* renamed from: g.a.y0.g.h */
/* loaded from: classes2.dex */
public final class C5119h extends AbstractC4516j0 {

    /* renamed from: b */
    final ThreadFactory f19903b;

    /* renamed from: c */
    private static final String f19900c = "RxNewThreadScheduler";

    /* renamed from: e */
    private static final String f19902e = "rx2.newthread-priority";

    /* renamed from: d */
    private static final ThreadFactoryC5122k f19901d = new ThreadFactoryC5122k(f19900c, Math.max(1, Math.min(10, Integer.getInteger(f19902e, 5).intValue())));

    public C5119h() {
        this(f19901d);
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new C5120i(this.f19903b);
    }

    public C5119h(ThreadFactory threadFactory) {
        this.f19903b = threadFactory;
    }
}
