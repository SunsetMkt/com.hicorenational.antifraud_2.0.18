package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes2.dex */
public class CacheApi {

    /* renamed from: a */
    private static String f13722a = "CacheApi";

    /* renamed from: e */
    private static CacheApi f13723e;

    /* renamed from: b */
    private Handler f13724b;

    /* renamed from: c */
    private CacheExector f13725c = new CacheExector(m12672a());

    /* renamed from: d */
    private Context f13726d;

    private CacheApi(Context context) {
        this.f13726d = context;
    }

    /* renamed from: a */
    private String m12672a() {
        Context context = this.f13726d;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getPath();
    }

    public static CacheApi get(Context context) {
        if (f13723e == null) {
            f13723e = new CacheApi(context);
        }
        return f13723e;
    }

    public double checkSize(String str) {
        CacheExector cacheExector = this.f13725c;
        if (cacheExector == null) {
            return 0.0d;
        }
        return cacheExector.checkSize(str);
    }

    public boolean delete(String str) {
        CacheExector cacheExector = this.f13725c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.deleteFile(str);
    }

    public IReader read(String str, Class cls) {
        CacheExector cacheExector = this.f13725c;
        if (cacheExector == null) {
            return null;
        }
        return cacheExector.readFile(str, cls);
    }

    public boolean save(String str, String str2) {
        CacheExector cacheExector = this.f13725c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.save(str, str2);
    }
}
