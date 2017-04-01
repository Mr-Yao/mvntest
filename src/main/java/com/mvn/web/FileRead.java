package com.mvn.web;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-12 20:37.
 */
public class FileRead {

	public static void read(String filePath) throws Exception {

		System.out.println("totalMemory:" + Runtime.getRuntime().totalMemory());
		System.out.println(" freeMemory:" + Runtime.getRuntime().freeMemory());

		long total = Runtime.getRuntime().freeMemory();

		final int BUFFER_SIZE = 5 * 1024 * 1024;// 缓冲区大小为5M

		File f = new File(filePath);

		MappedByteBuffer inputBuffer = new RandomAccessFile(f, "r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0, f.length());

		byte[] dst = new byte[BUFFER_SIZE];// 每次读出3M的内容

		long start = System.currentTimeMillis();

		for (int offset = 0; offset < inputBuffer.capacity(); offset += BUFFER_SIZE) {

			if (inputBuffer.capacity() - offset >= BUFFER_SIZE) {

				for (int i = 0; i < BUFFER_SIZE; i++) {
					dst[i] = inputBuffer.get(offset + i);
				}

			} else {

				for (int i = 0; i < inputBuffer.capacity() - offset; i++) {
					dst[i] = inputBuffer.get(offset + i);
				}

			}

			int length = (inputBuffer.capacity() % BUFFER_SIZE == 0) ? BUFFER_SIZE : inputBuffer.capacity() % BUFFER_SIZE;
			new String(dst, 0, length);
			// System.out.println(new String(dst, 0, length));// new
			// String(dst,0,length)这样可以取出缓存保存的字符串，可以对其进行操作
			System.out.println("freeMemory:" + Runtime.getRuntime().freeMemory());
			System.out.println("use: " + (total - Runtime.getRuntime().freeMemory()) / 1024 / 1024);
		}

		long end = System.currentTimeMillis();

		System.out.println("读取文件文件一半内容花费：" + (end - start) / 1000 + "秒");

	}

	public static void main(String[] args) throws Exception {
		long total = Runtime.getRuntime().freeMemory();

		File file = new File("H:test1.sql");
		long start = System.currentTimeMillis();

		int bufSize = 5 * 1024;
		byte[] bs = new byte[bufSize];
		ByteBuffer byteBuf = ByteBuffer.allocate(bufSize);

		FileChannel channel = new RandomAccessFile(file, "r").getChannel();

		channel.read(byteBuf);

		int size = byteBuf.position();
		byteBuf.rewind();

		byteBuf.get(bs);

		String str = new String(bs, 0, size);

		String redundant = str.substring(str.lastIndexOf("\n"));

		System.out.println(str.replace(redundant,""));

		//System.out.println(redundant);


		byteBuf.compact();
		System.out.println(size);
		System.out.println("use: " + (total - Runtime.getRuntime().freeMemory()) / 1024 / 1024);

		long end = System.currentTimeMillis();
		System.out.println("读取文件内容花费：" + (end - start) / 1000 + "秒");
	}
}
