package p000a.p001a.p004l;

import android.text.TextUtils;
import anet.channel.util.ALog;
import p000a.p001a.p004l.C0015a;

/* compiled from: Taobao */
/* renamed from: a.a.l.b */
/* loaded from: classes.dex */
final class RunnableC0016b implements Runnable {
    RunnableC0016b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        String m126f;
        String m126f2;
        try {
            m126f = C0015a.m126f();
            if (TextUtils.isEmpty(m126f)) {
                return;
            }
            m126f2 = C0015a.m126f();
            C0015a.a unused = C0015a.f39e = new C0015a.a(m126f2);
        } catch (Exception e2) {
            ALog.m714e(C0015a.f35a, "", null, e2, new Object[0]);
        }
    }
}
