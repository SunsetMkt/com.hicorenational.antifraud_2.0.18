package p023b.p024a.p025a.p027e;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import p023b.p024a.p025a.p026d.C0906d;
import p023b.p024a.p025a.p026d.C0907e;
import p023b.p024a.p025a.p026d.C0913k;
import p023b.p024a.p025a.p027e.C0920f;
import p023b.p024a.p025a.p029g.C0931d;

/* compiled from: AddressPicker.java */
/* renamed from: b.a.a.e.a */
/* loaded from: classes.dex */
public class C0915a extends C0920f<C0913k, C0906d, C0907e> {

    /* renamed from: A0 */
    private boolean f1378A0;

    /* renamed from: B0 */
    private ArrayList<C0913k> f1379B0;

    /* renamed from: x0 */
    private e f1380x0;

    /* renamed from: y0 */
    private f f1381y0;

    /* renamed from: z0 */
    private boolean f1382z0;

    /* compiled from: AddressPicker.java */
    /* renamed from: b.a.a.e.a$a */
    class a implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f1383a;

        /* renamed from: b */
        final /* synthetic */ WheelView f1384b;

        a(WheelView wheelView, WheelView wheelView2) {
            this.f1383a = wheelView;
            this.f1384b = wheelView2;
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [Trd, java.lang.Object] */
        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0915a c0915a = C0915a.this;
            c0915a.f1469m0 = i2;
            c0915a.f1463g0 = c0915a.m841G();
            if (C0915a.this.f1381y0 != null) {
                f fVar = C0915a.this.f1381y0;
                C0915a c0915a2 = C0915a.this;
                fVar.mo856a(c0915a2.f1469m0, (C0913k) c0915a2.f1463g0);
            }
            C0931d.m1156c(this, "change cities after province wheeled: index=" + i2);
            C0915a c0915a3 = C0915a.this;
            c0915a3.f1470n0 = 0;
            c0915a3.f1471o0 = 0;
            List<?> mo851a = c0915a3.f1472p0.mo851a(c0915a3.f1469m0);
            if (mo851a.size() > 0) {
                C0915a c0915a4 = C0915a.this;
                c0915a4.f1464h0 = (Snd) mo851a.get(c0915a4.f1470n0);
                this.f1383a.m2593a(mo851a, C0915a.this.f1470n0);
            } else {
                C0915a.this.f1464h0 = null;
                this.f1383a.setItems(new ArrayList());
            }
            C0915a c0915a5 = C0915a.this;
            List<?> mo852a = c0915a5.f1472p0.mo852a(c0915a5.f1469m0, c0915a5.f1470n0);
            if (mo852a.size() <= 0) {
                C0915a.this.f1465i0 = null;
                this.f1384b.setItems(new ArrayList());
            } else {
                C0915a c0915a6 = C0915a.this;
                c0915a6.f1465i0 = mo852a.get(c0915a6.f1471o0);
                this.f1384b.m2593a(mo852a, C0915a.this.f1471o0);
            }
        }
    }

    /* compiled from: AddressPicker.java */
    /* renamed from: b.a.a.e.a$b */
    class b implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f1386a;

        b(WheelView wheelView) {
            this.f1386a = wheelView;
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [Trd, java.lang.Object] */
        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0915a c0915a = C0915a.this;
            c0915a.f1470n0 = i2;
            c0915a.f1464h0 = c0915a.m839E();
            if (C0915a.this.f1381y0 != null) {
                f fVar = C0915a.this.f1381y0;
                C0915a c0915a2 = C0915a.this;
                fVar.mo854a(c0915a2.f1470n0, (C0906d) c0915a2.f1464h0);
            }
            C0931d.m1156c(this, "change counties after city wheeled: index=" + i2);
            C0915a c0915a3 = C0915a.this;
            c0915a3.f1471o0 = 0;
            List<?> mo852a = c0915a3.f1472p0.mo852a(c0915a3.f1469m0, c0915a3.f1470n0);
            if (mo852a.size() <= 0) {
                C0915a.this.f1465i0 = null;
                this.f1386a.setItems(new ArrayList());
            } else {
                C0915a c0915a4 = C0915a.this;
                c0915a4.f1465i0 = mo852a.get(c0915a4.f1471o0);
                this.f1386a.m2593a(mo852a, C0915a.this.f1471o0);
            }
        }
    }

    /* compiled from: AddressPicker.java */
    /* renamed from: b.a.a.e.a$c */
    class c implements WheelView.InterfaceC1290g {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [Trd, b.a.a.d.e] */
        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0915a c0915a = C0915a.this;
            c0915a.f1471o0 = i2;
            c0915a.f1465i0 = c0915a.m840F();
            if (C0915a.this.f1381y0 != null) {
                f fVar = C0915a.this.f1381y0;
                C0915a c0915a2 = C0915a.this;
                fVar.mo855a(c0915a2.f1471o0, (C0907e) c0915a2.f1465i0);
            }
        }
    }

    /* compiled from: AddressPicker.java */
    /* renamed from: b.a.a.e.a$d */
    private static class d implements C0920f.k<C0913k, C0906d, C0907e> {

        /* renamed from: a */
        private List<C0913k> f1389a = new ArrayList();

        /* renamed from: b */
        private List<List<C0906d>> f1390b = new ArrayList();

        /* renamed from: c */
        private List<List<List<C0907e>>> f1391c = new ArrayList();

        d(List<C0913k> list) {
            m849a(list);
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<C0913k> mo850a() {
            return this.f1389a;
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        /* renamed from: b */
        public boolean mo853b() {
            return false;
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<C0906d> mo851a(int i2) {
            return this.f1390b.size() <= i2 ? new ArrayList() : this.f1390b.get(i2);
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<C0907e> mo852a(int i2, int i3) {
            if (this.f1391c.size() <= i2) {
                return new ArrayList();
            }
            List<List<C0907e>> list = this.f1391c.get(i2);
            if (list.size() <= i3) {
                return new ArrayList();
            }
            return list.get(i3);
        }

        /* renamed from: a */
        private void m849a(List<C0913k> list) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                C0913k c0913k = list.get(i2);
                this.f1389a.add(c0913k);
                List<C0906d> cities = c0913k.getCities();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size2 = cities.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C0906d c0906d = cities.get(i3);
                    c0906d.setProvinceId(c0913k.getAreaId());
                    arrayList.add(c0906d);
                    List<C0907e> counties = c0906d.getCounties();
                    ArrayList arrayList3 = new ArrayList();
                    int size3 = counties.size();
                    int i4 = 0;
                    while (i4 < size3) {
                        C0907e c0907e = counties.get(i4);
                        c0907e.setCityId(c0906d.getAreaId());
                        arrayList3.add(c0907e);
                        i4++;
                        size = size;
                    }
                    arrayList2.add(arrayList3);
                }
                this.f1390b.add(arrayList);
                this.f1391c.add(arrayList2);
                i2++;
                size = size;
            }
        }
    }

    /* compiled from: AddressPicker.java */
    /* renamed from: b.a.a.e.a$e */
    public interface e {
        void onAddressPicked(C0913k c0913k, C0906d c0906d, C0907e c0907e);
    }

    /* compiled from: AddressPicker.java */
    /* renamed from: b.a.a.e.a$f */
    public interface f {
        /* renamed from: a */
        void mo854a(int i2, C0906d c0906d);

        /* renamed from: a */
        void mo855a(int i2, C0907e c0907e);

        /* renamed from: a */
        void mo856a(int i2, C0913k c0913k);
    }

    public C0915a(Activity activity, ArrayList<C0913k> arrayList) {
        super(activity, new d(arrayList));
        this.f1382z0 = false;
        this.f1378A0 = false;
        this.f1379B0 = new ArrayList<>();
        this.f1379B0 = arrayList;
    }

    @Nullable
    /* renamed from: E */
    public C0906d m839E() {
        List<C0906d> cities = m841G().getCities();
        if (cities.size() == 0) {
            return null;
        }
        return cities.get(this.f1470n0);
    }

    @Nullable
    /* renamed from: F */
    public C0907e m840F() {
        C0906d m839E = m839E();
        if (m839E == null) {
            return null;
        }
        List<C0907e> counties = m839E.getCounties();
        if (counties.size() == 0) {
            return null;
        }
        return counties.get(this.f1471o0);
    }

    @NonNull
    /* renamed from: G */
    public C0913k m841G() {
        return this.f1379B0.get(this.f1469m0);
    }

    /* renamed from: b */
    public void m843b(String str, String str2, String str3) {
        mo842a(new C0913k(str), new C0906d(str2), new C0907e(str3));
    }

    /* renamed from: o */
    public void m844o(boolean z) {
        this.f1378A0 = z;
    }

    /* renamed from: p */
    public void m845p(boolean z) {
        this.f1382z0 = z;
    }

    @Override // p023b.p024a.p025a.p027e.C0920f, p023b.p024a.p025a.p028f.AbstractC0927b
    @NonNull
    /* renamed from: r */
    protected View mo846r() {
        if (this.f1472p0 == null) {
            throw new IllegalArgumentException("please set address provider before make view");
        }
        float f2 = this.f1473q0;
        float f3 = this.f1474r0;
        float f4 = this.f1475s0;
        if (this.f1378A0) {
            this.f1382z0 = false;
        }
        if (this.f1382z0) {
            f3 = this.f1473q0;
            f4 = this.f1474r0;
            f2 = 0.0f;
        }
        this.f1517f0.m2597a(0.0f);
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView m1016x = m1016x();
        m1016x.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f2));
        linearLayout.addView(m1016x);
        if (this.f1382z0) {
            m1016x.setVisibility(8);
        }
        WheelView m1016x2 = m1016x();
        m1016x2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f3));
        linearLayout.addView(m1016x2);
        WheelView m1016x3 = m1016x();
        m1016x3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f4));
        linearLayout.addView(m1016x3);
        if (this.f1378A0) {
            m1016x3.setVisibility(8);
        }
        m1016x.m2593a(this.f1472p0.mo850a(), this.f1469m0);
        m1016x.setOnItemSelectListener(new a(m1016x2, m1016x3));
        m1016x2.m2593a(this.f1472p0.mo851a(this.f1469m0), this.f1470n0);
        m1016x2.setOnItemSelectListener(new b(m1016x3));
        m1016x3.m2593a(this.f1472p0.mo852a(this.f1469m0, this.f1470n0), this.f1471o0);
        m1016x3.setOnItemSelectListener(new c());
        return linearLayout;
    }

    public void setOnAddressPickListener(e eVar) {
        this.f1380x0 = eVar;
    }

    @Override // p023b.p024a.p025a.p027e.C0920f
    @Deprecated
    public final void setOnLinkageListener(C0920f.f fVar) {
        throw new UnsupportedOperationException("Please use setOnAddressPickListener instead.");
    }

    public void setOnWheelListener(f fVar) {
        this.f1381y0 = fVar;
    }

    @Override // p023b.p024a.p025a.p027e.C0920f, p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: v */
    public void mo847v() {
        if (this.f1380x0 != null) {
            this.f1380x0.onAddressPicked(m841G(), m839E(), this.f1378A0 ? null : m840F());
        }
    }

    @Override // p023b.p024a.p025a.p027e.C0920f
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo842a(C0913k c0913k, C0906d c0906d, C0907e c0907e) {
        super.mo842a((C0915a) c0913k, (C0913k) c0906d, (C0906d) c0907e);
    }
}
