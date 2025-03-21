package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: TimePeriodItem.java */
/* renamed from: com.umeng.analytics.pro.ai */
/* loaded from: classes2.dex */
public class C3325ai {

    /* renamed from: a */
    private String f11430a;

    /* renamed from: e */
    private boolean f11434e = false;

    /* renamed from: d */
    private int f11433d = -1;

    /* renamed from: c */
    private int f11432c = -1;

    /* renamed from: b */
    private int f11431b = -1;

    public C3325ai(String str) {
        this.f11430a = str;
        if (TextUtils.isEmpty(this.f11430a)) {
            return;
        }
        m10819a();
    }

    /* renamed from: a */
    private void m10819a() {
        try {
            if (!this.f11430a.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                this.f11433d = Integer.valueOf(this.f11430a).intValue();
                this.f11434e = false;
                return;
            }
            String[] split = this.f11430a.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                this.f11431b = Integer.valueOf(split[0]).intValue();
                this.f11432c = Integer.valueOf(split[1]).intValue();
                if (this.f11431b < 1) {
                    this.f11431b = 1;
                }
                if (this.f11432c > 24) {
                    this.f11432c = 24;
                }
            }
            this.f11434e = true;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean m10820a(int i2) {
        int i3;
        if (this.f11434e) {
            int i4 = this.f11431b;
            if (i4 != -1 && (i3 = this.f11432c) != -1 && i2 >= i4 && i2 <= i3) {
                return true;
            }
        } else {
            int i5 = this.f11433d;
            if (i5 != -1 && i2 == i5) {
                return true;
            }
        }
        return false;
    }
}
