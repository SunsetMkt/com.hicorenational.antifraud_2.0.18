package util;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import java.io.File;
import java.util.Locale;

/* JADX INFO: compiled from: AudioUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a1 {
    public static String a(long j2) {
        if (j2 <= 0) {
            return "0\u79d2";
        }
        long j3 = j2 / 1000;
        if (j3 < 60) {
            return j3 + "\u79d2";
        }
        long j4 = j3 % 60;
        long j5 = j3 / 60;
        if (j5 < 60) {
            if (j4 == 0) {
                return j5 + "\u5206\u949f";
            }
            return j5 + "\u5206\u949f" + j4 + "\u79d2";
        }
        long j6 = j5 / 60;
        long j7 = j5 % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(j6);
        sb.append("\u5c0f\u65f6");
        if (j7 > 0) {
            sb.append(j7);
            sb.append("\u5206\u949f");
        }
        if (j4 > 0) {
            sb.append(j4);
            sb.append("\u79d2");
        }
        return sb.toString();
    }

    public static String b(String str) {
        long jC = c(str);
        if (jC <= 0) {
            return "00:00";
        }
        long j2 = jC / 1000;
        return String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60));
    }

    public static long c(String str) {
        if (str != null && !str.isEmpty()) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (strExtractMetadata != null) {
                            return Long.parseLong(strExtractMetadata);
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 0L;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        long jD = d(str);
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        return jD;
                    }
                } finally {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        }
        return 0L;
    }

    private static long d(String str) {
        long duration;
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            try {
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                duration = mediaPlayer.getDuration();
            } catch (Exception e2) {
                e2.printStackTrace();
                duration = 0;
            }
            return duration;
        } finally {
            mediaPlayer.release();
        }
    }

    public static long e(String str) {
        return b(c(str));
    }

    public static String f(String str) {
        return a(c(str));
    }

    public static long b(long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 / 1000;
    }

    public static String a(String str) {
        long j2;
        try {
            j2 = Long.parseLong(str);
        } catch (Exception unused) {
            j2 = 0;
        }
        if (j2 <= 0) {
            return "0\u79d2";
        }
        if (j2 < 60) {
            return j2 + "\u79d2";
        }
        long j3 = j2 % 60;
        long j4 = j2 / 60;
        if (j4 < 60) {
            if (j3 == 0) {
                return j4 + "\u5206\u949f";
            }
            return j4 + "\u5206\u949f" + j3 + "\u79d2";
        }
        long j5 = j4 / 60;
        long j6 = j4 % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(j5);
        sb.append("\u5c0f\u65f6");
        if (j6 > 0) {
            sb.append(j6);
            sb.append("\u5206\u949f");
        }
        if (j3 > 0) {
            sb.append(j3);
            sb.append("\u79d2");
        }
        return sb.toString();
    }
}
