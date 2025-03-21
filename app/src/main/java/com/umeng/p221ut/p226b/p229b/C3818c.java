package com.umeng.p221ut.p226b.p229b;

import android.content.Context;
import com.umeng.p221ut.p222a.C3796a;

/* renamed from: com.umeng.ut.b.b.c */
/* loaded from: classes2.dex */
public class C3818c {
    public static String getTid(Context context) {
        if (context == null) {
            return null;
        }
        return C3819d.m12808a(context).m12824m();
    }

    public static String getUtdid(Context context) {
        if (context == null) {
            return "ffffffffffffffffffffffff";
        }
        C3796a.m12755a().m12760a(context);
        return C3816a.m12801a().getUtdid(context);
    }

    public static boolean isNewDid(Context context) {
        if (context == null) {
            return false;
        }
        return C3819d.m12808a(context).m12822d();
    }

    public static void removeTid(Context context) {
        if (context == null) {
            return;
        }
        C3819d.m12808a(context).m12823f();
    }

    public static void resetDid(Context context, String str, long j2) {
        if (context == null) {
            return;
        }
        C3819d.m12808a(context).m12820a(str, j2);
    }
}
