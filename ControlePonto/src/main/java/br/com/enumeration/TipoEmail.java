package br.com.enumeration;

public enum TipoEmail {

	ESQUECEU_SENHA, CONFIRMACAO_CADASTRO, NOVO_CADASTRO;

	public static TipoEmail findByOrdinal(Integer ordinal) {
		for (TipoEmail email : values()) {
			if (email.ordinal() == ordinal.intValue())
				return email;
		}
		return null;
	}

	public static TipoEmail findByName(String name) {
		for (TipoEmail email : values()) {
			if (email.name().equalsIgnoreCase(name))
				return email;
		}
		return null;
	}
}
