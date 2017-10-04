
import analizadorlexico.Lexer;
import analizadorlexico.Token;
import java.io.IOException;
import java.io.StringReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
public class main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//EN VEZ DE USAR UN READER SOBRE UN STRING
		//PUEDEN INTENTAR USAR UN READER SOBRE UN ARCHIVO DE TEXTO.
		String input = "aaaababb abb\n"
			   + "aaab\n"
			   + "baababab\n"
			   + "abababb\n"
			   + "babbbbbbabb\n"
			   + "asdasd\n"
			   + "abaaabb\n"
			   + "\n"
			   + "sumando = 25\n"
			   + "id = sumando + 32.25\n"
			   + "25as.dasds3 = sumando2.";
		
		boolean seguir = true;
		Lexer analizador = new Lexer(new StringReader(input));
		while(seguir) {
			try {
				Token miToken = analizador.yylex();
				if (miToken == null) {
					seguir = false;
					break;
				}
				switch (miToken) {
					case ERROR:
						System.out.printf("Se encontro un error, lexema: [%s]\n", analizador.yytext());
						break;
					case IDENTIFICADOR:
					case NUMERO:
						System.out.printf("token del tipo [%s], lexema es [%s]\n", miToken.toString(), analizador.getLexema());
						break;
					default:
						System.out.printf("token del tipo [%s], solo hay un lexema el cual es [%s]\n", miToken.toString(), analizador.yytext());
						break;
				}
			} catch(IOException e) {
				seguir = false;
				break;
			}
			
		}
		
	}
	
	
	
}
