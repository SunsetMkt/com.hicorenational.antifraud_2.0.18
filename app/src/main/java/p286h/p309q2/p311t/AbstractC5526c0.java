package p286h.p309q2.p311t;

import java.io.Serializable;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5418m;
import p286h.p309q2.p310s.InterfaceC5495a;
import p286h.p309q2.p310s.InterfaceC5496b;
import p286h.p309q2.p310s.InterfaceC5497c;
import p286h.p309q2.p310s.InterfaceC5498d;
import p286h.p309q2.p310s.InterfaceC5499e;
import p286h.p309q2.p310s.InterfaceC5500f;
import p286h.p309q2.p310s.InterfaceC5501g;
import p286h.p309q2.p310s.InterfaceC5502h;
import p286h.p309q2.p310s.InterfaceC5503i;
import p286h.p309q2.p310s.InterfaceC5504j;
import p286h.p309q2.p310s.InterfaceC5505k;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5507m;
import p286h.p309q2.p310s.InterfaceC5508n;
import p286h.p309q2.p310s.InterfaceC5509o;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p310s.InterfaceC5512r;
import p286h.p309q2.p310s.InterfaceC5513s;
import p286h.p309q2.p310s.InterfaceC5514t;
import p286h.p309q2.p310s.InterfaceC5515u;
import p286h.p309q2.p310s.InterfaceC5516v;
import p286h.p309q2.p310s.InterfaceC5517w;

/* compiled from: FunctionImpl.java */
@InterfaceC5216c(level = EnumC5220d.ERROR, message = "This class is no longer supported, do not use it.")
@Deprecated
/* renamed from: h.q2.t.c0 */
/* loaded from: classes2.dex */
public abstract class AbstractC5526c0 implements InterfaceC5418m, Serializable, InterfaceC5495a, InterfaceC5506l, InterfaceC5510p, InterfaceC5511q, InterfaceC5512r, InterfaceC5513s, InterfaceC5514t, InterfaceC5515u, InterfaceC5516v, InterfaceC5517w, InterfaceC5496b, InterfaceC5497c, InterfaceC5498d, InterfaceC5499e, InterfaceC5500f, InterfaceC5501g, InterfaceC5502h, InterfaceC5503i, InterfaceC5504j, InterfaceC5505k, InterfaceC5507m, InterfaceC5508n, InterfaceC5509o {
    /* renamed from: a */
    private void m22468a(int i2) {
        if (getArity() != i2) {
            m22469b(i2);
        }
    }

    /* renamed from: b */
    private void m22469b(int i2) {
        throw new IllegalStateException("Wrong function arity, expected: " + i2 + ", actual: " + getArity());
    }

    public abstract int getArity();

    @Override // p286h.p309q2.p310s.InterfaceC5495a
    public Object invoke() {
        m22468a(0);
        return invokeVararg(new Object[0]);
    }

    public Object invokeVararg(Object... objArr) {
        throw new UnsupportedOperationException();
    }

    @Override // p286h.p309q2.p310s.InterfaceC5506l
    public Object invoke(Object obj) {
        m22468a(1);
        return invokeVararg(obj);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5510p
    public Object invoke(Object obj, Object obj2) {
        m22468a(2);
        return invokeVararg(obj, obj2);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5511q
    public Object invoke(Object obj, Object obj2, Object obj3) {
        m22468a(3);
        return invokeVararg(obj, obj2, obj3);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5512r
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        m22468a(4);
        return invokeVararg(obj, obj2, obj3, obj4);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5513s
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        m22468a(5);
        return invokeVararg(obj, obj2, obj3, obj4, obj5);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5514t
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        m22468a(6);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5515u
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        m22468a(7);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5516v
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        m22468a(8);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5517w
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        m22468a(9);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5496b
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        m22468a(10);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5497c
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        m22468a(11);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5498d
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        m22468a(12);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5499e
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        m22468a(13);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5500f
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        m22468a(14);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5501g
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        m22468a(15);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5502h
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        m22468a(16);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5503i
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        m22468a(17);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5504j
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        m22468a(18);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5505k
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        m22468a(19);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5507m
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        m22468a(20);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5508n
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        m22468a(21);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // p286h.p309q2.p310s.InterfaceC5509o
    public Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        m22468a(22);
        return invokeVararg(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
