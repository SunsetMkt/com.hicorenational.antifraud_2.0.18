package com.airbnb.lottie.p110z;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.p100b0.C1354d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* renamed from: com.airbnb.lottie.z.g */
/* loaded from: classes.dex */
public class C1492g {

    /* renamed from: a */
    @NonNull
    private final InterfaceC1490e f3831a;

    public C1492g(@NonNull InterfaceC1490e interfaceC1490e) {
        this.f3831a = interfaceC1490e;
    }

    @Nullable
    /* renamed from: b */
    private File m3402b(String str) throws FileNotFoundException {
        File file = new File(m3401b(), m3400a(str, EnumC1488c.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(m3401b(), m3400a(str, EnumC1488c.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    /* renamed from: a */
    public void m3405a() {
        File m3401b = m3401b();
        if (m3401b.exists()) {
            File[] listFiles = m3401b.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : m3401b.listFiles()) {
                    file.delete();
                }
            }
            m3401b.delete();
        }
    }

    /* renamed from: b */
    private File m3401b() {
        File mo2885a = this.f3831a.mo2885a();
        if (mo2885a.isFile()) {
            mo2885a.delete();
        }
        if (!mo2885a.exists()) {
            mo2885a.mkdirs();
        }
        return mo2885a;
    }

    @Nullable
    @WorkerThread
    /* renamed from: a */
    Pair<EnumC1488c, InputStream> m3403a(String str) {
        EnumC1488c enumC1488c;
        try {
            File m3402b = m3402b(str);
            if (m3402b == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(m3402b);
            if (m3402b.getAbsolutePath().endsWith(".zip")) {
                enumC1488c = EnumC1488c.ZIP;
            } else {
                enumC1488c = EnumC1488c.JSON;
            }
            C1354d.m2789a("Cache hit for " + str + " at " + m3402b.getAbsolutePath());
            return new Pair<>(enumC1488c, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    File m3404a(String str, InputStream inputStream, EnumC1488c enumC1488c) throws IOException {
        File file = new File(m3401b(), m3400a(str, enumC1488c, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    /* renamed from: a */
    void m3406a(String str, EnumC1488c enumC1488c) {
        File file = new File(m3401b(), m3400a(str, enumC1488c, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        C1354d.m2789a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        C1354d.m2791b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    /* renamed from: a */
    private static String m3400a(String str, EnumC1488c enumC1488c, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? enumC1488c.tempExtension() : enumC1488c.extension);
        return sb.toString();
    }
}
