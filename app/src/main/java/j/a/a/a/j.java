package j.a.a.a;

import java.util.Comparator;

/* JADX INFO: compiled from: StringEncoderComparator.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements Comparator {
    private final i a;

    public j() {
        this.a = null;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((Comparable) this.a.encode(obj)).compareTo((Comparable) this.a.encode(obj2));
        } catch (g unused) {
            return 0;
        }
    }

    public j(i iVar) {
        this.a = iVar;
    }
}
