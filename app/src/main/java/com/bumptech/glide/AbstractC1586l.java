package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.AbstractC1586l;
import com.bumptech.glide.p137r.p139m.C1855e;
import com.bumptech.glide.p137r.p139m.C1858h;
import com.bumptech.glide.p137r.p139m.C1859i;
import com.bumptech.glide.p137r.p139m.C1860j;
import com.bumptech.glide.p137r.p139m.InterfaceC1857g;
import com.bumptech.glide.util.C1876j;

/* compiled from: TransitionOptions.java */
/* renamed from: com.bumptech.glide.l */
/* loaded from: classes.dex */
public abstract class AbstractC1586l<CHILD extends AbstractC1586l<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a */
    private InterfaceC1857g<? super TranscodeType> f4176a = C1855e.m4940b();

    /* renamed from: c */
    private CHILD m3807c() {
        return this;
    }

    @NonNull
    /* renamed from: a */
    public final CHILD m3808a() {
        return m3810a(C1855e.m4940b());
    }

    /* renamed from: b */
    final InterfaceC1857g<? super TranscodeType> m3812b() {
        return this.f4176a;
    }

    @NonNull
    /* renamed from: a */
    public final CHILD m3809a(int i2) {
        return m3810a(new C1858h(i2));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m26851clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    /* renamed from: a */
    public final CHILD m3811a(@NonNull C1860j.a aVar) {
        return m3810a(new C1859i(aVar));
    }

    @NonNull
    /* renamed from: a */
    public final CHILD m3810a(@NonNull InterfaceC1857g<? super TranscodeType> interfaceC1857g) {
        this.f4176a = (InterfaceC1857g) C1876j.m4985a(interfaceC1857g);
        return m3807c();
    }
}
