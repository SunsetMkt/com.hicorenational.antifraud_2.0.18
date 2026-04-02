package adapter;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import ui.Hicore;
import util.g2;

/* JADX INFO: loaded from: classes.dex */
public class AudioRecordDeleteAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    List<UploadStateInfo> V;
    SimpleDateFormat W;

    public AudioRecordDeleteAdapter(int i2, List<LocalMedia> list) {
        super(i2, list);
    }

    private SimpleDateFormat G() {
        if (this.W == null) {
            this.W = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
        }
        return this.W;
    }

    public AudioRecordDeleteAdapter(int i2, List<LocalMedia> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.V = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.img_defraud_play);
        if (this.V.get(i2).isPlayState()) {
            ((AnimationDrawable) imageView.getBackground()).start();
        } else {
            imageView.setBackground(null);
            imageView.setBackground(this.x.getResources().getDrawable(R.drawable.anim_defraud_play));
        }
        a((TextView) baseViewHolder.c(R.id.tv_upload_state), this.V.get(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0024  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        long length;
        String path = localMedia.getPath();
        long jLastModified = 0;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                length = file.length();
                jLastModified = file.lastModified();
            } else {
                length = 0;
            }
        }
        String str = G().format(Long.valueOf(jLastModified));
        String fileName = localMedia.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            fileName = "";
        }
        baseViewHolder.a(R.id.tv_audio_name, (CharSequence) fileName).a(R.id.tv_size_time, (CharSequence) (g2.a(length) + " | " + str)).a(R.id.iv_clear).a(R.id.iv_audio);
    }

    private void a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("\u7b49\u5f85\u4e0a\u4f20");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("\u4e0a\u4f20\u4e2d");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("\u4e0a\u4f20\u5b8c\u6210");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("\u4e0a\u4f20\u5931\u8d25");
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorRed));
        }
    }
}
