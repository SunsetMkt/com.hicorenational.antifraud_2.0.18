package p023b.p024a.p025a.p026d;

import java.util.List;

/* compiled from: CarNumberCity.java */
/* renamed from: b.a.a.d.b */
/* loaded from: classes.dex */
public class C0904b implements InterfaceC0911i<Void> {
    private String name;

    public C0904b(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0904b) {
            return this.name.equals(((C0904b) obj).getName());
        }
        return false;
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
    public List<Void> getThirds() {
        return null;
    }

    public String toString() {
        return "name=" + this.name;
    }
}
