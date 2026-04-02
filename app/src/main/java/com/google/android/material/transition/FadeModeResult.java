package com.google.android.material.transition;

/* JADX INFO: loaded from: classes.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i2, int i3, boolean z) {
        this.startAlpha = i2;
        this.endAlpha = i3;
        this.endOnTop = z;
    }

    static FadeModeResult endOnTop(int i2, int i3) {
        return new FadeModeResult(i2, i3, true);
    }

    static FadeModeResult startOnTop(int i2, int i3) {
        return new FadeModeResult(i2, i3, false);
    }
}
