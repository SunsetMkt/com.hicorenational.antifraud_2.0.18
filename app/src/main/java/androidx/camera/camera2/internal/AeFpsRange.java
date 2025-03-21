package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.impl.Camera2ImplConfig;

/* loaded from: classes.dex */
final class AeFpsRange {
    private Range<Integer> mAeTargetFpsRange;

    AeFpsRange(CameraCharacteristics cameraCharacteristics) {
        this.mAeTargetFpsRange = null;
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num == null || num.intValue() != 2) {
            return;
        }
        this.mAeTargetFpsRange = pickSuitableFpsRange((Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES));
    }

    private static Range<Integer> getCorrectedFpsRange(@NonNull Range<Integer> range) {
        int intValue = range.getUpper().intValue();
        int intValue2 = range.getLower().intValue();
        if (range.getUpper().intValue() >= 1000) {
            intValue = range.getUpper().intValue() / 1000;
        }
        if (range.getLower().intValue() >= 1000) {
            intValue2 = range.getLower().intValue() / 1000;
        }
        return new Range<>(Integer.valueOf(intValue2), Integer.valueOf(intValue));
    }

    private static Range<Integer> pickSuitableFpsRange(Range<Integer>[] rangeArr) {
        Range<Integer> range = null;
        if (rangeArr != null && rangeArr.length != 0) {
            for (Range<Integer> range2 : rangeArr) {
                Range<Integer> correctedFpsRange = getCorrectedFpsRange(range2);
                if (correctedFpsRange.getUpper().intValue() == 30 && (range == null || correctedFpsRange.getLower().intValue() < range.getLower().intValue())) {
                    range = correctedFpsRange;
                }
            }
        }
        return range;
    }

    public void addAeFpsRangeOptions(@NonNull Camera2ImplConfig.Builder builder) {
        Range<Integer> range = this.mAeTargetFpsRange;
        if (range != null) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
        }
    }
}
