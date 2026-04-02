package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: compiled from: OaidTracking.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends a {
    public static final String a = at.b().b(at.f7026l);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7724b = "key_umeng_sp_oaid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7725c = "key_umeng_sp_oaid_required_time";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f7726d = "oaid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f7727e;

    public h(Context context) {
        super(f7726d);
        this.f7727e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f7727e.getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f7724b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
