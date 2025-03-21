package com.tencent.bugly.beta.download;

import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.p205ui.C3095f;
import com.tencent.bugly.beta.p205ui.C3096g;
import com.tencent.bugly.beta.upgrade.C3099b;
import com.tencent.bugly.crashreport.common.info.C3114b;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3191p;
import com.tencent.bugly.proguard.C3199x;
import java.util.ArrayList;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.download.c */
/* loaded from: classes2.dex */
public class C3077c {

    /* renamed from: a */
    final int f9854a;

    /* renamed from: b */
    final Object[] f9855b;

    public C3077c(int i2, Object... objArr) {
        this.f9854a = i2;
        this.f9855b = objArr;
    }

    /* renamed from: a */
    public synchronized void m9316a(int i2, int i3) {
        try {
            int i4 = this.f9854a;
            if (i4 != 1) {
                if (i4 == 2) {
                    DownloadTask downloadTask = (DownloadTask) this.f9855b[0];
                    C3095f c3095f = (C3095f) this.f9855b[2];
                    if (i3 == 1) {
                        downloadTask.download();
                        C3151an.m9921c("continue download", new Object[0]);
                        this.f9855b[1] = false;
                        c3095f.mo9351a();
                    } else if ((i2 == 1 || ((Boolean) this.f9855b[1]).booleanValue()) && !C3082e.f9867G.f9888U && !C3082e.f9867G.f9889V) {
                        downloadTask.stop();
                        C3151an.m9921c("wifi network change to mobile network, stop download", new Object[0]);
                        this.f9855b[1] = true;
                        if (C3114b.m9606f(C3082e.f9867G.f9919u) != null) {
                            C3096g.m9360a(c3095f, true);
                            this.f9855b[1] = false;
                        }
                    }
                }
            } else if (i3 == 1 || i3 == 3 || i3 == 4) {
                ArrayList arrayList = (ArrayList) C3191p.f10775a.m10128a();
                if (arrayList != null && !arrayList.isEmpty()) {
                    C3099b.f9999a.m9374a(new C3199x(arrayList), true);
                }
            }
        } catch (Exception e2) {
            if (!C3151an.m9919b(e2)) {
                e2.printStackTrace();
            }
        }
    }
}
