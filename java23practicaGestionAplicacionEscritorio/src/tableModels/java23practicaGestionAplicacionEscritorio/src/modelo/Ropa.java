package modelo;

public class Ropa {

	private String tipo;
	private String color;
	private String precio;
	private String talla;
	private String sexo;
	private String referencia;
	private String descripcion;
	private int id;

	public Ropa() {
	}

	public Ropa(String tipo, String color, String precio, String talla,
			String sexo, String referencia, String descripcion) {
		super();
		this.tipo = tipo;
		this.color = color;
		this.precio = precio;
		this.talla = talla;
		this.sexo = sexo;
		this.referencia = referencia;
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ropa [tipo=" + tipo + ", color=" + color + ", precio=" + precio
				+ ", talla=" + talla + ", sexo=" + sexo + "referencia="
				+ referencia + "descripcion=" + descripcion + "]";
	}

}
