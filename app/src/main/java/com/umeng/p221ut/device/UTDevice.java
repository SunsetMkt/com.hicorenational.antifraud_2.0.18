package com.umeng.p221ut.device;

import android.content.Context;
import com.umeng.p221ut.p226b.p229b.C3818c;

/* loaded from: classes2.dex */
public class UTDevice {
    private static String getTid(Context context) {
        return C3818c.getTid(context);
    }

    public static String getUtdid(Context context) {
        return C3818c.getUtdid(context);
    }

    private static boolean isNewDid(Context context) {
        return C3818c.isNewDid(context);
    }

    private static void removeTid(Context context) {
        C3818c.removeTid(context);
    }

    private static void resetDid(Context context, String str, long j2) {
        C3818c.resetDid(context, str, j2);
    }
}
