package br.com.enumeration;

public enum Uf {

	AC("Acre"),	 
	AL("Alagoas"),	 
	AP("Amapá"),	 
	AM("Amazonas"),	 
	BA("Bahia"),	 
	CE("Ceará"),	 
	DF("Distrito Federal"),	 
	ES("Espírito Santo"),	 
	GO("Goiás"),	 
	MA("Maranhão"),	 
	MT("Mato Grosso"),	 
	MS("Mato Grosso do Sul"),	 
	MG("Minas Gerais"),	 
	PA("Pará"),	 
	PB("Paraíba"),	 
	PR("Paraná"),	 
	PE("Pernambuco"),	 
	PI("Piauí"),	 
	RJ("Rio de Janeiro"),	 
	RN("Rio Grande do Norte"),	 
	RS("Rio Grande do Sul"),	 
	RO("Rondônia"),	 
	RR("Roraima"),	 
	SC("Santa Catarina"),	 
	SP("São Paulo"),	 
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
