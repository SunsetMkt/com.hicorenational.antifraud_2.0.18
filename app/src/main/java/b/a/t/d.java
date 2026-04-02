package b.a.t;

import android.text.TextUtils;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.StringUtils;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class d implements a {

    /* JADX INFO: renamed from: c */
    private l f1859c;

    /* JADX INFO: renamed from: f */
    private Request f1862f;
    private volatile boolean a = false;

    /* JADX INFO: renamed from: b */
    volatile Cancelable f1858b = null;

    /* JADX INFO: renamed from: d */
    private int f1860d = 0;

    /* JADX INFO: renamed from: e */
    private int f1861e = 0;

    public d(l lVar) {
        this.f1859c = lVar;
        this.f1862f = lVar.a.a();
    }

    static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f1861e;
        dVar.f1861e = i2 + 1;
        return i2;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.a = true;
        if (this.f1858b != null) {
            this.f1858b.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a) {
            return;
        }
        if (this.f1859c.a.i()) {
            String strB = b.a.l.a.b(this.f1859c.a.g());
            if (!TextUtils.isEmpty(strB)) {
                Request.Builder builderNewBuilder = this.f1862f.newBuilder();
                String str = this.f1862f.getHeaders().get("Cookie");
                if (!TextUtils.isEmpty(str)) {
                    strB = StringUtils.concatString(str, "; ", strB);
                }
                builderNewBuilder.addHeader("Cookie", strB);
                this.f1862f = builderNewBuilder.build();
            }
        }
        RequestStatistic requestStatistic = this.f1862f.a;
        requestStatistic.degraded = 2;
        requestStatistic.sendBeforeTime = System.currentTimeMillis() - this.f1862f.a.reqStart;
        anet.channel.session.b.a(this.f1862f, new e(this));
    }
}
