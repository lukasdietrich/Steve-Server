package org.steve.server.httpd;

import java.util.Hashtable;

public class MimeType {

	private static MimeType instance;
	public static MimeType getInstance() {
		return (instance == null) ? instance = new MimeType() : instance;
	}
	
	private Hashtable<String, String> mime;
	
	private MimeType() {
		this.mime = new Hashtable<String, String>();
		
		this.mime.put("ai", "application/postscript");
		this.mime.put("aif", "audio/x-aiff");
		this.mime.put("aifc", "audio/x-aiff");
		this.mime.put("aiff", "audio/x-aiff");
		this.mime.put("asc", "text/plain");
		this.mime.put("atom", "application/atom+xml");
		this.mime.put("au", "audio/basic");
		this.mime.put("avi", "video/x-msvideo");
		this.mime.put("bcpio", "application/x-bcpio");
		this.mime.put("bmp", "image/bmp");
		this.mime.put("cdf", "application/x-netcdf");
		this.mime.put("cgm", "image/cgm");
		this.mime.put("cpio", "application/x-cpio");
		this.mime.put("cpt", "application/mac-compactpro");
		this.mime.put("csh", "application/x-csh");
		this.mime.put("css", "text/css");
		this.mime.put("dcr", "application/x-director");
		this.mime.put("dif", "video/x-dv");
		this.mime.put("dir", "application/x-director");
		this.mime.put("djv", "image/vnd.djvu");
		this.mime.put("djvu", "image/vnd.djvu");
		this.mime.put("doc", "application/msword");
		this.mime.put("dtd", "application/xml-dtd");
		this.mime.put("dv", "video/x-dv");
		this.mime.put("dvi", "application/x-dvi");
		this.mime.put("dxr", "application/x-director");
		this.mime.put("eps", "application/postscript");
		this.mime.put("etx", "text/x-setext");
		this.mime.put("ez", "application/andrew-inset");
		this.mime.put("gif", "image/gif");
		this.mime.put("gram", "application/srgs");
		this.mime.put("grxml", "application/srgs+xml");
		this.mime.put("gtar", "application/x-gtar");
		this.mime.put("hdf", "application/x-hdf");
		this.mime.put("hqx", "application/mac-binhex40");
		this.mime.put("htm", "text/html");
		this.mime.put("html", "text/html");
		this.mime.put("ice", "x-conference/x-cooltalk");
		this.mime.put("ico", "image/x-icon");
		this.mime.put("ics", "text/calendar");
		this.mime.put("ief", "image/ief");
		this.mime.put("ifb", "text/calendar");
		this.mime.put("iges", "model/iges");
		this.mime.put("igs", "model/iges");
		this.mime.put("jnlp", "application/x-java-jnlp-file");
		this.mime.put("jp2", "image/jp2");
		this.mime.put("jpe", "image/jpeg");
		this.mime.put("jpeg", "image/jpeg");
		this.mime.put("jpg", "image/jpeg");
		this.mime.put("js", "application/x-javascript");
		this.mime.put("kar", "audio/midi");
		this.mime.put("latex", "application/x-latex");
		this.mime.put("m3u", "audio/x-mpegurl");
		this.mime.put("m4a", "audio/mp4a-latm");
		this.mime.put("m4b", "audio/mp4a-latm");
		this.mime.put("m4p", "audio/mp4a-latm");
		this.mime.put("m4u", "video/vnd.mpegurl");
		this.mime.put("m4v", "video/x-m4v");
		this.mime.put("mac", "image/x-macpaint");
		this.mime.put("man", "application/x-troff-man");
		this.mime.put("mathml", "application/mathml+xml");
		this.mime.put("me", "application/x-troff-me");
		this.mime.put("mesh", "model/mesh");
		this.mime.put("mid", "audio/midi");
		this.mime.put("midi", "audio/midi");
		this.mime.put("mif", "application/vnd.mif");
		this.mime.put("mov", "video/quicktime");
		this.mime.put("movie", "video/x-sgi-movie");
		this.mime.put("mp2", "audio/mpeg");
		this.mime.put("mp3", "audio/mpeg");
		this.mime.put("mp4", "video/mp4");
		this.mime.put("mpe", "video/mpeg");
		this.mime.put("mpeg", "video/mpeg");
		this.mime.put("mpg", "video/mpeg");
		this.mime.put("mpga", "audio/mpeg");
		this.mime.put("ms", "application/x-troff-ms");
		this.mime.put("msh", "model/mesh");
		this.mime.put("mxu", "video/vnd.mpegurl");
		this.mime.put("nc", "application/x-netcdf");
		this.mime.put("oda", "application/oda");
		this.mime.put("ogg", "application/ogg");
		this.mime.put("pbm", "image/x-portable-bitmap");
		this.mime.put("pct", "image/pict");
		this.mime.put("pdb", "chemical/x-pdb");
		this.mime.put("pdf", "application/pdf");
		this.mime.put("pgm", "image/x-portable-graymap");
		this.mime.put("pgn", "application/x-chess-pgn");
		this.mime.put("pic", "image/pict");
		this.mime.put("pict", "image/pict");
		this.mime.put("png", "image/png");
		this.mime.put("pnm", "image/x-portable-anymap");
		this.mime.put("pnt", "image/x-macpaint");
		this.mime.put("pntg", "image/x-macpaint");
		this.mime.put("ppm", "image/x-portable-pixmap");
		this.mime.put("ppt", "application/vnd.ms-powerpoint");
		this.mime.put("ps", "application/postscript");
		this.mime.put("qt", "video/quicktime");
		this.mime.put("qti", "image/x-quicktime");
		this.mime.put("qtif", "image/x-quicktime");
		this.mime.put("ra", "audio/x-pn-realaudio");
		this.mime.put("ram", "audio/x-pn-realaudio");
		this.mime.put("ras", "image/x-cmu-raster");
		this.mime.put("rdf", "application/rdf+xml");
		this.mime.put("rgb", "image/x-rgb");
		this.mime.put("rm", "application/vnd.rn-realmedia");
		this.mime.put("roff", "application/x-troff");
		this.mime.put("rtf", "text/rtf");
		this.mime.put("rtx", "text/richtext");
		this.mime.put("sgm", "text/sgml");
		this.mime.put("sgml", "text/sgml");
		this.mime.put("sh", "application/x-sh");
		this.mime.put("shar", "application/x-shar");
		this.mime.put("silo", "model/mesh");
		this.mime.put("sit", "application/x-stuffit");
		this.mime.put("skd", "application/x-koan");
		this.mime.put("skm", "application/x-koan");
		this.mime.put("skp", "application/x-koan");
		this.mime.put("skt", "application/x-koan");
		this.mime.put("smi", "application/smil");
		this.mime.put("smil", "application/smil");
		this.mime.put("snd", "audio/basic");
		this.mime.put("spl", "application/x-futuresplash");
		this.mime.put("src", "application/x-wais-source");
		this.mime.put("sv4cpio", "application/x-sv4cpio");
		this.mime.put("sv4crc", "application/x-sv4crc");
		this.mime.put("svg", "image/svg+xml");
		this.mime.put("swf", "application/x-shockwave-flash");
		this.mime.put("t", "application/x-troff");
		this.mime.put("tar", "application/x-tar");
		this.mime.put("tcl", "application/x-tcl");
		this.mime.put("tex", "application/x-tex");
		this.mime.put("texi", "application/x-texinfo");
		this.mime.put("texinfo", "application/x-texinfo");
		this.mime.put("tif", "image/tiff");
		this.mime.put("tiff", "image/tiff");
		this.mime.put("tr", "application/x-troff");
		this.mime.put("tsv", "text/tab-separated-values");
		this.mime.put("txt", "text/plain");
		this.mime.put("ustar", "application/x-ustar");
		this.mime.put("vcd", "application/x-cdlink");
		this.mime.put("vrml", "model/vrml");
		this.mime.put("vxml", "application/voicexml+xml");
		this.mime.put("wav", "audio/x-wav");
		this.mime.put("wbmp", "image/vnd.wap.wbmp");
		this.mime.put("wbmxl", "application/vnd.wap.wbxml");
		this.mime.put("wml", "text/vnd.wap.wml");
		this.mime.put("wmlc", "application/vnd.wap.wmlc");
		this.mime.put("wmls", "text/vnd.wap.wmlscript");
		this.mime.put("wmlsc", "application/vnd.wap.wmlscriptc");
		this.mime.put("wrl", "model/vrml");
		this.mime.put("xbm", "image/x-xbitmap");
		this.mime.put("xht", "application/xhtml+xml");
		this.mime.put("xhtml", "application/xhtml+xml");
		this.mime.put("xls", "application/vnd.ms-excel");
		this.mime.put("xml", "application/xml");
		this.mime.put("xpm", "image/x-xpixmap");
		this.mime.put("xsl", "application/xml");
		this.mime.put("xslt", "application/xslt+xml");
		this.mime.put("xul", "application/vnd.mozilla.xul+xml");
		this.mime.put("xwd", "image/x-xwindowdump");
		this.mime.put("xyz", "chemical/x-xyz");
		this.mime.put("zip", "application/zip");
	}
	
	public String getMimeForFile(String f) {
		if(f.contains(".")) {
			f = f.substring(f.lastIndexOf(".") + 1);
		}
		
		if(this.mime.containsKey(f)) {
			return this.mime.get(f);
		}
		
		return "application/octet-stream";
	}
	
}
