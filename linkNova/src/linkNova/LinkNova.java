package linkNova;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class LinkNova {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static void main(String[] args) {
		
		//add our blocks to the blockchain ArrayList:
		blockchain.add(new Block("Hi im the first block", "0"));		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		
		// this below line converts the block chain object into a nicely formatted 
		// (pretty-printed) JSON string and assigns it to the blockchainJson variable.
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
		
	}

}
