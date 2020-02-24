package com.mdababi.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket(5000);
			while(true) {
				byte[] buffer = new byte[50];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				System.out.println("text received is: "+ new String(buffer));				
			}			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
