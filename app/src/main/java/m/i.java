package m;

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

/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes2.dex */
final class i<T> implements m.b<T> {
    private final o<T, ?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Object[] f12714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f12715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Call f12716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Throwable f12717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f12718f;

    /* JADX INFO: compiled from: OkHttpCall.java */
    class a implements Callback {
        final /* synthetic */ d a;

        a(d dVar) {
            this.a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.a.onFailure(i.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.a.onResponse(i.this, i.this.a(response));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }
    }

    /* JADX INFO: compiled from: OkHttpCall.java */
    static final class b extends ResponseBody {
        private final ResponseBody a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        IOException f12720b;

        /* JADX INFO: compiled from: OkHttpCall.java */
        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j2) throws IOException {
                try {
                    return super.read(buffer, j2);
                } catch (IOException e2) {
                    b.this.f12720b = e2;
                    throw e2;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.a = responseBody;
        }

        void c() throws IOException {
            IOException iOException = this.f12720b;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return Okio.buffer(new a(this.a.source()));
        }
    }

    /* JADX INFO: compiled from: OkHttpCall.java */
    static final class c extends ResponseBody {
        private final MediaType a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12721b;

        c(MediaType mediaType, long j2) {
            this.a = mediaType;
            this.f12721b = j2;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f12721b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.a;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    i(o<T, ?> oVar, @Nullable Object[] objArr) {
        this.a = oVar;
        this.f12714b = objArr;
    }

    @Override // m.b
    public void a(d<T> dVar) {
        Call call;
        Throwable th;
        p.a(dVar, "callback == null");
        synchronized (this) {
            if (this.f12718f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f12718f = true;
            call = this.f12716d;
            th = this.f12717e;
            if (call == null && th == null) {
                try {
                    Call callA = a();
                    this.f12716d = callA;
                    call = callA;
                } catch (Throwable th2) {
                    th = th2;
                    p.a(th);
                    this.f12717e = th;
                }
            }
        }
        if (th != null) {
            dVar.onFailure(this, th);
            return;
        }
        if (this.f12715c) {
            call.cancel();
        }
        call.enqueue(new a(dVar));
    }

    @Override // m.b
    public void cancel() {
        Call call;
        this.f12715c = true;
        synchronized (this) {
            call = this.f12716d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // m.b
    public m<T> execute() throws IOException {
        Call callA;
        synchronized (this) {
            if (this.f12718f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f12718f = true;
            if (this.f12717e != null) {
                if (this.f12717e instanceof IOException) {
                    throw ((IOException) this.f12717e);
                }
                if (this.f12717e instanceof RuntimeException) {
                    throw ((RuntimeException) this.f12717e);
                }
                throw ((Error) this.f12717e);
            }
            callA = this.f12716d;
            if (callA == null) {
                try {
                    callA = a();
                    this.f12716d = callA;
                } catch (IOException | Error | RuntimeException e2) {
                    p.a(e2);
                    this.f12717e = e2;
                    throw e2;
                }
            }
        }
        if (this.f12715c) {
            callA.cancel();
        }
        return a(callA.execute());
    }

    @Override // m.b
    public boolean isCanceled() {
        boolean z = true;
        if (this.f12715c) {
            return true;
        }
        synchronized (this) {
            if (this.f12716d == null || !this.f12716d.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // m.b
    public synchronized boolean isExecuted() {
        return this.f12718f;
    }

    @Override // m.b
    public synchronized Request request() {
        Call call = this.f12716d;
        if (call != null) {
            return call.request();
        }
        if (this.f12717e != null) {
            if (this.f12717e instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.f12717e);
            }
            if (this.f12717e instanceof RuntimeException) {
                throw ((RuntimeException) this.f12717e);
            }
            throw ((Error) this.f12717e);
        }
        try {
            Call callA = a();
            this.f12716d = callA;
            return callA.request();
        } catch (IOException e2) {
            this.f12717e = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e3) {
            e = e3;
            p.a(e);
            this.f12717e = e;
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            p.a(e);
            this.f12717e = e;
            throw e;
        }
    }

    @Override // m.b
    public i<T> clone() {
        return new i<>(this.a, this.f12714b);
    }

    private Call a() throws IOException {
        Call callA = this.a.a(this.f12714b);
        if (callA != null) {
            return callA;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    m<T> a(Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Response responseBuild = response.newBuilder().body(new c(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode < 200 || iCode >= 300) {
            try {
                return m.a(p.a(responseBodyBody), responseBuild);
            } finally {
                responseBodyBody.close();
            }
        }
        if (iCode != 204 && iCode != 205) {
            b bVar = new b(responseBodyBody);
            try {
                return m.a(this.a.a(bVar), responseBuild);
            } catch (RuntimeException e2) {
                bVar.c();
                throw e2;
            }
        }
        responseBodyBody.close();
        return m.a((Object) null, responseBuild);
    }
}
