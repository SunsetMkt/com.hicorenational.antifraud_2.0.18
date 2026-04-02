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

/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleClickListener implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f3626g = "SimpleClickListener";
    private GestureDetectorCompat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RecyclerView f3627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected BaseQuickAdapter f3628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3629d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3630e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f3631f = null;

    private class a implements GestureDetector.OnGestureListener {
        private RecyclerView a;

        /* JADX INFO: renamed from: com.chad.library.adapter.base.listener.SimpleClickListener$a$a, reason: collision with other inner class name */
        class RunnableC0069a implements Runnable {
            final /* synthetic */ View a;

            RunnableC0069a(View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                View view = this.a;
                if (view != null) {
                    view.setPressed(false);
                }
            }
        }

        a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        private void a(View view) {
            if (view != null) {
                view.postDelayed(new RunnableC0069a(view), 50L);
            }
            SimpleClickListener.this.f3629d = false;
            SimpleClickListener.this.f3631f = null;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            SimpleClickListener.this.f3629d = true;
            SimpleClickListener.this.f3631f = this.a.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            boolean z;
            if (this.a.getScrollState() == 0 && SimpleClickListener.this.f3629d && SimpleClickListener.this.f3631f != null) {
                SimpleClickListener.this.f3631f.performHapticFeedback(0);
                BaseViewHolder baseViewHolder = (BaseViewHolder) this.a.getChildViewHolder(SimpleClickListener.this.f3631f);
                if (SimpleClickListener.this.a(baseViewHolder.getLayoutPosition())) {
                    return;
                }
                HashSet<Integer> hashSetD = baseViewHolder.d();
                Set<Integer> setE = baseViewHolder.e();
                if (hashSetD == null || hashSetD.size() <= 0) {
                    z = false;
                } else {
                    for (Integer num : hashSetD) {
                        View viewFindViewById = SimpleClickListener.this.f3631f.findViewById(num.intValue());
                        if (SimpleClickListener.this.a(viewFindViewById, motionEvent) && viewFindViewById.isEnabled()) {
                            if (setE == null || !setE.contains(num)) {
                                SimpleClickListener.this.a(motionEvent, viewFindViewById);
                                SimpleClickListener simpleClickListener = SimpleClickListener.this;
                                simpleClickListener.b(simpleClickListener.f3628c, viewFindViewById, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f3628c.j());
                                viewFindViewById.setPressed(true);
                                SimpleClickListener.this.f3630e = true;
                            }
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    return;
                }
                SimpleClickListener simpleClickListener2 = SimpleClickListener.this;
                simpleClickListener2.d(simpleClickListener2.f3628c, simpleClickListener2.f3631f, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f3628c.j());
                SimpleClickListener simpleClickListener3 = SimpleClickListener.this;
                simpleClickListener3.a(motionEvent, simpleClickListener3.f3631f);
                SimpleClickListener.this.f3631f.setPressed(true);
                if (hashSetD != null) {
                    Iterator<Integer> it = hashSetD.iterator();
                    while (it.hasNext()) {
                        View viewFindViewById2 = SimpleClickListener.this.f3631f.findViewById(it.next().intValue());
                        if (viewFindViewById2 != null) {
                            viewFindViewById2.setPressed(false);
                        }
                    }
                }
                SimpleClickListener.this.f3630e = true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            if (!SimpleClickListener.this.f3629d || SimpleClickListener.this.f3631f == null) {
                return;
            }
            SimpleClickListener.this.f3630e = true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (SimpleClickListener.this.f3629d && SimpleClickListener.this.f3631f != null) {
                if (this.a.getScrollState() != 0) {
                    return false;
                }
                View view = SimpleClickListener.this.f3631f;
                BaseViewHolder baseViewHolder = (BaseViewHolder) this.a.getChildViewHolder(view);
                if (SimpleClickListener.this.a(baseViewHolder.getLayoutPosition())) {
                    return false;
                }
                HashSet<Integer> hashSetB = baseViewHolder.b();
                Set<Integer> setE = baseViewHolder.e();
                if (hashSetB == null || hashSetB.size() <= 0) {
                    SimpleClickListener.this.a(motionEvent, view);
                    SimpleClickListener.this.f3631f.setPressed(true);
                    if (hashSetB != null && hashSetB.size() > 0) {
                        Iterator<Integer> it = hashSetB.iterator();
                        while (it.hasNext()) {
                            View viewFindViewById = view.findViewById(it.next().intValue());
                            if (viewFindViewById != null) {
                                viewFindViewById.setPressed(false);
                            }
                        }
                    }
                    SimpleClickListener simpleClickListener = SimpleClickListener.this;
                    simpleClickListener.c(simpleClickListener.f3628c, view, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f3628c.j());
                } else {
                    for (Integer num : hashSetB) {
                        View viewFindViewById2 = view.findViewById(num.intValue());
                        if (viewFindViewById2 != null) {
                            if (SimpleClickListener.this.a(viewFindViewById2, motionEvent) && viewFindViewById2.isEnabled()) {
                                if (setE != null && setE.contains(num)) {
                                    return false;
                                }
                                SimpleClickListener.this.a(motionEvent, viewFindViewById2);
                                viewFindViewById2.setPressed(true);
                                SimpleClickListener simpleClickListener2 = SimpleClickListener.this;
                                simpleClickListener2.a(simpleClickListener2.f3628c, viewFindViewById2, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f3628c.j());
                                a(viewFindViewById2);
                                return true;
                            }
                            viewFindViewById2.setPressed(false);
                        }
                    }
                    SimpleClickListener.this.a(motionEvent, view);
                    SimpleClickListener.this.f3631f.setPressed(true);
                    Iterator<Integer> it2 = hashSetB.iterator();
                    while (it2.hasNext()) {
                        View viewFindViewById3 = view.findViewById(it2.next().intValue());
                        if (viewFindViewById3 != null) {
                            viewFindViewById3.setPressed(false);
                        }
                    }
                    SimpleClickListener simpleClickListener3 = SimpleClickListener.this;
                    simpleClickListener3.c(simpleClickListener3.f3628c, view, baseViewHolder.getLayoutPosition() - SimpleClickListener.this.f3628c.j());
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
        RecyclerView recyclerView2 = this.f3627b;
        if (recyclerView2 == null || recyclerView2 != recyclerView) {
            this.f3627b = recyclerView;
            this.f3628c = (BaseQuickAdapter) this.f3627b.getAdapter();
            this.a = new GestureDetectorCompat(this.f3627b.getContext(), new a(this.f3627b));
        }
        if (!this.a.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1 && this.f3630e) {
            View view = this.f3631f;
            if (view != null && ((baseViewHolder = (BaseViewHolder) this.f3627b.getChildViewHolder(view)) == null || !b(baseViewHolder.getItemViewType()))) {
                this.f3631f.setPressed(false);
            }
            this.f3630e = false;
            this.f3629d = false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
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
        if (this.f3628c == null) {
            RecyclerView recyclerView = this.f3627b;
            if (recyclerView == null) {
                return false;
            }
            this.f3628c = (BaseQuickAdapter) recyclerView.getAdapter();
        }
        int itemViewType = this.f3628c.getItemViewType(i2);
        return itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546;
    }
}
