package p388ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bean.CaseHistoryBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p388ui.view.swip.SwipBackLayout;
import util.C7264c1;
import util.C7274e1;
import util.C7292k1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class QRcodeActivity extends BaseActivity {

    @BindView(C2113R.id.iv_qrcode)
    ImageView mIvQrcode;

    @BindView(C2113R.id.tv_case_code)
    TextView mTvCaseCode;

    @BindView(C2113R.id.tv_case_name)
    TextView mTvCaseName;

    @BindView(C2113R.id.tv_close)
    TextView mTvClose;

    @BindView(C2113R.id.tv_date)
    TextView mTvDate;

    @BindView(C2113R.id.tv_number)
    TextView mTvNumber;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.QRcodeActivity$a */
    class RunnableC6453a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f22750a;

        /* renamed from: ui.activity.QRcodeActivity$a$a */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22752a;

            a(Bitmap bitmap) {
                this.f22752a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                QRcodeActivity.this.mIvQrcode.setImageBitmap(this.f22752a);
            }
        }

        RunnableC6453a(String str) {
            this.f22750a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap decodeResource = BitmapFactory.decodeResource(QRcodeActivity.this.getResources(), C2113R.mipmap.ic_police_logo);
            int m26285a = C7264c1.m26285a(QRcodeActivity.this, 240.0f);
            Bitmap m26333a = C7274e1.m26333a(this.f22750a, m26285a, m26285a, decodeResource);
            ImageView imageView = QRcodeActivity.this.mIvQrcode;
            if (imageView != null) {
                imageView.post(new a(m26333a));
            }
        }
    }

    private void createQRcode(String str) {
        new Thread(new RunnableC6453a(str)).start();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mTvTitle.setText("二维码");
        this.mTvClose.setVisibility(8);
        CaseHistoryBean.Rows rows = (CaseHistoryBean.Rows) getIntent().getSerializableExtra(C7292k1.f25391c);
        String id = rows.getId();
        String caseName = rows.getCaseName();
        String caseNumber = rows.getCaseNumber();
        String caseCategoryText = rows.getCaseCategoryText();
        if (TextUtils.isEmpty(caseNumber)) {
            this.mTvCaseCode.setText(AbstractC1191a.f2568g);
        } else {
            this.mTvCaseCode.setText("采集编号：" + caseNumber);
        }
        if (TextUtils.isEmpty(caseCategoryText)) {
            this.mTvNumber.setVisibility(8);
        } else {
            this.mTvNumber.setVisibility(0);
            this.mTvNumber.setText(caseCategoryText);
        }
        this.mTvCaseName.setText(caseName);
        this.mIvQrcode.setImageResource(C2113R.mipmap.ic_placeholder);
        if (TextUtils.isEmpty(id)) {
            C7331w1.m26688a("二维码数据有误");
            finish();
        } else {
            createQRcode(id);
            this.mTvDate.setText(rows.getCreateTime());
        }
    }

    @OnClick({C2113R.id.iv_back})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_qrcode;
    }
}
