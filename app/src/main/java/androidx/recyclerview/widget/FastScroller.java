package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

@VisibleForTesting
/* loaded from: classes.dex */
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;

    @VisibleForTesting
    float mHorizontalDragX;

    @VisibleForTesting
    int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;

    @VisibleForTesting
    int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private RecyclerView mRecyclerView;
    private final int mScrollbarMinimumRange;

    @VisibleForTesting
    float mVerticalDragY;

    @VisibleForTesting
    int mVerticalThumbCenterY;
    final StateListDrawable mVerticalThumbDrawable;

    @VisibleForTesting
    int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;
    private static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    private static final int[] EMPTY_STATE_SET = new int[0];
    private int mRecyclerViewWidth = 0;
    private int mRecyclerViewHeight = 0;
    private boolean mNeedVerticalScrollbar = false;
    private boolean mNeedHorizontalScrollbar = false;
    private int mState = 0;
    private int mDragState = 0;
    private final int[] mVerticalRange = new int[2];
    private final int[] mHorizontalRange = new int[2];
    final ValueAnimator mShowHideAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
    int mAnimationState = 0;
    private final Runnable mHideRunnable = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.hide(500);
        }
    };
    private final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            FastScroller.this.updateScrollPosition(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    private class AnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;

        AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
                return;
            }
            if (((Float) FastScroller.this.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.mAnimationState = 2;
                fastScroller2.requestRedraw();
            }
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.mVerticalThumbDrawable.setAlpha(floatValue);
            FastScroller.this.mVerticalTrackDrawable.setAlpha(floatValue);
            FastScroller.this.requestRedraw();
        }
    }

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i2, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i2, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i3;
        this.mMargin = i4;
        this.mVerticalThumbDrawable.setAlpha(255);
        this.mVerticalTrackDrawable.setAlpha(255);
        this.mShowHideAnimator.addListener(new AnimatorListener());
        this.mShowHideAnimator.addUpdateListener(new AnimatorUpdater());
        attachToRecyclerView(recyclerView);
    }

    private void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
        cancelHide();
    }

    private void drawHorizontalScrollbar(Canvas canvas) {
        int i2 = this.mRecyclerViewHeight;
        int i3 = this.mHorizontalThumbHeight;
        int i4 = this.mHorizontalThumbCenterX;
        int i5 = this.mHorizontalThumbWidth;
        this.mHorizontalThumbDrawable.setBounds(0, 0, i5, i3);
        this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
        canvas.translate(0.0f, i2 - i3);
        this.mHorizontalTrackDrawable.draw(canvas);
        canvas.translate(i4 - (i5 / 2), 0.0f);
        this.mHorizontalThumbDrawable.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void drawVerticalScrollbar(Canvas canvas) {
        int i2 = this.mRecyclerViewWidth;
        int i3 = this.mVerticalThumbWidth;
        int i4 = i2 - i3;
        int i5 = this.mVerticalThumbCenterY;
        int i6 = this.mVerticalThumbHeight;
        int i7 = i5 - (i6 / 2);
        this.mVerticalThumbDrawable.setBounds(0, 0, i3, i6);
        this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
        if (!isLayoutRTL()) {
            canvas.translate(i4, 0.0f);
            this.mVerticalTrackDrawable.draw(canvas);
            canvas.translate(0.0f, i7);
            this.mVerticalThumbDrawable.draw(canvas);
            canvas.translate(-i4, -i7);
            return;
        }
        this.mVerticalTrackDrawable.draw(canvas);
        canvas.translate(this.mVerticalThumbWidth, i7);
        canvas.scale(-1.0f, 1.0f);
        this.mVerticalThumbDrawable.draw(canvas);
        canvas.scale(1.0f, 1.0f);
        canvas.translate(-this.mVerticalThumbWidth, -i7);
    }

    private int[] getHorizontalRange() {
        int[] iArr = this.mHorizontalRange;
        int i2 = this.mMargin;
        iArr[0] = i2;
        iArr[1] = this.mRecyclerViewWidth - i2;
        return iArr;
    }

    private int[] getVerticalRange() {
        int[] iArr = this.mVerticalRange;
        int i2 = this.mMargin;
        iArr[0] = i2;
        iArr[1] = this.mRecyclerViewHeight - i2;
        return iArr;
    }

    private void horizontalScrollTo(float f2) {
        int[] horizontalRange = getHorizontalRange();
        float max = Math.max(horizontalRange[0], Math.min(horizontalRange[1], f2));
        if (Math.abs(this.mHorizontalThumbCenterX - max) < 2.0f) {
            return;
        }
        int scrollTo = scrollTo(this.mHorizontalDragX, max, horizontalRange, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
        if (scrollTo != 0) {
            this.mRecyclerView.scrollBy(scrollTo, 0);
        }
        this.mHorizontalDragX = max;
    }

    private boolean isLayoutRTL() {
        return ViewCompat.getLayoutDirection(this.mRecyclerView) == 1;
    }

    private void resetHideDelay(int i2) {
        cancelHide();
        this.mRecyclerView.postDelayed(this.mHideRunnable, i2);
    }

    private int scrollTo(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / i5) * i6);
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
    }

    private void verticalScrollTo(float f2) {
        int[] verticalRange = getVerticalRange();
        float max = Math.max(verticalRange[0], Math.min(verticalRange[1], f2));
        if (Math.abs(this.mVerticalThumbCenterY - max) < 2.0f) {
            return;
        }
        int scrollTo = scrollTo(this.mVerticalDragY, max, verticalRange, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
        if (scrollTo != 0) {
            this.mRecyclerView.scrollBy(0, scrollTo);
        }
        this.mVerticalDragY = max;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (this.mRecyclerView != null) {
            setupCallbacks();
        }
    }

    @VisibleForTesting
    Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    @VisibleForTesting
    Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    @VisibleForTesting
    Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    @VisibleForTesting
    Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    public void hide() {
        hide(0);
    }

    public boolean isDragging() {
        return this.mState == 2;
    }

    @VisibleForTesting
    boolean isHidden() {
        return this.mState == 0;
    }

    @VisibleForTesting
    boolean isPointInsideHorizontalThumb(float f2, float f3) {
        if (f3 >= this.mRecyclerViewHeight - this.mHorizontalThumbHeight) {
            int i2 = this.mHorizontalThumbCenterX;
            int i3 = this.mHorizontalThumbWidth;
            if (f2 >= i2 - (i3 / 2) && f2 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    boolean isPointInsideVerticalThumb(float f2, float f3) {
        if (!isLayoutRTL() ? f2 >= this.mRecyclerViewWidth - this.mVerticalThumbWidth : f2 <= this.mVerticalThumbWidth / 2) {
            int i2 = this.mVerticalThumbCenterY;
            int i3 = this.mVerticalThumbHeight;
            if (f3 >= i2 - (i3 / 2) && f3 <= i2 + (i3 / 2)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    boolean isVisible() {
        return this.mState == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mRecyclerViewWidth != this.mRecyclerView.getWidth() || this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) {
            this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
            this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
            setState(0);
        } else if (this.mAnimationState != 0) {
            if (this.mNeedVerticalScrollbar) {
                drawVerticalScrollbar(canvas);
            }
            if (this.mNeedHorizontalScrollbar) {
                drawHorizontalScrollbar(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i2 = this.mState;
        if (i2 == 1) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!isPointInsideVerticalThumb && !isPointInsideHorizontalThumb) {
                return false;
            }
            if (isPointInsideHorizontalThumb) {
                this.mDragState = 1;
                this.mHorizontalDragX = (int) motionEvent.getX();
            } else if (isPointInsideVerticalThumb) {
                this.mDragState = 2;
                this.mVerticalDragY = (int) motionEvent.getY();
            }
            setState(2);
        } else if (i2 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.mState == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (isPointInsideVerticalThumb || isPointInsideHorizontalThumb) {
                if (isPointInsideHorizontalThumb) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = (int) motionEvent.getX();
                } else if (isPointInsideVerticalThumb) {
                    this.mDragState = 2;
                    this.mVerticalDragY = (int) motionEvent.getY();
                }
                setState(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.mState == 2) {
            this.mVerticalDragY = 0.0f;
            this.mHorizontalDragX = 0.0f;
            setState(1);
            this.mDragState = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.mState == 2) {
            show();
            if (this.mDragState == 1) {
                horizontalScrollTo(motionEvent.getX());
            }
            if (this.mDragState == 2) {
                verticalScrollTo(motionEvent.getY());
            }
        }
    }

    void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    void setState(int i2) {
        if (i2 == 2 && this.mState != 2) {
            this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
            cancelHide();
        }
        if (i2 == 0) {
            requestRedraw();
        } else {
            show();
        }
        if (this.mState == 2 && i2 != 2) {
            this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
            resetHideDelay(HIDE_DELAY_AFTER_DRAGGING_MS);
        } else if (i2 == 1) {
            resetHideDelay(HIDE_DELAY_AFTER_VISIBLE_MS);
        }
        this.mState = i2;
    }

    public void show() {
        int i2 = this.mAnimationState;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                this.mShowHideAnimator.cancel();
            }
        }
        this.mAnimationState = 1;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.mShowHideAnimator.setDuration(500L);
        this.mShowHideAnimator.setStartDelay(0L);
        this.mShowHideAnimator.start();
    }

    void updateScrollPosition(int i2, int i3) {
        int computeVerticalScrollRange = this.mRecyclerView.computeVerticalScrollRange();
        int i4 = this.mRecyclerViewHeight;
        this.mNeedVerticalScrollbar = computeVerticalScrollRange - i4 > 0 && i4 >= this.mScrollbarMinimumRange;
        int computeHorizontalScrollRange = this.mRecyclerView.computeHorizontalScrollRange();
        int i5 = this.mRecyclerViewWidth;
        this.mNeedHorizontalScrollbar = computeHorizontalScrollRange - i5 > 0 && i5 >= this.mScrollbarMinimumRange;
        if (!this.mNeedVerticalScrollbar && !this.mNeedHorizontalScrollbar) {
            if (this.mState != 0) {
                setState(0);
                return;
            }
            return;
        }
        if (this.mNeedVerticalScrollbar) {
            float f2 = i4;
            this.mVerticalThumbCenterY = (int) ((f2 * (i3 + (f2 / 2.0f))) / computeVerticalScrollRange);
            this.mVerticalThumbHeight = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
        }
        if (this.mNeedHorizontalScrollbar) {
            float f3 = i5;
            this.mHorizontalThumbCenterX = (int) ((f3 * (i2 + (f3 / 2.0f))) / computeHorizontalScrollRange);
            this.mHorizontalThumbWidth = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
        }
        int i6 = this.mState;
        if (i6 == 0 || i6 == 1) {
            setState(1);
        }
    }

    @VisibleForTesting
    void hide(int i2) {
        int i3 = this.mAnimationState;
        if (i3 == 1) {
            this.mShowHideAnimator.cancel();
        } else if (i3 != 2) {
            return;
        }
        this.mAnimationState = 3;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.mShowHideAnimator.setDuration(i2);
        this.mShowHideAnimator.start();
    }
}
