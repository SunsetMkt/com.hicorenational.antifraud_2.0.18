package m;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import m.c;
import okhttp3.Request;

/* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends c.a {
    final Executor a;

    /* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
    class a implements c<Object, m.b<?>> {
        final /* synthetic */ Type a;

        a(Type type) {
            this.a = type;
        }

        @Override // m.c
        public Type a() {
            return this.a;
        }

        @Override // m.c
        public m.b<?> a(m.b<Object> bVar) {
            return new b(g.this.a, bVar);
        }
    }

    /* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
    static final class b<T> implements m.b<T> {
        final Executor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final m.b<T> f12710b;

        /* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
        class a implements d<T> {
            final /* synthetic */ d a;

            /* JADX INFO: renamed from: m.g$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
            class RunnableC0270a implements Runnable {
                final /* synthetic */ m a;

                RunnableC0270a(m mVar) {
                    this.a = mVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f12710b.isCanceled()) {
                        a aVar = a.this;
                        aVar.a.onFailure(b.this, new IOException("Canceled"));
                    } else {
                        a aVar2 = a.this;
                        aVar2.a.onResponse(b.this, this.a);
                    }
                }
            }

            /* JADX INFO: renamed from: m.g$b$a$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ExecutorCallAdapterFactory.java */
            class RunnableC0271b implements Runnable {
                final /* synthetic */ Throwable a;

                RunnableC0271b(Throwable th) {
                    this.a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.a.onFailure(b.this, this.a);
                }
            }

            a(d dVar) {
                this.a = dVar;
            }

            @Override // m.d
            public void onFailure(m.b<T> bVar, Throwable th) {
                b.this.a.execute(new RunnableC0271b(th));
            }

            @Override // m.d
            public void onResponse(m.b<T> bVar, m<T> mVar) {
                b.this.a.execute(new RunnableC0270a(mVar));
            }
        }

        b(Executor executor, m.b<T> bVar) {
            this.a = executor;
            this.f12710b = bVar;
        }

        @Override // m.b
        public void a(d<T> dVar) {
            p.a(dVar, "callback == null");
            this.f12710b.a(new a(dVar));
        }

        @Override // m.b
        public void cancel() {
            this.f12710b.cancel();
        }

        @Override // m.b
        public m<T> execute() throws IOException {
            return this.f12710b.execute();
        }

        @Override // m.b
        public boolean isCanceled() {
            return this.f12710b.isCanceled();
        }

        @Override // m.b
        public boolean isExecuted() {
            return this.f12710b.isExecuted();
        }

        @Override // m.b
        public Request request() {
            return this.f12710b.request();
        }

        @Override // m.b
        public m.b<T> clone() {
            return new b(this.a, this.f12710b.clone());
        }
    }

    g(Executor executor) {
        this.a = executor;
    }

    @Override // m.c.a
    public c<?, ?> a(Type type, Annotation[] annotationArr, n nVar) {
        if (c.a.a(type) != m.b.class) {
            return null;
        }
        return new a(p.b(type));
    }
}
