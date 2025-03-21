package com.chad.library.adapter.base.listener;

import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class SimpleClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: g, reason: collision with root package name */
    public static String f5467g = "SimpleClickListener";

    /* renamed from: a, reason: collision with root package name */
    private GestureDetectorCompat f5468a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f5469b;

    /* renamed from: c, reason: collision with root package name */
    protected BaseQuickAdapter f5470c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5471d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5472e = false;

    /* renamed from: f, reason: collision with root package name */
    private View f5473f = null;

    private class a implements GestureDetector.OnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private RecyclerView f5474a;

        /* renamed from: com.chad.library.adapter.base.listener.SimpleClickListener$a$a, reason: collision with other inner class name */
        class RunnableC0082a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f5476a;

            RunnableC0082a(View view) {
                this.f5476a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = this.f5476a;
                if (view != null) {
                    view.setPressed(false);
                }
            }
        }

        a(RecyclerView recyclerView) {
            this.f5474a = recyclerView;
        }

        private void a(View view) {
            if (view != null) {
                view.postDelayed(new RunnableC0082a(view), 50L);
            }
            SimpleClickListener.this.f5471d = false;
            SimpleClickListener.this.f5473f = null;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            SimpleClickListener.this.f5471d = true;
            SimpleClickListener.this.f5473f = this.f5474a.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        @Override // android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onLongPress(android.view.MotionEvent r10) {
            /*
                r9 = this;
                androidx.recyclerview.widget.RecyclerView r0 = r9.f5474a
                int r0 = r0.getScrollState()
                if (r0 == 0) goto L9
                return
            L9:
                com.chad.library.adapter.base.listener.SimpleClickListener r0 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                boolean r0 = com.chad.library.adapter.base.listener.SimpleClickListener.a(r0)
                if (r0 == 0) goto Lfe
                com.chad.library.adapter.base.listener.SimpleClickListener r0 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                android.view.View r0 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r0)
                if (r0 == 0) goto Lfe
                com.chad.library.adapter.base.listener.SimpleClickListener r0 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                android.view.View r0 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r0)
                r1 = 0
                r0.performHapticFeedback(r1)
                androidx.recyclerview.widget.RecyclerView r0 = r9.f5474a
                com.chad.library.adapter.base.listener.SimpleClickListener r2 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                android.view.View r2 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r2)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.getChildViewHolder(r2)
                com.chad.library.adapter.base.BaseViewHolder r0 = (com.chad.library.adapter.base.BaseViewHolder) r0
                com.chad.library.adapter.base.listener.SimpleClickListener r2 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                int r3 = r0.getLayoutPosition()
                boolean r2 = com.chad.library.adapter.base.listener.SimpleClickListener.a(r2, r3)
                if (r2 != 0) goto Lfe
                java.util.HashSet r2 = r0.d()
                java.util.Set r3 = r0.e()
                r4 = 1
                if (r2 == 0) goto La6
                int r5 = r2.size()
                if (r5 <= 0) goto La6
                java.util.Iterator r5 = r2.iterator()
            L52:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto La6
                java.lang.Object r6 = r5.next()
                java.lang.Integer r6 = (java.lang.Integer) r6
                com.chad.library.adapter.base.listener.SimpleClickListener r7 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                android.view.View r7 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r7)
                int r8 = r6.intValue()
                android.view.View r7 = r7.findViewById(r8)
                com.chad.library.adapter.base.listener.SimpleClickListener r8 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                boolean r8 = r8.a(r7, r10)
                if (r8 == 0) goto L52
                boolean r8 = r7.isEnabled()
                if (r8 == 0) goto L52
                if (r3 == 0) goto L83
                boolean r3 = r3.contains(r6)
                if (r3 == 0) goto L83
                goto La4
            L83:
                com.chad.library.adapter.base.listener.SimpleClickListener r3 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                com.chad.library.adapter.base.listener.SimpleClickListener.a(r3, r10, r7)
                com.chad.library.adapter.base.listener.SimpleClickListener r3 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                com.chad.library.adapter.base.BaseQuickAdapter r5 = r3.f5470c
                int r6 = r0.getLayoutPosition()
                com.chad.library.adapter.base.listener.SimpleClickListener r8 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                com.chad.library.adapter.base.BaseQuickAdapter r8 = r8.f5470c
                int r8 = r8.j()
                int r6 = r6 - r8
                r3.b(r5, r7, r6)
                r7.setPressed(r4)
                com.chad.library.adapter.base.listener.SimpleClickListener r3 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                com.chad.library.adapter.base.listener.SimpleClickListener.b(r3, r4)
            La4:
                r3 = 1
                goto La7
            La6:
                r3 = 0
            La7:
                if (r3 != 0) goto Lfe
                com.chad.library.adapter.base.listener.SimpleClickListener r3 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                com.chad.library.adapter.base.BaseQuickAdapter r5 = r3.f5470c
                android.view.View r6 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r3)
                int r0 = r0.getLayoutPosition()
                com.chad.library.adapter.base.listener.SimpleClickListener r7 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                com.chad.library.adapter.base.BaseQuickAdapter r7 = r7.f5470c
                int r7 = r7.j()
                int r0 = r0 - r7
                r3.d(r5, r6, r0)
                com.chad.library.adapter.base.listener.SimpleClickListener r0 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                android.view.View r3 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r0)
                com.chad.library.adapter.base.listener.SimpleClickListener.a(r0, r10, r3)
                com.chad.library.adapter.base.listener.SimpleClickListener r10 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                android.view.View r10 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r10)
                r10.setPressed(r4)
                if (r2 == 0) goto Lf9
                java.util.Iterator r10 = r2.iterator()
            Ld9:
                boolean r0 = r10.hasNext()
                if (r0 == 0) goto Lf9
                java.lang.Object r0 = r10.next()
                java.lang.Integer r0 = (java.lang.Integer) r0
                com.chad.library.adapter.base.listener.SimpleClickListener r2 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                android.view.View r2 = com.chad.library.adapter.base.listener.SimpleClickListener.b(r2)
                int r0 = r0.intValue()
                android.view.View r0 = r2.findViewById(r0)
                if (r0 == 0) goto Ld9
                r0.setPressed(r1)
                goto Ld9
            Lf9:
                com.chad.library.adapter.base.listener.SimpleClickListener r10 = com.chad.library.adapter.base.listener.SimpleClickListener.this
                com.chad.library.adapter.base.listener.SimpleClickListener.b(r10, r4)
            Lfe:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chad.library.adapter.base.listener.SimpleClickListener.a.onLongPress(android.view.MotionEvent):void");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            if (!SimpleClickListener.this.f5471d || SimpleClickListener.this.f5473f == null) {
                return;
            }
            SimpleClickListener.this.f5472e = true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (SimpleClickListener.this.f5471d && SimpleClickListener.this.f5473f != null) {
                if (this.f5474a.getScrollState() != 0) {
                    return false;
                }
                View view = SimpleClickListener.this.f5473f;
                BaseViewHolder baseViewHolder = (BaseViewHolder) this.f5474a.getChildViewHolder(view);
                if (SimpleClickListener.this.a(baseViewHolder.getLayoutPosition())) {
                    return false;
                }
                HashSet<Integer> b2 = baseViewHolder.b();
                Set<Integer> e2 = baseViewHolder.e();
                if (b2 == null || b2.size() <= 0) {
                    SimpleClickListener.this.a(motionEvent, view);
                    SimpleClickListener.this.f5473f.setPressed(true);
                    if (b2 != null && b2.size() > 0) {
                        Iterator<Integer> it = b2.iterator();
                        while (it.hasNext()) {
                            View findViewById = view.findViewById(it.next().intValue());
                            if (findViewById != null) {
                                findViewById.setPressed(false);
                            }
                        }
                    }
                    SimpleClickListener simpleClickListener = SimpleClickListener.this;
                    simpleClickListener.c(simpleClickListener.f5470c, view, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f5470c.j());
                } else {
                    for (Integer num : b2) {
                        View findViewById2 = view.findViewById(num.intValue());
                        if (findViewById2 != null) {
                            if (SimpleClickListener.this.a(findViewById2, motionEvent) && findViewById2.isEnabled()) {
                                if (e2 != null && e2.contains(num)) {
                                    return false;
                                }
                                SimpleClickListener.this.a(motionEvent, findViewById2);
                                findViewById2.setPressed(true);
                                SimpleClickListener simpleClickListener2 = SimpleClickListener.this;
                                simpleClickListener2.a(simpleClickListener2.f5470c, findViewById2, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f5470c.j());
                                a(findViewById2);
                                return true;
                            }
                            findViewById2.setPressed(false);
                        }
                    }
                    SimpleClickListener.this.a(motionEvent, view);
                    SimpleClickListener.this.f5473f.setPressed(true);
                    Iterator<Integer> it2 = b2.iterator();
                    while (it2.hasNext()) {
                        View findViewById3 = view.findViewById(it2.next().intValue());
                        if (findViewById3 != null) {
                            findViewById3.setPressed(false);
                        }
                    }
                    SimpleClickListener simpleClickListener3 = SimpleClickListener.this;
                    simpleClickListener3.c(simpleClickListener3.f5470c, view, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f5470c.j());
                }
                a(view);
            }
            return true;
        }
    }

    private boolean b(int i2) {
        return i2 == 1365 || i2 == 273 || i2 == 819 || i2 == 546;
    }

    public abstract void a(BaseQuickAdapter baseQuickAdapter, View view, int i2);

    public abstract void b(BaseQuickAdapter baseQuickAdapter, View view, int i2);

    public abstract void c(BaseQuickAdapter baseQuickAdapter, View view, int i2);

    public abstract void d(BaseQuickAdapter baseQuickAdapter, View view, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView2 = this.f5469b;
        if (recyclerView2 == null) {
            this.f5469b = recyclerView;
            this.f5470c = (BaseQuickAdapter) this.f5469b.getAdapter();
            this.f5468a = new GestureDetectorCompat(this.f5469b.getContext(), new a(this.f5469b));
        } else if (recyclerView2 != recyclerView) {
            this.f5469b = recyclerView;
            this.f5470c = (BaseQuickAdapter) this.f5469b.getAdapter();
            this.f5468a = new GestureDetectorCompat(this.f5469b.getContext(), new a(this.f5469b));
        }
        if (!this.f5468a.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1 && this.f5472e) {
            View view = this.f5473f;
            if (view != null && ((baseViewHolder = (BaseViewHolder) this.f5469b.getChildViewHolder(view)) == null || !b(baseViewHolder.getItemViewType()))) {
                this.f5473f.setPressed(false);
            }
            this.f5472e = false;
            this.f5471d = false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f5468a.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent, View view) {
        if (Build.VERSION.SDK_INT < 21 || view == null || view.getBackground() == null) {
            return;
        }
        view.getBackground().setHotspot(motionEvent.getRawX(), motionEvent.getY() - view.getY());
    }

    public boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (view != null && view.isShown()) {
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            if (motionEvent.getRawX() >= i2 && motionEvent.getRawX() <= i2 + view.getWidth() && motionEvent.getRawY() >= i3 && motionEvent.getRawY() <= i3 + view.getHeight()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2) {
        if (this.f5470c == null) {
            RecyclerView recyclerView = this.f5469b;
            if (recyclerView == null) {
                return false;
            }
            this.f5470c = (BaseQuickAdapter) recyclerView.getAdapter();
        }
        int itemViewType = this.f5470c.getItemViewType(i2);
        return itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546;
    }
}
