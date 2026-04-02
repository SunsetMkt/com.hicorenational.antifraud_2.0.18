package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: compiled from: TimePeriodItem.java */
/* JADX INFO: loaded from: classes2.dex */
public class ai {
    private String a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6988e = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6987d = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6986c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6985b = -1;

    public ai(String str) {
        this.a = str;
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.a.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                this.f6987d = Integer.valueOf(this.a).intValue();
                this.f6988e = false;
                return;
            }
            String[] strArrSplit = this.a.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (strArrSplit.length == 2) {
                this.f6985b = Integer.valueOf(strArrSplit[0]).intValue();
                this.f6986c = Integer.valueOf(strArrSplit[1]).intValue();
                if (this.f6985b < 1) {
                    this.f6985b = 1;
                }
                if (this.f6986c > 24) {
                    this.f6986c = 24;
                }
            }
            this.f6988e = true;
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i2) {
        int i3;
        if (this.f6988e) {
            int i4 = this.f6985b;
            if (i4 != -1 && (i3 = this.f6986c) != -1 && i2 >= i4 && i2 <= i3) {
                return true;
            }
        } else {
            int i5 = this.f6987d;
            if (i5 != -1 && i2 == i5) {
                return true;
            }
        }
        return false;
    }
}
