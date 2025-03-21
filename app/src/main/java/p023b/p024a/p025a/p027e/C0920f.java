package p023b.p024a.p025a.p027e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p023b.p024a.p025a.p026d.InterfaceC0909g;
import p023b.p024a.p025a.p026d.InterfaceC0911i;
import p023b.p024a.p025a.p026d.InterfaceC0912j;
import p023b.p024a.p025a.p029g.C0931d;

/* compiled from: LinkagePicker.java */
/* renamed from: b.a.a.e.f */
/* loaded from: classes.dex */
public class C0920f<Fst extends InterfaceC0909g<Snd>, Snd extends InterfaceC0911i<Trd>, Trd> extends AbstractC0925k {

    /* renamed from: g0 */
    protected Fst f1463g0;

    /* renamed from: h0 */
    protected Snd f1464h0;

    /* renamed from: i0 */
    protected Trd f1465i0;

    /* renamed from: j0 */
    protected String f1466j0;

    /* renamed from: k0 */
    protected String f1467k0;

    /* renamed from: l0 */
    protected String f1468l0;

    /* renamed from: m0 */
    protected int f1469m0;

    /* renamed from: n0 */
    protected int f1470n0;

    /* renamed from: o0 */
    protected int f1471o0;

    /* renamed from: p0 */
    protected k f1472p0;

    /* renamed from: q0 */
    protected float f1473q0;

    /* renamed from: r0 */
    protected float f1474r0;

    /* renamed from: s0 */
    protected float f1475s0;

    /* renamed from: t0 */
    private g f1476t0;

    /* renamed from: u0 */
    private f f1477u0;

    /* renamed from: v0 */
    private j f1478v0;

    /* renamed from: w0 */
    private i f1479w0;

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$a */
    class a implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f1480a;

        /* renamed from: b */
        final /* synthetic */ WheelView f1481b;

        a(WheelView wheelView, WheelView wheelView2) {
            this.f1480a = wheelView;
            this.f1481b = wheelView2;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0920f c0920f = C0920f.this;
            c0920f.f1463g0 = c0920f.f1472p0.mo850a().get(i2);
            C0920f.this.f1469m0 = i2;
            C0931d.m1156c(this, "change second data after first wheeled");
            C0920f c0920f2 = C0920f.this;
            c0920f2.f1470n0 = 0;
            c0920f2.f1471o0 = 0;
            List<Snd> mo851a = c0920f2.f1472p0.mo851a(c0920f2.f1469m0);
            C0920f c0920f3 = C0920f.this;
            c0920f3.f1464h0 = mo851a.get(c0920f3.f1470n0);
            this.f1480a.m2593a((List<?>) mo851a, C0920f.this.f1470n0);
            if (!C0920f.this.f1472p0.mo853b()) {
                C0920f c0920f4 = C0920f.this;
                List<Trd> mo852a = c0920f4.f1472p0.mo852a(c0920f4.f1469m0, c0920f4.f1470n0);
                C0920f c0920f5 = C0920f.this;
                c0920f5.f1465i0 = mo852a.get(c0920f5.f1471o0);
                this.f1481b.m2593a((List<?>) mo852a, C0920f.this.f1471o0);
            }
            if (C0920f.this.f1479w0 != null) {
                C0920f.this.f1479w0.m960a(C0920f.this.f1469m0, 0, 0);
            }
            if (C0920f.this.f1478v0 != null) {
                j jVar = C0920f.this.f1478v0;
                C0920f c0920f6 = C0920f.this;
                jVar.m961a(c0920f6.f1469m0, c0920f6.f1463g0.getName());
            }
        }
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$b */
    class b implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ WheelView f1483a;

        b(WheelView wheelView) {
            this.f1483a = wheelView;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0920f c0920f = C0920f.this;
            c0920f.f1464h0 = c0920f.f1472p0.mo851a(c0920f.f1469m0).get(i2);
            C0920f c0920f2 = C0920f.this;
            c0920f2.f1470n0 = i2;
            if (!c0920f2.f1472p0.mo853b()) {
                C0931d.m1156c(this, "change third data after second wheeled");
                C0920f c0920f3 = C0920f.this;
                c0920f3.f1471o0 = 0;
                List<Trd> mo852a = c0920f3.f1472p0.mo852a(c0920f3.f1469m0, c0920f3.f1470n0);
                C0920f c0920f4 = C0920f.this;
                c0920f4.f1465i0 = mo852a.get(c0920f4.f1471o0);
                this.f1483a.m2593a((List<?>) mo852a, C0920f.this.f1471o0);
            }
            if (C0920f.this.f1479w0 != null) {
                i iVar = C0920f.this.f1479w0;
                C0920f c0920f5 = C0920f.this;
                iVar.m960a(c0920f5.f1469m0, c0920f5.f1470n0, 0);
            }
            if (C0920f.this.f1478v0 != null) {
                j jVar = C0920f.this.f1478v0;
                C0920f c0920f6 = C0920f.this;
                jVar.m962b(c0920f6.f1470n0, c0920f6.f1464h0.getName());
            }
        }
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$c */
    class c implements WheelView.InterfaceC1290g {
        c() {
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            C0920f c0920f = C0920f.this;
            c0920f.f1465i0 = c0920f.f1472p0.mo852a(c0920f.f1469m0, c0920f.f1470n0).get(i2);
            C0920f c0920f2 = C0920f.this;
            c0920f2.f1471o0 = i2;
            if (c0920f2.f1479w0 != null) {
                i iVar = C0920f.this.f1479w0;
                C0920f c0920f3 = C0920f.this;
                iVar.m960a(c0920f3.f1469m0, c0920f3.f1470n0, c0920f3.f1471o0);
            }
            if (C0920f.this.f1478v0 != null) {
                Trd trd = C0920f.this.f1465i0;
                C0920f.this.f1478v0.m963c(C0920f.this.f1471o0, trd instanceof InterfaceC0912j ? ((InterfaceC0912j) trd).getName() : trd.toString());
            }
        }
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$e */
    private static class e<Fst extends InterfaceC0909g<Snd>, Snd extends InterfaceC0911i<Trd>, Trd> implements k<Fst, Snd, Trd> {

        /* renamed from: a */
        private List<Fst> f1486a;

        /* renamed from: b */
        private List<List<Snd>> f1487b;

        /* renamed from: c */
        private List<List<List<Trd>>> f1488c;

        /* renamed from: d */
        private boolean f1489d;

        public e(List<Fst> list, List<List<Snd>> list2, List<List<List<Trd>>> list3) {
            this.f1486a = new ArrayList();
            this.f1487b = new ArrayList();
            this.f1488c = new ArrayList();
            this.f1489d = false;
            this.f1486a = list;
            this.f1487b = list2;
            if (list3 == null || list3.size() == 0) {
                this.f1489d = true;
            } else {
                this.f1488c = list3;
            }
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<Fst> mo850a() {
            return this.f1486a;
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        /* renamed from: b */
        public boolean mo853b() {
            return this.f1489d;
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<Snd> mo851a(int i2) {
            return this.f1487b.get(i2);
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<Trd> mo852a(int i2, int i3) {
            if (this.f1489d) {
                return new ArrayList();
            }
            return this.f1488c.get(i2).get(i3);
        }
    }

    /* compiled from: LinkagePicker.java */
    @Deprecated
    /* renamed from: b.a.a.e.f$f */
    public static abstract class f extends h {
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$g */
    public interface g<Fst, Snd, Trd> {
        /* renamed from: a */
        void mo958a(Fst fst, Snd snd, Trd trd);
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$h */
    public static abstract class h implements g<l, m, String> {
        /* renamed from: a */
        public abstract void m959a(String str, String str2, String str3);

        @Override // p023b.p024a.p025a.p027e.C0920f.g
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo958a(l lVar, m mVar, String str) {
            m959a(lVar.getName(), mVar.getName(), str);
        }
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$i */
    public interface i {
        /* renamed from: a */
        void m960a(int i2, int i3, int i4);
    }

    /* compiled from: LinkagePicker.java */
    @Deprecated
    /* renamed from: b.a.a.e.f$j */
    public static abstract class j {
        /* renamed from: a */
        public abstract void m961a(int i2, String str);

        /* renamed from: b */
        public abstract void m962b(int i2, String str);

        /* renamed from: c */
        public void m963c(int i2, String str) {
        }
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$k */
    public interface k<Fst extends InterfaceC0909g<Snd>, Snd extends InterfaceC0911i<Trd>, Trd> {
        @NonNull
        /* renamed from: a */
        List<Fst> mo850a();

        @NonNull
        /* renamed from: a */
        List<Snd> mo851a(int i2);

        @NonNull
        /* renamed from: a */
        List<Trd> mo852a(int i2, int i3);

        /* renamed from: b */
        boolean mo853b();
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$l */
    private static class l implements InterfaceC0909g<m> {
        private String name;
        private List<m> seconds;

        /* synthetic */ l(String str, List list, a aVar) {
            this(str, list);
        }

        @Override // p023b.p024a.p025a.p026d.InterfaceC0909g, p023b.p024a.p025a.p026d.InterfaceC0910h
        public Object getId() {
            return this.name;
        }

        @Override // p023b.p024a.p025a.p026d.InterfaceC0914l
        public String getName() {
            return this.name;
        }

        @Override // p023b.p024a.p025a.p026d.InterfaceC0909g
        public List<m> getSeconds() {
            return this.seconds;
        }

        private l(String str, List<m> list) {
            this.seconds = new ArrayList();
            this.name = str;
            this.seconds = list;
        }
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$m */
    private static class m implements InterfaceC0911i<String> {
        private String name;
        private List<String> thirds;

        /* synthetic */ m(String str, List list, a aVar) {
            this(str, list);
        }

        @Override // p023b.p024a.p025a.p026d.InterfaceC0911i, p023b.p024a.p025a.p026d.InterfaceC0910h
        public Object getId() {
            return this.name;
        }

        @Override // p023b.p024a.p025a.p026d.InterfaceC0914l
        public String getName() {
            return this.name;
        }

        @Override // p023b.p024a.p025a.p026d.InterfaceC0911i
        public List<String> getThirds() {
            return this.thirds;
        }

        private m(String str, List<String> list) {
            this.thirds = new ArrayList();
            this.name = str;
            this.thirds = list;
        }
    }

    public C0920f(Activity activity) {
        super(activity);
        this.f1466j0 = "";
        this.f1467k0 = "";
        this.f1468l0 = "";
        this.f1469m0 = 0;
        this.f1470n0 = 0;
        this.f1471o0 = 0;
        this.f1473q0 = 1.0f;
        this.f1474r0 = 1.0f;
        this.f1475s0 = 1.0f;
    }

    /* renamed from: A */
    public int m940A() {
        return this.f1470n0;
    }

    /* renamed from: B */
    public Snd m941B() {
        if (this.f1464h0 == null) {
            this.f1464h0 = this.f1472p0.mo851a(this.f1469m0).get(this.f1470n0);
        }
        return this.f1464h0;
    }

    /* renamed from: C */
    public int m942C() {
        return this.f1471o0;
    }

    /* renamed from: D */
    public Trd m943D() {
        if (this.f1465i0 == null) {
            List<Trd> mo852a = this.f1472p0.mo852a(this.f1469m0, this.f1470n0);
            if (mo852a.size() > 0) {
                this.f1465i0 = mo852a.get(this.f1471o0);
            }
        }
        return this.f1465i0;
    }

    /* renamed from: e */
    public void m952e(int i2, int i3) {
        m946a(i2, i3, 0);
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    @NonNull
    /* renamed from: r */
    protected View mo846r() {
        if (this.f1472p0 == null) {
            throw new IllegalArgumentException("please set data provider before make view");
        }
        LinearLayout linearLayout = new LinearLayout(this.f1520a);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView m1016x = m1016x();
        m1016x.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.f1473q0));
        linearLayout.addView(m1016x);
        if (!TextUtils.isEmpty(this.f1466j0)) {
            TextView m1014w = m1014w();
            m1014w.setText(this.f1466j0);
            linearLayout.addView(m1014w);
        }
        WheelView m1016x2 = m1016x();
        m1016x2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.f1474r0));
        linearLayout.addView(m1016x2);
        if (!TextUtils.isEmpty(this.f1467k0)) {
            TextView m1014w2 = m1014w();
            m1014w2.setText(this.f1467k0);
            linearLayout.addView(m1014w2);
        }
        WheelView m1016x3 = m1016x();
        if (!this.f1472p0.mo853b()) {
            m1016x3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, this.f1475s0));
            linearLayout.addView(m1016x3);
            if (!TextUtils.isEmpty(this.f1468l0)) {
                TextView m1014w3 = m1014w();
                m1014w3.setText(this.f1468l0);
                linearLayout.addView(m1014w3);
            }
        }
        m1016x.m2593a(this.f1472p0.mo850a(), this.f1469m0);
        m1016x.setOnItemSelectListener(new a(m1016x2, m1016x3));
        m1016x2.m2593a(this.f1472p0.mo851a(this.f1469m0), this.f1470n0);
        m1016x2.setOnItemSelectListener(new b(m1016x3));
        if (this.f1472p0.mo853b()) {
            return linearLayout;
        }
        m1016x3.m2593a(this.f1472p0.mo852a(this.f1469m0, this.f1470n0), this.f1471o0);
        m1016x3.setOnItemSelectListener(new c());
        return linearLayout;
    }

    @Deprecated
    public void setOnLinkageListener(f fVar) {
        this.f1477u0 = fVar;
    }

    public void setOnPickListener(g<Fst, Snd, Trd> gVar) {
        this.f1476t0 = gVar;
    }

    public void setOnStringPickListener(h hVar) {
        this.f1476t0 = hVar;
    }

    public void setOnWheelLinkageListener(i iVar) {
        this.f1479w0 = iVar;
    }

    @Deprecated
    public void setOnWheelListener(j jVar) {
        this.f1478v0 = jVar;
    }

    @Override // p023b.p024a.p025a.p028f.AbstractC0927b
    /* renamed from: v */
    public void mo847v() {
        Fst m954z = m954z();
        Snd m941B = m941B();
        Trd m943D = m943D();
        if (!this.f1472p0.mo853b()) {
            g gVar = this.f1476t0;
            if (gVar != null) {
                gVar.mo958a(m954z, m941B, m943D);
            }
            if (this.f1477u0 != null) {
                this.f1477u0.m959a(m954z.getName(), m941B.getName(), m943D instanceof InterfaceC0912j ? ((InterfaceC0912j) m943D).getName() : m943D.toString());
                return;
            }
            return;
        }
        g gVar2 = this.f1476t0;
        if (gVar2 != null) {
            gVar2.mo958a(m954z, m941B, null);
        }
        f fVar = this.f1477u0;
        if (fVar != null) {
            fVar.m959a(m954z.getName(), m941B.getName(), (String) null);
        }
    }

    /* renamed from: y */
    public int m953y() {
        return this.f1469m0;
    }

    /* renamed from: z */
    public Fst m954z() {
        if (this.f1463g0 == null) {
            this.f1463g0 = this.f1472p0.mo850a().get(this.f1469m0);
        }
        return this.f1463g0;
    }

    /* renamed from: a */
    protected void m948a(d dVar) {
        this.f1472p0 = dVar;
    }

    /* renamed from: a */
    protected void m949a(k<Fst, Snd, Trd> kVar) {
        this.f1472p0 = kVar;
    }

    /* compiled from: LinkagePicker.java */
    /* renamed from: b.a.a.e.f$d */
    public static abstract class d implements k<l, m, String> {
        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<l> mo850a() {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = m957c().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                arrayList.add(new l(it.next(), mo851a(i2), null));
                i2++;
            }
            return arrayList;
        }

        @NonNull
        /* renamed from: b */
        public abstract List<String> m955b(int i2);

        @Nullable
        /* renamed from: b */
        public abstract List<String> m956b(int i2, int i3);

        @NonNull
        /* renamed from: c */
        public abstract List<String> m957c();

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<m> mo851a(int i2) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = m955b(i2).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                arrayList.add(new m(it.next(), mo852a(i2, i3), null));
                i3++;
            }
            return arrayList;
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<String> mo852a(int i2, int i3) {
            List<String> m956b = m956b(i2, i3);
            return m956b == null ? new ArrayList() : m956b;
        }
    }

    /* renamed from: a */
    public void m946a(int i2, int i3, int i4) {
        this.f1469m0 = i2;
        this.f1470n0 = i3;
        this.f1471o0 = i4;
    }

    public C0920f(Activity activity, d dVar) {
        super(activity);
        this.f1466j0 = "";
        this.f1467k0 = "";
        this.f1468l0 = "";
        this.f1469m0 = 0;
        this.f1470n0 = 0;
        this.f1471o0 = 0;
        this.f1473q0 = 1.0f;
        this.f1474r0 = 1.0f;
        this.f1475s0 = 1.0f;
        this.f1472p0 = dVar;
    }

    /* renamed from: a */
    public void m947a(Fst fst, Snd snd) {
        mo842a((C0920f<Fst, Snd, Trd>) fst, (Fst) snd, (Snd) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a9, code lost:
    
        r6.f1470n0 = r2;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo842a(Fst r7, Snd r8, Trd r9) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p023b.p024a.p025a.p027e.C0920f.mo842a(b.a.a.d.g, b.a.a.d.i, java.lang.Object):void");
    }

    public C0920f(Activity activity, k<Fst, Snd, Trd> kVar) {
        super(activity);
        this.f1466j0 = "";
        this.f1467k0 = "";
        this.f1468l0 = "";
        this.f1469m0 = 0;
        this.f1470n0 = 0;
        this.f1471o0 = 0;
        this.f1473q0 = 1.0f;
        this.f1474r0 = 1.0f;
        this.f1475s0 = 1.0f;
        this.f1472p0 = kVar;
    }

    @Deprecated
    public C0920f(Activity activity, List<Fst> list, List<List<Snd>> list2) {
        this(activity, list, list2, null);
    }

    @Deprecated
    public C0920f(Activity activity, List<Fst> list, List<List<Snd>> list2, List<List<List<Trd>>> list3) {
        super(activity);
        this.f1466j0 = "";
        this.f1467k0 = "";
        this.f1468l0 = "";
        this.f1469m0 = 0;
        this.f1470n0 = 0;
        this.f1471o0 = 0;
        this.f1473q0 = 1.0f;
        this.f1474r0 = 1.0f;
        this.f1475s0 = 1.0f;
        this.f1472p0 = new e(list, list2, list3);
    }

    /* renamed from: a */
    public void m950a(String str, String str2) {
        m951a(str, str2, "");
    }

    /* renamed from: a */
    public void m951a(String str, String str2, String str3) {
        this.f1466j0 = str;
        this.f1467k0 = str2;
        this.f1468l0 = str3;
    }

    /* renamed from: a */
    public void m945a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2, @FloatRange(from = 0.0d, m293to = 1.0d) float f3, @FloatRange(from = 0.0d, m293to = 1.0d) float f4) {
        this.f1473q0 = f2;
        this.f1474r0 = f3;
        this.f1475s0 = f4;
    }

    /* renamed from: a */
    public void m944a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2, @FloatRange(from = 0.0d, m293to = 1.0d) float f3) {
        this.f1473q0 = f2;
        this.f1474r0 = f3;
        this.f1475s0 = 0.0f;
    }
}
