package com.huawei.hms.hatool;

import android.os.Build;

/* renamed from: com.huawei.hms.hatool.m0 */
/* loaded from: classes.dex */
public class C2431m0 {

    /* renamed from: a */
    private boolean f7577a = false;

    /* renamed from: b */
    private int f7578b = 4;

    /* renamed from: a */
    private static String m7230a() {
        return "FormalHASDK_2.2.0.314" + C2439p.m7276a();
    }

    /* renamed from: a */
    public void m7231a(int i2) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 19) {
            sb.append(System.lineSeparator());
            sb.append("======================================= ");
            sb.append(System.lineSeparator());
            sb.append(m7230a());
            sb.append("");
            sb.append(System.lineSeparator());
            str = "=======================================";
        } else {
            sb.append("====================");
            sb.append(m7230a());
            str = "===================";
        }
        sb.append(str);
        sb.toString();
        this.f7578b = i2;
        this.f7577a = true;
    }

    /* renamed from: a */
    public void m7232a(int i2, String str, String str2) {
        if (i2 == 3 || i2 != 5) {
        }
    }

    /* renamed from: b */
    public void m7233b(int i2, String str, String str2) {
        m7232a(i2, "FormalHASDK", str + "=> " + str2);
    }

    /* renamed from: b */
    public boolean m7234b(int i2) {
        return this.f7577a && i2 >= this.f7578b;
    }
}
