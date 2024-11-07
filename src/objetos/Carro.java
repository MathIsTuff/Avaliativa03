package objetos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Carro {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd");
	 String placa;
	 String modelo;
	 String tamanho;
	 LocalDateTime horaEntrada;
	 LocalDateTime horaSaida;
	 long hours;
	 long minutes;
	 double valor;
	 boolean completed = false;
	 
	 
	 public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getHoraEntrada() {
		return horaEntrada.format(formatter);
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida.format(formatter);
	}
	public long getHoras() {
		return hours;
	}
	public long getMinutos() {
		return minutes;
	}
	public double getValor() {
		return valor;
	}
	
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void checkOut() {
		this.horaSaida = LocalDateTime.now();
		this.hours = ChronoUnit.HOURS.between(horaEntrada, horaSaida);
		this.minutes = ChronoUnit.MINUTES.between(horaEntrada, horaSaida);
		this.completed = true;
		if(minutes<=60) {
			this.valor = 5.00;
		} else if(minutes<=180) {
			this.valor = 10.00;
		} else {
			this.valor = 15.00;
		}
	
	}

	public Carro(String placa, String modelo, String tamanho) {
	        this.placa = placa;
	        this.modelo = modelo;
	        this.tamanho = tamanho;
	        this.horaEntrada = LocalDateTime.now();
	    }

	@Override
	public String toString() {
		return "Carro do modelo " + modelo + "    Placa = " + placa + "  Tamanho = " + tamanho + "\nEntrada = " + horaEntrada.format(formatter)
				+ "     Saida = " + horaSaida.format(formatter) + "\nHoras no estacionamento = " + hours + "    Pagou R$:" + valor;
	}
}
