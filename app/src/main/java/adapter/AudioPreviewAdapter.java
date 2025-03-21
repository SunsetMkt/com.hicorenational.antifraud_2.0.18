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
import java.util.List;

/* loaded from: classes.dex */
public class AudioPreviewAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    /* renamed from: V */
    List<UploadStateInfo> f169V;

    public AudioPreviewAdapter(List<LocalMedia> list, List<UploadStateInfo> list2) {
        super(C2113R.layout.item_survey_audio_new_preview, list);
        this.f169V = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((AudioPreviewAdapter) baseViewHolder, i2);
        UploadStateInfo uploadStateInfo = this.f169V.get(i2);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.img_defraud_play);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_size_time);
        if (uploadStateInfo.isPlayState()) {
            ((AnimationDrawable) imageView.getBackground()).start();
        } else {
            imageView.setBackground(null);
            imageView.setBackground(this.f5580x.getResources().getDrawable(C2113R.drawable.anim_defraud_play_blue));
        }
        textView.setText(m207a(uploadStateInfo.getFileSize()) + "KB/" + m207a(uploadStateInfo.getFileSize()) + "KB");
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
    private long m207a(long j2) {
        return j2 / 1024;
    }
}
