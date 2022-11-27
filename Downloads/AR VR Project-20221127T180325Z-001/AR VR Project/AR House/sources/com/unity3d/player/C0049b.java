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
public final class C0049b extends SSLSocketFactory {

    /* renamed from: c */
    private static volatile SSLSocketFactory f190c;

    /* renamed from: d */
    private static volatile X509TrustManager f191d;

    /* renamed from: e */
    private static final Object f192e = new Object[0];

    /* renamed from: f */
    private static final Object f193f = new Object[0];

    /* renamed from: g */
    private static final boolean f194g;

    /* renamed from: a */
    private final SSLSocketFactory f195a;

    /* renamed from: b */
    private final C0050a f196b = null;

    /* renamed from: com.unity3d.player.b$a */
    class C0050a implements HandshakeCompletedListener {
        public final void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
            SSLSession session = handshakeCompletedEvent.getSession();
            session.getCipherSuite();
            session.getProtocol();
            try {
                session.getPeerPrincipal().getName();
            } catch (SSLPeerUnverifiedException unused) {
            }
        }
    }

    /* renamed from: com.unity3d.player.b$b */
    public static abstract class C0051b implements X509TrustManager {

        /* renamed from: a */
        protected X509TrustManager f197a = C0049b.m147c();

        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f197a.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f197a.checkServerTrusted(x509CertificateArr, str);
        }

        public final X509Certificate[] getAcceptedIssuers() {
            return this.f197a.getAcceptedIssuers();
        }
    }

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 20) {
            z = true;
        }
        f194g = z;
    }

    private C0049b(C0051b[] bVarArr) {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, bVarArr, (SecureRandom) null);
        this.f195a = instance.getSocketFactory();
    }

    /* renamed from: a */
    private Socket m143a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            if (f194g) {
                SSLSocket sSLSocket = (SSLSocket) socket;
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            }
            C0050a aVar = this.f196b;
            if (aVar != null) {
                ((SSLSocket) socket).addHandshakeCompletedListener(aVar);
            }
        }
        return socket;
    }

    /* renamed from: a */
    public static SSLSocketFactory m144a(C0051b bVar) {
        if (bVar == null) {
            try {
                return m146b();
            } catch (Exception e) {
                C0057g.Log(5, "CustomSSLSocketFactory: Failed to create SSLSocketFactory (" + e.getMessage() + ")");
                return null;
            }
        } else {
            return new C0049b(new C0051b[]{bVar});
        }
    }

    /* renamed from: b */
    private static SSLSocketFactory m146b() {
        synchronized (f192e) {
            if (f190c != null) {
                SSLSocketFactory sSLSocketFactory = f190c;
                return sSLSocketFactory;
            }
            C0049b bVar = new C0049b((C0051b[]) null);
            f190c = bVar;
            return bVar;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static X509TrustManager m147c() {
        synchronized (f193f) {
            if (f191d != null) {
                X509TrustManager x509TrustManager = f191d;
                return x509TrustManager;
            }
            try {
                TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance.init((KeyStore) null);
                for (TrustManager trustManager : instance.getTrustManagers()) {
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager2 = (X509TrustManager) trustManager;
                        f191d = x509TrustManager2;
                        return x509TrustManager2;
                    }
                }
            } catch (Exception e) {
                C0057g.Log(5, "CustomSSLSocketFactory: Failed to find X509TrustManager (" + e.getMessage() + ")");
            }
        }
        return null;
    }

    public final Socket createSocket() {
        return m143a(this.f195a.createSocket());
    }

    public final Socket createSocket(String str, int i) {
        return m143a(this.f195a.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m143a(this.f195a.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        return m143a(this.f195a.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m143a(this.f195a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m143a(this.f195a.createSocket(socket, str, i, z));
    }

    public final String[] getDefaultCipherSuites() {
        return this.f195a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f195a.getSupportedCipherSuites();
    }
}
