package com.bumptech.glide.load.p123q;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p123q.InterfaceC1695n;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* renamed from: com.bumptech.glide.load.q.u */
/* loaded from: classes.dex */
public class C1702u<Data> implements InterfaceC1695n<String, Data> {

    /* renamed from: a */
    private final InterfaceC1695n<Uri, Data> f4760a;

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.q.u$a */
    public static final class a implements InterfaceC1696o<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public InterfaceC1695n<String, AssetFileDescriptor> mo4220a(@NonNull C1699r c1699r) {
            return new C1702u(c1699r.m4276a(Uri.class, AssetFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.q.u$b */
    public static class b implements InterfaceC1696o<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<String, ParcelFileDescriptor> mo4220a(@NonNull C1699r c1699r) {
            return new C1702u(c1699r.m4276a(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: com.bumptech.glide.load.q.u$c */
    public static class c implements InterfaceC1696o<String, InputStream> {
        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        @NonNull
        /* renamed from: a */
        public InterfaceC1695n<String, InputStream> mo4220a(@NonNull C1699r c1699r) {
            return new C1702u(c1699r.m4276a(Uri.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.p123q.InterfaceC1696o
        /* renamed from: a */
        public void mo4221a() {
        }
    }

    public C1702u(InterfaceC1695n<Uri, Data> interfaceC1695n) {
        this.f4760a = interfaceC1695n;
    }

    @Nullable
    /* renamed from: b */
    private static Uri m4287b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return m4288c(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? m4288c(str) : parse;
    }

    /* renamed from: c */
    private static Uri m4288c(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo4218a(@NonNull String str) {
        return true;
    }

    @Override // com.bumptech.glide.load.p123q.InterfaceC1695n
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1695n.a<Data> mo4217a(@NonNull String str, int i2, int i3, @NonNull C1596j c1596j) {
        Uri m4287b = m4287b(str);
        if (m4287b == null || !this.f4760a.mo4218a(m4287b)) {
            return null;
        }
        return this.f4760a.mo4217a(m4287b, i2, i3, c1596j);
    }
}
