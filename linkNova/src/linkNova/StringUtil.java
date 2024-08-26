package linkNova;
import java.security.MessageDigest; // Import this to get access to the SHA256 algorithm.
import com.google.gson.GsonBuilder;

public class StringUtil {
	
	// In this project SHA256 cyrptographic algorithm is used to generate a digital fingerprint for our block
	// The following method applies Sha256 to a string and returns the result.
	public static String applySha256(String input) {
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			//Applies sha256 to our input
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			// The below code converts a single byte from the hash array into 
			// its corresponding two-digit hexadecimal string representation.
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//Short hand helper to turn Object into a json string
	// converts the block chain object into a nicely formatted (pretty-printed) JSON string and assigns it to the blockchainJson variable
	public static String getJson(Object o) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(o);
	}
	
	//Returns difficulty string target, to compare to hash. eg difficulty of 5 will return "00000"  
	public static String getDifficultyString(int difficulty) {
		return new String(new char[difficulty]).replace('\0', '0');
	}
}
