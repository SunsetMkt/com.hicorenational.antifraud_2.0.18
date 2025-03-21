package adapter;

import android.text.TextUtils;
import bean.SmsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class SmsDeleteAdapter extends BaseQuickAdapter<SmsBean, BaseViewHolder> {
    public SmsDeleteAdapter(int i2, List<SmsBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, SmsBean smsBean) {
        baseViewHolder.m5211a(C2113R.id.tv_sms_phone, (CharSequence) smsBean.getSmsNum()).m5211a(C2113R.id.tv_time, (CharSequence) smsBean.getStringDate()).m5211a(C2113R.id.tv_sms_content, (CharSequence) smsBean.getSmsContent()).m5194a(C2113R.id.iv_edit).m5194a(C2113R.id.iv_clear);
        if (TextUtils.isEmpty(smsBean.getVictimTel())) {
            baseViewHolder.m5224c(C2113R.id.group_victim).setVisibility(8);
            return;
        }
        baseViewHolder.m5224c(C2113R.id.group_victim).setVisibility(0);
        baseViewHolder.m5211a(C2113R.id.tv_victim_phone, (CharSequence) ("收件人:" + smsBean.getVictimTel()));
    }
}
