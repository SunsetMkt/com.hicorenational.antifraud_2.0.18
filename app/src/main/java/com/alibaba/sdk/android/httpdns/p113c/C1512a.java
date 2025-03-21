package com.alibaba.sdk.android.httpdns.p113c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.alibaba.sdk.android.httpdns.c.a */
/* loaded from: classes.dex */
public class C1512a {

    /* renamed from: i */
    private int f3870i;

    /* renamed from: q */
    private String f3871q;

    /* renamed from: com.alibaba.sdk.android.httpdns.c.a$a */
    private static final class a {

        /* renamed from: b */
        private static final C1512a f3872b = new C1512a();
    }

    private C1512a() {
        this.f3870i = 0;
        this.f3871q = "UNKNOWN";
    }

    /* renamed from: a */
    private int m3463a(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 0;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 15:
                    return 3;
                case 12:
                case 14:
                default:
                    return 0;
                case 13:
                    return 4;
            }
        }
        return 255;
    }

    /* renamed from: a */
    public static C1512a m3464a() {
        return a.f3872b;
    }

    /* renamed from: d */
    private void m3465d(Context context) {
        int m3463a = m3463a(context);
        this.f3870i = m3463a;
        this.f3871q = "sp_" + m3463a;
    }

    /* renamed from: c */
    public void m3466c(Context context) {
        m3465d(context);
    }

    public int getNetworkType() {
        return this.f3870i;
    }

    /* renamed from: h */
    public boolean m3467h() {
        return this.f3870i == 1;
    }

    /* renamed from: i */
    public String m3468i() {
        return this.f3871q;
    }
}
