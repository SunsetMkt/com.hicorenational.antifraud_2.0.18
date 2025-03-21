package com.airbnb.lottie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.p110z.InterfaceC1490e;
import com.airbnb.lottie.p110z.InterfaceC1491f;
import java.io.File;

/* compiled from: LottieConfig.java */
/* renamed from: com.airbnb.lottie.i */
/* loaded from: classes.dex */
public class C1378i {

    /* renamed from: a */
    @Nullable
    final InterfaceC1491f f3243a;

    /* renamed from: b */
    @Nullable
    final InterfaceC1490e f3244b;

    /* renamed from: c */
    final boolean f3245c;

    /* compiled from: LottieConfig.java */
    /* renamed from: com.airbnb.lottie.i$b */
    public static final class b {

        /* renamed from: a */
        @Nullable
        private InterfaceC1491f f3246a;

        /* renamed from: b */
        @Nullable
        private InterfaceC1490e f3247b;

        /* renamed from: c */
        private boolean f3248c = false;

        /* compiled from: LottieConfig.java */
        /* renamed from: com.airbnb.lottie.i$b$a */
        class a implements InterfaceC1490e {

            /* renamed from: a */
            final /* synthetic */ File f3249a;

            a(File file) {
                this.f3249a = file;
            }

            @Override // com.airbnb.lottie.p110z.InterfaceC1490e
            @NonNull
            /* renamed from: a */
            public File mo2885a() {
                if (this.f3249a.isDirectory()) {
                    return this.f3249a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* compiled from: LottieConfig.java */
        /* renamed from: com.airbnb.lottie.i$b$b, reason: collision with other inner class name */
        class C7357b implements InterfaceC1490e {

            /* renamed from: a */
            final /* synthetic */ InterfaceC1490e f3251a;

            C7357b(InterfaceC1490e interfaceC1490e) {
                this.f3251a = interfaceC1490e;
            }

            @Override // com.airbnb.lottie.p110z.InterfaceC1490e
            @NonNull
            /* renamed from: a */
            public File mo2885a() {
                File mo2885a = this.f3251a.mo2885a();
                if (mo2885a.isDirectory()) {
                    return mo2885a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        /* renamed from: a */
        public b m2961a(@NonNull InterfaceC1491f interfaceC1491f) {
            this.f3246a = interfaceC1491f;
            return this;
        }

        @NonNull
        /* renamed from: a */
        public b m2962a(@NonNull File file) {
            if (this.f3247b != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.f3247b = new a(file);
            return this;
        }

        @NonNull
        /* renamed from: a */
        public b m2960a(@NonNull InterfaceC1490e interfaceC1490e) {
            if (this.f3247b == null) {
                this.f3247b = new C7357b(interfaceC1490e);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        /* renamed from: a */
        public b m2963a(boolean z) {
            this.f3248c = z;
            return this;
        }

        @NonNull
        /* renamed from: a */
        public C1378i m2964a() {
            return new C1378i(this.f3246a, this.f3247b, this.f3248c);
        }
    }

    private C1378i(@Nullable InterfaceC1491f interfaceC1491f, @Nullable InterfaceC1490e interfaceC1490e, boolean z) {
        this.f3243a = interfaceC1491f;
        this.f3244b = interfaceC1490e;
        this.f3245c = z;
    }
}
