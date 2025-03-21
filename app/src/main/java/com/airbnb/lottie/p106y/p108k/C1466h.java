package com.airbnb.lottie.p106y.p108k;

import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p102w.p103b.C1404l;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: MergePaths.java */
/* renamed from: com.airbnb.lottie.y.k.h */
/* loaded from: classes.dex */
public class C1466h implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3667a;

    /* renamed from: b */
    private final a f3668b;

    /* renamed from: c */
    private final boolean f3669c;

    /* compiled from: MergePaths.java */
    /* renamed from: com.airbnb.lottie.y.k.h$a */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a forId(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public C1466h(String str, a aVar, boolean z) {
        this.f3667a = str;
        this.f3668b = aVar;
        this.f3669c = z;
    }

    /* renamed from: a */
    public a m3270a() {
        return this.f3668b;
    }

    /* renamed from: b */
    public String m3271b() {
        return this.f3667a;
    }

    /* renamed from: c */
    public boolean m3272c() {
        return this.f3669c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f3668b + '}';
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    @Nullable
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        if (c1379j.m3021d()) {
            return new C1404l(this);
        }
        C1354d.m2791b("Animation contains merge paths but they are disabled.");
        return null;
    }
}
