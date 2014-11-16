package in.neoandroid.xmlparser;

import java.util.ArrayList;
import java.util.HashMap;

public class NeoXMLObject {
	private HashMap<String, String> attributes = new HashMap<String, String>();
	private String name = null;
	private String content = null;
	private HashMap<String, ArrayList<NeoXMLObject>> children = new HashMap<String, ArrayList<NeoXMLObject>>();
	
	public NeoXMLObject(String name) {
		this.name = name;
	}
	
	public HashMap<String, ArrayList<NeoXMLObject>> getAllChildren() {
		return children;
	}
	
	public ArrayList<NeoXMLObject> getChildrenWithTag(String name) {
		return children.get(name);
	}
	
	public NeoXMLObject getFirstChild(String name) {
		ArrayList<NeoXMLObject> childList = getChildrenWithTag(name);
		if(childList != null && childList.size() > 0)
			return childList.get(0);
		return null;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean insertAttribute(String name, String value) {
		if(attributes.containsKey(name))
			return false;
		attributes.put(name, value);
		return true;
	}

	public HashMap<String, String> getAllAttributes() {
		return attributes;
	}
	
	public boolean insertChild(NeoXMLObject child) {
		if(child == null)
			return false;
		ArrayList<NeoXMLObject> childList = children.get(child.name);
		if(childList == null)
			childList = new ArrayList<NeoXMLObject>();
		childList.add(child);
		children.put(child.name, childList);
		return true;
	}
	
	public boolean hasChild(String name) {
		return children.containsKey(name);
	}
	
	public boolean hasAttribute(String name) {
		return attributes.containsKey(name);
	}
}
