package com.airbnb.lottie.p110z;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: LottieFetchResult.java */
/* renamed from: com.airbnb.lottie.z.d */
/* loaded from: classes.dex */
public interface InterfaceC1489d extends Closeable {
    @Nullable
    /* renamed from: a */
    String mo3397a();

    @NonNull
    /* renamed from: b */
    InputStream mo3398b() throws IOException;

    @Nullable
    String contentType();

    boolean isSuccessful();
}
