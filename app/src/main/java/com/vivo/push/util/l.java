package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* JADX INFO: compiled from: DefaultNotifyDataAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements BaseNotifyDataAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f8673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f8674f;
    private Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8677d;

    private static boolean a(int i2) {
        return (i2 == -1 || i2 == 0) ? false : true;
    }

    private static boolean a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        u.d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (a(f8673e)) {
            return f8673e;
        }
        String str = this.f8677d;
        int iA = !a(str) ? -1 : a(str, "_notifyicon");
        f8673e = iA;
        if (a(iA)) {
            return f8673e;
        }
        for (String strSubstring = this.f8676c; !TextUtils.isEmpty(strSubstring); strSubstring = strSubstring.substring(0, strSubstring.length() - 1)) {
            int identifier = this.a.getIdentifier("vivo_push_rom" + strSubstring + "_notifyicon", "drawable", this.f8675b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.a.getIdentifier("vivo_push_notifyicon", "drawable", this.f8675b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (a(f8674f)) {
            return f8674f;
        }
        String str = this.f8677d;
        int iA = !a(str) ? -1 : a(str, "_icon");
        f8674f = iA;
        if (a(iA)) {
            return f8674f;
        }
        for (String strSubstring = this.f8676c; !TextUtils.isEmpty(strSubstring); strSubstring = strSubstring.substring(0, strSubstring.length() - 1)) {
            int identifier = this.a.getIdentifier("vivo_push_rom" + strSubstring + "_icon", "drawable", this.f8675b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.a.getIdentifier("vivo_push_icon", "drawable", this.f8675b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f8675b = context.getPackageName();
        this.a = context.getResources();
        this.f8676c = n.a();
        this.f8677d = Build.VERSION.RELEASE;
    }

    private int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit != null && strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
            try {
                for (int i2 = Integer.parseInt(str); i2 > 0; i2--) {
                    String str3 = "vivo_push_ard" + i2 + str2;
                    u.c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.a.getIdentifier(str3, "drawable", this.f8675b);
                    if (identifier > 0) {
                        u.c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                u.a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }
}
