/**
	We will use this node for DNS kinda operations.
*/

import java.util.*;

class TrieDnsNode {
	Character data;
	Map<Character, TrieDnsNode> map;
	boolean isIpEnd;
	String domainName;

	public TrieDnsNode(char data) {
		this.data = data;
		this.map = new HashMap<Character, TrieDnsNode>();
		this.isIpEnd = false;
		this.domainName = null;
	}

	public TrieDnsNode() {
		this.data = null;
		this.map = new HashMap<Character, TrieDnsNode>();
		this.isIpEnd = false;
		this.domainName = null;
	}	
}