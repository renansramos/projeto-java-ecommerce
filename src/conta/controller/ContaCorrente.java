package conta.controller;

import conta.model.Conta;

public class ContaCorrente extends Conta{

	private float limite;

	public ContaCorrente(int numero, String titular) {
		super(numero, titular);
		this.limite = limite;
	}
	
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

    
}