package conta.model;

public abstract class Conta {
	protected int numero;
	private String titular;

	
//Gerando o método construtor 
	public Conta(int numero, String titular) {
		this.numero = numero;
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	
	public void visualizar() {
		String numero = "";
		
		switch (this.numero) {
		case 1:
			numero="Produtos: ";
			break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Produto:");
		System.out.println("***********************************************************");
		System.out.println("Id do Produto: " + this.numero);
		System.out.println("Produto: " + this.titular);
	}
}
