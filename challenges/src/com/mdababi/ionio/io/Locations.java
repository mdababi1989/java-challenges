package com.mdababi.ionio.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mdababi
 *
 */
public class Locations implements Map<Integer, Location> {

	private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

	public static void main(String[] args) throws IOException {
		try (ObjectOutputStream locFile = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("locations.txt")))) {
			for (Location location : locations.values())
				locFile.writeObject(location);
		}
	}

	static {
		try (ObjectInputStream locFile = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("locations.txt")))) {
			boolean eof= false;
			while (!eof) {
				try {
					Location location = (Location) locFile.readObject();
				locations.put(location.getLocationID(), location);
				System.out.println("imported loc: " + location.getLocationID() + ":" + location.getDescription());
				}
				catch(EOFException e) {
					eof = true;
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
			String input = null;
			while ((input = dirFile.readLine()) != null) {
				String[] data = input.split(",");
				int loc = Integer.parseInt(data[0]);
				String exit = data[1];
				int destination = Integer.parseInt(data[2]);

				locations.get(loc).addExit(exit, destination);
				System.out.println("imported exit: " + loc + ":" + exit + ":" + destination);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Location get(Object key) {
		return locations.get(key);
	}

	@Override
	public Location put(Integer key, Location value) {
		return locations.put(key, value);
	}

	@Override
	public Location remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		locations.clear();
	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Collection<Location> values() {
		return locations.values();
	}

	@Override
	public Set<Entry<Integer, Location>> entrySet() {
		return locations.entrySet();
	}

}
