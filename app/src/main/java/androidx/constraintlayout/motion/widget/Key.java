package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class Key {
    static final String ALPHA = "alpha";
    static final String CUSTOM = "CUSTOM";
    static final String ELEVATION = "elevation";
    static final String PIVOT_X = "transformPivotX";
    static final String PIVOT_Y = "transformPivotY";
    static final String PROGRESS = "progress";
    static final String ROTATION = "rotation";
    static final String ROTATION_X = "rotationX";
    static final String ROTATION_Y = "rotationY";
    static final String SCALE_X = "scaleX";
    static final String SCALE_Y = "scaleY";
    static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    static final String TRANSLATION_X = "translationX";
    static final String TRANSLATION_Y = "translationY";
    static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    static final String WAVE_OFFSET = "waveOffset";
    static final String WAVE_PERIOD = "wavePeriod";
    static final String WAVE_VARIES_BY = "waveVariesBy";
    HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    public Key() {
        int i2 = UNSET;
        this.mFramePosition = i2;
        this.mTargetId = i2;
        this.mTargetString = null;
    }

    public abstract void addValues(HashMap<String, SplineSet> hashMap);

    abstract void getAttributeNames(HashSet<String> hashSet);

    abstract void load(Context context, AttributeSet attributeSet);

    boolean matches(String str) {
        String str2 = this.mTargetString;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
    }

    public abstract void setValue(String str, Object obj);

    boolean toBoolean(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    float toFloat(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    int toInt(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
