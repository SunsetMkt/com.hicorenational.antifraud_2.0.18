package p286h.p319v2;

import java.util.NoSuchElementException;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5339j;
import p286h.InterfaceC5610t0;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5556m0;
import p286h.p318u2.AbstractC5625f;
import p286h.p318u2.C5626g;
import p286h.p319v2.C5632a;
import p286h.p319v2.C5640i;
import p286h.p319v2.C5643l;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* renamed from: h.v2.q */
/* loaded from: classes2.dex */
public class C5648q extends C5647p {
    /* renamed from: a */
    public static final byte m23044a(byte b2, byte b3) {
        return b2 < b3 ? b3 : b2;
    }

    /* renamed from: a */
    public static int m23050a(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final int m23053a(@InterfaceC5816d C5642k c5642k) {
        return m23054a(c5642k, (AbstractC5625f) AbstractC5625f.f20486c);
    }

    /* renamed from: a */
    public static final long m23055a(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    /* renamed from: a */
    public static final short m23087a(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    /* renamed from: b */
    public static final byte m23098b(byte b2, byte b3) {
        return b2 > b3 ? b3 : b2;
    }

    /* renamed from: b */
    public static final double m23099b(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    /* renamed from: b */
    public static final float m23100b(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    /* renamed from: b */
    public static int m23101b(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    /* renamed from: b */
    public static final long m23102b(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final Integer m23122b(@InterfaceC5816d C5642k c5642k) {
        return m23123b(c5642k, AbstractC5625f.f20486c);
    }

    /* renamed from: b */
    public static final short m23127b(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    /* renamed from: c */
    public static final double m23134c(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    /* renamed from: c */
    public static final float m23135c(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    @InterfaceC5481e(name = "intRangeContains")
    /* renamed from: c */
    public static final boolean m23144c(@InterfaceC5816d InterfaceC5638g<Integer> interfaceC5638g, byte b2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Integer.valueOf(b2));
    }

    @InterfaceC5481e(name = "longRangeContains")
    /* renamed from: d */
    public static final boolean m23156d(@InterfaceC5816d InterfaceC5638g<Long> interfaceC5638g, byte b2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Long.valueOf(b2));
    }

    @InterfaceC5481e(name = "shortRangeContains")
    /* renamed from: e */
    public static final boolean m23162e(@InterfaceC5816d InterfaceC5638g<Short> interfaceC5638g, byte b2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Short.valueOf(b2));
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final long m23058a(@InterfaceC5816d C5645n c5645n) {
        return m23059a(c5645n, (AbstractC5625f) AbstractC5625f.f20486c);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final Long m23124b(@InterfaceC5816d C5645n c5645n) {
        return m23125b(c5645n, AbstractC5625f.f20486c);
    }

    @InterfaceC5481e(name = "intRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: c */
    public static final boolean m23145c(@InterfaceC5816d InterfaceC5638g<Integer> interfaceC5638g, double d2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Integer m23119b = m23119b(d2);
        if (m23119b != null) {
            return interfaceC5638g.contains(m23119b);
        }
        return false;
    }

    @InterfaceC5481e(name = "longRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m23157d(@InterfaceC5816d InterfaceC5638g<Long> interfaceC5638g, double d2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Long m23141c = m23141c(d2);
        if (m23141c != null) {
            return interfaceC5638g.contains(m23141c);
        }
        return false;
    }

    @InterfaceC5481e(name = "shortRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: e */
    public static final boolean m23163e(@InterfaceC5816d InterfaceC5638g<Short> interfaceC5638g, double d2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Short m23154d = m23154d(d2);
        if (m23154d != null) {
            return interfaceC5638g.contains(m23154d);
        }
        return false;
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final char m23046a(@InterfaceC5816d C5634c c5634c) {
        return m23047a(c5634c, (AbstractC5625f) AbstractC5625f.f20486c);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    /* renamed from: b */
    private static final Character m23116b(@InterfaceC5816d C5634c c5634c) {
        return m23117b(c5634c, AbstractC5625f.f20486c);
    }

    @InterfaceC5481e(name = "intRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: c */
    public static final boolean m23146c(@InterfaceC5816d InterfaceC5638g<Integer> interfaceC5638g, float f2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Integer m23120b = m23120b(f2);
        if (m23120b != null) {
            return interfaceC5638g.contains(m23120b);
        }
        return false;
    }

    @InterfaceC5481e(name = "longRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: d */
    public static final boolean m23158d(@InterfaceC5816d InterfaceC5638g<Long> interfaceC5638g, float f2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Long m23142c = m23142c(f2);
        if (m23142c != null) {
            return interfaceC5638g.contains(m23142c);
        }
        return false;
    }

    @InterfaceC5481e(name = "shortRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: e */
    public static final boolean m23164e(@InterfaceC5816d InterfaceC5638g<Short> interfaceC5638g, float f2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Short m23155d = m23155d(f2);
        if (m23155d != null) {
            return interfaceC5638g.contains(m23155d);
        }
        return false;
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final int m23054a(@InterfaceC5816d C5642k c5642k, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5642k, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        try {
            return C5626g.m22966a(abstractC5625f, c5642k);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5817e
    /* renamed from: b */
    public static final Integer m23123b(@InterfaceC5816d C5642k c5642k, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5642k, "$this$randomOrNull");
        C5544i0.m22546f(abstractC5625f, "random");
        if (c5642k.isEmpty()) {
            return null;
        }
        return Integer.valueOf(C5626g.m22966a(abstractC5625f, c5642k));
    }

    @InterfaceC5481e(name = "floatRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: c */
    public static final boolean m23147c(@InterfaceC5816d InterfaceC5638g<Float> interfaceC5638g, int i2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Float.valueOf(i2));
    }

    @InterfaceC5481e(name = "longRangeContains")
    /* renamed from: d */
    public static final boolean m23159d(@InterfaceC5816d InterfaceC5638g<Long> interfaceC5638g, int i2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Long.valueOf(i2));
    }

    @InterfaceC5481e(name = "shortRangeContains")
    /* renamed from: e */
    public static final boolean m23165e(@InterfaceC5816d InterfaceC5638g<Short> interfaceC5638g, int i2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Short m23126b = m23126b(i2);
        if (m23126b != null) {
            return interfaceC5638g.contains(m23126b);
        }
        return false;
    }

    @InterfaceC5481e(name = "floatRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: c */
    public static final boolean m23148c(@InterfaceC5816d InterfaceC5638g<Float> interfaceC5638g, long j2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Float.valueOf(j2));
    }

    @InterfaceC5481e(name = "intRangeContains")
    /* renamed from: d */
    public static final boolean m23160d(@InterfaceC5816d InterfaceC5638g<Integer> interfaceC5638g, long j2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Integer m23121b = m23121b(j2);
        if (m23121b != null) {
            return interfaceC5638g.contains(m23121b);
        }
        return false;
    }

    @InterfaceC5481e(name = "shortRangeContains")
    /* renamed from: e */
    public static final boolean m23166e(@InterfaceC5816d InterfaceC5638g<Short> interfaceC5638g, long j2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Short m23143c = m23143c(j2);
        if (m23143c != null) {
            return interfaceC5638g.contains(m23143c);
        }
        return false;
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final long m23059a(@InterfaceC5816d C5645n c5645n, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5645n, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        try {
            return C5626g.m22967a(abstractC5625f, c5645n);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5817e
    /* renamed from: b */
    public static final Long m23125b(@InterfaceC5816d C5645n c5645n, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5645n, "$this$randomOrNull");
        C5544i0.m22546f(abstractC5625f, "random");
        if (c5645n.isEmpty()) {
            return null;
        }
        return Long.valueOf(C5626g.m22967a(abstractC5625f, c5645n));
    }

    @InterfaceC5481e(name = "floatRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: c */
    public static final boolean m23149c(@InterfaceC5816d InterfaceC5638g<Float> interfaceC5638g, short s) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Float.valueOf(s));
    }

    @InterfaceC5481e(name = "intRangeContains")
    /* renamed from: d */
    public static final boolean m23161d(@InterfaceC5816d InterfaceC5638g<Integer> interfaceC5638g, short s) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Integer.valueOf(s));
    }

    @InterfaceC5481e(name = "longRangeContains")
    /* renamed from: e */
    public static final boolean m23167e(@InterfaceC5816d InterfaceC5638g<Long> interfaceC5638g, short s) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Long.valueOf(s));
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final C5640i m23136c(byte b2, byte b3) {
        return C5640i.f20510d.m23022a(b2, b3, -1);
    }

    @InterfaceC5817e
    /* renamed from: d */
    public static final Short m23154d(double d2) {
        double d3 = 32767;
        if (d2 < -32768 || d2 > d3) {
            return null;
        }
        return Short.valueOf((short) d2);
    }

    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final char m23047a(@InterfaceC5816d C5634c c5634c, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5634c, "$this$random");
        C5544i0.m22546f(abstractC5625f, "random");
        try {
            return (char) abstractC5625f.mo22960a((int) c5634c.getFirst(), c5634c.getLast() + 1);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5339j
    @InterfaceC5817e
    /* renamed from: b */
    public static final Character m23117b(@InterfaceC5816d C5634c c5634c, @InterfaceC5816d AbstractC5625f abstractC5625f) {
        C5544i0.m22546f(c5634c, "$this$randomOrNull");
        C5544i0.m22546f(abstractC5625f, "random");
        if (c5634c.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) abstractC5625f.mo22960a((int) c5634c.getFirst(), c5634c.getLast() + 1));
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static C5640i m23137c(int i2, int i3) {
        return C5640i.f20510d.m23022a(i2, i3, -1);
    }

    @InterfaceC5817e
    /* renamed from: d */
    public static final Short m23155d(float f2) {
        float f3 = 32767;
        if (f2 < -32768 || f2 > f3) {
            return null;
        }
        return Short.valueOf((short) f2);
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final C5643l m23139c(long j2, long j3) {
        return C5643l.f20520d.m23028a(j2, j3, -1L);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final C5642k m23150d(byte b2, byte b3) {
        return new C5642k(b2, b3 - 1);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final boolean m23096a(@InterfaceC5816d C5642k c5642k, Integer num) {
        C5544i0.m22546f(c5642k, "$this$contains");
        return num != null && c5642k.m23025a(num.intValue());
    }

    @InterfaceC5481e(name = "floatRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: b */
    public static final boolean m23128b(@InterfaceC5816d InterfaceC5638g<Float> interfaceC5638g, byte b2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Float.valueOf(b2));
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final C5640i m23138c(short s, short s2) {
        return C5640i.f20510d.m23022a(s, s2, -1);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static C5642k m23151d(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return C5642k.f20519f.m23026a();
        }
        return new C5642k(i2, i3 - 1);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final boolean m23097a(@InterfaceC5816d C5645n c5645n, Long l2) {
        C5544i0.m22546f(c5645n, "$this$contains");
        return l2 != null && c5645n.m23031a(l2.longValue());
    }

    @InterfaceC5481e(name = "floatRangeContains")
    /* renamed from: b */
    public static final boolean m23129b(@InterfaceC5816d InterfaceC5638g<Float> interfaceC5638g, double d2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Float.valueOf((float) d2));
    }

    @InterfaceC5817e
    /* renamed from: c */
    public static final Long m23141c(double d2) {
        double d3 = Long.MIN_VALUE;
        double d4 = C5556m0.f20396b;
        if (d2 < d3 || d2 > d4) {
            return null;
        }
        return Long.valueOf((long) d2);
    }

    @InterfaceC5426f
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    private static final boolean m23089a(@InterfaceC5816d C5634c c5634c, Character ch) {
        C5544i0.m22546f(c5634c, "$this$contains");
        return ch != null && c5634c.m23010a(ch.charValue());
    }

    @InterfaceC5481e(name = "doubleRangeContains")
    /* renamed from: b */
    public static final boolean m23130b(@InterfaceC5816d InterfaceC5638g<Double> interfaceC5638g, float f2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Double.valueOf(f2));
    }

    @InterfaceC5817e
    /* renamed from: c */
    public static final Long m23142c(float f2) {
        float f3 = Long.MIN_VALUE;
        float f4 = C5556m0.f20396b;
        if (f2 < f3 || f2 > f4) {
            return null;
        }
        return Long.valueOf((long) f2);
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final C5645n m23153d(long j2, long j3) {
        if (j3 <= Long.MIN_VALUE) {
            return C5645n.f20529f.m23032a();
        }
        return new C5645n(j2, j3 - 1);
    }

    @InterfaceC5481e(name = "doubleRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: a */
    public static final boolean m23090a(@InterfaceC5816d InterfaceC5638g<Double> interfaceC5638g, byte b2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Double.valueOf(b2));
    }

    @InterfaceC5481e(name = "doubleRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: b */
    public static final boolean m23131b(@InterfaceC5816d InterfaceC5638g<Double> interfaceC5638g, int i2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Double.valueOf(i2));
    }

    @InterfaceC5817e
    /* renamed from: c */
    public static final Short m23143c(long j2) {
        long j3 = 32767;
        if (-32768 <= j2 && j3 >= j2) {
            return Short.valueOf((short) j2);
        }
        return null;
    }

    @InterfaceC5481e(name = "byteRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: a */
    public static final boolean m23091a(@InterfaceC5816d InterfaceC5638g<Byte> interfaceC5638g, double d2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Byte m23079a = m23079a(d2);
        if (m23079a != null) {
            return interfaceC5638g.contains(m23079a);
        }
        return false;
    }

    @InterfaceC5481e(name = "doubleRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: b */
    public static final boolean m23132b(@InterfaceC5816d InterfaceC5638g<Double> interfaceC5638g, long j2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Double.valueOf(j2));
    }

    @InterfaceC5816d
    /* renamed from: c */
    public static final <T extends Comparable<? super T>> T m23140c(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        C5544i0.m22546f(t, "$this$coerceAtMost");
        C5544i0.m22546f(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public static final C5642k m23152d(short s, short s2) {
        return new C5642k(s, s2 - 1);
    }

    @InterfaceC5481e(name = "byteRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: a */
    public static final boolean m23092a(@InterfaceC5816d InterfaceC5638g<Byte> interfaceC5638g, float f2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Byte m23080a = m23080a(f2);
        if (m23080a != null) {
            return interfaceC5638g.contains(m23080a);
        }
        return false;
    }

    @InterfaceC5481e(name = "doubleRangeContains")
    @InterfaceC5216c(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    /* renamed from: b */
    public static final boolean m23133b(@InterfaceC5816d InterfaceC5638g<Double> interfaceC5638g, short s) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        return interfaceC5638g.contains(Double.valueOf(s));
    }

    @InterfaceC5481e(name = "byteRangeContains")
    /* renamed from: a */
    public static final boolean m23093a(@InterfaceC5816d InterfaceC5638g<Byte> interfaceC5638g, int i2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Byte m23081a = m23081a(i2);
        if (m23081a != null) {
            return interfaceC5638g.contains(m23081a);
        }
        return false;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public static final Integer m23121b(long j2) {
        long j3 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= j2 && j3 >= j2) {
            return Integer.valueOf((int) j2);
        }
        return null;
    }

    @InterfaceC5481e(name = "byteRangeContains")
    /* renamed from: a */
    public static final boolean m23094a(@InterfaceC5816d InterfaceC5638g<Byte> interfaceC5638g, long j2) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Byte m23082a = m23082a(j2);
        if (m23082a != null) {
            return interfaceC5638g.contains(m23082a);
        }
        return false;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public static final Integer m23119b(double d2) {
        double d3 = Integer.MAX_VALUE;
        if (d2 < Integer.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Integer.valueOf((int) d2);
    }

    @InterfaceC5481e(name = "byteRangeContains")
    /* renamed from: a */
    public static final boolean m23095a(@InterfaceC5816d InterfaceC5638g<Byte> interfaceC5638g, short s) {
        C5544i0.m22546f(interfaceC5638g, "$this$contains");
        Byte m23083a = m23083a(s);
        if (m23083a != null) {
            return interfaceC5638g.contains(m23083a);
        }
        return false;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public static final Integer m23120b(float f2) {
        float f3 = Integer.MAX_VALUE;
        if (f2 < Integer.MIN_VALUE || f2 > f3) {
            return null;
        }
        return Integer.valueOf((int) f2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5640i m23065a(int i2, byte b2) {
        return C5640i.f20510d.m23022a(i2, b2, -1);
    }

    @InterfaceC5817e
    /* renamed from: b */
    public static final Short m23126b(int i2) {
        if (-32768 <= i2 && 32767 >= i2) {
            return Short.valueOf((short) i2);
        }
        return null;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23073a(long j2, byte b2) {
        return C5643l.f20520d.m23028a(j2, b2, -1L);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5642k m23106b(int i2, byte b2) {
        return new C5642k(i2, b2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5640i m23069a(short s, byte b2) {
        return C5640i.f20510d.m23022a(s, b2, -1);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5645n m23112b(long j2, byte b2) {
        return new C5645n(j2, b2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5632a m23060a(char c2, char c3) {
        return C5632a.f20494d.m23007a(c2, c3, -1);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5642k m23108b(short s, byte b2) {
        return new C5642k(s, b2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23074a(long j2, int i2) {
        return C5643l.f20520d.m23028a(j2, i2, -1L);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5634c m23103b(char c2, char c3) {
        if (c3 <= 0) {
            return C5634c.f20503f.m23011a();
        }
        return new C5634c(c2, (char) (c3 - 1));
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5640i m23063a(byte b2, int i2) {
        return C5640i.f20510d.m23022a(b2, i2, -1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5640i m23070a(short s, int i2) {
        return C5640i.f20510d.m23022a(s, i2, -1);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5645n m23113b(long j2, int i2) {
        return new C5645n(j2, i2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23072a(int i2, long j2) {
        return C5643l.f20520d.m23028a(i2, j2, -1L);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5642k m23104b(byte b2, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return C5642k.f20519f.m23026a();
        }
        return new C5642k(b2, i2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23071a(byte b2, long j2) {
        return C5643l.f20520d.m23028a(b2, j2, -1L);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23078a(short s, long j2) {
        return C5643l.f20520d.m23028a(s, j2, -1L);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5642k m23109b(short s, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return C5642k.f20519f.m23026a();
        }
        return new C5642k(s, i2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5640i m23066a(int i2, short s) {
        return C5640i.f20510d.m23022a(i2, s, -1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23075a(long j2, short s) {
        return C5643l.f20520d.m23028a(j2, s, -1L);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5645n m23111b(int i2, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return C5645n.f20529f.m23032a();
        }
        return new C5645n(i2, j2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5640i m23064a(byte b2, short s) {
        return C5640i.f20510d.m23022a(b2, s, -1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5640i m23067a(@InterfaceC5816d C5640i c5640i) {
        C5544i0.m22546f(c5640i, "$this$reversed");
        return C5640i.f20510d.m23022a(c5640i.getLast(), c5640i.getFirst(), -c5640i.m23021b());
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5645n m23110b(byte b2, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return C5645n.f20529f.m23032a();
        }
        return new C5645n(b2, j2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23076a(@InterfaceC5816d C5643l c5643l) {
        C5544i0.m22546f(c5643l, "$this$reversed");
        return C5643l.f20520d.m23028a(c5643l.getLast(), c5643l.getFirst(), -c5643l.m23027b());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5632a m23061a(@InterfaceC5816d C5632a c5632a) {
        C5544i0.m22546f(c5632a, "$this$reversed");
        return C5632a.f20494d.m23007a(c5632a.getLast(), c5632a.getFirst(), -c5632a.m23006b());
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5645n m23115b(short s, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return C5645n.f20529f.m23032a();
        }
        return new C5645n(s, j2 - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static C5640i m23068a(@InterfaceC5816d C5640i c5640i, int i2) {
        C5544i0.m22546f(c5640i, "$this$step");
        C5647p.m23042a(i2 > 0, Integer.valueOf(i2));
        C5640i.a aVar = C5640i.f20510d;
        int first = c5640i.getFirst();
        int last = c5640i.getLast();
        if (c5640i.m23021b() <= 0) {
            i2 = -i2;
        }
        return aVar.m23022a(first, last, i2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5642k m23107b(int i2, short s) {
        return new C5642k(i2, s - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5643l m23077a(@InterfaceC5816d C5643l c5643l, long j2) {
        C5544i0.m22546f(c5643l, "$this$step");
        C5647p.m23042a(j2 > 0, Long.valueOf(j2));
        C5643l.a aVar = C5643l.f20520d;
        long first = c5643l.getFirst();
        long last = c5643l.getLast();
        if (c5643l.m23027b() <= 0) {
            j2 = -j2;
        }
        return aVar.m23028a(first, last, j2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5645n m23114b(long j2, short s) {
        return new C5645n(j2, s - 1);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final C5642k m23105b(byte b2, short s) {
        return new C5642k(b2, s - 1);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final C5632a m23062a(@InterfaceC5816d C5632a c5632a, int i2) {
        C5544i0.m22546f(c5632a, "$this$step");
        C5647p.m23042a(i2 > 0, Integer.valueOf(i2));
        C5632a.a aVar = C5632a.f20494d;
        char first = c5632a.getFirst();
        char last = c5632a.getLast();
        if (c5632a.m23006b() <= 0) {
            i2 = -i2;
        }
        return aVar.m23007a(first, last, i2);
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final <T extends Comparable<? super T>> T m23118b(@InterfaceC5816d T t, @InterfaceC5816d T t2) {
        C5544i0.m22546f(t, "$this$coerceAtLeast");
        C5544i0.m22546f(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    @InterfaceC5817e
    /* renamed from: a */
    public static final Byte m23081a(int i2) {
        if (-128 <= i2 && 127 >= i2) {
            return Byte.valueOf((byte) i2);
        }
        return null;
    }

    @InterfaceC5817e
    /* renamed from: a */
    public static final Byte m23082a(long j2) {
        long j3 = 127;
        if (-128 <= j2 && j3 >= j2) {
            return Byte.valueOf((byte) j2);
        }
        return null;
    }

    @InterfaceC5817e
    /* renamed from: a */
    public static final Byte m23083a(short s) {
        short s2 = (short) 127;
        if (((short) (-128)) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @InterfaceC5817e
    /* renamed from: a */
    public static final Byte m23079a(double d2) {
        double d3 = 127;
        if (d2 < -128 || d2 > d3) {
            return null;
        }
        return Byte.valueOf((byte) d2);
    }

    @InterfaceC5817e
    /* renamed from: a */
    public static final Byte m23080a(float f2) {
        float f3 = 127;
        if (f2 < -128 || f2 > f3) {
            return null;
        }
        return Byte.valueOf((byte) f2);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Comparable<? super T>> T m23086a(@InterfaceC5816d T t, @InterfaceC5817e T t2, @InterfaceC5817e T t3) {
        C5544i0.m22546f(t, "$this$coerceIn");
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) <= 0) {
                if (t.compareTo(t2) < 0) {
                    return t2;
                }
                if (t.compareTo(t3) > 0) {
                    return t3;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
        } else {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    /* renamed from: a */
    public static final byte m23045a(byte b2, byte b3, byte b4) {
        if (b3 <= b4) {
            return b2 < b3 ? b3 : b2 > b4 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b4) + " is less than minimum " + ((int) b3) + '.');
    }

    /* renamed from: a */
    public static final short m23088a(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    /* renamed from: a */
    public static int m23051a(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    /* renamed from: a */
    public static final long m23056a(long j2, long j3, long j4) {
        if (j3 <= j4) {
            return j2 < j3 ? j3 : j2 > j4 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j4 + " is less than minimum " + j3 + '.');
    }

    /* renamed from: a */
    public static final float m23049a(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    /* renamed from: a */
    public static final double m23048a(double d2, double d3, double d4) {
        if (d3 <= d4) {
            return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d4 + " is less than minimum " + d3 + '.');
    }

    @InterfaceC5610t0(version = "1.1")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Comparable<? super T>> T m23084a(@InterfaceC5816d T t, @InterfaceC5816d InterfaceC5637f<T> interfaceC5637f) {
        C5544i0.m22546f(t, "$this$coerceIn");
        C5544i0.m22546f(interfaceC5637f, "range");
        if (!interfaceC5637f.isEmpty()) {
            return (!interfaceC5637f.mo23014a(t, interfaceC5637f.getStart()) || interfaceC5637f.mo23014a(interfaceC5637f.getStart(), t)) ? (!interfaceC5637f.mo23014a(interfaceC5637f.getEndInclusive(), t) || interfaceC5637f.mo23014a(t, interfaceC5637f.getEndInclusive())) ? t : interfaceC5637f.getEndInclusive() : interfaceC5637f.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC5637f + '.');
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T extends Comparable<? super T>> T m23085a(@InterfaceC5816d T t, @InterfaceC5816d InterfaceC5638g<T> interfaceC5638g) {
        C5544i0.m22546f(t, "$this$coerceIn");
        C5544i0.m22546f(interfaceC5638g, "range");
        if (interfaceC5638g instanceof InterfaceC5637f) {
            return (T) m23084a((Comparable) t, (InterfaceC5637f) interfaceC5638g);
        }
        if (!interfaceC5638g.isEmpty()) {
            return t.compareTo(interfaceC5638g.getStart()) < 0 ? interfaceC5638g.getStart() : t.compareTo(interfaceC5638g.getEndInclusive()) > 0 ? interfaceC5638g.getEndInclusive() : t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC5638g + '.');
    }

    /* renamed from: a */
    public static final int m23052a(int i2, @InterfaceC5816d InterfaceC5638g<Integer> interfaceC5638g) {
        C5544i0.m22546f(interfaceC5638g, "range");
        if (interfaceC5638g instanceof InterfaceC5637f) {
            return ((Number) m23084a(Integer.valueOf(i2), (InterfaceC5637f<Integer>) interfaceC5638g)).intValue();
        }
        if (!interfaceC5638g.isEmpty()) {
            return i2 < interfaceC5638g.getStart().intValue() ? interfaceC5638g.getStart().intValue() : i2 > interfaceC5638g.getEndInclusive().intValue() ? interfaceC5638g.getEndInclusive().intValue() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC5638g + '.');
    }

    /* renamed from: a */
    public static final long m23057a(long j2, @InterfaceC5816d InterfaceC5638g<Long> interfaceC5638g) {
        C5544i0.m22546f(interfaceC5638g, "range");
        if (interfaceC5638g instanceof InterfaceC5637f) {
            return ((Number) m23084a(Long.valueOf(j2), (InterfaceC5637f<Long>) interfaceC5638g)).longValue();
        }
        if (!interfaceC5638g.isEmpty()) {
            return j2 < interfaceC5638g.getStart().longValue() ? interfaceC5638g.getStart().longValue() : j2 > interfaceC5638g.getEndInclusive().longValue() ? interfaceC5638g.getEndInclusive().longValue() : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + interfaceC5638g + '.');
    }
}
