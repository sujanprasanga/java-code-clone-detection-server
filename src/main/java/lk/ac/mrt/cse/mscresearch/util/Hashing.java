package lk.ac.mrt.cse.mscresearch.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;

import com.google.common.hash.HashFunction;

public class Hashing {

	private static final int BUFFER_SIZE = 10 * 1024 * 1024;
	private static final String UTF_8 = "UTF-8";
	private static final Charset CHARSET = Charset.forName(UTF_8);

	public static String hash(String s){
		return hash(s.getBytes(CHARSET));
	}
	
	public static String hash(byte[] allBytes){
		try{
			HashFunction murmur = com.google.common.hash.Hashing.murmur3_128();
			return digestToString(murmur.hashBytes(allBytes).asBytes());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

//	protected static String digestToString(byte[] digest) throws UnsupportedEncodingException {
//		return new String(digest, UTF_8);
//	}
	
	public static String hash(File f){
		try{
			HashFunction murmur = com.google.common.hash.Hashing.murmur3_128();
			byte[] allBytes = Files.readAllBytes((Paths.get(f.getAbsolutePath())));
			return digestToString(murmur.hashBytes(allBytes).asBytes());
//			MessageDigest md = MessageDigest.getInstance("hashValue");
//			try (BufferedInputStream is = new BufferedInputStream(Files.newInputStream(Paths.get(f.getAbsolutePath())), BUFFER_SIZE);
//					DigestInputStream dis = new DigestInputStream(is, md)) 
//			{
//				while(dis.read() != -1);
//			}
//			byte[] digest = md.digest();
//			return digestToString(digest);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String digestToString(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	public static void main(String[] args){
		File f = new File("D:\\development\\msc-research\\Temp\\rt.jar");
		System.out.println(hash(f));
	}
}
