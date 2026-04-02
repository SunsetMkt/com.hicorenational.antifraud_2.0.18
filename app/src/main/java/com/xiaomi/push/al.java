package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
class al implements ai {
    private Context a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class<?> f179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f181a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Method f8745b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Method f8746c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f8747d = null;

    public al(Context context) {
        this.a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            this.f179a = r.a(context, "com.android.id.impl.IdProviderImpl");
            this.f180a = this.f179a.newInstance();
            this.f8745b = this.f179a.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e2);
        }
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public boolean mo135a() {
        return (this.f179a == null || this.f180a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public String mo134a() {
        return a(this.a, this.f8745b);
    }

    private String a(Context context, Method method) {
        Object obj = this.f180a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e2);
            return null;
        }
    }
}
