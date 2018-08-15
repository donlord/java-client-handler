package com.cooksys.client_handler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
	private Socket socket;

	public ClientHandler(Socket s) {
		this.socket = s;

	}

	public void listenAndReply() {
		try {
			while (true) {
				BufferedInputStream bis = new BufferedInputStream(new DataInputStream(socket.getInputStream()));
				byte[] b = new byte[bis.read()];
				String msg = new String();
				bis.read(b);
				msg = new String(b);
				System.out.println("Message Accepted: " + msg);
				BufferedOutputStream bos = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()));
				bos.write(msg.getBytes().length);
				bos.write(msg.getBytes());
				bos.flush();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void run() {
		listenAndReply();
	}

}
