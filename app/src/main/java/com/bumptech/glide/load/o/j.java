package com.bumptech.glide.load.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.o.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: HttpUrlFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements d<InputStream> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f2734g = "HttpUrlFetcher";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f2735h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    static final b f2736i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f2737j = -1;
    private final com.bumptech.glide.load.q.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f2739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpURLConnection f2740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InputStream f2741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f2742f;

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.o.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(com.bumptech.glide.load.q.g gVar, int i2) {
        this(gVar, i2, f2736i);
    }

    private static boolean b(int i2) {
        return i2 / 100 == 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.o.d
    public void a(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb;
        String str = f2734g;
        long jA = com.bumptech.glide.util.f.a();
        try {
            try {
                aVar.a(a(this.a.d(), 0, null, this.a.b()));
                str = str;
            } catch (IOException e2) {
                Log.isLoggable(f2734g, 3);
                aVar.a((Exception) e2);
                str = str;
                if (Log.isLoggable(f2734g, 2)) {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable(f2734g, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                double dA = com.bumptech.glide.util.f.a(jA);
                sb.append(dA);
                sb.toString();
                str = dA;
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str, 2)) {
                String str2 = "Finished http url fetcher fetch in " + com.bumptech.glide.util.f.a(jA);
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public com.bumptech.glide.load.a c() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.o.d
    public void cancel() {
        this.f2742f = true;
    }

    @VisibleForTesting
    j(com.bumptech.glide.load.q.g gVar, int i2, b bVar) {
        this.a = gVar;
        this.f2738b = i2;
        this.f2739c = bVar;
    }

    @Override // com.bumptech.glide.load.o.d
    public void b() {
        InputStream inputStream = this.f2741e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f2740d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f2740d = null;
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new com.bumptech.glide.load.e("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f2740d = this.f2739c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f2740d.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f2740d.setConnectTimeout(this.f2738b);
            this.f2740d.setReadTimeout(this.f2738b);
            this.f2740d.setUseCaches(false);
            this.f2740d.setDoInput(true);
            this.f2740d.setInstanceFollowRedirects(false);
            this.f2740d.connect();
            this.f2741e = this.f2740d.getInputStream();
            if (this.f2742f) {
                return null;
            }
            int responseCode = this.f2740d.getResponseCode();
            if (a(responseCode)) {
                return a(this.f2740d);
            }
            if (!b(responseCode)) {
                if (responseCode == -1) {
                    throw new com.bumptech.glide.load.e(responseCode);
                }
                throw new com.bumptech.glide.load.e(this.f2740d.getResponseMessage(), responseCode);
            }
            String headerField = this.f2740d.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                b();
                return a(url3, i2 + 1, url, map);
            }
            throw new com.bumptech.glide.load.e("Received empty or null redirect url");
        }
        throw new com.bumptech.glide.load.e("Too many (> 5) redirects!");
    }

    private static boolean a(int i2) {
        return i2 / 100 == 2;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f2741e = com.bumptech.glide.util.b.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(f2734g, 3)) {
                String str = "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
            }
            this.f2741e = httpURLConnection.getInputStream();
        }
        return this.f2741e;
    }

    @Override // com.bumptech.glide.load.o.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
