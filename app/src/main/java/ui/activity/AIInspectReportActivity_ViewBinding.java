package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.jzvd.JzvdStd;
import com.hicorenational.antifraud.R;
import ui.view.AudioPlayerView;
import ui.view.FixedScrollbarEditText;

/* JADX INFO: loaded from: classes2.dex */
public class AIInspectReportActivity_ViewBinding implements Unbinder {
    private AIInspectReportActivity a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f13031b;

    class a extends DebouncingOnClickListener {
        final /* synthetic */ AIInspectReportActivity a;

        a(AIInspectReportActivity aIInspectReportActivity) {
            this.a = aIInspectReportActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public AIInspectReportActivity_ViewBinding(AIInspectReportActivity aIInspectReportActivity) {
        this(aIInspectReportActivity, aIInspectReportActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AIInspectReportActivity aIInspectReportActivity = this.a;
        if (aIInspectReportActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        aIInspectReportActivity.mTitleBg = null;
        aIInspectReportActivity.mTvTitle = null;
        aIInspectReportActivity.mInspectFlagImage = null;
        aIInspectReportActivity.mInspectFlagResult = null;
        aIInspectReportActivity.mInspectFlagDesc = null;
        aIInspectReportActivity.mImageReport = null;
        aIInspectReportActivity.mVideoReport = null;
        aIInspectReportActivity.mTextReport = null;
        aIInspectReportActivity.mImageFormat = null;
        aIInspectReportActivity.mImageSize = null;
        aIInspectReportActivity.mImageResolution = null;
        aIInspectReportActivity.mVideoFormat = null;
        aIInspectReportActivity.mVideoSize = null;
        aIInspectReportActivity.mVideoDuration = null;
        aIInspectReportActivity.mVideoResolution = null;
        aIInspectReportActivity.mTextCount = null;
        aIInspectReportActivity.mAudioFormat = null;
        aIInspectReportActivity.mAudioSize = null;
        aIInspectReportActivity.mAudioDuration = null;
        aIInspectReportActivity.lyTitleContent = null;
        aIInspectReportActivity.mAudioReport = null;
        aIInspectReportActivity.mAudioWatermarkImg = null;
        aIInspectReportActivity.aiImage = null;
        aIInspectReportActivity.videoView = null;
        aIInspectReportActivity.mAudioPlayerView = null;
        aIInspectReportActivity.myEdittext = null;
        this.f13031b.setOnClickListener(null);
        this.f13031b = null;
    }

    @UiThread
    public AIInspectReportActivity_ViewBinding(AIInspectReportActivity aIInspectReportActivity, View view) {
        this.a = aIInspectReportActivity;
        aIInspectReportActivity.mTitleBg = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_title, "field 'mTitleBg'", RelativeLayout.class);
        aIInspectReportActivity.mTvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'mTvTitle'", TextView.class);
        aIInspectReportActivity.mInspectFlagImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.inspect_flag_image, "field 'mInspectFlagImage'", ImageView.class);
        aIInspectReportActivity.mInspectFlagResult = (TextView) Utils.findRequiredViewAsType(view, R.id.inspect_flag_result, "field 'mInspectFlagResult'", TextView.class);
        aIInspectReportActivity.mInspectFlagDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.inspect_flag_desc, "field 'mInspectFlagDesc'", TextView.class);
        aIInspectReportActivity.mImageReport = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mImageReport, "field 'mImageReport'", LinearLayout.class);
        aIInspectReportActivity.mVideoReport = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mVideoReport, "field 'mVideoReport'", LinearLayout.class);
        aIInspectReportActivity.mTextReport = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mTextReport, "field 'mTextReport'", LinearLayout.class);
        aIInspectReportActivity.mImageFormat = (TextView) Utils.findRequiredViewAsType(view, R.id.mImageFormat, "field 'mImageFormat'", TextView.class);
        aIInspectReportActivity.mImageSize = (TextView) Utils.findRequiredViewAsType(view, R.id.mImageSize, "field 'mImageSize'", TextView.class);
        aIInspectReportActivity.mImageResolution = (TextView) Utils.findRequiredViewAsType(view, R.id.mImageResolution, "field 'mImageResolution'", TextView.class);
        aIInspectReportActivity.mVideoFormat = (TextView) Utils.findRequiredViewAsType(view, R.id.mVideoFormat, "field 'mVideoFormat'", TextView.class);
        aIInspectReportActivity.mVideoSize = (TextView) Utils.findRequiredViewAsType(view, R.id.mVideoSize, "field 'mVideoSize'", TextView.class);
        aIInspectReportActivity.mVideoDuration = (TextView) Utils.findRequiredViewAsType(view, R.id.mVideoDuration, "field 'mVideoDuration'", TextView.class);
        aIInspectReportActivity.mVideoResolution = (TextView) Utils.findRequiredViewAsType(view, R.id.mVideoResolution, "field 'mVideoResolution'", TextView.class);
        aIInspectReportActivity.mTextCount = (TextView) Utils.findRequiredViewAsType(view, R.id.mTextCount, "field 'mTextCount'", TextView.class);
        aIInspectReportActivity.mAudioFormat = (TextView) Utils.findRequiredViewAsType(view, R.id.mAudioFormat, "field 'mAudioFormat'", TextView.class);
        aIInspectReportActivity.mAudioSize = (TextView) Utils.findRequiredViewAsType(view, R.id.mAudioSize, "field 'mAudioSize'", TextView.class);
        aIInspectReportActivity.mAudioDuration = (TextView) Utils.findRequiredViewAsType(view, R.id.mAudioDuration, "field 'mAudioDuration'", TextView.class);
        aIInspectReportActivity.lyTitleContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ly_title_content, "field 'lyTitleContent'", LinearLayout.class);
        aIInspectReportActivity.mAudioReport = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mAudioReport, "field 'mAudioReport'", LinearLayout.class);
        aIInspectReportActivity.mAudioWatermarkImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.mAudioWatermarkImg, "field 'mAudioWatermarkImg'", ImageView.class);
        aIInspectReportActivity.aiImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.ai_image, "field 'aiImage'", ImageView.class);
        aIInspectReportActivity.videoView = (JzvdStd) Utils.findRequiredViewAsType(view, R.id.video_view, "field 'videoView'", JzvdStd.class);
        aIInspectReportActivity.mAudioPlayerView = (AudioPlayerView) Utils.findRequiredViewAsType(view, R.id.mAudioPlayerView, "field 'mAudioPlayerView'", AudioPlayerView.class);
        aIInspectReportActivity.myEdittext = (FixedScrollbarEditText) Utils.findRequiredViewAsType(view, R.id.mEditText, "field 'myEdittext'", FixedScrollbarEditText.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.f13031b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(aIInspectReportActivity));
    }
}
