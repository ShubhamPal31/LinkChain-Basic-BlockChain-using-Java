package linkNova;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class LinkNova {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	
	public static void main(String[] args) {
		
		// Let's create some blocks using the syntax
		// Block(String data,String previousHash)
		
		// The first block is called the genesis block, 
		// and because there is no previous block we will just enter “0” as the previous hash.
		Block genesisBlock = new Block("This is the first block","0");
		System.out.println("Hash for Block 1: "+genesisBlock.hash);
		
		// Second Block
		Block secondBlock = new Block("This is the second block", genesisBlock.hash);
		System.out.println("Hash for Block 2: "+secondBlock.hash);
		
		// Third Block
		Block thirdBlock = new Block("This is the third block", secondBlock.hash);
		System.out.println("Hash for Block 3: "+thirdBlock.hash);
		
	}

}
