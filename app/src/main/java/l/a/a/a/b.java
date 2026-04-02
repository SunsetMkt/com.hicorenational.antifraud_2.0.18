package l.a.a.a;

import java.util.Collection;

/* JADX INFO: compiled from: CollectionUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean b(Collection collection) {
        return !a(collection);
    }
}
