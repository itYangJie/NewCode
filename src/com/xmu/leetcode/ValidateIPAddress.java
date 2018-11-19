package com.xmu.leetcode;

public class ValidateIPAddress {
	public static void main(String[] args) {
		new ValidateIPAddress().validIPAddress("12..33.4");
	}
	public String validIPAddress(String IP) {
        if(IP.contains(".")) {
        	return validIPV4(IP);
        }else if(IP.contains(":")) {
        	return validIPV6(IP);
        }else
        	return "Neither";
    }
	private String validIPV6(String ip) {
		int count = 0;
		for(int i=0;i<ip.length();i++)
			if(':'==ip.charAt(i))
				count++;
		if(count!=7)
			return "Neither";
		String[] split = ip.split(":");
		if(split.length!=8)
			return "Neither";
		for(int i=0;i<8;i++) {
			String s = split[i];
			if(s.length()>4 || s.length()<1)
				return "Neither";
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				if(!((c>='0'&&c<='9')||(c>='a'&&c<='f')||(c>='A'&&c<='F')))
					return "Neither";
			}
		}
		return "IPv6";
	}
	private String validIPV4(String ip) {
		if(ip.matches("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$"))
			return "IPv4";
		else
			return "Neither";
	}

	
}
