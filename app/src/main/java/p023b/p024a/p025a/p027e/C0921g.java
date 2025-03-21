package p023b.p024a.p025a.p027e;

import android.app.Activity;
import p023b.p024a.p025a.p027e.C0922h;
import p023b.p024a.p025a.p027e.C0923i;

/* compiled from: NumberPicker.java */
/* renamed from: b.a.a.e.g */
/* loaded from: classes.dex */
public class C0921g extends C0923i<Number> {

    /* compiled from: NumberPicker.java */
    /* renamed from: b.a.a.e.g$a */
    class a extends b {

        /* renamed from: a */
        final /* synthetic */ C0922h.a f1490a;

        a(C0922h.a aVar) {
            this.f1490a = aVar;
        }

        @Override // p023b.p024a.p025a.p027e.C0921g.b
        /* renamed from: b */
        public void mo969b(int i2, Number number) {
            this.f1490a.mo971b(i2, number.toString());
        }
    }

    /* compiled from: NumberPicker.java */
    /* renamed from: b.a.a.e.g$b */
    public static abstract class b implements C0923i.b<Number> {
        /* renamed from: b */
        public abstract void mo969b(int i2, Number number);

        @Override // p023b.p024a.p025a.p027e.C0923i.b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final void mo970a(int i2, Number number) {
            mo969b(i2, number);
        }
    }

    /* compiled from: NumberPicker.java */
    /* renamed from: b.a.a.e.g$c */
    public interface c extends C0923i.c<Number> {
    }

    public C0921g(Activity activity) {
        super(activity, new Number[0]);
    }

    /* renamed from: F */
    public void m964F(int i2) {
        super.m985c((C0921g) Integer.valueOf(i2));
    }

    /* renamed from: a */
    public void m967a(int i2, int i3, int i4) {
        while (i2 <= i3) {
            m980a((C0921g) Integer.valueOf(i2));
            i2 += i4;
        }
    }

    /* renamed from: e */
    public void m968e(int i2, int i3) {
        m967a(i2, i3, 1);
    }

    public void setOnNumberPickListener(b bVar) {
        super.setOnItemPickListener(bVar);
    }

    @Deprecated
    public void setOnOptionPickListener(C0922h.a aVar) {
        setOnNumberPickListener(new a(aVar));
    }

    public void setOnWheelListener(c cVar) {
        super.setOnWheelListener((C0923i.c) cVar);
    }

    /* renamed from: a */
    public void m966a(double d2, double d3, double d4) {
        while (d2 <= d3) {
            m980a((C0921g) Double.valueOf(d2));
            d2 += d4;
        }
    }

    /* renamed from: a */
    public void m965a(double d2) {
        super.m985c((C0921g) Double.valueOf(d2));
    }
}
