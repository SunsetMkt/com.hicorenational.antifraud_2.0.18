package util;

import android.media.MediaMetadataRetriever;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MediaDurationUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class v1 {
    public static String a(String str) {
        return d(str);
    }

    public static String b(String str) throws IOException {
        long j2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (strExtractMetadata != null) {
                try {
                    j2 = Long.parseLong(strExtractMetadata);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    j2 = 0;
                }
            } else {
                j2 = 0;
            }
            long hours = TimeUnit.MILLISECONDS.toHours(j2);
            long minutes = TimeUnit.MILLISECONDS.toMinutes(j2) % 60;
            long seconds = TimeUnit.MILLISECONDS.toSeconds(j2) % 60;
            long j3 = j2 % 1000;
            return hours > 0 ? String.format("%02d:%02d:%02d.%03d", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(j3)) : String.format("%02d:%02d.%03d", Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(j3));
        } catch (Exception e3) {
            e3.printStackTrace();
            return "00:00.000";
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static long c(String str) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (strExtractMetadata != null) {
                    return Long.parseLong(strExtractMetadata);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            mediaMetadataRetriever.release();
            return 0L;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static String d(String str) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            long j2 = 0;
            if (strExtractMetadata != null) {
                try {
                    j2 = Long.parseLong(strExtractMetadata);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            return a(j2);
        } catch (Exception e3) {
            e3.printStackTrace();
            return "00:00";
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static String e(String str) {
        return d(str);
    }

    public static String a(long j2) {
        if (j2 <= 0) {
            return "00:00";
        }
        long hours = TimeUnit.MILLISECONDS.toHours(j2);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(j2) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j2) % 60;
        return hours > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)) : String.format("%02d:%02d", Long.valueOf(minutes), Long.valueOf(seconds));
    }

    public static String a(String str, String str2) {
        return a(c(str), str2);
    }

    public static String a(long j2, String str) {
        return j2 <= 0 ? str.replace("HH", "00").replace("mm", "00").replace("ss", "00").replace("SSS", "000") : str.replace("HH", String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(TimeUnit.MILLISECONDS.toHours(j2)))).replace("mm", String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j2) % 60))).replace("ss", String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2) % 60))).replace("SSS", String.format("%03d", Long.valueOf(j2 % 1000)));
    }
}
