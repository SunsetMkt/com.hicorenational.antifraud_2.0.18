package p000a.p001a.p013t;

import android.text.TextUtils;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.session.C0811b;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.StringUtils;
import p000a.p001a.p004l.C0015a;

/* compiled from: Taobao */
/* renamed from: a.a.t.d */
/* loaded from: classes.dex */
public class C0039d implements InterfaceRunnableC0036a {

    /* renamed from: c */
    private C0047l f93c;

    /* renamed from: f */
    private Request f96f;

    /* renamed from: a */
    private volatile boolean f91a = false;

    /* renamed from: b */
    volatile Cancelable f92b = null;

    /* renamed from: d */
    private int f94d = 0;

    /* renamed from: e */
    private int f95e = 0;

    public C0039d(C0047l c0047l) {
        this.f93c = c0047l;
        this.f96f = c0047l.f135a.m824a();
    }

    /* renamed from: b */
    static /* synthetic */ int m180b(C0039d c0039d) {
        int i2 = c0039d.f95e;
        c0039d.f95e = i2 + 1;
        return i2;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f91a = true;
        if (this.f92b != null) {
            this.f92b.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f91a) {
            return;
        }
        if (this.f93c.f135a.m835i()) {
            String m120b = C0015a.m120b(this.f93c.f135a.m833g());
            if (!TextUtils.isEmpty(m120b)) {
                Request.Builder newBuilder = this.f96f.newBuilder();
                String str = this.f96f.getHeaders().get("Cookie");
                if (!TextUtils.isEmpty(str)) {
                    m120b = StringUtils.concatString(str, "; ", m120b);
                }
                newBuilder.addHeader("Cookie", m120b);
                this.f96f = newBuilder.build();
            }
        }
        RequestStatistic requestStatistic = this.f96f.f916a;
        requestStatistic.degraded = 2;
        requestStatistic.sendBeforeTime = System.currentTimeMillis() - this.f96f.f916a.reqStart;
        C0811b.m602a(this.f96f, new C0040e(this));
    }
}
