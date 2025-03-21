package com.bumptech.glide.load.p123q;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.InterfaceC1593g;
import com.bumptech.glide.util.C1876j;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* renamed from: com.bumptech.glide.load.q.g */
/* loaded from: classes.dex */
public class C1688g implements InterfaceC1593g {

    /* renamed from: j */
    private static final String f4695j = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c */
    private final InterfaceC1689h f4696c;

    /* renamed from: d */
    @Nullable
    private final URL f4697d;

    /* renamed from: e */
    @Nullable
    private final String f4698e;

    /* renamed from: f */
    @Nullable
    private String f4699f;

    /* renamed from: g */
    @Nullable
    private URL f4700g;

    /* renamed from: h */
    @Nullable
    private volatile byte[] f4701h;

    /* renamed from: i */
    private int f4702i;

    public C1688g(URL url) {
        this(url, InterfaceC1689h.f4704b);
    }

    /* renamed from: e */
    private byte[] m4230e() {
        if (this.f4701h == null) {
            this.f4701h = m4233a().getBytes(InterfaceC1593g.f4191b);
        }
        return this.f4701h;
    }

    /* renamed from: f */
    private String m4231f() {
        if (TextUtils.isEmpty(this.f4699f)) {
            String str = this.f4698e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) C1876j.m4985a(this.f4697d)).toString();
            }
            this.f4699f = Uri.encode(str, f4695j);
        }
        return this.f4699f;
    }

    /* renamed from: g */
    private URL m4232g() throws MalformedURLException {
        if (this.f4700g == null) {
            this.f4700g = new URL(m4231f());
        }
        return this.f4700g;
    }

    /* renamed from: a */
    public String m4233a() {
        String str = this.f4698e;
        return str != null ? str : ((URL) C1876j.m4985a(this.f4697d)).toString();
    }

    /* renamed from: b */
    public Map<String, String> m4234b() {
        return this.f4696c.mo4237a();
    }

    /* renamed from: c */
    public String m4235c() {
        return m4231f();
    }

    /* renamed from: d */
    public URL m4236d() throws MalformedURLException {
        return m4232g();
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public boolean equals(Object obj) {
        if (!(obj instanceof C1688g)) {
            return false;
        }
        C1688g c1688g = (C1688g) obj;
        return m4233a().equals(c1688g.m4233a()) && this.f4696c.equals(c1688g.f4696c);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    public int hashCode() {
        if (this.f4702i == 0) {
            this.f4702i = m4233a().hashCode();
            this.f4702i = (this.f4702i * 31) + this.f4696c.hashCode();
        }
        return this.f4702i;
    }

    public String toString() {
        return m4233a();
    }

    public C1688g(String str) {
        this(str, InterfaceC1689h.f4704b);
    }

    @Override // com.bumptech.glide.load.InterfaceC1593g
    /* renamed from: a */
    public void mo3827a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(m4230e());
    }

    public C1688g(URL url, InterfaceC1689h interfaceC1689h) {
        this.f4697d = (URL) C1876j.m4985a(url);
        this.f4698e = null;
        this.f4696c = (InterfaceC1689h) C1876j.m4985a(interfaceC1689h);
    }

    public C1688g(String str, InterfaceC1689h interfaceC1689h) {
        this.f4697d = null;
        this.f4698e = C1876j.m4987a(str);
        this.f4696c = (InterfaceC1689h) C1876j.m4985a(interfaceC1689h);
    }
}
