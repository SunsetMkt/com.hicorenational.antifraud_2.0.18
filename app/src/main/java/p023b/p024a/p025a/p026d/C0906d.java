package p023b.p024a.p025a.p026d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: City.java */
/* renamed from: b.a.a.d.d */
/* loaded from: classes.dex */
public class C0906d extends AbstractC0903a implements InterfaceC0911i<C0907e> {
    private List<C0907e> counties;
    private String provinceId;

    public C0906d() {
        this.counties = new ArrayList();
    }

    public List<C0907e> getCounties() {
        return this.counties;
    }

    public String getProvinceId() {
        return this.provinceId;
    }

    @Override // p023b.p024a.p025a.p026d.InterfaceC0911i
    public List<C0907e> getThirds() {
        return this.counties;
    }

    public void setCounties(List<C0907e> list) {
        this.counties = list;
    }

    public void setProvinceId(String str) {
        this.provinceId = str;
    }

    public C0906d(String str) {
        super(str);
        this.counties = new ArrayList();
    }

    public C0906d(String str, String str2) {
        super(str, str2);
        this.counties = new ArrayList();
    }
}
