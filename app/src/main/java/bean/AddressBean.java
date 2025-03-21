package bean;

import java.util.ArrayList;
import java.util.List;
import p023b.p024a.p025a.p026d.C0906d;
import p023b.p024a.p025a.p026d.C0907e;
import p023b.p024a.p025a.p026d.C0913k;

/* loaded from: classes.dex */
public class AddressBean {
    private List<AddressBean> cityList;
    private String code;
    private String name;
    private List<AddressBean> townList;

    public static ArrayList<C0913k> gainRegionData(List<AddressBean> list) {
        ArrayList<C0913k> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < list.size(); i2++) {
            C0913k c0913k = new C0913k();
            c0913k.setAreaName(list.get(i2).getName());
            c0913k.setAreaId(list.get(i2).getCode());
            ArrayList arrayList2 = new ArrayList();
            List<AddressBean> cityList = list.get(i2).getCityList();
            if (cityList == null || cityList.size() <= 0) {
                C0907e c0907e = new C0907e();
                c0907e.setAreaName(list.get(i2).getName());
                c0907e.setAreaId(list.get(i2).getCode());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(c0907e);
                C0906d c0906d = new C0906d();
                c0906d.setAreaName(list.get(i2).getName());
                c0906d.setAreaId(list.get(i2).getCode());
                c0906d.setCounties(arrayList3);
                arrayList2.add(c0906d);
            } else {
                for (int i3 = 0; i3 < cityList.size(); i3++) {
                    C0906d c0906d2 = new C0906d();
                    c0906d2.setAreaName(cityList.get(i3).getName());
                    c0906d2.setAreaId(cityList.get(i3).getCode());
                    ArrayList arrayList4 = new ArrayList();
                    List<AddressBean> townList = cityList.get(i3).getTownList();
                    if (townList == null || townList.size() <= 0) {
                        C0907e c0907e2 = new C0907e();
                        c0907e2.setAreaName(cityList.get(i3).getName());
                        c0907e2.setAreaId(cityList.get(i3).getCode());
                        arrayList4.add(c0907e2);
                    } else {
                        for (int i4 = 0; i4 < townList.size(); i4++) {
                            C0907e c0907e3 = new C0907e();
                            c0907e3.setAreaName(townList.get(i4).getName());
                            c0907e3.setAreaId(townList.get(i4).getCode());
                            arrayList4.add(c0907e3);
                        }
                    }
                    c0906d2.setCounties(arrayList4);
                    arrayList2.add(c0906d2);
                }
            }
            c0913k.setCities(arrayList2);
            arrayList.add(c0913k);
        }
        C0907e c0907e4 = new C0907e();
        c0907e4.setAreaName("请选择");
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(c0907e4);
        C0906d c0906d3 = new C0906d();
        c0906d3.setAreaName("请选择");
        c0906d3.setCounties(arrayList5);
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(c0906d3);
        C0913k c0913k2 = new C0913k();
        c0913k2.setAreaName("请选择");
        c0913k2.setCities(arrayList6);
        arrayList.add(0, c0913k2);
        return arrayList;
    }

    public List<AddressBean> getCityList() {
        return this.cityList;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public List<AddressBean> getTownList() {
        return this.townList;
    }

    public void setCityList(List<AddressBean> list) {
        this.cityList = list;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTownList(List<AddressBean> list) {
        this.townList = list;
    }
}
