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
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import ui.Hicore;

/* JADX INFO: loaded from: classes.dex */
public class AudioProgressBlueAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {
    List<UploadStateInfo> V;
    SimpleDateFormat W;
    private boolean X;

    public AudioProgressBlueAdapter(int i2, List<LocalMedia> list) {
        super(i2, list);
        this.X = false;
    }

    private SimpleDateFormat G() {
        if (this.W == null) {
            this.W = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
        }
        return this.W;
    }

    public void k(boolean z) {
        this.X = z;
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder(baseViewHolder, i2);
        UploadStateInfo uploadStateInfo = this.V.get(i2);
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.img_defraud_play);
        TextView textView = (TextView) baseViewHolder.c(R.id.tv_size_time);
        ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.iv_fail);
        ImageView imageView3 = (ImageView) baseViewHolder.c(R.id.iv_clear);
        if (this.X) {
            imageView3.setVisibility(8);
        }
        if (uploadStateInfo.isPlayState()) {
            ((AnimationDrawable) imageView.getBackground()).start();
        } else {
            imageView.setBackground(null);
            imageView.setBackground(this.x.getResources().getDrawable(R.drawable.anim_defraud_play_blue));
        }
        a(imageView2, textView, (TextView) baseViewHolder.c(R.id.tv_upload_state), uploadStateInfo);
        baseViewHolder.a(R.id.tv_size_time, (CharSequence) ((uploadStateInfo.getProgress() / 1024) + "KB | " + (uploadStateInfo.getTotal() / 1024) + "KB"));
    }

    public AudioProgressBlueAdapter(int i2, List<LocalMedia> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.X = false;
        this.V = list2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        String fileName = localMedia.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            fileName = "";
        }
        baseViewHolder.a(R.id.tv_audio_name, (CharSequence) fileName).a(R.id.iv_fail).a(R.id.iv_clear).a(R.id.img_defraud_play);
    }

    private void a(ImageView imageView, TextView textView, TextView textView2, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView2.setText("\u7b49\u5f85\u4e0a\u4f20");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            textView.setText(a(uploadStateInfo.getProgress()) + "KB/" + a(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 1) {
            textView2.setText("\u4e0a\u4f20\u4e2d");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.black_dark));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            textView.setText(a(uploadStateInfo.getProgress()) + "KB/" + a(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 2) {
            textView2.setText("\u4e0a\u4f20\u5b8c\u6210");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.blue));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorGray));
            textView.setText(a(uploadStateInfo.getFileSize()) + "KB/" + a(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState != 3) {
            return;
        }
        textView2.setText("\u4e0a\u4f20\u5931\u8d25");
        textView2.setTextColor(Hicore.getApp().getResources().getColor(R.color.colorRed));
        textView.setTextColor(Hicore.getApp().getResources().getColor(R.color._FF4002));
        textView.setText(a(uploadStateInfo.getProgress()) + "KB/" + a(uploadStateInfo.getFileSize()) + "KB");
        imageView.setVisibility(0);
    }

    private long a(long j2) {
        return j2 / 1024;
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
