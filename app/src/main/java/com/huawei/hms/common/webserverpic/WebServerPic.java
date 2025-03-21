package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* loaded from: classes.dex */
public class WebServerPic {
    public static final Parcelable.Creator<WebServerPic> CREATOR = new WebServerPicCreator();

    /* renamed from: a */
    private final Uri f7308a;

    /* renamed from: b */
    private final int f7309b;

    /* renamed from: c */
    private final int f7310c;

    public WebServerPic(Uri uri, int i2, int i3) throws IllegalArgumentException {
        this.f7308a = uri;
        this.f7309b = i2;
        this.f7310c = i3;
        if (uri == null) {
            throw new IllegalArgumentException("url is not able to be null");
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("width and height should be positive or 0");
        }
    }

    public final int getHeight() {
        return this.f7310c;
    }

    public final Uri getUrl() {
        return this.f7308a;
    }

    public final int getWidth() {
        return this.f7309b;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "Image %dx%d %s", Integer.valueOf(this.f7309b), Integer.valueOf(this.f7310c), this.f7308a.toString());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUrl(), i2, false);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public WebServerPic(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }
}
