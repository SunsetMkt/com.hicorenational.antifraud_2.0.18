package adapter;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import bean.UploadStateInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import p388ui.Hicore;

/* loaded from: classes.dex */
public class AudioRecordDeleteAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

    /* renamed from: V */
    List<UploadStateInfo> f173V;

    /* renamed from: W */
    SimpleDateFormat f174W;

    public AudioRecordDeleteAdapter(int i2, List<LocalMedia> list) {
        super(i2, list);
    }

    /* renamed from: G */
    private SimpleDateFormat m213G() {
        if (this.f174W == null) {
            this.f174W = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
        }
        return this.f174W;
    }

    public AudioRecordDeleteAdapter(int i2, List<LocalMedia> list, List<UploadStateInfo> list2) {
        super(i2, list);
        this.f173V = list2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        super.onBindViewHolder((AudioRecordDeleteAdapter) baseViewHolder, i2);
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.img_defraud_play);
        if (this.f173V.get(i2).isPlayState()) {
            ((AnimationDrawable) imageView.getBackground()).start();
        } else {
            imageView.setBackground(null);
            imageView.setBackground(this.f5580x.getResources().getDrawable(C2113R.drawable.anim_defraud_play));
        }
        m214a((TextView) baseViewHolder.m5224c(C2113R.id.tv_upload_state), this.f173V.get(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo204a(com.chad.library.adapter.base.BaseViewHolder r7, com.luck.picture.lib.entity.LocalMedia r8) {
        /*
            r6 = this;
            java.lang.String r0 = r8.getPath()
            r1 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L20
            if (r3 != 0) goto L24
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L20
            r3.<init>(r0)     // Catch: java.lang.Exception -> L20
            boolean r0 = r3.exists()     // Catch: java.lang.Exception -> L20
            if (r0 == 0) goto L24
            long r4 = r3.length()     // Catch: java.lang.Exception -> L20
            long r1 = r3.lastModified()     // Catch: java.lang.Exception -> L20
            goto L25
        L20:
            r0 = move-exception
            r0.printStackTrace()
        L24:
            r4 = r1
        L25:
            java.text.SimpleDateFormat r0 = r6.m213G()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r0 = r0.format(r1)
            java.lang.String r8 = r8.getFileName()
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L3d
            java.lang.String r8 = ""
        L3d:
            r1 = 2131297431(0x7f090497, float:1.8212807E38)
            com.chad.library.adapter.base.BaseViewHolder r7 = r7.m5211a(r1, r8)
            r8 = 2131297710(0x7f0905ae, float:1.8213373E38)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = util.C7337y1.m26732a(r4)
            r1.append(r2)
            java.lang.String r2 = " | "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.chad.library.adapter.base.BaseViewHolder r7 = r7.m5211a(r8, r0)
            r8 = 2131296772(0x7f090204, float:1.821147E38)
            com.chad.library.adapter.base.BaseViewHolder r7 = r7.m5194a(r8)
            r8 = 2131296761(0x7f0901f9, float:1.8211448E38)
            r7.m5194a(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: adapter.AudioRecordDeleteAdapter.mo204a(com.chad.library.adapter.base.BaseViewHolder, com.luck.picture.lib.entity.LocalMedia):void");
    }

    /* renamed from: a */
    private void m214a(TextView textView, UploadStateInfo uploadStateInfo) {
        int uploadState = uploadStateInfo.getUploadState();
        if (uploadState == 0) {
            textView.setText("等待上传");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorGray));
            return;
        }
        if (uploadState == 1) {
            textView.setText("上传中");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.black_dark));
        } else if (uploadState == 2) {
            textView.setText("上传完成");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.blue));
        } else {
            if (uploadState != 3) {
                return;
            }
            textView.setText("上传失败");
            textView.setTextColor(Hicore.getApp().getResources().getColor(C2113R.color.colorRed));
        }
    }
}
