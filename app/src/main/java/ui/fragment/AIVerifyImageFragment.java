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
import bean.aimedia.ImageCheckConfigType;
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
import ui.callview.AIVerifyImageCallView;
import ui.presenter.AIVerifyImagePresenter;
import ui.view.LoadingLottieView;
import util.c2;
import util.e2;
import util.j1;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyImageFragment extends BaseFragment implements AIVerifyImageCallView, ui.callview.a {
    private boolean isFragmentHidden;

    @BindView(R.id.mCheckBtn)
    TextView mCheckBtn;

    @BindView(R.id.mCheckImage)
    ImageView mCheckImage;

    @BindView(R.id.mCheckLayout)
    FrameLayout mCheckLayout;

    @BindView(R.id.mLoadingView)
    LoadingLottieView mLoadingView;
    private AIVerifyImagePresenter mPresenter;

    @BindView(R.id.mUnCheckLayout)
    LinearLayout mUnCheckLayout;

    @BindView(R.id.mUnCheckTipImg)
    ImageView mUnCheckTipImg;

    @BindView(R.id.mUnCheckTipTitle)
    TextView mUnCheckTipTitle;
    private List<LocalMedia> mPicList = new ArrayList();
    private int count = 1;

    private ImageCheckConfigType getAiVerifyImageConfig() {
        AiMedia aiMedia;
        String strB = c2.b(c2.L0);
        if (strB == null || strB.length() <= 0 || (aiMedia = (AiMedia) new com.google.gson.e().a(strB, AiMedia.class)) == null) {
            return null;
        }
        return aiMedia.getimageCheckConfig();
    }

    private void initView() {
        this.mUnCheckTipImg.setImageResource(R.drawable.ic_upload_image);
        this.mLoadingView.setLottieAnimation("sandy_loading.json");
        this.mLoadingView.setLottieLoop(true);
        this.mLoadingView.setDescText("\u56fe\u50cf\u4f2a\u9020\u68c0\u6d4b\u4e2d");
        ImageCheckConfigType aiVerifyImageConfig = getAiVerifyImageConfig();
        if (aiVerifyImageConfig != null) {
            this.mUnCheckTipTitle.setText("\u8bf7\u4e0a\u4f20\u9ad8\u6e05\u56fe\u50cf\uff0c\u5927\u5c0f" + aiVerifyImageConfig.getMinSizeMb() + Constants.WAVE_SEPARATOR + aiVerifyImageConfig.getMaxSizeMb());
        }
    }

    private void startVerify() {
        this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_grey_22);
        this.mCheckBtn.setEnabled(false);
        if (this.mPicList.size() > 0) {
            this.mLoadingView.setVisibility(0);
            this.mLoadingView.c();
        }
        List<LocalMedia> list = this.mPicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("6");
        ossFileRequest.setFilePath(this.mPicList.get(0).getPath());
        this.mPresenter.getOssAIToken(ossFileRequest);
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_ai_verify_image;
    }

    @Override // ui.fragment.BaseFragment
    protected void initPage() {
        initView();
        this.mPresenter = new AIVerifyImagePresenter(this.mActivity, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1021) {
            return;
        }
        List<LocalMedia> listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
        if (listObtainMultipleResult.size() > 0) {
            if (Build.VERSION.SDK_INT > 28) {
                this.mPresenter.changePath(listObtainMultipleResult);
            }
            double dG = j1.g(listObtainMultipleResult.get(0).getPath());
            if (getAiVerifyImageConfig() != null) {
                if (dG < r8.getminSize()) {
                    e2.a("\u56fe\u50cf\u8fc7\u5c0f,\u8bf7\u91cd\u65b0\u9009\u62e9");
                    return;
                } else if (dG > r8.getmaxSize()) {
                    e2.a("\u56fe\u50cf\u8fc7\u5927,\u8bf7\u91cd\u65b0\u9009\u62e9");
                    return;
                }
            }
            this.mUnCheckLayout.setVisibility(8);
            this.mCheckLayout.setVisibility(0);
            this.mPicList.clear();
            this.mPicList.addAll(listObtainMultipleResult);
            com.bumptech.glide.b.a(this.mActivity).a(this.mPicList.get(0).getPath()).a(this.mCheckImage);
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

    @Override // ui.callview.AIVerifyImageCallView
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
        if (z) {
            return;
        }
        ((AIVerifyActivity) this.mActivity).setActivityBroadCastFragment(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
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

    @Override // ui.callview.AIVerifyImageCallView
    public void onSuccess(String str) {
        try {
            if (isDetached() || getActivity() == null) {
                return;
            }
            boolean z = new JSONObject(str).getJSONObject("data").getInt("isAIGenerated") == 1;
            this.mLoadingView.b();
            this.mLoadingView.setVisibility(8);
            if (!this.isFragmentHidden) {
                Intent intent = new Intent(this.mActivity, (Class<?>) AIInspectReportActivity.class);
                Records records = new Records();
                records.setAIGenerated(z);
                records.setLocalFilePath(this.mPicList.get(0).getPath());
                intent.putExtra(SocializeConstants.KEY_PLATFORM, records);
                intent.putExtra("verifyType", 1);
                startActivity(intent);
            }
            this.mPicList.clear();
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
            return;
        }
        int id = view.getId();
        if (id == R.id.mCheckBtn) {
            startVerify();
            return;
        }
        if (id == R.id.mCheckLayout || id == R.id.mUploadImageLayout) {
            if (this.count > 0) {
                this.mPresenter.selectPicture(this);
            } else {
                e2.a("\u5f53\u5929\u6b21\u6570\u5df2\u7ecf\u4f7f\u7528\u5b8c");
            }
        }
    }

    @Override // ui.callview.a
    public void refreshUiCount(int i2) {
        this.count = i2;
        this.mCheckBtn.setBackgroundResource(i2 > 0 ? R.drawable.bg_radius_blue_22 : R.drawable.bg_radius_grey_22);
        this.mCheckBtn.setEnabled(i2 > 0);
    }
}
