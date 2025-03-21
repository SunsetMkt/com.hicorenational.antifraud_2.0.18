package p324i.p325a.p326a.p327a;

import java.util.Comparator;

/* compiled from: StringEncoderComparator.java */
/* renamed from: i.a.a.a.j */
/* loaded from: classes2.dex */
public class C5765j implements Comparator {

    /* renamed from: a */
    private final InterfaceC5764i f20756a;

    public C5765j() {
        this.f20756a = null;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.f20756a.encode(obj)).compareTo((Comparable) this.f20756a.encode(obj2));
        } catch (C5762g unused) {
            return 0;
        }
    }

    public C5765j(InterfaceC5764i interfaceC5764i) {
        this.f20756a = interfaceC5764i;
    }
}
