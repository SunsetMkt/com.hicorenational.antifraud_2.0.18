package ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bean.OssFileRequest;
import bean.Records;
import bean.aimedia.AiMedia;
import bean.aimedia.AudioCheckConfigType;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.umeng.socialize.common.SocializeConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import ui.activity.AIInspectReportActivity;
import ui.activity.AIVerifyActivity;
import ui.callview.AIVerifyAudioCallView;
import ui.presenter.AIVerifyAudioPresenter;
import ui.view.AudioPlayerView;
import ui.view.LoadingLottieView;
import util.a1;
import util.c2;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyAudioFragment extends BaseFragment implements AIVerifyAudioCallView, ui.callview.a {
    private boolean isFragmentHidden;

    @BindView(R.id.mAudioPlayerView)
    AudioPlayerView mAudioView;

    @BindView(R.id.mCheckBtn)
    TextView mCheckBtn;

    @BindView(R.id.mCheckLayout)
    FrameLayout mCheckLayout;

    @BindView(R.id.mLoadingView)
    LoadingLottieView mLoadingView;
    private AIVerifyAudioPresenter mPresenter;

    @BindView(R.id.mUnCheckLayout)
    LinearLayout mUnCheckLayout;

    @BindView(R.id.mUnCheckTipImg)
    ImageView mUnCheckTipImg;

    @BindView(R.id.mUnCheckTipTitle)
    TextView mUnCheckTipTitle;
    private List<LocalMedia> mAudioList = new ArrayList();
    private int count = 1;

    private AudioCheckConfigType getAiVerifyAudioConfig() {
        AiMedia aiMedia;
        String strB = c2.b(c2.L0);
        if (strB == null || strB.length() <= 0 || (aiMedia = (AiMedia) new com.google.gson.e().a(strB, AiMedia.class)) == null) {
            return null;
        }
        return aiMedia.getaudioCheckConfig();
    }

    private void initView() {
        this.mUnCheckTipImg.setImageResource(R.drawable.ic_upload_audio);
        this.mLoadingView.setLottieAnimation("sandy_loading.json");
        this.mLoadingView.setLottieLoop(true);
        this.mLoadingView.setDescText("\u97f3\u9891\u4f2a\u9020\u68c0\u6d4b\u4e2d");
        AudioCheckConfigType aiVerifyAudioConfig = getAiVerifyAudioConfig();
        if (aiVerifyAudioConfig != null) {
            this.mUnCheckTipTitle.setText("\u8bf7\u4e0a\u4f20\u5c0f\u4e8e" + aiVerifyAudioConfig.getaudioMinTime() + "\u5206\u949f\u7684\u4eba\u58f0\u97f3\u9891");
        }
    }

    private void startVerify() {
        this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_grey_22);
        this.mCheckBtn.setEnabled(false);
        if (this.mAudioList.size() > 0) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.c();
        }
        List<LocalMedia> list = this.mAudioList;
        if (list == null || list.size() <= 0) {
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("6");
        ossFileRequest.setFilePath(this.mAudioList.get(0).getPath());
        this.mPresenter.upAiAudioFileToOss(ossFileRequest);
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_ai_verify_audio;
    }

    @Override // ui.fragment.BaseFragment
    protected void initPage() {
        initView();
        this.mPresenter = new AIVerifyAudioPresenter(this.mActivity, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1023) {
            return;
        }
        List<LocalMedia> listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
        if (listObtainMultipleResult.size() > 0) {
            if (Build.VERSION.SDK_INT > 28) {
                this.mPresenter.changePath(listObtainMultipleResult);
            }
            AudioPlayerView audioPlayerView = this.mAudioView;
            if (audioPlayerView != null) {
                audioPlayerView.f();
            }
            long jE = a1.e(listObtainMultipleResult.get(0).getPath());
            if (getAiVerifyAudioConfig() != null) {
                if (r8.getaudioMinTime() > jE) {
                    e2.a("\u97f3\u9891\u8fc7\u77ed,\u8bf7\u91cd\u65b0\u9009\u62e9");
                    return;
                } else if (r8.getaudioMaxTime() < jE) {
                    e2.a("\u97f3\u9891\u8fc7\u957f,\u8bf7\u91cd\u65b0\u9009\u62e9");
                    return;
                }
            }
            this.mUnCheckLayout.setVisibility(8);
            this.mCheckLayout.setVisibility(0);
            this.mAudioList.clear();
            this.mAudioList.addAll(listObtainMultipleResult);
            this.mAudioView.setAudioFile(new File(this.mAudioList.get(0).getPath()));
            this.mAudioView.c();
            this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_blue_22);
            this.mCheckBtn.setEnabled(true);
        }
    }

    @Override // ui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LoadingLottieView loadingLottieView = this.mLoadingView;
        if (loadingLottieView != null) {
            loadingLottieView.clearAnimation();
        }
    }

    @Override // ui.callview.AIVerifyAudioCallView
    public void onError(String str) {
        ((AIVerifyActivity) this.mActivity).aiVerifyCountPresenter.checkAiVerifyCount();
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
        AudioPlayerView audioPlayerView = this.mAudioView;
        if (audioPlayerView != null) {
            audioPlayerView.f();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AudioPlayerView audioPlayerView = this.mAudioView;
        if (audioPlayerView != null) {
            audioPlayerView.b();
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

    @Override // ui.callview.AIVerifyAudioCallView
    public void onSuccess(String str) {
        try {
            if (isDetached() || getActivity() == null) {
                return;
            }
            boolean z = true;
            if (new JSONObject(str).getJSONObject("data").getInt("isAIGenerated") != 1) {
                z = false;
            }
            this.mLoadingView.b();
            this.mLoadingView.setVisibility(8);
            if (!this.isFragmentHidden) {
                Intent intent = new Intent(this.mActivity, (Class<?>) AIInspectReportActivity.class);
                Records records = new Records();
                records.setAIGenerated(z);
                records.setLocalFilePath(this.mAudioList.get(0).getPath());
                intent.putExtra(SocializeConstants.KEY_PLATFORM, records);
                intent.putExtra("verifyType", 4);
                startActivity(intent);
            }
            this.mAudioList.clear();
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

    @OnClick({R.id.mUploadImageLayout, R.id.mCheckBtn, R.id.frame_layout, R.id.ai_check_border})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.ai_check_border /* 2131296350 */:
            case R.id.frame_layout /* 2131296699 */:
            case R.id.mUploadImageLayout /* 2131297092 */:
                if (this.count <= 0) {
                    e2.a("\u5f53\u5929\u6b21\u6570\u5df2\u7ecf\u4f7f\u7528\u5b8c");
                } else {
                    this.mPresenter.selectAudio(this);
                }
                break;
            case R.id.mCheckBtn /* 2131297073 */:
                this.mUnCheckLayout.setVisibility(8);
                this.mCheckLayout.setVisibility(0);
                startVerify();
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
