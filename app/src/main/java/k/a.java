package k;

import android.content.Context;
import com.luck.picture.lib.engine.CacheResourcesEngine;
import java.io.File;

/* JADX INFO: compiled from: GlideCacheEngine.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements CacheResourcesEngine {
    private static final int a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f12637b;

    private a() {
    }

    public static a a() {
        if (f12637b == null) {
            synchronized (a.class) {
                if (f12637b == null) {
                    f12637b = new a();
                }
            }
        }
        return f12637b;
    }

    @Override // com.luck.picture.lib.engine.CacheResourcesEngine
    public String onCachePath(Context context, String str) {
        File fileB = c.b(context, str);
        return fileB != null ? fileB.getAbsolutePath() : "";
    }
}
