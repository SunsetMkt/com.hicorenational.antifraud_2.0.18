package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.C1921R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;

    @Nullable
    private Typeface font;

    @Nullable
    public final String fontFamily;

    @FontRes
    private final int fontFamilyResourceId;
    private boolean fontResolved = false;

    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;

    @Nullable
    public final ColorStateList textColor;

    @Nullable
    public final ColorStateList textColorHint;

    @Nullable
    public final ColorStateList textColorLink;
    public final float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context context, @StyleRes int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, C1921R.styleable.TextAppearance);
        this.textSize = obtainStyledAttributes.getDimension(C1921R.styleable.TextAppearance_android_textSize, 0.0f);
        this.textColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, C1921R.styleable.TextAppearance_android_textColor);
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, C1921R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, C1921R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(C1921R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(C1921R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, C1921R.styleable.TextAppearance_fontFamily, C1921R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(C1921R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, C1921R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(C1921R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(C1921R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(C1921R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createFallbackTypeface() {
        if (this.font == null) {
            this.font = Typeface.create(this.fontFamily, this.textStyle);
        }
        if (this.font == null) {
            int i2 = this.typeface;
            if (i2 == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.font = Typeface.SERIF;
            } else if (i2 != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            Typeface typeface = this.font;
            if (typeface != null) {
                this.font = Typeface.create(typeface, this.textStyle);
            }
        }
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                this.font = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                if (this.font != null) {
                    this.font = Typeface.create(this.font, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                String str = "Error loading font " + this.fontFamily;
            }
        }
        createFallbackTypeface();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(Context context, final TextPaint textPaint, @NonNull final ResourcesCompat.FontCallback fontCallback) {
        if (this.fontResolved) {
            updateTextPaintMeasureState(textPaint, this.font);
            return;
        }
        createFallbackTypeface();
        if (context.isRestricted()) {
            this.fontResolved = true;
            updateTextPaintMeasureState(textPaint, this.font);
            return;
        }
        try {
            ResourcesCompat.getFont(context, this.fontFamilyResourceId, new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void onFontRetrievalFailed(int i2) {
                    TextAppearance.this.createFallbackTypeface();
                    TextAppearance.this.fontResolved = true;
                    fontCallback.onFontRetrievalFailed(i2);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void onFontRetrieved(@NonNull Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    TextAppearance.this.updateTextPaintMeasureState(textPaint, typeface);
                    TextAppearance.this.fontResolved = true;
                    fontCallback.onFontRetrieved(typeface);
                }
            }, null);
        } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
        } catch (Exception unused2) {
            String str = "Error loading font " + this.fontFamily;
        }
    }

    public void updateDrawState(Context context, TextPaint textPaint, ResourcesCompat.FontCallback fontCallback) {
        updateMeasureState(context, textPaint, fontCallback);
        ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f2 = this.shadowRadius;
        float f3 = this.shadowDx;
        float f4 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void updateMeasureState(Context context, TextPaint textPaint, @Nullable ResourcesCompat.FontCallback fontCallback) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            updateTextPaintMeasureState(textPaint, getFont(context));
            return;
        }
        getFontAsync(context, textPaint, fontCallback);
        if (this.fontResolved) {
            return;
        }
        updateTextPaintMeasureState(textPaint, this.font);
    }

    public void updateTextPaintMeasureState(@NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.textStyle;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
    }
}
