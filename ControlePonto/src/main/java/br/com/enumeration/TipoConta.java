package br.com.enumeration;

public enum TipoConta {

	CORRENTE, SALARIO, POUPANÇA;

	public static TipoConta findByOrdinal(Integer ordinal) {
		for (TipoConta tipoConta : values()) {
			if (tipoConta.ordinal() == ordinal.intValue())
				return tipoConta;
		}
		return null;
	}

	public static TipoConta findByName(String name) {
		for (TipoConta tipoConta : values()) {
			if (tipoConta.name().equalsIgnoreCase(name))
				return tipoConta;
		}
		return null;
	}
}
