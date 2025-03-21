package p375l;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* compiled from: OkHttpCall.java */
/* renamed from: l.i */
/* loaded from: classes2.dex */
final class C5880i<T> implements InterfaceC5873b<T> {

    /* renamed from: a */
    private final C5886o<T, ?> f21212a;

    /* renamed from: b */
    @Nullable
    private final Object[] f21213b;

    /* renamed from: c */
    private volatile boolean f21214c;

    /* renamed from: d */
    @GuardedBy("this")
    @Nullable
    private Call f21215d;

    /* renamed from: e */
    @GuardedBy("this")
    @Nullable
    private Throwable f21216e;

    /* renamed from: f */
    @GuardedBy("this")
    private boolean f21217f;

    /* compiled from: OkHttpCall.java */
    /* renamed from: l.i$a */
    class a implements Callback {

        /* renamed from: a */
        final /* synthetic */ InterfaceC5875d f21218a;

        a(InterfaceC5875d interfaceC5875d) {
            this.f21218a = interfaceC5875d;
        }

        /* renamed from: a */
        private void m24759a(Throwable th) {
            try {
                this.f21218a.onFailure(C5880i.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            m24759a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.f21218a.onResponse(C5880i.this, C5880i.this.m24758a(response));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                m24759a(th2);
            }
        }
    }

    /* compiled from: OkHttpCall.java */
    /* renamed from: l.i$b */
    static final class b extends ResponseBody {

        /* renamed from: a */
        private final ResponseBody f21220a;

        /* renamed from: b */
        IOException f21221b;

        /* compiled from: OkHttpCall.java */
        /* renamed from: l.i$b$a */
        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j2) throws IOException {
                try {
                    return super.read(buffer, j2);
                } catch (IOException e2) {
                    b.this.f21221b = e2;
                    throw e2;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.f21220a = responseBody;
        }

        /* renamed from: c */
        void m24760c() throws IOException {
            IOException iOException = this.f21221b;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f21220a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f21220a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f21220a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return Okio.buffer(new a(this.f21220a.source()));
        }
    }

    /* compiled from: OkHttpCall.java */
    /* renamed from: l.i$c */
    static final class c extends ResponseBody {

        /* renamed from: a */
        private final MediaType f21223a;

        /* renamed from: b */
        private final long f21224b;

        c(MediaType mediaType, long j2) {
            this.f21223a = mediaType;
            this.f21224b = j2;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f21224b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f21223a;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    C5880i(C5886o<T, ?> c5886o, @Nullable Object[] objArr) {
        this.f21212a = c5886o;
        this.f21213b = objArr;
    }

    @Override // p375l.InterfaceC5873b
    /* renamed from: a */
    public void mo24747a(InterfaceC5875d<T> interfaceC5875d) {
        Call call;
        Throwable th;
        C5887p.m24845a(interfaceC5875d, "callback == null");
        synchronized (this) {
            if (this.f21217f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f21217f = true;
            call = this.f21215d;
            th = this.f21216e;
            if (call == null && th == null) {
                try {
                    Call m24757a = m24757a();
                    this.f21215d = m24757a;
                    call = m24757a;
                } catch (Throwable th2) {
                    th = th2;
                    C5887p.m24852a(th);
                    this.f21216e = th;
                }
            }
        }
        if (th != null) {
            interfaceC5875d.onFailure(this, th);
            return;
        }
        if (this.f21214c) {
            call.cancel();
        }
        call.enqueue(new a(interfaceC5875d));
    }

    @Override // p375l.InterfaceC5873b
    public void cancel() {
        Call call;
        this.f21214c = true;
        synchronized (this) {
            call = this.f21215d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // p375l.InterfaceC5873b
    public C5884m<T> execute() throws IOException {
        Call call;
        synchronized (this) {
            if (this.f21217f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f21217f = true;
            if (this.f21216e != null) {
                if (this.f21216e instanceof IOException) {
                    throw ((IOException) this.f21216e);
                }
                if (this.f21216e instanceof RuntimeException) {
                    throw ((RuntimeException) this.f21216e);
                }
                throw ((Error) this.f21216e);
            }
            call = this.f21215d;
            if (call == null) {
                try {
                    call = m24757a();
                    this.f21215d = call;
                } catch (IOException | Error | RuntimeException e2) {
                    C5887p.m24852a(e2);
                    this.f21216e = e2;
                    throw e2;
                }
            }
        }
        if (this.f21214c) {
            call.cancel();
        }
        return m24758a(call.execute());
    }

    @Override // p375l.InterfaceC5873b
    public boolean isCanceled() {
        boolean z = true;
        if (this.f21214c) {
            return true;
        }
        synchronized (this) {
            if (this.f21215d == null || !this.f21215d.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // p375l.InterfaceC5873b
    public synchronized boolean isExecuted() {
        return this.f21217f;
    }

    @Override // p375l.InterfaceC5873b
    public synchronized Request request() {
        Call call = this.f21215d;
        if (call != null) {
            return call.request();
        }
        if (this.f21216e != null) {
            if (this.f21216e instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.f21216e);
            }
            if (this.f21216e instanceof RuntimeException) {
                throw ((RuntimeException) this.f21216e);
            }
            throw ((Error) this.f21216e);
        }
        try {
            Call m24757a = m24757a();
            this.f21215d = m24757a;
            return m24757a.request();
        } catch (IOException e2) {
            this.f21216e = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e3) {
            e = e3;
            C5887p.m24852a(e);
            this.f21216e = e;
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            C5887p.m24852a(e);
            this.f21216e = e;
            throw e;
        }
    }

    @Override // p375l.InterfaceC5873b
    public C5880i<T> clone() {
        return new C5880i<>(this.f21212a, this.f21213b);
    }

    /* renamed from: a */
    private Call m24757a() throws IOException {
        Call m24829a = this.f21212a.m24829a(this.f21213b);
        if (m24829a != null) {
            return m24829a;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* renamed from: a */
    C5884m<T> m24758a(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new c(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code < 200 || code >= 300) {
            try {
                return C5884m.m24790a(C5887p.m24850a(body), build);
            } finally {
                body.close();
            }
        }
        if (code != 204 && code != 205) {
            b bVar = new b(body);
            try {
                return C5884m.m24789a(this.f21212a.m24828a(bVar), build);
            } catch (RuntimeException e2) {
                bVar.m24760c();
                throw e2;
            }
        }
        body.close();
        return C5884m.m24789a((Object) null, build);
    }
}
