package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.C1921R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private GradientDrawable boxBackground;

    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxBottomOffsetPx;
    private final int boxCollapsedPaddingTopPx;
    private float boxCornerRadiusBottomEnd;
    private float boxCornerRadiusBottomStart;
    private float boxCornerRadiusTopEnd;
    private float boxCornerRadiusTopStart;
    private final int boxLabelCutoutPaddingPx;

    @ColorInt
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private final int counterOverflowTextAppearance;
    private boolean counterOverflowed;
    private final int counterTextAppearance;
    private TextView counterView;
    private ColorStateList defaultHintTextColor;

    @ColorInt
    private final int defaultStrokeColor;

    @ColorInt
    private final int disabledColor;
    EditText editText;
    private Drawable editTextOriginalDrawable;

    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasPasswordToggleTintList;
    private boolean hasPasswordToggleTintMode;
    private boolean hasReconstructedEditTextBackground;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;

    @ColorInt
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private CharSequence passwordToggleContentDesc;
    private Drawable passwordToggleDrawable;
    private Drawable passwordToggleDummyDrawable;
    private boolean passwordToggleEnabled;
    private ColorStateList passwordToggleTintList;
    private PorterDuff.Mode passwordToggleTintMode;
    private CheckableImageButton passwordToggleView;
    private boolean passwordToggledVisible;
    private boolean restoringSavedState;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (z2) {
                accessibilityNodeInfoCompat.setText(hint);
            }
            if (z2) {
                accessibilityNodeInfoCompat.setHintText(hint);
                if (!z && z2) {
                    z4 = true;
                }
                accessibilityNodeInfoCompat.setShowingHintText(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
                accessibilityNodeInfoCompat.setContentInvalid(true);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            EditText editText = this.layout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.layout.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        CharSequence error;
        boolean isPasswordToggledVisible;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.error, parcel, i2);
            parcel.writeInt(this.isPasswordToggledVisible ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isPasswordToggledVisible = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private void applyBoxAttributes() {
        int i2;
        Drawable drawable;
        if (this.boxBackground == null) {
            return;
        }
        setBoxAttributes();
        EditText editText = this.editText;
        if (editText != null && this.boxBackgroundMode == 2) {
            if (editText.getBackground() != null) {
                this.editTextOriginalDrawable = this.editText.getBackground();
            }
            ViewCompat.setBackground(this.editText, null);
        }
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 1 && (drawable = this.editTextOriginalDrawable) != null) {
            ViewCompat.setBackground(editText2, drawable);
        }
        int i3 = this.boxStrokeWidthPx;
        if (i3 > -1 && (i2 = this.boxStrokeColor) != 0) {
            this.boxBackground.setStroke(i3, i2);
        }
        this.boxBackground.setCornerRadii(getCornerRadiiAsArray());
        this.boxBackground.setColor(this.boxBackgroundColor);
        invalidate();
    }

    private void applyCutoutPadding(RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.boxLabelCutoutPaddingPx;
        rectF.left = f2 - i2;
        rectF.top -= i2;
        rectF.right += i2;
        rectF.bottom += i2;
    }

    private void applyPasswordToggleTint() {
        if (this.passwordToggleDrawable != null) {
            if (this.hasPasswordToggleTintList || this.hasPasswordToggleTintMode) {
                this.passwordToggleDrawable = DrawableCompat.wrap(this.passwordToggleDrawable).mutate();
                if (this.hasPasswordToggleTintList) {
                    DrawableCompat.setTintList(this.passwordToggleDrawable, this.passwordToggleTintList);
                }
                if (this.hasPasswordToggleTintMode) {
                    DrawableCompat.setTintMode(this.passwordToggleDrawable, this.passwordToggleTintMode);
                }
                CheckableImageButton checkableImageButton = this.passwordToggleView;
                if (checkableImageButton != null) {
                    Drawable drawable = checkableImageButton.getDrawable();
                    Drawable drawable2 = this.passwordToggleDrawable;
                    if (drawable != drawable2) {
                        this.passwordToggleView.setImageDrawable(drawable2);
                    }
                }
            }
        }
    }

    private void assignBoxBackgroundByMode() {
        int i2 = this.boxBackgroundMode;
        if (i2 == 0) {
            this.boxBackground = null;
            return;
        }
        if (i2 == 2 && this.hintEnabled && !(this.boxBackground instanceof CutoutDrawable)) {
            this.boxBackground = new CutoutDrawable();
        } else {
            if (this.boxBackground instanceof GradientDrawable) {
                return;
            }
            this.boxBackground = new GradientDrawable();
        }
    }

    private int calculateBoxBackgroundTop() {
        EditText editText = this.editText;
        if (editText == null) {
            return 0;
        }
        int i2 = this.boxBackgroundMode;
        if (i2 == 1) {
            return editText.getTop();
        }
        if (i2 != 2) {
            return 0;
        }
        return editText.getTop() + calculateLabelMarginTop();
    }

    private int calculateCollapsedTextTopBounds() {
        int i2 = this.boxBackgroundMode;
        return i2 != 1 ? i2 != 2 ? getPaddingTop() : getBoxBackground().getBounds().top - calculateLabelMarginTop() : getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i2 = this.boxBackgroundMode;
        if (i2 == 0 || i2 == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else {
            if (i2 != 2) {
                return 0;
            }
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void collapseHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        Drawable background;
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 != 21 && i2 != 22) || (background = this.editText.getBackground()) == null || this.hasReconstructedEditTextBackground) {
            return;
        }
        Drawable newDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.hasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer) background, newDrawable.getConstantState());
        }
        if (this.hasReconstructedEditTextBackground) {
            return;
        }
        ViewCompat.setBackground(this.editText, newDrawable);
        this.hasReconstructedEditTextBackground = true;
        onApplyBoxBackgroundMode();
    }

    private void expandHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z && this.hintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
    }

    @NonNull
    private Drawable getBoxBackground() {
        int i2 = this.boxBackgroundMode;
        if (i2 == 1 || i2 == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    private float[] getCornerRadiiAsArray() {
        if (ViewUtils.isLayoutRtl(this)) {
            float f2 = this.boxCornerRadiusTopEnd;
            float f3 = this.boxCornerRadiusTopStart;
            float f4 = this.boxCornerRadiusBottomStart;
            float f5 = this.boxCornerRadiusBottomEnd;
            return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
        }
        float f6 = this.boxCornerRadiusTopStart;
        float f7 = this.boxCornerRadiusTopEnd;
        float f8 = this.boxCornerRadiusBottomEnd;
        float f9 = this.boxCornerRadiusBottomStart;
        return new float[]{f6, f6, f7, f7, f8, f8, f9, f9};
    }

    private boolean hasPasswordTransformation() {
        EditText editText = this.editText;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
        updateTextInputBoxBounds();
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF);
            applyCutoutPadding(rectF);
            ((CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setBoxAttributes() {
        int i2 = this.boxBackgroundMode;
        if (i2 == 1) {
            this.boxStrokeWidthPx = 0;
        } else if (i2 == 2 && this.focusedStrokeColor == 0) {
            this.focusedStrokeColor = this.focusedTextColor.getColorForState(getDrawableState(), this.focusedTextColor.getDefaultColor());
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        boolean z = editText instanceof TextInputEditText;
        this.editText = editText;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        if (!hasPasswordTransformation()) {
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        }
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int gravity = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(gravity);
        this.editText.addTextChangedListener(new TextWatcher() { // from class: com.google.android.material.textfield.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.updateLabelState(!r0.restoringSavedState);
                TextInputLayout textInputLayout = TextInputLayout.this;
                if (textInputLayout.counterEnabled) {
                    textInputLayout.updateCounter(editable.length());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty(this.hint)) {
                this.originalHint = this.editText.getHint();
                setHint(this.originalHint);
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        this.indicatorViewController.adjustIndicatorPadding();
        updatePasswordToggleView();
        updateLabelState(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.setText(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    private boolean shouldShowPasswordIcon() {
        return this.passwordToggleEnabled && (hasPasswordTransformation() || this.passwordToggledVisible);
    }

    private void updateEditTextBackgroundBounds() {
        Drawable background;
        EditText editText = this.editText;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        DescendantOffsetUtils.getDescendantRect(this, this.editText, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.editText.getBottom());
        }
    }

    private void updateInputLayoutMargins() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int calculateLabelMarginTop = calculateLabelMarginTop();
        if (calculateLabelMarginTop != layoutParams.topMargin) {
            layoutParams.topMargin = calculateLabelMarginTop;
            this.inputFrame.requestLayout();
        }
    }

    private void updatePasswordToggleView() {
        if (this.editText == null) {
            return;
        }
        if (!shouldShowPasswordIcon()) {
            CheckableImageButton checkableImageButton = this.passwordToggleView;
            if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
                this.passwordToggleView.setVisibility(8);
            }
            if (this.passwordToggleDummyDrawable != null) {
                Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.editText);
                if (compoundDrawablesRelative[2] == this.passwordToggleDummyDrawable) {
                    TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.originalEditTextEndDrawable, compoundDrawablesRelative[3]);
                    this.passwordToggleDummyDrawable = null;
                    return;
                }
                return;
            }
            return;
        }
        if (this.passwordToggleView == null) {
            this.passwordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C1921R.layout.design_text_input_password_icon, (ViewGroup) this.inputFrame, false);
            this.passwordToggleView.setImageDrawable(this.passwordToggleDrawable);
            this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
            this.inputFrame.addView(this.passwordToggleView);
            this.passwordToggleView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TextInputLayout.this.passwordVisibilityToggleRequested(false);
                }
            });
        }
        EditText editText = this.editText;
        if (editText != null && ViewCompat.getMinimumHeight(editText) <= 0) {
            this.editText.setMinimumHeight(ViewCompat.getMinimumHeight(this.passwordToggleView));
        }
        this.passwordToggleView.setVisibility(0);
        this.passwordToggleView.setChecked(this.passwordToggledVisible);
        if (this.passwordToggleDummyDrawable == null) {
            this.passwordToggleDummyDrawable = new ColorDrawable();
        }
        this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
        Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
        if (compoundDrawablesRelative2[2] != this.passwordToggleDummyDrawable) {
            this.originalEditTextEndDrawable = compoundDrawablesRelative2[2];
        }
        TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.passwordToggleDummyDrawable, compoundDrawablesRelative2[3]);
        this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
    }

    private void updateTextInputBoxBounds() {
        if (this.boxBackgroundMode == 0 || this.boxBackground == null || this.editText == null || getRight() == 0) {
            return;
        }
        int left = this.editText.getLeft();
        int calculateBoxBackgroundTop = calculateBoxBackgroundTop();
        int right = this.editText.getRight();
        int bottom = this.editText.getBottom() + this.boxBottomOffsetPx;
        if (this.boxBackgroundMode == 2) {
            int i2 = this.boxStrokeWidthFocusedPx;
            left += i2 / 2;
            calculateBoxBackgroundTop -= i2 / 2;
            right -= i2 / 2;
            bottom += i2 / 2;
        }
        this.boxBackground.setBounds(left, calculateBoxBackgroundTop, right, bottom);
        applyBoxAttributes();
        updateEditTextBackgroundBounds();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i2, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.inputFrame.addView(view, layoutParams2);
        this.inputFrame.setLayoutParams(layoutParams);
        updateInputLayoutMargins();
        setEditText((EditText) view);
    }

    @VisibleForTesting
    void animateToExpansionFraction(float f2) {
        if (this.collapsingTextHelper.getExpansionFraction() == f2) {
            return;
        }
        if (this.animator == null) {
            this.animator = new ValueAnimator();
            this.animator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        this.animator.setFloatValues(this.collapsingTextHelper.getExpansionFraction(), f2);
        this.animator.start();
    }

    @VisibleForTesting
    boolean cutoutIsOpen() {
        return cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.originalHint == null || (editText = this.editText) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence hint = editText.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.editText.setHint(hint);
            this.isProvidingHint = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.boxBackground;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        updateLabelState(ViewCompat.isLaidOut(this) && isEnabled());
        updateEditTextBackground();
        updateTextInputBoxBounds();
        updateTextInputBoxState();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null ? collapsingTextHelper.setState(drawableState) | false : false) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxCornerRadiusBottomEnd;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxCornerRadiusBottomStart;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxCornerRadiusTopEnd;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxCornerRadiusTopStart;
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    @Nullable
    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @VisibleForTesting
    final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    @VisibleForTesting
    final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    @VisibleForTesting
    final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.passwordToggleContentDesc;
    }

    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.passwordToggleDrawable;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    @VisibleForTesting
    final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    @VisibleForTesting
    final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        EditText editText;
        super.onLayout(z, i2, i3, i4, i5);
        if (this.boxBackground != null) {
            updateTextInputBoxBounds();
        }
        if (!this.hintEnabled || (editText = this.editText) == null) {
            return;
        }
        Rect rect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(this, editText, rect);
        int compoundPaddingLeft = rect.left + this.editText.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.editText.getCompoundPaddingRight();
        int calculateCollapsedTextTopBounds = calculateCollapsedTextTopBounds();
        this.collapsingTextHelper.setExpandedBounds(compoundPaddingLeft, rect.top + this.editText.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.editText.getCompoundPaddingBottom());
        this.collapsingTextHelper.setCollapsedBounds(compoundPaddingLeft, calculateCollapsedTextTopBounds, compoundPaddingRight, (i5 - i3) - getPaddingBottom());
        this.collapsingTextHelper.recalculate();
        if (!cutoutEnabled() || this.hintExpanded) {
            return;
        }
        openCutout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        updatePasswordToggleView();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isPasswordToggledVisible) {
            passwordVisibilityToggleRequested(true);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isPasswordToggledVisible = this.passwordToggledVisible;
        return savedState;
    }

    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.passwordToggleEnabled) {
            int selectionEnd = this.editText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.editText.setTransformationMethod(null);
                this.passwordToggledVisible = true;
            } else {
                this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordToggledVisible = false;
            }
            this.passwordToggleView.setChecked(this.passwordToggledVisible);
            if (z) {
                this.passwordToggleView.jumpDrawablesToCurrentState();
            }
            this.editText.setSelection(selectionEnd);
        }
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.boxBackgroundColor != i2) {
            this.boxBackgroundColor = i2;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i2;
        onApplyBoxBackgroundMode();
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        if (this.boxCornerRadiusTopStart == f2 && this.boxCornerRadiusTopEnd == f3 && this.boxCornerRadiusBottomEnd == f5 && this.boxCornerRadiusBottomStart == f4) {
            return;
        }
        this.boxCornerRadiusTopStart = f2;
        this.boxCornerRadiusTopEnd = f3;
        this.boxCornerRadiusBottomEnd = f5;
        this.boxCornerRadiusBottomStart = f4;
        applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(@DimenRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        setBoxCornerRadii(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i5));
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.focusedStrokeColor != i2) {
            this.focusedStrokeColor = i2;
            updateTextInputBoxState();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                this.counterView = new AppCompatTextView(getContext());
                this.counterView.setId(C1921R.id.textinput_counter);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterTextAppearance);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                EditText editText = this.editText;
                if (editText == null) {
                    updateCounter(0);
                } else {
                    updateCounter(editText.getText().length());
                }
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.counterMaxLength != i2) {
            if (i2 > 0) {
                this.counterMaxLength = i2;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                EditText editText = this.editText;
                updateCounter(editText == null ? 0 : editText.getText().length());
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.hideError();
        } else {
            this.indicatorViewController.showError(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.setErrorEnabled(z);
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        this.indicatorViewController.setErrorTextAppearance(i2);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        }
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.setHelperTextEnabled(z);
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        this.indicatorViewController.setHelperTextAppearance(i2);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (this.hintEnabled) {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            } else {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i2);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EditText editText;
        if (this.passwordToggleEnabled != z) {
            this.passwordToggleEnabled = z;
            if (!z && this.passwordToggledVisible && (editText = this.editText) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.passwordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.passwordToggleTintList = colorStateList;
        this.hasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.passwordToggleTintMode = mode;
        this.hasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setTextAppearanceCompatWithErrorFallback(android.widget.TextView r3, @androidx.annotation.StyleRes int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.C1921R.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.C1921R.color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.setTextAppearanceCompatWithErrorFallback(android.widget.TextView, int):void");
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.editText;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            this.indicatorViewController.setTypefaces(typeface);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void updateCounter(int i2) {
        boolean z = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText(String.valueOf(i2));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            if (ViewCompat.getAccessibilityLiveRegion(this.counterView) == 1) {
                ViewCompat.setAccessibilityLiveRegion(this.counterView, 0);
            }
            this.counterOverflowed = i2 > this.counterMaxLength;
            boolean z2 = this.counterOverflowed;
            if (z != z2) {
                setTextAppearanceCompatWithErrorFallback(this.counterView, z2 ? this.counterOverflowTextAppearance : this.counterTextAppearance);
                if (this.counterOverflowed) {
                    ViewCompat.setAccessibilityLiveRegion(this.counterView, 1);
                }
            }
            this.counterView.setText(getContext().getString(C1921R.string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.counterMaxLength)));
            this.counterView.setContentDescription(getContext().getString(C1921R.string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.counterMaxLength)));
        }
        if (this.editText == null || z == this.counterOverflowed) {
            return;
        }
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }

    void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText = this.editText;
        if (editText == null || (background = editText.getBackground()) == null) {
            return;
        }
        ensureBackgroundDrawableStateWorkaround();
        if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.errorShouldBeShown()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.getErrorViewCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.editText.refreshDrawableState();
        }
    }

    void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    void updateTextInputBoxState() {
        TextView textView;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        EditText editText = this.editText;
        boolean z = editText != null && editText.hasFocus();
        EditText editText2 = this.editText;
        boolean z2 = editText2 != null && editText2.isHovered();
        if (this.boxBackgroundMode == 2) {
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (this.indicatorViewController.errorShouldBeShown()) {
                this.boxStrokeColor = this.indicatorViewController.getErrorViewCurrentTextColor();
            } else if (this.counterOverflowed && (textView = this.counterView) != null) {
                this.boxStrokeColor = textView.getCurrentTextColor();
            } else if (z) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z2) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
            if ((z2 || z) && isEnabled()) {
                this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
            } else {
                this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
            }
            applyBoxAttributes();
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1921R.attr.textInputStyle);
    }

    private void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.editText;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.editText;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.disabledColor));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.disabledColor));
        } else if (errorShouldBeShown) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z4 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z3 || (isEnabled() && (z4 || errorShouldBeShown))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
                return;
            }
            return;
        }
        if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.indicatorViewController = new IndicatorViewController(this);
        this.tmpRect = new Rect();
        this.tmpRectF = new RectF();
        this.collapsingTextHelper = new CollapsingTextHelper(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.inputFrame = new FrameLayout(context);
        this.inputFrame.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        this.collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setPositionInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.collapsingTextHelper.setCollapsedTextGravity(8388659);
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context, attributeSet, C1921R.styleable.TextInputLayout, i2, C1921R.style.Widget_Design_TextInputLayout, new int[0]);
        this.hintEnabled = obtainTintedStyledAttributes.getBoolean(C1921R.styleable.TextInputLayout_hintEnabled, true);
        setHint(obtainTintedStyledAttributes.getText(C1921R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = obtainTintedStyledAttributes.getBoolean(C1921R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.boxBottomOffsetPx = context.getResources().getDimensionPixelOffset(C1921R.dimen.mtrl_textinput_box_bottom_offset);
        this.boxLabelCutoutPaddingPx = context.getResources().getDimensionPixelOffset(C1921R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = obtainTintedStyledAttributes.getDimensionPixelOffset(C1921R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxCornerRadiusTopStart = obtainTintedStyledAttributes.getDimension(C1921R.styleable.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.boxCornerRadiusTopEnd = obtainTintedStyledAttributes.getDimension(C1921R.styleable.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.boxCornerRadiusBottomEnd = obtainTintedStyledAttributes.getDimension(C1921R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.boxCornerRadiusBottomStart = obtainTintedStyledAttributes.getDimension(C1921R.styleable.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.boxBackgroundColor = obtainTintedStyledAttributes.getColor(C1921R.styleable.TextInputLayout_boxBackgroundColor, 0);
        this.focusedStrokeColor = obtainTintedStyledAttributes.getColor(C1921R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.boxStrokeWidthDefaultPx = context.getResources().getDimensionPixelSize(C1921R.dimen.mtrl_textinput_box_stroke_width_default);
        this.boxStrokeWidthFocusedPx = context.getResources().getDimensionPixelSize(C1921R.dimen.mtrl_textinput_box_stroke_width_focused);
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        setBoxBackgroundMode(obtainTintedStyledAttributes.getInt(C1921R.styleable.TextInputLayout_boxBackgroundMode, 0));
        if (obtainTintedStyledAttributes.hasValue(C1921R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = obtainTintedStyledAttributes.getColorStateList(C1921R.styleable.TextInputLayout_android_textColorHint);
            this.focusedTextColor = colorStateList;
            this.defaultHintTextColor = colorStateList;
        }
        this.defaultStrokeColor = ContextCompat.getColor(context, C1921R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(context, C1921R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(context, C1921R.color.mtrl_textinput_hovered_box_stroke_color);
        if (obtainTintedStyledAttributes.getResourceId(C1921R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(obtainTintedStyledAttributes.getResourceId(C1921R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int resourceId = obtainTintedStyledAttributes.getResourceId(C1921R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean z = obtainTintedStyledAttributes.getBoolean(C1921R.styleable.TextInputLayout_errorEnabled, false);
        int resourceId2 = obtainTintedStyledAttributes.getResourceId(C1921R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean z2 = obtainTintedStyledAttributes.getBoolean(C1921R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence text = obtainTintedStyledAttributes.getText(C1921R.styleable.TextInputLayout_helperText);
        boolean z3 = obtainTintedStyledAttributes.getBoolean(C1921R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(obtainTintedStyledAttributes.getInt(C1921R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = obtainTintedStyledAttributes.getResourceId(C1921R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = obtainTintedStyledAttributes.getResourceId(C1921R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.passwordToggleEnabled = obtainTintedStyledAttributes.getBoolean(C1921R.styleable.TextInputLayout_passwordToggleEnabled, false);
        this.passwordToggleDrawable = obtainTintedStyledAttributes.getDrawable(C1921R.styleable.TextInputLayout_passwordToggleDrawable);
        this.passwordToggleContentDesc = obtainTintedStyledAttributes.getText(C1921R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (obtainTintedStyledAttributes.hasValue(C1921R.styleable.TextInputLayout_passwordToggleTint)) {
            this.hasPasswordToggleTintList = true;
            this.passwordToggleTintList = obtainTintedStyledAttributes.getColorStateList(C1921R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (obtainTintedStyledAttributes.hasValue(C1921R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.hasPasswordToggleTintMode = true;
            this.passwordToggleTintMode = ViewUtils.parseTintMode(obtainTintedStyledAttributes.getInt(C1921R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        obtainTintedStyledAttributes.recycle();
        setHelperTextEnabled(z2);
        setHelperText(text);
        setHelperTextTextAppearance(resourceId2);
        setErrorEnabled(z);
        setErrorTextAppearance(resourceId);
        setCounterEnabled(z3);
        applyPasswordToggleTint();
        ViewCompat.setImportantForAccessibility(this, 2);
    }

    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.passwordToggleContentDesc = charSequence;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.passwordToggleDrawable = drawable;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }
}
