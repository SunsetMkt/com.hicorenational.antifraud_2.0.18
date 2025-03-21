package com.bumptech.glide.load.p116o;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* renamed from: com.bumptech.glide.load.o.o */
/* loaded from: classes.dex */
public class C1615o extends AbstractC1612l<InputStream> {

    /* renamed from: e */
    private static final int f4236e = 1;

    /* renamed from: f */
    private static final int f4237f = 2;

    /* renamed from: g */
    private static final int f4238g = 3;

    /* renamed from: h */
    private static final int f4239h = 4;

    /* renamed from: i */
    private static final int f4240i = 5;

    /* renamed from: j */
    private static final UriMatcher f4241j = new UriMatcher(-1);

    static {
        f4241j.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f4241j.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f4241j.addURI("com.android.contacts", "contacts/#/photo", 2);
        f4241j.addURI("com.android.contacts", "contacts/#", 3);
        f4241j.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f4241j.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public C1615o(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* renamed from: b */
    private InputStream m3873b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f4241j.match(uri);
        if (match != 1) {
            if (match == 3) {
                return m3872a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return m3872a(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.p116o.AbstractC1612l
    /* renamed from: a */
    public InputStream mo3845a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream m3873b = m3873b(uri, contentResolver);
        if (m3873b != null) {
            return m3873b;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    /* renamed from: a */
    private InputStream m3872a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.p116o.AbstractC1612l
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo3847a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.p116o.InterfaceC1604d
    @NonNull
    /* renamed from: a */
    public Class<InputStream> mo3846a() {
        return InputStream.class;
    }
}
