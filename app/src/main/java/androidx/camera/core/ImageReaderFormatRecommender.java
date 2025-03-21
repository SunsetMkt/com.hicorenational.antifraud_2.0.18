package androidx.camera.core;

import p031c.p035b.p036a.p037a.InterfaceC0950c;

/* loaded from: classes.dex */
final class ImageReaderFormatRecommender {

    @InterfaceC0950c
    static abstract class FormatCombo {
        FormatCombo() {
        }

        static FormatCombo create(int i2, int i3) {
            return new AutoValue_ImageReaderFormatRecommender_FormatCombo(i2, i3);
        }

        abstract int imageAnalysisFormat();

        abstract int imageCaptureFormat();
    }

    private ImageReaderFormatRecommender() {
    }

    static FormatCombo chooseCombo() {
        return FormatCombo.create(256, 35);
    }
}
