package com.mdababi.network.tcp;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(5000)) {
			while (true) {
				new Echoer(serverSocket.accept()).start();
			}
		} catch (IOException e) {
			System.out.println("Server error: " + e.getMessage());
		}

	}
}
