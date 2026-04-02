package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String t = LottieAnimationView.class.getSimpleName();
    private static final l<Throwable> u = new a();
    private final l<com.airbnb.lottie.g> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<Throwable> f2014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private l<Throwable> f2015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @DrawableRes
    private int f2016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f2017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f2019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @RawRes
    private int f2020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f2025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2026n;
    private t o;
    private final Set<n> p;
    private int q;

    @Nullable
    private q<com.airbnb.lottie.g> r;

    @Nullable
    private com.airbnb.lottie.g s;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f2028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2029d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f2030e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2031f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f2032g;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.a);
            parcel.writeFloat(this.f2028c);
            parcel.writeInt(this.f2029d ? 1 : 0);
            parcel.writeString(this.f2030e);
            parcel.writeInt(this.f2031f);
            parcel.writeInt(this.f2032g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.f2028c = parcel.readFloat();
            this.f2029d = parcel.readInt() == 1;
            this.f2030e = parcel.readString();
            this.f2031f = parcel.readInt();
            this.f2032g = parcel.readInt();
        }
    }

    class a implements l<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (!com.airbnb.lottie.b0.h.a(th)) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
            com.airbnb.lottie.b0.d.c("Unable to load composition.", th);
        }
    }

    class b implements l<com.airbnb.lottie.g> {
        b() {
        }

        @Override // com.airbnb.lottie.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(com.airbnb.lottie.g gVar) {
            LottieAnimationView.this.setComposition(gVar);
        }
    }

    class c implements l<Throwable> {
        c() {
        }

        @Override // com.airbnb.lottie.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f2016d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f2016d);
            }
            (LottieAnimationView.this.f2015c == null ? LottieAnimationView.u : LottieAnimationView.this.f2015c).onResult(th);
        }
    }

    class d implements Callable<p<com.airbnb.lottie.g>> {
        final /* synthetic */ int a;

        d(int i2) {
            this.a = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return LottieAnimationView.this.f2026n ? h.b(LottieAnimationView.this.getContext(), this.a) : h.b(LottieAnimationView.this.getContext(), this.a, (String) null);
        }
    }

    class e implements Callable<p<com.airbnb.lottie.g>> {
        final /* synthetic */ String a;

        e(String str) {
            this.a = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public p<com.airbnb.lottie.g> call() {
            return LottieAnimationView.this.f2026n ? h.b(LottieAnimationView.this.getContext(), this.a) : h.b(LottieAnimationView.this.getContext(), this.a, (String) null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> extends com.airbnb.lottie.c0.j<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.c0.l f2035d;

        f(com.airbnb.lottie.c0.l lVar) {
            this.f2035d = lVar;
        }

        @Override // com.airbnb.lottie.c0.j
        public T a(com.airbnb.lottie.c0.b<T> bVar) {
            return (T) this.f2035d.a(bVar);
        }
    }

    static /* synthetic */ class g {
        static final /* synthetic */ int[] a = new int[t.values().length];

        static {
            try {
                a[t.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[t.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[t.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.a = new b();
        this.f2014b = new c();
        this.f2016d = 0;
        this.f2017e = new j();
        this.f2021i = false;
        this.f2022j = false;
        this.f2023k = false;
        this.f2024l = false;
        this.f2025m = false;
        this.f2026n = true;
        this.o = t.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        a((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    private void o() {
        q<com.airbnb.lottie.g> qVar = this.r;
        if (qVar != null) {
            qVar.d(this.a);
            this.r.c(this.f2014b);
        }
    }

    private void p() {
        this.s = null;
        this.f2017e.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q() {
        com.airbnb.lottie.g gVar;
        int i2;
        int i3 = g.a[this.o.ordinal()];
        int i4 = 2;
        if (i3 != 1) {
            if (i3 == 2 || i3 != 3) {
                i4 = 1;
            } else {
                com.airbnb.lottie.g gVar2 = this.s;
                boolean z = false;
                if ((gVar2 == null || !gVar2.o() || Build.VERSION.SDK_INT >= 28) && (((gVar = this.s) == null || gVar.k() <= 4) && (i2 = Build.VERSION.SDK_INT) >= 21 && i2 != 24 && i2 != 25)) {
                    z = true;
                }
                if (!z) {
                }
            }
        }
        if (i4 != getLayerType()) {
            setLayerType(i4, null);
        }
    }

    private void r() {
        boolean zE = e();
        setImageDrawable(null);
        setImageDrawable(this.f2017e);
        if (zE) {
            this.f2017e.B();
        }
    }

    private void setCompositionTask(q<com.airbnb.lottie.g> qVar) {
        p();
        o();
        this.r = qVar.b(this.a).a(this.f2014b);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        com.airbnb.lottie.e.a("buildDrawingCache");
        this.q++;
        super.buildDrawingCache(z);
        if (this.q == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(t.HARDWARE);
        }
        this.q--;
        com.airbnb.lottie.e.b("buildDrawingCache");
    }

    public boolean d() {
        return this.f2017e.s();
    }

    public boolean e() {
        return this.f2017e.t();
    }

    public boolean f() {
        return this.f2017e.w();
    }

    @MainThread
    public void g() {
        this.f2025m = false;
        this.f2023k = false;
        this.f2022j = false;
        this.f2021i = false;
        this.f2017e.x();
        q();
    }

    @Nullable
    public com.airbnb.lottie.g getComposition() {
        return this.s;
    }

    public long getDuration() {
        com.airbnb.lottie.g gVar = this.s;
        if (gVar != null) {
            return (long) gVar.c();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f2017e.g();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f2017e.h();
    }

    public float getMaxFrame() {
        return this.f2017e.i();
    }

    public float getMinFrame() {
        return this.f2017e.j();
    }

    @Nullable
    public s getPerformanceTracker() {
        return this.f2017e.k();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f2017e.l();
    }

    public int getRepeatCount() {
        return this.f2017e.m();
    }

    public int getRepeatMode() {
        return this.f2017e.n();
    }

    public float getScale() {
        return this.f2017e.o();
    }

    public float getSpeed() {
        return this.f2017e.p();
    }

    @MainThread
    public void h() {
        if (!isShown()) {
            this.f2021i = true;
        } else {
            this.f2017e.y();
            q();
        }
    }

    public void i() {
        this.f2017e.z();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        j jVar = this.f2017e;
        if (drawable2 == jVar) {
            super.invalidateDrawable(jVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j() {
        this.p.clear();
    }

    public void k() {
        this.f2017e.A();
    }

    @MainThread
    public void l() {
        if (isShown()) {
            this.f2017e.B();
            q();
        } else {
            this.f2021i = false;
            this.f2022j = true;
        }
    }

    public void m() {
        this.f2017e.C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.f2025m || this.f2023k)) {
            h();
            this.f2025m = false;
            this.f2023k = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (e()) {
            a();
            this.f2023k = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2019g = savedState.a;
        if (!TextUtils.isEmpty(this.f2019g)) {
            setAnimation(this.f2019g);
        }
        this.f2020h = savedState.f2027b;
        int i2 = this.f2020h;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.f2028c);
        if (savedState.f2029d) {
            h();
        }
        this.f2017e.b(savedState.f2030e);
        setRepeatMode(savedState.f2031f);
        setRepeatCount(savedState.f2032g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f2019g;
        savedState.f2027b = this.f2020h;
        savedState.f2028c = this.f2017e.l();
        savedState.f2029d = this.f2017e.t() || (!ViewCompat.isAttachedToWindow(this) && this.f2023k);
        savedState.f2030e = this.f2017e.h();
        savedState.f2031f = this.f2017e.n();
        savedState.f2032g = this.f2017e.m();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        if (this.f2018f) {
            if (!isShown()) {
                if (e()) {
                    g();
                    this.f2022j = true;
                    return;
                }
                return;
            }
            if (this.f2022j) {
                l();
            } else if (this.f2021i) {
                h();
            }
            this.f2022j = false;
            this.f2021i = false;
        }
    }

    public void setAnimation(@RawRes int i2) {
        this.f2020h = i2;
        this.f2019g = null;
        setCompositionTask(a(i2));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f2026n ? h.c(getContext(), str) : h.c(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f2017e.c(z);
    }

    public void setCacheComposition(boolean z) {
        this.f2026n = z;
    }

    public void setComposition(@NonNull com.airbnb.lottie.g gVar) {
        if (com.airbnb.lottie.e.a) {
            String str = "Set Composition \n" + gVar;
        }
        this.f2017e.setCallback(this);
        this.s = gVar;
        this.f2024l = true;
        boolean zA = this.f2017e.a(gVar);
        this.f2024l = false;
        q();
        if (getDrawable() != this.f2017e || zA) {
            if (!zA) {
                r();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<n> it = this.p.iterator();
            while (it.hasNext()) {
                it.next().a(gVar);
            }
        }
    }

    public void setFailureListener(@Nullable l<Throwable> lVar) {
        this.f2015c = lVar;
    }

    public void setFallbackResource(@DrawableRes int i2) {
        this.f2016d = i2;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.c cVar) {
        this.f2017e.a(cVar);
    }

    public void setFrame(int i2) {
        this.f2017e.a(i2);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.f2017e.d(z);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.d dVar) {
        this.f2017e.a(dVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f2017e.b(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        o();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        o();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        o();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f2017e.b(i2);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f2017e.a(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.f2017e.d(str);
    }

    public void setMinFrame(int i2) {
        this.f2017e.c(i2);
    }

    public void setMinProgress(float f2) {
        this.f2017e.b(f2);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.f2017e.e(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f2017e.f(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f2017e.c(f2);
    }

    public void setRenderMode(t tVar) {
        this.o = tVar;
        q();
    }

    public void setRepeatCount(int i2) {
        this.f2017e.d(i2);
    }

    public void setRepeatMode(int i2) {
        this.f2017e.e(i2);
    }

    public void setSafeMode(boolean z) {
        this.f2017e.g(z);
    }

    public void setScale(float f2) {
        this.f2017e.d(f2);
        if (getDrawable() == this.f2017e) {
            r();
        }
    }

    public void setSpeed(float f2) {
        this.f2017e.e(f2);
    }

    public void setTextDelegate(v vVar) {
        this.f2017e.a(vVar);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        j jVar;
        if (!this.f2024l && drawable == (jVar = this.f2017e) && jVar.t()) {
            g();
        } else if (!this.f2024l && (drawable instanceof j)) {
            j jVar2 = (j) drawable;
            if (jVar2.t()) {
                jVar2.x();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    private void a(@Nullable AttributeSet attributeSet, @AttrRes int i2) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i2, 0);
        this.f2026n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f2023k = true;
            this.f2025m = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f2017e.d(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            a(new com.airbnb.lottie.y.e("**"), o.E, (com.airbnb.lottie.c0.j<ColorFilter>) new com.airbnb.lottie.c0.j(new u(AppCompatResources.getColorStateList(getContext(), typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.f2017e.d(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, t.AUTOMATIC.ordinal());
            if (iOrdinal >= t.values().length) {
                iOrdinal = t.AUTOMATIC.ordinal();
            }
            setRenderMode(t.values()[iOrdinal]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f2017e.a(Boolean.valueOf(com.airbnb.lottie.b0.h.a(getContext()) != 0.0f));
        q();
        this.f2018f = true;
    }

    public void b(String str, @Nullable String str2) {
        setCompositionTask(h.c(getContext(), str, str2));
    }

    public boolean c() {
        return this.f2017e.r();
    }

    public void setMaxFrame(String str) {
        this.f2017e.c(str);
    }

    public void setMinFrame(String str) {
        this.f2017e.e(str);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2017e.b(animatorUpdateListener);
    }

    public void setAnimation(String str) {
        this.f2019g = str;
        this.f2020h = 0;
        setCompositionTask(a(str));
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f2017e.b(animatorListener);
    }

    @RequiresApi(api = 19)
    public void b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f2017e.b(animatorPauseListener);
    }

    @Deprecated
    public void b(boolean z) {
        this.f2017e.d(z ? -1 : 0);
    }

    public void b() {
        this.f2017e.c();
    }

    public boolean b(@NonNull n nVar) {
        return this.p.remove(nVar);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.f2014b = new c();
        this.f2016d = 0;
        this.f2017e = new j();
        this.f2021i = false;
        this.f2022j = false;
        this.f2023k = false;
        this.f2024l = false;
        this.f2025m = false;
        this.f2026n = true;
        this.o = t.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        a(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new b();
        this.f2014b = new c();
        this.f2016d = 0;
        this.f2017e = new j();
        this.f2021i = false;
        this.f2022j = false;
        this.f2023k = false;
        this.f2024l = false;
        this.f2025m = false;
        this.f2026n = true;
        this.o = t.AUTOMATIC;
        this.p = new HashSet();
        this.q = 0;
        a(attributeSet, i2);
    }

    public void a(boolean z) {
        this.f2017e.a(z);
    }

    private q<com.airbnb.lottie.g> a(@RawRes int i2) {
        if (isInEditMode()) {
            return new q<>(new d(i2), true);
        }
        return this.f2026n ? h.a(getContext(), i2) : h.a(getContext(), i2, (String) null);
    }

    private q<com.airbnb.lottie.g> a(String str) {
        if (isInEditMode()) {
            return new q<>(new e(str), true);
        }
        return this.f2026n ? h.a(getContext(), str) : h.a(getContext(), str, (String) null);
    }

    public void a(String str, @Nullable String str2) {
        a(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void a(InputStream inputStream, @Nullable String str) {
        setCompositionTask(h.a(inputStream, str));
    }

    public void a(String str, String str2, boolean z) {
        this.f2017e.a(str, str2, z);
    }

    public void a(int i2, int i3) {
        this.f2017e.a(i2, i3);
    }

    public void a(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.f2017e.a(f2, f3);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2017e.a(animatorUpdateListener);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f2017e.a(animatorListener);
    }

    @RequiresApi(api = 19)
    public void a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f2017e.a(animatorPauseListener);
    }

    @Nullable
    public Bitmap a(String str, @Nullable Bitmap bitmap) {
        return this.f2017e.a(str, bitmap);
    }

    public List<com.airbnb.lottie.y.e> a(com.airbnb.lottie.y.e eVar) {
        return this.f2017e.a(eVar);
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t2, com.airbnb.lottie.c0.j<T> jVar) {
        this.f2017e.a(eVar, t2, jVar);
    }

    public <T> void a(com.airbnb.lottie.y.e eVar, T t2, com.airbnb.lottie.c0.l<T> lVar) {
        this.f2017e.a(eVar, t2, new f(lVar));
    }

    @MainThread
    public void a() {
        this.f2023k = false;
        this.f2022j = false;
        this.f2021i = false;
        this.f2017e.a();
        q();
    }

    public boolean a(@NonNull n nVar) {
        com.airbnb.lottie.g gVar = this.s;
        if (gVar != null) {
            nVar.a(gVar);
        }
        return this.p.add(nVar);
    }
}
