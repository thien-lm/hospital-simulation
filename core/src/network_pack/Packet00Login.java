package network_pack;
/*created by thienepzai using vanzeben project*/
import networking.GameClient;
import networking.GameServer;

public class Packet00Login extends Packet {

	public String userName;
	
	 public Packet00Login(byte[] data) {
		super(00);
		this.userName = readData(data);
		// TODO Auto-generated constructor stub
	}
	
	public Packet00Login(String userName) {
		super(00);
		this.userName = userName;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void writeData(GameClient client) {
		// TODO Auto-generated method stub
		client.sendData(getData());
	}

	@Override
	public void writeData(GameServer server) {
		// TODO Auto-generated method stub
		server.sendDataToAllClient(getData());
	
	}

	@Override
	public byte[] getData() {
		// TODO Auto-generated method stub
		return ("00" + this.userName).getBytes();
	}
	
	public String getUsername() {
		return userName;
	}


	

}
