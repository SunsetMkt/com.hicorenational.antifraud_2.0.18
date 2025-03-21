package com.lxj.xpopup.core;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.lxj.xpopup.p184c.AbstractC2770b;
import com.lxj.xpopup.p184c.C2769a;
import com.lxj.xpopup.p184c.C2771c;
import com.lxj.xpopup.p184c.C2772d;
import com.lxj.xpopup.p184c.C2773e;
import com.lxj.xpopup.p184c.C2774f;
import com.lxj.xpopup.p184c.C2775g;
import com.lxj.xpopup.p185d.EnumC2803c;
import com.lxj.xpopup.p185d.EnumC2805e;
import com.lxj.xpopup.p186e.InterfaceC2815i;
import com.lxj.xpopup.p187f.C2818b;
import com.lxj.xpopup.p187f.C2819c;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes.dex */
public abstract class BasePopupView extends FrameLayout {

    /* renamed from: o */
    private static Stack<BasePopupView> f8616o = new Stack<>();

    /* renamed from: a */
    public C2800a f8617a;

    /* renamed from: b */
    protected AbstractC2770b f8618b;

    /* renamed from: c */
    protected C2773e f8619c;

    /* renamed from: d */
    private int f8620d;

    /* renamed from: e */
    public EnumC2805e f8621e;

    /* renamed from: f */
    private boolean f8622f;

    /* renamed from: g */
    private int f8623g;

    /* renamed from: h */
    private boolean f8624h;

    /* renamed from: i */
    private Runnable f8625i;

    /* renamed from: j */
    private RunnableC2787i f8626j;

    /* renamed from: k */
    private Runnable f8627k;

    /* renamed from: l */
    Runnable f8628l;

    /* renamed from: m */
    private float f8629m;

    /* renamed from: n */
    private float f8630n;

    /* renamed from: com.lxj.xpopup.core.BasePopupView$a */
    class RunnableC2779a implements Runnable {
        RunnableC2779a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BasePopupView.this.getLayoutParams();
            int rotation = ((WindowManager) BasePopupView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = C2819c.m8474d(BasePopupView.this.getContext()) ? C2819c.m8465b() : 0;
            } else if (rotation == 1) {
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = C2819c.m8474d(BasePopupView.this.getContext()) ? C2819c.m8465b() : 0;
                layoutParams.leftMargin = 0;
            } else if (rotation == 3) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = C2819c.m8474d(BasePopupView.this.getContext()) ? C2819c.m8465b() : 0;
            }
            BasePopupView.this.setLayoutParams(layoutParams);
            BasePopupView.this.getPopupContentView().setAlpha(1.0f);
            BasePopupView.this.m8373u();
            BasePopupView.this.mo8383g();
            BasePopupView.this.mo8381e();
            BasePopupView basePopupView = BasePopupView.this;
            if (basePopupView instanceof FullScreenPopupView) {
                return;
            }
            basePopupView.m8384h();
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$b */
    class C2780b implements C2818b.b {
        C2780b() {
        }

        @Override // com.lxj.xpopup.p187f.C2818b.b
        /* renamed from: a */
        public void mo8395a(int i2) {
            if (i2 == 0) {
                C2819c.m8473c(BasePopupView.this);
                BasePopupView.this.f8624h = false;
            } else {
                C2819c.m8455a(i2, BasePopupView.this);
                BasePopupView.this.f8624h = true;
            }
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$c */
    class RunnableC2781c implements Runnable {
        RunnableC2781c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BasePopupView.this.getParent() != null) {
                ((ViewGroup) BasePopupView.this.getParent()).removeView(BasePopupView.this);
            }
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f8617a.f8702o.addView(basePopupView, new FrameLayout.LayoutParams(-1, -1));
            ArrayList arrayList = new ArrayList();
            C2819c.m8461a((ArrayList<EditText>) arrayList, (ViewGroup) BasePopupView.this.getPopupContentView());
            if (arrayList.size() > 0) {
                Window window = ((Activity) BasePopupView.this.getContext()).getWindow();
                BasePopupView.this.f8623g = window.getAttributes().softInputMode;
                if (BasePopupView.this.f8623g != 16) {
                    window.setSoftInputMode(16);
                }
            }
            BasePopupView.this.m8386j();
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$d */
    class RunnableC2782d implements Runnable {
        RunnableC2782d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC2815i interfaceC2815i;
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f8621e = EnumC2805e.Show;
            basePopupView.m8391p();
            BasePopupView basePopupView2 = BasePopupView.this;
            if (basePopupView2 instanceof FullScreenPopupView) {
                basePopupView2.m8384h();
            }
            C2800a c2800a = BasePopupView.this.f8617a;
            if (c2800a != null && (interfaceC2815i = c2800a.f8701n) != null) {
                interfaceC2815i.mo8434b();
            }
            if (C2819c.m8448a((Activity) BasePopupView.this.getContext()) <= 0 || BasePopupView.this.f8624h) {
                return;
            }
            C2819c.m8455a(C2819c.m8448a((Activity) BasePopupView.this.getContext()), BasePopupView.this);
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$e */
    class RunnableC2783e implements Runnable {
        RunnableC2783e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePopupView.this.mo8378b();
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$f */
    class RunnableC2784f implements Runnable {
        RunnableC2784f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC2815i interfaceC2815i;
            BasePopupView.this.mo8390o();
            C2800a c2800a = BasePopupView.this.f8617a;
            if (c2800a != null && (interfaceC2815i = c2800a.f8701n) != null) {
                interfaceC2815i.onDismiss();
            }
            Runnable runnable = BasePopupView.this.f8628l;
            if (runnable != null) {
                runnable.run();
                BasePopupView.this.f8628l = null;
            }
            BasePopupView.this.f8621e = EnumC2805e.Dismiss;
            if (!BasePopupView.f8616o.isEmpty()) {
                BasePopupView.f8616o.pop();
            }
            C2800a c2800a2 = BasePopupView.this.f8617a;
            if (c2800a2 != null && c2800a2.f8710w) {
                if (BasePopupView.f8616o.isEmpty()) {
                    View findViewById = ((Activity) BasePopupView.this.getContext()).findViewById(R.id.content);
                    findViewById.setFocusable(true);
                    findViewById.setFocusableInTouchMode(true);
                } else {
                    ((BasePopupView) BasePopupView.f8616o.get(BasePopupView.f8616o.size() - 1)).m8384h();
                }
            }
            BasePopupView basePopupView = BasePopupView.this;
            ViewGroup viewGroup = basePopupView.f8617a.f8702o;
            if (viewGroup != null) {
                viewGroup.removeView(basePopupView);
                BasePopupView basePopupView2 = BasePopupView.this;
                C2818b.m8444a(basePopupView2.f8617a.f8702o, basePopupView2);
            }
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$g */
    static /* synthetic */ class C2785g {

        /* renamed from: a */
        static final /* synthetic */ int[] f8637a = new int[EnumC2803c.values().length];

        static {
            try {
                f8637a[EnumC2803c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8637a[EnumC2803c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8637a[EnumC2803c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8637a[EnumC2803c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8637a[EnumC2803c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8637a[EnumC2803c.TranslateAlphaFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8637a[EnumC2803c.TranslateAlphaFromTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8637a[EnumC2803c.TranslateAlphaFromRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8637a[EnumC2803c.TranslateAlphaFromBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8637a[EnumC2803c.TranslateFromLeft.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8637a[EnumC2803c.TranslateFromTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8637a[EnumC2803c.TranslateFromRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8637a[EnumC2803c.TranslateFromBottom.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromLeft.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromLeftTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromRightTop.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromRight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromRightBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromBottom.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f8637a[EnumC2803c.ScrollAlphaFromLeftBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f8637a[EnumC2803c.NoAnimation.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$h */
    class ViewOnKeyListenerC2786h implements View.OnKeyListener {
        ViewOnKeyListenerC2786h() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterfaceC2815i interfaceC2815i;
            if (i2 != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            if (BasePopupView.this.f8617a.f8689b.booleanValue() && ((interfaceC2815i = BasePopupView.this.f8617a.f8701n) == null || !interfaceC2815i.mo8435c())) {
                BasePopupView.this.m8379c();
            }
            return true;
        }
    }

    /* renamed from: com.lxj.xpopup.core.BasePopupView$i */
    class RunnableC2787i implements Runnable {

        /* renamed from: a */
        View f8639a;

        /* renamed from: b */
        boolean f8640b = false;

        public RunnableC2787i(View view) {
            this.f8639a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f8639a;
            if (view == null || this.f8640b) {
                return;
            }
            this.f8640b = true;
            C2818b.m8447b(view);
        }
    }

    public BasePopupView(@NonNull Context context) {
        super(context);
        this.f8621e = EnumC2805e.Dismiss;
        this.f8622f = false;
        this.f8623g = -1;
        this.f8624h = false;
        this.f8625i = new RunnableC2782d();
        this.f8627k = new RunnableC2784f();
        this.f8620d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f8619c = new C2773e(this);
        View inflate = LayoutInflater.from(context).inflate(getPopupLayoutId(), (ViewGroup) this, false);
        inflate.setAlpha(0.0f);
        addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m8373u() {
        if (this.f8618b == null) {
            AbstractC2770b abstractC2770b = this.f8617a.f8696i;
            if (abstractC2770b != null) {
                this.f8618b = abstractC2770b;
                this.f8618b.f8569a = getPopupContentView();
            } else {
                this.f8618b = m8385i();
                if (this.f8618b == null) {
                    this.f8618b = getPopupAnimator();
                }
            }
            this.f8619c.mo8349d();
            AbstractC2770b abstractC2770b2 = this.f8618b;
            if (abstractC2770b2 != null) {
                abstractC2770b2.mo8349d();
            }
        }
    }

    /* renamed from: d */
    protected void m8380d() {
        if (this.f8617a.f8700m.booleanValue()) {
            C2818b.m8443a(this);
        }
        removeCallbacks(this.f8627k);
        postDelayed(this.f8627k, getAnimationDuration());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void mo8381e() {
        removeCallbacks(this.f8625i);
        postDelayed(this.f8625i, getAnimationDuration());
    }

    /* renamed from: f */
    public void mo8382f() {
        if (this.f8617a.f8692e.booleanValue()) {
            this.f8619c.mo8347a();
        }
        AbstractC2770b abstractC2770b = this.f8618b;
        if (abstractC2770b != null) {
            abstractC2770b.mo8347a();
        }
    }

    /* renamed from: g */
    public void mo8383g() {
        if (this.f8617a.f8692e.booleanValue()) {
            this.f8619c.f8586e = this.f8617a.f8695h == EnumC2803c.NoAnimation;
            this.f8619c.mo8348b();
        }
        AbstractC2770b abstractC2770b = this.f8618b;
        if (abstractC2770b != null) {
            abstractC2770b.mo8348b();
        }
    }

    public int getAnimationDuration() {
        if (this.f8617a.f8695h == EnumC2803c.NoAnimation) {
            return 10;
        }
        return C2768b.m8294a();
    }

    protected int getImplLayoutId() {
        return -1;
    }

    protected int getMaxHeight() {
        return this.f8617a.f8699l;
    }

    protected int getMaxWidth() {
        return 0;
    }

    protected AbstractC2770b getPopupAnimator() {
        return null;
    }

    public View getPopupContentView() {
        return getChildAt(0);
    }

    protected int getPopupHeight() {
        return 0;
    }

    public View getPopupImplView() {
        return ((ViewGroup) getPopupContentView()).getChildAt(0);
    }

    protected abstract int getPopupLayoutId();

    protected int getPopupWidth() {
        return 0;
    }

    protected View getTargetSizeView() {
        return getPopupContentView();
    }

    /* renamed from: h */
    public void m8384h() {
        if (this.f8617a.f8710w) {
            setFocusableInTouchMode(true);
            requestFocus();
            if (!f8616o.contains(this)) {
                f8616o.push(this);
            }
        }
        setOnKeyListener(new ViewOnKeyListenerC2786h());
        if (!this.f8617a.f8711x) {
            m8376a((View) this);
        }
        ArrayList arrayList = new ArrayList();
        C2819c.m8461a((ArrayList<EditText>) arrayList, (ViewGroup) getPopupContentView());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            EditText editText = (EditText) arrayList.get(i2);
            editText.setOnKeyListener(new ViewOnKeyListenerC2786h());
            if (i2 == 0 && this.f8617a.f8711x) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                m8376a(editText);
            }
        }
    }

    /* renamed from: i */
    protected AbstractC2770b m8385i() {
        EnumC2803c enumC2803c;
        C2800a c2800a = this.f8617a;
        if (c2800a == null || (enumC2803c = c2800a.f8695h) == null) {
            return null;
        }
        switch (C2785g.f8637a[enumC2803c.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new C2771c(getPopupContentView(), this.f8617a.f8695h);
            case 6:
            case 7:
            case 8:
            case 9:
                return new C2774f(getPopupContentView(), this.f8617a.f8695h);
            case 10:
            case 11:
            case 12:
            case 13:
                return new C2775g(getPopupContentView(), this.f8617a.f8695h);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return new C2772d(getPopupContentView(), this.f8617a.f8695h);
            case 22:
                return new C2769a();
            default:
                return null;
        }
    }

    /* renamed from: j */
    public void m8386j() {
        EnumC2805e enumC2805e = this.f8621e;
        EnumC2805e enumC2805e2 = EnumC2805e.Showing;
        if (enumC2805e == enumC2805e2) {
            return;
        }
        this.f8621e = enumC2805e2;
        if (!this.f8622f) {
            mo8364k();
        }
        if (!(this instanceof FullScreenPopupView) && !(this instanceof ImageViewerPopupView)) {
            C2819c.m8457a(getTargetSizeView(), (getMaxWidth() == 0 || getPopupWidth() <= getMaxWidth()) ? getPopupWidth() : getMaxWidth(), (getMaxHeight() == 0 || getPopupHeight() <= getMaxHeight()) ? getPopupHeight() : getMaxHeight());
        }
        if (!this.f8622f) {
            this.f8622f = true;
            mo8389n();
            InterfaceC2815i interfaceC2815i = this.f8617a.f8701n;
            if (interfaceC2815i != null) {
                interfaceC2815i.mo8433a();
            }
        }
        postDelayed(new RunnableC2779a(), 50L);
    }

    /* renamed from: k */
    protected void mo8364k() {
    }

    /* renamed from: l */
    public boolean m8387l() {
        return this.f8621e == EnumC2805e.Dismiss;
    }

    /* renamed from: m */
    public boolean m8388m() {
        return this.f8621e != EnumC2805e.Dismiss;
    }

    /* renamed from: n */
    protected void mo8389n() {
    }

    /* renamed from: o */
    protected void mo8390o() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f8616o.clear();
        removeCallbacks(this.f8625i);
        removeCallbacks(this.f8627k);
        C2818b.m8444a(this.f8617a.f8702o, this);
        RunnableC2787i runnableC2787i = this.f8626j;
        if (runnableC2787i != null) {
            removeCallbacks(runnableC2787i);
        }
        this.f8621e = EnumC2805e.Dismiss;
        this.f8626j = null;
        this.f8624h = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getPopupContentView().getGlobalVisibleRect(rect);
        if (!C2819c.m8462a(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f8629m = motionEvent.getX();
                this.f8630n = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f8629m, 2.0d) + Math.pow(motionEvent.getY() - this.f8630n, 2.0d))) < this.f8620d && this.f8617a.f8690c.booleanValue()) {
                    mo8378b();
                }
                this.f8629m = 0.0f;
                this.f8630n = 0.0f;
            }
        }
        return true;
    }

    /* renamed from: p */
    protected void m8391p() {
    }

    /* renamed from: q */
    protected void m8392q() {
    }

    /* renamed from: r */
    public BasePopupView m8393r() {
        if (getParent() != null) {
            return this;
        }
        Activity activity = (Activity) getContext();
        this.f8617a.f8702o = (ViewGroup) activity.getWindow().getDecorView();
        C2818b.m8442a(activity, this, new C2780b());
        this.f8617a.f8702o.post(new RunnableC2781c());
        return this;
    }

    /* renamed from: s */
    public void m8394s() {
        if (m8388m()) {
            mo8378b();
        } else {
            m8393r();
        }
    }

    /* renamed from: b */
    public void mo8378b() {
        EnumC2805e enumC2805e = this.f8621e;
        EnumC2805e enumC2805e2 = EnumC2805e.Dismissing;
        if (enumC2805e == enumC2805e2) {
            return;
        }
        this.f8621e = enumC2805e2;
        if (this.f8617a.f8700m.booleanValue()) {
            C2818b.m8443a(this);
        }
        m8392q();
        clearFocus();
        mo8382f();
        m8380d();
    }

    /* renamed from: c */
    protected void m8379c() {
        if (C2818b.f8731a == 0) {
            mo8378b();
        } else {
            C2818b.m8443a(this);
        }
    }

    /* renamed from: a */
    protected void m8376a(View view) {
        if (this.f8617a.f8700m.booleanValue()) {
            RunnableC2787i runnableC2787i = this.f8626j;
            if (runnableC2787i == null) {
                this.f8626j = new RunnableC2787i(view);
            } else {
                removeCallbacks(runnableC2787i);
            }
            postDelayed(this.f8626j, 10L);
        }
    }

    /* renamed from: a */
    public void m8374a(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        postDelayed(new RunnableC2783e(), j2);
    }

    /* renamed from: a */
    public void m8375a(long j2, Runnable runnable) {
        this.f8628l = runnable;
        m8374a(j2);
    }

    /* renamed from: a */
    public void m8377a(Runnable runnable) {
        this.f8628l = runnable;
        mo8378b();
    }

    public BasePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8621e = EnumC2805e.Dismiss;
        this.f8622f = false;
        this.f8623g = -1;
        this.f8624h = false;
        this.f8625i = new RunnableC2782d();
        this.f8627k = new RunnableC2784f();
    }

    public BasePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8621e = EnumC2805e.Dismiss;
        this.f8622f = false;
        this.f8623g = -1;
        this.f8624h = false;
        this.f8625i = new RunnableC2782d();
        this.f8627k = new RunnableC2784f();
    }
}
