import java.util.Locale;
import java.util.Scanner;

public class MainProjetoCodingTank02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Double temp = 0.0D;
        int n = 0;
        Double somaEntrada = 0.0D;
        Double somaSaida = 0.0D;
        Double mediaEntrada = 0.0D;
        Double mediaSaida = 0.0D;
        char entradaT = ' ';
        char saidaT = ' ';
        Double[] temperatura;
        Double[] convertida;

                System.out.println("Digite a quantidade de entradas as serem transformadas:");
                n = sc.nextInt();
                if (n > 0) {
                    try {
                System.out.println("Digite o tipo de temperatura para ser convertido(C/F/K): ");
                entradaT = sc.next().charAt(0);
                System.out.println("Digite o tipo de temperatura para qual deseja converter(C/F/K): ");
                saidaT = sc.next().charAt(0);
            } catch(Throwable e){
                System.out.println("erro do tipo " + e + ". Reinicie o Programa.");
            }finally{
                temperatura = new Double[n];
                convertida = new Double[n];
                if ((entradaT == 'c' || entradaT == 'C') || (entradaT == 'f' || entradaT == 'F') || (entradaT == 'k' || entradaT == 'K')
                        || (saidaT == 'c' || saidaT == 'C') || (saidaT == 'f' || saidaT == 'F') || (saidaT == 'k' || saidaT == 'K')) {
                    for (int i = 0; i < temperatura.length; i++) {
                        System.out.printf("Digite o valor da %d temperatura: ", i + 1);
                        temp = sc.nextDouble();
                        temperatura[i] = temp;
                        convertida[i] = converterTemperatura(temp, entradaT, saidaT);
                        System.out.printf("Valor digitado em %c: %.2f º%c%n", entradaT, temp, entradaT);
                        System.out.printf("Valor convertido para %c: %.2f º%c%n", saidaT, convertida[i], saidaT);
                    }
                    for (int i = 0; i < convertida.length; i++) {
                        somaEntrada += temperatura[i];
                        somaSaida += convertida[i];
                    }
                } else {
                    System.out.println("Erro de entrada Reinicie o Programa.");
                    return;
                }
                mediaEntrada = somaEntrada / n;
                mediaSaida = somaSaida / n;
                System.out.printf("Media das Temperaturas de entrada: %.2f º%c%n", mediaEntrada, entradaT);
                System.out.printf("Media das Temperaturas de saida: %.2f º%c%n", mediaSaida, saidaT);
            }
        }else{
            System.out.println("Erro de entrada de dado. Reinicie o programa.");
            return;
            }
        }


    private static Double converterTemperatura(Double temp, char entradaT, char saidaT) {
        switch (entradaT) {
            case 'C':
                if (saidaT == 'K') {
                    return celsiusParaKelvin(temp);
                } else if (saidaT == 'F') {
                   return celsiusParaFahrenheit(temp);
                }
                break;
            case 'F':
                if (saidaT == 'C') {
                   return fahrenheitParaCelsius(temp);
                } else if (saidaT == 'K') {
                  return fahrenheitParaKelvin(temp);
                }
                break;
            case 'K':
                if (saidaT == 'C') {
                   return kelvinParaCelsius(temp);
                } else if (saidaT == 'F') {
                    return kelvinParaFahrenheit(temp);
                }
                break;
            default:
                System.out.println("erro de entrada");
                return temp = 0.0D;
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
