package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.physics.box2d.World;

import entity.PlayerMP;
import network_pack.Packet;
import network_pack.Packet00Login;
import network_pack.Packet.PacketTypes;
import screen.GameScreen;
/*created by thienepzai using vanzeben project*/
public class GameServer extends Thread {

		private DatagramSocket socket;
		@SuppressWarnings("unused")
		private GameScreen game;
		private List<PlayerMP> connectedPlayers = new ArrayList<>();
		@SuppressWarnings("unused")
		private int count = 0;
		@SuppressWarnings("unused")
		private World world;
		
		public GameServer(GameScreen gameScreen) 
		{
			this.game = gameScreen;
			try {
				this.socket = new DatagramSocket(1507);
			}
			catch (SocketException e) {
				// TODO Auto-generated catch block
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
				  parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
		      }
			  
		}
		
		private void parsePacket(byte[] data, InetAddress address, int port) {
			String message = new String(data).trim();
			PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
			 Packet packet = null;
			switch(type) {
			default:
			case INVALID:
			   break;
			case LOGIN:
	            packet = new Packet00Login(data);
	            System.out.println("[" + address.getHostAddress() + ":" + port + "] "
	                    + ((Packet00Login) packet).getUsername() + " has connected...");
	            PlayerMP player = new PlayerMP(((Packet00Login) packet).getUsername(),address, port); 
	            this.addConnection(player, (Packet00Login) packet);
				
				break;
			case MOVE:
			    break;
			case DISCONNECT:
//				packet = new Packet01Disconnect(data);
//	            System.out.println("[" + address.getHostAddress() + ":" + port + "] "
//	                    + ((Packet01Disconnect) packet).getUsername() + " has left...");
//	            this.removeConnection((Packet01Disconnect) packet);
	            break;
					
		}
		}
		
	    public void addConnection(PlayerMP player, Packet00Login packet) {
	        boolean alreadyConnected = false;
	        for (PlayerMP p : this.connectedPlayers) {
	            if (player.getUsername().equalsIgnoreCase(p.getUsername())) {
	                if (p.ipAddress == null) {
	                    p.ipAddress = player.ipAddress;
	                }
	                if (p.port == -1) {
	                    p.port = player.port;
	                }
	                alreadyConnected = true;
	            } else {
	                // relay to the current connected player that there is a new
	                // player
	                sendData(packet.getData(), p.ipAddress, p.port);

	                // relay to the new player that the currently connect player
	                // exists
	                packet = new Packet00Login(p.getUsername());
	                sendData(packet.getData(), player.ipAddress, player.port);
	            }
	        }
	        if (!alreadyConnected) {
	            this.connectedPlayers.add(player);
	        }
	    }


		public void sendData(byte[] data, InetAddress ipAddress, int port) {
			DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void sendDataToAllClient(byte[] data) {
			for(PlayerMP p : connectedPlayers) {
				sendData(data, p.ipAddress, p.port);
			}
			
		}
//		
//		 public void removeConnection(Packet01Disconnect packet) {
//		      
//		        this.connectedPlayers.remove(getPlayerMPIndex(packet.getUsername()));
//		        packet.writeData(this);
//		    }
//
//		    public PlayerMP getPlayerMP(String username) {
//		        for (PlayerMP player : this.connectedPlayers) {
//		            if (player.getUsername().equals(username)) {
//		                return player;
//		            }
//		        }
//		        return null;
//		    }
//		    
//		    public int getPlayerMPIndex(String username) {
//		        int index = 0;
//		        for (PlayerMP player : this.connectedPlayers) {
//		            if (player.getUsername().equals(username)) {
//		                break;
//		            }
//		            index++;
//		        }
//		        return index;
//		    }
//	

	}

