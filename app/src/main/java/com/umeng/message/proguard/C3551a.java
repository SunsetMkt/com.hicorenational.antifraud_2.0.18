package com.umeng.message.proguard;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;

/* renamed from: com.umeng.message.proguard.a */
/* loaded from: classes2.dex */
public final class C3551a {

    /* renamed from: b */
    private static C3551a f13143b;

    /* renamed from: a */
    public Class<?> f13144a;

    /* renamed from: c */
    private Class<?> f13145c;

    /* renamed from: d */
    private Class<?> f13146d;

    /* renamed from: e */
    private Class<?> f13147e;

    private C3551a() {
        Application m12460a = C3604x.m12460a();
        String resourcePackageName = PushAgent.getInstance(m12460a).getResourcePackageName();
        resourcePackageName = TextUtils.isEmpty(resourcePackageName) ? m12460a.getPackageName() : resourcePackageName;
        UPLog.m12142d("R2", "resPackageName:", resourcePackageName);
        try {
            this.f13146d = Class.forName(resourcePackageName + ".R$drawable");
        } catch (ClassNotFoundException e2) {
            UPLog.m12142d("R2", UPLog.getStackTrace(e2));
            UMLog.m11549aq(C3553ab.f13149b, 0, "\\|");
        }
        try {
            this.f13144a = Class.forName(resourcePackageName + ".R$layout");
        } catch (ClassNotFoundException e3) {
            UPLog.m12142d("R2", UPLog.getStackTrace(e3));
        }
        try {
            this.f13145c = Class.forName(resourcePackageName + ".R$id");
        } catch (ClassNotFoundException e4) {
            UPLog.m12142d("R2", UPLog.getStackTrace(e4));
        }
        try {
            this.f13147e = Class.forName(resourcePackageName + ".R$raw");
        } catch (ClassNotFoundException e5) {
            UPLog.m12142d("R2", UPLog.getStackTrace(e5));
        }
    }

    /* renamed from: a */
    public static int m12218a(String str) {
        return m12217a(m12219a().f13145c, str);
    }

    /* renamed from: b */
    public final int m12220b(String str) {
        return m12217a(this.f13146d, str);
    }

    /* renamed from: c */
    public final int m12221c(String str) {
        return m12217a(this.f13147e, str);
    }

    /* renamed from: a */
    public static C3551a m12219a() {
        if (f13143b == null) {
            f13143b = new C3551a();
        }
        return f13143b;
    }

    /* renamed from: a */
    public static int m12217a(Class<?> cls, String str) {
        if (cls != null) {
            return cls.getField(str).getInt(str);
        }
        UPLog.m12144e("R2", "getRes(null,", str, ")");
        throw new Resources.NotFoundException(C3604x.m12460a().getPackageName() + ".R$* field=" + str + " not exist.");
    }
}
