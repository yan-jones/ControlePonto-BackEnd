package br.com.enumeration;

public enum Uf {

	AC("Acre"),	 
	AL("Alagoas"),	 
	AP("Amap�"),	 
	AM("Amazonas"),	 
	BA("Bahia"),	 
	CE("Cear�"),	 
	DF("Distrito Federal"),	 
	ES("Esp�rito Santo"),	 
	GO("Goi�s"),	 
	MA("Maranh�o"),	 
	MT("Mato Grosso"),	 
	MS("Mato Grosso do Sul"),	 
	MG("Minas Gerais"),	 
	PA("Par�"),	 
	PB("Para�ba"),	 
	PR("Paran�"),	 
	PE("Pernambuco"),	 
	PI("Piau�"),	 
	RJ("Rio de Janeiro"),	 
	RN("Rio Grande do Norte"),	 
	RS("Rio Grande do Sul"),	 
	RO("Rond�nia"),	 
	RR("Roraima"),	 
	SC("Santa Catarina"),	 
	SP("S�o Paulo"),	 
	SE("Sergipe"),	 
	TO("Tocantins");
	
	private String uf;

	private Uf(String uf) {
		setUf(uf);
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public static Uf findByOrdinal(Integer ordinal){
		for (Uf uf : values()) {
			if(uf.ordinal() == ordinal.intValue())
				return uf;
		}
		return null;
	}
	
	public static Uf findByName(String name){
		for (Uf uf : values()) {
			if(uf.name().equalsIgnoreCase(name))
				return uf;
		}
		return null;
	}
}
