package com.bumptech.glide.load.r.d;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BitmapEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bumptech.glide.load.m<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Integer> f3150b = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bumptech.glide.load.i<Bitmap.CompressFormat> f3151c = com.bumptech.glide.load.i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3152d = "BitmapEncoder";

    @Nullable
    private final com.bumptech.glide.load.p.a0.b a;

    public e(@NonNull com.bumptech.glide.load.p.a0.b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #2 {all -> 0x00b3, blocks: (B:3:0x0021, B:13:0x004d, B:25:0x0061, B:27:0x0067, B:31:0x00af, B:32:0x00b2), top: B:41:0x0021 }] */
    @Override // com.bumptech.glide.load.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(@NonNull com.bumptech.glide.load.p.v<Bitmap> vVar, @NonNull File file, @NonNull com.bumptech.glide.load.j jVar) {
        Bitmap bitmap = vVar.get();
        Bitmap.CompressFormat compressFormatA = a(bitmap, jVar);
        com.bumptech.glide.util.n.b.a("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatA);
        try {
            long jA = com.bumptech.glide.util.f.a();
            int iIntValue = ((Integer) jVar.a(f3150b)).intValue();
            boolean z = false;
            OutputStream cVar = null;
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        cVar = this.a != null ? new com.bumptech.glide.load.o.c(fileOutputStream, this.a) : fileOutputStream;
                        bitmap.compress(compressFormatA, iIntValue, cVar);
                        cVar.close();
                        z = true;
                    } catch (IOException unused) {
                        cVar = fileOutputStream;
                        Log.isLoggable(f3152d, 3);
                        if (cVar != null) {
                        }
                        if (Log.isLoggable(f3152d, 2)) {
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        cVar = fileOutputStream;
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused3) {
            }
            try {
                cVar.close();
            } catch (IOException unused4) {
            }
            if (Log.isLoggable(f3152d, 2)) {
                String str = "Compressed with type: " + compressFormatA + " of size " + com.bumptech.glide.util.l.a(bitmap) + " in " + com.bumptech.glide.util.f.a(jA) + ", options format: " + jVar.a(f3151c) + ", hasAlpha: " + bitmap.hasAlpha();
            }
            return z;
        } finally {
            com.bumptech.glide.util.n.b.a();
        }
    }

    @Deprecated
    public e() {
        this.a = null;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, com.bumptech.glide.load.j jVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) jVar.a(f3151c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.m
    @NonNull
    public com.bumptech.glide.load.c a(@NonNull com.bumptech.glide.load.j jVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }
}
