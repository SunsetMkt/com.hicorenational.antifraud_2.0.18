package com.umeng.socialize.c.b;

import android.content.Context;
import com.umeng.socialize.utils.SLog;
import java.io.File;

/* compiled from: CacheUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static void a() {
    }

    public static void a(Context context) {
        try {
            b(context);
        } catch (Exception e2) {
            SLog.error(e2);
        }
    }

    private static void b(Context context) {
        File[] listFiles = new File(context.getExternalFilesDir(null), c.f11650a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
