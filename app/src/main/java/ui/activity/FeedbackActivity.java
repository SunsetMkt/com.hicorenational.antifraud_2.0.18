package ui.activity;

import adapter.FeedbackSelectAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.FeedbackTagBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.LoginManager;
import network.FeedbackInfo;
import ui.callview.FeedbackCallView;
import ui.presenter.FeedbackPresenter;
import ui.view.MyEdittext;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class FeedbackActivity extends BaseActivity implements FeedbackCallView, FeedbackSelectAdapter.b, BaseQuickAdapter.i {
    public static final int CODE_PREVIEW = 1001;

    @BindView(R.id.confirm)
    TextView mConfirm;

    @BindView(R.id.et_describe)
    MyEdittext mEtDescribe;

    @BindView(R.id.flow_layout)
    TagFlowLayout mFlowLayout;

    @BindView(R.id.phone)
    EditText mPhone;
    private FeedbackPresenter mPresenter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int mMaxCount = 300;
    private List<FeedbackTagBean> mTagList = new ArrayList();
    protected com.zhy.view.flowlayout.b mTagAdapter = null;
    private int tagCode = 0;
    private String tagName = "";
    private int oldPosition = -1;
    private int TAG1401 = 1000;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private FeedbackSelectAdapter mAdapter = null;
    private int previewPosition = -1;
    private int mMaxSelectNum = 6;

    class a extends com.zhy.view.flowlayout.b<FeedbackTagBean> {

        /* JADX INFO: renamed from: d */
        final /* synthetic */ int f13358d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ int f13359e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, int i2, int i3) {
            super(list);
            this.f13358d = i2;
            this.f13359e = i3;
        }

        @Override // com.zhy.view.flowlayout.b
        public View a(FlowLayout flowLayout, int i2, FeedbackTagBean feedbackTagBean) {
            TextView textView = new TextView(FeedbackActivity.this);
            textView.setId(FeedbackActivity.this.TAG1401);
            textView.setGravity(17);
            textView.setText(feedbackTagBean.getText());
            textView.setTextSize(14.0f);
            textView.setPadding(0, util.g1.a(R.dimen.dp5), 0, util.g1.a(R.dimen.dp5));
            textView.setBackgroundResource(R.drawable.shape_gray_feedback);
            textView.setTextColor(FeedbackActivity.this.getResources().getColorStateList(R.color._525B71));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f13358d, -2);
            int i3 = this.f13359e;
            layoutParams.setMargins(i3, 10, i3, 10);
            textView.setLayoutParams(layoutParams);
            return textView;
        }
    }

    class b implements TagFlowLayout.c {
        b() {
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.c
        public boolean a(View view, int i2, FlowLayout flowLayout) {
            TextView textView = (TextView) view.findViewById(FeedbackActivity.this.TAG1401);
            FeedbackTagBean feedbackTagBean = (FeedbackTagBean) FeedbackActivity.this.mTagList.get(i2);
            if (i2 == FeedbackActivity.this.oldPosition) {
                FeedbackActivity.this.tagCode = 0;
                FeedbackActivity.this.tagName = "";
                FeedbackActivity.this.oldPosition = -1;
                textView.setTextColor(FeedbackActivity.this.getResources().getColorStateList(R.color._525B71));
            } else {
                int code = feedbackTagBean.getCode();
                String text = feedbackTagBean.getText();
                FeedbackActivity.this.tagCode = code;
                FeedbackActivity.this.tagName = text;
                if (FeedbackActivity.this.oldPosition != -1) {
                    FeedbackActivity feedbackActivity = FeedbackActivity.this;
                    ((TextView) feedbackActivity.mFlowLayout.getChildAt(feedbackActivity.oldPosition).findViewById(FeedbackActivity.this.TAG1401)).setTextColor(FeedbackActivity.this.getResources().getColorStateList(R.color._525B71));
                }
                FeedbackActivity.this.oldPosition = i2;
                textView.setTextColor(FeedbackActivity.this.getResources().getColorStateList(R.color._3048FF));
            }
            if (TextUtils.isEmpty(FeedbackActivity.this.mEtDescribe.getText().toString()) || FeedbackActivity.this.oldPosition == -1) {
                FeedbackActivity.this.mConfirm.setEnabled(false);
            } else {
                FeedbackActivity.this.mConfirm.setEnabled(true);
            }
            return true;
        }
    }

    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable.toString().replace(d.c.a.b.a.a.f10074g, ""))) {
                FeedbackActivity.this.mConfirm.setEnabled(false);
                return;
            }
            if (editable.length() > FeedbackActivity.this.mMaxCount) {
                FeedbackActivity feedbackActivity = FeedbackActivity.this;
                feedbackActivity.mEtDescribe.setText(editable.subSequence(0, feedbackActivity.mMaxCount));
                FeedbackActivity.this.mEtDescribe.requestFocus();
                FeedbackActivity feedbackActivity2 = FeedbackActivity.this;
                feedbackActivity2.mEtDescribe.setSelection(feedbackActivity2.mMaxCount);
            }
            if (FeedbackActivity.this.oldPosition != -1) {
                FeedbackActivity.this.mConfirm.setEnabled(true);
            } else {
                FeedbackActivity.this.mConfirm.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class d implements PermissionsListener {
        d() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(FeedbackActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            k.e.a(FeedbackActivity.this.mActivity, 200L, PictureMimeType.ofImage(), FeedbackActivity.this.mMaxSelectNum - FeedbackActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void checkPermission() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new d());
    }

    private void confirm() {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        String strTrim = this.mEtDescribe.getText().toString().trim();
        String strTrim2 = this.mPhone.getText().toString().trim();
        if (TextUtils.isEmpty(strTrim2)) {
            strTrim2 = "";
        }
        FeedbackInfo feedbackInfo = new FeedbackInfo();
        feedbackInfo.setContent(strTrim);
        feedbackInfo.setMobileNumber(strTrim2);
        feedbackInfo.setClassifyCode(this.tagCode);
        this.mPresenter.confirmFeedback(feedbackInfo, this.mLocalMedia);
        showProgressDialog("\u63d0\u4ea4\u4e2d...");
    }

    private void initListener() {
        util.h1.a(this.mEtDescribe, this.mMaxCount);
        this.mEtDescribe.addTextChangedListener(new c());
    }

    private void initRecycle() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new FeedbackSelectAdapter(R.layout.recyclerview_feedback, this.mLocalMedia, this.mMaxSelectNum, null);
        this.mAdapter.a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(this);
        this.mAdapter.setOnItemChildClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    private void initTag() {
        this.mTagList.add(new FeedbackTagBean("\u529f\u80fd\u5f02\u5e38", 1));
        this.mTagList.add(new FeedbackTagBean("\u4ea7\u54c1\u5efa\u8bae", 2));
        this.mTagList.add(new FeedbackTagBean("\u6211\u8981\u5410\u69fd", 3));
        this.mTagList.add(new FeedbackTagBean("\u5176\u4ed6\u95ee\u9898", 0));
        if (this.mTagAdapter == null) {
            int i2 = getResources().getDisplayMetrics().widthPixels;
            int iA = util.g1.a(R.dimen.dp_74);
            int iA2 = i2 - util.g1.a(R.dimen.dp_30);
            int i3 = iA2 / iA;
            int i4 = iA2 % iA;
            if (i4 == 0) {
                i3--;
                i4 = iA;
            }
            this.mTagAdapter = new a(this.mTagList, iA, i4 / (i3 * 2));
        }
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new b());
    }

    public void deleteDoubleElement(List<LocalMedia> list, List<LocalMedia> list2, LocalMedia localMedia) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list2 == null || (list2.size() <= 0 && localMedia != null)) {
            list2 = new ArrayList<>();
            list2.add(localMedia);
        }
        Iterator<LocalMedia> it = list2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            LocalMedia next = it.next();
            if (list.size() > 0) {
                for (LocalMedia localMedia2 : list) {
                    if (!next.getPath().equals(localMedia2.getPath())) {
                        if (Build.VERSION.SDK_INT > 28) {
                            try {
                                String path = localMedia2.getPath();
                                String path2 = next.getPath();
                                if (util.t1.a(new File(path)).equals(util.t1.a(new File(path2)))) {
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    z = true;
                }
                if (!z) {
                    next.setChecked(true);
                    list.add(next);
                }
            } else {
                next.setChecked(true);
                list.add(next);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocalMedia localMedia3 = list.get(i2);
            if (localMedia3.isChecked()) {
                localMedia3.setChecked(false);
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u610f\u89c1\u53cd\u9988");
        this.mPresenter = new FeedbackPresenter(this.mActivity, this);
        initTag();
        initListener();
        initRecycle();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        List<LocalMedia> listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(listObtainMultipleResult);
        }
        deleteDoubleElement(this.mLocalMedia, listObtainMultipleResult, null);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != R.id.iv_clear) {
            return;
        }
        this.mLocalMedia.remove(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // adapter.FeedbackSelectAdapter.b
    public void onItemClickListener(int i2, List<LocalMedia> list) {
        if (isDouble()) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = (ArrayList) list;
        if (i2 == arrayList.size()) {
            checkPermission();
            return;
        }
        this.previewPosition = i2;
        String path = ((LocalMedia) arrayList.get(i2)).getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f13585f, arrayList);
        intent.putExtra(PreviewPictureActivity.f13586g, i2);
        intent.putExtra(PreviewPictureActivity.f13587h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f13588i, path);
        startActivityForResult(intent, 1001);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    @OnClick({R.id.iv_back, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            confirm();
        } else {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        }
    }

    @Override // ui.callview.FeedbackCallView
    public void onfail() {
        e2.a("\u7f51\u7edc\u5f02\u5e38,\u63d0\u4ea4\u5931\u8d25~");
        hideProgressDialog();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_feedback;
    }
}
