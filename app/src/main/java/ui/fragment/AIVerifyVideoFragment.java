package ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.OssFileRequest;
import bean.Records;
import bean.aimedia.AiMedia;
import bean.aimedia.VideoCheckConfigType;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.umeng.socialize.common.SocializeConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import ui.activity.AIInspectReportActivity;
import ui.activity.AIVerifyActivity;
import ui.callview.AIVerifyVideoCallView;
import ui.presenter.AIVerifyVideoPresenter;
import ui.view.LoadingLottieView;
import ui.view.VideoTouchView;
import util.c2;
import util.e2;
import util.j1;
import util.j2;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyVideoFragment extends BaseFragment implements AIVerifyVideoCallView, ui.callview.a {

    @BindView(R.id.clickVideoView)
    View clickVideoView;
    private boolean isFragmentHidden;

    @BindView(R.id.mCheckBtn)
    TextView mCheckBtn;

    @BindView(R.id.mCheckLayout)
    FrameLayout mCheckLayout;

    @BindView(R.id.mLoadingView)
    LoadingLottieView mLoadingView;
    private AIVerifyVideoPresenter mPresenter;

    @BindView(R.id.mUnCheckLayout)
    LinearLayout mUnCheckLayout;

    @BindView(R.id.mUnCheckTipImg)
    ImageView mUnCheckTipImg;

    @BindView(R.id.mUnCheckTipTitle)
    TextView mUnCheckTipTitle;

    @BindView(R.id.mVideoPlayer)
    VideoTouchView mVideoPlayer;
    private List<LocalMedia> mVideoList = new ArrayList();
    private int count = 1;

    class a implements VideoTouchView.b {
        a() {
        }

        @Override // ui.view.VideoTouchView.b
        public void a() {
            AIVerifyVideoFragment.this.mPresenter.selectVideo(AIVerifyVideoFragment.this);
        }
    }

    private VideoCheckConfigType getAiVerifyVideoConfig() {
        AiMedia aiMedia;
        String strB = c2.b(c2.L0);
        if (strB == null || strB.length() <= 0 || (aiMedia = (AiMedia) new com.google.gson.e().a(strB, AiMedia.class)) == null) {
            return null;
        }
        return aiMedia.getvideoCheckConfig();
    }

    private void initView() {
        this.mUnCheckTipImg.setImageResource(R.drawable.ic_upload_video);
        this.mLoadingView.setLottieAnimation("sandy_loading.json");
        this.mLoadingView.setLottieLoop(true);
        this.mLoadingView.setDescText("\u89c6\u9891\u4f2a\u9020\u68c0\u6d4b\u4e2d");
        VideoCheckConfigType aiVerifyVideoConfig = getAiVerifyVideoConfig();
        if (aiVerifyVideoConfig != null) {
            this.mUnCheckTipTitle.setText("\u8bf7\u4e0a\u4f20\u9ad8\u6e05\u89c6\u9891,\u5927\u5c0f" + aiVerifyVideoConfig.getMinSizeMb() + Constants.WAVE_SEPARATOR + aiVerifyVideoConfig.getMaxSizeMb());
        }
        this.mVideoPlayer.setCLickOnClickListener(new a());
    }

    private void startVerify() {
        this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_grey_22);
        this.mCheckBtn.setEnabled(false);
        if (this.mVideoList.size() > 0) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.c();
        }
        List<LocalMedia> list = this.mVideoList;
        if (list == null || list.size() <= 0) {
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("6");
        ossFileRequest.setFilePath(this.mVideoList.get(0).getPath());
        this.mPresenter.upAiVideoFileToOss(ossFileRequest);
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_ai_verify_video;
    }

    @Override // ui.fragment.BaseFragment
    protected void initPage() {
        initView();
        this.mPresenter = new AIVerifyVideoPresenter(this.mActivity, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1022) {
            return;
        }
        List<LocalMedia> listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
        if (listObtainMultipleResult.size() > 0) {
            if (Build.VERSION.SDK_INT > 28) {
                this.mPresenter.changePath(listObtainMultipleResult);
            }
            String path = listObtainMultipleResult.get(0).getPath();
            double dG = j1.g(path);
            long jD = j2.d(path);
            Size sizeE = j2.e(path);
            VideoCheckConfigType aiVerifyVideoConfig = getAiVerifyVideoConfig();
            if (aiVerifyVideoConfig != null) {
                if (dG < aiVerifyVideoConfig.getminSize()) {
                    e2.a("\u89c6\u9891\u8fc7\u5c0f,\u8bf7\u91cd\u65b0\u9009\u62e9");
                    return;
                }
                if (dG > aiVerifyVideoConfig.getmaxSize()) {
                    e2.a("\u89c6\u9891\u8fc7\u5927,\u8bf7\u91cd\u65b0\u9009\u62e9");
                    return;
                }
                if (aiVerifyVideoConfig.getvideoMinTime() > jD) {
                    e2.a("\u8bf7\u4e0a\u4f20\u8d85\u8fc7" + aiVerifyVideoConfig.getvideoMinTime() + "\u79d2\u7684\u89c6\u9891");
                    return;
                }
                if (aiVerifyVideoConfig.getvideoMinWidth() > sizeE.getWidth() || aiVerifyVideoConfig.getvideoMinWidth() > sizeE.getHeight()) {
                    e2.a("\u89c6\u9891\u5206\u8fa8\u7387\u8fc7\u4f4e,\u8bf7\u91cd\u65b0\u9009\u62e9");
                    return;
                }
            }
            this.mUnCheckLayout.setVisibility(8);
            this.mCheckLayout.setVisibility(0);
            this.mVideoList.clear();
            this.mVideoList.addAll(listObtainMultipleResult);
            this.mVideoPlayer.setUp(this.mVideoList.get(0).getPath(), "");
            this.mVideoPlayer.startVideo();
            this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_blue_22);
            this.mCheckBtn.setEnabled(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((AIVerifyActivity) this.mActivity).aiVerifyCountPresenter.checkAiVerifyCount();
    }

    @Override // ui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LoadingLottieView loadingLottieView = this.mLoadingView;
        if (loadingLottieView != null) {
            loadingLottieView.clearAnimation();
        }
        VideoTouchView videoTouchView = this.mVideoPlayer;
        if (videoTouchView != null) {
            videoTouchView.reset();
        }
    }

    @Override // ui.callview.AIVerifyVideoCallView
    public void onError(String str) {
        e2.a(str);
        this.mLoadingView.b();
        this.mLoadingView.setVisibility(8);
        this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_blue_22);
        this.mCheckBtn.setEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            ((AIVerifyActivity) this.mActivity).setActivityBroadCastFragment(this);
            return;
        }
        VideoTouchView videoTouchView = this.mVideoPlayer;
        if (videoTouchView != null) {
            videoTouchView.reset();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VideoTouchView videoTouchView = this.mVideoPlayer;
        if (videoTouchView != null) {
            videoTouchView.reset();
        }
        this.isFragmentHidden = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isFragmentHidden = false;
        String strA = c2.a("verifyCount", "");
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.count = Integer.parseInt(strA);
    }

    @Override // ui.callview.AIVerifyVideoCallView
    public void onSuccess(String str) {
        try {
            if (isDetached() || getActivity() == null) {
                return;
            }
            this.mLoadingView.b();
            this.mLoadingView.setVisibility(8);
            if (this.mVideoPlayer != null) {
                this.mVideoPlayer.reset();
            }
            boolean z = true;
            if (new JSONObject(str).getJSONObject("data").getInt("isAIGenerated") != 1) {
                z = false;
            }
            if (!this.isFragmentHidden) {
                Intent intent = new Intent(this.mActivity, (Class<?>) AIInspectReportActivity.class);
                Records records = new Records();
                records.setAIGenerated(z);
                records.setLocalFilePath(this.mVideoList.get(0).getPath());
                intent.putExtra(SocializeConstants.KEY_PLATFORM, records);
                intent.putExtra("verifyType", 2);
                startActivity(intent);
            }
            this.mVideoList.clear();
            this.mCheckLayout.setVisibility(8);
            this.mUnCheckLayout.setVisibility(0);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (isDetached() || getActivity() == null) {
                return;
            }
            this.mLoadingView.b();
            this.mLoadingView.setVisibility(8);
        }
    }

    @OnClick({R.id.mUploadImageLayout, R.id.mCheckLayout, R.id.mCheckBtn})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.mCheckBtn /* 2131297073 */:
                startVerify();
                break;
            case R.id.mCheckLayout /* 2131297075 */:
            case R.id.mUploadImageLayout /* 2131297092 */:
            case R.id.mVideoPlayer /* 2131297099 */:
                if (this.count <= 0) {
                    e2.a("\u5f53\u5929\u6b21\u6570\u5df2\u7ecf\u4f7f\u7528\u5b8c");
                } else {
                    this.mPresenter.selectVideo(this);
                }
                break;
        }
    }

    @Override // ui.callview.a
    public void refreshUiCount(int i2) {
        this.count = i2;
        this.mCheckBtn.setBackgroundResource(i2 > 0 ? R.drawable.bg_radius_blue_22 : R.drawable.bg_radius_grey_22);
        this.mCheckBtn.setEnabled(i2 > 0);
    }
}
