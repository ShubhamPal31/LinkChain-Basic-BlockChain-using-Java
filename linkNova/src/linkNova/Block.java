package linkNova;
import java.util.Date;


// Each block in the block-chain will have its own digital fingerprint, contain digital fingerprint of the previous block, and have some data 
public class Block {
	
	public String hash;
	public String previousHash;
	private String data; //this data can be anything such as transactions, but in this project the data will be a simple message.
	private long timeStamp;
	private int nonce;
	
	// Constructor for Block
	public Block(String data,String previousHash) {
		this.data=data;
		this.previousHash=previousHash;
		this.timeStamp=new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	// To calculate the hash
	// We must calculate the hash from all parts of the block we don’t want to be tampered with. So for our block we will include the previousHash, the data and timeStamp.
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) +
				data 
				);
		return calculatedhash;
	}
	
	// We will require miners to do proof-of-work by trying different variable values in the block until its hash starts with a certain number of 0’s.
	//Increases nonce value until hash target is reached.
		public void mineBlock(int difficulty) {
			String target = StringUtil.getDifficultyString(difficulty); //Create a string with difficulty * "0" 
			while(!hash.substring( 0, difficulty).equals(target)) {
				nonce++;
				hash = calculateHash();
			}
			System.out.println("Block Mined!!! : " + hash);
		}
}
