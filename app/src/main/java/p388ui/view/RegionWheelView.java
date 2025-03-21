package p388ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import bean.PcodeRegionBean;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import network.http.AddressHttp;
import p023b.p024a.p025a.p026d.C0906d;
import p023b.p024a.p025a.p026d.C0907e;
import p023b.p024a.p025a.p026d.C0913k;
import p023b.p024a.p025a.p027e.C0915a;
import p023b.p024a.p025a.p027e.C0920f;
import p023b.p024a.p025a.p029g.C0931d;
import util.C7301n1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class RegionWheelView extends LinearLayout {

    /* renamed from: a */
    protected C0913k f24630a;

    /* renamed from: b */
    protected C0906d f24631b;

    /* renamed from: c */
    protected C0907e f24632c;

    /* renamed from: d */
    protected int f24633d;

    /* renamed from: e */
    protected int f24634e;

    /* renamed from: f */
    protected int f24635f;

    /* renamed from: g */
    protected C0920f.k f24636g;

    /* renamed from: h */
    private ArrayList<C0913k> f24637h;

    /* renamed from: i */
    private WheelView.C1286c f24638i;

    /* renamed from: j */
    private WheelView f24639j;

    /* renamed from: k */
    private WheelView f24640k;

    /* renamed from: l */
    private WheelView f24641l;

    /* renamed from: ui.view.RegionWheelView$a */
    class C7190a implements C0915a.f {
        C7190a() {
        }

        @Override // p023b.p024a.p025a.p027e.C0915a.f
        /* renamed from: a */
        public void mo856a(int i2, C0913k c0913k) {
            if (c0913k != null) {
                C7301n1.m26453a("province-->" + c0913k.getAreaName());
            }
        }

        @Override // p023b.p024a.p025a.p027e.C0915a.f
        /* renamed from: a */
        public void mo854a(int i2, C0906d c0906d) {
            if (c0906d != null) {
                C7301n1.m26453a("city-->" + c0906d.getAreaName());
            }
        }

        @Override // p023b.p024a.p025a.p027e.C0915a.f
        /* renamed from: a */
        public void mo855a(int i2, C0907e c0907e) {
            if (c0907e != null) {
                C7301n1.m26453a("county-->" + c0907e.getAreaName());
            }
        }
    }

    /* renamed from: ui.view.RegionWheelView$b */
    class C7191b implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ C0915a.f f24643a;

        C7191b(C0915a.f fVar) {
            this.f24643a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f24633d = i2;
            regionWheelView.f24630a = regionWheelView.getSelectedProvince();
            C0915a.f fVar = this.f24643a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.mo856a(regionWheelView2.f24633d, regionWheelView2.f24630a);
            }
            C0931d.m1156c(this, "change cities after province wheeled: index=" + i2);
            RegionWheelView regionWheelView3 = RegionWheelView.this;
            regionWheelView3.f24634e = 0;
            regionWheelView3.f24635f = 0;
            List<?> mo851a = regionWheelView3.f24636g.mo851a(regionWheelView3.f24633d);
            if (mo851a.size() > 0) {
                RegionWheelView regionWheelView4 = RegionWheelView.this;
                regionWheelView4.f24631b = (C0906d) mo851a.get(regionWheelView4.f24634e);
                RegionWheelView.this.f24640k.m2593a(mo851a, RegionWheelView.this.f24634e);
            } else {
                RegionWheelView regionWheelView5 = RegionWheelView.this;
                regionWheelView5.f24631b = null;
                regionWheelView5.f24640k.setItems(new ArrayList());
            }
            RegionWheelView regionWheelView6 = RegionWheelView.this;
            List<?> mo852a = regionWheelView6.f24636g.mo852a(regionWheelView6.f24633d, regionWheelView6.f24634e);
            if (mo852a.size() > 0) {
                RegionWheelView regionWheelView7 = RegionWheelView.this;
                regionWheelView7.f24632c = (C0907e) mo852a.get(regionWheelView7.f24635f);
                RegionWheelView.this.f24641l.m2593a(mo852a, RegionWheelView.this.f24635f);
            } else {
                RegionWheelView regionWheelView8 = RegionWheelView.this;
                regionWheelView8.f24632c = null;
                regionWheelView8.f24641l.setItems(new ArrayList());
            }
        }
    }

    /* renamed from: ui.view.RegionWheelView$c */
    class C7192c implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ C0915a.f f24645a;

        C7192c(C0915a.f fVar) {
            this.f24645a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f24634e = i2;
            regionWheelView.f24631b = regionWheelView.getSelectedCity();
            C0915a.f fVar = this.f24645a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.mo854a(regionWheelView2.f24634e, regionWheelView2.f24631b);
            }
            C0931d.m1156c(this, "change counties after city wheeled: index=" + i2);
            RegionWheelView regionWheelView3 = RegionWheelView.this;
            regionWheelView3.f24635f = 0;
            List<?> mo852a = regionWheelView3.f24636g.mo852a(regionWheelView3.f24633d, regionWheelView3.f24634e);
            if (mo852a.size() > 0) {
                RegionWheelView regionWheelView4 = RegionWheelView.this;
                regionWheelView4.f24632c = (C0907e) mo852a.get(regionWheelView4.f24635f);
                RegionWheelView.this.f24641l.m2593a(mo852a, RegionWheelView.this.f24635f);
            } else {
                RegionWheelView regionWheelView5 = RegionWheelView.this;
                regionWheelView5.f24632c = null;
                regionWheelView5.f24641l.setItems(new ArrayList());
            }
        }
    }

    /* renamed from: ui.view.RegionWheelView$d */
    class C7193d implements WheelView.InterfaceC1290g {

        /* renamed from: a */
        final /* synthetic */ C0915a.f f24647a;

        C7193d(C0915a.f fVar) {
            this.f24647a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.InterfaceC1290g
        /* renamed from: a */
        public void mo848a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f24635f = i2;
            regionWheelView.f24632c = regionWheelView.getSelectedCounty();
            C0915a.f fVar = this.f24647a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.mo855a(regionWheelView2.f24635f, regionWheelView2.f24632c);
            }
        }
    }

    /* renamed from: ui.view.RegionWheelView$e */
    private static class C7194e implements C0920f.k<C0913k, C0906d, C0907e> {

        /* renamed from: a */
        private List<C0913k> f24649a = new ArrayList();

        /* renamed from: b */
        private List<List<C0906d>> f24650b = new ArrayList();

        /* renamed from: c */
        private List<List<List<C0907e>>> f24651c = new ArrayList();

        C7194e(List<C0913k> list) {
            m25841a(list);
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<C0913k> mo850a() {
            return this.f24649a;
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
            return this.f24650b.size() <= i2 ? new ArrayList() : this.f24650b.get(i2);
        }

        @Override // p023b.p024a.p025a.p027e.C0920f.k
        @NonNull
        /* renamed from: a */
        public List<C0907e> mo852a(int i2, int i3) {
            if (this.f24651c.size() <= i2) {
                return new ArrayList();
            }
            List<List<C0907e>> list = this.f24651c.get(i2);
            if (list.size() <= i3) {
                return new ArrayList();
            }
            return list.get(i3);
        }

        /* renamed from: a */
        private void m25841a(List<C0913k> list) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                C0913k c0913k = list.get(i2);
                this.f24649a.add(c0913k);
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
                this.f24650b.add(arrayList);
                this.f24651c.add(arrayList2);
                i2++;
                size = size;
            }
        }
    }

    public RegionWheelView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0906d getSelectedCity() {
        List<C0906d> cities = getSelectedProvince().getCities();
        if (cities.size() == 0) {
            return null;
        }
        try {
            return cities.get(this.f24634e);
        } catch (Exception unused) {
            return cities.get(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0907e getSelectedCounty() {
        C0906d selectedCity = getSelectedCity();
        if (selectedCity == null) {
            return null;
        }
        List<C0907e> counties = selectedCity.getCounties();
        if (counties.size() == 0) {
            return null;
        }
        try {
            return counties.get(this.f24635f);
        } catch (Exception unused) {
            return counties.get(0);
        }
    }

    public C0906d getCity() {
        return this.f24631b;
    }

    public C0907e getCounty() {
        return this.f24632c;
    }

    public C0913k getProvince() {
        return this.f24630a;
    }

    public C0913k getSelectedProvince() {
        try {
            return this.f24637h.get(this.f24633d);
        } catch (Exception unused) {
            return new C0913k();
        }
    }

    public void setSelectIndex(PcodeRegionBean pcodeRegionBean) {
        ArrayList<C0913k> arrayList;
        if (pcodeRegionBean == null || this.f24636g == null || (arrayList = this.f24637h) == null || arrayList.size() <= 0) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f24637h.size(); i3++) {
            if (TextUtils.equals(this.f24637h.get(i3).getAreaId(), pcodeRegionBean.getProvinceId())) {
                this.f24633d = i3;
                WheelView wheelView = this.f24639j;
                if (wheelView != null) {
                    wheelView.m2593a(this.f24636g.mo850a(), this.f24633d);
                }
                List mo851a = this.f24636g.mo851a(i3);
                if (mo851a == null || mo851a.size() <= 0) {
                    return;
                }
                String cityId = pcodeRegionBean.getCityId();
                for (int i4 = 0; i4 < mo851a.size(); i4++) {
                    if (TextUtils.equals(((C0906d) mo851a.get(i4)).getAreaId(), cityId)) {
                        this.f24634e = i4;
                        WheelView wheelView2 = this.f24640k;
                        if (wheelView2 != null) {
                            wheelView2.m2593a(this.f24636g.mo851a(this.f24633d), this.f24634e);
                        }
                        List mo852a = this.f24636g.mo852a(i3, i4);
                        if (mo852a == null || mo852a.size() <= 0) {
                            return;
                        }
                        String districtId = pcodeRegionBean.getDistrictId();
                        while (true) {
                            if (i2 >= mo852a.size()) {
                                break;
                            }
                            if (TextUtils.equals(((C0907e) mo852a.get(i2)).getAreaId(), districtId)) {
                                this.f24635f = i2;
                                this.f24632c = (C0907e) mo852a.get(i2);
                                break;
                            }
                            i2++;
                        }
                        WheelView wheelView3 = this.f24641l;
                        if (wheelView3 != null) {
                            wheelView3.m2593a(this.f24636g.mo852a(this.f24633d, this.f24634e), this.f24635f);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
    }

    public RegionWheelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24630a = null;
        this.f24631b = null;
        this.f24632c = null;
        this.f24633d = 0;
        this.f24634e = 0;
        this.f24635f = 0;
        this.f24637h = new ArrayList<>();
        this.f24638i = new WheelView.C1286c();
        m25834b(context);
    }

    /* renamed from: b */
    private void m25834b(Context context) {
        this.f24637h = AddressHttp.getAddSint(null).getPickData();
        this.f24636g = new C7194e(this.f24637h);
        addView(m25837a(context, new C7190a()));
    }

    /* renamed from: a */
    public void m25839a() {
        m25840a(AddressHttp.getAddSint(null).getPickData());
    }

    /* renamed from: a */
    public void m25840a(ArrayList<C0913k> arrayList) {
        String str;
        String str2 = "";
        if (arrayList != null || arrayList.size() > 0) {
            C0907e county = getCounty();
            this.f24637h = arrayList;
            this.f24636g = new C7194e(this.f24637h);
            if (this.f24639j == null || this.f24640k == null || this.f24641l == null) {
                return;
            }
            try {
                str = this.f24637h.get(this.f24633d).getCities().get(this.f24634e).getCounties().get(this.f24635f).getAreaName();
                try {
                    str2 = this.f24637h.get(this.f24633d).getCities().get(this.f24634e).getCounties().get(this.f24635f).getAreaId();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (county != null) {
                        this.f24633d = 0;
                        this.f24634e = 0;
                        this.f24635f = 0;
                        C7331w1.m26688a("请重新选择");
                    }
                    this.f24639j.m2593a(this.f24636g.mo850a(), this.f24633d);
                    this.f24640k.m2593a(this.f24636g.mo851a(this.f24633d), this.f24634e);
                    this.f24641l.m2593a(this.f24636g.mo852a(this.f24633d, this.f24634e), this.f24635f);
                }
            } catch (Exception e3) {
                e = e3;
                str = "";
            }
            if (county != null && (!TextUtils.equals(county.getAreaName(), str) || !TextUtils.equals(county.getAreaId(), str2))) {
                this.f24633d = 0;
                this.f24634e = 0;
                this.f24635f = 0;
                C7331w1.m26688a("请重新选择");
            }
            this.f24639j.m2593a(this.f24636g.mo850a(), this.f24633d);
            this.f24640k.m2593a(this.f24636g.mo851a(this.f24633d), this.f24634e);
            this.f24641l.m2593a(this.f24636g.mo852a(this.f24633d, this.f24634e), this.f24635f);
        }
    }

    /* renamed from: b */
    private void m25833b() {
        this.f24638i.m2599a(true);
        this.f24638i.m2604d(-1);
        this.f24638i.m2603c(100);
        this.f24638i.m2602b(true);
        this.f24638i.m2597a(0.0f);
    }

    /* renamed from: a */
    protected WheelView m25838a(Context context) {
        WheelView wheelView = new WheelView(context);
        wheelView.setLineSpaceMultiplier(2.0f);
        wheelView.setTextPadding(-1);
        wheelView.setTextSize(16.0f);
        wheelView.setTypeface(Typeface.DEFAULT);
        wheelView.m2591a(WheelView.f2878i0, ViewCompat.MEASURED_STATE_MASK);
        wheelView.setDividerConfig(this.f24638i);
        wheelView.setOffset(4);
        wheelView.setCycleDisable(true);
        wheelView.setUseWeight(true);
        wheelView.setTextSizeAutoFit(true);
        return wheelView;
    }

    public void setSelectIndex(String str) {
        try {
            if (str.length() == 6) {
                PcodeRegionBean pcodeRegionBean = new PcodeRegionBean();
                pcodeRegionBean.setProvinceId(str.substring(0, 2));
                pcodeRegionBean.setCityId(str.substring(0, 4));
                pcodeRegionBean.setDistrictId(str);
                setSelectIndex(pcodeRegionBean);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    protected View m25837a(Context context, C0915a.f fVar) {
        m25833b();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f24639j = m25838a(context);
        this.f24639j.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f24639j);
        this.f24640k = m25838a(context);
        this.f24640k.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f24640k);
        this.f24641l = m25838a(context);
        this.f24641l.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f24641l);
        this.f24639j.m2593a(this.f24636g.mo850a(), this.f24633d);
        this.f24639j.setOnItemSelectListener(new C7191b(fVar));
        this.f24640k.m2593a(this.f24636g.mo851a(this.f24633d), this.f24634e);
        this.f24640k.setOnItemSelectListener(new C7192c(fVar));
        this.f24641l.m2593a(this.f24636g.mo852a(this.f24633d, this.f24634e), this.f24635f);
        this.f24641l.setOnItemSelectListener(new C7193d(fVar));
        if (this.f24631b == null && this.f24636g.mo851a(0).size() > 0) {
            this.f24631b = (C0906d) this.f24636g.mo851a(0).get(0);
        }
        if (this.f24632c == null && this.f24636g.mo852a(0, 0).size() > 0) {
            this.f24632c = (C0907e) this.f24636g.mo852a(0, 0).get(0);
        }
        return linearLayout;
    }
}
