package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.C0619R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";

    /* renamed from: UP */
    public static final int f623UP = 1;

    @NonNull
    Callback mCallback;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    RecyclerView mRecyclerView;
    int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List<RecyclerView.ViewHolder> mSwapTargets;
    private float mSwipeEscapeVelocity;
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;
    final List<View> mPendingCleanup = new ArrayList();
    private final float[] mTmpPosition = new float[2];
    RecyclerView.ViewHolder mSelected = null;
    int mActivePointerId = -1;
    private int mActionState = 0;
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    final Runnable mScrollRunnable = new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.1
        @Override // java.lang.Runnable
        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.mSelected == null || !itemTouchHelper.scrollIfNecessary()) {
                return;
            }
            ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper2.mSelected;
            if (viewHolder != null) {
                itemTouchHelper2.moveIfNecessary(viewHolder);
            }
            ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
            itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
            ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
        }
    };
    private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            int findPointerIndex;
            RecoverAnimation findAnimation;
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.mSelected == null && (findAnimation = itemTouchHelper.findAnimation(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.mInitialTouchX -= findAnimation.f624mX;
                    itemTouchHelper2.mInitialTouchY -= findAnimation.f625mY;
                    itemTouchHelper2.endRecoverAnimation(findAnimation.mViewHolder, true);
                    if (ItemTouchHelper.this.mPendingCleanup.remove(findAnimation.mViewHolder.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.mCallback.clearView(itemTouchHelper3.mRecyclerView, findAnimation.mViewHolder);
                    }
                    ItemTouchHelper.this.select(findAnimation.mViewHolder, findAnimation.mActionState);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.updateDxDy(motionEvent, itemTouchHelper4.mSelectedFlags, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.mActivePointerId = -1;
                itemTouchHelper5.select(null, 0);
            } else {
                int i2 = ItemTouchHelper.this.mActivePointerId;
                if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.mSelected != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.select(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
            if (findPointerIndex >= 0) {
                ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            RecyclerView.ViewHolder viewHolder = itemTouchHelper.mSelected;
            if (viewHolder == null) {
                return;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (findPointerIndex >= 0) {
                        itemTouchHelper.updateDxDy(motionEvent, itemTouchHelper.mSelectedFlags, findPointerIndex);
                        ItemTouchHelper.this.moveIfNecessary(viewHolder);
                        ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                        itemTouchHelper2.mRecyclerView.removeCallbacks(itemTouchHelper2.mScrollRunnable);
                        ItemTouchHelper.this.mScrollRunnable.run();
                        ItemTouchHelper.this.mRecyclerView.invalidate();
                        return;
                    }
                    return;
                }
                if (actionMasked != 3) {
                    if (actionMasked != 6) {
                        return;
                    }
                    int actionIndex = motionEvent.getActionIndex();
                    if (motionEvent.getPointerId(actionIndex) == ItemTouchHelper.this.mActivePointerId) {
                        ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.updateDxDy(motionEvent, itemTouchHelper3.mSelectedFlags, actionIndex);
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = itemTouchHelper.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
            ItemTouchHelper.this.select(null, 0);
            ItemTouchHelper.this.mActivePointerId = -1;
        }
    };

    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() { // from class: androidx.recyclerview.widget.ItemTouchHelper.Callback.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
        private int mCachedMaxScrollSpeed = -1;

        public static int convertToRelativeDirection(int i2, int i3) {
            int i4;
            int i5 = i2 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= (-789517) & i7;
                i4 = (i7 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i6 | i4;
        }

        @NonNull
        public static ItemTouchUIUtil getDefaultUIUtil() {
            return ItemTouchUIUtilImpl.INSTANCE;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(C0619R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public static int makeMovementFlags(int i2, int i3) {
            return makeFlag(2, i2) | makeFlag(1, i3) | makeFlag(0, i3 | i2);
        }

        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<RecyclerView.ViewHolder> list, int i2, int i3) {
            int i4;
            int bottom;
            int top;
            int abs;
            int left;
            int abs2;
            int right;
            int width = i2 + viewHolder.itemView.getWidth();
            int height = i3 + viewHolder.itemView.getHeight();
            int left2 = i2 - viewHolder.itemView.getLeft();
            int top2 = i3 - viewHolder.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder2 = null;
            int i5 = -1;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.ViewHolder viewHolder3 = list.get(i6);
                if (left2 <= 0 || (right = viewHolder3.itemView.getRight() - width) >= 0 || viewHolder3.itemView.getRight() <= viewHolder.itemView.getRight() || (i4 = Math.abs(right)) <= i5) {
                    i4 = i5;
                } else {
                    viewHolder2 = viewHolder3;
                }
                if (left2 < 0 && (left = viewHolder3.itemView.getLeft() - i2) > 0 && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs2 = Math.abs(left)) > i4) {
                    i4 = abs2;
                    viewHolder2 = viewHolder3;
                }
                if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i3) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs = Math.abs(top)) > i4) {
                    i4 = abs;
                    viewHolder2 = viewHolder3;
                }
                if (top2 <= 0 || (bottom = viewHolder3.itemView.getBottom() - height) >= 0 || viewHolder3.itemView.getBottom() <= viewHolder.itemView.getBottom() || (i5 = Math.abs(bottom)) <= i4) {
                    i5 = i4;
                } else {
                    viewHolder2 = viewHolder3;
                }
            }
            return viewHolder2;
        }

        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            ItemTouchUIUtilImpl.INSTANCE.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i2, int i3) {
            int i4;
            int i5 = i2 & RELATIVE_DIR_FLAGS;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (~i5);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= (-3158065) & i7;
                i4 = (i7 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i6 | i4;
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public long getAnimationDuration(@NonNull RecyclerView recyclerView, int i2, float f2, float f3) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i2 == 8 ? 200L : 250L : i2 == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f2) {
            return f2;
        }

        public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f2) {
            return f2;
        }

        boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) != 0;
        }

        boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(@NonNull RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            int signum = (int) (((int) (((int) Math.signum(i3)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i3) * 1.0f) / i2)))) * sDragScrollInterpolator.getInterpolation(j2 <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? j2 / 2000.0f : 1.0f));
            return signum == 0 ? i3 > 0 ? 1 : -1 : signum;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            ItemTouchUIUtilImpl.INSTANCE.onDraw(canvas, recyclerView, viewHolder.itemView, f2, f3, i2, z);
        }

        public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
            ItemTouchUIUtilImpl.INSTANCE.onDrawOver(canvas, recyclerView, viewHolder.itemView, f2, f3, i2, z);
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i2, float f2, float f3) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                RecoverAnimation recoverAnimation = list.get(i3);
                recoverAnimation.update();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.f624mX, recoverAnimation.f625mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, int i2, float f2, float f3) {
            int size = list.size();
            boolean z = false;
            for (int i3 = 0; i3 < size; i3++) {
                RecoverAnimation recoverAnimation = list.get(i3);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.f624mX, recoverAnimation.f625mY, recoverAnimation.mActionState, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                RecoverAnimation recoverAnimation2 = list.get(i4);
                if (recoverAnimation2.mEnded && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(i4);
                } else if (!recoverAnimation2.mEnded) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2);

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i2, @NonNull RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i4, i5);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i3);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i3);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i3);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i3);
                }
            }
        }

        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int i2) {
            if (viewHolder != null) {
                ItemTouchUIUtilImpl.INSTANCE.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i2);
    }

    private class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mShouldReactToLongPress = true;

        ItemTouchHelperGestureListener() {
        }

        void doNotReactToLongPress() {
            this.mShouldReactToLongPress = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View findChildView;
            RecyclerView.ViewHolder childViewHolder;
            if (!this.mShouldReactToLongPress || (findChildView = ItemTouchHelper.this.findChildView(motionEvent)) == null || (childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(findChildView)) == null) {
                return;
            }
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, childViewHolder)) {
                int pointerId = motionEvent.getPointerId(0);
                int i2 = ItemTouchHelper.this.mActivePointerId;
                if (pointerId == i2) {
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.mInitialTouchX = x;
                    itemTouchHelper2.mInitialTouchY = y;
                    itemTouchHelper2.mDy = 0.0f;
                    itemTouchHelper2.mDx = 0.0f;
                    if (itemTouchHelper2.mCallback.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.select(childViewHolder, 2);
                    }
                }
            }
        }
    }

    private static class RecoverAnimation implements Animator.AnimatorListener {
        final int mActionState;
        final int mAnimationType;
        private float mFraction;
        boolean mIsPendingCleanup;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        final RecyclerView.ViewHolder mViewHolder;

        /* renamed from: mX */
        float f624mX;

        /* renamed from: mY */
        float f625mY;
        boolean mOverridden = false;
        boolean mEnded = false;
        private final ValueAnimator mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.mActionState = i3;
            this.mAnimationType = i2;
            this.mViewHolder = viewHolder;
            this.mStartDx = f2;
            this.mStartDy = f3;
            this.mTargetX = f4;
            this.mTargetY = f5;
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.recyclerview.widget.ItemTouchHelper.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            this.mValueAnimator.setTarget(viewHolder.itemView);
            this.mValueAnimator.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public void setDuration(long j2) {
            this.mValueAnimator.setDuration(j2);
        }

        public void setFraction(float f2) {
            this.mFraction = f2;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            float f2 = this.mStartDx;
            float f3 = this.mTargetX;
            if (f2 == f3) {
                this.f624mX = this.mViewHolder.itemView.getTranslationX();
            } else {
                this.f624mX = f2 + (this.mFraction * (f3 - f2));
            }
            float f4 = this.mStartDy;
            float f5 = this.mTargetY;
            if (f4 == f5) {
                this.f625mY = this.mViewHolder.itemView.getTranslationY();
            } else {
                this.f625mY = f4 + (this.mFraction * (f5 - f4));
            }
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i2, int i3) {
            this.mDefaultSwipeDirs = i3;
            this.mDefaultDragDirs = i2;
        }

        public int getDragDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i2) {
            this.mDefaultDragDirs = i2;
        }

        public void setDefaultSwipeDirs(int i2) {
            this.mDefaultSwipeDirs = i2;
        }
    }

    public interface ViewDropHandler {
        void prepareForDrop(@NonNull View view, @NonNull View view2, int i2, int i3);
    }

    public ItemTouchHelper(@NonNull Callback callback) {
        this.mCallback = callback;
    }

    private void addChildDrawingOrderCallback() {
        if (Build.VERSION.SDK_INT >= 21) {
            return;
        }
        if (this.mChildDrawingOrderCallback == null) {
            this.mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback() { // from class: androidx.recyclerview.widget.ItemTouchHelper.5
                @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
                public int onGetChildDrawingOrder(int i2, int i3) {
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    View view = itemTouchHelper.mOverdrawChild;
                    if (view == null) {
                        return i3;
                    }
                    int i4 = itemTouchHelper.mOverdrawChildPosition;
                    if (i4 == -1) {
                        i4 = itemTouchHelper.mRecyclerView.indexOfChild(view);
                        ItemTouchHelper.this.mOverdrawChildPosition = i4;
                    }
                    return i3 == i2 + (-1) ? i4 : i3 < i4 ? i3 : i3 + 1;
                }
            };
        }
        this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
    }

    private int checkHorizontalSwipe(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = this.mDx > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            int i4 = xVelocity <= 0.0f ? 4 : 8;
            float abs = Math.abs(xVelocity);
            if ((i4 & i2) != 0 && i3 == i4 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                return i4;
            }
        }
        float width = this.mRecyclerView.getWidth() * this.mCallback.getSwipeThreshold(viewHolder);
        if ((i2 & i3) == 0 || Math.abs(this.mDx) <= width) {
            return 0;
        }
        return i3;
    }

    private int checkVerticalSwipe(RecyclerView.ViewHolder viewHolder, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = this.mDy > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mActivePointerId > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            int i4 = yVelocity <= 0.0f ? 1 : 2;
            float abs = Math.abs(yVelocity);
            if ((i4 & i2) != 0 && i4 == i3 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                return i4;
            }
        }
        float height = this.mRecyclerView.getHeight() * this.mCallback.getSwipeThreshold(viewHolder);
        if ((i2 & i3) == 0 || Math.abs(this.mDy) <= height) {
            return 0;
        }
        return i3;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
        stopGestureDetection();
    }

    private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.mSwapTargets;
        if (list == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            list.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        int i2 = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i2;
        int height = viewHolder2.itemView.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(i3 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i6 = (abs * abs) + (abs2 * abs2);
                    int size = this.mSwapTargets.size();
                    int i7 = 0;
                    for (int i8 = 0; i8 < size && i6 > this.mDistances.get(i8).intValue(); i8++) {
                        i7++;
                    }
                    this.mSwapTargets.add(i7, childViewHolder);
                    this.mDistances.add(i7, Integer.valueOf(i6));
                }
            }
            i5++;
            viewHolder2 = viewHolder;
        }
        return this.mSwapTargets;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent) {
        View findChildView;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i2 = this.mActivePointerId;
        if (i2 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        float x = motionEvent.getX(findPointerIndex) - this.mInitialTouchX;
        float y = motionEvent.getY(findPointerIndex) - this.mInitialTouchY;
        float abs = Math.abs(x);
        float abs2 = Math.abs(y);
        int i3 = this.mSlop;
        if (abs < i3 && abs2 < i3) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (findChildView = findChildView(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(findChildView);
        }
        return null;
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
        } else {
            fArr[0] = this.mSelected.itemView.getTranslationX();
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        } else {
            fArr[1] = this.mSelected.itemView.getTranslationY();
        }
    }

    private static boolean hitTest(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        startGestureDetection();
    }

    private void startGestureDetection() {
        this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
        this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
    }

    private void stopGestureDetection() {
        ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
        if (itemTouchHelperGestureListener != null) {
            itemTouchHelperGestureListener.doNotReactToLongPress();
            this.mItemTouchHelperGestureListener = null;
        }
        if (this.mGestureDetector != null) {
            this.mGestureDetector = null;
        }
    }

    private int swipeIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i2 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            int checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe > 0) {
                return (i2 & checkHorizontalSwipe) == 0 ? Callback.convertToRelativeDirection(checkHorizontalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkHorizontalSwipe;
            }
            int checkVerticalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe > 0) {
                return checkVerticalSwipe;
            }
        } else {
            int checkVerticalSwipe2 = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkVerticalSwipe2 > 0) {
                return checkVerticalSwipe2;
            }
            int checkHorizontalSwipe2 = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe2 > 0) {
                return (i2 & checkHorizontalSwipe2) == 0 ? Callback.convertToRelativeDirection(checkHorizontalSwipe2, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkHorizontalSwipe2;
            }
        }
        return 0;
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
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.mSwipeEscapeVelocity = resources.getDimension(C0619R.dimen.item_touch_helper_swipe_escape_velocity);
            this.mMaxSwipeVelocity = resources.getDimension(C0619R.dimen.item_touch_helper_swipe_escape_max_velocity);
            setupCallbacks();
        }
    }

    void checkSelectForSwipe(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.ViewHolder findSwipedView;
        int absoluteMovementFlags;
        if (this.mSelected != null || i2 != 2 || this.mActionState == 2 || !this.mCallback.isItemViewSwipeEnabled() || this.mRecyclerView.getScrollState() == 1 || (findSwipedView = findSwipedView(motionEvent)) == null || (absoluteMovementFlags = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, findSwipedView) & 65280) >> 8) == 0) {
            return;
        }
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        float f2 = x - this.mInitialTouchX;
        float f3 = y - this.mInitialTouchY;
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        int i4 = this.mSlop;
        if (abs >= i4 || abs2 >= i4) {
            if (abs > abs2) {
                if (f2 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                    return;
                }
                if (f2 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                    return;
                }
            } else {
                if (f3 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                }
                if (f3 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                    return;
                }
            }
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            this.mActivePointerId = motionEvent.getPointerId(0);
            select(findSwipedView, 1);
        }
    }

    void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return;
            }
        }
    }

    RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == findChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    View findChildView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x, y, recoverAnimation.f624mX, recoverAnimation.f625mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.mRecoverAnimations.get(i2).mEnded) {
                return true;
            }
        }
        return false;
    }

    void moveIfNecessary(RecyclerView.ViewHolder viewHolder) {
        if (!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
            int i2 = (int) (this.mSelectedStartX + this.mDx);
            int i3 = (int) (this.mSelectedStartY + this.mDy);
            if (Math.abs(i3 - viewHolder.itemView.getTop()) >= viewHolder.itemView.getHeight() * moveThreshold || Math.abs(i2 - viewHolder.itemView.getLeft()) >= viewHolder.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.ViewHolder> findSwapTargets = findSwapTargets(viewHolder);
                if (findSwapTargets.size() == 0) {
                    return;
                }
                RecyclerView.ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i2, i3);
                if (chooseDropTarget == null) {
                    this.mSwapTargets.clear();
                    this.mDistances.clear();
                    return;
                }
                int adapterPosition = chooseDropTarget.getAdapterPosition();
                int adapterPosition2 = viewHolder.getAdapterPosition();
                if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
                    this.mCallback.onMoved(this.mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i2, i3);
                }
            }
        }
    }

    void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(@NonNull View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null, 0);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, childViewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f2, f3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f2;
        float f3;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f4 = fArr[0];
            f3 = fArr[1];
            f2 = f4;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f2, f3);
    }

    void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i2) {
        this.mRecyclerView.post(new Runnable() { // from class: androidx.recyclerview.widget.ItemTouchHelper.4
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = ItemTouchHelper.this.mRecyclerView;
                if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
                    return;
                }
                RecoverAnimation recoverAnimation2 = recoverAnimation;
                if (recoverAnimation2.mOverridden || recoverAnimation2.mViewHolder.getAdapterPosition() == -1) {
                    return;
                }
                RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                    ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i2);
                } else {
                    ItemTouchHelper.this.mRecyclerView.post(this);
                }
            }
        });
    }

    void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:
    
        if (r1 > 0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean scrollIfNecessary() {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.scrollIfNecessary():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void select(@androidx.annotation.Nullable androidx.recyclerview.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.select(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder) && viewHolder.itemView.getParent() == this.mRecyclerView) {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 2);
        }
    }

    public void startSwipe(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder) && viewHolder.itemView.getParent() == this.mRecyclerView) {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 1);
        }
    }

    void updateDxDy(MotionEvent motionEvent, int i2, int i3) {
        float x = motionEvent.getX(i3);
        float y = motionEvent.getY(i3);
        this.mDx = x - this.mInitialTouchX;
        this.mDy = y - this.mInitialTouchY;
        if ((i2 & 4) == 0) {
            this.mDx = Math.max(0.0f, this.mDx);
        }
        if ((i2 & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i2 & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i2 & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }
}
