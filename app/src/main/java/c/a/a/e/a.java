package c.a.a.e;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a.e.f;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AddressPicker.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c.a.a.e.f<c.a.a.d.k, c.a.a.d.d, c.a.a.d.e> {
    private boolean A0;
    private ArrayList<c.a.a.d.k> B0;
    private e x0;
    private f y0;
    private boolean z0;

    /* JADX INFO: renamed from: c.a.a.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AddressPicker.java */
    class C0025a implements WheelView.g {
        final /* synthetic */ WheelView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ WheelView f1919b;

        C0025a(WheelView wheelView, WheelView wheelView2) {
            this.a = wheelView;
            this.f1919b = wheelView2;
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [Trd, java.lang.Object] */
        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            a aVar = a.this;
            aVar.m0 = i2;
            aVar.g0 = aVar.G();
            if (a.this.y0 != null) {
                f fVar = a.this.y0;
                a aVar2 = a.this;
                fVar.a(aVar2.m0, (c.a.a.d.k) aVar2.g0);
            }
            c.a.a.g.d.c(this, "change cities after province wheeled: index=" + i2);
            a aVar3 = a.this;
            aVar3.n0 = 0;
            aVar3.o0 = 0;
            List<?> listA = aVar3.p0.a(aVar3.m0);
            if (listA.size() > 0) {
                a aVar4 = a.this;
                aVar4.h0 = (Snd) listA.get(aVar4.n0);
                this.a.a(listA, a.this.n0);
            } else {
                a.this.h0 = null;
                this.a.setItems(new ArrayList());
            }
            a aVar5 = a.this;
            List<?> listA2 = aVar5.p0.a(aVar5.m0, aVar5.n0);
            if (listA2.size() <= 0) {
                a.this.i0 = null;
                this.f1919b.setItems(new ArrayList());
            } else {
                a aVar6 = a.this;
                aVar6.i0 = listA2.get(aVar6.o0);
                this.f1919b.a(listA2, a.this.o0);
            }
        }
    }

    /* JADX INFO: compiled from: AddressPicker.java */
    class b implements WheelView.g {
        final /* synthetic */ WheelView a;

        b(WheelView wheelView) {
            this.a = wheelView;
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [Trd, java.lang.Object] */
        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            a aVar = a.this;
            aVar.n0 = i2;
            aVar.h0 = aVar.E();
            if (a.this.y0 != null) {
                f fVar = a.this.y0;
                a aVar2 = a.this;
                fVar.a(aVar2.n0, (c.a.a.d.d) aVar2.h0);
            }
            c.a.a.g.d.c(this, "change counties after city wheeled: index=" + i2);
            a aVar3 = a.this;
            aVar3.o0 = 0;
            List<?> listA = aVar3.p0.a(aVar3.m0, aVar3.n0);
            if (listA.size() <= 0) {
                a.this.i0 = null;
                this.a.setItems(new ArrayList());
            } else {
                a aVar4 = a.this;
                aVar4.i0 = listA.get(aVar4.o0);
                this.a.a(listA, a.this.o0);
            }
        }
    }

    /* JADX INFO: compiled from: AddressPicker.java */
    class c implements WheelView.g {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [Trd, c.a.a.d.e] */
        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            a aVar = a.this;
            aVar.o0 = i2;
            aVar.i0 = aVar.F();
            if (a.this.y0 != null) {
                f fVar = a.this.y0;
                a aVar2 = a.this;
                fVar.a(aVar2.o0, (c.a.a.d.e) aVar2.i0);
            }
        }
    }

    /* JADX INFO: compiled from: AddressPicker.java */
    private static class d implements f.k<c.a.a.d.k, c.a.a.d.d, c.a.a.d.e> {
        private List<c.a.a.d.k> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<List<c.a.a.d.d>> f1922b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<List<List<c.a.a.d.e>>> f1923c = new ArrayList();

        d(List<c.a.a.d.k> list) {
            a(list);
        }

        @Override // c.a.a.e.f.k
        @NonNull
        public List<c.a.a.d.k> a() {
            return this.a;
        }

        @Override // c.a.a.e.f.k
        public boolean b() {
            return false;
        }

        @Override // c.a.a.e.f.k
        @NonNull
        public List<c.a.a.d.d> a(int i2) {
            return this.f1922b.size() <= i2 ? new ArrayList() : this.f1922b.get(i2);
        }

        @Override // c.a.a.e.f.k
        @NonNull
        public List<c.a.a.d.e> a(int i2, int i3) {
            if (this.f1923c.size() <= i2) {
                return new ArrayList();
            }
            List<List<c.a.a.d.e>> list = this.f1923c.get(i2);
            if (list.size() <= i3) {
                return new ArrayList();
            }
            return list.get(i3);
        }

        private void a(List<c.a.a.d.k> list) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                c.a.a.d.k kVar = list.get(i2);
                this.a.add(kVar);
                List<c.a.a.d.d> cities = kVar.getCities();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size2 = cities.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    c.a.a.d.d dVar = cities.get(i3);
                    dVar.setProvinceId(kVar.getAreaId());
                    arrayList.add(dVar);
                    List<c.a.a.d.e> counties = dVar.getCounties();
                    ArrayList arrayList3 = new ArrayList();
                    int size3 = counties.size();
                    int i4 = 0;
                    while (i4 < size3) {
                        c.a.a.d.e eVar = counties.get(i4);
                        eVar.setCityId(dVar.getAreaId());
                        arrayList3.add(eVar);
                        i4++;
                        size = size;
                    }
                    arrayList2.add(arrayList3);
                }
                this.f1922b.add(arrayList);
                this.f1923c.add(arrayList2);
                i2++;
                size = size;
            }
        }
    }

    /* JADX INFO: compiled from: AddressPicker.java */
    public interface e {
        void onAddressPicked(c.a.a.d.k kVar, c.a.a.d.d dVar, c.a.a.d.e eVar);
    }

    /* JADX INFO: compiled from: AddressPicker.java */
    public interface f {
        void a(int i2, c.a.a.d.d dVar);

        void a(int i2, c.a.a.d.e eVar);

        void a(int i2, c.a.a.d.k kVar);
    }

    public a(Activity activity, ArrayList<c.a.a.d.k> arrayList) {
        super(activity, new d(arrayList));
        this.z0 = false;
        this.A0 = false;
        this.B0 = new ArrayList<>();
        this.B0 = arrayList;
    }

    @Nullable
    public c.a.a.d.d E() {
        List<c.a.a.d.d> cities = G().getCities();
        if (cities.size() == 0) {
            return null;
        }
        return cities.get(this.n0);
    }

    @Nullable
    public c.a.a.d.e F() {
        c.a.a.d.d dVarE = E();
        if (dVarE == null) {
            return null;
        }
        List<c.a.a.d.e> counties = dVarE.getCounties();
        if (counties.size() == 0) {
            return null;
        }
        return counties.get(this.o0);
    }

    @NonNull
    public c.a.a.d.k G() {
        return this.B0.get(this.m0);
    }

    public void b(String str, String str2, String str3) {
        a(new c.a.a.d.k(str), new c.a.a.d.d(str2), new c.a.a.d.e(str3));
    }

    public void o(boolean z) {
        this.A0 = z;
    }

    public void p(boolean z) {
        this.z0 = z;
    }

    @Override // c.a.a.e.f, c.a.a.f.b
    @NonNull
    protected View r() {
        if (this.p0 == null) {
            throw new IllegalArgumentException("please set address provider before make view");
        }
        float f2 = this.q0;
        float f3 = this.r0;
        float f4 = this.s0;
        if (this.A0) {
            this.z0 = false;
        }
        if (this.z0) {
            f3 = this.q0;
            f4 = this.r0;
            f2 = 0.0f;
        }
        this.f0.a(0.0f);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView wheelViewX = x();
        wheelViewX.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f2));
        linearLayout.addView(wheelViewX);
        if (this.z0) {
            wheelViewX.setVisibility(8);
        }
        WheelView wheelViewX2 = x();
        wheelViewX2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f3));
        linearLayout.addView(wheelViewX2);
        WheelView wheelViewX3 = x();
        wheelViewX3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, f4));
        linearLayout.addView(wheelViewX3);
        if (this.A0) {
            wheelViewX3.setVisibility(8);
        }
        wheelViewX.a(this.p0.a(), this.m0);
        wheelViewX.setOnItemSelectListener(new C0025a(wheelViewX2, wheelViewX3));
        wheelViewX2.a(this.p0.a(this.m0), this.n0);
        wheelViewX2.setOnItemSelectListener(new b(wheelViewX3));
        wheelViewX3.a(this.p0.a(this.m0, this.n0), this.o0);
        wheelViewX3.setOnItemSelectListener(new c());
        return linearLayout;
    }

    public void setOnAddressPickListener(e eVar) {
        this.x0 = eVar;
    }

    @Override // c.a.a.e.f
    @Deprecated
    public final void setOnLinkageListener(f.AbstractC0028f abstractC0028f) {
        throw new UnsupportedOperationException("Please use setOnAddressPickListener instead.");
    }

    public void setOnWheelListener(f fVar) {
        this.y0 = fVar;
    }

    @Override // c.a.a.e.f, c.a.a.f.b
    public void v() {
        if (this.x0 != null) {
            this.x0.onAddressPicked(G(), E(), this.A0 ? null : F());
        }
    }

    @Override // c.a.a.e.f
    public void a(c.a.a.d.k kVar, c.a.a.d.d dVar, c.a.a.d.e eVar) {
        super.a(kVar, dVar, eVar);
    }
}
