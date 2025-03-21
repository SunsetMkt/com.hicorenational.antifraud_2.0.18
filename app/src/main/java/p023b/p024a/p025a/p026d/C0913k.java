package p023b.p024a.p025a.p026d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Province.java */
/* renamed from: b.a.a.d.k */
/* loaded from: classes.dex */
public class C0913k extends AbstractC0903a implements InterfaceC0909g<C0906d> {
    private List<C0906d> cities;

    public C0913k() {
        this.cities = new ArrayList();
    }

    public List<C0906d> getCities() {
        return this.cities;
    }

    @Override // p023b.p024a.p025a.p026d.InterfaceC0909g
    public List<C0906d> getSeconds() {
        return this.cities;
    }

    public void setCities(List<C0906d> list) {
        this.cities = list;
    }

    public C0913k(String str) {
        super(str);
        this.cities = new ArrayList();
    }

    public C0913k(String str, String str2) {
        super(str, str2);
        this.cities = new ArrayList();
    }
}
