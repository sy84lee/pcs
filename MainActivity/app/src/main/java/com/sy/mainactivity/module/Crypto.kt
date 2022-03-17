package com.sy.mainactivity.module

import java.security.MessageDigest
import java.security.CryptoPrimitive

class Crypto {
    fun getHash(alg: String, message: String) : ByteArray{
        val md = MessageDigest.getInstance(alg)
        val digest: ByteArray = md.digest(message.toByteArray())

        return digest
    }
}
