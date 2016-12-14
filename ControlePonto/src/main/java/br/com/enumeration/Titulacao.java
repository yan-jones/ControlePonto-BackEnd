package br.com.enumeration;

public enum Titulacao {

	GRADUADO, ESPECIALISTA, MESTRADO, DOUTORADO, POS_DOUTORADO;

	public static Titulacao findByOrdinal(Integer ordinal) {
		for (Titulacao titulacao : values()) {
			if (titulacao.ordinal() == ordinal.intValue())
				return titulacao;
		}
		return null;
	}

	public static Titulacao findByName(String name) {
		for (Titulacao titulacao : values()) {
			if (titulacao.name().equalsIgnoreCase(name))
				return titulacao;
		}
		return null;
	}
}
