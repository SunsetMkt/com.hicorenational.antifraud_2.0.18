package com.bumptech.glide.load.p116o;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* renamed from: com.bumptech.glide.load.o.b */
/* loaded from: classes.dex */
public abstract class AbstractC1602b<T> implements InterfaceC1604d<T> {

    /* renamed from: d */
    private static final String f4200d = "AssetPathFetcher";

    /* renamed from: a */
    private final String f4201a;

    /* renamed from: b */
    private final AssetManager f4202b;

    /* renamed from: c */
    private T f4203c;

    public AbstractC1602b(AssetManager assetManager, String str) {
        this.f4202b = assetManager;
        this.f4201a = str;
    }

    /* renamed from: a */
    protected abstract T mo3848a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: a */
    public void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super T> aVar) {
        try {
            this.f4203c = mo3848a(this.f4202b, this.f4201a);
            aVar.mo3857a((InterfaceC1604d.a<? super T>) this.f4203c);
        } catch (IOException e2) {
            Log.isLoggable(f4200d, 3);
            aVar.mo3856a((Exception) e2);
        }
    }

    /* renamed from: a */
    protected abstract void mo3850a(T t) throws IOException;

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: b */
    public void mo3851b() {
        T t = this.f4203c;
        if (t == null) {
            return;
        }
        try {
            mo3850a(t);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    @NonNull
    /* renamed from: c */
    public EnumC1587a mo3852c() {
        return EnumC1587a.LOCAL;
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    public void cancel() {
    }
}
