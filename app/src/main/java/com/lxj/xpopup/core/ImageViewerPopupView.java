package com.lxj.xpopup.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeTransform;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpermission.C2765b;
import com.lxj.xpermission.XPermission;
import com.lxj.xpopup.C2766R;
import com.lxj.xpopup.C2768b;
import com.lxj.xpopup.p185d.EnumC2805e;
import com.lxj.xpopup.p186e.InterfaceC2810d;
import com.lxj.xpopup.p186e.InterfaceC2813g;
import com.lxj.xpopup.p186e.InterfaceC2816j;
import com.lxj.xpopup.p187f.C2819c;
import com.lxj.xpopup.photoview.PhotoView;
import com.lxj.xpopup.widget.BlankView;
import com.lxj.xpopup.widget.HackyViewPager;
import com.lxj.xpopup.widget.PhotoViewContainer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ImageViewerPopupView extends BasePopupView implements InterfaceC2810d, View.OnClickListener {

    /* renamed from: A */
    protected Rect f8652A;

    /* renamed from: B */
    protected ImageView f8653B;

    /* renamed from: C */
    protected PhotoView f8654C;

    /* renamed from: D */
    protected boolean f8655D;

    /* renamed from: E */
    protected int f8656E;

    /* renamed from: F */
    protected int f8657F;

    /* renamed from: G */
    protected int f8658G;

    /* renamed from: H */
    protected boolean f8659H;

    /* renamed from: I */
    protected boolean f8660I;

    /* renamed from: J */
    protected boolean f8661J;

    /* renamed from: K */
    protected View f8662K;

    /* renamed from: L */
    protected int f8663L;

    /* renamed from: p */
    protected FrameLayout f8664p;

    /* renamed from: q */
    protected PhotoViewContainer f8665q;

    /* renamed from: r */
    protected BlankView f8666r;

    /* renamed from: s */
    protected TextView f8667s;

    /* renamed from: t */
    protected TextView f8668t;

    /* renamed from: u */
    protected HackyViewPager f8669u;

    /* renamed from: v */
    protected ArgbEvaluator f8670v;

    /* renamed from: w */
    protected List<Object> f8671w;

    /* renamed from: x */
    protected InterfaceC2816j f8672x;

    /* renamed from: y */
    protected InterfaceC2813g f8673y;

    /* renamed from: z */
    protected int f8674z;

    public class PhotoViewAdapter extends PagerAdapter {

        /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$PhotoViewAdapter$a */
        class ViewOnClickListenerC2792a implements View.OnClickListener {
            ViewOnClickListenerC2792a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageViewerPopupView.this.mo8378b();
            }
        }

        public PhotoViewAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            if (imageViewerPopupView.f8661J) {
                return 1073741823;
            }
            return imageViewerPopupView.f8671w.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            PhotoView photoView = new PhotoView(viewGroup.getContext());
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            InterfaceC2816j interfaceC2816j = imageViewerPopupView.f8672x;
            if (interfaceC2816j != null) {
                List<Object> list = imageViewerPopupView.f8671w;
                interfaceC2816j.m8437a(i2, list.get(imageViewerPopupView.f8661J ? i2 % list.size() : i2), photoView);
            }
            viewGroup.addView(photoView);
            photoView.setOnClickListener(new ViewOnClickListenerC2792a());
            return photoView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return obj == view;
        }
    }

    /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$a */
    class C2793a extends ViewPager.SimpleOnPageChangeListener {
        C2793a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.f8674z = i2;
            imageViewerPopupView.m8410x();
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            InterfaceC2813g interfaceC2813g = imageViewerPopupView2.f8673y;
            if (interfaceC2813g != null) {
                interfaceC2813g.m8432a(imageViewerPopupView2, i2);
            }
        }
    }

    /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$b */
    class RunnableC2794b implements Runnable {

        /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$b$a */
        class a extends TransitionListenerAdapter {
            a() {
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ImageViewerPopupView.this.f8669u.setVisibility(0);
                ImageViewerPopupView.this.f8654C.setVisibility(4);
                ImageViewerPopupView.this.m8410x();
                ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
                imageViewerPopupView.f8665q.f8920f = false;
                ImageViewerPopupView.super.mo8381e();
            }
        }

        RunnableC2794b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TransitionManager.beginDelayedTransition((ViewGroup) ImageViewerPopupView.this.f8654C.getParent(), new TransitionSet().setDuration(C2768b.m8294a()).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).addListener((Transition.TransitionListener) new a()));
            ImageViewerPopupView.this.f8654C.setTranslationY(0.0f);
            ImageViewerPopupView.this.f8654C.setTranslationX(0.0f);
            ImageViewerPopupView.this.f8654C.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            C2819c.m8457a(imageViewerPopupView.f8654C, imageViewerPopupView.f8665q.getWidth(), ImageViewerPopupView.this.f8665q.getHeight());
            ImageViewerPopupView imageViewerPopupView2 = ImageViewerPopupView.this;
            imageViewerPopupView2.m8407d(imageViewerPopupView2.f8663L);
            View view = ImageViewerPopupView.this.f8662K;
            if (view != null) {
                view.animate().alpha(1.0f).setDuration(C2768b.m8294a()).start();
            }
        }
    }

    /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$c */
    class C2795c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        final /* synthetic */ int f8680a;

        /* renamed from: b */
        final /* synthetic */ int f8681b;

        C2795c(int i2, int i3) {
            this.f8680a = i2;
            this.f8681b = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            imageViewerPopupView.f8665q.setBackgroundColor(((Integer) imageViewerPopupView.f8670v.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(this.f8680a), Integer.valueOf(this.f8681b))).intValue());
        }
    }

    /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$d */
    class C2796d extends TransitionListenerAdapter {
        C2796d() {
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            ImageViewerPopupView.this.m8380d();
            ImageViewerPopupView.this.f8669u.setVisibility(4);
            ImageViewerPopupView.this.f8654C.setVisibility(0);
            ImageViewerPopupView.this.f8669u.setScaleX(1.0f);
            ImageViewerPopupView.this.f8669u.setScaleY(1.0f);
            ImageViewerPopupView.this.f8654C.setScaleX(1.0f);
            ImageViewerPopupView.this.f8654C.setScaleY(1.0f);
            ImageViewerPopupView.this.f8666r.setVisibility(4);
        }
    }

    /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$e */
    class C2797e extends AnimatorListenerAdapter {
        C2797e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            View view = ImageViewerPopupView.this.f8662K;
            if (view != null) {
                view.setVisibility(4);
            }
        }
    }

    /* renamed from: com.lxj.xpopup.core.ImageViewerPopupView$f */
    class C2798f implements XPermission.InterfaceC2762d {
        C2798f() {
        }

        @Override // com.lxj.xpermission.XPermission.InterfaceC2762d
        /* renamed from: a */
        public void mo8291a() {
            Toast.makeText(ImageViewerPopupView.this.getContext(), "没有保存权限，保存功能无法使用！", 0).show();
        }

        @Override // com.lxj.xpermission.XPermission.InterfaceC2762d
        public void onGranted() {
            Context context = ImageViewerPopupView.this.getContext();
            ImageViewerPopupView imageViewerPopupView = ImageViewerPopupView.this;
            InterfaceC2816j interfaceC2816j = imageViewerPopupView.f8672x;
            List<Object> list = imageViewerPopupView.f8671w;
            boolean z = imageViewerPopupView.f8661J;
            int i2 = imageViewerPopupView.f8674z;
            if (z) {
                i2 %= list.size();
            }
            C2819c.m8456a(context, interfaceC2816j, list.get(i2));
        }
    }

    public ImageViewerPopupView(@NonNull Context context) {
        super(context);
        this.f8670v = new ArgbEvaluator();
        this.f8671w = new ArrayList();
        this.f8652A = null;
        this.f8655D = true;
        this.f8656E = -1;
        this.f8657F = -1;
        this.f8658G = -1;
        this.f8659H = true;
        this.f8660I = true;
        this.f8661J = false;
        this.f8663L = Color.rgb(32, 36, 46);
        this.f8664p = (FrameLayout) findViewById(C2766R.id.container);
        if (getImplLayoutId() > 0) {
            this.f8662K = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) this.f8664p, false);
            this.f8662K.setVisibility(4);
            this.f8662K.setAlpha(0.0f);
            this.f8664p.addView(this.f8662K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8407d(int i2) {
        int color = ((ColorDrawable) this.f8665q.getBackground()).getColor();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new C2795c(color, i2));
        ofFloat.setDuration(C2768b.m8294a()).setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    /* renamed from: v */
    private void m8408v() {
        if (this.f8653B == null) {
            return;
        }
        if (this.f8654C == null) {
            this.f8654C = new PhotoView(getContext());
            this.f8665q.addView(this.f8654C);
            this.f8654C.setScaleType(this.f8653B.getScaleType());
            this.f8654C.setTranslationX(this.f8652A.left);
            this.f8654C.setTranslationY(this.f8652A.top);
            C2819c.m8457a(this.f8654C, this.f8652A.width(), this.f8652A.height());
        }
        m8409w();
        this.f8654C.setImageDrawable(this.f8653B.getDrawable());
    }

    /* renamed from: w */
    private void m8409w() {
        this.f8666r.setVisibility(this.f8655D ? 0 : 4);
        if (this.f8655D) {
            int i2 = this.f8656E;
            if (i2 != -1) {
                this.f8666r.f8891d = i2;
            }
            int i3 = this.f8658G;
            if (i3 != -1) {
                this.f8666r.f8890c = i3;
            }
            int i4 = this.f8657F;
            if (i4 != -1) {
                this.f8666r.f8892e = i4;
            }
            C2819c.m8457a(this.f8666r, this.f8652A.width(), this.f8652A.height());
            this.f8666r.setTranslationX(this.f8652A.left);
            this.f8666r.setTranslationY(this.f8652A.top);
            this.f8666r.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m8410x() {
        if (this.f8671w.size() > 1) {
            int size = this.f8661J ? this.f8674z % this.f8671w.size() : this.f8674z;
            this.f8667s.setText((size + 1) + "/" + this.f8671w.size());
        }
        if (this.f8659H) {
            this.f8668t.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: e */
    public void mo8381e() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: f */
    public void mo8382f() {
        if (this.f8653B == null) {
            this.f8665q.setBackgroundColor(0);
            m8380d();
            this.f8669u.setVisibility(4);
            this.f8666r.setVisibility(4);
            return;
        }
        this.f8667s.setVisibility(4);
        this.f8668t.setVisibility(4);
        this.f8669u.setVisibility(4);
        this.f8654C.setVisibility(0);
        this.f8665q.f8920f = true;
        TransitionManager.beginDelayedTransition((ViewGroup) this.f8654C.getParent(), new TransitionSet().setDuration(C2768b.m8294a()).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()).setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator()).addListener((Transition.TransitionListener) new C2796d()));
        this.f8654C.setTranslationY(this.f8652A.top);
        this.f8654C.setTranslationX(this.f8652A.left);
        this.f8654C.setScaleX(1.0f);
        this.f8654C.setScaleY(1.0f);
        this.f8654C.setScaleType(this.f8653B.getScaleType());
        C2819c.m8457a(this.f8654C, this.f8652A.width(), this.f8652A.height());
        m8407d(0);
        View view = this.f8662K;
        if (view != null) {
            view.animate().alpha(0.0f).setDuration(C2768b.m8294a()).setListener(new C2797e()).start();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: g */
    public void mo8383g() {
        if (this.f8653B == null) {
            this.f8665q.setBackgroundColor(this.f8663L);
            this.f8669u.setVisibility(0);
            m8410x();
            this.f8665q.f8920f = false;
            super.mo8381e();
            return;
        }
        this.f8665q.f8920f = true;
        this.f8654C.setVisibility(0);
        View view = this.f8662K;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f8654C.post(new RunnableC2794b());
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getAnimationDuration() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupLayoutId() {
        return C2766R.layout._xpopup_image_viewer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: k */
    protected void mo8364k() {
        super.mo8364k();
        this.f8667s = (TextView) findViewById(C2766R.id.tv_pager_indicator);
        this.f8668t = (TextView) findViewById(C2766R.id.tv_save);
        this.f8666r = (BlankView) findViewById(C2766R.id.placeholderView);
        this.f8665q = (PhotoViewContainer) findViewById(C2766R.id.photoViewContainer);
        this.f8665q.setOnDragChangeListener(this);
        this.f8669u = (HackyViewPager) findViewById(C2766R.id.pager);
        this.f8669u.setAdapter(new PhotoViewAdapter());
        this.f8669u.setOffscreenPageLimit(this.f8671w.size());
        this.f8669u.setCurrentItem(this.f8674z);
        this.f8669u.setVisibility(4);
        m8408v();
        if (this.f8661J) {
            this.f8669u.setOffscreenPageLimit(this.f8671w.size() / 2);
        }
        this.f8669u.addOnPageChangeListener(new C2793a());
        if (!this.f8660I) {
            this.f8667s.setVisibility(8);
        }
        if (this.f8659H) {
            this.f8668t.setOnClickListener(this);
        } else {
            this.f8668t.setVisibility(8);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: o */
    protected void mo8390o() {
        super.mo8390o();
        this.f8653B = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f8668t) {
            m8426u();
        }
    }

    /* renamed from: u */
    protected void m8426u() {
        XPermission.m8249a(getContext(), C2765b.f8541i).m8275a(new C2798f()).m8285e();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    /* renamed from: b */
    public void mo8378b() {
        if (this.f8621e != EnumC2805e.Show) {
            return;
        }
        this.f8621e = EnumC2805e.Dismissing;
        if (this.f8653B != null) {
            HackyViewPager hackyViewPager = this.f8669u;
            PhotoView photoView = (PhotoView) hackyViewPager.getChildAt(hackyViewPager.getCurrentItem());
            if (photoView != null) {
                Matrix matrix = new Matrix();
                photoView.getSuppMatrix(matrix);
                this.f8654C.setSuppMatrix(matrix);
            }
        }
        mo8382f();
    }

    /* renamed from: c */
    public ImageViewerPopupView m8424c(boolean z) {
        this.f8655D = z;
        return this;
    }

    /* renamed from: a */
    public ImageViewerPopupView m8416a(List<Object> list) {
        this.f8671w = list;
        return this;
    }

    /* renamed from: c */
    public ImageViewerPopupView m8423c(int i2) {
        this.f8657F = i2;
        return this;
    }

    /* renamed from: a */
    public ImageViewerPopupView m8414a(InterfaceC2813g interfaceC2813g) {
        this.f8673y = interfaceC2813g;
        return this;
    }

    /* renamed from: a */
    public ImageViewerPopupView m8415a(InterfaceC2816j interfaceC2816j) {
        this.f8672x = interfaceC2816j;
        return this;
    }

    /* renamed from: a */
    public ImageViewerPopupView m8417a(boolean z) {
        this.f8661J = z;
        return this;
    }

    /* renamed from: a */
    public ImageViewerPopupView m8411a(int i2) {
        this.f8656E = i2;
        return this;
    }

    /* renamed from: d */
    public ImageViewerPopupView m8425d(boolean z) {
        this.f8659H = z;
        return this;
    }

    /* renamed from: a */
    public ImageViewerPopupView m8413a(ImageView imageView, Object obj) {
        if (this.f8671w == null) {
            this.f8671w = new ArrayList();
        }
        this.f8671w.clear();
        this.f8671w.add(obj);
        m8412a(imageView, 0);
        return this;
    }

    /* renamed from: b */
    public ImageViewerPopupView m8422b(boolean z) {
        this.f8660I = z;
        return this;
    }

    /* renamed from: b */
    public ImageViewerPopupView m8421b(int i2) {
        this.f8658G = i2;
        return this;
    }

    /* renamed from: a */
    public ImageViewerPopupView m8412a(ImageView imageView, int i2) {
        this.f8653B = imageView;
        this.f8674z = i2;
        if (imageView != null) {
            int[] iArr = new int[2];
            this.f8653B.getLocationInWindow(iArr);
            this.f8652A = new Rect(iArr[0], iArr[1], iArr[0] + imageView.getWidth(), iArr[1] + imageView.getHeight());
        }
        return this;
    }

    /* renamed from: a */
    public void m8420a(ImageView imageView) {
        m8412a(imageView, this.f8674z);
        m8408v();
    }

    @Override // com.lxj.xpopup.p186e.InterfaceC2810d
    /* renamed from: a */
    public void mo8418a() {
        mo8378b();
    }

    @Override // com.lxj.xpopup.p186e.InterfaceC2810d
    /* renamed from: a */
    public void mo8419a(int i2, float f2, float f3) {
        float f4 = 1.0f - f3;
        this.f8667s.setAlpha(f4);
        View view = this.f8662K;
        if (view != null) {
            view.setAlpha(f4);
        }
        if (this.f8659H) {
            this.f8668t.setAlpha(f4);
        }
        this.f8665q.setBackgroundColor(((Integer) this.f8670v.evaluate(f3 * 0.8f, Integer.valueOf(this.f8663L), 0)).intValue());
    }
}
