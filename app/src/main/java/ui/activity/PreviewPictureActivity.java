package ui.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.photoview.PhotoView;
import com.luck.picture.lib.widget.PreviewViewPager;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewPictureActivity extends BaseActivity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13584e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13585f = "extra_pic";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13586g = "extra_position";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13587h = "extra_sum";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13588i = "extra_path";
    private TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PreviewViewPager f13589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList f13590c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<LocalMedia> f13591d;

    class a extends PagerAdapter {
        private List<View> a;

        public a(List<View> list) {
            this.a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.a.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            View view = this.a.get(i2);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.preview_image);
            k.b bVarA = k.b.a();
            PreviewPictureActivity previewPictureActivity = PreviewPictureActivity.this;
            bVarA.loadImage(previewPictureActivity.mActivity, ((LocalMedia) previewPictureActivity.f13591d.get(i2)).getPath(), photoView);
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, false);
        this.a = (TextView) findViewById(R.id.tv_title);
        this.f13589b = (PreviewViewPager) findViewById(R.id.view_pager);
        this.a.setText("\u9884\u89c8");
        a();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.picture_anim_fade_in, R.anim.picture_anim_exit);
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        if (!Hicore.getApp().isDouble() && view.getId() == R.id.iv_back) {
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        overridePendingTransition(R.anim.picture_anim_enter, R.anim.picture_anim_fade_in);
        return R.layout.dialog_preview_picture;
    }

    private void a() {
        this.f13591d = getIntent().getParcelableArrayListExtra(f13585f);
        List<LocalMedia> list = this.f13591d;
        if (list != null) {
            if (list.size() > 0) {
                a(getIntent().getIntExtra(f13586g, 0));
                return;
            } else {
                a(0);
                return;
            }
        }
        String stringExtra = getIntent().getStringExtra(f13588i);
        this.f13591d = new ArrayList();
        LocalMedia localMedia = new LocalMedia();
        localMedia.setPath(stringExtra);
        this.f13591d.add(localMedia);
        a(0);
    }

    private void a(int i2) {
        for (int i3 = 0; i3 < this.f13591d.size(); i3++) {
            this.f13590c.add(LayoutInflater.from(this).inflate(R.layout.pic_preview, (ViewGroup) null));
        }
        this.f13589b.setAdapter(new a(this.f13590c));
        this.f13589b.setCurrentItem(i2);
    }
}
