package br.com.enumeration;

public enum Status {

	APROVADO, PENDENTE;

	public static Status findByOrdinal(Integer ordinal) {
		for (Status status : values()) {
			if (status.ordinal() == ordinal.intValue())
				return status;
		}
		return null;
	}

	public static Status findByName(String name) {
		for (Status status : values()) {
			if (status.name().equalsIgnoreCase(name))
				return status;
		}
		return null;
	}
}
