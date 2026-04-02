package i.q2.t;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CallableReference.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p implements i.w2.b, Serializable {

    @i.t0(version = "1.1")
    public static final Object NO_RECEIVER = a.a;
    private transient i.w2.b a;

    /* JADX INFO: renamed from: receiver */
    @i.t0(version = "1.1")
    protected final Object f12232receiver;

    /* JADX INFO: compiled from: CallableReference.java */
    @i.t0(version = "1.2")
    private static class a implements Serializable {
        private static final a a = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return a;
        }
    }

    public p() {
        this(NO_RECEIVER);
    }

    @Override // i.w2.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // i.w2.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @i.t0(version = "1.1")
    public i.w2.b compute() {
        i.w2.b bVar = this.a;
        if (bVar != null) {
            return bVar;
        }
        i.w2.b bVarComputeReflected = computeReflected();
        this.a = bVarComputeReflected;
        return bVarComputeReflected;
    }

    protected abstract i.w2.b computeReflected();

    @Override // i.w2.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @i.t0(version = "1.1")
    public Object getBoundReceiver() {
        return this.f12232receiver;
    }

    @Override // i.w2.b
    public String getName() {
        throw new AbstractMethodError();
    }

    public i.w2.f getOwner() {
        throw new AbstractMethodError();
    }

    @Override // i.w2.b
    public List<i.w2.l> getParameters() {
        return getReflected().getParameters();
    }

    @i.t0(version = "1.1")
    protected i.w2.b getReflected() {
        i.w2.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute;
        }
        throw new i.q2.l();
    }

    @Override // i.w2.b
    public i.w2.q getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override // i.w2.b
    @i.t0(version = "1.1")
    public List<i.w2.r> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // i.w2.b
    @i.t0(version = "1.1")
    public i.w2.u getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // i.w2.b
    @i.t0(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // i.w2.b
    @i.t0(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // i.w2.b
    @i.t0(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // i.w2.b, i.w2.g
    @i.t0(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @i.t0(version = "1.1")
    protected p(Object obj) {
        this.f12232receiver = obj;
    }
}
