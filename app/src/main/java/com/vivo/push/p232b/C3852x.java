package com.vivo.push.p232b;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;
import com.vivo.push.util.C4010u;
import java.util.HashMap;

/* compiled from: ReporterCommand.java */
/* renamed from: com.vivo.push.b.x */
/* loaded from: classes2.dex */
public final class C3852x extends AbstractC4016v {

    /* renamed from: a */
    private HashMap<String, String> f13957a;

    /* renamed from: b */
    private long f13958b;

    public C3852x() {
        super(2012);
    }

    /* renamed from: a */
    public final void m12886a(HashMap<String, String> hashMap) {
        this.f13957a = hashMap;
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    public final void mo12833c(C3862d c3862d) {
        c3862d.m12916a("ReporterCommand.EXTRA_PARAMS", this.f13957a);
        c3862d.m12915a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13958b);
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    public final void mo12834d(C3862d c3862d) {
        this.f13957a = (HashMap) c3862d.m12926d("ReporterCommand.EXTRA_PARAMS");
        this.f13958b = c3862d.m12922b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f13958b);
    }

    @Override // com.vivo.push.AbstractC4016v
    public final String toString() {
        return "ReporterCommand（" + this.f13958b + ")";
    }

    public C3852x(long j2) {
        this();
        this.f13958b = j2;
    }

    /* renamed from: d */
    public final void m12887d() {
        if (this.f13957a == null) {
            C4010u.m13309d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.f13958b);
        sb.append(",msgId:");
        String str = this.f13957a.get(C2085b.f6162c);
        if (TextUtils.isEmpty(str)) {
            str = this.f13957a.get("message_id");
        }
        sb.append(str);
        C4010u.m13309d("ReporterCommand", sb.toString());
    }
}
