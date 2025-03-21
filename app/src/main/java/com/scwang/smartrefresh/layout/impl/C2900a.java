package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.legacy.widget.Space;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2871e;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2875i;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2877k;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2881a;
import com.scwang.smartrefresh.layout.p192e.AbstractC2892e;
import com.scwang.smartrefresh.layout.p192e.C2890c;
import com.scwang.smartrefresh.layout.p192e.C2891d;
import java.util.Collections;
import java.util.LinkedList;

/* compiled from: RefreshContentWrapper.java */
/* renamed from: com.scwang.smartrefresh.layout.impl.a */
/* loaded from: classes.dex */
public class C2900a implements InterfaceC2871e, InterfaceC2881a, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    protected View f9220a;

    /* renamed from: b */
    protected View f9221b;

    /* renamed from: c */
    protected View f9222c;

    /* renamed from: d */
    protected View f9223d;

    /* renamed from: e */
    protected View f9224e;

    /* renamed from: f */
    protected int f9225f = 0;

    /* renamed from: g */
    protected boolean f9226g = true;

    /* renamed from: h */
    protected boolean f9227h = true;

    /* renamed from: i */
    protected C2901b f9228i = new C2901b();

    public C2900a(@NonNull View view) {
        this.f9222c = view;
        this.f9221b = view;
        this.f9220a = view;
    }

    /* renamed from: a */
    protected void m8784a(View view, InterfaceC2875i interfaceC2875i) {
        boolean isInEditMode = this.f9220a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = m8783a(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!isInEditMode) {
                C2890c.m8738a(view, interfaceC2875i, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.f9222c = view2;
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: b */
    public boolean mo8710b() {
        return this.f9227h && this.f9228i.mo8721b(this.f9220a);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    @NonNull
    /* renamed from: c */
    public View mo8711c() {
        return this.f9222c;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    @NonNull
    public View getView() {
        return this.f9220a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            if (this.f9222c instanceof AbsListView) {
                AbstractC2892e.m8747a((AbsListView) this.f9222c, intValue - this.f9225f);
            } else {
                this.f9222c.scrollBy(0, intValue - this.f9225f);
            }
        } catch (Throwable unused) {
        }
        this.f9225f = intValue;
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: b */
    public void mo8709b(boolean z) {
        this.f9228i.f9231c = z;
    }

    @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2881a
    /* renamed from: a */
    public void mo8722a(boolean z, boolean z2) {
        this.f9226g = z;
        this.f9227h = z2;
    }

    /* renamed from: a */
    protected View m8783a(View view, boolean z) {
        LinkedList linkedList = new LinkedList(Collections.singletonList(view));
        View view2 = null;
        while (!linkedList.isEmpty() && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && AbstractC2892e.m8748a(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        linkedList.add(viewGroup.getChildAt(i2));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    /* renamed from: a */
    protected View m8782a(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (C2891d.m8743a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && AbstractC2892e.m8748a(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View m8782a = m8782a(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return m8782a;
                }
            }
        }
        return view2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo8704a(int r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 1
            r1 = -1
            r2 = 0
            r3 = 0
            if (r7 == r1) goto L21
            android.view.View r4 = r5.f9221b
            android.view.View r7 = r4.findViewById(r7)
            if (r7 == 0) goto L21
            if (r6 <= 0) goto L16
            float r4 = (float) r6
            r7.setTranslationY(r4)
            r7 = 1
            goto L22
        L16:
            float r4 = r7.getTranslationY()
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 <= 0) goto L21
            r7.setTranslationY(r3)
        L21:
            r7 = 0
        L22:
            if (r8 == r1) goto L3f
            android.view.View r1 = r5.f9221b
            android.view.View r8 = r1.findViewById(r8)
            if (r8 == 0) goto L3f
            if (r6 >= 0) goto L34
            float r7 = (float) r6
            r8.setTranslationY(r7)
            r7 = 1
            goto L3f
        L34:
            float r0 = r8.getTranslationY()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L3f
            r8.setTranslationY(r3)
        L3f:
            if (r7 != 0) goto L48
            android.view.View r7 = r5.f9221b
            float r8 = (float) r6
            r7.setTranslationY(r8)
            goto L4d
        L48:
            android.view.View r7 = r5.f9221b
            r7.setTranslationY(r3)
        L4d:
            android.view.View r7 = r5.f9223d
            if (r7 == 0) goto L59
            int r8 = java.lang.Math.max(r2, r6)
            float r8 = (float) r8
            r7.setTranslationY(r8)
        L59:
            android.view.View r7 = r5.f9224e
            if (r7 == 0) goto L65
            int r6 = java.lang.Math.min(r2, r6)
            float r6 = (float) r6
            r7.setTranslationY(r6)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.impl.C2900a.mo8704a(int, int, int):void");
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: a */
    public boolean mo8708a() {
        return this.f9226g && this.f9228i.mo8720a(this.f9220a);
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: a */
    public void mo8705a(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.f9220a.getLeft(), -this.f9220a.getTop());
        View view = this.f9222c;
        View view2 = this.f9220a;
        if (view != view2) {
            this.f9222c = m8782a(view2, pointF, view);
        }
        if (this.f9222c == this.f9220a) {
            this.f9228i.f9229a = null;
        } else {
            this.f9228i.f9229a = pointF;
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: a */
    public void mo8706a(InterfaceC2875i interfaceC2875i, View view, View view2) {
        m8784a(this.f9220a, interfaceC2875i);
        if (view == null && view2 == null) {
            return;
        }
        this.f9223d = view;
        this.f9224e = view2;
        FrameLayout frameLayout = new FrameLayout(this.f9220a.getContext());
        interfaceC2875i.mo8698c().getLayout().removeView(this.f9220a);
        ViewGroup.LayoutParams layoutParams = this.f9220a.getLayoutParams();
        frameLayout.addView(this.f9220a, -1, -1);
        interfaceC2875i.mo8698c().getLayout().addView(frameLayout, layoutParams);
        this.f9220a = frameLayout;
        if (view != null) {
            view.setClickable(true);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams2.height = AbstractC2892e.m8750c(view);
            viewGroup.addView(new Space(this.f9220a.getContext()), indexOfChild, layoutParams2);
            frameLayout.addView(view);
        }
        if (view2 != null) {
            view2.setClickable(true);
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int indexOfChild2 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(layoutParams3);
            layoutParams3.height = AbstractC2892e.m8750c(view2);
            viewGroup2.addView(new Space(this.f9220a.getContext()), indexOfChild2, layoutParams3);
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: a */
    public void mo8707a(InterfaceC2877k interfaceC2877k) {
        if (interfaceC2877k instanceof C2901b) {
            this.f9228i = (C2901b) interfaceC2877k;
        } else {
            this.f9228i.f9230b = interfaceC2877k;
        }
    }

    @Override // com.scwang.smartrefresh.layout.p189b.InterfaceC2871e
    /* renamed from: a */
    public ValueAnimator.AnimatorUpdateListener mo8703a(int i2) {
        View view = this.f9222c;
        if (view == null || i2 == 0) {
            return null;
        }
        if ((i2 >= 0 || !C2891d.m8740a(view)) && (i2 <= 0 || !C2891d.m8744b(this.f9222c))) {
            return null;
        }
        this.f9225f = i2;
        return this;
    }
}
