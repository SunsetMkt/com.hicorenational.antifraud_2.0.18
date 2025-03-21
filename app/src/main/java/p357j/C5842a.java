package p357j;

import android.content.Context;
import com.luck.picture.lib.engine.CacheResourcesEngine;
import java.io.File;

/* compiled from: GlideCacheEngine.java */
/* renamed from: j.a */
/* loaded from: classes2.dex */
public class C5842a implements CacheResourcesEngine {

    /* renamed from: a */
    private static final int f21098a = 4;

    /* renamed from: b */
    private static C5842a f21099b;

    private C5842a() {
    }

    /* renamed from: a */
    public static C5842a m24585a() {
        if (f21099b == null) {
            synchronized (C5842a.class) {
                if (f21099b == null) {
                    f21099b = new C5842a();
                }
            }
        }
        return f21099b;
    }

    @Override // com.luck.picture.lib.engine.CacheResourcesEngine
    public String onCachePath(Context context, String str) {
        File m24597b = C5844c.m24597b(context, str);
        return m24597b != null ? m24597b.getAbsolutePath() : "";
    }
}
