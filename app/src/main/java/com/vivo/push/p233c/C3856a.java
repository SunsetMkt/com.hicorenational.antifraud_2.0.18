package com.vivo.push.p233c;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.C4010u;
import java.util.HashMap;

/* compiled from: CoreConfigManager.java */
/* renamed from: com.vivo.push.c.a */
/* loaded from: classes2.dex */
public final class C3856a {

    /* renamed from: a */
    private Context f13963a;

    /* renamed from: b */
    private HashMap<String, String> f13964b = new HashMap<>();

    public C3856a(Context context) {
        this.f13963a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m12890e() {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.p233c.C3856a.m12890e():int");
    }

    /* renamed from: a */
    public final int m12891a() {
        int m12888a = m12888a(1);
        C4010u.m13309d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(m12888a)));
        return m12888a;
    }

    /* renamed from: b */
    public final int m12892b() {
        int m12888a = m12888a(4);
        C4010u.m13309d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(m12888a)));
        return m12888a;
    }

    /* renamed from: c */
    public final boolean m12893c() {
        int m12888a = m12888a(8);
        C4010u.m13309d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(m12888a)));
        return m12888a == 0;
    }

    /* renamed from: d */
    public final boolean m12894d() {
        int m12888a = m12888a(16);
        C4010u.m13309d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(m12888a)));
        return m12888a == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b2 A[Catch: Exception -> 0x008d, TRY_ENTER, TryCatch #0 {Exception -> 0x008d, blocks: (B:33:0x0089, B:35:0x0091, B:37:0x0095, B:43:0x00b2, B:45:0x00b7, B:47:0x00bb), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b7 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:33:0x0089, B:35:0x0091, B:37:0x0095, B:43:0x00b2, B:45:0x00b7, B:47:0x00bb), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cb A[Catch: Exception -> 0x00c7, TryCatch #5 {Exception -> 0x00c7, blocks: (B:62:0x00c3, B:53:0x00cb, B:55:0x00cf), top: B:61:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m12889a(android.content.Context r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.p233c.C3856a.m12889a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private int m12888a(int i2) {
        int m12890e = m12890e();
        if (m12890e != 0) {
            return m12890e;
        }
        HashMap<String, String> hashMap = this.f13964b;
        if (hashMap == null || hashMap.size() == 0) {
            return 8006;
        }
        String str = this.f13964b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i2 & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return 8007;
        }
    }
}
