package com.bumptech.glide.load.q;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements com.bumptech.glide.load.d<InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3109b = "StreamEncoder";
    private final com.bumptech.glide.load.p.a0.b a;

    public t(com.bumptech.glide.load.p.a0.b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // com.bumptech.glide.load.d
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.bumptech.glide.load.j jVar) throws Throwable {
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.a.b(65536, byte[].class);
        boolean z = false;
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
            }
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    r1 = -1;
                    if (i2 == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                } catch (IOException unused3) {
                    r1 = fileOutputStream;
                    Log.isLoggable(f3109b, 3);
                    if (r1 != 0) {
                        r1.close();
                        r1 = r1;
                    }
                    this.a.put(bArr);
                    return z;
                } catch (Throwable th) {
                    th = th;
                    r1 = fileOutputStream;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException unused4) {
                        }
                    }
                    this.a.put(bArr);
                    throw th;
                }
                this.a.put(bArr);
                return z;
            }
            fileOutputStream.close();
            z = true;
            fileOutputStream.close();
            this.a.put(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
