package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0471R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class TouchResponse {
    private static final boolean DEBUG = false;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float mLastTouchX;
    private float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private int mTouchAnchorSide = 0;
    private int mTouchSide = 0;
    private int mOnTouchUp = 0;
    private int mTouchAnchorId = -1;
    private int mTouchRegionId = -1;
    private int mLimitBoundsTo = -1;
    private float mTouchAnchorY = 0.5f;
    private float mTouchAnchorX = 0.5f;
    private float mTouchDirectionX = 0.0f;
    private float mTouchDirectionY = 1.0f;
    private boolean mDragStarted = false;
    private float[] mAnchorDpDt = new float[2];
    private float mMaxVelocity = 4.0f;
    private float mMaxAcceleration = 1.2f;
    private boolean mMoveWhenScrollAtTop = true;
    private float mDragScale = 1.0f;
    private int mFlags = 0;
    private float mDragThreshold = 10.0f;

    TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index == C0471R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == C0471R.styleable.OnSwipe_touchAnchorSide) {
                this.mTouchAnchorSide = typedArray.getInt(index, this.mTouchAnchorSide);
                float[][] fArr = TOUCH_SIDES;
                int i3 = this.mTouchAnchorSide;
                this.mTouchAnchorX = fArr[i3][0];
                this.mTouchAnchorY = fArr[i3][1];
            } else if (index == C0471R.styleable.OnSwipe_dragDirection) {
                this.mTouchSide = typedArray.getInt(index, this.mTouchSide);
                float[][] fArr2 = TOUCH_DIRECTION;
                int i4 = this.mTouchSide;
                this.mTouchDirectionX = fArr2[i4][0];
                this.mTouchDirectionY = fArr2[i4][1];
            } else if (index == C0471R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == C0471R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == C0471R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == C0471R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == C0471R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == C0471R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == C0471R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == C0471R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == C0471R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            }
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0471R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    float dot(float f2, float f3) {
        return (f2 * this.mTouchDirectionX) + (f3 * this.mTouchDirectionY);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.mLimitBoundsTo;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    float getProgressDirection(float f2, float f3) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if (this.mTouchDirectionX != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f2 * this.mTouchDirectionX) / this.mAnchorDpDt[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f3 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
    }

    RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.mTouchRegionId;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i2, MotionScene motionScene) {
        int i3;
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            this.mDragStarted = false;
            return;
        }
        if (action == 1) {
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(1000);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress = this.mMotionLayout.getProgress();
            int i4 = this.mTouchAnchorId;
            if (i4 != -1) {
                this.mMotionLayout.getAnchorDpDt(i4, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr = this.mAnchorDpDt;
                fArr[1] = this.mTouchDirectionY * min;
                fArr[0] = min * this.mTouchDirectionX;
            }
            float f2 = this.mTouchDirectionX;
            float[] fArr2 = this.mAnchorDpDt;
            float f3 = fArr2[0];
            float f4 = fArr2[1];
            float f5 = f2 != 0.0f ? xVelocity / fArr2[0] : yVelocity / fArr2[1];
            float f6 = !Float.isNaN(f5) ? (f5 / 3.0f) + progress : progress;
            if (f6 == 0.0f || f6 == 1.0f || (i3 = this.mOnTouchUp) == 3) {
                if (0.0f >= f6 || 1.0f <= f6) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            this.mMotionLayout.touchAnimateTo(i3, ((double) f6) < 0.5d ? 0.0f : 1.0f, f5);
            if (0.0f >= progress || 1.0f <= progress) {
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = motionEvent.getRawY() - this.mLastTouchY;
        float rawX = motionEvent.getRawX() - this.mLastTouchX;
        if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
            float progress2 = this.mMotionLayout.getProgress();
            if (!this.mDragStarted) {
                this.mDragStarted = true;
                this.mMotionLayout.setProgress(progress2);
            }
            int i5 = this.mTouchAnchorId;
            if (i5 != -1) {
                this.mMotionLayout.getAnchorDpDt(i5, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr3 = this.mAnchorDpDt;
                fArr3[1] = this.mTouchDirectionY * min2;
                fArr3[0] = min2 * this.mTouchDirectionX;
            }
            float f7 = this.mTouchDirectionX;
            float[] fArr4 = this.mAnchorDpDt;
            if (Math.abs(((f7 * fArr4[0]) + (this.mTouchDirectionY * fArr4[1])) * this.mDragScale) < 0.01d) {
                float[] fArr5 = this.mAnchorDpDt;
                fArr5[0] = 0.01f;
                fArr5[1] = 0.01f;
            }
            float max = Math.max(Math.min(progress2 + (this.mTouchDirectionX != 0.0f ? rawX / this.mAnchorDpDt[0] : rawY / this.mAnchorDpDt[1]), 1.0f), 0.0f);
            if (max != this.mMotionLayout.getProgress()) {
                this.mMotionLayout.setProgress(max);
                motionTracker.computeCurrentVelocity(1000);
                this.mMotionLayout.mLastVelocity = this.mTouchDirectionX != 0.0f ? motionTracker.getXVelocity() / this.mAnchorDpDt[0] : motionTracker.getYVelocity() / this.mAnchorDpDt[1];
            } else {
                this.mMotionLayout.mLastVelocity = 0.0f;
            }
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
        }
    }

    void scrollMove(float f2, float f3) {
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f4 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (Math.abs((f4 * fArr[0]) + (this.mTouchDirectionY * fArr[1])) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f5 = this.mTouchDirectionX;
        float max = Math.max(Math.min(progress + (f5 != 0.0f ? (f2 * f5) / this.mAnchorDpDt[0] : (f3 * this.mTouchDirectionY) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    void scrollUp(float f2, float f3) {
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f4 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f5 = fArr[0];
        float f6 = this.mTouchDirectionY;
        float f7 = fArr[1];
        float f8 = f4 != 0.0f ? (f2 * f4) / fArr[0] : (f3 * f6) / fArr[1];
        if (!Float.isNaN(f8)) {
            progress += f8 / 3.0f;
        }
        if (progress != 0.0f) {
            if ((this.mOnTouchUp != 3) && (progress != 1.0f)) {
                this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, ((double) progress) < 0.5d ? 0.0f : 1.0f, f8);
            }
        }
    }

    public void setAnchorId(int i2) {
        this.mTouchAnchorId = i2;
    }

    void setDown(float f2, float f3) {
        this.mLastTouchX = f2;
        this.mLastTouchY = f3;
    }

    public void setMaxAcceleration(float f2) {
        this.mMaxAcceleration = f2;
    }

    public void setMaxVelocity(float f2) {
        this.mMaxVelocity = f2;
    }

    public void setRTL(boolean z) {
        if (z) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = TOUCH_SIDES;
        int i2 = this.mTouchAnchorSide;
        this.mTouchAnchorX = fArr5[i2][0];
        this.mTouchAnchorY = fArr5[i2][1];
        float[][] fArr6 = TOUCH_DIRECTION;
        int i3 = this.mTouchSide;
        this.mTouchDirectionX = fArr6[i3][0];
        this.mTouchDirectionY = fArr6[i3][1];
    }

    public void setTouchAnchorLocation(float f2, float f3) {
        this.mTouchAnchorX = f2;
        this.mTouchAnchorY = f3;
    }

    void setUpTouchEvent(float f2, float f3) {
        this.mLastTouchX = f2;
        this.mLastTouchY = f3;
        this.mDragStarted = false;
    }

    void setupTouch() {
        View view;
        int i2 = this.mTouchAnchorId;
        if (i2 != -1) {
            view = this.mMotionLayout.findViewById(i2);
            if (view == null) {
                String str = "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId);
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView2, int i3, int i4, int i5, int i6) {
                }
            });
        }
    }

    public String toString() {
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }
}
