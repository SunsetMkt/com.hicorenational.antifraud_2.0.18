package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.util.u;

/* JADX INFO: compiled from: NodeReportItem.java */
/* JADX INFO: loaded from: classes2.dex */
final class m {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8598b;

    public m(com.vivo.push.restructure.a.a aVar, String str) {
        if (aVar != null) {
            this.a = aVar.a();
        }
        this.f8598b = str;
    }

    public final com.vivo.push.b.h a() {
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.f8598b)) {
            return new com.vivo.push.b.h(this.a, this.f8598b);
        }
        u.a("convertOffLineMsg() error, mMessageID = " + this.a + ", mNodeArrayInfo = " + this.f8598b);
        return null;
    }
}
