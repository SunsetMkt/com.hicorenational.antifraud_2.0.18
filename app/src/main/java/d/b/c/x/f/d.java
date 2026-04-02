package d.b.c.x.f;

import i.f1;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: HighLevelEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c */
    static final int f9882c = 0;

    /* JADX INFO: renamed from: d */
    static final int f9883d = 1;

    /* JADX INFO: renamed from: e */
    static final int f9884e = 2;

    /* JADX INFO: renamed from: f */
    static final int f9885f = 3;

    /* JADX INFO: renamed from: g */
    static final int f9886g = 4;

    /* JADX INFO: renamed from: j */
    static final int[][] f9889j;
    private final byte[] a;

    /* JADX INFO: renamed from: b */
    static final String[] f9881b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: h */
    static final int[][] f9887h = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* JADX INFO: renamed from: i */
    private static final int[][] f9888i = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);

    /* JADX INFO: compiled from: HighLevelEncoder.java */
    class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.b() - fVar2.b();
        }
    }

    static {
        f9888i[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            f9888i[0][i2] = (i2 - 65) + 2;
        }
        f9888i[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            f9888i[1][i3] = (i3 - 97) + 2;
        }
        f9888i[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            f9888i[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr = f9888i;
        iArr[2][44] = 12;
        iArr[2][46] = 13;
        int[] iArr2 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            f9888i[3][iArr2[i5]] = i5;
        }
        int[] iArr3 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < iArr3.length; i6++) {
            if (iArr3[i6] > 0) {
                f9888i[4][iArr3[i6]] = i6;
            }
        }
        f9889j = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        for (int[] iArr4 : f9889j) {
            Arrays.fill(iArr4, -1);
        }
        int[][] iArr5 = f9889j;
        iArr5[0][4] = 0;
        iArr5[1][4] = 0;
        iArr5[1][0] = 28;
        iArr5[3][4] = 0;
        iArr5[2][4] = 0;
        iArr5[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.a = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d.b.c.z.a a() {
        int i2;
        Collection<f> collectionSingletonList = Collections.singletonList(f.f9892e);
        int i3 = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i3 >= bArr.length) {
                return ((f) Collections.min(collectionSingletonList, new a())).a(this.a);
            }
            int i4 = i3 + 1;
            byte b2 = i4 < bArr.length ? bArr[i4] : (byte) 0;
            byte b3 = this.a[i3];
            if (b3 != 13) {
                if (b3 != 44) {
                    if (b3 != 46) {
                        i2 = (b3 == 58 && b2 == 32) ? 5 : 0;
                    } else if (b2 == 32) {
                        i2 = 3;
                    }
                } else if (b2 == 32) {
                    i2 = 4;
                }
            } else if (b2 == 10) {
                i2 = 2;
            }
            if (i2 > 0) {
                collectionSingletonList = a(collectionSingletonList, i3, i2);
                i3 = i4;
            } else {
                collectionSingletonList = a(collectionSingletonList, i3);
            }
            i3++;
        }
    }

    private Collection<f> a(Iterable<f> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i2, linkedList);
        }
        return a(linkedList);
    }

    private void a(f fVar, int i2, Collection<f> collection) {
        char c2 = (char) (this.a[i2] & f1.f12066c);
        boolean z = f9888i[fVar.c()][c2] > 0;
        f fVarB = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = f9888i[i3][c2];
            if (i4 > 0) {
                if (fVarB == null) {
                    fVarB = fVar.b(i2);
                }
                if (!z || i3 == fVar.c() || i3 == 2) {
                    collection.add(fVarB.a(i3, i4));
                }
                if (!z && f9889j[fVar.c()][i3] >= 0) {
                    collection.add(fVarB.b(i3, i4));
                }
            }
        }
        if (fVar.a() > 0 || f9888i[fVar.c()][c2] == 0) {
            collection.add(fVar.a(i2));
        }
    }

    private static Collection<f> a(Iterable<f> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i2, i3, linkedList);
        }
        return a(linkedList);
    }

    private static void a(f fVar, int i2, int i3, Collection<f> collection) {
        f fVarB = fVar.b(i2);
        collection.add(fVarB.a(4, i3));
        if (fVar.c() != 4) {
            collection.add(fVarB.b(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(fVarB.a(2, 16 - i3).a(2, 1));
        }
        if (fVar.a() > 0) {
            collection.add(fVar.a(i2).a(i2 + 1));
        }
    }

    private static Collection<f> a(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.a(fVar)) {
                    z = false;
                    break;
                }
                if (fVar.a(fVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }
}
