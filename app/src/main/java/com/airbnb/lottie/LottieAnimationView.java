package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
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
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1362b;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p101c0.InterfaceC1372l;
import com.airbnb.lottie.p106y.C1439e;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: t */
    private static final String f2956t = LottieAnimationView.class.getSimpleName();

    /* renamed from: u */
    private static final InterfaceC1381l<Throwable> f2957u = new C1296a();

    /* renamed from: a */
    private final InterfaceC1381l<C1376g> f2958a;

    /* renamed from: b */
    private final InterfaceC1381l<Throwable> f2959b;

    /* renamed from: c */
    @Nullable
    private InterfaceC1381l<Throwable> f2960c;

    /* renamed from: d */
    @DrawableRes
    private int f2961d;

    /* renamed from: e */
    private final C1379j f2962e;

    /* renamed from: f */
    private boolean f2963f;

    /* renamed from: g */
    private String f2964g;

    /* renamed from: h */
    @RawRes
    private int f2965h;

    /* renamed from: i */
    private boolean f2966i;

    /* renamed from: j */
    private boolean f2967j;

    /* renamed from: k */
    private boolean f2968k;

    /* renamed from: l */
    private boolean f2969l;

    /* renamed from: m */
    private boolean f2970m;

    /* renamed from: n */
    private boolean f2971n;

    /* renamed from: o */
    private EnumC1389t f2972o;

    /* renamed from: p */
    private final Set<InterfaceC1383n> f2973p;

    /* renamed from: q */
    private int f2974q;

    /* renamed from: r */
    @Nullable
    private C1386q<C1376g> f2975r;

    /* renamed from: s */
    @Nullable
    private C1376g f2976s;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1295a();

        /* renamed from: a */
        String f2977a;

        /* renamed from: b */
        int f2978b;

        /* renamed from: c */
        float f2979c;

        /* renamed from: d */
        boolean f2980d;

        /* renamed from: e */
        String f2981e;

        /* renamed from: f */
        int f2982f;

        /* renamed from: g */
        int f2983g;

        /* renamed from: com.airbnb.lottie.LottieAnimationView$SavedState$a */
        class C1295a implements Parcelable.Creator<SavedState> {
            C1295a() {
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

        /* synthetic */ SavedState(Parcel parcel, C1296a c1296a) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f2977a);
            parcel.writeFloat(this.f2979c);
            parcel.writeInt(this.f2980d ? 1 : 0);
            parcel.writeString(this.f2981e);
            parcel.writeInt(this.f2982f);
            parcel.writeInt(this.f2983g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f2977a = parcel.readString();
            this.f2979c = parcel.readFloat();
            this.f2980d = parcel.readInt() == 1;
            this.f2981e = parcel.readString();
            this.f2982f = parcel.readInt();
            this.f2983g = parcel.readInt();
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$a */
    class C1296a implements InterfaceC1381l<Throwable> {
        C1296a() {
        }

        @Override // com.airbnb.lottie.InterfaceC1381l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (!C1358h.m2845a(th)) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
            C1354d.m2793c("Unable to load composition.", th);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$b */
    class C1297b implements InterfaceC1381l<C1376g> {
        C1297b() {
        }

        @Override // com.airbnb.lottie.InterfaceC1381l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(C1376g c1376g) {
            LottieAnimationView.this.setComposition(c1376g);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$c */
    class C1298c implements InterfaceC1381l<Throwable> {
        C1298c() {
        }

        @Override // com.airbnb.lottie.InterfaceC1381l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f2961d != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f2961d);
            }
            (LottieAnimationView.this.f2960c == null ? LottieAnimationView.f2957u : LottieAnimationView.this.f2960c).onResult(th);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$d */
    class CallableC1299d implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ int f2986a;

        CallableC1299d(int i2) {
            this.f2986a = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return LottieAnimationView.this.f2971n ? C1377h.m2942b(LottieAnimationView.this.getContext(), this.f2986a) : C1377h.m2943b(LottieAnimationView.this.getContext(), this.f2986a, (String) null);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$e */
    class CallableC1300e implements Callable<C1385p<C1376g>> {

        /* renamed from: a */
        final /* synthetic */ String f2988a;

        CallableC1300e(String str) {
            this.f2988a = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public C1385p<C1376g> call() {
            return LottieAnimationView.this.f2971n ? C1377h.m2944b(LottieAnimationView.this.getContext(), this.f2988a) : C1377h.m2945b(LottieAnimationView.this.getContext(), this.f2988a, (String) null);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.airbnb.lottie.LottieAnimationView$f */
    class C1301f<T> extends C1370j<T> {

        /* renamed from: d */
        final /* synthetic */ InterfaceC1372l f2990d;

        C1301f(InterfaceC1372l interfaceC1372l) {
            this.f2990d = interfaceC1372l;
        }

        @Override // com.airbnb.lottie.p101c0.C1370j
        /* renamed from: a */
        public T mo2653a(C1362b<T> c1362b) {
            return (T) this.f2990d.m2876a(c1362b);
        }
    }

    /* renamed from: com.airbnb.lottie.LottieAnimationView$g */
    static /* synthetic */ class C1302g {

        /* renamed from: a */
        static final /* synthetic */ int[] f2992a = new int[EnumC1389t.values().length];

        static {
            try {
                f2992a[EnumC1389t.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2992a[EnumC1389t.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2992a[EnumC1389t.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f2958a = new C1297b();
        this.f2959b = new C1298c();
        this.f2961d = 0;
        this.f2962e = new C1379j();
        this.f2966i = false;
        this.f2967j = false;
        this.f2968k = false;
        this.f2969l = false;
        this.f2970m = false;
        this.f2971n = true;
        this.f2972o = EnumC1389t.AUTOMATIC;
        this.f2973p = new HashSet();
        this.f2974q = 0;
        m2609a((AttributeSet) null, C1303R.attr.lottieAnimationViewStyle);
    }

    /* renamed from: o */
    private void m2613o() {
        C1386q<C1376g> c1386q = this.f2975r;
        if (c1386q != null) {
            c1386q.m3073d(this.f2958a);
            this.f2975r.m3072c(this.f2959b);
        }
    }

    /* renamed from: p */
    private void m2614p() {
        this.f2976s = null;
        this.f2962e.m3004b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        if (r3 != false) goto L30;
     */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2615q() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.C1302g.f2992a
            com.airbnb.lottie.t r1 = r5.f2972o
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L46
            if (r0 == r1) goto L13
            r3 = 3
            if (r0 == r3) goto L15
        L13:
            r1 = 1
            goto L46
        L15:
            com.airbnb.lottie.g r0 = r5.f2976s
            r3 = 0
            if (r0 == 0) goto L27
            boolean r0 = r0.m2911o()
            if (r0 == 0) goto L27
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L27
            goto L44
        L27:
            com.airbnb.lottie.g r0 = r5.f2976s
            if (r0 == 0) goto L33
            int r0 = r0.m2907k()
            r4 = 4
            if (r0 <= r4) goto L33
            goto L44
        L33:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L3a
            goto L44
        L3a:
            r4 = 24
            if (r0 == r4) goto L44
            r4 = 25
            if (r0 != r4) goto L43
            goto L44
        L43:
            r3 = 1
        L44:
            if (r3 == 0) goto L13
        L46:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L50
            r0 = 0
            r5.setLayerType(r1, r0)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.m2615q():void");
    }

    /* renamed from: r */
    private void m2616r() {
        boolean m2641e = m2641e();
        setImageDrawable(null);
        setImageDrawable(this.f2962e);
        if (m2641e) {
            this.f2962e.m2979B();
        }
    }

    private void setCompositionTask(C1386q<C1376g> c1386q) {
        m2614p();
        m2613o();
        this.f2975r = c1386q.m3071b(this.f2958a).m3070a(this.f2959b);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        C1374e.m2881a("buildDrawingCache");
        this.f2974q++;
        super.buildDrawingCache(z);
        if (this.f2974q == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(EnumC1389t.HARDWARE);
        }
        this.f2974q--;
        C1374e.m2883b("buildDrawingCache");
    }

    /* renamed from: d */
    public boolean m2640d() {
        return this.f2962e.m3042s();
    }

    /* renamed from: e */
    public boolean m2641e() {
        return this.f2962e.m3043t();
    }

    /* renamed from: f */
    public boolean m2642f() {
        return this.f2962e.m3046w();
    }

    @MainThread
    /* renamed from: g */
    public void m2643g() {
        this.f2970m = false;
        this.f2968k = false;
        this.f2967j = false;
        this.f2966i = false;
        this.f2962e.m3047x();
        m2615q();
    }

    @Nullable
    public C1376g getComposition() {
        return this.f2976s;
    }

    public long getDuration() {
        C1376g c1376g = this.f2976s;
        if (c1376g != null) {
            return (long) c1376g.m2898c();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f2962e.m3029g();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f2962e.m3031h();
    }

    public float getMaxFrame() {
        return this.f2962e.m3032i();
    }

    public float getMinFrame() {
        return this.f2962e.m3033j();
    }

    @Nullable
    public C1388s getPerformanceTracker() {
        return this.f2962e.m3034k();
    }

    @FloatRange(from = 0.0d, m293to = 1.0d)
    public float getProgress() {
        return this.f2962e.m3035l();
    }

    public int getRepeatCount() {
        return this.f2962e.m3036m();
    }

    public int getRepeatMode() {
        return this.f2962e.m3037n();
    }

    public float getScale() {
        return this.f2962e.m3038o();
    }

    public float getSpeed() {
        return this.f2962e.m3039p();
    }

    @MainThread
    /* renamed from: h */
    public void m2644h() {
        if (!isShown()) {
            this.f2966i = true;
        } else {
            this.f2962e.m3048y();
            m2615q();
        }
    }

    /* renamed from: i */
    public void m2645i() {
        this.f2962e.m3049z();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        C1379j c1379j = this.f2962e;
        if (drawable2 == c1379j) {
            super.invalidateDrawable(c1379j);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* renamed from: j */
    public void m2646j() {
        this.f2973p.clear();
    }

    /* renamed from: k */
    public void m2647k() {
        this.f2962e.m2978A();
    }

    @MainThread
    /* renamed from: l */
    public void m2648l() {
        if (isShown()) {
            this.f2962e.m2979B();
            m2615q();
        } else {
            this.f2966i = false;
            this.f2967j = true;
        }
    }

    /* renamed from: m */
    public void m2649m() {
        this.f2962e.m2980C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.f2970m || this.f2968k)) {
            m2644h();
            this.f2970m = false;
            this.f2968k = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (m2641e()) {
            m2619a();
            this.f2968k = true;
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
        this.f2964g = savedState.f2977a;
        if (!TextUtils.isEmpty(this.f2964g)) {
            setAnimation(this.f2964g);
        }
        this.f2965h = savedState.f2978b;
        int i2 = this.f2965h;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.f2979c);
        if (savedState.f2980d) {
            m2644h();
        }
        this.f2962e.m3010b(savedState.f2981e);
        setRepeatMode(savedState.f2982f);
        setRepeatCount(savedState.f2983g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2977a = this.f2964g;
        savedState.f2978b = this.f2965h;
        savedState.f2979c = this.f2962e.m3035l();
        savedState.f2980d = this.f2962e.m3043t() || (!ViewCompat.isAttachedToWindow(this) && this.f2968k);
        savedState.f2981e = this.f2962e.m3031h();
        savedState.f2982f = this.f2962e.m3037n();
        savedState.f2983g = this.f2962e.m3036m();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        if (this.f2963f) {
            if (!isShown()) {
                if (m2641e()) {
                    m2643g();
                    this.f2967j = true;
                    return;
                }
                return;
            }
            if (this.f2967j) {
                m2648l();
            } else if (this.f2966i) {
                m2644h();
            }
            this.f2967j = false;
            this.f2966i = false;
        }
    }

    public void setAnimation(@RawRes int i2) {
        this.f2965h = i2;
        this.f2964g = null;
        setCompositionTask(m2607a(i2));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        m2628a(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f2971n ? C1377h.m2953c(getContext(), str) : C1377h.m2954c(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f2962e.m3016c(z);
    }

    public void setCacheComposition(boolean z) {
        this.f2971n = z;
    }

    public void setComposition(@NonNull C1376g c1376g) {
        if (C1374e.f3188a) {
            String str = "Set Composition \n" + c1376g;
        }
        this.f2962e.setCallback(this);
        this.f2976s = c1376g;
        this.f2969l = true;
        boolean m3003a = this.f2962e.m3003a(c1376g);
        this.f2969l = false;
        m2615q();
        if (getDrawable() != this.f2962e || m3003a) {
            if (!m3003a) {
                m2616r();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<InterfaceC1383n> it = this.f2973p.iterator();
            while (it.hasNext()) {
                it.next().m3059a(c1376g);
            }
        }
    }

    public void setFailureListener(@Nullable InterfaceC1381l<Throwable> interfaceC1381l) {
        this.f2960c = interfaceC1381l;
    }

    public void setFallbackResource(@DrawableRes int i2) {
        this.f2961d = i2;
    }

    public void setFontAssetDelegate(C1360c c1360c) {
        this.f2962e.m2995a(c1360c);
    }

    public void setFrame(int i2) {
        this.f2962e.m2989a(i2);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.f2962e.m3020d(z);
    }

    public void setImageAssetDelegate(InterfaceC1373d interfaceC1373d) {
        this.f2962e.m2996a(interfaceC1373d);
    }

    public void setImageAssetsFolder(String str) {
        this.f2962e.m3010b(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m2613o();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        m2613o();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        m2613o();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.f2962e.m3006b(i2);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        this.f2962e.m2987a(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.f2962e.m3019d(str);
    }

    public void setMinFrame(int i2) {
        this.f2962e.m3014c(i2);
    }

    public void setMinProgress(float f2) {
        this.f2962e.m3005b(f2);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.f2962e.m3026e(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f2962e.m3028f(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        this.f2962e.m3013c(f2);
    }

    public void setRenderMode(EnumC1389t enumC1389t) {
        this.f2972o = enumC1389t;
        m2615q();
    }

    public void setRepeatCount(int i2) {
        this.f2962e.m3018d(i2);
    }

    public void setRepeatMode(int i2) {
        this.f2962e.m3024e(i2);
    }

    public void setSafeMode(boolean z) {
        this.f2962e.m3030g(z);
    }

    public void setScale(float f2) {
        this.f2962e.m3017d(f2);
        if (getDrawable() == this.f2962e) {
            m2616r();
        }
    }

    public void setSpeed(float f2) {
        this.f2962e.m3023e(f2);
    }

    public void setTextDelegate(C1391v c1391v) {
        this.f2962e.m2997a(c1391v);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        C1379j c1379j;
        if (!this.f2969l && drawable == (c1379j = this.f2962e) && c1379j.m3043t()) {
            m2643g();
        } else if (!this.f2969l && (drawable instanceof C1379j)) {
            C1379j c1379j2 = (C1379j) drawable;
            if (c1379j2.m3043t()) {
                c1379j2.m3047x();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    /* renamed from: a */
    private void m2609a(@Nullable AttributeSet attributeSet, @AttrRes int i2) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1303R.styleable.LottieAnimationView, i2, 0);
        this.f2971n = obtainStyledAttributes.getBoolean(C1303R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean hasValue = obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_rawRes);
        boolean hasValue2 = obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_fileName);
        boolean hasValue3 = obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_url);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(C1303R.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(C1303R.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(C1303R.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(C1303R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(C1303R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f2968k = true;
            this.f2970m = true;
        }
        if (obtainStyledAttributes.getBoolean(C1303R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f2962e.m3018d(-1);
        }
        if (obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(C1303R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(C1303R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(C1303R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(C1303R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(C1303R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        m2630a(obtainStyledAttributes.getBoolean(C1303R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_colorFilter)) {
            m2625a(new C1439e("**"), (C1439e) InterfaceC1384o.f3326E, (C1370j<C1439e>) new C1370j(new C1390u(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(C1303R.styleable.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_scale)) {
            this.f2962e.m3017d(obtainStyledAttributes.getFloat(C1303R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(C1303R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i3 = obtainStyledAttributes.getInt(C1303R.styleable.LottieAnimationView_lottie_renderMode, EnumC1389t.AUTOMATIC.ordinal());
            if (i3 >= EnumC1389t.values().length) {
                i3 = EnumC1389t.AUTOMATIC.ordinal();
            }
            setRenderMode(EnumC1389t.values()[i3]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(C1303R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        obtainStyledAttributes.recycle();
        this.f2962e.m3000a(Boolean.valueOf(C1358h.m2833a(getContext()) != 0.0f));
        m2615q();
        this.f2963f = true;
    }

    /* renamed from: b */
    public void m2636b(String str, @Nullable String str2) {
        setCompositionTask(C1377h.m2954c(getContext(), str, str2));
    }

    /* renamed from: c */
    public boolean m2639c() {
        return this.f2962e.m3041r();
    }

    public void setMaxFrame(String str) {
        this.f2962e.m3015c(str);
    }

    public void setMinFrame(String str) {
        this.f2962e.m3025e(str);
    }

    /* renamed from: b */
    public void m2635b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2962e.m3009b(animatorUpdateListener);
    }

    public void setAnimation(String str) {
        this.f2964g = str;
        this.f2965h = 0;
        setCompositionTask(m2608a(str));
    }

    /* renamed from: b */
    public void m2633b(Animator.AnimatorListener animatorListener) {
        this.f2962e.m3007b(animatorListener);
    }

    @RequiresApi(api = 19)
    /* renamed from: b */
    public void m2634b(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f2962e.m3008b(animatorPauseListener);
    }

    @Deprecated
    /* renamed from: b */
    public void m2637b(boolean z) {
        this.f2962e.m3018d(z ? -1 : 0);
    }

    /* renamed from: b */
    public void m2632b() {
        this.f2962e.m3012c();
    }

    /* renamed from: b */
    public boolean m2638b(@NonNull InterfaceC1383n interfaceC1383n) {
        return this.f2973p.remove(interfaceC1383n);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2958a = new C1297b();
        this.f2959b = new C1298c();
        this.f2961d = 0;
        this.f2962e = new C1379j();
        this.f2966i = false;
        this.f2967j = false;
        this.f2968k = false;
        this.f2969l = false;
        this.f2970m = false;
        this.f2971n = true;
        this.f2972o = EnumC1389t.AUTOMATIC;
        this.f2973p = new HashSet();
        this.f2974q = 0;
        m2609a(attributeSet, C1303R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2958a = new C1297b();
        this.f2959b = new C1298c();
        this.f2961d = 0;
        this.f2962e = new C1379j();
        this.f2966i = false;
        this.f2967j = false;
        this.f2968k = false;
        this.f2969l = false;
        this.f2970m = false;
        this.f2971n = true;
        this.f2972o = EnumC1389t.AUTOMATIC;
        this.f2973p = new HashSet();
        this.f2974q = 0;
        m2609a(attributeSet, i2);
    }

    /* renamed from: a */
    public void m2630a(boolean z) {
        this.f2962e.m3002a(z);
    }

    /* renamed from: a */
    private C1386q<C1376g> m2607a(@RawRes int i2) {
        if (isInEditMode()) {
            return new C1386q<>(new CallableC1299d(i2), true);
        }
        return this.f2971n ? C1377h.m2928a(getContext(), i2) : C1377h.m2929a(getContext(), i2, (String) null);
    }

    /* renamed from: a */
    private C1386q<C1376g> m2608a(String str) {
        if (isInEditMode()) {
            return new C1386q<>(new CallableC1300e(str), true);
        }
        return this.f2971n ? C1377h.m2930a(getContext(), str) : C1377h.m2931a(getContext(), str, (String) null);
    }

    /* renamed from: a */
    public void m2628a(String str, @Nullable String str2) {
        m2627a(new ByteArrayInputStream(str.getBytes()), str2);
    }

    /* renamed from: a */
    public void m2627a(InputStream inputStream, @Nullable String str) {
        setCompositionTask(C1377h.m2933a(inputStream, str));
    }

    /* renamed from: a */
    public void m2629a(String str, String str2, boolean z) {
        this.f2962e.m3001a(str, str2, z);
    }

    /* renamed from: a */
    public void m2621a(int i2, int i3) {
        this.f2962e.m2990a(i2, i3);
    }

    /* renamed from: a */
    public void m2620a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2, @FloatRange(from = 0.0d, m293to = 1.0d) float f3) {
        this.f2962e.m2988a(f2, f3);
    }

    /* renamed from: a */
    public void m2624a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f2962e.m2993a(animatorUpdateListener);
    }

    /* renamed from: a */
    public void m2622a(Animator.AnimatorListener animatorListener) {
        this.f2962e.m2991a(animatorListener);
    }

    @RequiresApi(api = 19)
    /* renamed from: a */
    public void m2623a(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f2962e.m2992a(animatorPauseListener);
    }

    @Nullable
    /* renamed from: a */
    public Bitmap m2617a(String str, @Nullable Bitmap bitmap) {
        return this.f2962e.m2983a(str, bitmap);
    }

    /* renamed from: a */
    public List<C1439e> m2618a(C1439e c1439e) {
        return this.f2962e.m2985a(c1439e);
    }

    /* renamed from: a */
    public <T> void m2625a(C1439e c1439e, T t, C1370j<T> c1370j) {
        this.f2962e.m2998a(c1439e, (C1439e) t, (C1370j<C1439e>) c1370j);
    }

    /* renamed from: a */
    public <T> void m2626a(C1439e c1439e, T t, InterfaceC1372l<T> interfaceC1372l) {
        this.f2962e.m2998a(c1439e, (C1439e) t, (C1370j<C1439e>) new C1301f(interfaceC1372l));
    }

    @MainThread
    /* renamed from: a */
    public void m2619a() {
        this.f2968k = false;
        this.f2967j = false;
        this.f2966i = false;
        this.f2962e.m2986a();
        m2615q();
    }

    /* renamed from: a */
    public boolean m2631a(@NonNull InterfaceC1383n interfaceC1383n) {
        C1376g c1376g = this.f2976s;
        if (c1376g != null) {
            interfaceC1383n.m3059a(c1376g);
        }
        return this.f2973p.add(interfaceC1383n);
    }
}
