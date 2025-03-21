package com.bumptech.glide.load.p116o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.EnumC1587a;

/* compiled from: DataFetcher.java */
/* renamed from: com.bumptech.glide.load.o.d */
/* loaded from: classes.dex */
public interface InterfaceC1604d<T> {

    /* compiled from: DataFetcher.java */
    /* renamed from: com.bumptech.glide.load.o.d$a */
    public interface a<T> {
        /* renamed from: a */
        void mo3856a(@NonNull Exception exc);

        /* renamed from: a */
        void mo3857a(@Nullable T t);
    }

    @NonNull
    /* renamed from: a */
    Class<T> mo3846a();

    /* renamed from: a */
    void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull a<? super T> aVar);

    /* renamed from: b */
    void mo3851b();

    @NonNull
    /* renamed from: c */
    EnumC1587a mo3852c();

    void cancel();
}
