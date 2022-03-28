package com.sy.pcs.module

import java.security.MessageDigest

class Crypto {
    fun getHash(alg: String, message: String) : ByteArray{
        val md = MessageDigest.getInstance(alg)
        val digest: ByteArray = md.digest(message.toByteArray())

        return digest
    }
}