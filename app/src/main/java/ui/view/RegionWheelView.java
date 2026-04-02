package ui.view;

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
import c.a.a.e.a;
import c.a.a.e.f;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;
import network.http.AddressHttp;
import util.e2;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class RegionWheelView extends LinearLayout {
    protected c.a.a.d.k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c.a.a.d.d f14599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected c.a.a.d.e f14600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f14601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f14602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f14603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected f.k f14604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<c.a.a.d.k> f14605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WheelView.c f14606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WheelView f14607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private WheelView f14608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WheelView f14609l;

    class a implements a.f {
        a() {
        }

        @Override // c.a.a.e.a.f
        public void a(int i2, c.a.a.d.k kVar) {
            if (kVar != null) {
                s1.a("province-->" + kVar.getAreaName());
            }
        }

        @Override // c.a.a.e.a.f
        public void a(int i2, c.a.a.d.d dVar) {
            if (dVar != null) {
                s1.a("city-->" + dVar.getAreaName());
            }
        }

        @Override // c.a.a.e.a.f
        public void a(int i2, c.a.a.d.e eVar) {
            if (eVar != null) {
                s1.a("county-->" + eVar.getAreaName());
            }
        }
    }

    class b implements WheelView.g {
        final /* synthetic */ a.f a;

        b(a.f fVar) {
            this.a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f14601d = i2;
            regionWheelView.a = regionWheelView.getSelectedProvince();
            a.f fVar = this.a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.a(regionWheelView2.f14601d, regionWheelView2.a);
            }
            c.a.a.g.d.c(this, "change cities after province wheeled: index=" + i2);
            RegionWheelView regionWheelView3 = RegionWheelView.this;
            regionWheelView3.f14602e = 0;
            regionWheelView3.f14603f = 0;
            List<?> listA = regionWheelView3.f14604g.a(regionWheelView3.f14601d);
            if (listA.size() > 0) {
                RegionWheelView regionWheelView4 = RegionWheelView.this;
                regionWheelView4.f14599b = (c.a.a.d.d) listA.get(regionWheelView4.f14602e);
                RegionWheelView.this.f14608k.a(listA, RegionWheelView.this.f14602e);
            } else {
                RegionWheelView regionWheelView5 = RegionWheelView.this;
                regionWheelView5.f14599b = null;
                regionWheelView5.f14608k.setItems(new ArrayList());
            }
            RegionWheelView regionWheelView6 = RegionWheelView.this;
            List<?> listA2 = regionWheelView6.f14604g.a(regionWheelView6.f14601d, regionWheelView6.f14602e);
            if (listA2.size() > 0) {
                RegionWheelView regionWheelView7 = RegionWheelView.this;
                regionWheelView7.f14600c = (c.a.a.d.e) listA2.get(regionWheelView7.f14603f);
                RegionWheelView.this.f14609l.a(listA2, RegionWheelView.this.f14603f);
            } else {
                RegionWheelView regionWheelView8 = RegionWheelView.this;
                regionWheelView8.f14600c = null;
                regionWheelView8.f14609l.setItems(new ArrayList());
            }
        }
    }

    class c implements WheelView.g {
        final /* synthetic */ a.f a;

        c(a.f fVar) {
            this.a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f14602e = i2;
            regionWheelView.f14599b = regionWheelView.getSelectedCity();
            a.f fVar = this.a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.a(regionWheelView2.f14602e, regionWheelView2.f14599b);
            }
            c.a.a.g.d.c(this, "change counties after city wheeled: index=" + i2);
            RegionWheelView regionWheelView3 = RegionWheelView.this;
            regionWheelView3.f14603f = 0;
            List<?> listA = regionWheelView3.f14604g.a(regionWheelView3.f14601d, regionWheelView3.f14602e);
            if (listA.size() > 0) {
                RegionWheelView regionWheelView4 = RegionWheelView.this;
                regionWheelView4.f14600c = (c.a.a.d.e) listA.get(regionWheelView4.f14603f);
                RegionWheelView.this.f14609l.a(listA, RegionWheelView.this.f14603f);
            } else {
                RegionWheelView regionWheelView5 = RegionWheelView.this;
                regionWheelView5.f14600c = null;
                regionWheelView5.f14609l.setItems(new ArrayList());
            }
        }
    }

    class d implements WheelView.g {
        final /* synthetic */ a.f a;

        d(a.f fVar) {
            this.a = fVar;
        }

        @Override // cn.qqtheme.framework.widget.WheelView.g
        public void a(int i2) {
            RegionWheelView regionWheelView = RegionWheelView.this;
            regionWheelView.f14603f = i2;
            regionWheelView.f14600c = regionWheelView.getSelectedCounty();
            a.f fVar = this.a;
            if (fVar != null) {
                RegionWheelView regionWheelView2 = RegionWheelView.this;
                fVar.a(regionWheelView2.f14603f, regionWheelView2.f14600c);
            }
        }
    }

    private static class e implements f.k<c.a.a.d.k, c.a.a.d.d, c.a.a.d.e> {
        private List<c.a.a.d.k> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<List<c.a.a.d.d>> f14613b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<List<List<c.a.a.d.e>>> f14614c = new ArrayList();

        e(List<c.a.a.d.k> list) {
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
            return this.f14613b.size() <= i2 ? new ArrayList() : this.f14613b.get(i2);
        }

        @Override // c.a.a.e.f.k
        @NonNull
        public List<c.a.a.d.e> a(int i2, int i3) {
            if (this.f14614c.size() <= i2) {
                return new ArrayList();
            }
            List<List<c.a.a.d.e>> list = this.f14614c.get(i2);
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
                this.f14613b.add(arrayList);
                this.f14614c.add(arrayList2);
                i2++;
                size = size;
            }
        }
    }

    public RegionWheelView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a.a.d.d getSelectedCity() {
        List<c.a.a.d.d> cities = getSelectedProvince().getCities();
        if (cities.size() == 0) {
            return null;
        }
        try {
            return cities.get(this.f14602e);
        } catch (Exception unused) {
            return cities.get(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a.a.d.e getSelectedCounty() {
        c.a.a.d.d selectedCity = getSelectedCity();
        if (selectedCity == null) {
            return null;
        }
        List<c.a.a.d.e> counties = selectedCity.getCounties();
        if (counties.size() == 0) {
            return null;
        }
        try {
            return counties.get(this.f14603f);
        } catch (Exception unused) {
            return counties.get(0);
        }
    }

    public c.a.a.d.d getCity() {
        return this.f14599b;
    }

    public c.a.a.d.e getCounty() {
        return this.f14600c;
    }

    public c.a.a.d.k getProvince() {
        return this.a;
    }

    public c.a.a.d.k getSelectedProvince() {
        try {
            return this.f14605h.get(this.f14601d);
        } catch (Exception unused) {
            return new c.a.a.d.k();
        }
    }

    public void setSelectIndex(PcodeRegionBean pcodeRegionBean) {
        ArrayList<c.a.a.d.k> arrayList;
        if (pcodeRegionBean == null || this.f14604g == null || (arrayList = this.f14605h) == null || arrayList.size() <= 0) {
            return;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14605h.size(); i3++) {
            if (TextUtils.equals(this.f14605h.get(i3).getAreaId(), pcodeRegionBean.getProvinceId())) {
                this.f14601d = i3;
                WheelView wheelView = this.f14607j;
                if (wheelView != null) {
                    wheelView.a(this.f14604g.a(), this.f14601d);
                }
                List listA = this.f14604g.a(i3);
                if (listA == null || listA.size() <= 0) {
                    return;
                }
                String cityId = pcodeRegionBean.getCityId();
                for (int i4 = 0; i4 < listA.size(); i4++) {
                    if (TextUtils.equals(((c.a.a.d.d) listA.get(i4)).getAreaId(), cityId)) {
                        this.f14602e = i4;
                        WheelView wheelView2 = this.f14608k;
                        if (wheelView2 != null) {
                            wheelView2.a(this.f14604g.a(this.f14601d), this.f14602e);
                        }
                        List listA2 = this.f14604g.a(i3, i4);
                        if (listA2 == null || listA2.size() <= 0) {
                            return;
                        }
                        String districtId = pcodeRegionBean.getDistrictId();
                        while (true) {
                            if (i2 >= listA2.size()) {
                                break;
                            }
                            if (TextUtils.equals(((c.a.a.d.e) listA2.get(i2)).getAreaId(), districtId)) {
                                this.f14603f = i2;
                                this.f14600c = (c.a.a.d.e) listA2.get(i2);
                                break;
                            }
                            i2++;
                        }
                        WheelView wheelView3 = this.f14609l;
                        if (wheelView3 != null) {
                            wheelView3.a(this.f14604g.a(this.f14601d, this.f14602e), this.f14603f);
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
        this.a = null;
        this.f14599b = null;
        this.f14600c = null;
        this.f14601d = 0;
        this.f14602e = 0;
        this.f14603f = 0;
        this.f14605h = new ArrayList<>();
        this.f14606i = new WheelView.c();
        b(context);
    }

    private void b(Context context) {
        this.f14605h = AddressHttp.getAddSint(null).getPickData();
        this.f14604g = new e(this.f14605h);
        addView(a(context, new a()));
    }

    public void a() {
        a(AddressHttp.getAddSint(null).getPickData());
    }

    public void a(ArrayList<c.a.a.d.k> arrayList) {
        String areaName;
        String areaId = "";
        if (arrayList != null || arrayList.size() > 0) {
            c.a.a.d.e county = getCounty();
            this.f14605h = arrayList;
            this.f14604g = new e(this.f14605h);
            if (this.f14607j == null || this.f14608k == null || this.f14609l == null) {
                return;
            }
            try {
                areaName = this.f14605h.get(this.f14601d).getCities().get(this.f14602e).getCounties().get(this.f14603f).getAreaName();
                try {
                    areaId = this.f14605h.get(this.f14601d).getCities().get(this.f14602e).getCounties().get(this.f14603f).getAreaId();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                areaName = "";
            }
            if (county != null && (!TextUtils.equals(county.getAreaName(), areaName) || !TextUtils.equals(county.getAreaId(), areaId))) {
                this.f14601d = 0;
                this.f14602e = 0;
                this.f14603f = 0;
                e2.a("\u8bf7\u91cd\u65b0\u9009\u62e9");
            }
            this.f14607j.a(this.f14604g.a(), this.f14601d);
            this.f14608k.a(this.f14604g.a(this.f14601d), this.f14602e);
            this.f14609l.a(this.f14604g.a(this.f14601d, this.f14602e), this.f14603f);
        }
    }

    private void b() {
        this.f14606i.a(true);
        this.f14606i.d(-1);
        this.f14606i.c(100);
        this.f14606i.b(true);
        this.f14606i.a(0.0f);
    }

    protected WheelView a(Context context) {
        WheelView wheelView = new WheelView(context);
        wheelView.setLineSpaceMultiplier(2.0f);
        wheelView.setTextPadding(-1);
        wheelView.setTextSize(16.0f);
        wheelView.setTypeface(Typeface.DEFAULT);
        wheelView.a(WheelView.i0, ViewCompat.MEASURED_STATE_MASK);
        wheelView.setDividerConfig(this.f14606i);
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

    protected View a(Context context, a.f fVar) {
        b();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f14607j = a(context);
        this.f14607j.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f14607j);
        this.f14608k = a(context);
        this.f14608k.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f14608k);
        this.f14609l = a(context);
        this.f14609l.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout.addView(this.f14609l);
        this.f14607j.a(this.f14604g.a(), this.f14601d);
        this.f14607j.setOnItemSelectListener(new b(fVar));
        this.f14608k.a(this.f14604g.a(this.f14601d), this.f14602e);
        this.f14608k.setOnItemSelectListener(new c(fVar));
        this.f14609l.a(this.f14604g.a(this.f14601d, this.f14602e), this.f14603f);
        this.f14609l.setOnItemSelectListener(new d(fVar));
        if (this.f14599b == null && this.f14604g.a(0).size() > 0) {
            this.f14599b = (c.a.a.d.d) this.f14604g.a(0).get(0);
        }
        if (this.f14600c == null && this.f14604g.a(0, 0).size() > 0) {
            this.f14600c = (c.a.a.d.e) this.f14604g.a(0, 0).get(0);
        }
        return linearLayout;
    }
}
