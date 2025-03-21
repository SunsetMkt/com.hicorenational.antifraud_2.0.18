package com.umeng.socialize.p217c.p219b;

import android.content.Context;
import com.umeng.socialize.utils.SLog;
import java.io.File;

/* compiled from: CacheUtil.java */
/* renamed from: com.umeng.socialize.c.b.a */
/* loaded from: classes2.dex */
public class C3634a {
    /* renamed from: a */
    public static void m12628a() {
    }

    /* renamed from: a */
    public static void m12629a(Context context) {
        try {
            m12630b(context);
        } catch (Exception e2) {
            SLog.error(e2);
        }
    }

    /* renamed from: b */
    private static void m12630b(Context context) {
        File[] listFiles = new File(context.getExternalFilesDir(null), C3636c.f13585a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
