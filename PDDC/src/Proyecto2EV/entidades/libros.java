package Proyecto2EV.entidades;

public class libros {
    protected String isbn, nombre, autor, genero;
	protected int cantidad, prestado;
	
	protected libros() {
		//este es el constructor vacio
	}


	public libros(String isbn, String nombre, String autor, String genero, int prestado, int cantidad) {
        //este es el constructor con todos los atributos que quiero que se usuen para  crear un libro(todos)
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.prestado = prestado;
        this.cantidad = cantidad;
    }

    // Getters y setters 
	public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPrestado() {
        return prestado;
    }

    public void setPrestado(int prestado) {
        this.prestado = prestado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        return "{" +
            " isbn='" + getIsbn() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", autor='" + getAutor() + "'" +
            ", genero='" + getGenero() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", prestado='" + getPrestado() + "'" +
            "}";
    }

}
	
	

