package com.bumptech.glide.load.p116o;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.EnumC1582h;
import com.bumptech.glide.load.EnumC1587a;
import com.bumptech.glide.load.p116o.InterfaceC1604d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* renamed from: com.bumptech.glide.load.o.l */
/* loaded from: classes.dex */
public abstract class AbstractC1612l<T> implements InterfaceC1604d<T> {

    /* renamed from: d */
    private static final String f4230d = "LocalUriFetcher";

    /* renamed from: a */
    private final Uri f4231a;

    /* renamed from: b */
    private final ContentResolver f4232b;

    /* renamed from: c */
    private T f4233c;

    public AbstractC1612l(ContentResolver contentResolver, Uri uri) {
        this.f4232b = contentResolver;
        this.f4231a = uri;
    }

    /* renamed from: a */
    protected abstract T mo3845a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: a */
    public final void mo3849a(@NonNull EnumC1582h enumC1582h, @NonNull InterfaceC1604d.a<? super T> aVar) {
        try {
            this.f4233c = mo3845a(this.f4231a, this.f4232b);
            aVar.mo3857a((InterfaceC1604d.a<? super T>) this.f4233c);
        } catch (FileNotFoundException e2) {
            Log.isLoggable(f4230d, 3);
            aVar.mo3856a((Exception) e2);
        }
    }

    /* renamed from: a */
    protected abstract void mo3847a(T t) throws IOException;

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    /* renamed from: b */
    public void mo3851b() {
        T t = this.f4233c;
        if (t != null) {
            try {
                mo3847a(t);
            } catch (IOException unused) {
            }
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
