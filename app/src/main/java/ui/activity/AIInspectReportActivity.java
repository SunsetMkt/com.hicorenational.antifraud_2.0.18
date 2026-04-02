package ui.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bean.Records;
import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.JzvdStd;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.common.SocializeConstants;
import java.io.File;
import java.util.HashMap;
import ui.view.AudioPlayerView;
import ui.view.FixedScrollbarEditText;
import util.i2;
import util.j2;
import util.n1;

/* JADX INFO: loaded from: classes2.dex */
public class AIInspectReportActivity extends BaseActivity {
    private int a = -1;

    @BindView(R.id.ai_image)
    ImageView aiImage;

    /* JADX INFO: renamed from: b */
    private Records f13030b;

    @BindView(R.id.ly_title_content)
    LinearLayout lyTitleContent;

    @BindView(R.id.mAudioDuration)
    TextView mAudioDuration;

    @BindView(R.id.mAudioFormat)
    TextView mAudioFormat;

    @BindView(R.id.mAudioPlayerView)
    AudioPlayerView mAudioPlayerView;

    @BindView(R.id.mAudioReport)
    LinearLayout mAudioReport;

    @BindView(R.id.mAudioSize)
    TextView mAudioSize;

    @BindView(R.id.mAudioWatermarkImg)
    ImageView mAudioWatermarkImg;

    @BindView(R.id.mImageFormat)
    TextView mImageFormat;

    @BindView(R.id.mImageReport)
    LinearLayout mImageReport;

    @BindView(R.id.mImageResolution)
    TextView mImageResolution;

    @BindView(R.id.mImageSize)
    TextView mImageSize;

    @BindView(R.id.inspect_flag_desc)
    TextView mInspectFlagDesc;

    @BindView(R.id.inspect_flag_image)
    ImageView mInspectFlagImage;

    @BindView(R.id.inspect_flag_result)
    TextView mInspectFlagResult;

    @BindView(R.id.mTextCount)
    TextView mTextCount;

    @BindView(R.id.mTextReport)
    LinearLayout mTextReport;

    @BindView(R.id.rl_title)
    RelativeLayout mTitleBg;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @BindView(R.id.mVideoDuration)
    TextView mVideoDuration;

    @BindView(R.id.mVideoFormat)
    TextView mVideoFormat;

    @BindView(R.id.mVideoReport)
    LinearLayout mVideoReport;

    @BindView(R.id.mVideoResolution)
    TextView mVideoResolution;

    @BindView(R.id.mVideoSize)
    TextView mVideoSize;

    @BindView(R.id.mEditText)
    FixedScrollbarEditText myEdittext;

    @BindView(R.id.video_view)
    JzvdStd videoView;

    class a implements i2.a {
        a() {
        }

        @Override // util.i2.a
        public void a(Bitmap bitmap) {
            AIInspectReportActivity.this.videoView.thumbImageView.setImageBitmap(bitmap);
        }

        @Override // util.i2.a
        public void onError(String str) {
        }
    }

    class b implements i2.a {
        b() {
        }

        @Override // util.i2.a
        public void a(Bitmap bitmap) {
            AIInspectReportActivity.this.videoView.thumbImageView.setImageBitmap(bitmap);
        }

        @Override // util.i2.a
        public void onError(String str) {
        }
    }

    private void a(int i2) {
        this.f13030b = (Records) getIntent().getSerializableExtra(SocializeConstants.KEY_PLATFORM);
        this.mTitleBg.setBackgroundColor(getResources().getColor(R.color.ai_verify_bg));
        this.mTvTitle.setTextSize(2, 18.0f);
        this.mTvTitle.setTypeface(null, 1);
        if (i2 == 1) {
            b();
            return;
        }
        if (i2 == 2) {
            d();
        } else if (i2 == 3) {
            c();
        } else {
            a();
        }
    }

    private void b() {
        this.mTvTitle.setText("\u56fe\u50cfAI\u68c0\u6d4b\u62a5\u544a");
        this.aiImage.setVisibility(0);
        this.videoView.setVisibility(8);
        this.mAudioPlayerView.setVisibility(8);
        this.myEdittext.setVisibility(8);
        this.mImageReport.setVisibility(0);
        this.mVideoReport.setVisibility(8);
        this.mTextReport.setVisibility(8);
        this.mAudioReport.setVisibility(8);
        Records records = this.f13030b;
        if (records != null) {
            if (records.isAIGenerated()) {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_false);
                this.mInspectFlagResult.setText(R.string.ai_inspect_image_false);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#C64416"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_false));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_false);
            } else {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_true);
                this.mInspectFlagResult.setText(R.string.ai_inspect_flag_true);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#008C7D"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_true));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_true);
            }
        }
        Records records2 = this.f13030b;
        if (records2 != null) {
            if (records2.getLocalFilePath() == null || this.f13030b.getLocalFilePath().length() <= 0 || !new File(this.f13030b.getLocalFilePath()).exists()) {
                if (this.f13030b.getOssFilePath() == null || this.f13030b.getOssFilePath().length() <= 0) {
                    return;
                }
                com.bumptech.glide.b.a(this.mActivity).a(this.f13030b.getOssFilePath()).a(this.aiImage);
                this.mImageFormat.setText(this.f13030b.getFileFormat());
                this.mImageSize.setText(util.j1.a(this.f13030b.getFileSize()));
                this.mImageResolution.setText(this.f13030b.getResolutionRatio());
                return;
            }
            String localFilePath = this.f13030b.getLocalFilePath();
            com.bumptech.glide.b.a(this.mActivity).a(this.f13030b.getLocalFilePath()).a(this.aiImage);
            this.mImageFormat.setText(util.j1.e(localFilePath));
            this.mImageSize.setText(util.j1.h(localFilePath));
            n1.a aVarA = util.n1.a(localFilePath);
            this.mImageResolution.setText(aVarA.b() + "*" + aVarA.a());
        }
    }

    private void c() {
        this.mTvTitle.setText("\u6587\u672cAI\u68c0\u6d4b\u62a5\u544a");
        this.aiImage.setVisibility(8);
        this.videoView.setVisibility(8);
        this.myEdittext.setVisibility(0);
        this.mAudioPlayerView.setVisibility(8);
        this.mImageReport.setVisibility(8);
        this.mVideoReport.setVisibility(8);
        this.mTextReport.setVisibility(0);
        this.mAudioReport.setVisibility(8);
        Records records = this.f13030b;
        if (records != null) {
            if (records.isAIGenerated()) {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_false);
                this.mInspectFlagResult.setText(R.string.ai_inspect_text_false);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#C64416"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_false));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_false);
            } else {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_true);
                this.mInspectFlagResult.setText(R.string.ai_inspect_flag_true);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#008C7D"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_true));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_true);
            }
        }
        Records records2 = this.f13030b;
        if (records2 == null || records2.getTextContent() == null || this.f13030b.getTextContent().length() <= 0) {
            return;
        }
        this.myEdittext.setText(this.f13030b.getTextContent().toString());
        this.mTextCount.setText(this.f13030b.getTextSize() + "");
    }

    private void d() {
        this.mTvTitle.setText("\u89c6\u9891AI\u68c0\u6d4b\u62a5\u544a");
        this.aiImage.setVisibility(8);
        this.videoView.setVisibility(0);
        this.mAudioPlayerView.setVisibility(8);
        this.myEdittext.setVisibility(8);
        this.mImageReport.setVisibility(8);
        this.mVideoReport.setVisibility(0);
        this.mTextReport.setVisibility(8);
        this.mAudioReport.setVisibility(8);
        Records records = this.f13030b;
        if (records != null) {
            if (records.isAIGenerated()) {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_false);
                this.mInspectFlagResult.setText(R.string.ai_inspect_video_false);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#C64416"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_false));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_false);
            } else {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_true);
                this.mInspectFlagResult.setText(R.string.ai_inspect_flag_true);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#008C7D"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_true));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_true);
            }
        }
        Records records2 = this.f13030b;
        if (records2 != null) {
            if (records2.getLocalFilePath() == null || this.f13030b.getLocalFilePath().length() <= 0 || !new File(this.f13030b.getLocalFilePath()).exists()) {
                if (this.f13030b.getOssFilePath() == null || this.f13030b.getOssFilePath().length() <= 0) {
                    return;
                }
                this.videoView.setUp(this.f13030b.getOssFilePath(), "");
                this.mVideoFormat.setText(this.f13030b.getFileFormat());
                this.mVideoSize.setText(util.j1.a(this.f13030b.getFileSize()));
                this.mVideoDuration.setText(this.f13030b.getDuration());
                this.mVideoResolution.setText(this.f13030b.getResolutionRatio());
                HashMap map = new HashMap();
                map.put(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
                map.put(HttpHeaders.RANGE, "bytes=0-");
                i2.a(this.mActivity).a(this.f13030b.getOssFilePath(), new b());
                return;
            }
            String localFilePath = this.f13030b.getLocalFilePath();
            this.videoView.setUp(localFilePath, "");
            this.mVideoFormat.setText(util.j1.e(localFilePath));
            this.mVideoSize.setText(util.j1.h(localFilePath));
            this.mVideoDuration.setText(j2.b(localFilePath));
            Size sizeE = j2.e(localFilePath);
            this.videoView.updateStartImage();
            this.mVideoResolution.setText(sizeE.getWidth() + "*" + sizeE.getHeight());
            i2.a(this.mActivity).a(localFilePath, new a());
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.a = getIntent().getIntExtra("verifyType", -1);
        a(this.a);
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AudioPlayerView audioPlayerView = this.mAudioPlayerView;
        if (audioPlayerView != null) {
            audioPlayerView.f();
        }
        JzvdStd jzvdStd = this.videoView;
        if (jzvdStd != null) {
            jzvdStd.reset();
        }
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.iv_back) {
            return;
        }
        finish();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_ai_inspect_report;
    }

    private void a() {
        this.mTvTitle.setText("\u97f3\u9891AI\u68c0\u6d4b\u62a5\u544a");
        this.aiImage.setVisibility(8);
        this.videoView.setVisibility(8);
        this.myEdittext.setVisibility(8);
        this.mAudioPlayerView.setVisibility(0);
        this.mImageReport.setVisibility(8);
        this.mVideoReport.setVisibility(8);
        this.mTextReport.setVisibility(8);
        this.mAudioReport.setVisibility(0);
        Records records = this.f13030b;
        if (records != null) {
            if (records.isAIGenerated()) {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_false);
                this.mInspectFlagResult.setText(R.string.ai_inspect_audio_false);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#C64416"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_false));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_false);
            } else {
                this.mInspectFlagImage.setImageResource(R.drawable.ic_inspect_flag_true);
                this.mInspectFlagResult.setText(R.string.ai_inspect_flag_true);
                this.mInspectFlagResult.setTextColor(Color.parseColor("#008C7D"));
                this.lyTitleContent.setBackground(getResources().getDrawable(R.drawable.shape_ai_inspection_report_top_true));
                this.mAudioWatermarkImg.setBackgroundResource(R.drawable.ic_watermark_true);
            }
        }
        Records records2 = this.f13030b;
        if (records2 != null) {
            if (records2.getLocalFilePath() != null && this.f13030b.getLocalFilePath().length() > 0) {
                File file = new File(this.f13030b.getLocalFilePath());
                if (file.exists()) {
                    String localFilePath = this.f13030b.getLocalFilePath();
                    this.mAudioPlayerView.setAudioFile(file);
                    this.mAudioFormat.setText(util.j1.e(localFilePath));
                    this.mAudioSize.setText(util.j1.h(localFilePath));
                    this.mAudioDuration.setText(util.a1.f(localFilePath));
                    return;
                }
            }
            if (this.f13030b.getOssFilePath() == null || this.f13030b.getOssFilePath().length() <= 0) {
                return;
            }
            this.mAudioPlayerView.setAudioUrl(this.f13030b.getOssFilePath());
            this.mAudioFormat.setText(this.f13030b.getFileFormat());
            this.mAudioSize.setText(util.j1.a(this.f13030b.getFileSize()));
            this.mAudioDuration.setText(this.f13030b.getDuration());
        }
    }
}
