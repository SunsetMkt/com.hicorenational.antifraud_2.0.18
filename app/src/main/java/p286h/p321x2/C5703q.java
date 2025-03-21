package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import p286h.C5715y1;
import p286h.EnumC5220d;
import p286h.InterfaceC5212b;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p300m.C5396c;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: SequenceBuilder.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aN\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\t\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aM\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aM\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\n0\u0014\"\u0004\b\u0000\u0010\n2/\b\u0001\u0010\u0017\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f¢\u0006\u0002\b\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0007\u001a\u00060\u0001j\u0002`\u0002X\u0082T¢\u0006\u0002\n\u0000*V\b\u0007\u0010\u0019\u001a\u0004\b\u0000\u0010\n\"\b\u0012\u0004\u0012\u0002H\n0\r2\b\u0012\u0004\u0012\u0002H\n0\rB6\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u001c\b\u001d\u0012\u0018\b\u000bB\u0014\b\u001e\u0012\u0006\b\u001f\u0012\u0002\b\f\u0012\b\b \u0012\u0004\b\b(!\u0012\n\b\"\u0012\u0006\b\n0#8$*\f\b\u0002\u0010%\"\u00020\u00012\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m23546d2 = {"State_Done", "", "Lkotlin/sequences/State;", "State_Failed", "State_ManyNotReady", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", ExifInterface.GPS_DIRECTION_TRUE, "builderAction", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "iterator", "block", "sequence", "SequenceBuilder", "Lkotlin/Deprecated;", "message", "Use SequenceScope class instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "SequenceScope<T>", "level", "Lkotlin/DeprecationLevel;", "ERROR", "State", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/sequences/SequencesKt")
/* renamed from: h.x2.q */
/* loaded from: classes2.dex */
class C5703q {

    /* renamed from: a */
    private static final int f20609a = 0;

    /* renamed from: b */
    private static final int f20610b = 1;

    /* renamed from: c */
    private static final int f20611c = 2;

    /* renamed from: d */
    private static final int f20612d = 3;

    /* renamed from: e */
    private static final int f20613e = 4;

    /* renamed from: f */
    private static final int f20614f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.q$a */
    public static final class a<T> implements InterfaceC5699m<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5510p f20615a;

        public a(InterfaceC5510p interfaceC5510p) {
            this.f20615a = interfaceC5510p;
        }

        @Override // p286h.p321x2.InterfaceC5699m
        @InterfaceC5816d
        public Iterator<T> iterator() {
            Iterator<T> m23349c;
            m23349c = C5703q.m23349c(this.f20615a);
            return m23349c;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.q$b */
    public static final class b<T> implements InterfaceC5699m<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5510p f20616a;

        public b(InterfaceC5510p interfaceC5510p) {
            this.f20616a = interfaceC5510p;
        }

        @Override // p286h.p321x2.InterfaceC5699m
        @InterfaceC5816d
        public Iterator<T> iterator() {
            Iterator<T> m23349c;
            m23349c = C5703q.m23349c(this.f20616a);
            return m23349c;
        }
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use 'iterator { }' function instead.", replaceWith = @InterfaceC5467o0(expression = "iterator(builderAction)", imports = {}))
    /* renamed from: a */
    private static final <T> Iterator<T> m23346a(@InterfaceC5212b InterfaceC5510p<? super AbstractC5701o<? super T>, ? super InterfaceC5358d<? super C5715y1>, ? extends Object> interfaceC5510p) {
        Iterator<T> m23349c;
        m23349c = m23349c(interfaceC5510p);
        return m23349c;
    }

    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use SequenceScope class instead.", replaceWith = @InterfaceC5467o0(expression = "SequenceScope<T>", imports = {}))
    /* renamed from: a */
    public static /* synthetic */ void m23347a() {
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "Use 'sequence { }' function instead.", replaceWith = @InterfaceC5467o0(expression = "sequence(builderAction)", imports = {}))
    /* renamed from: b */
    private static final <T> InterfaceC5699m<T> m23348b(@InterfaceC5212b InterfaceC5510p<? super AbstractC5701o<? super T>, ? super InterfaceC5358d<? super C5715y1>, ? extends Object> interfaceC5510p) {
        return new a(interfaceC5510p);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: c */
    public static <T> Iterator<T> m23349c(@InterfaceC5212b @InterfaceC5816d InterfaceC5510p<? super AbstractC5701o<? super T>, ? super InterfaceC5358d<? super C5715y1>, ? extends Object> interfaceC5510p) {
        InterfaceC5358d<C5715y1> m22113a;
        C5544i0.m22546f(interfaceC5510p, "block");
        C5700n c5700n = new C5700n();
        m22113a = C5396c.m22113a(interfaceC5510p, c5700n, c5700n);
        c5700n.m23333a(m22113a);
        return c5700n;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: d */
    public static final <T> InterfaceC5699m<T> m23350d(@InterfaceC5212b @InterfaceC5816d InterfaceC5510p<? super AbstractC5701o<? super T>, ? super InterfaceC5358d<? super C5715y1>, ? extends Object> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "block");
        return new b(interfaceC5510p);
    }
}
