package com.airbnb.lottie.p110z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.p100b0.C1354d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* compiled from: DefaultLottieFetchResult.java */
/* renamed from: com.airbnb.lottie.z.a */
/* loaded from: classes.dex */
public class C1486a implements InterfaceC1489d {

    /* renamed from: a */
    @NonNull
    private final HttpURLConnection f3829a;

    public C1486a(@NonNull HttpURLConnection httpURLConnection) {
        this.f3829a = httpURLConnection;
    }

    @Override // com.airbnb.lottie.p110z.InterfaceC1489d
    @Nullable
    /* renamed from: a */
    public String mo3397a() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f3829a.getURL() + ". Failed with " + this.f3829a.getResponseCode() + "\n" + m3396a(this.f3829a);
        } catch (IOException e2) {
            C1354d.m2793c("get error failed ", e2);
            return e2.getMessage();
        }
    }

    @Override // com.airbnb.lottie.p110z.InterfaceC1489d
    @NonNull
    /* renamed from: b */
    public InputStream mo3398b() throws IOException {
        return this.f3829a.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3829a.disconnect();
    }

    @Override // com.airbnb.lottie.p110z.InterfaceC1489d
    @Nullable
    public String contentType() {
        return this.f3829a.getContentType();
    }

    @Override // com.airbnb.lottie.p110z.InterfaceC1489d
    public boolean isSuccessful() {
        try {
            return this.f3829a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private String m3396a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
