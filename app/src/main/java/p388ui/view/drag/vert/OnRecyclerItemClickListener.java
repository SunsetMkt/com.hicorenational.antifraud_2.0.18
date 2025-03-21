package p388ui.view.drag.vert;

import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import util.C7264c1;

/* loaded from: classes2.dex */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a */
    private GestureDetectorCompat f24855a;

    /* renamed from: b */
    private RecyclerView f24856b;

    /* renamed from: c */
    private DisplayMetrics f24857c;

    /* renamed from: d */
    private boolean f24858d = false;

    /* renamed from: ui.view.drag.vert.OnRecyclerItemClickListener$b */
    private class C7219b extends GestureDetector.SimpleOnGestureListener {
        private C7219b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (motionEvent.getX() < OnRecyclerItemClickListener.this.f24857c.widthPixels - C7264c1.m26285a(OnRecyclerItemClickListener.this.f24856b.getContext(), 80.0f)) {
                return true;
            }
            View findChildViewUnder = OnRecyclerItemClickListener.this.f24856b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder != null) {
                OnRecyclerItemClickListener.this.m25964b(OnRecyclerItemClickListener.this.f24856b.getChildViewHolder(findChildViewUnder));
                OnRecyclerItemClickListener.this.f24858d = true;
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (OnRecyclerItemClickListener.this.f24858d) {
                OnRecyclerItemClickListener.this.m25962a();
                OnRecyclerItemClickListener.this.f24858d = false;
            }
            return super.onScroll(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View findChildViewUnder = OnRecyclerItemClickListener.this.f24856b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder == null) {
                return true;
            }
            OnRecyclerItemClickListener.this.m25963a(OnRecyclerItemClickListener.this.f24856b.getChildViewHolder(findChildViewUnder));
            return true;
        }
    }

    public OnRecyclerItemClickListener(RecyclerView recyclerView) {
        this.f24856b = recyclerView;
        this.f24857c = recyclerView.getContext().getResources().getDisplayMetrics();
        this.f24855a = new GestureDetectorCompat(recyclerView.getContext(), new C7219b());
    }

    /* renamed from: a */
    public abstract void m25962a();

    /* renamed from: a */
    public abstract void m25963a(RecyclerView.ViewHolder viewHolder);

    /* renamed from: b */
    public abstract void m25964b(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f24855a.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f24855a.onTouchEvent(motionEvent);
    }
}
