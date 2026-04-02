package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import bean.Records;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.R;
import java.io.File;
import java.util.List;
import ui.view.AudioPlayerView;

/* JADX INFO: loaded from: classes.dex */
public class AIInspectRecordAdapter extends BaseQuickAdapter<Records, BaseViewHolder> {
    private Context V;

    public AIInspectRecordAdapter(List<Records> list, Context context) {
        super(R.layout.item_ai_inspect_record, list);
        this.V = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0144  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"CheckResult"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BaseViewHolder baseViewHolder, Records records) {
        ImageView imageView = (ImageView) baseViewHolder.c(R.id.mVerifyIcon);
        TextView textView = (TextView) baseViewHolder.c(R.id.mVerifyType);
        TextView textView2 = (TextView) baseViewHolder.c(R.id.mVerifyTime);
        ImageView imageView2 = (ImageView) baseViewHolder.c(R.id.mVerifyImage);
        ImageView imageView3 = (ImageView) baseViewHolder.c(R.id.video_view);
        TextView textView3 = (TextView) baseViewHolder.c(R.id.mEditText);
        AudioPlayerView audioPlayerView = (AudioPlayerView) baseViewHolder.c(R.id.mAudioPlayerView);
        ImageView imageView4 = (ImageView) baseViewHolder.c(R.id.img_watermark);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
        textView3.setVisibility(8);
        audioPlayerView.setVisibility(8);
        int i2 = !records.isAIGenerated() ? R.drawable.ic_ai_record_true : R.drawable.ic_ai_record_false;
        int checkType = records.getCheckType();
        if (checkType == 1) {
            imageView2.setVisibility(0);
            imageView.setImageResource(R.drawable.ic_ai_record_image);
            textView.setText(this.V.getResources().getString(R.string.ai_verify_type_image));
            if (records.getLocalFilePath() != null && records.getLocalFilePath().length() > 0) {
                String localFilePath = records.getLocalFilePath();
                if (new File(localFilePath).exists()) {
                    com.bumptech.glide.b.e(this.V).a(localFilePath).a(imageView2);
                }
            } else if (records.getOssFilePath() != null && records.getOssFilePath().length() > 0) {
                com.bumptech.glide.b.e(this.V).a(records.getOssFilePath()).a(imageView2);
            }
        } else if (checkType == 2) {
            imageView3.setVisibility(0);
            imageView.setImageResource(R.drawable.ic_ai_record_video);
            textView.setText(this.V.getResources().getString(R.string.ai_verify_type_video));
            imageView2.setVisibility(8);
            if (records.getLocalFilePath() != null && records.getLocalFilePath().length() > 0) {
                String localFilePath2 = records.getLocalFilePath();
                if (new File(localFilePath2).exists()) {
                    com.bumptech.glide.b.e(this.V).a(localFilePath2).a(imageView3);
                }
            } else if (records.getOssFilePath() != null && records.getOssFilePath().length() > 0) {
                com.bumptech.glide.b.e(this.V).a(records.getOssFilePath()).a(imageView3);
            }
        } else if (checkType == 3) {
            textView3.setVisibility(0);
            imageView.setImageResource(R.drawable.ic_ai_record_text);
            textView.setText(this.V.getResources().getString(R.string.ai_verify_type_text));
            imageView2.setVisibility(8);
            textView3.setText(records.getTextContent());
        } else if (checkType == 4) {
            audioPlayerView.setVisibility(0);
            imageView.setImageResource(R.drawable.ic_ai_record_audio);
            textView.setText(this.V.getResources().getString(R.string.ai_verify_type_audio));
            imageView2.setVisibility(8);
            if (records.getLocalFilePath() == null || records.getLocalFilePath().length() <= 0) {
                if (records.getOssFilePath() != null && records.getOssFilePath().length() > 0) {
                    audioPlayerView.setAudioUrl(records.getOssFilePath());
                }
                audioPlayerView.e();
            } else {
                File file = new File(records.getLocalFilePath());
                if (file.exists()) {
                    audioPlayerView.setAudioFile(file);
                    audioPlayerView.e();
                }
            }
        }
        textView2.setText(records.getCheckTime());
        imageView4.setBackgroundResource(i2);
    }
}
