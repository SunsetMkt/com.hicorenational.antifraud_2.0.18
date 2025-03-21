package p388ui.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.widget.PreviewViewPager;
import java.util.ArrayList;
import java.util.List;
import p357j.C5843b;
import p388ui.Hicore;
import p388ui.statusbarcompat.C7161b;

/* loaded from: classes2.dex */
public class PreviewPictureActivity extends BaseActivity {

    /* renamed from: e */
    public static final int f22710e = 1000;

    /* renamed from: f */
    public static final String f22711f = "extra_pic";

    /* renamed from: g */
    public static final String f22712g = "extra_position";

    /* renamed from: h */
    public static final String f22713h = "extra_sum";

    /* renamed from: i */
    public static final String f22714i = "extra_path";

    /* renamed from: a */
    private TextView f22715a;

    /* renamed from: b */
    private PreviewViewPager f22716b;

    /* renamed from: c */
    private ArrayList f22717c = new ArrayList();

    /* renamed from: d */
    private List<LocalMedia> f22718d;

    /* renamed from: ui.activity.PreviewPictureActivity$a */
    class C6440a extends PagerAdapter {

        /* renamed from: a */
        private List<View> f22719a;

        public C6440a(List<View> list) {
            this.f22719a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.f22719a.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f22719a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view = this.f22719a.get(i2);
            PhotoView photoView = (PhotoView) view.findViewById(C2113R.id.preview_image);
            C5843b m24586a = C5843b.m24586a();
            PreviewPictureActivity previewPictureActivity = PreviewPictureActivity.this;
            m24586a.loadImage(previewPictureActivity.mActivity, ((LocalMedia) previewPictureActivity.f22718d.get(i2)).getPath(), photoView);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C7161b.m25698a((Activity) this, true, false);
        this.f22715a = (TextView) findViewById(C2113R.id.tv_title);
        this.f22716b = (PreviewViewPager) findViewById(C2113R.id.view_pager);
        this.f22715a.setText("预览");
        m25306a();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(C2113R.anim.picture_anim_fade_in, C2113R.anim.picture_anim_exit);
    }

    @OnClick({C2113R.id.iv_back})
    public void onClick(View view) {
        if (!Hicore.getApp().isDouble() && view.getId() == C2113R.id.iv_back) {
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        overridePendingTransition(C2113R.anim.picture_anim_enter, C2113R.anim.picture_anim_fade_in);
        return C2113R.layout.dialog_preview_picture;
    }

    /* renamed from: a */
    private void m25306a() {
        this.f22718d = getIntent().getParcelableArrayListExtra(f22711f);
        List<LocalMedia> list = this.f22718d;
        if (list != null) {
            if (list.size() > 0) {
                m25307a(getIntent().getIntExtra(f22712g, 0));
                return;
            } else {
                m25307a(0);
                return;
            }
        }
        String stringExtra = getIntent().getStringExtra(f22714i);
        this.f22718d = new ArrayList();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(stringExtra);
        this.f22718d.add(localMedia);
        m25307a(0);
    }

    /* renamed from: a */
    private void m25307a(int i2) {
        for (int i3 = 0; i3 < this.f22718d.size(); i3++) {
            this.f22717c.add(LayoutInflater.from(this).inflate(C2113R.layout.pic_preview, (ViewGroup) null));
        }
        this.f22716b.setAdapter(new C6440a(this.f22717c));
        this.f22716b.setCurrentItem(i2);
    }
}
