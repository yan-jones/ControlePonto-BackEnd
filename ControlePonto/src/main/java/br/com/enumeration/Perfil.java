package br.com.enumeration;

public enum Perfil {

	GESTOR, PROFESSOR, ALUNO, SEGURANCA;

	public static Perfil findByOrdinal(Integer ordinal) {
		for (Perfil perfil : values()) {
			if (perfil.ordinal() == ordinal.intValue())
				return perfil;
		}
		return null;
	}

	public static Perfil findByName(String name) {
		for (Perfil perfil : values()) {
			if (perfil.name().equalsIgnoreCase(name))
				return perfil;
		}
		return null;
	}
}
