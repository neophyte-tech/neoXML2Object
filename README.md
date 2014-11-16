neoXML2Object
=============

# Introduction

neoAndroid.in's Simple XML to Object converter for Android. This was inspired from the simpler JSON parser (when compared with the existing XML Parsers). That said, it should be noted that this parser does not provide the complete feature set of an XML Parser nor would it parse complex XML files. But, this parser would provide simple parsing and object handling for many Android<->Server interactions.

# Usage

Send in the InputStream and initialize the Parser:
```
NeoXMLParser parser = new NeoXMLParser(inStream);
```
Or directly from an HttpResponse
```
NeoXMLParser parser = new NeoXMLParser(response.getEntity().getContent());
```

You would then want to parse the XML and get the object using:
```
NeoXMLObject xmlObj = parser.parse();
```

You should now have the parsed object for consumption
```
NeoXMLObject status = xmlObj.getFirstChild("status"); // Get the first 'status' child of the xmlObj

xmlObj.getAttributeValue("id"); // Get the value of the attribute "id"

xmlObj.hasChild("error"); // Find if there is a child element called "error"

xmlObj.hasAttribute("id"); // Find if there is an attribute called "id"
```

# Contributions

Any contribution would be really appreciated. But, please note that all pull requests would be assumed to be dual licensed under GPLv2+ and Apache v2
