package com.airbnb.lottie.p110z;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.C1377h;
import com.airbnb.lottie.C1385p;
import com.airbnb.lottie.p100b0.C1354d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
/* renamed from: com.airbnb.lottie.z.h */
/* loaded from: classes.dex */
public class C1493h {

    /* renamed from: a */
    @NonNull
    private final C1492g f3832a;

    /* renamed from: b */
    @NonNull
    private final InterfaceC1491f f3833b;

    public C1493h(@NonNull C1492g c1492g, @NonNull InterfaceC1491f interfaceC1491f) {
        this.f3832a = c1492g;
        this.f3833b = interfaceC1491f;
    }

    @Nullable
    @WorkerThread
    /* renamed from: b */
    private C1376g m3409b(@NonNull String str, @Nullable String str2) {
        Pair<EnumC1488c, InputStream> m3403a;
        if (str2 == null || (m3403a = this.f3832a.m3403a(str)) == null) {
            return null;
        }
        EnumC1488c enumC1488c = (EnumC1488c) m3403a.first;
        InputStream inputStream = (InputStream) m3403a.second;
        C1385p<C1376g> m2949b = enumC1488c == EnumC1488c.ZIP ? C1377h.m2949b(new ZipInputStream(inputStream), str) : C1377h.m2947b(inputStream, str);
        if (m2949b.m3061b() != null) {
            return m2949b.m3061b();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    /* renamed from: c */
    private C1385p<C1376g> m3411c(@NonNull String str, @Nullable String str2) {
        C1354d.m2789a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                InterfaceC1489d mo3399a = this.f3833b.mo3399a(str);
                if (!mo3399a.isSuccessful()) {
                    C1385p<C1376g> c1385p = new C1385p<>(new IllegalArgumentException(mo3399a.mo3397a()));
                    if (mo3399a != null) {
                        try {
                            mo3399a.close();
                        } catch (IOException e2) {
                            C1354d.m2793c("LottieFetchResult close failed ", e2);
                        }
                    }
                    return c1385p;
                }
                C1385p<C1376g> m3408a = m3408a(str, mo3399a.mo3398b(), mo3399a.contentType(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(m3408a.m3061b() != null);
                C1354d.m2789a(sb.toString());
                if (mo3399a != null) {
                    try {
                        mo3399a.close();
                    } catch (IOException e3) {
                        C1354d.m2793c("LottieFetchResult close failed ", e3);
                    }
                }
                return m3408a;
            } catch (Exception e4) {
                C1385p<C1376g> c1385p2 = new C1385p<>(e4);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e5) {
                        C1354d.m2793c("LottieFetchResult close failed ", e5);
                    }
                }
                return c1385p2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e6) {
                    C1354d.m2793c("LottieFetchResult close failed ", e6);
                }
            }
            throw th;
        }
    }

    @NonNull
    @WorkerThread
    /* renamed from: a */
    public C1385p<C1376g> m3412a(@NonNull String str, @Nullable String str2) {
        C1376g m3409b = m3409b(str, str2);
        if (m3409b != null) {
            return new C1385p<>(m3409b);
        }
        C1354d.m2789a("Animation for " + str + " not found in cache. Fetching from network.");
        return m3411c(str, str2);
    }

    @NonNull
    /* renamed from: a */
    private C1385p<C1376g> m3408a(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        EnumC1488c enumC1488c;
        C1385p<C1376g> m3410b;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str.split("\\?")[0].endsWith(".lottie")) {
            C1354d.m2789a("Received json response.");
            enumC1488c = EnumC1488c.JSON;
            m3410b = m3407a(str, inputStream, str3);
        } else {
            C1354d.m2789a("Handling zip response.");
            enumC1488c = EnumC1488c.ZIP;
            m3410b = m3410b(str, inputStream, str3);
        }
        if (str3 != null && m3410b.m3061b() != null) {
            this.f3832a.m3406a(str, enumC1488c);
        }
        return m3410b;
    }

    @NonNull
    /* renamed from: b */
    private C1385p<C1376g> m3410b(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return C1377h.m2949b(new ZipInputStream(inputStream), (String) null);
        }
        return C1377h.m2949b(new ZipInputStream(new FileInputStream(this.f3832a.m3404a(str, inputStream, EnumC1488c.ZIP))), str);
    }

    @NonNull
    /* renamed from: a */
    private C1385p<C1376g> m3407a(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return C1377h.m2947b(inputStream, (String) null);
        }
        return C1377h.m2947b(new FileInputStream(new File(this.f3832a.m3404a(str, inputStream, EnumC1488c.JSON).getAbsolutePath())), str);
    }
}
