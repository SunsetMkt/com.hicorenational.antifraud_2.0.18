package com.umeng.message.proguard;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final class am {
    public static void a(ac acVar) {
        if (Build.VERSION.SDK_INT < 23 || acVar == null || acVar.f7944b == null) {
            return;
        }
        Object obj = acVar.f7945c;
        if (obj instanceof c) {
            ((c) obj).c();
        }
        acVar.f7945c = null;
    }
}
