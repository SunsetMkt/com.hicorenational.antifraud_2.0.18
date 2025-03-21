package com.bumptech.glide.load.p116o.p117p;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.C1592f;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* renamed from: com.bumptech.glide.load.o.p.e */
/* loaded from: classes.dex */
class C1620e {

    /* renamed from: f */
    private static final String f4254f = "ThumbStreamOpener";

    /* renamed from: g */
    private static final C1616a f4255g = new C1616a();

    /* renamed from: a */
    private final C1616a f4256a;

    /* renamed from: b */
    private final InterfaceC1619d f4257b;

    /* renamed from: c */
    private final InterfaceC1623b f4258c;

    /* renamed from: d */
    private final ContentResolver f4259d;

    /* renamed from: e */
    private final List<ImageHeaderParser> f4260e;

    C1620e(List<ImageHeaderParser> list, InterfaceC1619d interfaceC1619d, InterfaceC1623b interfaceC1623b, ContentResolver contentResolver) {
        this(list, f4255g, interfaceC1619d, interfaceC1623b, contentResolver);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    @androidx.annotation.Nullable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m3888c(@androidx.annotation.NonNull android.net.Uri r5) {
        /*
            r4 = this;
            r0 = 0
            com.bumptech.glide.load.o.p.d r1 = r4.f4257b     // Catch: java.lang.Throwable -> L20 java.lang.SecurityException -> L23
            android.database.Cursor r1 = r1.mo3886a(r5)     // Catch: java.lang.Throwable -> L20 java.lang.SecurityException -> L23
            if (r1 == 0) goto L1a
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.SecurityException -> L24 java.lang.Throwable -> L43
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.SecurityException -> L24 java.lang.Throwable -> L43
            if (r1 == 0) goto L19
            r1.close()
        L19:
            return r5
        L1a:
            if (r1 == 0) goto L1f
            r1.close()
        L1f:
            return r0
        L20:
            r5 = move-exception
            r1 = r0
            goto L44
        L23:
            r1 = r0
        L24:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L3d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L43
            r2.append(r5)     // Catch: java.lang.Throwable -> L43
            r2.toString()     // Catch: java.lang.Throwable -> L43
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            return r0
        L43:
            r5 = move-exception
        L44:
            if (r1 == 0) goto L49
            r1.close()
        L49:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.p116o.p117p.C1620e.m3888c(android.net.Uri):java.lang.String");
    }

    /* renamed from: a */
    int m3889a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f4259d.openInputStream(uri);
                int m3820a = C1592f.m3820a(this.f4260e, inputStream, this.f4258c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return m3820a;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException unused3) {
            if (Log.isLoggable(f4254f, 3)) {
                String str = "Failed to open uri: " + uri;
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused4) {
                return -1;
            }
        }
    }

    /* renamed from: b */
    public InputStream m3890b(Uri uri) throws FileNotFoundException {
        String m3888c = m3888c(uri);
        if (TextUtils.isEmpty(m3888c)) {
            return null;
        }
        File m3874a = this.f4256a.m3874a(m3888c);
        if (!m3887a(m3874a)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(m3874a);
        try {
            return this.f4259d.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    C1620e(List<ImageHeaderParser> list, C1616a c1616a, InterfaceC1619d interfaceC1619d, InterfaceC1623b interfaceC1623b, ContentResolver contentResolver) {
        this.f4256a = c1616a;
        this.f4257b = interfaceC1619d;
        this.f4258c = interfaceC1623b;
        this.f4259d = contentResolver;
        this.f4260e = list;
    }

    /* renamed from: a */
    private boolean m3887a(File file) {
        return this.f4256a.m3875a(file) && 0 < this.f4256a.m3876b(file);
    }
}
