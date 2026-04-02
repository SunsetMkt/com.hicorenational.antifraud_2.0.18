package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* JADX INFO: compiled from: TimePeriodChain.java */
/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<ai> f6984b = new ArrayList<>();

    public ah(String str) {
        this.a = "";
        this.a = str;
        if (TextUtils.isEmpty(this.a)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.a.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String str = this.a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String strTrim = str.trim();
                if (this.f6984b != null) {
                    this.f6984b.add(new ai(strTrim));
                    return;
                }
                return;
            }
            for (String str2 : this.a.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                if (!TextUtils.isEmpty(str2)) {
                    String strTrim2 = str2.trim();
                    if (this.f6984b != null) {
                        this.f6984b.add(new ai(strTrim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i2) {
        try {
            if (this.f6984b == null) {
                return false;
            }
            int size = this.f6984b.size();
            for (int i3 = 0; i3 < size; i3++) {
                ai aiVar = this.f6984b.get(i3);
                if (aiVar != null && aiVar.a(i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
