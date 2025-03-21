package com.vivo.push;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: BundleWapper.java */
/* renamed from: com.vivo.push.d */
/* loaded from: classes2.dex */
public final class C3862d {

    /* renamed from: a */
    private Bundle f13972a;

    /* renamed from: b */
    private String f13973b;

    /* renamed from: c */
    private String f13974c;

    public C3862d(String str, String str2, Bundle bundle) {
        this.f13973b = str;
        this.f13974c = str2;
        this.f13972a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.push.C3862d m12911a(android.content.Intent r6) {
        /*
            java.lang.String r0 = "BundleWapper"
            r1 = 0
            if (r6 != 0) goto Lb
            java.lang.String r6 = "create error : intent is null"
            com.vivo.push.util.C4010u.m13292a(r0, r6)
            return r1
        Lb:
            android.os.Bundle r2 = r6.getExtras()
            if (r2 == 0) goto L1e
            java.lang.String r3 = "client_pkgname"
            java.lang.String r3 = r2.getString(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L1e
            goto L1f
        L1e:
            r3 = r1
        L1f:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L2a
            java.lang.String r4 = "create warning: pkgName is null"
            com.vivo.push.util.C4010u.m13301b(r0, r4)
        L2a:
            java.lang.String r4 = r6.getPackage()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L4f
            android.content.ComponentName r4 = r6.getComponent()
            if (r4 != 0) goto L3b
            goto L43
        L3b:
            android.content.ComponentName r6 = r6.getComponent()
            java.lang.String r1 = r6.getPackageName()
        L43:
            r4 = r1
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L4f
            java.lang.String r6 = "create warning: targetPkgName is null"
            com.vivo.push.util.C4010u.m13301b(r0, r6)
        L4f:
            com.vivo.push.d r6 = new com.vivo.push.d
            r6.<init>(r3, r4, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.C3862d.m12911a(android.content.Intent):com.vivo.push.d");
    }

    /* renamed from: b */
    public final int m12921b(String str, int i2) {
        Bundle bundle = this.f13972a;
        return bundle == null ? i2 : bundle.getInt(str, i2);
    }

    /* renamed from: c */
    public final ArrayList<String> m12925c(String str) {
        Bundle bundle = this.f13972a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    /* renamed from: d */
    public final Serializable m12926d(String str) {
        Bundle bundle = this.f13972a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    /* renamed from: e */
    public final boolean m12927e(String str) {
        Bundle bundle = this.f13972a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    /* renamed from: b */
    public final byte[] m12924b(String str) {
        Bundle bundle = this.f13972a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    /* renamed from: b */
    public final long m12922b(String str, long j2) {
        Bundle bundle = this.f13972a;
        return bundle == null ? j2 : bundle.getLong(str, j2);
    }

    /* renamed from: b */
    public final Bundle m12923b() {
        return this.f13972a;
    }

    /* renamed from: a */
    public final void m12914a(String str, int i2) {
        if (this.f13972a == null) {
            this.f13972a = new Bundle();
        }
        this.f13972a.putInt(str, i2);
    }

    /* renamed from: a */
    public final void m12915a(String str, long j2) {
        if (this.f13972a == null) {
            this.f13972a = new Bundle();
        }
        this.f13972a.putLong(str, j2);
    }

    /* renamed from: a */
    public final void m12917a(String str, String str2) {
        if (this.f13972a == null) {
            this.f13972a = new Bundle();
        }
        this.f13972a.putString(str, str2);
    }

    /* renamed from: a */
    public final void m12920a(String str, byte[] bArr) {
        if (this.f13972a == null) {
            this.f13972a = new Bundle();
        }
        this.f13972a.putByteArray(str, bArr);
    }

    /* renamed from: a */
    public final void m12916a(String str, Serializable serializable) {
        if (this.f13972a == null) {
            this.f13972a = new Bundle();
        }
        this.f13972a.putSerializable(str, serializable);
    }

    /* renamed from: a */
    public final void m12919a(String str, boolean z) {
        if (this.f13972a == null) {
            this.f13972a = new Bundle();
        }
        this.f13972a.putBoolean(str, z);
    }

    /* renamed from: a */
    public final void m12918a(String str, ArrayList<String> arrayList) {
        if (this.f13972a == null) {
            this.f13972a = new Bundle();
        }
        this.f13972a.putStringArrayList(str, arrayList);
    }

    /* renamed from: a */
    public final String m12913a(String str) {
        Bundle bundle = this.f13972a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    /* renamed from: a */
    public final String m12912a() {
        return this.f13973b;
    }
}
