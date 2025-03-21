package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: HttpException.java */
/* renamed from: com.bumptech.glide.load.e */
/* loaded from: classes.dex */
public final class C1591e extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public C1591e(int i2) {
        this("Http request failed with status code: " + i2, i2);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public C1591e(String str) {
        this(str, -1);
    }

    public C1591e(String str, int i2) {
        this(str, i2, null);
    }

    public C1591e(String str, int i2, @Nullable Throwable th) {
        super(str, th);
        this.statusCode = i2;
    }
}
