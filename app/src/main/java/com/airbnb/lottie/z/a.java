package com.airbnb.lottie.z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: DefaultLottieFetchResult.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    @NonNull
    private final HttpURLConnection a;

    public a(@NonNull HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    @Override // com.airbnb.lottie.z.d
    @Nullable
    public String a() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.a.getURL() + ". Failed with " + this.a.getResponseCode() + "\n" + a(this.a);
        } catch (IOException e2) {
            com.airbnb.lottie.b0.d.c("get error failed ", e2);
            return e2.getMessage();
        }
    }

    @Override // com.airbnb.lottie.z.d
    @NonNull
    public InputStream b() throws IOException {
        return this.a.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.disconnect();
    }

    @Override // com.airbnb.lottie.z.d
    @Nullable
    public String contentType() {
        return this.a.getContentType();
    }

    @Override // com.airbnb.lottie.z.d
    public boolean isSuccessful() {
        try {
            return this.a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    private String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
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
