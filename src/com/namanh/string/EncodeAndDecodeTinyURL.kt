package com.namanh.string

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it
 * returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 *
 * S1: Create a unique string from 6 random character
 *
 * Time: O(1)
 * Space: O(n)
 */
class EncodeAndDecodeTinyURL {
    private val baseUrl = "http://tinyurl.com/"
    private val seed = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val map = mutableMapOf<String, String>()
    private val reverseMap = mutableMapOf<String, String>()

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        if (map.containsKey(longUrl)) return baseUrl + map[longUrl]

        var key: String
        do {
            key = ""
            for (i in 1..6) {
                key += seed[(seed.indices).random()]
            }
        } while (map.containsKey(key))

        map[longUrl] = key
        reverseMap[key] = longUrl
        return baseUrl + key
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return reverseMap[shortUrl.replace(baseUrl, "")] ?: ""
    }
}