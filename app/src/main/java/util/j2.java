package util;

import android.media.MediaMetadataRetriever;
import android.util.Size;

/* JADX INFO: compiled from: VideoUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class j2 {
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
        return a(c(str));
    }

    public static long c(long j2) {
        if (j2 <= 0) {
            return 0L;
        }
        return j2 / 1000;
    }

    public static long d(String str) {
        return c(c(str));
    }

    public static Size e(String str) {
        if (str == null || str.isEmpty()) {
            return new Size(0, 0);
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    if (strExtractMetadata != null && strExtractMetadata2 != null) {
                        return new Size(Integer.parseInt(strExtractMetadata), Integer.parseInt(strExtractMetadata2));
                    }
                    mediaMetadataRetriever.release();
                } finally {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                mediaMetadataRetriever.release();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return new Size(0, 0);
    }

    public static long c(String str) {
        long j2 = 0;
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                    if (strExtractMetadata != null) {
                        j2 = Long.parseLong(strExtractMetadata);
                        return j2;
                    }
                    mediaMetadataRetriever.release();
                } finally {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                mediaMetadataRetriever.release();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return j2;
    }

    public static String b(long j2) {
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
