package com.umeng.message.proguard;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f7939b;
    public Class<?> a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Class<?> f7940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Class<?> f7941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Class<?> f7942e;

    private a() {
        Application applicationA = x.a();
        String resourcePackageName = PushAgent.getInstance(applicationA).getResourcePackageName();
        resourcePackageName = TextUtils.isEmpty(resourcePackageName) ? applicationA.getPackageName() : resourcePackageName;
        UPLog.d("R2", "resPackageName:", resourcePackageName);
        try {
            this.f7941d = Class.forName(resourcePackageName + ".R$drawable");
        } catch (ClassNotFoundException e2) {
            UPLog.d("R2", UPLog.getStackTrace(e2));
            UMLog.aq(ab.f7943b, 0, "\\|");
        }
        try {
            this.a = Class.forName(resourcePackageName + ".R$layout");
        } catch (ClassNotFoundException e3) {
            UPLog.d("R2", UPLog.getStackTrace(e3));
        }
        try {
            this.f7940c = Class.forName(resourcePackageName + ".R$id");
        } catch (ClassNotFoundException e4) {
            UPLog.d("R2", UPLog.getStackTrace(e4));
        }
        try {
            this.f7942e = Class.forName(resourcePackageName + ".R$raw");
        } catch (ClassNotFoundException e5) {
            UPLog.d("R2", UPLog.getStackTrace(e5));
        }
    }

    public static int a(String str) {
        return a(a().f7940c, str);
    }

    public final int b(String str) {
        return a(this.f7941d, str);
    }

    public final int c(String str) {
        return a(this.f7942e, str);
    }

    public static a a() {
        if (f7939b == null) {
            f7939b = new a();
        }
        return f7939b;
    }

    public static int a(Class<?> cls, String str) {
        if (cls != null) {
            return cls.getField(str).getInt(str);
        }
        UPLog.e("R2", "getRes(null,", str, ")");
        throw new Resources.NotFoundException(x.a().getPackageName() + ".R$* field=" + str + " not exist.");
    }
}
