package com.bumptech.glide.load.p125r.p130h;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p126d.C1728g;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* compiled from: DrawableBytesTranscoder.java */
/* renamed from: com.bumptech.glide.load.r.h.c */
/* loaded from: classes.dex */
public final class C1764c implements InterfaceC1766e<Drawable, byte[]> {

    /* renamed from: a */
    private final InterfaceC1626e f4982a;

    /* renamed from: b */
    private final InterfaceC1766e<Bitmap, byte[]> f4983b;

    /* renamed from: c */
    private final InterfaceC1766e<GifDrawable, byte[]> f4984c;

    public C1764c(@NonNull InterfaceC1626e interfaceC1626e, @NonNull InterfaceC1766e<Bitmap, byte[]> interfaceC1766e, @NonNull InterfaceC1766e<GifDrawable, byte[]> interfaceC1766e2) {
        this.f4982a = interfaceC1626e;
        this.f4983b = interfaceC1766e;
        this.f4984c = interfaceC1766e2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /* renamed from: a */
    private static InterfaceC1677v<GifDrawable> m4433a(@NonNull InterfaceC1677v<Drawable> interfaceC1677v) {
        return interfaceC1677v;
    }

    @Override // com.bumptech.glide.load.p125r.p130h.InterfaceC1766e
    @Nullable
    /* renamed from: a */
    public InterfaceC1677v<byte[]> mo4432a(@NonNull InterfaceC1677v<Drawable> interfaceC1677v, @NonNull C1596j c1596j) {
        Drawable drawable = interfaceC1677v.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f4983b.mo4432a(C1728g.m4315a(((BitmapDrawable) drawable).getBitmap(), this.f4982a), c1596j);
        }
        if (drawable instanceof GifDrawable) {
            return this.f4984c.mo4432a(m4433a(interfaceC1677v), c1596j);
        }
        return null;
    }
}
