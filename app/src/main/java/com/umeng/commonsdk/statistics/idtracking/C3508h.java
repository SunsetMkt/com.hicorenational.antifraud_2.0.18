package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.C3336at;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.utils.C3531d;

/* compiled from: OaidTracking.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.h */
/* loaded from: classes2.dex */
public class C3508h extends AbstractC3501a {

    /* renamed from: a */
    public static final String f12800a = C3336at.m10865b().m10868b(C3336at.f11498l);

    /* renamed from: b */
    public static final String f12801b = "key_umeng_sp_oaid";

    /* renamed from: c */
    public static final String f12802c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d */
    private static final String f12803d = "oaid";

    /* renamed from: e */
    private Context f12804e;

    public C3508h(Context context) {
        super(f12803d);
        this.f12804e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    /* renamed from: f */
    public String mo11855f() {
        if (!FieldManager.allow(C3531d.f12959G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f12804e.getSharedPreferences(f12800a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(f12801b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
