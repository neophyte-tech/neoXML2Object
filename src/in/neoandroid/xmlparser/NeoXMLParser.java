package in.neoandroid.xmlparser;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;
import android.util.Xml;

public class NeoXMLParser {
	InputStream inputStream = null;
	public NeoXMLParser(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public NeoXMLObject parse() throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            parser.nextTag();
            return parseTag(parser);
        } finally {
            inputStream.close();
        }
    }

	public NeoXMLObject parseTag(XmlPullParser parser) throws XmlPullParserException, IOException {
		if(parser.getEventType() != XmlPullParser.START_TAG)
			return null;

		NeoXMLObject newObject = new NeoXMLObject(parser.getName());
		// Read Attributes
		// TODO: Handle attribute prefixes -> Currently ignored
		for(int i=0;i<parser.getAttributeCount();i++)
			newObject.insertAttribute(parser.getAttributeName(i), parser.getAttributeValue(i));

		while(parser.next() != XmlPullParser.END_TAG) {
			switch(parser.getEventType()) {
				case XmlPullParser.START_TAG:
					newObject.insertChild(parseTag(parser)); // Recursive Call
					break;
				case XmlPullParser.TEXT:
					newObject.setContent(parser.getText());
					break;
				default:
				case XmlPullParser.COMMENT:
					break;
			}
		}
		return newObject;
	}
}
