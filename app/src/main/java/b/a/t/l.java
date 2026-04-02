package b.a.t;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class l {
    public final anetwork.channel.entity.k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.a.p.a f1892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile AtomicBoolean f1894d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile a f1895e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Future f1896f = null;

    public l(anetwork.channel.entity.k kVar, b.a.p.a aVar) {
        this.a = kVar;
        this.f1893c = kVar.f1794i;
        this.f1892b = aVar;
    }

    public void a() {
        Future future = this.f1896f;
        if (future != null) {
            future.cancel(true);
            this.f1896f = null;
        }
    }

    public void b() {
        if (this.f1895e != null) {
            this.f1895e.cancel();
            this.f1895e = null;
        }
    }
}
