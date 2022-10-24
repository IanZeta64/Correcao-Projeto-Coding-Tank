import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MainProjetoCodingTank02 {
public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    int n = 0, codEntrada = 0, codSaida = 0;
    Double temp = 0.0D;
    Double somaEntrada = 0.0D, somaSaida = 0.0D, mediaEntrada = 0.0D, mediaSaida = 0.0D;
    Double[] temperatura, convertida;
    char entradaT = ' ', saidaT = ' ';

    try {
        System.out.println("Digite a quantidade de entradas as serem transformadas:");
        n = sc.nextInt();
    } catch (InputMismatchException e1) {
        System.out.println("Erro de entrada de dados(" + e1 + "). Reinicie o programa.");
        return;
    }
    try {
        if (n > 0) {
            System.out.println("Digite o tipo de temperatura para ser convertido. \n1-C\n2-F\n3-K: ");
            codEntrada = sc.nextInt();
        } else {
            System.out.println("Erro de entrada de dados. Reinicie o Programa.");
            return;
        }
        if (codEntrada >= 1 && codEntrada <= 3) {
            if (codEntrada == 1) {entradaT = 'C';}
            else if (codEntrada == 2) {entradaT = 'F';}
            else {entradaT = 'K';}
        } else {
            System.out.println("Erro de entrada de dados. Reinicie o Programa.");
            return;
        }
        } catch (InputMismatchException e2) {
            System.out.println("Erro de entrada de dados(" + e2 + "). Reinicie o programa.");
            return;
        }
    try {
        System.out.println("Digite o tipo de temperatura para qual deseja converter. \n1-C\n2-F\n3-K: ");
        codSaida = sc.nextInt();
            if (codSaida >= 1 && codSaida <= 3) {
                if (codSaida == 1) {saidaT = 'C';}
                else if (codSaida == 2) {saidaT = 'F';}
                else {saidaT = 'K';}
            } else {
                System.out.println("Erro de entrada de dados. Reinicie o Programa. ");
                return;
            }
    } catch (InputMismatchException e3) {
        System.out.println("Erro de entrada de dados(" + e3 + "). Reinicie o programa.");
        return;
    }
    temperatura = new Double[n];
    convertida = new Double[n];
        for (int i = 0; i < temperatura.length; i++) {
            System.out.printf("Digite o valor da %d temperatura: ", i + 1);
            temp = sc.nextDouble();
            temperatura[i] = temp;
            convertida[i] = converterTemperatura(temp, codEntrada, codSaida, entradaT, saidaT);
            System.out.printf("Valor digitado em %c: %.2f º%c%n", entradaT, temp, entradaT);
            System.out.printf("Valor convertido para %c: %.2f º%c%n", saidaT, convertida[i], saidaT);
        }
        for (int i = 0; i < convertida.length; i++) {
            somaEntrada += temperatura[i];
            somaSaida += convertida[i];
        }
        mediaEntrada = somaEntrada / n;
        mediaSaida = somaSaida / n;
        System.out.printf("Media das Temperaturas de entrada: %.2f º%c%n", mediaEntrada, entradaT);
        System.out.printf("Media das Temperaturas de saida: %.2f º%c%n", mediaSaida, saidaT);
    }
    private static Double converterTemperatura(Double temp, int codEntrada, int codSaida, char entradaT, char saidaT) {
    switch (codEntrada) {
        case 1:
            if (codSaida == 3) {
                return celsiusParaKelvin(temp);
            } else if (codSaida == 2) {
               return celsiusParaFahrenheit(temp);
            }
            break;
        case 2:
            if (codSaida == 1) {
               return fahrenheitParaCelsius(temp);
            } else if (codSaida == 3) {
              return fahrenheitParaKelvin(temp);
            }
            break;
        case 3:
            if (codSaida == 1) {
               return kelvinParaCelsius(temp);
            } else if (codSaida == 2) {
                return kelvinParaFahrenheit(temp);
            }
            break;
        default:
            return temp;
    } return temp;
    }
    private static final Double FATOR1 =  9.0D / 5.0D;
    private static final Double FATOR2 = 32D;
    private static final Double FATOR3 = 273.15D;
    private static final Double FATOR4 = 5.0D/ 9.0D;
    private static Double celsiusParaFahrenheit(double celsius){
    Double celsiusFhrenheit = (celsius * FATOR1) + FATOR2;
    return celsiusFhrenheit;
    }
    private static Double fahrenheitParaCelsius(double fahrenheit){
    Double fahrenheitCelsius = (fahrenheit - FATOR2) * FATOR4;
    return fahrenheitCelsius;
    }
    private static Double celsiusParaKelvin(double celsius){
    Double celsiusKelvin = celsius + FATOR3;
    return celsiusKelvin;
    }
    private static Double kelvinParaCelsius(double kelvin){
    Double kelvinCelsius = kelvin - FATOR3;
    return kelvinCelsius;
    }
    private static Double fahrenheitParaKelvin(double fahrenheit){ //( °F − 32) × 5/9 + 273,15 = 273,15 K
    Double fahrenheitKelvin = (fahrenheit - FATOR2) * FATOR4 + FATOR3;
    return fahrenheitKelvin;
    }
    private static Double kelvinParaFahrenheit(double kelvin){ //(0 K − 273,15) × 9/5 + 32 = -459,7 °F
    Double kelvinFahrenheit = (kelvin - FATOR3) * FATOR1 + FATOR2;
    return kelvinFahrenheit;
    }
}
