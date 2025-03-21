package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.utils.C3531d;

/* compiled from: UTDIdTracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.j */
/* loaded from: classes2.dex */
public class C3510j extends AbstractC3501a {

    /* renamed from: a */
    private static final String f12806a = "utdid";

    /* renamed from: b */
    private Context f12807b;

    public C3510j(Context context) {
        super("utdid");
        this.f12807b = context;
    }

    /* renamed from: g */
    private String m11875g() {
        try {
            return this.f12807b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: h */
    private String m11876h() {
        try {
            return this.f12807b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    /* renamed from: f */
    public String mo11855f() {
        try {
            if (FieldManager.allow(C3531d.f13019u)) {
                String m11876h = m11876h();
                return TextUtils.isEmpty(m11876h) ? m11875g() : m11876h;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
