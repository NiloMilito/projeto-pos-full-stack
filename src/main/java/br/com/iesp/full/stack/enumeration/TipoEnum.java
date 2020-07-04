package br.com.iesp.full.stack.enumeration;

public enum TipoEnum {
	SERVICO(1), PRODUTO(2);
	
	private int valor;
	private String descricao;
	
	private TipoEnum(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}		
	

}
