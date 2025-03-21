package p023b.p024a.p025a.p026d;

/* compiled from: CarNumberProvince.java */
/* renamed from: b.a.a.d.c */
/* loaded from: classes.dex */
public class C0905c implements InterfaceC0909g<C0904b> {
    private String name;

    public C0905c(String str) {
        this.name = str;
    }

    @Override // p023b.p024a.p025a.p026d.InterfaceC0909g, p023b.p024a.p025a.p026d.InterfaceC0910h
    public Object getId() {
        return this.name;
    }

    @Override // p023b.p024a.p025a.p026d.InterfaceC0914l
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x05fa, code lost:
    
        return r0;
     */
    @Override // p023b.p024a.p025a.p026d.InterfaceC0909g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<p023b.p024a.p025a.p026d.C0904b> getSeconds() {
        /*
            Method dump skipped, instructions count: 1724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p023b.p024a.p025a.p026d.C0905c.getSeconds():java.util.List");
    }

    public String toString() {
        return "name=" + this.name;
    }
}
