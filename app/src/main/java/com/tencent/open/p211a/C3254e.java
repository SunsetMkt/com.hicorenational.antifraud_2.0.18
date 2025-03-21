package com.tencent.open.p211a;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Version;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.e */
/* loaded from: classes2.dex */
class C3254e implements InterfaceC3250a {

    /* renamed from: a */
    private OkHttpClient f11152a;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.a.e$a */
    private static class a implements Interceptor {

        /* renamed from: a */
        private final String f11153a;

        public a(String str) {
            this.f11153a = str;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header(HttpHeaders.USER_AGENT, this.f11153a).build());
        }
    }

    public C3254e(String str) throws NoClassDefFoundError {
        m10414a(str);
    }

    /* renamed from: a */
    private void m10414a(String str) {
        String userAgent = Version.userAgent();
        if (userAgent == null || !userAgent.startsWith("okhttp/3")) {
            throw new NoClassDefFoundError();
        }
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS)).connectTimeout(15000L, TimeUnit.MILLISECONDS).readTimeout(30000L, TimeUnit.MILLISECONDS).writeTimeout(30000L, TimeUnit.MILLISECONDS).cache(null).addInterceptor(new a(str));
        m10415a(addInterceptor);
        this.f11152a = addInterceptor.build();
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public void mo10403a(long j2, long j3) {
        if (j2 <= 0 || j3 <= 0) {
            return;
        }
        if (this.f11152a.connectTimeoutMillis() == j2 && this.f11152a.readTimeoutMillis() == j3) {
            return;
        }
        SLog.m10502i("OkHttpServiceImpl", "setTimeout changed.");
        this.f11152a = this.f11152a.newBuilder().connectTimeout(j2, TimeUnit.MILLISECONDS).readTimeout(j3, TimeUnit.MILLISECONDS).writeTimeout(j3, TimeUnit.MILLISECONDS).build();
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public InterfaceC3256g mo10400a(String str, String str2) throws IOException {
        SLog.m10502i("OkHttpServiceImpl", "get.");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return new C3253d(this.f11152a.newCall(new Request.Builder().url(str).get().build()).execute(), str2.length());
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public InterfaceC3256g mo10401a(String str, Map<String, String> map) throws IOException {
        SLog.m10502i("OkHttpServiceImpl", "post data");
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str3 != null) {
                    builder.add(str2, str3);
                }
            }
        }
        FormBody build = builder.build();
        return new C3253d(this.f11152a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
    }

    @Override // com.tencent.open.p211a.InterfaceC3250a
    /* renamed from: a */
    public InterfaceC3256g mo10402a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() != 0) {
            SLog.m10502i("OkHttpServiceImpl", "post data, has byte data");
            MultipartBody.Builder builder = new MultipartBody.Builder();
            if (map != null && map.size() > 0) {
                for (String str2 : map.keySet()) {
                    String str3 = map.get(str2);
                    if (str3 != null) {
                        builder.addFormDataPart(str2, str3);
                    }
                }
            }
            for (String str4 : map2.keySet()) {
                byte[] bArr = map2.get(str4);
                if (bArr != null && bArr.length > 0) {
                    builder.addFormDataPart(str4, str4, RequestBody.create(MediaType.get("content/unknown"), bArr));
                    SLog.m10508w("OkHttpServiceImpl", "post byte data.");
                }
            }
            MultipartBody build = builder.build();
            return new C3253d(this.f11152a.newCall(new Request.Builder().url(str).post(build).build()).execute(), (int) build.contentLength());
        }
        return mo10401a(str, map);
    }

    /* renamed from: a */
    private void m10415a(OkHttpClient.Builder builder) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16 || i2 >= 21) {
            return;
        }
        try {
            C3257h c3257h = new C3257h();
            TrustManager m10427a = c3257h.m10427a();
            if (m10427a == null) {
                return;
            }
            builder.sslSocketFactory(c3257h, (X509TrustManager) m10427a);
            SLog.m10502i("OkHttpServiceImpl", "enableTls2: enabled.");
        } catch (KeyManagementException e2) {
            SLog.m10501e("OkHttpServiceImpl", "enableTls2: failed.", e2);
        } catch (KeyStoreException e3) {
            SLog.m10501e("OkHttpServiceImpl", "enableTls2: failed.", e3);
        } catch (NoSuchAlgorithmException e4) {
            SLog.m10501e("OkHttpServiceImpl", "enableTls2: failed.", e4);
        }
    }
}
