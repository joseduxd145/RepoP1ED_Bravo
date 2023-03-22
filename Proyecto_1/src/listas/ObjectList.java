package listas;

public class ObjectList
{
	private Object[] array;
	private int size;
	private int incremento;
	
	//Constructor vacio
	public ObjectList()
	{
		this.array = new Object[10];
		this.size = 0;
		this.incremento = 4;
	}
	
	//Contructor parcial
	public ObjectList(Object[] pArray)
	{
		this.array = pArray;
		this.size = 0;
		this.incremento = 4;
		
		for(int i = 0; i < this.array.length; i++)
		{
			if(this.array[i] != null)
				this.size++;
		}
	}
	
	//TODO Crear un constructor con parametros array e incremento, o ambos.
	public ObjectList(int pIncremento)
	{
		this.array = new Object[10];
		this.size = 0;
		this.incremento = pIncremento;
	}
	
	
	//Metodo para vaciar el array
	public void clear()
	{
		array = new Object[array.length];
		size = 0;
	}
	
	//Metodo que añade un objeto al array, si no hay espacio lo agranda y lo añade
	public void add(Object pObject)
	{
		if(size >= array.length)
		{
			Object[] tmpArray = new Object[array.length + incremento];
			
			for(int i = 0; i < array.length; i++)
				tmpArray[i] = array[i];
			
			array = tmpArray;
			
			array[size] = pObject;
			size++;
		}
		else
		{
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] == null)
				{
					array[i] = pObject;
					size++;
					break;
				}
			}
		}
	}
	
	//Metodo para añadir un array
	public void add(Object[] pArray)
	{
		if((array.length - size) >= pArray.length)
		{
			int contador = 0;
			
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] == null)
				{
					if(contador >= pArray.length)
						break;
					array[i] = pArray[contador];
					contador++;
				}
			}
		}
		else
		{
			this.alocar(pArray.length - (array.length - size));
			int contador = 0;
			
			for(int i = 0; i < array.length; i++)
			{
				if(array[i] == null)
				{
					if(contador >= pArray.length)
						break;
					array[i] = pArray[contador];
					contador++;
				}
			}
		}
	}
	
	//Metodo para obtener partes del array
	public Object getElement(int pElemento)
	{
		if(pElemento < array.length)
		{
			return array[pElemento];
		}
		else
		{
			return null;
		}
	}
	
	//Metodo que elimina un elemento del array
	public boolean remove(int pElemento)
	{
		if(pElemento < array.length)
		{
			array[pElemento] = null;
			size--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Metodo alocar espacio en el array
	
	public void alocar(int pPosiciones)
	{
		Object[] tmpArray = new Object[this.array.length + pPosiciones];
		for(int i = 0; i < array.length; i++)
		{
			tmpArray[i] = array[i];
		}
		array = tmpArray;
	}

	//Metodo para compactar el array
	public void compactar()
	{
		int newSize = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != null)
			{
				newSize++;
			}
		}
		
		Object[] tmpArray = new Object[newSize];
		this.size = newSize;
		
		int contador = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] != null)
			{
				tmpArray[contador] = array[i];
				contador++;
			}
		}
		
		array = tmpArray;
	}
	
	//Metodos getset
	
	//Geter del array
	public Object[] getArray()
	{
		return this.array;
	}
	
	//Setter del array
	public void setArray(Object[] pArray)
	{
		this.array = pArray;
	}
	
	//Getter del size del array
	public int getSize()
	{
		return this.size;
	}
	
	//Setter del size del array
	public void setSize(int pSize)
	{
		this.size = pSize;
	}
	
	//Getter del incremento
	public int getIncremento()
	{
		return this.incremento;
	}
	
	//Setter del incremento
	public void setIncremento(int pIncremento)
	{
		this.incremento = pIncremento;
	}
	
	public String toString()
	{
		String salida = "Tamaño: " + size + "\nIncremento: " + incremento + "\nArray: " + array.length + "\n";
		
		for(int i = 0; i < array.length; i++)
		{
			salida += i + " " + array[i] + "\n";
		}
		
		return salida;
	}
}