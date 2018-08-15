package com.cooksys.client_handler;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Client {

	public Client() {

	}

	public static void connector() {
		try (Socket s = new Socket("localhost", 8080)) {
			while (true) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String outMsg = new String("this is the msg");
				BufferedOutputStream bos = new BufferedOutputStream(new DataOutputStream(s.getOutputStream()));
				bos.write(outMsg.getBytes().length);
				bos.write(outMsg.getBytes());
				bos.flush();

			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		connector();
	}
}