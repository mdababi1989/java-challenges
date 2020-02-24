package com.mdababi.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			DatagramSocket socket = new DatagramSocket();
			Scanner scanner = new Scanner(System.in);
			String echoString;

			do {
				echoString = scanner.nextLine();
				byte[] buffer = echoString.getBytes();
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length, inetAddress, 5000);
				socket.send(packet);

			} while (!echoString.equals("exit"));

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
