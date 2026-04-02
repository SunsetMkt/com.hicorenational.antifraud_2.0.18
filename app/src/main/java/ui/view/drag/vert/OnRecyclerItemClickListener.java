package ui.view.drag.vert;

import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import util.g1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RecyclerView f14716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DisplayMetrics f14717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14718d = false;

    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (motionEvent.getX() < OnRecyclerItemClickListener.this.f14717c.widthPixels - g1.a(OnRecyclerItemClickListener.this.f14716b.getContext(), 80.0f)) {
                return true;
            }
            View viewFindChildViewUnder = OnRecyclerItemClickListener.this.f14716b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder != null) {
                OnRecyclerItemClickListener.this.b(OnRecyclerItemClickListener.this.f14716b.getChildViewHolder(viewFindChildViewUnder));
                OnRecyclerItemClickListener.this.f14718d = true;
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (OnRecyclerItemClickListener.this.f14718d) {
                OnRecyclerItemClickListener.this.a();
                OnRecyclerItemClickListener.this.f14718d = false;
            }
            return super.onScroll(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View viewFindChildViewUnder = OnRecyclerItemClickListener.this.f14716b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder == null) {
                return true;
            }
            OnRecyclerItemClickListener.this.a(OnRecyclerItemClickListener.this.f14716b.getChildViewHolder(viewFindChildViewUnder));
            return true;
        }
    }

    public OnRecyclerItemClickListener(RecyclerView recyclerView) {
        this.f14716b = recyclerView;
        this.f14717c = recyclerView.getContext().getResources().getDisplayMetrics();
        this.a = new GestureDetectorCompat(recyclerView.getContext(), new b());
    }

    public abstract void a();

    public abstract void a(RecyclerView.ViewHolder viewHolder);

    public abstract void b(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.a.onTouchEvent(motionEvent);
    }
}
