package com.arjun.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class SSLUtil {

    private static final String DEFAULT_KEYSTORE = "/home/arjun/IdeaProjects/my-ssl-lib/src/main/resources/test.jks";

    private static final String DEFAULT_KEYSTORE_PASSWORD = "test";

    public static KeyStore createRetrieveNewKeyStore() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        File keyStoreFile = new File(DEFAULT_KEYSTORE);
        if (keyStoreFile.exists()) {
            System.out.println("Returning default keystore");
            keyStore.load(new FileInputStream(DEFAULT_KEYSTORE), DEFAULT_KEYSTORE_PASSWORD.toCharArray());
        } else {
            keyStoreFile.createNewFile();
            keyStore.load(null, "test".toCharArray());
            keyStore.store(new FileOutputStream(new File(DEFAULT_KEYSTORE)),DEFAULT_KEYSTORE_PASSWORD.toCharArray());
            System.out.println("New keystore created");
        }
        return keyStore;
    }

    public static KeyPair generateKeyPair(KeyStore keyStore) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG","SUN");
        keyPairGenerator.initialize(1024,sr);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }
}

