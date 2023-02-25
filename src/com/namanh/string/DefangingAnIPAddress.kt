package com.namanh.string

/**
 * https://leetcode.com/problems/defanging-an-ip-address
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 */
object DefangingAnIPAddress {
    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }
}