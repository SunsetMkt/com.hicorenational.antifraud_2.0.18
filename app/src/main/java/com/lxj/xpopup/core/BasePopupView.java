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
import com.lxj.xpopup.f.b;
import com.lxj.xpopup.impl.FullScreenPopupView;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePopupView extends FrameLayout {
    private static Stack<BasePopupView> o = new Stack<>();
    public com.lxj.xpopup.core.a a;

    /* JADX INFO: renamed from: b */
    protected com.lxj.xpopup.c.b f5424b;

    /* JADX INFO: renamed from: c */
    protected com.lxj.xpopup.c.e f5425c;

    /* JADX INFO: renamed from: d */
    private int f5426d;

    /* JADX INFO: renamed from: e */
    public com.lxj.xpopup.d.e f5427e;

    /* JADX INFO: renamed from: f */
    private boolean f5428f;

    /* JADX INFO: renamed from: g */
    private int f5429g;

    /* JADX INFO: renamed from: h */
    private boolean f5430h;

    /* JADX INFO: renamed from: i */
    private Runnable f5431i;

    /* JADX INFO: renamed from: j */
    private i f5432j;

    /* JADX INFO: renamed from: k */
    private Runnable f5433k;

    /* JADX INFO: renamed from: l */
    Runnable f5434l;

    /* JADX INFO: renamed from: m */
    private float f5435m;

    /* JADX INFO: renamed from: n */
    private float f5436n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BasePopupView.this.getLayoutParams();
            int rotation = ((WindowManager) BasePopupView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (rotation == 0) {
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = com.lxj.xpopup.f.c.d(BasePopupView.this.getContext()) ? com.lxj.xpopup.f.c.b() : 0;
            } else if (rotation == 1) {
                layoutParams.bottomMargin = 0;
                layoutParams.rightMargin = com.lxj.xpopup.f.c.d(BasePopupView.this.getContext()) ? com.lxj.xpopup.f.c.b() : 0;
                layoutParams.leftMargin = 0;
            } else if (rotation == 3) {
                layoutParams.bottomMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = com.lxj.xpopup.f.c.d(BasePopupView.this.getContext()) ? com.lxj.xpopup.f.c.b() : 0;
            }
            BasePopupView.this.setLayoutParams(layoutParams);
            BasePopupView.this.getPopupContentView().setAlpha(1.0f);
            BasePopupView.this.u();
            BasePopupView.this.g();
            BasePopupView.this.e();
            BasePopupView basePopupView = BasePopupView.this;
            if (basePopupView instanceof FullScreenPopupView) {
                return;
            }
            basePopupView.h();
        }
    }

    class b implements b.InterfaceC0103b {
        b() {
        }

        @Override // com.lxj.xpopup.f.b.InterfaceC0103b
        public void a(int i2) {
            if (i2 == 0) {
                com.lxj.xpopup.f.c.c(BasePopupView.this);
                BasePopupView.this.f5430h = false;
            } else {
                com.lxj.xpopup.f.c.a(i2, BasePopupView.this);
                BasePopupView.this.f5430h = true;
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BasePopupView.this.getParent() != null) {
                ((ViewGroup) BasePopupView.this.getParent()).removeView(BasePopupView.this);
            }
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.a.o.addView(basePopupView, new FrameLayout.LayoutParams(-1, -1));
            ArrayList arrayList = new ArrayList();
            com.lxj.xpopup.f.c.a((ArrayList<EditText>) arrayList, (ViewGroup) BasePopupView.this.getPopupContentView());
            if (arrayList.size() > 0) {
                Window window = ((Activity) BasePopupView.this.getContext()).getWindow();
                BasePopupView.this.f5429g = window.getAttributes().softInputMode;
                if (BasePopupView.this.f5429g != 16) {
                    window.setSoftInputMode(16);
                }
            }
            BasePopupView.this.j();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.lxj.xpopup.e.i iVar;
            BasePopupView basePopupView = BasePopupView.this;
            basePopupView.f5427e = com.lxj.xpopup.d.e.Show;
            basePopupView.p();
            BasePopupView basePopupView2 = BasePopupView.this;
            if (basePopupView2 instanceof FullScreenPopupView) {
                basePopupView2.h();
            }
            com.lxj.xpopup.core.a aVar = BasePopupView.this.a;
            if (aVar != null && (iVar = aVar.f5453n) != null) {
                iVar.b();
            }
            if (com.lxj.xpopup.f.c.a((Activity) BasePopupView.this.getContext()) <= 0 || BasePopupView.this.f5430h) {
                return;
            }
            com.lxj.xpopup.f.c.a(com.lxj.xpopup.f.c.a((Activity) BasePopupView.this.getContext()), BasePopupView.this);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePopupView.this.b();
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.lxj.xpopup.e.i iVar;
            BasePopupView.this.o();
            com.lxj.xpopup.core.a aVar = BasePopupView.this.a;
            if (aVar != null && (iVar = aVar.f5453n) != null) {
                iVar.onDismiss();
            }
            Runnable runnable = BasePopupView.this.f5434l;
            if (runnable != null) {
                runnable.run();
                BasePopupView.this.f5434l = null;
            }
            BasePopupView.this.f5427e = com.lxj.xpopup.d.e.Dismiss;
            if (!BasePopupView.o.isEmpty()) {
                BasePopupView.o.pop();
            }
            com.lxj.xpopup.core.a aVar2 = BasePopupView.this.a;
            if (aVar2 != null && aVar2.w) {
                if (BasePopupView.o.isEmpty()) {
                    View viewFindViewById = ((Activity) BasePopupView.this.getContext()).findViewById(R.id.content);
                    viewFindViewById.setFocusable(true);
                    viewFindViewById.setFocusableInTouchMode(true);
                } else {
                    ((BasePopupView) BasePopupView.o.get(BasePopupView.o.size() - 1)).h();
                }
            }
            BasePopupView basePopupView = BasePopupView.this;
            ViewGroup viewGroup = basePopupView.a.o;
            if (viewGroup != null) {
                viewGroup.removeView(basePopupView);
                BasePopupView basePopupView2 = BasePopupView.this;
                com.lxj.xpopup.f.b.a(basePopupView2.a.o, basePopupView2);
            }
        }
    }

    static /* synthetic */ class g {
        static final /* synthetic */ int[] a = new int[com.lxj.xpopup.d.c.values().length];

        static {
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromLeft.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromRight.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateAlphaFromBottom.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateFromLeft.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateFromTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateFromRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[com.lxj.xpopup.d.c.TranslateFromBottom.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromLeft.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromTop.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromRightTop.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromRight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromRightBottom.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromBottom.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[com.lxj.xpopup.d.c.ScrollAlphaFromLeftBottom.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[com.lxj.xpopup.d.c.NoAnimation.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    class h implements View.OnKeyListener {
        h() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            com.lxj.xpopup.e.i iVar;
            if (i2 != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            if (BasePopupView.this.a.f5441b.booleanValue() && ((iVar = BasePopupView.this.a.f5453n) == null || !iVar.c())) {
                BasePopupView.this.c();
            }
            return true;
        }
    }

    class i implements Runnable {
        View a;

        /* JADX INFO: renamed from: b */
        boolean f5437b = false;

        public i(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.a;
            if (view == null || this.f5437b) {
                return;
            }
            this.f5437b = true;
            com.lxj.xpopup.f.b.b(view);
        }
    }

    public BasePopupView(@NonNull Context context) {
        super(context);
        this.f5427e = com.lxj.xpopup.d.e.Dismiss;
        this.f5428f = false;
        this.f5429g = -1;
        this.f5430h = false;
        this.f5431i = new d();
        this.f5433k = new f();
        this.f5426d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f5425c = new com.lxj.xpopup.c.e(this);
        View viewInflate = LayoutInflater.from(context).inflate(getPopupLayoutId(), (ViewGroup) this, false);
        viewInflate.setAlpha(0.0f);
        addView(viewInflate);
    }

    public void u() {
        if (this.f5424b == null) {
            com.lxj.xpopup.c.b bVar = this.a.f5448i;
            if (bVar != null) {
                this.f5424b = bVar;
                this.f5424b.a = getPopupContentView();
            } else {
                this.f5424b = i();
                if (this.f5424b == null) {
                    this.f5424b = getPopupAnimator();
                }
            }
            this.f5425c.d();
            com.lxj.xpopup.c.b bVar2 = this.f5424b;
            if (bVar2 != null) {
                bVar2.d();
            }
        }
    }

    protected void d() {
        if (this.a.f5452m.booleanValue()) {
            com.lxj.xpopup.f.b.a(this);
        }
        removeCallbacks(this.f5433k);
        postDelayed(this.f5433k, getAnimationDuration());
    }

    public void e() {
        removeCallbacks(this.f5431i);
        postDelayed(this.f5431i, getAnimationDuration());
    }

    public void f() {
        if (this.a.f5444e.booleanValue()) {
            this.f5425c.a();
        }
        com.lxj.xpopup.c.b bVar = this.f5424b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void g() {
        if (this.a.f5444e.booleanValue()) {
            this.f5425c.f5411e = this.a.f5447h == com.lxj.xpopup.d.c.NoAnimation;
            this.f5425c.b();
        }
        com.lxj.xpopup.c.b bVar = this.f5424b;
        if (bVar != null) {
            bVar.b();
        }
    }

    public int getAnimationDuration() {
        if (this.a.f5447h == com.lxj.xpopup.d.c.NoAnimation) {
            return 10;
        }
        return com.lxj.xpopup.b.a();
    }

    protected int getImplLayoutId() {
        return -1;
    }

    protected int getMaxHeight() {
        return this.a.f5451l;
    }

    protected int getMaxWidth() {
        return 0;
    }

    protected com.lxj.xpopup.c.b getPopupAnimator() {
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

    public void h() {
        if (this.a.w) {
            setFocusableInTouchMode(true);
            requestFocus();
            if (!o.contains(this)) {
                o.push(this);
            }
        }
        setOnKeyListener(new h());
        if (!this.a.x) {
            a((View) this);
        }
        ArrayList arrayList = new ArrayList();
        com.lxj.xpopup.f.c.a((ArrayList<EditText>) arrayList, (ViewGroup) getPopupContentView());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            EditText editText = (EditText) arrayList.get(i2);
            editText.setOnKeyListener(new h());
            if (i2 == 0 && this.a.x) {
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                editText.requestFocus();
                a(editText);
            }
        }
    }

    protected com.lxj.xpopup.c.b i() {
        com.lxj.xpopup.d.c cVar;
        com.lxj.xpopup.core.a aVar = this.a;
        if (aVar == null || (cVar = aVar.f5447h) == null) {
            return null;
        }
        switch (g.a[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return new com.lxj.xpopup.c.c(getPopupContentView(), this.a.f5447h);
            case 6:
            case 7:
            case 8:
            case 9:
                return new com.lxj.xpopup.c.f(getPopupContentView(), this.a.f5447h);
            case 10:
            case 11:
            case 12:
            case 13:
                return new com.lxj.xpopup.c.g(getPopupContentView(), this.a.f5447h);
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return new com.lxj.xpopup.c.d(getPopupContentView(), this.a.f5447h);
            case 22:
                return new com.lxj.xpopup.c.a();
            default:
                return null;
        }
    }

    public void j() {
        com.lxj.xpopup.d.e eVar = this.f5427e;
        com.lxj.xpopup.d.e eVar2 = com.lxj.xpopup.d.e.Showing;
        if (eVar == eVar2) {
            return;
        }
        this.f5427e = eVar2;
        if (!this.f5428f) {
            k();
        }
        if (!(this instanceof FullScreenPopupView) && !(this instanceof ImageViewerPopupView)) {
            com.lxj.xpopup.f.c.a(getTargetSizeView(), (getMaxWidth() == 0 || getPopupWidth() <= getMaxWidth()) ? getPopupWidth() : getMaxWidth(), (getMaxHeight() == 0 || getPopupHeight() <= getMaxHeight()) ? getPopupHeight() : getMaxHeight());
        }
        if (!this.f5428f) {
            this.f5428f = true;
            n();
            com.lxj.xpopup.e.i iVar = this.a.f5453n;
            if (iVar != null) {
                iVar.a();
            }
        }
        postDelayed(new a(), 50L);
    }

    protected void k() {
    }

    public boolean l() {
        return this.f5427e == com.lxj.xpopup.d.e.Dismiss;
    }

    public boolean m() {
        return this.f5427e != com.lxj.xpopup.d.e.Dismiss;
    }

    protected void n() {
    }

    protected void o() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o.clear();
        removeCallbacks(this.f5431i);
        removeCallbacks(this.f5433k);
        com.lxj.xpopup.f.b.a(this.a.o, this);
        i iVar = this.f5432j;
        if (iVar != null) {
            removeCallbacks(iVar);
        }
        this.f5427e = com.lxj.xpopup.d.e.Dismiss;
        this.f5432j = null;
        this.f5430h = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Rect rect = new Rect();
        getPopupContentView().getGlobalVisibleRect(rect);
        if (!com.lxj.xpopup.f.c.a(motionEvent.getX(), motionEvent.getY(), rect)) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f5435m = motionEvent.getX();
                this.f5436n = motionEvent.getY();
            } else if (action == 1) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f5435m, 2.0d) + Math.pow(motionEvent.getY() - this.f5436n, 2.0d))) < this.f5426d && this.a.f5442c.booleanValue()) {
                    b();
                }
                this.f5435m = 0.0f;
                this.f5436n = 0.0f;
            }
        }
        return true;
    }

    protected void p() {
    }

    protected void q() {
    }

    public BasePopupView r() {
        if (getParent() != null) {
            return this;
        }
        Activity activity = (Activity) getContext();
        this.a.o = (ViewGroup) activity.getWindow().getDecorView();
        com.lxj.xpopup.f.b.a(activity, this, new b());
        this.a.o.post(new c());
        return this;
    }

    public void s() {
        if (m()) {
            b();
        } else {
            r();
        }
    }

    public void b() {
        com.lxj.xpopup.d.e eVar = this.f5427e;
        com.lxj.xpopup.d.e eVar2 = com.lxj.xpopup.d.e.Dismissing;
        if (eVar == eVar2) {
            return;
        }
        this.f5427e = eVar2;
        if (this.a.f5452m.booleanValue()) {
            com.lxj.xpopup.f.b.a(this);
        }
        q();
        clearFocus();
        f();
        d();
    }

    protected void c() {
        if (com.lxj.xpopup.f.b.a == 0) {
            b();
        } else {
            com.lxj.xpopup.f.b.a(this);
        }
    }

    protected void a(View view) {
        if (this.a.f5452m.booleanValue()) {
            i iVar = this.f5432j;
            if (iVar == null) {
                this.f5432j = new i(view);
            } else {
                removeCallbacks(iVar);
            }
            postDelayed(this.f5432j, 10L);
        }
    }

    public void a(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        postDelayed(new e(), j2);
    }

    public void a(long j2, Runnable runnable) {
        this.f5434l = runnable;
        a(j2);
    }

    public void a(Runnable runnable) {
        this.f5434l = runnable;
        b();
    }

    public BasePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5427e = com.lxj.xpopup.d.e.Dismiss;
        this.f5428f = false;
        this.f5429g = -1;
        this.f5430h = false;
        this.f5431i = new d();
        this.f5433k = new f();
    }

    public BasePopupView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5427e = com.lxj.xpopup.d.e.Dismiss;
        this.f5428f = false;
        this.f5429g = -1;
        this.f5430h = false;
        this.f5431i = new d();
        this.f5433k = new f();
    }
}
