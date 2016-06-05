/**
	Question: How to Implement Reverse DNS and Forward DNS Look Up Cache? 
		where,
			Reverse DNS is, given IP address get the domain name.
			Forward DNS is, given domain name get the IP address.

	Reference: 
			http://www.geeksforgeeks.org/implement-reverse-dns-look-cache/
			http://www.geeksforgeeks.org/implement-forward-dns-look-cache/

	Logic: 
		Reverse DNS:
		- Just like normal Trie but here we will have one more instance variable called domainName.
		- While storing, after the last character in IP address we will current.domainName as the domain name.
		- While searching, for the last node of the IP address we see whether the isIpEnd = true and length of IP = 0 then print current.domainName.
	
		Forward DNS:
		- Same as above except in place of IP we store domain name and while retrieving we give the IP address instead of domain name.
*/

class DnsTrie {
	
	public TrieDnsNode rootRevDns, rootFrwDns;

	String[] ip = {"107.108.11.123", "107.109.123.255", "74.125.200.106"};
    String[] url = {"www.samsung.com", "www.samsung.net", "www.google.in"};
    String[] testIp = {"107.108.11.123", "107.108.11.124"};
    String[] testUrl = {"www.samsung.com", "www.sansui.com"};

	public static void main(String[] args) {
    	DnsTrie dtObj = new DnsTrie();
    	dtObj.initialize();

    	dtObj.createRevDNS();
    	dtObj.testRevDNS();

    	// Similarly we do the same for Forwards DNS also.
    	// dtObj.createFrwDns();
    	// dtObj.testFrwDns();
	}

	public void initialize() {
		rootRevDns = new TrieDnsNode();
		rootFrwDns = new TrieDnsNode();
	}

	public void createRevDNS() {
		for(int ipIndex = 0; ipIndex < ip.length; ipIndex++) {
			TrieDnsNode current = rootRevDns;
			String eachIp = ip[ipIndex];
			for(int i = 0; i < eachIp.length(); i++) {
				TrieDnsNode nextNode = current.map.get(eachIp.charAt(i));
				if(null == nextNode) {
					TrieDnsNode newNode = new TrieDnsNode(eachIp.charAt(i));
					current.map.put(eachIp.charAt(i), newNode);
					current = current.map.get(eachIp.charAt(i));
				} else {
					current = nextNode;
				}
			}

			current.isIpEnd = true;
			current.domainName = url[ipIndex];
		}
	}

	public void testRevDNS() {
		for(int ipIndex = 0; ipIndex < testIp.length; ipIndex++) {
			String eachIp = testIp[ipIndex];
			int length = eachIp.length();
			TrieDnsNode current = rootRevDns;
			for(int i = 0; i < eachIp.length(); i++) {
				if(current.map.get(eachIp.charAt(i)) != null) {
					current = current.map.get(eachIp.charAt(i));
					length--;
				} else {
					break;
				}
			}

			if(length == 0 && current.isIpEnd) {
				System.out.println("Domain name for IP " + eachIp + " is " + current.domainName);
			} else {
				System.out.println("Domain name does not exist for IP " + eachIp);
			}
		}
	}

}