package ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bean.OssFileRequest;
import bean.Records;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.common.SocializeConstants;
import org.json.JSONObject;
import ui.activity.AIInspectReportActivity;
import ui.activity.AIVerifyActivity;
import ui.callview.AIVerifyTextCallView;
import ui.presenter.AIVerifyTextPresenter;
import ui.view.FixedScrollbarEditText;
import ui.view.LoadingLottieView;
import util.c2;
import util.e2;
import util.j1;

/* JADX INFO: loaded from: classes2.dex */
public class AIVerifyTextFragment extends BaseFragment implements AIVerifyTextCallView, ui.callview.a {

    @BindView(R.id.ai_check_border)
    ConstraintLayout aiCheckBorder;
    private AIVerifyTextPresenter aiVerifyTextPresenter;
    private boolean isFragmentHidden;

    @BindView(R.id.mCheckBtn)
    TextView mCheckBtn;

    @BindView(R.id.mEditText)
    FixedScrollbarEditText mEditText;

    @BindView(R.id.mLoadingView)
    LoadingLottieView mLoadingView;

    @BindView(R.id.mTextCount)
    TextView mTextCount;

    @BindView(R.id.mTextCountLayout)
    LinearLayout mTextCountLayout;
    private boolean isProcessing = false;
    private int maxCharacters = 5000;
    private int count = 1;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (AIVerifyTextFragment.this.isProcessing || editable == null) {
                return;
            }
            String string = editable.toString();
            AIVerifyTextFragment.this.isProcessing = true;
            try {
                String strLimitText = AIVerifyTextFragment.this.limitText(string);
                int iCountActualCharacters = AIVerifyTextFragment.this.countActualCharacters(strLimitText);
                editable.replace(0, editable.length(), strLimitText);
                AIVerifyTextFragment.this.mEditText.setSelection(editable.length());
                AIVerifyTextFragment.this.updateCounter(iCountActualCharacters);
            } finally {
                AIVerifyTextFragment.this.isProcessing = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int countActualCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String limitText(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (!Character.isWhitespace(cCharAt)) {
                if (i2 >= this.maxCharacters) {
                    break;
                }
                sb.append(cCharAt);
                i2++;
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private void startVerify() {
        this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_grey_22);
        this.mCheckBtn.setEnabled(false);
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.c();
        String string = this.mEditText.getText().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String path = getContext().getExternalCacheDir().getPath();
        j1.a(path, "textverify.txt", string);
        String str = path + "/textverify.txt";
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("6");
        ossFileRequest.setFilePath(str);
        this.aiVerifyTextPresenter.upAiTextFileToOss(ossFileRequest, countActualCharacters(limitText(this.mEditText.getText().toString())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCounter(int i2) {
        TextView textView = this.mTextCount;
        if (textView == null) {
            return;
        }
        textView.setText(i2 + "");
        if (i2 > 0) {
            this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_blue_22);
            this.mCheckBtn.setEnabled(true);
        } else {
            this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_grey_22);
            this.mCheckBtn.setEnabled(false);
        }
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_ai_verify_text;
    }

    @Override // ui.fragment.BaseFragment
    @SuppressLint({"ClickableViewAccessibility"})
    protected void initPage() {
        this.aiVerifyTextPresenter = new AIVerifyTextPresenter(this.mActivity, this);
        this.mLoadingView.setLottieAnimation("loading.json");
        this.mLoadingView.setLottieAnimation("sandy_loading.json");
        this.mLoadingView.setLottieLoop(true);
        this.mLoadingView.setDescText("\u6587\u672c\u4f2a\u9020\u68c0\u6d4b\u4e2d");
        this.aiCheckBorder.setVisibility(8);
        this.mEditText.setVerticalScrollBarEnabled(true);
        this.mEditText.setScrollbarFadingEnabled(false);
        this.mEditText.addTextChangedListener(new a());
    }

    @Override // ui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LoadingLottieView loadingLottieView = this.mLoadingView;
        if (loadingLottieView != null) {
            loadingLottieView.clearAnimation();
        }
    }

    @Override // ui.callview.AIVerifyTextCallView
    public void onError(String str) {
        e2.a(str);
        this.mLoadingView.b();
        this.mLoadingView.setVisibility(8);
        ((AIVerifyActivity) this.mActivity).aiVerifyCountPresenter.checkAiVerifyCount();
        this.mCheckBtn.setBackgroundResource(R.drawable.bg_radius_blue_22);
        this.mCheckBtn.setEnabled(true);
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

    @Override // ui.callview.AIVerifyTextCallView
    public void onSuccess(String str) {
        try {
            if (isDetached() || getActivity() == null) {
                return;
            }
            this.mLoadingView.b();
            this.mLoadingView.setVisibility(8);
            boolean z = true;
            if (new JSONObject(str).getJSONObject("data").getInt("isAIGenerated") != 1) {
                z = false;
            }
            if (!this.isFragmentHidden) {
                Intent intent = new Intent(this.mActivity, (Class<?>) AIInspectReportActivity.class);
                Records records = new Records();
                records.setAIGenerated(z);
                records.setTextContent(this.mEditText.getText().toString());
                records.setTextSize(countActualCharacters(limitText(this.mEditText.getText().toString())) + "");
                intent.putExtra(SocializeConstants.KEY_PLATFORM, records);
                intent.putExtra("verifyType", 3);
                startActivity(intent);
            }
            this.mEditText.setText("");
            this.aiCheckBorder.setVisibility(8);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (isDetached() || getActivity() == null) {
                return;
            }
            this.mLoadingView.b();
            this.mLoadingView.setVisibility(8);
        }
    }

    @OnClick({R.id.mCheckBtn})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.mCheckBtn) {
            if (this.count <= 0) {
                e2.a("\u5f53\u5929\u6b21\u6570\u5df2\u7ecf\u4f7f\u7528\u5b8c");
            } else {
                this.aiCheckBorder.setVisibility(0);
                startVerify();
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
