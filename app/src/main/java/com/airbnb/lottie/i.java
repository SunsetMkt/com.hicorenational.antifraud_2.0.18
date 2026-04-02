package com.airbnb.lottie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: compiled from: LottieConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    @Nullable
    final com.airbnb.lottie.z.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    final com.airbnb.lottie.z.e f2176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f2177c;

    /* JADX INFO: compiled from: LottieConfig.java */
    public static final class b {

        @Nullable
        private com.airbnb.lottie.z.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private com.airbnb.lottie.z.e f2178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2179c = false;

        /* JADX INFO: compiled from: LottieConfig.java */
        class a implements com.airbnb.lottie.z.e {
            final /* synthetic */ File a;

            a(File file) {
                this.a = file;
            }

            @Override // com.airbnb.lottie.z.e
            @NonNull
            public File a() {
                if (this.a.isDirectory()) {
                    return this.a;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        /* JADX INFO: renamed from: com.airbnb.lottie.i$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LottieConfig.java */
        class C0035b implements com.airbnb.lottie.z.e {
            final /* synthetic */ com.airbnb.lottie.z.e a;

            C0035b(com.airbnb.lottie.z.e eVar) {
                this.a = eVar;
            }

            @Override // com.airbnb.lottie.z.e
            @NonNull
            public File a() {
                File fileA = this.a.a();
                if (fileA.isDirectory()) {
                    return fileA;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }

        @NonNull
        public b a(@NonNull com.airbnb.lottie.z.f fVar) {
            this.a = fVar;
            return this;
        }

        @NonNull
        public b a(@NonNull File file) {
            if (this.f2178b != null) {
                throw new IllegalStateException("There is already a cache provider!");
            }
            this.f2178b = new a(file);
            return this;
        }

        @NonNull
        public b a(@NonNull com.airbnb.lottie.z.e eVar) {
            if (this.f2178b == null) {
                this.f2178b = new C0035b(eVar);
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public b a(boolean z) {
            this.f2179c = z;
            return this;
        }

        @NonNull
        public i a() {
            return new i(this.a, this.f2178b, this.f2179c);
        }
    }

    private i(@Nullable com.airbnb.lottie.z.f fVar, @Nullable com.airbnb.lottie.z.e eVar, boolean z) {
        this.a = fVar;
        this.f2176b = eVar;
        this.f2177c = z;
    }
}
