import java.util.Locale;
import java.util.Scanner;

public class MainProjetoCodingTank02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Double temp = 0.0D;
        Double somaEntrada = 0.0D;
        Double somaSaida = 0.0D;
        int contador = 0;
        Double mediaEntrada = 0.0D;
        Double mediaSaida = 0.0D;
        int entradaT;
        int saidaT;
    try{
            System.out.println("Digite a quantidade de entradas as serem transformadas:");
            int n = sc.nextInt();
            System.out.println("Digite o tipo de temperatura para ser convertido(1-C/2-F/3-K): ");
            entradaT = sc.nextInt();
            System.out.println("Digite o tipo de temperatura para qual deseja converter(1-C/2-F/3-K): ");
            saidaT = sc.nextInt();
            if(((entradaT >= 1) && (entradaT<=3)) && ((saidaT>= 1) && (saidaT <= 3))){
                for (int i = 0; i < n; i++) {
                    System.out.printf("Digite o valor da %d temperatura: ", i+1);
                    temp = sc.nextDouble();
                    somaEntrada = somaEntrada + temp;
                    contador++;

                    switch (entradaT) {
                        case 1:
                            if (saidaT == 3) {
                                celsiusParaKelvin(temp);
                                System.out.printf("Valor digitado em Celsius: %.2f ºC%n", temp);
                                System.out.printf("Valor convertido de Celsius para Kelvin: %.2f ºK%n",
                                        celsiusParaKelvin(temp));
                                somaSaida += celsiusParaKelvin(temp);
                            } else if (saidaT == 2) {
                                celsiusParaFahrenheit(temp);
                                System.out.printf("Valor em graus Celsius: %.2f ºC %n", temp);
                                System.out.printf("Valor convertido de Celsius para fahrenheit: %.2f ºF%n",
                                        celsiusParaFahrenheit(temp));
                                somaSaida += celsiusParaFahrenheit(temp);
                            } else {
                                System.out.println("Impossivel converter temperaturas iguais! Reinicie o programa."); return;
                            }
                            break;
                        case 2:
                            if (saidaT == 1) {
                                fahrenheitParaCelsius(temp);
                                System.out.printf("Valor digitado em Fahrenheit: %.2f ºF%n", temp);
                                System.out.printf("Valor convertido de Farenheit para Celsius: %.2f ºC%n",
                                        fahrenheitParaCelsius(temp));
                                somaSaida += fahrenheitParaCelsius(temp);
                            } else if (saidaT == 3) {
                                fahrenheitParaKelvin(temp);
                                System.out.printf("Valor digitado em Fahrenheit: %.2f ºK%n", temp);
                                System.out.printf("Valor convertido de Fahrenheit para Kelvin: %.2f ºF%n",
                                        fahrenheitParaKelvin(temp));
                                somaSaida += fahrenheitParaKelvin(temp);

                            } else {
                                System.out.println("Impossivel converter temperaturas iguais! Reinicie o programa."); return;
                            }
                            break;
                        case 3:
                            if (saidaT == 1) {
                                kelvinParaCelsius(temp);
                                System.out.printf("Valor digitado em Kelvin: %.2f ºK%n", temp);
                                System.out.printf("Valor convertido de Kelvin para Celsius: %.2f ºC%n",
                                        kelvinParaCelsius(temp));
                                somaSaida += kelvinParaCelsius(temp);
                            } else if (saidaT == 2) {
                                kelvinParaFahrenheit(temp);
                                System.out.printf("Valor digitado em Kelvin: %.2f ºF%n", temp);
                                System.out.printf("Valor convertido de Kelvin para Fahrenheit: %.2f ºK%n",
                                        kelvinParaFahrenheit(temp));
                                somaSaida += kelvinParaFahrenheit(temp);
                            } else {
                                System.out.println("Impossivel converter temperaturas iguais! Reinicie o programa."); return;
                            }
                    }
                }
            }
            else{
                System.out.println("Entrada de valores invalidos!Reiniciar programa.");
                return;
            }

        mediaEntrada = somaEntrada / contador;
        mediaSaida = somaSaida / contador;
        System.out.printf("Media das Temperaturas de entrada: %.2f %n", mediaEntrada);
        System.out.printf("Media das Temperaturas de saida: %.2f %n", mediaSaida);
    }catch(Throwable e) {
        System.out.println("Erro: " + e + ".\nReiniciar programa.");
        }
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
