package com.umeng.message.proguard;

import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class al {
    public final aq a = new aq(AgooConstants.MESSAGE_NOTIFICATION);

    private long f() {
        return this.a.b("rep_ts", 0L);
    }

    public final boolean a() {
        return this.a.b("e_u", true);
    }

    public final long b() {
        return this.a.b("req_ts", 0L);
    }

    public final boolean c() {
        return Math.abs(System.currentTimeMillis() - f()) < com.heytap.mcssdk.constant.a.f3868d;
    }

    public final String d() {
        String strB = this.a.b("info", "");
        if (!TextUtils.isEmpty(strB)) {
            try {
                return new String(as.a(strB));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final boolean e() {
        return this.a.b("sync", false);
    }

    public final void a(boolean z) {
        this.a.a("e_s", z);
    }

    public final void b(boolean z) {
        this.a.a("sync", z);
    }

    public final void a(long j2) {
        this.a.a("rep_ts", j2);
    }
}
