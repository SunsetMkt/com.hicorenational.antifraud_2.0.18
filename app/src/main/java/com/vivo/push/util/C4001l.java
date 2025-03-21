package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* compiled from: DefaultNotifyDataAdapter.java */
/* renamed from: com.vivo.push.util.l */
/* loaded from: classes2.dex */
public final class C4001l implements BaseNotifyDataAdapter {

    /* renamed from: e */
    private static int f14252e;

    /* renamed from: f */
    private static int f14253f;

    /* renamed from: a */
    private Resources f14254a;

    /* renamed from: b */
    private String f14255b;

    /* renamed from: c */
    private String f14256c;

    /* renamed from: d */
    private String f14257d;

    /* renamed from: a */
    private static boolean m13263a(int i2) {
        return (i2 == -1 || i2 == 0) ? false : true;
    }

    /* renamed from: a */
    private static boolean m13264a(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        C4010u.m13309d("DefaultNotifyDataAdapter", "systemVersion is not suit ");
        return false;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultNotifyIcon() {
        if (m13263a(f14252e)) {
            return f14252e;
        }
        String str = this.f14257d;
        int m13262a = !m13264a(str) ? -1 : m13262a(str, "_notifyicon");
        f14252e = m13262a;
        if (m13263a(m13262a)) {
            return f14252e;
        }
        for (String str2 = this.f14256c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f14254a.getIdentifier("vivo_push_rom" + str2 + "_notifyicon", "drawable", this.f14255b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f14254a.getIdentifier("vivo_push_notifyicon", "drawable", this.f14255b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getDefaultSmallIconId() {
        if (m13263a(f14253f)) {
            return f14253f;
        }
        String str = this.f14257d;
        int m13262a = !m13264a(str) ? -1 : m13262a(str, "_icon");
        f14253f = m13262a;
        if (m13263a(m13262a)) {
            return f14253f;
        }
        for (String str2 = this.f14256c; !TextUtils.isEmpty(str2); str2 = str2.substring(0, str2.length() - 1)) {
            int identifier = this.f14254a.getIdentifier("vivo_push_rom" + str2 + "_icon", "drawable", this.f14255b);
            if (identifier > 0) {
                return identifier;
            }
        }
        return this.f14254a.getIdentifier("vivo_push_icon", "drawable", this.f14255b);
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final int getNotifyMode(InsideNotificationItem insideNotificationItem) {
        return Build.VERSION.SDK_INT >= 21 ? 2 : 1;
    }

    @Override // com.vivo.push.util.BaseNotifyDataAdapter
    public final void init(Context context) {
        this.f14255b = context.getPackageName();
        this.f14254a = context.getResources();
        this.f14256c = C4003n.m13265a();
        this.f14257d = Build.VERSION.RELEASE;
    }

    /* renamed from: a */
    private int m13262a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            if (split != null && split.length > 0) {
                str = split[0];
            }
            try {
                for (int parseInt = Integer.parseInt(str); parseInt > 0; parseInt--) {
                    String str3 = "vivo_push_ard" + parseInt + str2;
                    C4010u.m13306c("DefaultNotifyDataAdapter", "get notify icon : ".concat(String.valueOf(str3)));
                    int identifier = this.f14254a.getIdentifier(str3, "drawable", this.f14255b);
                    if (identifier > 0) {
                        C4010u.m13306c("DefaultNotifyDataAdapter", "find notify icon : ".concat(String.valueOf(str3)));
                        return identifier;
                    }
                }
            } catch (Exception e2) {
                C4010u.m13294a("DefaultNotifyDataAdapter", e2);
            }
        }
        return -1;
    }
}
