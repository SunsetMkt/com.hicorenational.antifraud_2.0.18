package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.vivo.push.p231a.C3825a;
import com.vivo.push.p232b.C3842n;
import com.vivo.push.p238g.C3918a;

/* compiled from: LogController.java */
/* renamed from: com.vivo.push.util.s */
/* loaded from: classes2.dex */
public final class C4008s implements InterfaceC4009t {

    /* renamed from: a */
    private static final String f14277a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: a */
    public final int mo13280a(String str, String str2) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f14277a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: b */
    public final int mo13285b(String str, String str2) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(str)), f14277a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: c */
    public final int mo13288c(String str, String str2) {
        return Log.d("VivoPush.Client.".concat(String.valueOf(str)), f14277a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: d */
    public final int mo13290d(String str, String str2) {
        if (!C4010u.m13300a()) {
            return -1;
        }
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f14277a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: e */
    public final int mo13291e(String str, String str2) {
        if (!C4010u.m13300a()) {
            return -1;
        }
        return Log.v("VivoPush.Client.".concat(String.valueOf(str)), f14277a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: a */
    public final int mo13282a(String str, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: b */
    public final int mo13286b(String str, String str2, Throwable th) {
        if (!C4010u.m13300a()) {
            return -1;
        }
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f14277a + str2, th);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: c */
    public final void mo13289c(Context context, String str) {
        if (m13279a()) {
            m13278a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: b */
    public final void mo13287b(Context context, String str) {
        if (m13279a()) {
            m13278a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: a */
    public final int mo13281a(String str, String str2, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f14277a + str2, th);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: a */
    public final String mo13283a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    @Override // com.vivo.push.util.InterfaceC4009t
    /* renamed from: a */
    public final void mo13284a(Context context, String str) {
        if (m13279a()) {
            m13278a(context, str, 0);
        }
    }

    /* renamed from: a */
    private void m13278a(Context context, String str, int i2) {
        C3842n c3842n = new C3842n();
        c3842n.m12854b(str);
        c3842n.m12853a(i2);
        if (i2 > 0) {
            mo13290d("LogController", str);
        }
        c3842n.m12858g();
        C3825a.m12827a(context, c3842n, context.getPackageName());
    }

    /* renamed from: a */
    private static boolean m13279a() {
        C4010u.m13300a();
        return C3918a.m12991a().m12992b();
    }
}
