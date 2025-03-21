package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.p134o.InterfaceC1804a;

/* compiled from: GifBitmapProvider.java */
/* renamed from: com.bumptech.glide.load.resource.gif.b */
/* loaded from: classes.dex */
public final class C1771b implements InterfaceC1804a.a {

    /* renamed from: a */
    private final InterfaceC1626e f5014a;

    /* renamed from: b */
    @Nullable
    private final InterfaceC1623b f5015b;

    public C1771b(InterfaceC1626e interfaceC1626e) {
        this(interfaceC1626e, null);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a.a
    @NonNull
    /* renamed from: a */
    public Bitmap mo4464a(int i2, int i3, @NonNull Bitmap.Config config) {
        return this.f5014a.mo3926b(i2, i3, config);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a.a
    @NonNull
    /* renamed from: b */
    public byte[] mo4469b(int i2) {
        InterfaceC1623b interfaceC1623b = this.f5015b;
        return interfaceC1623b == null ? new byte[i2] : (byte[]) interfaceC1623b.mo3907b(i2, byte[].class);
    }

    public C1771b(InterfaceC1626e interfaceC1626e, @Nullable InterfaceC1623b interfaceC1623b) {
        this.f5014a = interfaceC1626e;
        this.f5015b = interfaceC1623b;
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a.a
    /* renamed from: a */
    public void mo4465a(@NonNull Bitmap bitmap) {
        this.f5014a.mo3924a(bitmap);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a.a
    /* renamed from: a */
    public void mo4466a(@NonNull byte[] bArr) {
        InterfaceC1623b interfaceC1623b = this.f5015b;
        if (interfaceC1623b == null) {
            return;
        }
        interfaceC1623b.put(bArr);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a.a
    @NonNull
    /* renamed from: a */
    public int[] mo4468a(int i2) {
        InterfaceC1623b interfaceC1623b = this.f5015b;
        if (interfaceC1623b == null) {
            return new int[i2];
        }
        return (int[]) interfaceC1623b.mo3907b(i2, int[].class);
    }

    @Override // com.bumptech.glide.p134o.InterfaceC1804a.a
    /* renamed from: a */
    public void mo4467a(@NonNull int[] iArr) {
        InterfaceC1623b interfaceC1623b = this.f5015b;
        if (interfaceC1623b == null) {
            return;
        }
        interfaceC1623b.put(iArr);
    }
}
