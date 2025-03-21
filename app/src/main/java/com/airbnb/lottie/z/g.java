package com.airbnb.lottie.z;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final e f3990a;

    public g(@NonNull e eVar) {
        this.f3990a = eVar;
    }

    @Nullable
    private File b(String str) throws FileNotFoundException {
        File file = new File(b(), a(str, c.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(b(), a(str, c.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public void a() {
        File b2 = b();
        if (b2.exists()) {
            File[] listFiles = b2.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : b2.listFiles()) {
                    file.delete();
                }
            }
            b2.delete();
        }
    }

    private File b() {
        File a2 = this.f3990a.a();
        if (a2.isFile()) {
            a2.delete();
        }
        if (!a2.exists()) {
            a2.mkdirs();
        }
        return a2;
    }

    @Nullable
    @WorkerThread
    Pair<c, InputStream> a(String str) {
        c cVar;
        try {
            File b2 = b(str);
            if (b2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(b2);
            if (b2.getAbsolutePath().endsWith(".zip")) {
                cVar = c.ZIP;
            } else {
                cVar = c.JSON;
            }
            com.airbnb.lottie.b0.d.a("Cache hit for " + str + " at " + b2.getAbsolutePath());
            return new Pair<>(cVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File a(String str, InputStream inputStream, c cVar) throws IOException {
        File file = new File(b(), a(str, cVar, true));
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

    void a(String str, c cVar) {
        File file = new File(b(), a(str, cVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        com.airbnb.lottie.b0.d.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        com.airbnb.lottie.b0.d.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    private static String a(String str, c cVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? cVar.tempExtension() : cVar.extension);
        return sb.toString();
    }
}
