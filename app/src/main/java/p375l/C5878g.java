package p375l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import p375l.InterfaceC5874c;

/* compiled from: ExecutorCallAdapterFactory.java */
/* renamed from: l.g */
/* loaded from: classes2.dex */
final class C5878g extends InterfaceC5874c.a {

    /* renamed from: a */
    final Executor f21200a;

    /* compiled from: ExecutorCallAdapterFactory.java */
    /* renamed from: l.g$a */
    class a implements InterfaceC5874c<Object, InterfaceC5873b<?>> {

        /* renamed from: a */
        final /* synthetic */ Type f21201a;

        a(Type type) {
            this.f21201a = type;
        }

        @Override // p375l.InterfaceC5874c
        /* renamed from: a */
        public Type mo24749a() {
            return this.f21201a;
        }

        @Override // p375l.InterfaceC5874c
        /* renamed from: a, reason: avoid collision after fix types in other method */
        public InterfaceC5873b<?> mo24748a(InterfaceC5873b<Object> interfaceC5873b) {
            return new b(C5878g.this.f21200a, interfaceC5873b);
        }
    }

    /* compiled from: ExecutorCallAdapterFactory.java */
    /* renamed from: l.g$b */
    static final class b<T> implements InterfaceC5873b<T> {

        /* renamed from: a */
        final Executor f21203a;

        /* renamed from: b */
        final InterfaceC5873b<T> f21204b;

        /* compiled from: ExecutorCallAdapterFactory.java */
        /* renamed from: l.g$b$a */
        class a implements InterfaceC5875d<T> {

            /* renamed from: a */
            final /* synthetic */ InterfaceC5875d f21205a;

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: l.g$b$a$a, reason: collision with other inner class name */
            class RunnableC7435a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C5884m f21207a;

                RunnableC7435a(C5884m c5884m) {
                    this.f21207a = c5884m;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f21204b.isCanceled()) {
                        a aVar = a.this;
                        aVar.f21205a.onFailure(b.this, new IOException("Canceled"));
                    } else {
                        a aVar2 = a.this;
                        aVar2.f21205a.onResponse(b.this, this.f21207a);
                    }
                }
            }

            /* compiled from: ExecutorCallAdapterFactory.java */
            /* renamed from: l.g$b$a$b, reason: collision with other inner class name */
            class RunnableC7436b implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Throwable f21209a;

                RunnableC7436b(Throwable th) {
                    this.f21209a = th;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.f21205a.onFailure(b.this, this.f21209a);
                }
            }

            a(InterfaceC5875d interfaceC5875d) {
                this.f21205a = interfaceC5875d;
            }

            @Override // p375l.InterfaceC5875d
            public void onFailure(InterfaceC5873b<T> interfaceC5873b, Throwable th) {
                b.this.f21203a.execute(new RunnableC7436b(th));
            }

            @Override // p375l.InterfaceC5875d
            public void onResponse(InterfaceC5873b<T> interfaceC5873b, C5884m<T> c5884m) {
                b.this.f21203a.execute(new RunnableC7435a(c5884m));
            }
        }

        b(Executor executor, InterfaceC5873b<T> interfaceC5873b) {
            this.f21203a = executor;
            this.f21204b = interfaceC5873b;
        }

        @Override // p375l.InterfaceC5873b
        /* renamed from: a */
        public void mo24747a(InterfaceC5875d<T> interfaceC5875d) {
            C5887p.m24845a(interfaceC5875d, "callback == null");
            this.f21204b.mo24747a(new a(interfaceC5875d));
        }

        @Override // p375l.InterfaceC5873b
        public void cancel() {
            this.f21204b.cancel();
        }

        @Override // p375l.InterfaceC5873b
        public C5884m<T> execute() throws IOException {
            return this.f21204b.execute();
        }

        @Override // p375l.InterfaceC5873b
        public boolean isCanceled() {
            return this.f21204b.isCanceled();
        }

        @Override // p375l.InterfaceC5873b
        public boolean isExecuted() {
            return this.f21204b.isExecuted();
        }

        @Override // p375l.InterfaceC5873b
        public Request request() {
            return this.f21204b.request();
        }

        @Override // p375l.InterfaceC5873b
        public InterfaceC5873b<T> clone() {
            return new b(this.f21203a, this.f21204b.clone());
        }
    }

    C5878g(Executor executor) {
        this.f21200a = executor;
    }

    @Override // p375l.InterfaceC5874c.a
    /* renamed from: a */
    public InterfaceC5874c<?, ?> mo24752a(Type type, Annotation[] annotationArr, C5885n c5885n) {
        if (InterfaceC5874c.a.m24750a(type) != InterfaceC5873b.class) {
            return null;
        }
        return new a(C5887p.m24856b(type));
    }
}
