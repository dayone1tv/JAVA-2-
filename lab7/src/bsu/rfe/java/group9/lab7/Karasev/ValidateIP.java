package bsu.rfe.java.group9.lab7.Karasev;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;

class ValidateIP {
    public static boolean isValidIP(String ip) {
        try {
            return !Inet4Address.getByName(ip)
                    .getHostAddress().equals(ip);
        } catch (UnknownHostException ex) {
            return true;
        }
    }
}
