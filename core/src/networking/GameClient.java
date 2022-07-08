package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import entity.PlayerMP;
import network_pack.Packet;
import network_pack.Packet00Login;
import network_pack.Packet.PacketTypes;
import screen.GameScreen;
/*created by thienepzai using vanzeben project*/
public class GameClient extends Thread{

	private InetAddress ipAddress;
	private DatagramSocket socket;
	private GameScreen game;
	
	public GameClient(GameScreen gameScreen, String ipAdress) 
	{
		this.game = gameScreen;
		try {
			this.socket = new DatagramSocket();
		
		this.ipAddress = InetAddress.getByName(ipAdress);
		}
		catch (SocketException e) {
			e.printStackTrace();
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		  while(true) {
			  byte[] data = new byte[1024];
			  DatagramPacket packet = new DatagramPacket(data, data.length);
			  try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			  System.out.println("Server>" + new String(packet.getData()));
			  this.parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
		  }
	}
	
	private void parsePacket(byte[] data, InetAddress address, int port) {
        String message = new String(data).trim();
        PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
        Packet packet = null;
        switch (type) {
        default:
        case INVALID:
            break;
        case LOGIN:
            packet = new Packet00Login(data);
            System.out.println("[" + address.getHostAddress() + ":" + port + "] "
                    + ((Packet00Login) packet).getUsername() + " has joined the game...");
            PlayerMP player = new PlayerMP(((Packet00Login) packet).getUsername(),address, port); 
            game.mpPlayer.add(player);
            game.buildBody(game.mpPlayer.get(game.getI()));
            break;
        case DISCONNECT:
            break;
        }
    }
	
	public void sendData(byte[] data) {
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 1507);
		try {
			socket.send(packet);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
