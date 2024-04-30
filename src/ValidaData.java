import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;


public class ValidaData {
    

    public static boolean isDia(Object dia) {
        // Verifica se a entrada é uma String
        if (dia instanceof String) {
            try {
                // Tenta converter a String para int
                int diaInt = Integer.parseInt((String) dia);
                // Verifica se o dia está dentro do intervalo válido
                return diaInt >= 1 && diaInt <= 31;
            } catch (NumberFormatException e) {
                // Se houver uma exceção ao tentar converter para int, retorna falso
                return false;
            }
        }
        // Se a entrada não for uma String, verifica diretamente se está dentro do intervalo válido
        if (dia instanceof Integer) {
            // Se for um Integer, verifica se está dentro do intervalo válido
            int diaInt = (int) dia;
            return diaInt >= 1 && diaInt <= 31;
        }
        // Se a entrada não for nem String nem Integer, retorna falso
        return false;
    }

    private static final Map<String, Integer> mesesPorNome = new HashMap<>();

    static {
        mesesPorNome.put("janeiro", 1);
        mesesPorNome.put("fevereiro", 2);
        mesesPorNome.put("marco", 3);
        mesesPorNome.put("abril", 4);
        mesesPorNome.put("maio", 5);
        mesesPorNome.put("junho", 6);
        mesesPorNome.put("julho", 7);
        mesesPorNome.put("agosto", 8);
        mesesPorNome.put("setembro", 9);
        mesesPorNome.put("outubro", 10);
        mesesPorNome.put("novembro", 11);
        mesesPorNome.put("dezembro", 12);
    }

    public static boolean isMes(Object mes) {
        // Verifica se a entrada é uma String
        if (mes instanceof String) {
            String mesString = ((String) mes).toLowerCase();
            // Verifica se o nome do mês está na lista de meses em português
            return mesesPorNome.containsKey(mesString);
        }
        // Se a entrada não for uma String, verifica diretamente se está dentro do intervalo válido
        if (mes instanceof Integer) {
            // Se for um Integer, verifica se está dentro do intervalo válido
            int mesInt = (int) mes;
            return mesInt >= 1 && mesInt <= 12;
        }
        // Se a entrada não for nem String nem Integer, retorna falso
        return false;
    }

    public static boolean isAno(int ano) {
        int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);
        return ano >= (anoCorrente - 120) && ano <= anoCorrente;
    }

    public static boolean isDataValida(int dia, Object mes, int ano) {
        if (!isDia(dia) || !isMes(mes) || !isAno(ano)) {
            return false;
        }
        int mesInt;
        if (mes instanceof String) {
            String mesString = ((String) mes).toLowerCase();
            mesInt = mesesPorNome.get(mesString);
        } else {
            mesInt = (int) mes;
        }
        // Verifica se o dia é válido para o mês
        if (mesInt == 2) { // Fevereiro
            if (dia > 29) {
                return false;
            } else if (dia == 29) {
                // Verifica se é ano bissexto
                return isAnoBissexto(ano);
            }
        } else if ((mesInt == 4 || mesInt == 6 || mesInt == 9 || mesInt == 11) && dia > 30) {
            // Abril, Junho, Setembro, Novembro têm 30 dias
            return false;
        }
        return true;
    }

    private static boolean isAnoBissexto(int ano) {
        // Verifica se o ano é bissexto
        return ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0);
    }
}