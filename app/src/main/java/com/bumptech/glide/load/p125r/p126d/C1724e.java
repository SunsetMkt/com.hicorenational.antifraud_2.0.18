package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1595i;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.EnumC1589c;
import com.bumptech.glide.load.InterfaceC1599m;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;

/* compiled from: BitmapEncoder.java */
/* renamed from: com.bumptech.glide.load.r.d.e */
/* loaded from: classes.dex */
public class C1724e implements InterfaceC1599m<Bitmap> {

    /* renamed from: b */
    public static final C1595i<Integer> f4830b = C1595i.m3831a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c */
    public static final C1595i<Bitmap.CompressFormat> f4831c = C1595i.m3829a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: d */
    private static final String f4832d = "BitmapEncoder";

    /* renamed from: a */
    @Nullable
    private final InterfaceC1623b f4833a;

    public C1724e(@NonNull InterfaceC1623b interfaceC1623b) {
        this.f4833a = interfaceC1623b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        if (r6 == null) goto L24;
     */
    @Override // com.bumptech.glide.load.InterfaceC1590d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo3817a(@androidx.annotation.NonNull com.bumptech.glide.load.p118p.InterfaceC1677v<android.graphics.Bitmap> r9, @androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull com.bumptech.glide.load.C1596j r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.m4311a(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.p141n.C1881b.m5027a(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.C1872f.m4970a()     // Catch: java.lang.Throwable -> Lb3
            com.bumptech.glide.load.i<java.lang.Integer> r4 = com.bumptech.glide.load.p125r.p126d.C1724e.f4830b     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r4 = r11.m3840a(r4)     // Catch: java.lang.Throwable -> Lb3
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lb3
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lb3
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            com.bumptech.glide.load.p.a0.b r10 = r8.f4833a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            if (r10 == 0) goto L45
            com.bumptech.glide.load.o.c r10 = new com.bumptech.glide.load.o.c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            com.bumptech.glide.load.p.a0.b r6 = r8.f4833a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6 = r10
            goto L46
        L45:
            r6 = r7
        L46:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r6.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            r5 = 1
        L4d:
            r6.close()     // Catch: java.io.IOException -> L60 java.lang.Throwable -> Lb3
            goto L60
        L51:
            r9 = move-exception
            r6 = r7
            goto Lad
        L54:
            r6 = r7
            goto L58
        L56:
            r9 = move-exception
            goto Lad
        L58:
            r10 = 3
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L60
            goto L4d
        L60:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lb3
            if (r10 == 0) goto La9
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            r10.<init>()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = "Compressed with type: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r1)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = " of size "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            int r0 = com.bumptech.glide.util.C1878l.m4995a(r9)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = " in "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            double r0 = com.bumptech.glide.util.C1872f.m4969a(r2)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = ", options format: "
            r10.append(r0)     // Catch: java.lang.Throwable -> Lb3
            com.bumptech.glide.load.i<android.graphics.Bitmap$CompressFormat> r0 = com.bumptech.glide.load.p125r.p126d.C1724e.f4831c     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r11 = r11.m3840a(r0)     // Catch: java.lang.Throwable -> Lb3
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lb3
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lb3
            r10.append(r9)     // Catch: java.lang.Throwable -> Lb3
            r10.toString()     // Catch: java.lang.Throwable -> Lb3
        La9:
            com.bumptech.glide.util.p141n.C1881b.m5023a()
            return r5
        Lad:
            if (r6 == 0) goto Lb2
            r6.close()     // Catch: java.io.IOException -> Lb2 java.lang.Throwable -> Lb3
        Lb2:
            throw r9     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            r9 = move-exception
            com.bumptech.glide.util.p141n.C1881b.m5023a()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.p125r.p126d.C1724e.mo3817a(com.bumptech.glide.load.p.v, java.io.File, com.bumptech.glide.load.j):boolean");
    }

    @Deprecated
    public C1724e() {
        this.f4833a = null;
    }

    /* renamed from: a */
    private Bitmap.CompressFormat m4311a(Bitmap bitmap, C1596j c1596j) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) c1596j.m3840a(f4831c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.InterfaceC1599m
    @NonNull
    /* renamed from: a */
    public EnumC1589c mo3844a(@NonNull C1596j c1596j) {
        return EnumC1589c.TRANSFORMED;
    }
}
