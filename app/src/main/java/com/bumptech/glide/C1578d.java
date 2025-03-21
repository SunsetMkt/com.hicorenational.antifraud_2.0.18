package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.bumptech.glide.load.p118p.C1666k;
import com.bumptech.glide.load.p118p.p119a0.InterfaceC1623b;
import com.bumptech.glide.p137r.C1829h;
import com.bumptech.glide.p137r.InterfaceC1828g;
import com.bumptech.glide.p137r.p138l.AbstractC1850r;
import com.bumptech.glide.p137r.p138l.C1843k;
import java.util.List;
import java.util.Map;

/* compiled from: GlideContext.java */
/* renamed from: com.bumptech.glide.d */
/* loaded from: classes.dex */
public class C1578d extends ContextWrapper {

    /* renamed from: k */
    @VisibleForTesting
    static final AbstractC1586l<?, ?> f4099k = new C1575a();

    /* renamed from: a */
    private final InterfaceC1623b f4100a;

    /* renamed from: b */
    private final C1583i f4101b;

    /* renamed from: c */
    private final C1843k f4102c;

    /* renamed from: d */
    private final ComponentCallbacks2C1576b.a f4103d;

    /* renamed from: e */
    private final List<InterfaceC1828g<Object>> f4104e;

    /* renamed from: f */
    private final Map<Class<?>, AbstractC1586l<?, ?>> f4105f;

    /* renamed from: g */
    private final C1666k f4106g;

    /* renamed from: h */
    private final boolean f4107h;

    /* renamed from: i */
    private final int f4108i;

    /* renamed from: j */
    @Nullable
    @GuardedBy("this")
    private C1829h f4109j;

    public C1578d(@NonNull Context context, @NonNull InterfaceC1623b interfaceC1623b, @NonNull C1583i c1583i, @NonNull C1843k c1843k, @NonNull ComponentCallbacks2C1576b.a aVar, @NonNull Map<Class<?>, AbstractC1586l<?, ?>> map, @NonNull List<InterfaceC1828g<Object>> list, @NonNull C1666k c1666k, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f4100a = interfaceC1623b;
        this.f4101b = c1583i;
        this.f4102c = c1843k;
        this.f4103d = aVar;
        this.f4104e = list;
        this.f4105f = map;
        this.f4106g = c1666k;
        this.f4107h = z;
        this.f4108i = i2;
    }

    @NonNull
    /* renamed from: a */
    public <T> AbstractC1586l<?, T> m3688a(@NonNull Class<T> cls) {
        AbstractC1586l<?, T> abstractC1586l = (AbstractC1586l) this.f4105f.get(cls);
        if (abstractC1586l == null) {
            for (Map.Entry<Class<?>, AbstractC1586l<?, ?>> entry : this.f4105f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    abstractC1586l = (AbstractC1586l) entry.getValue();
                }
            }
        }
        return abstractC1586l == null ? (AbstractC1586l<?, T>) f4099k : abstractC1586l;
    }

    /* renamed from: b */
    public List<InterfaceC1828g<Object>> m3691b() {
        return this.f4104e;
    }

    /* renamed from: c */
    public synchronized C1829h m3692c() {
        if (this.f4109j == null) {
            this.f4109j = this.f4103d.build().m4734M();
        }
        return this.f4109j;
    }

    @NonNull
    /* renamed from: d */
    public C1666k m3693d() {
        return this.f4106g;
    }

    /* renamed from: e */
    public int m3694e() {
        return this.f4108i;
    }

    @NonNull
    /* renamed from: f */
    public C1583i m3695f() {
        return this.f4101b;
    }

    /* renamed from: g */
    public boolean m3696g() {
        return this.f4107h;
    }

    @NonNull
    /* renamed from: a */
    public <X> AbstractC1850r<ImageView, X> m3690a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f4102c.m4907a(imageView, cls);
    }

    @NonNull
    /* renamed from: a */
    public InterfaceC1623b m3689a() {
        return this.f4100a;
    }
}
