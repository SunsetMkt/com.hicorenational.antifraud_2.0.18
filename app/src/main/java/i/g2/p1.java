package i.g2;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u00a8\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
public final class p1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    @i.k2.n.a.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
    static final class a<T> extends i.k2.n.a.k implements i.q2.s.p<i.x2.o<? super List<? extends T>>, i.k2.d<? super i.y1>, Object> {
        final /* synthetic */ Iterator $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private i.x2.o p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, int i3, Iterator it, boolean z, boolean z2, i.k2.d dVar) {
            super(2, dVar);
            this.$size = i2;
            this.$step = i3;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override // i.k2.n.a.a
        @j.c.a.d
        public final i.k2.d<i.y1> create(@j.c.a.e Object obj, @j.c.a.d i.k2.d<?> dVar) {
            i.q2.t.i0.f(dVar, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, dVar);
            aVar.p$ = (i.x2.o) obj;
            return aVar;
        }

        @Override // i.q2.s.p
        public final Object invoke(Object obj, i.k2.d<? super i.y1> dVar) {
            return ((a) create(obj, dVar)).invokeSuspend(i.y1.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00fa A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x017f  */
        /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v15, types: [i.g2.a, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r1v16, types: [i.g2.j1] */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [i.g2.a, i.g2.j1, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6, types: [i.g2.j1] */
        /* JADX WARN: Type inference failed for: r5v7, types: [i.g2.j1] */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v9, types: [i.x2.o, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v10 */
        /* JADX WARN: Type inference failed for: r9v3, types: [i.x2.o, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r9v8 */
        /* JADX WARN: Type inference failed for: r9v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c1 -> B:30:0x00c4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0144 -> B:59:0x0147). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0176 -> B:72:0x0179). Please report as a decompilation issue!!! */
        @Override // i.k2.n.a.a
        @j.c.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@j.c.a.d Object obj) {
            int i2;
            ?? r9;
            a<T> aVar;
            int i3;
            Iterator it;
            ArrayList arrayList;
            int i4;
            Object obj2;
            int i5;
            i.x2.o oVar;
            a<T> aVar2;
            int i6;
            Iterator it2;
            ?? A;
            ?? r1;
            int i7;
            int i8;
            ?? r7;
            Object objB = i.k2.m.d.b();
            int i9 = this.label;
            if (i9 == 0) {
                i.r0.b(obj);
                i.x2.o oVar2 = this.p$;
                int iB = i.v2.q.b(this.$size, 1024);
                i2 = this.$step - this.$size;
                if (i2 < 0) {
                    j1 j1Var = new j1(iB);
                    r9 = oVar2;
                    aVar = this;
                    i3 = iB;
                    it = this.$iterator;
                    A = j1Var;
                    while (it.hasNext()) {
                    }
                    if (aVar.$partialWindows) {
                    }
                    return i.y1.a;
                }
                arrayList = new ArrayList(iB);
                i4 = 0;
                obj2 = objB;
                i5 = i2;
                oVar = oVar2;
                aVar2 = this;
                i6 = iB;
                it2 = this.$iterator;
                while (it2.hasNext()) {
                }
                if (!arrayList.isEmpty()) {
                    aVar2.L$0 = oVar;
                    aVar2.I$0 = i6;
                    aVar2.I$1 = i5;
                    aVar2.L$1 = arrayList;
                    aVar2.I$2 = i4;
                    aVar2.label = 2;
                    if (oVar.a(arrayList, (i.k2.d<? super i.y1>) aVar2) == obj2) {
                    }
                }
                return i.y1.a;
            }
            if (i9 == 1) {
                it2 = (Iterator) this.L$3;
                arrayList = (ArrayList) this.L$1;
                int i10 = this.I$1;
                i6 = this.I$0;
                oVar = (i.x2.o) this.L$0;
                i.r0.b(obj);
                aVar2 = this;
                obj2 = objB;
                i5 = i10;
                if (aVar2.$reuseBuffer) {
                    arrayList = new ArrayList(aVar2.$size);
                } else {
                    arrayList.clear();
                }
                i4 = i5;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (i4 > 0) {
                        i4--;
                    } else {
                        arrayList.add(next);
                        if (arrayList.size() == aVar2.$size) {
                            aVar2.L$0 = oVar;
                            aVar2.I$0 = i6;
                            aVar2.I$1 = i5;
                            aVar2.L$1 = arrayList;
                            aVar2.I$2 = i4;
                            aVar2.L$2 = next;
                            aVar2.L$3 = it2;
                            aVar2.label = 1;
                            if (oVar.a(arrayList, (i.k2.d<? super i.y1>) aVar2) == obj2) {
                                return obj2;
                            }
                            if (aVar2.$reuseBuffer) {
                            }
                            i4 = i5;
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
                if ((!arrayList.isEmpty()) && (aVar2.$partialWindows || arrayList.size() == aVar2.$size)) {
                    aVar2.L$0 = oVar;
                    aVar2.I$0 = i6;
                    aVar2.I$1 = i5;
                    aVar2.L$1 = arrayList;
                    aVar2.I$2 = i4;
                    aVar2.label = 2;
                    if (oVar.a(arrayList, (i.k2.d<? super i.y1>) aVar2) == obj2) {
                        return obj2;
                    }
                }
                return i.y1.a;
            }
            if (i9 == 2) {
            } else {
                if (i9 == 3) {
                    it = (Iterator) this.L$3;
                    j1 j1Var2 = (j1) this.L$1;
                    i2 = this.I$1;
                    i3 = this.I$0;
                    i.x2.o oVar3 = (i.x2.o) this.L$0;
                    i.r0.b(obj);
                    aVar = this;
                    ?? r5 = j1Var2;
                    ?? r92 = oVar3;
                    r5.b(aVar.$step);
                    A = r5;
                    r9 = r92;
                    while (it.hasNext()) {
                        Object next2 = it.next();
                        A.add(next2);
                        if (A.b()) {
                            int size = A.size();
                            int i11 = aVar.$size;
                            if (size >= i11) {
                                ?? arrayList2 = aVar.$reuseBuffer ? A : new ArrayList((Collection) A);
                                aVar.L$0 = r9;
                                aVar.I$0 = i3;
                                aVar.I$1 = i2;
                                aVar.L$1 = A;
                                aVar.L$2 = next2;
                                aVar.L$3 = it;
                                aVar.label = 3;
                                Object objA = r9.a(arrayList2, aVar);
                                r5 = A;
                                r92 = r9;
                                if (objA == objB) {
                                    return objB;
                                }
                                r5.b(aVar.$step);
                                A = r5;
                                r9 = r92;
                                while (it.hasNext()) {
                                }
                            } else {
                                A = A.a(i11);
                            }
                        }
                    }
                    if (aVar.$partialWindows) {
                        r1 = A;
                        i7 = i2;
                        i8 = i3;
                        r7 = r9;
                        if (r1.size() <= aVar.$step) {
                        }
                    }
                    return i.y1.a;
                }
                if (i9 == 4) {
                    j1 j1Var3 = (j1) this.L$1;
                    i7 = this.I$1;
                    i8 = this.I$0;
                    i.x2.o oVar4 = (i.x2.o) this.L$0;
                    i.r0.b(obj);
                    aVar = this;
                    ?? r12 = j1Var3;
                    ?? r72 = oVar4;
                    r12.b(aVar.$step);
                    r1 = r12;
                    r7 = r72;
                    if (r1.size() <= aVar.$step) {
                        ?? arrayList3 = aVar.$reuseBuffer ? r1 : new ArrayList((Collection) r1);
                        aVar.L$0 = r7;
                        aVar.I$0 = i8;
                        aVar.I$1 = i7;
                        aVar.L$1 = r1;
                        aVar.label = 4;
                        Object objA2 = r7.a(arrayList3, aVar);
                        r12 = r1;
                        r72 = r7;
                        if (objA2 == objB) {
                            return objB;
                        }
                        r12.b(aVar.$step);
                        r1 = r12;
                        r7 = r72;
                        if (r1.size() <= aVar.$step) {
                            if (!r1.isEmpty()) {
                                aVar.L$0 = r7;
                                aVar.I$0 = i8;
                                aVar.I$1 = i7;
                                aVar.L$1 = r1;
                                aVar.label = 5;
                                if (r7.a(r1, aVar) == objB) {
                                    return objB;
                                }
                            }
                            return i.y1.a;
                        }
                    }
                } else {
                    if (i9 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            i.r0.b(obj);
            return i.y1.a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class b<T> implements i.x2.m<List<? extends T>> {
        final /* synthetic */ i.x2.m a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f12095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f12096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f12097e;

        public b(i.x2.m mVar, int i2, int i3, boolean z, boolean z2) {
            this.a = mVar;
            this.f12094b = i2;
            this.f12095c = i3;
            this.f12096d = z;
            this.f12097e = z2;
        }

        @Override // i.x2.m
        @j.c.a.d
        public Iterator<List<? extends T>> iterator() {
            return p1.a(this.a.iterator(), this.f12094b, this.f12095c, this.f12096d, this.f12097e);
        }
    }

    public static final void a(int i2, int i3) {
        String str;
        if (i2 > 0 && i3 > 0) {
            return;
        }
        if (i2 != i3) {
            str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
        } else {
            str = "size " + i2 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @j.c.a.d
    public static final <T> i.x2.m<List<T>> a(@j.c.a.d i.x2.m<? extends T> mVar, int i2, int i3, boolean z, boolean z2) {
        i.q2.t.i0.f(mVar, "$this$windowedSequence");
        a(i2, i3);
        return new b(mVar, i2, i3, z, z2);
    }

    @j.c.a.d
    public static final <T> Iterator<List<T>> a(@j.c.a.d Iterator<? extends T> it, int i2, int i3, boolean z, boolean z2) {
        i.q2.t.i0.f(it, "iterator");
        return !it.hasNext() ? i0.a : i.x2.q.c(new a(i2, i3, it, z2, z, null));
    }
}
