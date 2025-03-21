package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gu implements hq<gu, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public String f646a;

    /* renamed from: d, reason: collision with other field name */
    public String f651d;

    /* renamed from: a, reason: collision with other field name */
    private static final Cif f644a = new Cif("Target");

    /* renamed from: a, reason: collision with root package name */
    private static final hx f13035a = new hx("", (byte) 10, 1);

    /* renamed from: b, reason: collision with root package name */
    private static final hx f13036b = new hx("", (byte) 11, 2);

    /* renamed from: c, reason: collision with root package name */
    private static final hx f13037c = new hx("", (byte) 11, 3);

    /* renamed from: d, reason: collision with root package name */
    private static final hx f13038d = new hx("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hx f13039e = new hx("", (byte) 2, 5);

    /* renamed from: f, reason: collision with root package name */
    private static final hx f13040f = new hx("", (byte) 11, 7);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f647a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public long f645a = 5;

    /* renamed from: b, reason: collision with other field name */
    public String f649b = "xiaomi.com";

    /* renamed from: c, reason: collision with other field name */
    public String f650c = "";

    /* renamed from: a, reason: collision with other field name */
    public boolean f648a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m506a() {
        return this.f647a.get(0);
    }

    public boolean b() {
        return this.f646a != null;
    }

    public boolean c() {
        return this.f649b != null;
    }

    public boolean d() {
        return this.f650c != null;
    }

    public boolean e() {
        return this.f647a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gu)) {
            return m507a((gu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f651d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f645a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f646a;
        if (str == null) {
            sb.append(c.c.a.b.a.a.f3101h);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f649b;
            if (str2 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f650c;
            if (str3 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f648a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f651d;
            if (str4 == null) {
                sb.append(c.c.a.b.a.a.f3101h);
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f647a.set(0, z);
    }

    public void b(boolean z) {
        this.f647a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m507a(gu guVar) {
        if (guVar == null || this.f645a != guVar.f645a) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = guVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f646a.equals(guVar.f646a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = guVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f649b.equals(guVar.f649b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = guVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f650c.equals(guVar.f650c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = guVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f648a == guVar.f648a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = guVar.f();
        if (f2 || f3) {
            return f2 && f3 && this.f651d.equals(guVar.f651d);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f644a);
        iaVar.a(f13035a);
        iaVar.a(this.f645a);
        iaVar.b();
        if (this.f646a != null) {
            iaVar.a(f13036b);
            iaVar.a(this.f646a);
            iaVar.b();
        }
        if (this.f649b != null && c()) {
            iaVar.a(f13037c);
            iaVar.a(this.f649b);
            iaVar.b();
        }
        if (this.f650c != null && d()) {
            iaVar.a(f13038d);
            iaVar.a(this.f650c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(f13039e);
            iaVar.a(this.f648a);
            iaVar.b();
        }
        if (this.f651d != null && f()) {
            iaVar.a(f13040f);
            iaVar.a(this.f651d);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo611a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gu guVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!gu.class.equals(guVar.getClass())) {
            return gu.class.getName().compareTo(guVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(m506a()).compareTo(Boolean.valueOf(guVar.m506a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (m506a() && (a7 = hr.a(this.f645a, guVar.f645a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(guVar.b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (b() && (a6 = hr.a(this.f646a, guVar.f646a)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(guVar.c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (c() && (a5 = hr.a(this.f649b, guVar.f649b)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(guVar.d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (d() && (a4 = hr.a(this.f650c, guVar.f650c)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(guVar.e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (e() && (a3 = hr.a(this.f648a, guVar.f648a)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(guVar.f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!f() || (a2 = hr.a(this.f651d, guVar.f651d)) == 0) {
            return 0;
        }
        return a2;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
        iaVar.mo607a();
        while (true) {
            hx mo603a = iaVar.mo603a();
            byte b2 = mo603a.f13224a;
            if (b2 == 0) {
                break;
            }
            short s = mo603a.f898a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s != 7) {
                                    id.a(iaVar, b2);
                                } else if (b2 == 11) {
                                    this.f651d = iaVar.mo608a();
                                } else {
                                    id.a(iaVar, b2);
                                }
                            } else if (b2 == 2) {
                                this.f648a = iaVar.mo613a();
                                b(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                        } else if (b2 == 11) {
                            this.f650c = iaVar.mo608a();
                        } else {
                            id.a(iaVar, b2);
                        }
                    } else if (b2 == 11) {
                        this.f649b = iaVar.mo608a();
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f646a = iaVar.mo608a();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 10) {
                this.f645a = iaVar.mo602a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m506a()) {
            a();
            return;
        }
        throw new ib("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a() {
        if (this.f646a != null) {
            return;
        }
        throw new ib("Required field 'userId' was not present! Struct: " + toString());
    }
}
