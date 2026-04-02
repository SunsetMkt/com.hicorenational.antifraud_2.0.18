package com.bumptech.glide.load.o.p;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: ThumbnailStreamOpener.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2761f = "ThumbStreamOpener";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final a f2762g = new a();
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f2763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.p.a0.b f2764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ContentResolver f2765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<ImageHeaderParser> f2766e;

    e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.p.a0.b bVar, ContentResolver contentResolver) {
        this(list, f2762g, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String c(@NonNull Uri uri) throws Throwable {
        Cursor cursorA;
        Cursor cursor = null;
        try {
            try {
                cursorA = this.f2763b.a(uri);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToFirst()) {
                            String string = cursorA.getString(0);
                            if (cursorA != null) {
                                cursorA.close();
                            }
                            return string;
                        }
                    } catch (SecurityException unused) {
                        if (Log.isLoggable(f2761f, 3)) {
                            String str = "Failed to query for thumbnail for Uri: " + uri;
                        }
                        if (cursorA != null) {
                            cursorA.close();
                        }
                        return null;
                    }
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            } catch (SecurityException unused2) {
                cursorA = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    int a(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f2765d.openInputStream(uri);
                int iA = f.a(this.f2766e, inputStreamOpenInputStream, this.f2764c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iA;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException unused3) {
            if (Log.isLoggable(f2761f, 3)) {
                String str = "Failed to open uri: " + uri;
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused4) {
                return -1;
            }
        }
    }

    public InputStream b(Uri uri) throws Throwable {
        String strC = c(uri);
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        File fileA = this.a.a(strC);
        if (!a(fileA)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        try {
            return this.f2765d.openInputStream(uriFromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.p.a0.b bVar, ContentResolver contentResolver) {
        this.a = aVar;
        this.f2763b = dVar;
        this.f2764c = bVar;
        this.f2765d = contentResolver;
        this.f2766e = list;
    }

    private boolean a(File file) {
        return this.a.a(file) && 0 < this.a.b(file);
    }
}
