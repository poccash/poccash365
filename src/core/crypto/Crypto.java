package core.crypto;

import pc365.kit.crypto.Pc365Crypto;
import pc365.kit.entity.Pc365ID;
import org.bouncycastle.jcajce.provider.digest.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Crypto {
  static final Pc365Crypto pc365Crypto = Pc365Crypto.getInstance();

  private Crypto() {
  } //never

  public static MessageDigest sha256() {
    return pc365Crypto.getSha256();
  }

  public static MessageDigest shabal256() {
    return pc365Crypto.getShabal256();
  }

  public static MessageDigest ripemd160() {
    return pc365Crypto.getRipeMD160();
  }

  public static MessageDigest md5() {// TODO unit test
    try {
      return MessageDigest.getInstance("MD5"); // TODO pc365kit4j integration
    } catch (NoSuchAlgorithmException e) {
      return new MD5.Digest();
    }
  }

  public static byte[] getPublicKey(String secretPhrase) {
    return pc365Crypto.getPublicKey(secretPhrase);
  }

  public static byte[] getPrivateKey(String secretPhrase) {
    return pc365Crypto.getPrivateKey(secretPhrase);
  }

  public static byte[] sign(byte[] message, String secretPhrase) {
      return pc365Crypto.sign(message, secretPhrase);
  }

  public static boolean verify(byte[] signature, byte[] message, byte[] publicKey, boolean enforceCanonical) {
      return pc365Crypto.verify(signature, message, publicKey, enforceCanonical);
  }

  public static byte[] aesEncrypt(byte[] plaintext, byte[] myPrivateKey, byte[] theirPublicKey) {
    return pc365Crypto.aesSharedEncrypt(plaintext, myPrivateKey, theirPublicKey);
  }

  public static byte[] aesEncrypt(byte[] plaintext, byte[] myPrivateKey, byte[] theirPublicKey, byte[] nonce) {
    return pc365Crypto.aesSharedEncrypt(plaintext, myPrivateKey, theirPublicKey, nonce);
  }

  public static byte[] aesDecrypt(byte[] ivCiphertext, byte[] myPrivateKey, byte[] theirPublicKey) {
    return pc365Crypto.aesSharedDecrypt(ivCiphertext, myPrivateKey, theirPublicKey);
  }

  public static byte[] aesDecrypt(byte[] ivCiphertext, byte[] myPrivateKey, byte[] theirPublicKey, byte[] nonce) {
    return pc365Crypto.aesSharedDecrypt(ivCiphertext, myPrivateKey, theirPublicKey, nonce);
  }

  public static byte[] getSharedSecret(byte[] myPrivateKey, byte[] theirPublicKey) {
    return pc365Crypto.getSharedSecret(myPrivateKey, theirPublicKey);
  }

  public static String rsEncode(long id) {
    return pc365Crypto.rsEncode(Pc365ID.fromLong(id));
  }

  public static long rsDecode(String rsString) {
    return pc365Crypto.rsDecode(rsString).getSignedLongId();
  }
}
