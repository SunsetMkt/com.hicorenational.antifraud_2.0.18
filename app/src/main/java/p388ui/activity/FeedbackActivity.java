package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhy.view.flowlayout.AbstractC4439b;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import interfaces.PermissionsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import manager.LoginManager;
import network.FeedbackInfo;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p357j.C5846e;
import p388ui.callview.FeedbackCallView;
import p388ui.presenter.FeedbackPresenter;
import p388ui.view.MyEdittext;
import util.C7264c1;
import util.C7268d1;
import util.C7304o1;
import util.C7331w1;
import util.permissionutil.C7308a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class FeedbackActivity extends BaseActivity implements FeedbackCallView, FeedbackSelectAdapter.InterfaceC0061b, BaseQuickAdapter.InterfaceC1895i {
    public static final int CODE_PREVIEW = 1001;

    @BindView(C2113R.id.confirm)
    TextView mConfirm;

    @BindView(C2113R.id.et_describe)
    MyEdittext mEtDescribe;

    @BindView(C2113R.id.flow_layout)
    TagFlowLayout mFlowLayout;

    @BindView(C2113R.id.phone)
    EditText mPhone;
    private FeedbackPresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;
    private int mMaxCount = 300;
    private List<FeedbackTagBean> mTagList = new ArrayList();
    protected AbstractC4439b mTagAdapter = null;
    private int tagCode = 0;
    private String tagName = "";
    private int oldPosition = -1;
    private int TAG1401 = 1000;
    private List<LocalMedia> mLocalMedia = new ArrayList();
    private FeedbackSelectAdapter mAdapter = null;
    private int previewPosition = -1;
    private int mMaxSelectNum = 6;

    /* renamed from: ui.activity.FeedbackActivity$a */
    class C6298a extends AbstractC4439b<FeedbackTagBean> {

        /* renamed from: d */
        final /* synthetic */ int f22297d;

        /* renamed from: e */
        final /* synthetic */ int f22298e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C6298a(List list, int i2, int i3) {
            super(list);
            this.f22297d = i2;
            this.f22298e = i3;
        }

        @Override // com.zhy.view.flowlayout.AbstractC4439b
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public View mo16383a(FlowLayout flowLayout, int i2, FeedbackTagBean feedbackTagBean) {
            TextView textView = new TextView(FeedbackActivity.this);
            textView.setId(FeedbackActivity.this.TAG1401);
            textView.setGravity(17);
            textView.setText(feedbackTagBean.getText());
            textView.setTextSize(14.0f);
            textView.setPadding(0, C7264c1.m26284a(C2113R.dimen.dp5), 0, C7264c1.m26284a(C2113R.dimen.dp5));
            textView.setBackgroundResource(C2113R.drawable.shape_gray_feedback);
            textView.setTextColor(FeedbackActivity.this.getResources().getColorStateList(C2113R.color._525B71));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f22297d, -2);
            int i3 = this.f22298e;
            layoutParams.setMargins(i3, 10, i3, 10);
            textView.setLayoutParams(layoutParams);
            return textView;
        }
    }

    /* renamed from: ui.activity.FeedbackActivity$b */
    class C6299b implements TagFlowLayout.InterfaceC4437c {
        C6299b() {
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.InterfaceC4437c
        /* renamed from: a */
        public boolean mo16381a(View view, int i2, FlowLayout flowLayout) {
            TextView textView = (TextView) view.findViewById(FeedbackActivity.this.TAG1401);
            FeedbackTagBean feedbackTagBean = (FeedbackTagBean) FeedbackActivity.this.mTagList.get(i2);
            if (i2 == FeedbackActivity.this.oldPosition) {
                FeedbackActivity.this.tagCode = 0;
                FeedbackActivity.this.tagName = "";
                FeedbackActivity.this.oldPosition = -1;
                textView.setTextColor(FeedbackActivity.this.getResources().getColorStateList(C2113R.color._525B71));
            } else {
                int code = feedbackTagBean.getCode();
                String text = feedbackTagBean.getText();
                FeedbackActivity.this.tagCode = code;
                FeedbackActivity.this.tagName = text;
                if (FeedbackActivity.this.oldPosition != -1) {
                    FeedbackActivity feedbackActivity = FeedbackActivity.this;
                    ((TextView) feedbackActivity.mFlowLayout.getChildAt(feedbackActivity.oldPosition).findViewById(FeedbackActivity.this.TAG1401)).setTextColor(FeedbackActivity.this.getResources().getColorStateList(C2113R.color._525B71));
                }
                FeedbackActivity.this.oldPosition = i2;
                textView.setTextColor(FeedbackActivity.this.getResources().getColorStateList(C2113R.color._3048FF));
            }
            if (TextUtils.isEmpty(FeedbackActivity.this.mEtDescribe.getText().toString()) || FeedbackActivity.this.oldPosition == -1) {
                FeedbackActivity.this.mConfirm.setEnabled(false);
            } else {
                FeedbackActivity.this.mConfirm.setEnabled(true);
            }
            return true;
        }
    }

    /* renamed from: ui.activity.FeedbackActivity$c */
    class C6300c implements TextWatcher {
        C6300c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable.toString().replace(AbstractC1191a.f2568g, ""))) {
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

    /* renamed from: ui.activity.FeedbackActivity$d */
    class C6301d implements PermissionsListener {
        C6301d() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            C7310c.m26513a(FeedbackActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            C5846e.m24617a(FeedbackActivity.this.mActivity, 200L, PictureMimeType.ofImage(), FeedbackActivity.this.mMaxSelectNum - FeedbackActivity.this.mLocalMedia.size()).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    private void checkPermission() {
        C7310c.m26518a(this.mActivity, new String[]{C7308a.f25547z}, new C6301d());
    }

    private void confirm() {
        if (LoginManager.getInstance().isLogOut()) {
            return;
        }
        String trim = this.mEtDescribe.getText().toString().trim();
        String trim2 = this.mPhone.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            trim2 = "";
        }
        FeedbackInfo feedbackInfo = new FeedbackInfo();
        feedbackInfo.setContent(trim);
        feedbackInfo.setMobileNumber(trim2);
        feedbackInfo.setClassifyCode(this.tagCode);
        this.mPresenter.confirmFeedback(feedbackInfo, this.mLocalMedia);
        showProgressDialog("提交中...");
    }

    private void initListener() {
        C7268d1.m26308a(this.mEtDescribe, this.mMaxCount);
        this.mEtDescribe.addTextChangedListener(new C6300c());
    }

    private void initRecycle() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        this.mAdapter = new FeedbackSelectAdapter(C2113R.layout.recyclerview_feedback, this.mLocalMedia, this.mMaxSelectNum, null);
        this.mAdapter.m5103a(this.mRecyclerview);
        this.mAdapter.setOnItemClickListener(this);
        this.mAdapter.setOnItemChildClickListener(this);
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    private void initTag() {
        this.mTagList.add(new FeedbackTagBean("功能异常", 1));
        this.mTagList.add(new FeedbackTagBean("产品建议", 2));
        this.mTagList.add(new FeedbackTagBean("我要吐槽", 3));
        this.mTagList.add(new FeedbackTagBean("其他问题", 0));
        if (this.mTagAdapter == null) {
            int i2 = getResources().getDisplayMetrics().widthPixels;
            int m26284a = C7264c1.m26284a(C2113R.dimen.dp_74);
            int m26284a2 = i2 - C7264c1.m26284a(C2113R.dimen.dp_30);
            int i3 = m26284a2 / m26284a;
            int i4 = m26284a2 % m26284a;
            if (i4 == 0) {
                i3--;
                i4 = m26284a;
            }
            this.mTagAdapter = new C6298a(this.mTagList, m26284a, i4 / (i3 * 2));
        }
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new C6299b());
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
                                if (C7304o1.m26466a(new File(path)).equals(C7304o1.m26466a(new File(path2)))) {
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

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("意见反馈");
        this.mPresenter = new FeedbackPresenter(this.mActivity, this);
        initTag();
        initListener();
        initRecycle();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        List<LocalMedia> obtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != 188 || (obtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || obtainMultipleResult.size() <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT > 28) {
            changePath(obtainMultipleResult);
        }
        deleteDoubleElement(this.mLocalMedia, obtainMultipleResult, null);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != C2113R.id.iv_clear) {
            return;
        }
        this.mLocalMedia.remove(i2);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // adapter.FeedbackSelectAdapter.InterfaceC0061b
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
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f22711f, arrayList);
        intent.putExtra(PreviewPictureActivity.f22712g, i2);
        intent.putExtra(PreviewPictureActivity.f22713h, arrayList.size());
        intent.putExtra(PreviewPictureActivity.f22714i, path);
        startActivityForResult(intent, 1001);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.confirm) {
            confirm();
        } else {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
        }
    }

    @Override // p388ui.callview.FeedbackCallView
    public void onfail() {
        C7331w1.m26688a("网络异常,提交失败~");
        hideProgressDialog();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_feedback;
    }
}
