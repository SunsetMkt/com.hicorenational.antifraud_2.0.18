package h.a;

/* JADX INFO: compiled from: Notification.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a0<Object> f10227b = new a0<>(null);
    final Object a;

    private a0(Object obj) {
        this.a = obj;
    }

    @h.a.t0.f
    public static <T> a0<T> f() {
        return (a0<T>) f10227b;
    }

    @h.a.t0.g
    public Throwable a() {
        Object obj = this.a;
        if (h.a.y0.j.q.isError(obj)) {
            return h.a.y0.j.q.getError(obj);
        }
        return null;
    }

    @h.a.t0.g
    public T b() {
        Object obj = this.a;
        if (obj == null || h.a.y0.j.q.isError(obj)) {
            return null;
        }
        return (T) this.a;
    }

    public boolean c() {
        return this.a == null;
    }

    public boolean d() {
        return h.a.y0.j.q.isError(this.a);
    }

    public boolean e() {
        Object obj = this.a;
        return (obj == null || h.a.y0.j.q.isError(obj)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a0) {
            return h.a.y0.b.b.a(this.a, ((a0) obj).a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (h.a.y0.j.q.isError(obj)) {
            return "OnErrorNotification[" + h.a.y0.j.q.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.a + "]";
    }

    @h.a.t0.f
    public static <T> a0<T> a(@h.a.t0.f T t) {
        h.a.y0.b.b.a((Object) t, "value is null");
        return new a0<>(t);
    }

    @h.a.t0.f
    public static <T> a0<T> a(@h.a.t0.f Throwable th) {
        h.a.y0.b.b.a(th, "error is null");
        return new a0<>(h.a.y0.j.q.error(th));
    }
}
