package anet.channel.request;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* renamed from: anet.channel.request.a */
/* loaded from: classes.dex */
final class C0802a implements Parcelable.Creator<ByteArrayEntry> {
    C0802a() {
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteArrayEntry createFromParcel(Parcel parcel) {
        byte[] bArr;
        ByteArrayEntry byteArrayEntry = new ByteArrayEntry((C0802a) null);
        byteArrayEntry.bytes = new byte[parcel.readInt()];
        bArr = byteArrayEntry.bytes;
        parcel.readByteArray(bArr);
        byteArrayEntry.offset = parcel.readInt();
        byteArrayEntry.count = parcel.readInt();
        byteArrayEntry.contentType = parcel.readString();
        return byteArrayEntry;
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteArrayEntry[] newArray(int i2) {
        return new ByteArrayEntry[i2];
    }
}
