package com.bumptech.glide.p136q;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry.java */
/* renamed from: com.bumptech.glide.q.b */
/* loaded from: classes.dex */
public final class C1817b {

    /* renamed from: a */
    private final List<ImageHeaderParser> f5246a = new ArrayList();

    @NonNull
    /* renamed from: a */
    public synchronized List<ImageHeaderParser> m4695a() {
        return this.f5246a;
    }

    /* renamed from: a */
    public synchronized void m4696a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f5246a.add(imageHeaderParser);
    }
}
