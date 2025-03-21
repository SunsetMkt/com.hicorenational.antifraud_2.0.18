package com.bumptech.glide.p135p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManifestParser.java */
@Deprecated
/* renamed from: com.bumptech.glide.p.e */
/* loaded from: classes.dex */
public final class C1814e {

    /* renamed from: b */
    private static final String f5240b = "ManifestParser";

    /* renamed from: c */
    private static final String f5241c = "GlideModule";

    /* renamed from: a */
    private final Context f5242a;

    public C1814e(Context context) {
        this.f5242a = context;
    }

    /* renamed from: a */
    public List<InterfaceC1812c> m4690a() {
        Log.isLoggable(f5240b, 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f5242a.getPackageManager().getApplicationInfo(this.f5242a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable(f5240b, 3);
                return arrayList;
            }
            if (Log.isLoggable(f5240b, 2)) {
                String str = "Got app info metadata: " + applicationInfo.metaData;
            }
            for (String str2 : applicationInfo.metaData.keySet()) {
                if (f5241c.equals(applicationInfo.metaData.get(str2))) {
                    arrayList.add(m4688a(str2));
                    if (Log.isLoggable(f5240b, 3)) {
                        String str3 = "Loaded Glide module: " + str2;
                    }
                }
            }
            Log.isLoggable(f5240b, 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }

    /* renamed from: a */
    private static InterfaceC1812c m4688a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                m4689a(cls, e2);
            } catch (InstantiationException e3) {
                m4689a(cls, e3);
            } catch (NoSuchMethodException e4) {
                m4689a(cls, e4);
            } catch (InvocationTargetException e5) {
                m4689a(cls, e5);
            }
            if (obj instanceof InterfaceC1812c) {
                return (InterfaceC1812c) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    /* renamed from: a */
    private static void m4689a(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }
}
