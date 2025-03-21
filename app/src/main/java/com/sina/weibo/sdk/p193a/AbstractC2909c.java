package com.sina.weibo.sdk.p193a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: com.sina.weibo.sdk.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC2909c<Params, Progress, Result> {

    /* renamed from: P */
    Params[] f9273P;

    /* renamed from: L */
    volatile int f9269L = b.f9281U;

    /* renamed from: O */
    int f9272O = 5;

    /* renamed from: x */
    Handler f9274x = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.a.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (message.what != 1) {
                return;
            }
            AbstractC2909c.m8808a(aVar.f9279S, aVar.f9280T[0]);
            message.obj = null;
        }
    };

    /* renamed from: M */
    final d<Params, Result> f9270M = new d<Params, Result>() { // from class: com.sina.weibo.sdk.a.c.2
        @Override // java.util.concurrent.Callable
        public final Result call() {
            Process.setThreadPriority(AbstractC2909c.this.f9272O);
            return (Result) AbstractC2909c.this.mo8809l();
        }
    };

    /* renamed from: N */
    final FutureTask<Result> f9271N = new AbstractC2909c<Params, Progress, Result>.c(this.f9270M) { // from class: com.sina.weibo.sdk.a.c.3
        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return 0;
        }

        @Override // java.util.concurrent.FutureTask
        protected final void done() {
            try {
                Result result = get();
                AbstractC2909c abstractC2909c = AbstractC2909c.this;
                abstractC2909c.f9274x.obtainMessage(1, new a(abstractC2909c, result)).sendToTarget();
            } catch (InterruptedException unused) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            } catch (CancellationException unused2) {
                AbstractC2909c abstractC2909c2 = AbstractC2909c.this;
                abstractC2909c2.f9274x.obtainMessage(3, new a(abstractC2909c2, null)).sendToTarget();
            } catch (ExecutionException unused3) {
                throw new RuntimeException("An error occur while execute doInBackground().");
            }
        }
    };

    /* renamed from: com.sina.weibo.sdk.a.c$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: R */
        static final /* synthetic */ int[] f9278R = new int[b.m8810m().length];

        static {
            try {
                f9278R[b.f9282V - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9278R[b.f9283W - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: com.sina.weibo.sdk.a.c$a */
    static class a<Data> {

        /* renamed from: S */
        final AbstractC2909c f9279S;

        /* renamed from: T */
        final Data[] f9280T;

        a(AbstractC2909c abstractC2909c, Data... dataArr) {
            this.f9279S = abstractC2909c;
            this.f9280T = dataArr;
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.sina.weibo.sdk.a.c$b */
    public static final class b {

        /* renamed from: U */
        public static final int f9281U = 1;

        /* renamed from: V */
        public static final int f9282V = 2;

        /* renamed from: W */
        public static final int f9283W = 3;

        /* renamed from: X */
        private static final /* synthetic */ int[] f9284X = {f9281U, f9282V, f9283W};

        /* renamed from: m */
        public static int[] m8810m() {
            return (int[]) f9284X.clone();
        }
    }

    /* renamed from: com.sina.weibo.sdk.a.c$c */
    abstract class c extends FutureTask<Result> implements Comparable<Object> {
        int priority;

        public c(d dVar) {
            super(dVar);
            this.priority = dVar.priority;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m8808a(AbstractC2909c abstractC2909c, Object obj) {
        abstractC2909c.onPostExecute(obj);
        abstractC2909c.f9269L = b.f9283W;
    }

    /* renamed from: l */
    protected abstract Result mo8809l();

    protected void onPostExecute(Result result) {
    }

    /* renamed from: com.sina.weibo.sdk.a.c$d */
    static abstract class d<Params, Result> implements Callable<Result> {

        /* renamed from: Y */
        Params[] f9286Y;
        int priority;

        private d() {
            this.priority = 10;
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }
}
