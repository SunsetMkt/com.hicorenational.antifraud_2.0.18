package b.a.l;

import android.text.TextUtils;
import anet.channel.util.ALog;
import b.a.l.a;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class b implements Runnable {
    b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(a.f())) {
                return;
            }
            a.C0023a unused = a.f1819e = new a.C0023a(a.f());
        } catch (Exception e2) {
            ALog.e(a.a, "", null, e2, new Object[0]);
        }
    }
}
