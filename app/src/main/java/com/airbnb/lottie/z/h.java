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

/* JADX INFO: compiled from: NetworkFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    @NonNull
    private final g a;

    /* JADX INFO: renamed from: b */
    @NonNull
    private final f f2541b;

    public h(@NonNull g gVar, @NonNull f fVar) {
        this.a = gVar;
        this.f2541b = fVar;
    }

    @Nullable
    @WorkerThread
    private com.airbnb.lottie.g b(@NonNull String str, @Nullable String str2) {
        Pair<c, InputStream> pairA;
        if (str2 == null || (pairA = this.a.a(str)) == null) {
            return null;
        }
        c cVar = (c) pairA.first;
        InputStream inputStream = (InputStream) pairA.second;
        p<com.airbnb.lottie.g> pVarB = cVar == c.ZIP ? com.airbnb.lottie.h.b(new ZipInputStream(inputStream), str) : com.airbnb.lottie.h.b(inputStream, str);
        if (pVarB.b() != null) {
            return pVarB.b();
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
                d dVarA = this.f2541b.a(str);
                if (!dVarA.isSuccessful()) {
                    p<com.airbnb.lottie.g> pVar = new p<>(new IllegalArgumentException(dVarA.a()));
                    if (dVarA != null) {
                        try {
                            dVarA.close();
                        } catch (IOException e2) {
                            com.airbnb.lottie.b0.d.c("LottieFetchResult close failed ", e2);
                        }
                    }
                    return pVar;
                }
                p<com.airbnb.lottie.g> pVarA = a(str, dVarA.b(), dVarA.contentType(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(pVarA.b() != null);
                com.airbnb.lottie.b0.d.a(sb.toString());
                if (dVarA != null) {
                    try {
                        dVarA.close();
                    } catch (IOException e3) {
                        com.airbnb.lottie.b0.d.c("LottieFetchResult close failed ", e3);
                    }
                }
                return pVarA;
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
        com.airbnb.lottie.g gVarB = b(str, str2);
        if (gVarB != null) {
            return new p<>(gVarB);
        }
        com.airbnb.lottie.b0.d.a("Animation for " + str + " not found in cache. Fetching from network.");
        return c(str, str2);
    }

    @NonNull
    private p<com.airbnb.lottie.g> a(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        c cVar;
        p<com.airbnb.lottie.g> pVarB;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str.split("\\?")[0].endsWith(".lottie")) {
            com.airbnb.lottie.b0.d.a("Received json response.");
            cVar = c.JSON;
            pVarB = a(str, inputStream, str3);
        } else {
            com.airbnb.lottie.b0.d.a("Handling zip response.");
            cVar = c.ZIP;
            pVarB = b(str, inputStream, str3);
        }
        if (str3 != null && pVarB.b() != null) {
            this.a.a(str, cVar);
        }
        return pVarB;
    }

    @NonNull
    private p<com.airbnb.lottie.g> b(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.h.b(new ZipInputStream(inputStream), (String) null);
        }
        return com.airbnb.lottie.h.b(new ZipInputStream(new FileInputStream(this.a.a(str, inputStream, c.ZIP))), str);
    }

    @NonNull
    private p<com.airbnb.lottie.g> a(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return com.airbnb.lottie.h.b(inputStream, (String) null);
        }
        return com.airbnb.lottie.h.b(new FileInputStream(new File(this.a.a(str, inputStream, c.JSON).getAbsolutePath())), str);
    }
}
