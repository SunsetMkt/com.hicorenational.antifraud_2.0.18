package p251g.p252a.p268y0.p282h;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p271c.InterfaceC4615n;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5182v;
import p251g.p252a.p268y0.p284j.InterfaceC5181u;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;

/* compiled from: QueueDrainSubscriber.java */
/* renamed from: g.a.y0.h.m */
/* loaded from: classes2.dex */
public abstract class AbstractC5142m<T, U, V> extends C5146q implements InterfaceC4529q<T>, InterfaceC5181u<U, V> {

    /* renamed from: h0 */
    protected final InterfaceC5822c<? super V> f19966h0;

    /* renamed from: i0 */
    protected final InterfaceC4615n<U> f19967i0;

    /* renamed from: j0 */
    protected volatile boolean f19968j0;

    /* renamed from: k0 */
    protected volatile boolean f19969k0;

    /* renamed from: l0 */
    protected Throwable f19970l0;

    public AbstractC5142m(InterfaceC5822c<? super V> interfaceC5822c, InterfaceC4615n<U> interfaceC4615n) {
        this.f19966h0 = interfaceC5822c;
        this.f19967i0 = interfaceC4615n;
    }

    /* renamed from: a */
    protected final void m18593a(U u, boolean z, InterfaceC4552c interfaceC4552c) {
        InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
        InterfaceC4615n<U> interfaceC4615n = this.f19967i0;
        if (this.f20017p.get() == 0 && this.f20017p.compareAndSet(0, 1)) {
            long j2 = this.f20001F.get();
            if (j2 == 0) {
                interfaceC4552c.dispose();
                interfaceC5822c.onError(new C4562c("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (mo18337a(interfaceC5822c, u) && j2 != C5556m0.f20396b) {
                    mo18591a(1L);
                }
                if (mo18590a(-1) == 0) {
                    return;
                }
            }
        } else {
            interfaceC4615n.offer(u);
            if (!mo18596b()) {
                return;
            }
        }
        C5182v.m18648a(interfaceC4615n, interfaceC5822c, z, interfaceC4552c, this);
    }

    /* renamed from: a */
    public boolean mo18337a(InterfaceC5822c<? super V> interfaceC5822c, U u) {
        return false;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5181u
    /* renamed from: b */
    public final boolean mo18596b() {
        return this.f20017p.getAndIncrement() == 0;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5181u
    /* renamed from: c */
    public final boolean mo18597c() {
        return this.f19969k0;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5181u
    /* renamed from: d */
    public final boolean mo18598d() {
        return this.f19968j0;
    }

    /* renamed from: e */
    public final boolean m18599e() {
        return this.f20017p.get() == 0 && this.f20017p.compareAndSet(0, 1);
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5181u
    public final long requested() {
        return this.f20001F.get();
    }

    /* renamed from: b */
    protected final void m18595b(U u, boolean z, InterfaceC4552c interfaceC4552c) {
        InterfaceC5822c<? super V> interfaceC5822c = this.f19966h0;
        InterfaceC4615n<U> interfaceC4615n = this.f19967i0;
        if (this.f20017p.get() == 0 && this.f20017p.compareAndSet(0, 1)) {
            long j2 = this.f20001F.get();
            if (j2 == 0) {
                this.f19968j0 = true;
                interfaceC4552c.dispose();
                interfaceC5822c.onError(new C4562c("Could not emit buffer due to lack of requests"));
                return;
            } else if (interfaceC4615n.isEmpty()) {
                if (mo18337a(interfaceC5822c, u) && j2 != C5556m0.f20396b) {
                    mo18591a(1L);
                }
                if (mo18590a(-1) == 0) {
                    return;
                }
            } else {
                interfaceC4615n.offer(u);
            }
        } else {
            interfaceC4615n.offer(u);
            if (!mo18596b()) {
                return;
            }
        }
        C5182v.m18648a(interfaceC4615n, interfaceC5822c, z, interfaceC4552c, this);
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5181u
    /* renamed from: a */
    public final Throwable mo18592a() {
        return this.f19970l0;
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5181u
    /* renamed from: a */
    public final int mo18590a(int i2) {
        return this.f20017p.addAndGet(i2);
    }

    @Override // p251g.p252a.p268y0.p284j.InterfaceC5181u
    /* renamed from: a */
    public final long mo18591a(long j2) {
        return this.f20001F.addAndGet(-j2);
    }

    /* renamed from: b */
    public final void m18594b(long j2) {
        if (EnumC5160j.validate(j2)) {
            C5164d.m18607a(this.f20001F, j2);
        }
    }
}
