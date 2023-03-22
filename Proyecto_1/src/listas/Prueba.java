package listas;

import java.util.ArrayList;
import java.util.Vector;

public class Prueba
{
	public static void main(String[] args)
	{
		ObjectList list = new ObjectList();

		list.add(Integer.valueOf((int)(Math.random() * 100)));		
		list.add(Integer.valueOf((int)(Math.random() * 100)));		
		list.add(Integer.valueOf((int)(Math.random() * 100)));		
		list.add(Integer.valueOf((int)(Math.random() * 100)));		
		list.add(Integer.valueOf((int)(Math.random() * 100)));

		list.compactar();
		
		System.out.println(list.toString());
	}
}
