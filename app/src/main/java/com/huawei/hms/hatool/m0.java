package com.huawei.hms.hatool;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class m0 {
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4781b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.314" + p.a();
    }

    public void a(int i2) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 19) {
            sb.append(System.lineSeparator());
            sb.append("======================================= ");
            sb.append(System.lineSeparator());
            sb.append(a());
            sb.append("");
            sb.append(System.lineSeparator());
            str = "=======================================";
        } else {
            sb.append("====================");
            sb.append(a());
            str = "===================";
        }
        sb.append(str);
        sb.toString();
        this.f4781b = i2;
        this.a = true;
    }

    public void a(int i2, String str, String str2) {
        if (i2 == 3 || i2 != 5) {
        }
    }

    public void b(int i2, String str, String str2) {
        a(i2, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i2) {
        return this.a && i2 >= this.f4781b;
    }
}
