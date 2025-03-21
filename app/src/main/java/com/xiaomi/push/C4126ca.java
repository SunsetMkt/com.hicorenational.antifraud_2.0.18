package com.xiaomi.push;

import android.os.Build;
import android.system.Os;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.io.File;

/* renamed from: com.xiaomi.push.ca */
/* loaded from: classes2.dex */
public class C4126ca {
    /* renamed from: a */
    public static long m14027a(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return 0L;
        }
        try {
            if (new File(str).exists()) {
                return Os.stat(str).st_size;
            }
            return 0L;
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
            return 0L;
        }
    }
}
