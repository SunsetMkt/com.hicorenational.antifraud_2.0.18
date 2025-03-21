package com.airbnb.lottie.z;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.p;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final g f3991a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final f f3992b;

    public h(@NonNull g gVar, @NonNull f fVar) {
        this.f3991a = gVar;
        this.f3992b = fVar;
    }

    @Nullable
    @WorkerThread
    private com.airbnb.lottie.g b(@NonNull String str, @Nullable String str2) {
        Pair<c, InputStream> a2;
        if (str2 == null || (a2 = this.f3991a.a(str)) == null) {
            return null;
        }
        c cVar = (c) a2.first;
        InputStream inputStream = (InputStream) a2.second;
        p<com.airbnb.lottie.g> b2 = cVar == c.ZIP ? com.airbnb.lottie.h.b(new ZipInputStream(inputStream), str) : com.airbnb.lottie.h.b(inputStream, str);
        if (b2.b() != null) {
            return b2.b();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    private p<com.airbnb.lottie.g> c(@NonNull String str, @Nullable String str2) {
        com.airbnb.lottie.b0.d.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                d a2 = this.f3992b.a(str);
                if (!a2.isSuccessful()) {
                    p<com.airbnb.lottie.g> pVar = new p<>(new IllegalArgumentException(a2.a()));
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (IOException e2) {
                            com.airbnb.lottie.b0.d.c("LottieFetchResult close failed ", e2);
                        }
                    }
                    return pVar;
                }
                p<com.airbnb.lottie.g> a3 = a(str, a2.b(), a2.contentType(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(a3.b() != null);
                com.airbnb.lottie.b0.d.a(sb.toString());
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (IOException e3) {
                        com.airbnb.lottie.b0.d.c("LottieFetchResult close failed ", e3);
                    }
                }
                return a3;
            } catch (Exception e4) {
                p<com.airbnb.lottie.g> pVar2 = new p<>(e4);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e5) {
                        com.airbnb.lottie.b0.d.c("LottieFetchResult close failed ", e5);
                    }
                }
                return pVar2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e6) {
                    com.airbnb.lottie.b0.d.c("LottieFetchResult close failed ", e6);
                }
            }
            throw th;
        }
    }

    @NonNull
    @WorkerThread
    public p<com.airbnb.lottie.g> a(@NonNull String str, @Nullable String str2) {
        com.airbnb.lottie.g b2 = b(str, str2);
        if (b2 != null) {
            return new p<>(b2);
        }
        com.airbnb.lottie.b0.d.a("Animation for " + str + " not found in cache. Fetching from network.");
        return c(str, str2);
    }

    @NonNull
    private p<com.airbnb.lottie.g> a(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        c cVar;
        p<com.airbnb.lottie.g> b2;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str.split("\\?")[0].endsWith(".lottie")) {
            com.airbnb.lottie.b0.d.a("Received json response.");
            cVar = c.JSON;
            b2 = a(str, inputStream, str3);
        } else {
            com.airbnb.lottie.b0.d.a("Handling zip response.");
            cVar = c.ZIP;
            b2 = b(str, inputStream, str3);
        }
        if (str3 != null && b2.b() != null) {
            this.f3991a.a(str, cVar);
        }
        return b2;
    }

    @NonNull
    private p<com.airbnb.lottie.g> b(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.h.b(new ZipInputStream(inputStream), (String) null);
        }
        return com.airbnb.lottie.h.b(new ZipInputStream(new FileInputStream(this.f3991a.a(str, inputStream, c.ZIP))), str);
    }

    @NonNull
    private p<com.airbnb.lottie.g> a(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.h.b(inputStream, (String) null);
        }
        return com.airbnb.lottie.h.b(new FileInputStream(new File(this.f3991a.a(str, inputStream, c.JSON).getAbsolutePath())), str);
    }
}
