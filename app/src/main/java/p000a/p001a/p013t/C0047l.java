package p000a.p001a.p013t;

import anetwork.channel.entity.C0899k;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p008p.InterfaceC0026a;

/* compiled from: Taobao */
/* renamed from: a.a.t.l */
/* loaded from: classes.dex */
class C0047l {

    /* renamed from: a */
    public final C0899k f135a;

    /* renamed from: b */
    public InterfaceC0026a f136b;

    /* renamed from: c */
    public final String f137c;

    /* renamed from: d */
    public volatile AtomicBoolean f138d = new AtomicBoolean();

    /* renamed from: e */
    public volatile InterfaceRunnableC0036a f139e = null;

    /* renamed from: f */
    public volatile Future f140f = null;

    public C0047l(C0899k c0899k, InterfaceC0026a interfaceC0026a) {
        this.f135a = c0899k;
        this.f137c = c0899k.f1367i;
        this.f136b = interfaceC0026a;
    }

    /* renamed from: a */
    public void m197a() {
        Future future = this.f140f;
        if (future != null) {
            future.cancel(true);
            this.f140f = null;
        }
    }

    /* renamed from: b */
    public void m198b() {
        if (this.f139e != null) {
            this.f139e.cancel();
            this.f139e = null;
        }
    }
}
