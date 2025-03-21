package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0471R;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout.MotionTracker mVelocityTracker;
    StateSet mStateSet = null;
    Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private Transition mDefaultTransition = null;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean DEBUG_DESKTOP = false;
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private int getId(Context context, String str) {
        int i2;
        if (str.contains("/")) {
            i2 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + i2);
            }
        } else {
            i2 = -1;
        }
        return (i2 != -1 || str == null || str.length() <= 1) ? i2 : Integer.parseInt(str.substring(1));
    }

    private int getIndex(Transition transition) {
        int i2 = transition.mId;
        if (i2 == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i3 = 0; i3 < this.mTransitionList.size(); i3++) {
            if (this.mTransitionList.get(i3).mId == i2) {
                return i3;
            }
        }
        return -1;
    }

    private int getRealID(int i2) {
        int stateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        return (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i2, -1, -1)) == -1) ? i2 : stateGetConstraintID;
    }

    private boolean hasCycleDependency(int i2) {
        int i3 = this.mDeriveMap.get(i2);
        int size = this.mDeriveMap.size();
        while (i3 > 0) {
            if (i3 == i2) {
                return true;
            }
            int i4 = size - 1;
            if (size < 0) {
                return true;
            }
            i3 = this.mDeriveMap.get(i3);
            size = i4;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    private void load(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        Transition transition = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c2 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.DEBUG_DESKTOP) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 793277014:
                            if (name.equals(TAG)) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            parseMotionSceneTags(context, xml);
                            break;
                        case 1:
                            ArrayList<Transition> arrayList = this.mTransitionList;
                            Transition transition2 = new Transition(this, context, xml);
                            arrayList.add(transition2);
                            if (this.mCurrentTransition == null && !transition2.mIsAbstract) {
                                this.mCurrentTransition = transition2;
                                if (this.mCurrentTransition != null && this.mCurrentTransition.mTouchResponse != null) {
                                    this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                                }
                            }
                            if (transition2.mIsAbstract) {
                                if (transition2.mConstraintSetEnd == -1) {
                                    this.mDefaultTransition = transition2;
                                } else {
                                    this.mAbstractTransitionList.add(transition2);
                                }
                                this.mTransitionList.remove(transition2);
                            }
                            transition = transition2;
                            break;
                        case 2:
                            if (transition == null) {
                                String str = " OnSwipe (" + context.getResources().getResourceEntryName(i2) + ".xml:" + xml.getLineNumber() + ")";
                            }
                            transition.mTouchResponse = new TouchResponse(context, this.mMotionLayout, xml);
                            break;
                        case 3:
                            transition.addOnClick(context, xml);
                            break;
                        case 4:
                            this.mStateSet = new StateSet(context, xml);
                            break;
                        case 5:
                            parseConstraintSet(context, xml);
                            break;
                        case 6:
                            transition.mKeyFramesList.add(new KeyFrames(context, xml));
                            break;
                        default:
                            String str2 = "WARNING UNKNOWN ATTRIBUTE " + name;
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        char c2;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < attributeCount; i4++) {
            String attributeName = xmlPullParser.getAttributeName(i4);
            String attributeValue = xmlPullParser.getAttributeValue(i4);
            if (this.DEBUG_DESKTOP) {
                System.out.println("id string = " + attributeValue);
            }
            int hashCode = attributeName.hashCode();
            if (hashCode != -1496482599) {
                if (hashCode == 3355 && attributeName.equals("id")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (attributeName.equals("deriveConstraintsFrom")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                i2 = getId(context, attributeValue);
                this.mConstraintSetIdMap.put(stripID(attributeValue), Integer.valueOf(i2));
            } else if (c2 == 1) {
                i3 = getId(context, attributeValue);
            }
        }
        if (i2 != -1) {
            if (this.mMotionLayout.mDebugPath != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (i3 != -1) {
                this.mDeriveMap.put(i2, i3);
            }
            this.mConstraintSetMap.put(i2, constraintSet);
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0471R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == C0471R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = obtainStyledAttributes.getInt(index, this.mDefaultDuration);
            } else if (index == C0471R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i2) {
        int i3 = this.mDeriveMap.get(i2);
        if (i3 > 0) {
            readConstraintChain(this.mDeriveMap.get(i2));
            ConstraintSet constraintSet = this.mConstraintSetMap.get(i2);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i3);
            if (constraintSet2 != null) {
                constraintSet.readFallback(constraintSet2);
                this.mDeriveMap.put(i2, -1);
            } else {
                String str = "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), i3);
            }
        }
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i2) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mOnClicks.size() > 0) {
                Iterator it2 = next.mOnClicks.iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.mAbstractTransitionList.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (next2.mOnClicks.size() > 0) {
                Iterator it4 = next2.mOnClicks.iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.mTransitionList.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (next3.mOnClicks.size() > 0) {
                Iterator it6 = next3.mOnClicks.iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i2, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.mAbstractTransitionList.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (next4.mOnClicks.size() > 0) {
                Iterator it8 = next4.mOnClicks.iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i2, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    boolean autoTransition(MotionLayout motionLayout, int i2) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mAutoTransition != 0 && this.mCurrentTransition != next) {
                if (i2 == next.mConstraintSetStart && (next.mAutoTransition == 4 || next.mAutoTransition == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i2 == next.mConstraintSetEnd && (next.mAutoTransition == 3 || next.mAutoTransition == 1)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i2, float f2, float f3, MotionEvent motionEvent) {
        if (i2 == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i2);
        float f4 = 0.0f;
        Transition transition = null;
        RectF rectF = new RectF();
        for (Transition transition2 : transitionsWithState) {
            if (!transition2.mDisable && transition2.mTouchResponse != null) {
                transition2.mTouchResponse.setRTL(this.mRtl);
                RectF touchRegion = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF touchRegion2 = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 == null || motionEvent == null || touchRegion2.contains(motionEvent.getX(), motionEvent.getY())) {
                        float dot = transition2.mTouchResponse.dot(f2, f3) * (transition2.mConstraintSetEnd == i2 ? -1.0f : 1.1f);
                        if (dot > f4) {
                            transition = transition2;
                            f4 = dot;
                        }
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z) {
        this.mDisableAutoTransition = z;
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + str);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            int keyAt = this.mConstraintSetMap.keyAt(i2);
            String resourceName = context.getResources().getResourceName(keyAt);
            if (this.DEBUG_DESKTOP) {
                System.out.println("Id for <" + i2 + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(keyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int[] iArr = new int[this.mConstraintSetMap.size()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = this.mConstraintSetMap.keyAt(i2);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        return transition != null ? transition.mDuration : this.mDefaultDuration;
    }

    int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Interpolator getInterpolator() {
        switch (this.mCurrentTransition.mDefaultInterpolator) {
            case -2:
                return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
            case -1:
                final Easing interpolator = Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString);
                return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f2) {
                        return (float) interpolator.get(f2);
                    }
                };
            case 0:
                return new AccelerateDecelerateInterpolator();
            case 1:
                return new AccelerateInterpolator();
            case 2:
                return new DecelerateInterpolator();
            case 3:
                return null;
            case 4:
                return new AnticipateInterpolator();
            case 5:
                return new BounceInterpolator();
            default:
                return null;
        }
    }

    Key getKeyFrame(Context context, int i2, int i3, int i4) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            for (Integer num : keyFrames.getKeys()) {
                if (i3 == num.intValue()) {
                    Iterator<Key> it2 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                    while (it2.hasNext()) {
                        Key next = it2.next();
                        if (next.mFramePosition == i4 && next.mType == i2) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            Iterator it = transition.mKeyFramesList.iterator();
            while (it.hasNext()) {
                ((KeyFrames) it.next()).addFrames(motionController);
            }
        } else {
            Transition transition2 = this.mDefaultTransition;
            if (transition2 != null) {
                Iterator it2 = transition2.mKeyFramesList.iterator();
                while (it2.hasNext()) {
                    ((KeyFrames) it2.next()).addFrames(motionController);
                }
            }
        }
    }

    float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
    }

    float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
    }

    boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i2) {
        return 0.0f;
    }

    float getProgressDirection(float f2, float f3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getProgressDirection(f2, f3);
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public Transition getTransitionById(int i2) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mId == i2) {
                return next;
            }
        }
        return null;
    }

    int getTransitionDirection(int i2) {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mConstraintSetStart == i2) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i2) {
        int realID = getRealID(i2);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.mConstraintSetStart == realID || next.mConstraintSetEnd == realID) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    boolean hasKeyFramePosition(View view, int i2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public int lookUpConstraintId(String str) {
        return this.mConstraintSetIdMap.get(str).intValue();
    }

    public String lookUpConstraintName(int i2) {
        for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    void processScrollMove(float f2, float f3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollMove(f2, f3);
    }

    void processScrollUp(float f2, float f3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollUp(f2, f3);
    }

    void processTouchEvent(MotionEvent motionEvent, int i2, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i2 != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mMotionOutsideRegion = false;
                    } else {
                        this.mMotionOutsideRegion = true;
                    }
                    this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                    return;
                }
                return;
            }
            if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                    return;
                }
                Transition bestTransitionFor = bestTransitionFor(i2, rawX, rawY, motionEvent2);
                if (bestTransitionFor != null) {
                    motionLayout.setTransition(bestTransitionFor);
                    RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        z = true;
                    }
                    this.mMotionOutsideRegion = z;
                    this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                }
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null && !this.mMotionOutsideRegion) {
            this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i2, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionTracker = this.mVelocityTracker) == null) {
            return;
        }
        motionTracker.recycle();
        this.mVelocityTracker = null;
        int i3 = motionLayout.mCurrentState;
        if (i3 != -1) {
            autoTransition(motionLayout, i3);
        }
    }

    void readFallback(MotionLayout motionLayout) {
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            int keyAt = this.mConstraintSetMap.keyAt(i2);
            if (hasCycleDependency(keyAt)) {
                return;
            }
            readConstraintChain(keyAt);
        }
        for (int i3 = 0; i3 < this.mConstraintSetMap.size(); i3++) {
            this.mConstraintSetMap.valueAt(i3).readFallback(motionLayout);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i2, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i2, constraintSet);
    }

    public void setDuration(int i2) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i2);
        } else {
            this.mDefaultDuration = i2;
        }
    }

    public void setKeyframe(View view, int i2, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return;
        }
        Iterator it = transition.mKeyFramesList.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i2) {
                    int i3 = ((obj != null ? ((Float) obj).floatValue() : 0.0f) > 0.0f ? 1 : ((obj != null ? ((Float) obj).floatValue() : 0.0f) == 0.0f ? 0 : -1));
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z) {
        this.mRtl = z;
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setTransition(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.StateSet r0 = r6.mStateSet
            r1 = -1
            if (r0 == 0) goto L16
            int r0 = r0.stateGetConstraintID(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            androidx.constraintlayout.widget.StateSet r2 = r6.mStateSet
            int r2 = r2.stateGetConstraintID(r8, r1, r1)
            if (r2 == r1) goto L17
            goto L18
        L16:
            r0 = r7
        L17:
            r2 = r8
        L18:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mTransitionList
            java.util.Iterator r3 = r3.iterator()
        L1e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L5a
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r4)
            if (r5 != r2) goto L36
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r4)
            if (r5 == r0) goto L42
        L36:
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r4)
            if (r5 != r8) goto L1e
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r4)
            if (r5 != r7) goto L1e
        L42:
            r6.mCurrentTransition = r4
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mCurrentTransition
            if (r7 == 0) goto L59
            androidx.constraintlayout.motion.widget.TouchResponse r7 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$200(r7)
            if (r7 == 0) goto L59
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r7 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$200(r7)
            boolean r8 = r6.mRtl
            r7.setRTL(r8)
        L59:
            return
        L5a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = r6.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r6.mAbstractTransitionList
            java.util.Iterator r3 = r3.iterator()
        L62:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L76
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.MotionScene$Transition r4 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r4
            int r5 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r4)
            if (r5 != r8) goto L62
            r7 = r4
            goto L62
        L76:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r8 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.access$102(r8, r0)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.access$002(r8, r2)
            if (r0 == r1) goto L88
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r7 = r6.mTransitionList
            r7.add(r8)
        L88:
            r6.mCurrentTransition = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setupTouch();
    }

    boolean supportTouch() {
        Iterator<Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (it.next().mTouchResponse != null) {
                return true;
            }
        }
        Transition transition = this.mCurrentTransition;
        return (transition == null || transition.mTouchResponse == null) ? false : true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.mScene == this;
    }

    ConstraintSet getConstraintSet(int i2) {
        return getConstraintSet(i2, -1, -1);
    }

    ConstraintSet getConstraintSet(int i2, int i3, int i4) {
        int stateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + i2);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        StateSet stateSet = this.mStateSet;
        if (stateSet != null && (stateGetConstraintID = stateSet.stateGetConstraintID(i2, i3, i4)) != -1) {
            i2 = stateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i2) == null) {
            String str = "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), i2) + " In MotionScene";
            SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.mConstraintSetMap.get(i2);
    }

    MotionScene(Context context, MotionLayout motionLayout, int i2) {
        this.mMotionLayout = motionLayout;
        load(context, i2);
        this.mConstraintSetMap.put(C0471R.id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(C0471R.id.motion_base));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        Transition transition2 = this.mCurrentTransition;
        if (transition2 == null || transition2.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), C0471R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == C0471R.styleable.OnClick_targetId) {
                        this.mTargetId = obtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == C0471R.styleable.OnClick_clickAction) {
                        this.mMode = obtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View] */
            public void addOnClickListeners(MotionLayout motionLayout, int i2, Transition transition) {
                int i3 = this.mTargetId;
                MotionLayout motionLayout2 = motionLayout;
                if (i3 != -1) {
                    motionLayout2 = motionLayout.findViewById(i3);
                }
                if (motionLayout2 == null) {
                    String str = "OnClick could not find id " + this.mTargetId;
                    return;
                }
                int i4 = transition.mConstraintSetStart;
                int i5 = transition.mConstraintSetEnd;
                if (i4 == -1) {
                    motionLayout2.setOnClickListener(this);
                    return;
                }
                if ((((this.mMode & 1) != 0 && i2 == i4) | ((this.mMode & 1) != 0 && i2 == i4) | ((this.mMode & 256) != 0 && i2 == i4) | ((this.mMode & 16) != 0 && i2 == i5)) || ((this.mMode & 4096) != 0 && i2 == i5)) {
                    motionLayout2.setOnClickListener(this);
                }
            }

            boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int i2 = transition2.mConstraintSetEnd;
                int i3 = this.mTransition.mConstraintSetStart;
                if (i3 == -1) {
                    return motionLayout.mCurrentState != i2;
                }
                int i4 = motionLayout.mCurrentState;
                return i4 == i3 || i4 == i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.mTransition.mMotionScene.mMotionLayout;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        Transition transition = new Transition(this.mTransition.mMotionScene, this.mTransition);
                        transition.mConstraintSetStart = currentState;
                        transition.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                        motionLayout.setTransition(transition);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                    int i2 = this.mMode;
                    boolean z = ((i2 & 1) == 0 && (i2 & 256) == 0) ? false : true;
                    int i3 = this.mMode;
                    boolean z2 = ((i3 & 16) == 0 && (i3 & 4096) == 0) ? false : true;
                    if (z && z2) {
                        Transition transition3 = this.mTransition.mMotionScene.mCurrentTransition;
                        Transition transition4 = this.mTransition;
                        if (transition3 != transition4) {
                            motionLayout.setTransition(transition4);
                        }
                        if (motionLayout.getCurrentState() == motionLayout.getEndState() || motionLayout.getProgress() > 0.5f) {
                            z = false;
                        } else {
                            z2 = false;
                        }
                    }
                    if (isTransitionViable(transition2, motionLayout)) {
                        if (z && (this.mMode & 1) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToEnd();
                            return;
                        }
                        if (z2 && (this.mMode & 16) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToStart();
                        } else if (z && (this.mMode & 256) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z2 || (this.mMode & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i2 = this.mTargetId;
                if (i2 == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i2);
                if (findViewById != null) {
                    findViewById.setOnClickListener(null);
                    return;
                }
                String str = " (*)  could not find id " + this.mTargetId;
            }
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                if (index == C0471R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, this.mConstraintSetEnd);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    }
                } else if (index == C0471R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    }
                } else if (index == C0471R.styleable.Transition_motionInterpolator) {
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 == 1) {
                        this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                        if (this.mDefaultInterpolatorID != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i3 == 3) {
                        this.mDefaultInterpolatorString = typedArray.getString(index);
                        if (this.mDefaultInterpolatorString.indexOf("/") > 0) {
                            this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                            this.mDefaultInterpolator = -2;
                        } else {
                            this.mDefaultInterpolator = -1;
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == C0471R.styleable.Transition_duration) {
                    this.mDuration = typedArray.getInt(index, this.mDuration);
                } else if (index == C0471R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == C0471R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == C0471R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == C0471R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == C0471R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == C0471R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == C0471R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0471R.styleable.Transition);
            fill(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public String debugString(Context context) {
            String resourceEntryName = this.mConstraintSetStart == -1 ? AbstractC1191a.f2571h : context.getResources().getResourceEntryName(this.mConstraintSetStart);
            if (this.mConstraintSetEnd == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i2) {
            return (i2 & this.mTransitionFlags) != 0;
        }

        public void setAutoTransition(int i2) {
            this.mAutoTransition = i2;
        }

        public void setDuration(int i2) {
            this.mDuration = i2;
        }

        public void setEnable(boolean z) {
            this.mDisable = !z;
        }

        public void setPathMotionArc(int i2) {
            this.mPathMotionArc = i2;
        }

        public void setStagger(float f2) {
            this.mStagger = f2;
        }

        public Transition(int i2, MotionScene motionScene, int i3, int i4) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i2;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i3;
            this.mConstraintSetEnd = i4;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
