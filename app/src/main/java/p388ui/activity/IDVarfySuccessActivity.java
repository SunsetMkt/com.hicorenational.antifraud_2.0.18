package p388ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import org.greenrobot.eventbus.C6049c;
import util.C7292k1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class IDVarfySuccessActivity extends BaseActivity {

    /* renamed from: a */
    String f22421a;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.tv_tips)
    TextView mTvTips;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("核实完成");
        this.f22421a = getIntent().getStringExtra(C7292k1.f25416k0);
        this.mTvTips.setText("恭喜您完成“身份核实”\n\n核实结果将传达给请求方" + this.f22421a);
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_idvrfy_start})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == C2113R.id.btn_idvrfy_start || id == C2113R.id.iv_back) {
            C6049c.m24987f().m25000d(new C7265a(39, null));
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_id_var_ok;
    }
}
