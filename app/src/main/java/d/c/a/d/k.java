package d.c.a.d;

/* JADX INFO: compiled from: TaskCompletionSource.java */
/* JADX INFO: loaded from: classes.dex */
public class k<TResult> {
    private final com.hihonor.cloudservice.tasks.q.i<TResult> a = new com.hihonor.cloudservice.tasks.q.i<>();

    /* JADX INFO: compiled from: TaskCompletionSource.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.a.f();
        }
    }

    public k() {
    }

    public j<TResult> a() {
        return this.a;
    }

    public k(d.c.a.d.a aVar) {
        aVar.a(new a());
    }

    public void a(Exception exc) {
        this.a.a(exc);
    }

    public void a(TResult tresult) {
        this.a.a(tresult);
    }
}
