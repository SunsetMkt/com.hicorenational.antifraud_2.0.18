package com.airbnb.lottie.p106y.p108k;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1399g;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p107j.C1444a;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: ShapeFill.java */
/* renamed from: com.airbnb.lottie.y.k.m */
/* loaded from: classes.dex */
public class C1471m implements InterfaceC1460b {

    /* renamed from: a */
    private final boolean f3695a;

    /* renamed from: b */
    private final Path.FillType f3696b;

    /* renamed from: c */
    private final String f3697c;

    /* renamed from: d */
    @Nullable
    private final C1444a f3698d;

    /* renamed from: e */
    @Nullable
    private final C1447d f3699e;

    /* renamed from: f */
    private final boolean f3700f;

    public C1471m(String str, boolean z, Path.FillType fillType, @Nullable C1444a c1444a, @Nullable C1447d c1447d, boolean z2) {
        this.f3697c = str;
        this.f3695a = z;
        this.f3696b = fillType;
        this.f3698d = c1444a;
        this.f3699e = c1447d;
        this.f3700f = z2;
    }

    @Nullable
    /* renamed from: a */
    public C1444a m3298a() {
        return this.f3698d;
    }

    /* renamed from: b */
    public Path.FillType m3299b() {
        return this.f3696b;
    }

    /* renamed from: c */
    public String m3300c() {
        return this.f3697c;
    }

    @Nullable
    /* renamed from: d */
    public C1447d m3301d() {
        return this.f3699e;
    }

    /* renamed from: e */
    public boolean m3302e() {
        return this.f3700f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f3695a + '}';
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1399g(c1379j, abstractC1477a, this);
    }
}
