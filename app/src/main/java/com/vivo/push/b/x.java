package com.vivo.push.b;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: ReporterCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends com.vivo.push.v {
    private HashMap<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8473b;

    public x() {
        super(2012);
    }

    public final void a(HashMap<String, String> map) {
        this.a = map;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f8473b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f8473b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f8473b);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand\uff08" + this.f8473b + ")";
    }

    public x(long j2) {
        this();
        this.f8473b = j2;
    }

    public final void d() {
        if (this.a == null) {
            com.vivo.push.util.u.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb = new StringBuilder("report message reportType:");
        sb.append(this.f8473b);
        sb.append(",msgId:");
        String str = this.a.get(com.heytap.mcssdk.constant.b.f3893c);
        if (TextUtils.isEmpty(str)) {
            str = this.a.get("message_id");
        }
        sb.append(str);
        com.vivo.push.util.u.d("ReporterCommand", sb.toString());
    }
}
