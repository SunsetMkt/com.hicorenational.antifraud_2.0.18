package com.bumptech.glide.load.q;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: GlideUrl.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f3067j = "@#&=*+-_.,:!?()/~'%;$";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f3068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final URL f3069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f3070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f3071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private URL f3072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private volatile byte[] f3073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f3074i;

    public g(URL url) {
        this(url, h.f3075b);
    }

    private byte[] e() {
        if (this.f3073h == null) {
            this.f3073h = a().getBytes(com.bumptech.glide.load.g.f2715b);
        }
        return this.f3073h;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f3071f)) {
            String string = this.f3070e;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) com.bumptech.glide.util.j.a(this.f3069d)).toString();
            }
            this.f3071f = Uri.encode(string, f3067j);
        }
        return this.f3071f;
    }

    private URL g() throws MalformedURLException {
        if (this.f3072g == null) {
            this.f3072g = new URL(f());
        }
        return this.f3072g;
    }

    public String a() {
        String str = this.f3070e;
        return str != null ? str : ((URL) com.bumptech.glide.util.j.a(this.f3069d)).toString();
    }

    public Map<String, String> b() {
        return this.f3068c.a();
    }

    public String c() {
        return f();
    }

    public URL d() throws MalformedURLException {
        return g();
    }

    @Override // com.bumptech.glide.load.g
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a().equals(gVar.a()) && this.f3068c.equals(gVar.f3068c);
    }

    @Override // com.bumptech.glide.load.g
    public int hashCode() {
        if (this.f3074i == 0) {
            this.f3074i = a().hashCode();
            this.f3074i = (this.f3074i * 31) + this.f3068c.hashCode();
        }
        return this.f3074i;
    }

    public String toString() {
        return a();
    }

    public g(String str) {
        this(str, h.f3075b);
    }

    @Override // com.bumptech.glide.load.g
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(e());
    }

    public g(URL url, h hVar) {
        this.f3069d = (URL) com.bumptech.glide.util.j.a(url);
        this.f3070e = null;
        this.f3068c = (h) com.bumptech.glide.util.j.a(hVar);
    }

    public g(String str, h hVar) {
        this.f3069d = null;
        this.f3070e = com.bumptech.glide.util.j.a(str);
        this.f3068c = (h) com.bumptech.glide.util.j.a(hVar);
    }
}
