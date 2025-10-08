package br.com.valueprojects.mock_spring.model;

import java.util.Calendar;
import java.util.List;

import br.com.valueprojects.mock_spring.infra.JogoDao;



public class FinalizaJogo {

	private int total = 0;
	private final JogoDao dao;
    private Juiz juiz = new Juiz();

	public FinalizaJogo(JogoDao dao) {
		this.dao = dao;
	}

	public void finaliza() {
		List<Jogo> todosJogosEmAndamento = dao.emAndamento();

		for (Jogo jogo : todosJogosEmAndamento) {
			if (iniciouSemanaAnterior(jogo)) {
                // seta o id do jogador vencedor
                Participante vencedor = juiz.julga(jogo);
                jogo.setVencedor(vencedor.getId());

                jogo.finaliza();
				total++;
				dao.atualiza(jogo);

			}
		}
	}

	private boolean iniciouSemanaAnterior(Jogo jogo) {
		return diasEntre(jogo.getData(), Calendar.getInstance()) >= 7;
	}

	private int diasEntre(Calendar inicio, Calendar fim) {
		Calendar data = (Calendar) inicio.clone();
		int diasNoIntervalo = 0;
		while (data.before(fim)) {
			data.add(Calendar.DAY_OF_MONTH, 1);
			diasNoIntervalo++;
		}

		return diasNoIntervalo;
	}

	public int getTotalFinalizados() {
		return total;
	}
}
