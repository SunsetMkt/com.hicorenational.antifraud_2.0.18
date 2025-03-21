package p286h.p309q2.p311t;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import p286h.InterfaceC5610t0;
import p286h.p309q2.C5488l;
import p286h.p320w2.EnumC5680u;
import p286h.p320w2.InterfaceC5661b;
import p286h.p320w2.InterfaceC5665f;
import p286h.p320w2.InterfaceC5671l;
import p286h.p320w2.InterfaceC5676q;
import p286h.p320w2.InterfaceC5677r;

/* compiled from: CallableReference.java */
/* renamed from: h.q2.t.p */
/* loaded from: classes2.dex */
public abstract class AbstractC5564p implements InterfaceC5661b, Serializable {

    @InterfaceC5610t0(version = "1.1")
    public static final Object NO_RECEIVER = a.f20410a;

    /* renamed from: a */
    private transient InterfaceC5661b f20409a;

    /* renamed from: receiver, reason: collision with root package name */
    @InterfaceC5610t0(version = "1.1")
    protected final Object f25901receiver;

    /* compiled from: CallableReference.java */
    @InterfaceC5610t0(version = "1.2")
    /* renamed from: h.q2.t.p$a */
    private static class a implements Serializable {

        /* renamed from: a */
        private static final a f20410a = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f20410a;
        }
    }

    public AbstractC5564p() {
        this(NO_RECEIVER);
    }

    @Override // p286h.p320w2.InterfaceC5661b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // p286h.p320w2.InterfaceC5661b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @InterfaceC5610t0(version = "1.1")
    public InterfaceC5661b compute() {
        InterfaceC5661b interfaceC5661b = this.f20409a;
        if (interfaceC5661b != null) {
            return interfaceC5661b;
        }
        InterfaceC5661b computeReflected = computeReflected();
        this.f20409a = computeReflected;
        return computeReflected;
    }

    protected abstract InterfaceC5661b computeReflected();

    @Override // p286h.p320w2.InterfaceC5660a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @InterfaceC5610t0(version = "1.1")
    public Object getBoundReceiver() {
        return this.f25901receiver;
    }

    @Override // p286h.p320w2.InterfaceC5661b
    public String getName() {
        throw new AbstractMethodError();
    }

    public InterfaceC5665f getOwner() {
        throw new AbstractMethodError();
    }

    @Override // p286h.p320w2.InterfaceC5661b
    public List<InterfaceC5671l> getParameters() {
        return getReflected().getParameters();
    }

    @InterfaceC5610t0(version = "1.1")
    protected InterfaceC5661b getReflected() {
        InterfaceC5661b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new C5488l();
    }

    @Override // p286h.p320w2.InterfaceC5661b
    public InterfaceC5676q getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override // p286h.p320w2.InterfaceC5661b
    @InterfaceC5610t0(version = "1.1")
    public List<InterfaceC5677r> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // p286h.p320w2.InterfaceC5661b
    @InterfaceC5610t0(version = "1.1")
    public EnumC5680u getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // p286h.p320w2.InterfaceC5661b
    @InterfaceC5610t0(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // p286h.p320w2.InterfaceC5661b
    @InterfaceC5610t0(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // p286h.p320w2.InterfaceC5661b
    @InterfaceC5610t0(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // p286h.p320w2.InterfaceC5661b, p286h.p320w2.InterfaceC5666g
    @InterfaceC5610t0(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @InterfaceC5610t0(version = "1.1")
    protected AbstractC5564p(Object obj) {
        this.f25901receiver = obj;
    }
}
