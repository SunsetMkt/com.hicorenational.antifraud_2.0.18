package com.airbnb.lottie.p102w.p103b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1416c;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1468j;
import com.airbnb.lottie.p106y.p108k.C1475q;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.List;

/* compiled from: RectangleContent.java */
/* renamed from: com.airbnb.lottie.w.b.p */
/* loaded from: classes.dex */
public class C1408p implements AbstractC1414a.b, InterfaceC1403k, InterfaceC1406n {

    /* renamed from: c */
    private final String f3479c;

    /* renamed from: d */
    private final boolean f3480d;

    /* renamed from: e */
    private final C1379j f3481e;

    /* renamed from: f */
    private final AbstractC1414a<?, PointF> f3482f;

    /* renamed from: g */
    private final AbstractC1414a<?, PointF> f3483g;

    /* renamed from: h */
    private final AbstractC1414a<?, Float> f3484h;

    /* renamed from: j */
    private boolean f3486j;

    /* renamed from: a */
    private final Path f3477a = new Path();

    /* renamed from: b */
    private final RectF f3478b = new RectF();

    /* renamed from: i */
    private C1394b f3485i = new C1394b();

    public C1408p(C1379j c1379j, AbstractC1477a abstractC1477a, C1468j c1468j) {
        this.f3479c = c1468j.m3284b();
        this.f3480d = c1468j.m3287e();
        this.f3481e = c1379j;
        this.f3482f = c1468j.m3285c().mo3220a();
        this.f3483g = c1468j.m3286d().mo3220a();
        this.f3484h = c1468j.m3283a().mo3220a();
        abstractC1477a.m3345a(this.f3482f);
        abstractC1477a.m3345a(this.f3483g);
        abstractC1477a.m3345a(this.f3484h);
        this.f3482f.m3138a(this);
        this.f3483g.m3138a(this);
        this.f3484h.m3138a(this);
    }

    /* renamed from: b */
    private void m3123b() {
        this.f3486j = false;
        this.f3481e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        m3123b();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3479c;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1406n
    public Path getPath() {
        if (this.f3486j) {
            return this.f3477a;
        }
        this.f3477a.reset();
        if (this.f3480d) {
            this.f3486j = true;
            return this.f3477a;
        }
        PointF mo3143f = this.f3483g.mo3143f();
        float f2 = mo3143f.x / 2.0f;
        float f3 = mo3143f.y / 2.0f;
        AbstractC1414a<?, Float> abstractC1414a = this.f3484h;
        float m3155i = abstractC1414a == null ? 0.0f : ((C1416c) abstractC1414a).m3155i();
        float min = Math.min(f2, f3);
        if (m3155i > min) {
            m3155i = min;
        }
        PointF mo3143f2 = this.f3482f.mo3143f();
        this.f3477a.moveTo(mo3143f2.x + f2, (mo3143f2.y - f3) + m3155i);
        this.f3477a.lineTo(mo3143f2.x + f2, (mo3143f2.y + f3) - m3155i);
        if (m3155i > 0.0f) {
            RectF rectF = this.f3478b;
            float f4 = mo3143f2.x;
            float f5 = m3155i * 2.0f;
            float f6 = mo3143f2.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f3477a.arcTo(this.f3478b, 0.0f, 90.0f, false);
        }
        this.f3477a.lineTo((mo3143f2.x - f2) + m3155i, mo3143f2.y + f3);
        if (m3155i > 0.0f) {
            RectF rectF2 = this.f3478b;
            float f7 = mo3143f2.x;
            float f8 = mo3143f2.y;
            float f9 = m3155i * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f3477a.arcTo(this.f3478b, 90.0f, 90.0f, false);
        }
        this.f3477a.lineTo(mo3143f2.x - f2, (mo3143f2.y - f3) + m3155i);
        if (m3155i > 0.0f) {
            RectF rectF3 = this.f3478b;
            float f10 = mo3143f2.x;
            float f11 = mo3143f2.y;
            float f12 = m3155i * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.f3477a.arcTo(this.f3478b, 180.0f, 90.0f, false);
        }
        this.f3477a.lineTo((mo3143f2.x + f2) - m3155i, mo3143f2.y - f3);
        if (m3155i > 0.0f) {
            RectF rectF4 = this.f3478b;
            float f13 = mo3143f2.x;
            float f14 = m3155i * 2.0f;
            float f15 = mo3143f2.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.f3477a.arcTo(this.f3478b, 270.0f, 90.0f, false);
        }
        this.f3477a.close();
        this.f3485i.m3101a(this.f3477a);
        this.f3486j = true;
        return this.f3477a;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceC1395c interfaceC1395c = list.get(i2);
            if (interfaceC1395c instanceof C1412t) {
                C1412t c1412t = (C1412t) interfaceC1395c;
                if (c1412t.m3129e() == C1475q.a.SIMULTANEOUSLY) {
                    this.f3485i.m3102a(c1412t);
                    c1412t.m3125a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        C1357g.m2826a(c1439e, i2, list, c1439e2, this);
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        if (t == InterfaceC1384o.f3339j) {
            this.f3483g.m3137a((C1370j<PointF>) c1370j);
        } else if (t == InterfaceC1384o.f3341l) {
            this.f3482f.m3137a((C1370j<PointF>) c1370j);
        } else if (t == InterfaceC1384o.f3340k) {
            this.f3484h.m3137a((C1370j<Float>) c1370j);
        }
    }
}
