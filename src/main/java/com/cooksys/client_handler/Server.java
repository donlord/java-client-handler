package com.cooksys.client_handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8080);

			Socket client = ss.accept();
			ClientHandler c = new ClientHandler(client);
			for (int i = 0; i < 10; i++) {
				Thread t = new Thread(c);
				t.start();
				System.out.println("i fiinished ");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
