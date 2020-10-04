package com.up.clothes_app.util

import android.os.Build
import android.util.Base64

import androidx.annotation.RequiresApi

import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.io.UnsupportedEncodingException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException


object AESUtil {


    internal var KEY = "h@rdLosmLaKeyenc"
    internal var IV = "h@rdLosmLavecenc"


    @RequiresApi(api = Build.VERSION_CODES.O)
    fun encrypt(key: String, initVector: String, value: String): String {
        try {
            val iv = IvParameterSpec(initVector.toByteArray(charset("UTF-8")))
            val skeySpec = SecretKeySpec(key.toByteArray(charset("UTF-8")), "AES")

            val cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv)

            val encrypted = cipher.doFinal(value.toByteArray())

            return Base64.encodeToString(encrypted, Base64.NO_WRAP)
        } catch (ex: UnsupportedEncodingException) {
            throw RuntimeException("Encrypt exception: ", ex)
        } catch (ex: InvalidAlgorithmParameterException) {
            throw RuntimeException("Encrypt exception: ", ex)
        } catch (ex: InvalidKeyException) {
            throw RuntimeException("Encrypt exception: ", ex)
        } catch (ex: NoSuchAlgorithmException) {
            throw RuntimeException("Encrypt exception: ", ex)
        } catch (ex: BadPaddingException) {
            throw RuntimeException("Encrypt exception: ", ex)
        } catch (ex: IllegalBlockSizeException) {
            throw RuntimeException("Encrypt exception: ", ex)
        } catch (ex: NoSuchPaddingException) {
            throw RuntimeException("Encrypt exception: ", ex)
        }

    }

    /*@RequiresApi(api = Build.VERSION_CODES.O)
    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            throw new RuntimeException("Invalid data provided!");
        }
    }*/
}

