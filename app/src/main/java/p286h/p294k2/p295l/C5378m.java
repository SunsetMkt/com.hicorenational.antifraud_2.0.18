package p286h.p294k2.p295l;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.InterfaceC5212b;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p294k2.p295l.p296n.C5380b;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p321x2.InterfaceC5699m;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SequenceBuilder.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000*\f\b\u0002\u0010\u0016\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\b\t¨\u0006\u0017"}, m23546d2 = {"State_Done", "", "Lkotlin/coroutines/experimental/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", ExifInterface.GPS_DIRECTION_TRUE, "builderAction", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/SequenceBuilder;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "State", "kotlin-stdlib-coroutines"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/coroutines/experimental/SequenceBuilderKt")
/* renamed from: h.k2.l.m */
/* loaded from: classes2.dex */
class C5378m {

    /* renamed from: a */
    private static final int f20257a = 0;

    /* renamed from: b */
    private static final int f20258b = 1;

    /* renamed from: c */
    private static final int f20259c = 2;

    /* renamed from: d */
    private static final int f20260d = 3;

    /* renamed from: e */
    private static final int f20261e = 4;

    /* renamed from: f */
    private static final int f20262f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.k2.l.m$a */
    public static final class a<T> implements InterfaceC5699m<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5510p f20263a;

        public a(InterfaceC5510p interfaceC5510p) {
            this.f20263a = interfaceC5510p;
        }

        @Override // p286h.p321x2.InterfaceC5699m
        @InterfaceC5816d
        public Iterator<T> iterator() {
            return C5378m.m22065a(this.f20263a);
        }
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> Iterator<T> m22065a(@InterfaceC5212b @InterfaceC5816d InterfaceC5510p<? super AbstractC5375j<? super T>, ? super InterfaceC5368c<? super C5715y1>, ? extends Object> interfaceC5510p) {
        InterfaceC5368c<C5715y1> m22072a;
        C5544i0.m22546f(interfaceC5510p, "builderAction");
        C5376k c5376k = new C5376k();
        m22072a = C5380b.m22072a(interfaceC5510p, c5376k, c5376k);
        c5376k.m22062a(m22072a);
        return c5376k;
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> InterfaceC5699m<T> m22066b(@InterfaceC5212b @InterfaceC5816d InterfaceC5510p<? super AbstractC5375j<? super T>, ? super InterfaceC5368c<? super C5715y1>, ? extends Object> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "builderAction");
        return new a(interfaceC5510p);
    }
}
