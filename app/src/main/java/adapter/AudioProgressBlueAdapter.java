package adapter;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import p388ui.Hicore;

/* loaded from: classes.dex */
public class AudioProgressBlueAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    /* renamed from: V */
    List<UploadStateInfo> f170V;

    /* renamed from: W */
    SimpleDateFormat f171W;

    /* renamed from: X */
    private boolean f172X;

    public AudioProgressBlueAdapter(int i2, List<LocalMedia> list) {
        super(i2, list);
        this.f172X = false;
    }

    /* renamed from: G */
    private SimpleDateFormat m208G() {
        if (this.f171W == null) {
            this.f171W = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
        }
        return this.f171W;
    }

    /* renamed from: k */
    public void m212k(boolean z) {
        this.f172X = z;
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((AudioProgressBlueAdapter) baseViewHolder, i2);
        UploadStateInfo uploadStateInfo = this.f170V.get(i2);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.img_defraud_play);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_size_time);
        ImageView imageView2 = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_fail);
        ImageView imageView3 = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_clear);
        if (this.f172X) {
            imageView3.setVisibility(8);
        }
        if (uploadStateInfo.isPlayState()) {
            ((AnimationDrawable) imageView.getBackground()).start();
        } else {
            imageView.setBackground(null);
            imageView.setBackground(this.f5580x.getResources().getDrawable(C2113R.drawable.anim_defraud_play_blue));
        }
        m210a(imageView2, textView, (TextView) baseViewHolder.m5224c(C2113R.id.tv_upload_state), uploadStateInfo);
        baseViewHolder.m5211a(C2113R.id.tv_size_time, (CharSequence) ((uploadStateInfo.getProgress() / 1024) + "KB | " + (uploadStateInfo.getTotal() / 1024) + "KB"));
    }

    public AudioProgressBlueAdapter(int i2, List<LocalMedia> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.f172X = false;
        this.f170V = list2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, LocalMedia localMedia) {
        String fileName = localMedia.getFileName();
        if (TextUtils.isEmpty(fileName)) {
            fileName = "";
        }
        baseViewHolder.m5211a(C2113R.id.tv_audio_name, (CharSequence) fileName).m5194a(C2113R.id.iv_fail).m5194a(C2113R.id.iv_clear).m5194a(C2113R.id.img_defraud_play);
    }

    /* renamed from: a */
    private void m210a(ImageView imageView, TextView textView, TextView textView2, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView2.setText("等待上传");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            textView.setText(m209a(uploadStateInfo.getProgress()) + "KB/" + m209a(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 1) {
            textView2.setText("上传中");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.black_dark));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            textView.setText(m209a(uploadStateInfo.getProgress()) + "KB/" + m209a(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState == 2) {
            textView2.setText("上传完成");
            textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.blue));
            imageView.setVisibility(8);
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            textView.setText(m209a(uploadStateInfo.getFileSize()) + "KB/" + m209a(uploadStateInfo.getFileSize()) + "KB");
            return;
        }
        if (uploadState != 3) {
            return;
        }
        textView2.setText("上传失败");
        textView2.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorRed));
        textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color._FF4002));
        textView.setText(m209a(uploadStateInfo.getProgress()) + "KB/" + m209a(uploadStateInfo.getFileSize()) + "KB");
        imageView.setVisibility(0);
    }

    /* renamed from: a */
    private long m209a(long j2) {
        return j2 / 1024;
    }

    /* renamed from: a */
    private void m211a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("等待上传");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("上传中");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("上传完成");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("上传失败");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorRed));
        }
    }
}
