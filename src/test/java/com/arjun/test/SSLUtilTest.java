package com.arjun.test;

import org.junit.Test;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class SSLUtilTest {

    @Test
    public void testCreateKeyStore() {
        try {
            KeyStore keyStore = SSLUtil.createRetrieveNewKeyStore();
            KeyPair keyPair = SSLUtil.generateKeyPair(keyStore);
            System.out.println("private key-" + keyPair.getPrivate().toString());
            System.out.println("public key-" + keyPair.getPublic().toString());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}
