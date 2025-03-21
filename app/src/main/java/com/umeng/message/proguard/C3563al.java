package com.umeng.message.proguard;

import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import org.android.agoo.common.AgooConstants;

/* renamed from: com.umeng.message.proguard.al */
/* loaded from: classes2.dex */
public final class C3563al {

    /* renamed from: a */
    public final C3568aq f13215a = new C3568aq(AgooConstants.MESSAGE_NOTIFICATION);

    /* renamed from: f */
    private long m12260f() {
        return this.f13215a.m12289b("rep_ts", 0L);
    }

    /* renamed from: a */
    public final boolean m12263a() {
        return this.f13215a.m12292b("e_u", true);
    }

    /* renamed from: b */
    public final long m12264b() {
        return this.f13215a.m12289b("req_ts", 0L);
    }

    /* renamed from: c */
    public final boolean m12266c() {
        return Math.abs(System.currentTimeMillis() - m12260f()) < C2084a.f6122d;
    }

    /* renamed from: d */
    public final String m12267d() {
        String m12290b = this.f13215a.m12290b("info", "");
        if (!TextUtils.isEmpty(m12290b)) {
            try {
                return new String(C3570as.m12294a(m12290b));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* renamed from: e */
    public final boolean m12268e() {
        return this.f13215a.m12292b("sync", false);
    }

    /* renamed from: a */
    public final void m12262a(boolean z) {
        this.f13215a.m12287a("e_s", z);
    }

    /* renamed from: b */
    public final void m12265b(boolean z) {
        this.f13215a.m12287a("sync", z);
    }

    /* renamed from: a */
    public final void m12261a(long j2) {
        this.f13215a.m12284a("rep_ts", j2);
    }
}
