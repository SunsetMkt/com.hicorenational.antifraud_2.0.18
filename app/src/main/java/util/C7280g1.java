package util;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import bean.LocalVideoBean;
import com.luck.picture.lib.tools.PictureFileUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.List;

/* compiled from: GetVideoFile.java */
/* renamed from: util.g1 */
/* loaded from: classes2.dex */
public class C7280g1 {

    /* compiled from: GetVideoFile.java */
    /* renamed from: util.g1$a */
    static class a implements FileFilter {

        /* renamed from: a */
        final /* synthetic */ List f25308a;

        a(List list) {
            this.f25308a = list;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            int indexOf = name.indexOf(46);
            if (indexOf == -1) {
                if (!file.isDirectory()) {
                    return false;
                }
                C7280g1.m26368a(this.f25308a, file);
                return false;
            }
            String substring = name.substring(indexOf);
            if (!substring.equalsIgnoreCase(".mp4") && !substring.equalsIgnoreCase(PictureFileUtils.POST_AUDIO)) {
                return false;
            }
            LocalVideoBean localVideoBean = new LocalVideoBean();
            file.getUsableSpace();
            localVideoBean.setName(file.getName());
            localVideoBean.setPath(file.getPath());
            localVideoBean.setLastTime(file.lastModified());
            C7280g1.m26367a(localVideoBean);
            this.f25308a.add(localVideoBean);
            return true;
        }
    }

    /* renamed from: a */
    public static List<LocalVideoBean> m26368a(List<LocalVideoBean> list, File file) {
        if (file == null) {
            return list;
        }
        file.listFiles(new a(list));
        return list;
    }

    /* renamed from: a */
    public static LocalVideoBean m26367a(LocalVideoBean localVideoBean) {
        String str = "text";
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String path = localVideoBean.getPath();
        if (!TextUtils.isEmpty(path)) {
            try {
                mediaMetadataRetriever.setDataSource(path);
                try {
                    localVideoBean.setDuration(Long.parseLong(mediaMetadataRetriever.extractMetadata(9)));
                } catch (Exception unused) {
                    localVideoBean.setDuration(0L);
                }
                try {
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(12);
                    if (!TextUtils.isEmpty(extractMetadata)) {
                        str = extractMetadata;
                    }
                } catch (Exception unused2) {
                }
                if (localVideoBean.getName().endsWith("mp3") || str.startsWith("audio")) {
                    localVideoBean.setMimeType(1);
                } else if (localVideoBean.getName().endsWith("mp4") || str.startsWith("video")) {
                    localVideoBean.setMimeType(2);
                }
                mediaMetadataRetriever.release();
            } catch (Exception unused3) {
                mediaMetadataRetriever.release();
            }
        }
        return localVideoBean;
    }
}
