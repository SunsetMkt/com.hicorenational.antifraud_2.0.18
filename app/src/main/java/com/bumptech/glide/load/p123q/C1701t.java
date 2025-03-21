package com.bumptech.glide.load.p123q;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1590d;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamEncoder.java */
/* renamed from: com.bumptech.glide.load.q.t */
/* loaded from: classes.dex */
public class C1701t implements InterfaceC1590d<InputStream> {

    /* renamed from: b */
    private static final String f4758b = "StreamEncoder";

    /* renamed from: a */
    private final InterfaceC1623b f4759a;

    public C1701t(InterfaceC1623b interfaceC1623b) {
        this.f4759a = interfaceC1623b;
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
    @Override // com.bumptech.glide.load.InterfaceC1590d
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3817a(@NonNull InputStream inputStream, @NonNull File file, @NonNull C1596j c1596j) {
        byte[] bArr = (byte[]) this.f4759a.mo3907b(65536, byte[].class);
        boolean z = false;
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            r1 = -1;
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (IOException unused) {
                            r1 = fileOutputStream;
                            Log.isLoggable(f4758b, 3);
                            if (r1 != 0) {
                                r1.close();
                                r1 = r1;
                            }
                            this.f4759a.put(bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            r1 = fileOutputStream;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (IOException unused2) {
                                }
                            }
                            this.f4759a.put(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream.close();
                    z = true;
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
            }
            this.f4759a.put(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
