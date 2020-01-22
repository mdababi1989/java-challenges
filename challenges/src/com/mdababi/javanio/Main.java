package com.mdababi.javanio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main {

	public static void main(String[] args) {
		try {
			Pipe pipe = Pipe.open();
			Runnable writer = new Runnable() {
				@Override
				public void run() {
					try {
						Pipe.SinkChannel sinkChannel = pipe.sink();
						ByteBuffer buffer = ByteBuffer.allocate(56);
						for (int i = 0; i < 10; i++) {
							String currentTime = "the time is :" + System.currentTimeMillis();
							buffer.put(currentTime.getBytes());
							buffer.flip();
							while (buffer.hasRemaining()) {
								sinkChannel.write(buffer);

							}
							buffer.flip();
							Thread.sleep(100);
						}
					} catch (IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

			Runnable reader = new Runnable() {
				@Override
				public void run() {
					try {
						Pipe.SourceChannel sourceChannel = pipe.source();
						ByteBuffer buffer = ByteBuffer.allocate(56);
						for (int i = 0; i < 10; i++) {
							int numread = sourceChannel.read(buffer);
							byte[] timeString = new byte[numread];
							buffer.flip();
							buffer.get(timeString);
							System.out.println(i+": Thread read: "+ new String(timeString));
							buffer.flip();
							Thread.sleep(100);
						}

					} catch (IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			new Thread(writer).start();
			new Thread(reader).start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
