package cn.utils;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.util.Base64;

/**
 * AES/CBC/PKCS5Padding 对称加密
 *
 * @author hbt
 */
public class AES {

    /**
     * 偏移量
     */
    public static final String IV = "SVB2ycTwoSHe5tdZ";
    /**
     * 密码
     */
    public static final String KEY = "YrGOn5ot2swsfeRv";

    private static final String ALGORITHM = "AES/CBC/PKCS7Padding";

    /**
     * 数据加密
     *
     * @param srcData
     * @return
     */
    public static String encrypt(String srcData) {
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher;
        String encoded = null;
        try {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(IV.getBytes()));
            byte[] bytes = cipher.doFinal(srcData.getBytes());
            encoded = Base64.getEncoder().encodeToString(bytes);
            encoded = pretty(encoded);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encoded;
    }

    /**
     * 数据加密
     *
     * @param iv
     * @param srcData
     * @return
     */
    public static String encrypt(String iv, String key, String srcData) {
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher;
        String encoded = null;
        try {
            //这个地方调用BouncyCastleProvider让java支持PKCS7Padding
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
            byte[] bytes = cipher.doFinal(srcData.getBytes());
            encoded = Base64.getEncoder().encodeToString(bytes);
            encoded = pretty(encoded);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encoded;
    }


    /**
     * 数据解密
     *
     * @param
     * @param
     * @param
     * @return
     */
    public static String decrypt(String encoded) {
        encoded = uglify(encoded);
        byte[] encData = Base64.getDecoder().decode(encoded);
        SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher;
        String srcData = null;
        try {
            //这个地方调用BouncyCastleProvider让java支持PKCS7Padding
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(IV.getBytes()));
            byte[] bytes = cipher.doFinal(encData);
            srcData = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return srcData;
    }

    /**
     * 数据解密
     *
     * @param
     * @param
     * @param
     * @return
     */
    public static String decrypt(String iv, String key, String encoded) {
        encoded = uglify(encoded);
        byte[] encData = Base64.getDecoder().decode(encoded);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher;
        String srcData = null;
        try {
            /**
             * 这个地方调用BouncyCastleProvider
             *让java支持PKCS7Padding
             */
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
            byte[] bytes = cipher.doFinal(encData);
            srcData = new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return srcData;
    }


    public static String pretty(String encoded) {
        char[] prettyChars = {'-','_'};
        char[] uglyChars = {'+', '/'};
        for(int i=0;i<prettyChars.length;i++) {
            char patten = uglyChars[i];
            char replace = prettyChars[i];
            encoded = encoded.replace(patten, replace);
        }
        return encoded;
    }

    public static String uglify(String encoded) {
        char[] prettyChars = {'-','_'};
        char[] uglyChars = {'+', '/'};
        for(int i=0;i<uglyChars.length;i++) {
            char patten = prettyChars[i];
            char replace = uglyChars[i];
            encoded = encoded.replace(patten, replace);
        }
        return encoded;
    }

    public static void main(String[] args) throws Exception {
        String encoded = "{\"trans_no\":\"1159601161840566272\", \"member_id\":\"175190301894246400\", \"origin\":2, \"delta\":122}";
        JSONObject jsonObject = JSONObject.parseObject(encoded);

        System.out.println("srcData " + jsonObject);
        String encrypt = encrypt(IV, KEY, jsonObject.toJSONString());
        String decoded = decrypt(IV, KEY,encrypt);
        System.out.println(">>>>> " +encrypt);
        System.out.println("decoded " + decoded);
    }

}
