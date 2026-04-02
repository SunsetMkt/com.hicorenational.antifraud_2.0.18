package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class CacheApi {
    private static String a = "CacheApi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CacheApi f8335e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f8336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CacheExector f8337c = new CacheExector(a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f8338d;

    private CacheApi(Context context) {
        this.f8338d = context;
    }

    private String a() {
        Context context = this.f8338d;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getPath();
    }

    public static CacheApi get(Context context) {
        if (f8335e == null) {
            f8335e = new CacheApi(context);
        }
        return f8335e;
    }

    public double checkSize(String str) {
        CacheExector cacheExector = this.f8337c;
        if (cacheExector == null) {
            return 0.0d;
        }
        return cacheExector.checkSize(str);
    }

    public boolean delete(String str) {
        CacheExector cacheExector = this.f8337c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.deleteFile(str);
    }

    public IReader read(String str, Class cls) {
        CacheExector cacheExector = this.f8337c;
        if (cacheExector == null) {
            return null;
        }
        return cacheExector.readFile(str, cls);
    }

    public boolean save(String str, String str2) {
        CacheExector cacheExector = this.f8337c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.save(str, str2);
    }
}
