package p251g.p252a.p268y0.p281g;

import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: ImmediateThinScheduler.java */
/* renamed from: g.a.y0.g.e */
/* loaded from: classes2.dex */
public final class C5116e extends AbstractC4516j0 {

    /* renamed from: b */
    public static final AbstractC4516j0 f19869b = new C5116e();

    /* renamed from: c */
    static final AbstractC4516j0.c f19870c = new a();

    /* renamed from: d */
    static final InterfaceC4552c f19871d = C4553d.m18189b();

    static {
        f19871d.dispose();
    }

    private C5116e() {
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17407a(@InterfaceC4546f Runnable runnable) {
        runnable.run();
        return f19871d;
    }

    /* compiled from: ImmediateThinScheduler.java */
    /* renamed from: g.a.y0.g.e$a */
    static final class a extends AbstractC4516j0.c {
        a() {
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
            runnable.run();
            return C5116e.f19871d;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return false;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17412a(@InterfaceC4546f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17409a(@InterfaceC4546f Runnable runnable, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public InterfaceC4552c mo17408a(@InterfaceC4546f Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return f19870c;
    }
}
