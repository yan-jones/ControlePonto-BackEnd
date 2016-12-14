package br.com.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import br.com.entity.Pessoa;

public class LogUtil {

	// CAMINHO DO ARQUIVO DE LOG DOS LOGINS REALIZADOS COM SUCESSO
	// public static final String CAMINHO_ARQUIVO_LOGIN =
	// System.getProperty("jboss.server.log.dir") + "\\";
	private static final String CAMINHO_ARQUIVO_LOGIN = "..\\..\\..\\..\\resources\\Log\\";

	public static void logSuccessLogin(String nome, Pessoa pessoa) {
		File file = new File(CAMINHO_ARQUIVO_LOGIN + nome);
		try {
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.print("Data login: " + DataUtil.formatDataHoraBr(Calendar.getInstance().getTime()) + " - Pessoa: [nome="
					+ pessoa.getNome() + ", cpf=" + pessoa.getCpf() + ", perfil=" + pessoa.getPerfil() + ", status="
					+ pessoa.getStatus() + "]" + System.getProperty("line.separator"));
			pw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
