package com.bumptech.glide.load.p125r.p126d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.InterfaceC1598l;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.util.C1878l;

/* compiled from: UnitBitmapDecoder.java */
/* renamed from: com.bumptech.glide.load.r.d.h0 */
/* loaded from: classes.dex */
public final class C1731h0 implements InterfaceC1598l<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder.java */
    /* renamed from: com.bumptech.glide.load.r.d.h0$a */
    private static final class a implements InterfaceC1677v<Bitmap> {

        /* renamed from: a */
        private final Bitmap f4858a;

        a(@NonNull Bitmap bitmap) {
            this.f4858a = bitmap;
        }

        @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
        /* renamed from: a */
        public int mo4183a() {
            return C1878l.m4995a(this.f4858a);
        }

        @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
        @NonNull
        /* renamed from: b */
        public Class<Bitmap> mo4184b() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
        public void recycle() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.p118p.InterfaceC1677v
        @NonNull
        public Bitmap get() {
            return this.f4858a;
        }
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean mo3843a(@NonNull Bitmap bitmap, @NonNull C1596j c1596j) {
        return true;
    }

    @Override // com.bumptech.glide.load.InterfaceC1598l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC1677v<Bitmap> mo3842a(@NonNull Bitmap bitmap, int i2, int i3, @NonNull C1596j c1596j) {
        return new a(bitmap);
    }
}
