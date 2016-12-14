package br.com.enumeration;

public enum TipoEquipamento {

	IPHONE, MACBOOK, APPLE_WATCH, IPAD, APPLE_TV;

	public static TipoEquipamento findByOrdinal(Integer ordinal) {
		for (TipoEquipamento tipo : values()) {
			if (tipo.ordinal() == ordinal.intValue())
				return tipo;
		}
		return null;
	}

	public static TipoEquipamento findByName(String name) {
		for (TipoEquipamento tipo : values()) {
			if (tipo.name().equalsIgnoreCase(name))
				return tipo;
		}
		return null;
	}
}
