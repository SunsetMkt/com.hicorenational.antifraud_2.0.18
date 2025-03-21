package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.lang.reflect.Method;

/* renamed from: com.xiaomi.push.al */
/* loaded from: classes2.dex */
class C4083al implements InterfaceC4080ai {

    /* renamed from: a */
    private Context f14532a;

    /* renamed from: a */
    private Class<?> f14533a;

    /* renamed from: a */
    private Object f14534a;

    /* renamed from: a */
    private Method f14535a = null;

    /* renamed from: b */
    private Method f14536b = null;

    /* renamed from: c */
    private Method f14537c = null;

    /* renamed from: d */
    private Method f14538d = null;

    public C4083al(Context context) {
        this.f14532a = context;
        m13753a(context);
    }

    /* renamed from: a */
    private void m13753a(Context context) {
        try {
            this.f14533a = C4309r.m15716a(context, "com.android.id.impl.IdProviderImpl");
            this.f14534a = this.f14533a.newInstance();
            this.f14536b = this.f14533a.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            AbstractC4022b.m13349a("miui load class error", e2);
        }
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public boolean mo13737a() {
        return (this.f14533a == null || this.f14534a == null) ? false : true;
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public String mo13736a() {
        return m13752a(this.f14532a, this.f14536b);
    }

    /* renamed from: a */
    private String m13752a(Context context, Method method) {
        Object obj = this.f14534a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            AbstractC4022b.m13349a("miui invoke error", e2);
            return null;
        }
    }
}
