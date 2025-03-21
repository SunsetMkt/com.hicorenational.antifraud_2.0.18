package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* compiled from: TimePeriodChain.java */
/* renamed from: com.umeng.analytics.pro.ah */
/* loaded from: classes2.dex */
public class C3324ah {

    /* renamed from: a */
    private String f11428a;

    /* renamed from: b */
    private ArrayList<C3325ai> f11429b = new ArrayList<>();

    public C3324ah(String str) {
        this.f11428a = "";
        this.f11428a = str;
        if (TextUtils.isEmpty(this.f11428a)) {
            return;
        }
        m10817a();
    }

    /* renamed from: a */
    private void m10817a() {
        try {
            if (!this.f11428a.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String str = this.f11428a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String trim = str.trim();
                if (this.f11429b != null) {
                    this.f11429b.add(new C3325ai(trim));
                    return;
                }
                return;
            }
            for (String str2 : this.f11428a.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (!TextUtils.isEmpty(str2)) {
                    String trim2 = str2.trim();
                    if (this.f11429b != null) {
                        this.f11429b.add(new C3325ai(trim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean m10818a(int i2) {
        try {
            if (this.f11429b == null) {
                return false;
            }
            int size = this.f11429b.size();
            for (int i3 = 0; i3 < size; i3++) {
                C3325ai c3325ai = this.f11429b.get(i3);
                if (c3325ai != null && c3325ai.m10820a(i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
