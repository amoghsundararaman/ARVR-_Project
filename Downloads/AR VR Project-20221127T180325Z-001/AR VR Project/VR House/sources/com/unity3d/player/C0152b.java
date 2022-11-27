package com.unity3d.player;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.unity3d.player.b */
public final class C0152b extends SSLSocketFactory {

    /* renamed from: c */
    private static volatile SSLSocketFactory f194c;

    /* renamed from: d */
    private static volatile X509TrustManager f195d;

    /* renamed from: e */
    private static final Object f196e = new Object[0];

    /* renamed from: f */
    private static final Object f197f = new Object[0];

    /* renamed from: g */
    private static final boolean f198g;

    /* renamed from: a */
    private final SSLSocketFactory f199a;

    /* renamed from: b */
    private final C0153a f200b = null;

    /* renamed from: com.unity3d.player.b$a */
    class C0153a implements HandshakeCompletedListener {
        public final void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
            SSLSession session = handshakeCompletedEvent.getSession();
            session.getCipherSuite();
            session.getProtocol();
            try {
                session.getPeerPrincipal().getName();
            } catch (SSLPeerUnverifiedException e) {
            }
        }
    }

    /* renamed from: com.unity3d.player.b$b */
    public static abstract class C0154b implements X509TrustManager {

        /* renamed from: a */
        protected X509TrustManager f201a = C0152b.m140c();

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f201a.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f201a.checkServerTrusted(x509CertificateArr, str);
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return this.f201a.getAcceptedIssuers();
        }
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 20) {
            z = true;
        }
        f198g = z;
    }

    private C0152b(C0154b[] bVarArr) {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, bVarArr, (SecureRandom) null);
        this.f199a = instance.getSocketFactory();
    }

    /* renamed from: a */
    private Socket m136a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            if (f198g) {
                ((SSLSocket) socket).setEnabledProtocols(((SSLSocket) socket).getSupportedProtocols());
            }
            if (this.f200b != null) {
                ((SSLSocket) socket).addHandshakeCompletedListener(this.f200b);
            }
        }
        return socket;
    }

    /* renamed from: a */
    public static SSLSocketFactory m137a(C0154b bVar) {
        if (bVar == null) {
            try {
                return m139b();
            } catch (Exception e) {
                C0160g.Log(5, "CustomSSLSocketFactory: Failed to create SSLSocketFactory (" + e.getMessage() + ")");
                return null;
            }
        } else {
            return new C0152b(new C0154b[]{bVar});
        }
    }

    /* renamed from: b */
    private static SSLSocketFactory m139b() {
        SSLSocketFactory bVar;
        synchronized (f196e) {
            if (f194c != null) {
                bVar = f194c;
            } else {
                bVar = new C0152b((C0154b[]) null);
                f194c = bVar;
            }
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static X509TrustManager m140c() {
        synchronized (f197f) {
            if (f195d != null) {
                X509TrustManager x509TrustManager = f195d;
                return x509TrustManager;
            }
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init((KeyStore) null);
                for (TrustManager trustManager : instance.getTrustManagers()) {
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager2 = (X509TrustManager) trustManager;
                        f195d = x509TrustManager2;
                        return x509TrustManager2;
                    }
                }
            } catch (Exception e) {
                C0160g.Log(5, "CustomSSLSocketFactory: Failed to find X509TrustManager (" + e.getMessage() + ")");
                return null;
            }
        }
    }

    public final Socket createSocket() {
        return m136a(this.f199a.createSocket());
    }

    public final Socket createSocket(String str, int i) {
        return m136a(this.f199a.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m136a(this.f199a.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return m136a(this.f199a.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m136a(this.f199a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m136a(this.f199a.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f199a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f199a.getSupportedCipherSuites();
    }
}
