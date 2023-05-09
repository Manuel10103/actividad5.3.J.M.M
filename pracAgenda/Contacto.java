package pracAgenda;

class Contacto {

	protected String nombre;
	protected String apellidos;
	protected String numtlfn;
	protected String mail;
	protected String dni;
	protected Fecha fechanac;
	protected String desc;

	protected Contacto(String nombre, String apellidos, String numtlfn, String mail, String dni, Fecha fechanac,
			String desc) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numtlfn = numtlfn;
		this.mail = mail;
		this.dni = dni;
		this.fechanac = fechanac;
		this.desc = desc;
	}

	public Contacto() {
		
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	protected String getNumtlfn() {
		return numtlfn;
	}

	protected void setNumtlfn(String numtlfn) {
		this.numtlfn = numtlfn;
	}

	protected String getMail() {
		return mail;
	}

	protected void setMail(String mail) {
		this.mail = mail;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected Fecha getFechanac() {
		return fechanac;
	}

	protected void setFechanac(Fecha fechanac) {
		this.fechanac = fechanac;
	}

	protected String getDesc() {
		return desc;
	}

	protected void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", numtlfn=" + numtlfn + ", mail=" + mail
				+ ", dni=" + dni + ", fechanac=" + fechanac + ", desc=" + desc + "]";
	}

}
