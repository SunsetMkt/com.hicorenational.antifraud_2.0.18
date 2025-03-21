package com.bumptech.glide.load.p116o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.C1591e;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import com.bumptech.glide.load.p123q.C1688g;
import com.bumptech.glide.util.C1868b;
import com.bumptech.glide.util.C1872f;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* renamed from: com.bumptech.glide.load.o.j */
/* loaded from: classes.dex */
public class C1610j implements InterfaceC1604d<InputStream> {

    /* renamed from: g */
    private static final String f4217g = "HttpUrlFetcher";

    /* renamed from: h */
    private static final int f4218h = 5;

    /* renamed from: i */
    @VisibleForTesting
    static final b f4219i = new a();

    /* renamed from: j */
    private static final int f4220j = -1;

    /* renamed from: a */
    private final C1688g f4221a;

    /* renamed from: b */
    private final int f4222b;

    /* renamed from: c */
    private final b f4223c;

    /* renamed from: d */
    private HttpURLConnection f4224d;

    /* renamed from: e */
    private InputStream f4225e;

    /* renamed from: f */
    private volatile boolean f4226f;

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: com.bumptech.glide.load.o.j$a */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.p116o.C1610j.b
        /* renamed from: a */
        public HttpURLConnection mo3868a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: com.bumptech.glide.load.o.j$b */
    interface b {
        /* renamed from: a */
        HttpURLConnection mo3868a(URL url) throws IOException;
    }

    public C1610j(C1688g c1688g, int i2) {
        this(c1688g, i2, f4219i);
    }

    /* renamed from: b */
    private static boolean m3867b(int i2) {
        return i2 / 100 == 3;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: a */
    public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long m4970a = C1872f.m4970a();
        try {
            try {
                aVar.mo3857a((InterfaceC1604d.a<? super InputStream>) m3865a(this.f4221a.m4236d(), 0, null, this.f4221a.m4234b()));
            } catch (IOException e2) {
                Log.isLoggable(f4217g, 3);
                aVar.mo3856a((Exception) e2);
                if (!Log.isLoggable(f4217g, 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable(f4217g, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(C1872f.m4969a(m4970a));
                sb.toString();
            }
        } catch (Throwable th) {
            if (Log.isLoggable(f4217g, 2)) {
                String str = "Finished http url fetcher fetch in " + C1872f.m4969a(m4970a);
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    @NonNull
    /* renamed from: c */
    public EnumC1587a mo3852c() {
        return EnumC1587a.REMOTE;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    public void cancel() {
        this.f4226f = true;
    }

    @VisibleForTesting
    C1610j(C1688g c1688g, int i2, b bVar) {
        this.f4221a = c1688g;
        this.f4222b = i2;
        this.f4223c = bVar;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: b */
    public void mo3851b() {
        InputStream inputStream = this.f4225e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f4224d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f4224d = null;
    }

    /* renamed from: a */
    private InputStream m3865a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new C1591e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f4224d = this.f4223c.mo3868a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f4224d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f4224d.setConnectTimeout(this.f4222b);
            this.f4224d.setReadTimeout(this.f4222b);
            this.f4224d.setUseCaches(false);
            this.f4224d.setDoInput(true);
            this.f4224d.setInstanceFollowRedirects(false);
            this.f4224d.connect();
            this.f4225e = this.f4224d.getInputStream();
            if (this.f4226f) {
                return null;
            }
            int responseCode = this.f4224d.getResponseCode();
            if (m3866a(responseCode)) {
                return m3864a(this.f4224d);
            }
            if (!m3867b(responseCode)) {
                if (responseCode == -1) {
                    throw new C1591e(responseCode);
                }
                throw new C1591e(this.f4224d.getResponseMessage(), responseCode);
            }
            String headerField = this.f4224d.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                mo3851b();
                return m3865a(url3, i2 + 1, url, map);
            }
            throw new C1591e("Received empty or null redirect url");
        }
        throw new C1591e("Too many (> 5) redirects!");
    }

    /* renamed from: a */
    private static boolean m3866a(int i2) {
        return i2 / 100 == 2;
    }

    /* renamed from: a */
    private InputStream m3864a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f4225e = C1868b.m4959a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(f4217g, 3)) {
                String str = "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
            }
            this.f4225e = httpURLConnection.getInputStream();
        }
        return this.f4225e;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo3846a() {
        return InputStream.class;
    }
}
