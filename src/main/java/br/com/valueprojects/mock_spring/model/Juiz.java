
package br.com.valueprojects.mock_spring.model;


public class Juiz {
	
	private double maisPontos = Double.NEGATIVE_INFINITY;
	private double menosPontos = Double.POSITIVE_INFINITY;
	
	public Participante julga(Jogo jogo){
        Participante vencedor = null;

		if (jogo.getResultados().isEmpty()){
			throw new RuntimeException("Sem resultados n�o h� julgamento!");
        }
		for (Resultado resultado : jogo.getResultados()){
			if (resultado.getMetrica() > maisPontos) {
                vencedor = resultado.getParticipante();
                maisPontos = resultado.getMetrica();
            }
			if (resultado.getMetrica() < menosPontos) {
                menosPontos = resultado.getMetrica();
            }
	     }

        return vencedor;
	}
		
	public double getPrimeiroColocado(){
			return maisPontos;
		}
		
   public double getUltimoColocado(){
			
			return menosPontos;
		}

}
