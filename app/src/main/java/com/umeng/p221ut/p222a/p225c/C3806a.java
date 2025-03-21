package com.umeng.p221ut.p222a.p225c;

import android.content.Context;
import com.umeng.commonsdk.utils.UMUtils;

/* renamed from: com.umeng.ut.a.c.a */
/* loaded from: classes2.dex */
public class C3806a {
    /* renamed from: a */
    public static boolean m12770a(Context context) {
        try {
            return UMUtils.isMainProgress(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }
}
