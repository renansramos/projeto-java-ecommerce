package conta.model;

public class ContaCorrente extends Conta{

	private float limite;

	public ContaCorrente(int numero, String titular) {
		super(numero, titular);
		this.limite = limite;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("O Produto é: " + this.limite);
		System.out.println("O ID é: " + this.numero);
	}
    
}