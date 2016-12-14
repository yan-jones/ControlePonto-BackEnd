package br.com.enumeration;

public enum Sexo {

	M("Masculino"), 
	F("Feminino");

	private String sexo;

	private Sexo(String sexo) {
		setSexo(sexo);
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public static Sexo findByOrdinal(Integer ordinal) {
		for (Sexo sexo : values()) {
			if (sexo.ordinal() == ordinal.intValue())
				return sexo;
		}
		return null;
	}

	public static Sexo findByName(String name) {
		for (Sexo sexo : values()) {
			if (sexo.name().equalsIgnoreCase(name))
				return sexo;
		}
		return null;
	}
}
