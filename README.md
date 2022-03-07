# Transferencias-Bancaria
package model;

import helper.Utils;

public class Conta {
	private static int codico = 1001;

	private int numero;
	private Cliente cliente;
	private Double saldo = 0.0;
	private Double limite = 0.0;
	private Double saldoTotal;

	public Conta(Cliente cliente) {
		this.numero = Conta.codico;
		this.cliente = cliente;
		Conta.codico += 1;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public int getNumero() {
		return numero;
	}

	public Double getSaldoTotal() {
		return saldoTotal;
	}

	private void atualizaSaldoTotal() {
		this.saldoTotal = this.getSaldo() + this.getLimite();
	}

	public String toString() {
		return "Numero da Conta: " + this.getNumero() + "\nCliente: " + this.cliente.getNome() + "\nSaldo Total: "
				+ Utils.doubleParaString(this.getSaldoTotal());

	}

	public void depositar(Double valor) {
		if (valor > 0) {
			this.saldo = this.getSaldo() + valor;
			this.atualizaSaldoTotal();
			System.out.println("Deposito efetuado com sucesso! ");
		} else {
			System.out.println("Erro ao efetuar deposito. Tente novamente. ");
		}
	}

	public void sacar(Double valor) {
		if (valor > 0 && this.getSaldoTotal() >= valor) {
			if (this.getSaldo() >= valor) {
				this.saldo = this.getSaldo() - valor;
				this.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso! ");

			} else {
				Double restante = this.getSaldo() - valor;
				this.limite = this.getLimite() - restante;
				this.saldo = 0.00;
				this.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso! ");

			}

		} else {
			System.out.println("Saque nao realizado. Tente novamente. ");
		}

	}

	public void transferir(Conta destino, Double valor) {
		if (valor > 0 && this.getSaldoTotal() >= valor) {
			if (this.getSaldo() >= valor) {
				this.saldo = this.getSaldo() - valor;
				destino.saldo = destino.getSaldo() + valor;
				this.atualizaSaldoTotal();
				destino.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso! ");
			} else {
				Double restante = this.getSaldo() - valor;
				this.limite = this.getLimite() - restante;
				this.saldo = 0.00;
				destino.saldo = destino.getSaldo() + valor;
				this.atualizaSaldoTotal();
				destino.atualizaSaldoTotal();
				System.out.println("Saque efetuado com sucesso! ");
			}

		} else {
			System.out.println("Saque nao realizado. Tente novamente. ");
		}
	}
}
