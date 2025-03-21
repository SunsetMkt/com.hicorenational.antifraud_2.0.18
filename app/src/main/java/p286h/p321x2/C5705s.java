package p286h.p321x2;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p286h.C5218c1;
import p286h.C5334i0;
import p286h.C5597r0;
import p286h.C5715y1;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5294r;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p300m.C5397d;
import p286h.p294k2.p301n.p302a.AbstractC5408k;
import p286h.p294k2.p301n.p302a.InterfaceC5403f;
import p286h.p304m2.InterfaceC5426f;
import p286h.p304m2.InterfaceC5427g;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.AbstractC5547j0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000b\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\b\u0010\f\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0010\"\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00050\u000bH\u0002¢\u0006\u0002\b\u0016\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0007¢\u0006\u0002\b\u0018\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a@\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001e0\u001d\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00150\u001d0\u0001¨\u0006\u001f"}, m23546d2 = {"Sequence", "Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, m23547k = 5, m23548mv = {1, 1, 16}, m23550xi = 1, m23551xs = "kotlin/sequences/SequencesKt")
/* renamed from: h.x2.s */
/* loaded from: classes2.dex */
public class C5705s extends C5704r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.s$a */
    public static final class a<T> implements InterfaceC5699m<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5495a f20617a;

        public a(InterfaceC5495a interfaceC5495a) {
            this.f20617a = interfaceC5495a;
        }

        @Override // p286h.p321x2.InterfaceC5699m
        @InterfaceC5816d
        public Iterator<T> iterator() {
            return (Iterator) this.f20617a.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.s$b */
    public static final class b<T> implements InterfaceC5699m<T> {

        /* renamed from: a */
        final /* synthetic */ Iterator f20618a;

        public b(Iterator it) {
            this.f20618a = it;
        }

        @Override // p286h.p321x2.InterfaceC5699m
        @InterfaceC5816d
        public Iterator<T> iterator() {
            return this.f20618a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.s$c */
    static final class c<T> extends AbstractC5547j0 implements InterfaceC5506l<InterfaceC5699m<? extends T>, Iterator<? extends T>> {
        public static final c INSTANCE = new c();

        c() {
            super(1);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final Iterator<T> invoke(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
            C5544i0.m22546f(interfaceC5699m, "it");
            return interfaceC5699m.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.s$d */
    static final class d<T> extends AbstractC5547j0 implements InterfaceC5506l<Iterable<? extends T>, Iterator<? extends T>> {
        public static final d INSTANCE = new d();

        d() {
            super(1);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5816d
        public final Iterator<T> invoke(@InterfaceC5816d Iterable<? extends T> iterable) {
            C5544i0.m22546f(iterable, "it");
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.s$e */
    static final class e<T> extends AbstractC5547j0 implements InterfaceC5506l<T, T> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        public final T invoke(T t) {
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.s$f */
    static final class f<T> extends AbstractC5547j0 implements InterfaceC5506l<T, T> {
        final /* synthetic */ InterfaceC5495a $nextFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC5495a interfaceC5495a) {
            super(1);
            this.$nextFunction = interfaceC5495a;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5506l
        @InterfaceC5817e
        public final T invoke(@InterfaceC5816d T t) {
            C5544i0.m22546f(t, "it");
            return (T) this.$nextFunction.invoke();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* renamed from: h.x2.s$g */
    static final class g<T> extends AbstractC5547j0 implements InterfaceC5495a<T> {
        final /* synthetic */ Object $seed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Object obj) {
            super(0);
            this.$seed = obj;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5495a
        @InterfaceC5817e
        public final T invoke() {
            return (T) this.$seed;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @InterfaceC5403f(m22127c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", m22128f = "Sequences.kt", m22129i = {0, 0, 1, 1}, m22130l = {67, 69}, m22131m = "invokeSuspend", m22132n = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, m22133s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: h.x2.s$h */
    static final class h<T> extends AbstractC5408k implements InterfaceC5510p<AbstractC5701o<? super T>, InterfaceC5358d<? super C5715y1>, Object> {
        final /* synthetic */ InterfaceC5495a $defaultValue;
        final /* synthetic */ InterfaceC5699m $this_ifEmpty;
        Object L$0;
        Object L$1;
        int label;

        /* renamed from: p$ */
        private AbstractC5701o f20619p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(InterfaceC5699m interfaceC5699m, InterfaceC5495a interfaceC5495a, InterfaceC5358d interfaceC5358d) {
            super(2, interfaceC5358d);
            this.$this_ifEmpty = interfaceC5699m;
            this.$defaultValue = interfaceC5495a;
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5816d
        public final InterfaceC5358d<C5715y1> create(@InterfaceC5817e Object obj, @InterfaceC5816d InterfaceC5358d<?> interfaceC5358d) {
            C5544i0.m22546f(interfaceC5358d, "completion");
            h hVar = new h(this.$this_ifEmpty, this.$defaultValue, interfaceC5358d);
            hVar.f20619p$ = (AbstractC5701o) obj;
            return hVar;
        }

        @Override // p286h.p309q2.p310s.InterfaceC5510p
        public final Object invoke(Object obj, InterfaceC5358d<? super C5715y1> interfaceC5358d) {
            return ((h) create(obj, interfaceC5358d)).invokeSuspend(C5715y1.f20665a);
        }

        @Override // p286h.p294k2.p301n.p302a.AbstractC5398a
        @InterfaceC5817e
        public final Object invokeSuspend(@InterfaceC5816d Object obj) {
            Object m22117b;
            m22117b = C5397d.m22117b();
            int i2 = this.label;
            if (i2 == 0) {
                C5597r0.m22717b(obj);
                AbstractC5701o abstractC5701o = this.f20619p$;
                Iterator<? extends T> it = this.$this_ifEmpty.iterator();
                if (it.hasNext()) {
                    this.L$0 = abstractC5701o;
                    this.L$1 = it;
                    this.label = 1;
                    if (abstractC5701o.mo23332a((Iterator) it, (InterfaceC5358d<? super C5715y1>) this) == m22117b) {
                        return m22117b;
                    }
                } else {
                    InterfaceC5699m<? extends T> interfaceC5699m = (InterfaceC5699m) this.$defaultValue.invoke();
                    this.L$0 = abstractC5701o;
                    this.L$1 = it;
                    this.label = 2;
                    if (abstractC5701o.m23335a((InterfaceC5699m) interfaceC5699m, (InterfaceC5358d<? super C5715y1>) this) == m22117b) {
                        return m22117b;
                    }
                }
            } else {
                if (i2 != 1 && i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C5597r0.m22717b(obj);
            }
            return C5715y1.f20665a;
        }
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final <T> InterfaceC5699m<T> m23352a(InterfaceC5495a<? extends Iterator<? extends T>> interfaceC5495a) {
        return new a(interfaceC5495a);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static <T> InterfaceC5699m<T> m23360b() {
        return C5693g.f20576a;
    }

    @InterfaceC5481e(name = "flattenSequenceOfIterable")
    @InterfaceC5816d
    /* renamed from: c */
    public static final <T> InterfaceC5699m<T> m23363c(@InterfaceC5816d InterfaceC5699m<? extends Iterable<? extends T>> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$flatten");
        return m23356a((InterfaceC5699m) interfaceC5699m, (InterfaceC5506l) d.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: d */
    private static final <T> InterfaceC5699m<T> m23364d(@InterfaceC5817e InterfaceC5699m<? extends T> interfaceC5699m) {
        return interfaceC5699m != 0 ? interfaceC5699m : m23360b();
    }

    @InterfaceC5816d
    /* renamed from: e */
    public static final <T, R> C5334i0<List<T>, List<R>> m23365e(@InterfaceC5816d InterfaceC5699m<? extends C5334i0<? extends T, ? extends R>> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$unzip");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (C5334i0<? extends T, ? extends R> c5334i0 : interfaceC5699m) {
            arrayList.add(c5334i0.getFirst());
            arrayList2.add(c5334i0.getSecond());
        }
        return C5218c1.m18838a(arrayList, arrayList2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5699m<T> m23358a(@InterfaceC5816d Iterator<? extends T> it) {
        InterfaceC5699m<T> m23354a;
        C5544i0.m22546f(it, "$this$asSequence");
        m23354a = m23354a(new b(it));
        return m23354a;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> InterfaceC5699m<T> m23362b(@InterfaceC5816d InterfaceC5699m<? extends InterfaceC5699m<? extends T>> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$flatten");
        return m23356a((InterfaceC5699m) interfaceC5699m, (InterfaceC5506l) c.INSTANCE);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5699m<T> m23359a(@InterfaceC5816d T... tArr) {
        InterfaceC5699m<T> m21285g;
        C5544i0.m22546f(tArr, "elements");
        if (tArr.length == 0) {
            return m23360b();
        }
        m21285g = C5294r.m21285g((Object[]) tArr);
        return m21285g;
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T> InterfaceC5699m<T> m23361b(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a) {
        InterfaceC5699m<T> m23354a;
        C5544i0.m22546f(interfaceC5495a, "nextFunction");
        m23354a = m23354a(new C5696j(interfaceC5495a, new f(interfaceC5495a)));
        return m23354a;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5699m<T> m23355a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, @InterfaceC5816d InterfaceC5495a<? extends InterfaceC5699m<? extends T>> interfaceC5495a) {
        C5544i0.m22546f(interfaceC5699m, "$this$ifEmpty");
        C5544i0.m22546f(interfaceC5495a, "defaultValue");
        return C5703q.m23350d(new h(interfaceC5699m, interfaceC5495a, null));
    }

    /* renamed from: a */
    private static final <T, R> InterfaceC5699m<R> m23356a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m, InterfaceC5506l<? super T, ? extends Iterator<? extends R>> interfaceC5506l) {
        if (interfaceC5699m instanceof C5712z) {
            return ((C5712z) interfaceC5699m).m23542a(interfaceC5506l);
        }
        return new C5695i(interfaceC5699m, e.INSTANCE, interfaceC5506l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: a */
    public static <T> InterfaceC5699m<T> m23354a(@InterfaceC5816d InterfaceC5699m<? extends T> interfaceC5699m) {
        C5544i0.m22546f(interfaceC5699m, "$this$constrainOnce");
        return interfaceC5699m instanceof C5685a ? interfaceC5699m : new C5685a(interfaceC5699m);
    }

    @InterfaceC5427g
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5699m<T> m23357a(@InterfaceC5817e T t, @InterfaceC5816d InterfaceC5506l<? super T, ? extends T> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5506l, "nextFunction");
        if (t == null) {
            return C5693g.f20576a;
        }
        return new C5696j(new g(t), interfaceC5506l);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static <T> InterfaceC5699m<T> m23353a(@InterfaceC5816d InterfaceC5495a<? extends T> interfaceC5495a, @InterfaceC5816d InterfaceC5506l<? super T, ? extends T> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5495a, "seedFunction");
        C5544i0.m22546f(interfaceC5506l, "nextFunction");
        return new C5696j(interfaceC5495a, interfaceC5506l);
    }
}
