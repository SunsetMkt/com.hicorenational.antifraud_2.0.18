package com.bumptech.glide.load.p125r.p130h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1596j;
import com.bumptech.glide.load.p118p.InterfaceC1677v;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1626e;
import com.bumptech.glide.load.p125r.p126d.C1751z;
import com.bumptech.glide.util.C1876j;

/* compiled from: BitmapDrawableTranscoder.java */
/* renamed from: com.bumptech.glide.load.r.h.b */
/* loaded from: classes.dex */
public class C1763b implements InterfaceC1766e<Bitmap, BitmapDrawable> {

    /* renamed from: a */
    private final Resources f4981a;

    public C1763b(@NonNull Context context) {
        this(context.getResources());
    }

    @Override // com.bumptech.glide.load.p125r.p130h.InterfaceC1766e
    @Nullable
    /* renamed from: a */
    public InterfaceC1677v<BitmapDrawable> mo4432a(@NonNull InterfaceC1677v<Bitmap> interfaceC1677v, @NonNull C1596j c1596j) {
        return C1751z.m4410a(this.f4981a, interfaceC1677v);
    }

    @Deprecated
    public C1763b(@NonNull Resources resources, InterfaceC1626e interfaceC1626e) {
        this(resources);
    }

    public C1763b(@NonNull Resources resources) {
        this.f4981a = (Resources) C1876j.m4985a(resources);
    }
}
