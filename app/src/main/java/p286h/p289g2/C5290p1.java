package p286h.p289g2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p301n.p302a.AbstractC5408k;
import p286h.p294k2.p301n.p302a.InterfaceC5403f;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p321x2.AbstractC5701o;
import p286h.p321x2.C5703q;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SlidingWindow.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, m23546d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, m23547k = 2, m23548mv = {1, 1, 16})
/* renamed from: h.g2.p1 */
/* loaded from: classes2.dex */
public final class C5290p1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @InterfaceC5403f(m22127c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", m22128f = "SlidingWindow.kt", m22129i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, m22130l = {34, 40, 49, 55, 58}, m22131m = "invokeSuspend", m22132n = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, m22133s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
    /* renamed from: h.g2.p1$a */
    static final class a<T> extends AbstractC5408k implements InterfaceC5510p<AbstractC5701o<? super List<? extends T>>, InterfaceC5358d<? super C5715y1>, Object> {
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

        /* renamed from: p$ */
        private AbstractC5701o f20144p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i2, int i3, Iterator it, boolean z, boolean z2, InterfaceC5358d interfaceC5358d) {
            super(2, interfaceC5358d);
            this.$size = i2;
            this.$step = i3;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5816d
        public final InterfaceC5358d<C5715y1> create(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5358d<?> interfaceC5358d) {
            C5544i0.m22546f(interfaceC5358d, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, interfaceC5358d);
            aVar.f20144p$ = (AbstractC5701o) obj;
            return aVar;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5510p
        public final Object invoke(Object obj, InterfaceC5358d<? super C5715y1> interfaceC5358d) {
            return ((a) create(obj, interfaceC5358d)).invokeSuspend(C5715y1.f20665a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:19:0x015d  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x017f  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x00fa A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x00cc  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0176 -> B:16:0x0179). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0144 -> B:32:0x0147). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x00c1 -> B:52:0x00c4). Please report as a decompilation issue!!! */
        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @p324i.p336c.p337a.InterfaceC5817e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@p324i.p336c.p337a.InterfaceC5816d java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 410
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p286h.p289g2.C5290p1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.g2.p1$b */
    public static final class b<T> implements InterfaceC5699m<List<? extends T>> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5699m f20145a;

        /* renamed from: b */
        final /* synthetic */ int f20146b;

        /* renamed from: c */
        final /* synthetic */ int f20147c;

        /* renamed from: d */
        final /* synthetic */ boolean f20148d;

        /* renamed from: e */
        final /* synthetic */ boolean f20149e;

        public b(InterfaceC5699m interfaceC5699m, int i2, int i3, boolean z, boolean z2) {
            this.f20145a = interfaceC5699m;
            this.f20146b = i2;
            this.f20147c = i3;
            this.f20148d = z;
            this.f20149e = z2;
        }

        @Override // p286h.p321x2.InterfaceC5699m
        @InterfaceC5816d
        public Iterator<List<? extends T>> iterator() {
            return C5290p1.m20140a(this.f20145a.iterator(), this.f20146b, this.f20147c, this.f20148d, this.f20149e);
        }
    }

    /* renamed from: a */
    public static final void m20141a(int i2, int i3) {
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

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5699m<List<T>> m20139a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, int i2, int i3, boolean z, boolean z2) {
        C5544i0.m22546f(interfaceC5699m, "$this$windowedSequence");
        m20141a(i2, i3);
        return new b(interfaceC5699m, i2, i3, z, z2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Iterator<List<T>> m20140a(@InterfaceC5816d Iterator<? extends T> it, int i2, int i3, boolean z, boolean z2) {
        Iterator<List<T>> m23349c;
        C5544i0.m22546f(it, "iterator");
        if (!it.hasNext()) {
            return C5268i0.f20126a;
        }
        m23349c = C5703q.m23349c(new a(i2, i3, it, z2, z, null));
        return m23349c;
    }
}
