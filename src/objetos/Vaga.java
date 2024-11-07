package objetos;

public class Vaga {
	int numVaga;
	String tamanho;
	boolean disp;
	Carro carro;
	public int getNumVaga() {
		return numVaga;
	}
	public void setNumVaga(int numVaga) {
		this.numVaga = numVaga;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isDisp() {
		return disp;
	}
	public void setDisp(boolean disponivel) {
		this.disp = disponivel;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Vaga(int numVaga, String tamanho) {
		this.numVaga = numVaga;
		this.tamanho = tamanho;
		this.disp = true;
	}
	@Override
	public String toString() {
		if(disp) {
			return "Vaga = " + numVaga + "\nTamanho = " + tamanho + "\n[Disponivel]";
		}
		return "Vaga = " + numVaga + "\nTamanho = " + tamanho + "\nPlaca do carro = " + carro.getPlaca() + "\n[Ocupada]";
	}
	
}
