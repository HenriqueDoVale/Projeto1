public class Projeto1{
  public static void main(String[] args) {
  final int tamanhoQuadriculas = 8;
  Sokoban(43521141 , tamanhoQuadriculas);
  Sokoban(435211412 , tamanhoQuadriculas);
  Sokoban(4352114 , tamanhoQuadriculas);
  Sokoban(43527141 , tamanhoQuadriculas);
  Sokoban(43525141 , tamanhoQuadriculas);
  Sokoban(43221141 ,tamanhoQuadriculas);
  Sokoban(43121145 , tamanhoQuadriculas);
  Sokoban(43121541 , tamanhoQuadriculas);
  Sokoban(43121522 , tamanhoQuadriculas);
  Sokoban(43121152 , tamanhoQuadriculas);
  }
  /**
  *Dado um numero inteiro a função devolve o numero de digitos desse numero
  *
  *@param num numero inteiro dado
  *@requires {@code num>0}
  *@return  retorna o numero de digitos de num
  */
  public static int digits(int num){
    int contador = 0;
    while (num > 0){
      num /= 10;
      contador++;
    }
    return contador;
  }
  /**
  *Dado um numero e um digito de 1 a 9 calcula o nº de ocurrenciasNum
  *
  *@param num numero dado inteiro
  *@param d digito de 1 a 9
  *@requires {@code num>0 && d>0 && d<=9}
  *@ensures {@code \result>0}
  *@return nº de vezes que o digito ocorre no num dado
  */
  public static int occurrencesOf(int num, int d){
  int contador = 0;
  while(num > 0){
    if (num%10 == d) {
      contador++;
    }
    num /= 10;
    }
    return contador;
  }
  /**
   * Verifica se um dado numero é positivo, apenas contem digitos de
   * 1 a 5 e se tem no máximo uma ocorrência de 5
   *
   *@param num numero inteiro dado
   *@return retorna true se num for positivo, com digitos de 1 a 5
   * e com no maximo uma ocorrência de 5 e false se alguma das
   *condições não for cumprida
   */
  public static boolean isValid(int num){
    int contadorDe5 = 0;

    if (num < 0) {
      return false;
    }

    while (num > 0){
      if((num%10) == 5){
        contadorDe5++;
      }

      if ((num%10) > 5 || contadorDe5 > 1) {
        return false;
      }
      num /= 10;
  }
  return true;


}
  /**
  * Dado um numero num e um digito d, retorna o numero à direita
  * do digito d
  *
  *@param num numero inteiro dado
  *@param d digito de 0 a 9
  *@requires {@code (occurrencesOf(num, d) == 1)}
  *@ensures {@code \result >= 0}
  *@return retorna a sequencia de numeros à direita de d, se default:
  *for o digito mais à direita retorna 0
  */
  private static int rightSubsequence(int num,int d){
    int soma = 0;
    int contador = 1;
    int contador2 = 0;
    int mult = 1;

    while(num>0){
      if (num%10 != d) {
        while(contador2<contador) {
          soma += (num%10) * mult;
          contador2++;
          mult *= 10;
        }
        contador += 1;
      }
      num /= 10;

      if (num%10 == d) {
        return soma;
      }
    }
        return 0;
    }
    /**
    *Verifica se sequência  de  dígitos  à  direita  de  5  representa  um  inteiro  positivo  e  o  primeiro  dígito  dessa
    *sequência é ímpar ou se a sequência de dígitos à direita de 5 representa um inteiro maior que 10 e o produto dos seus dois
    *primeiros dígitos não é múltiplo de 4.
    *
    *@param num inteiro dado
    *@requires {@code isValidnum(num)==true && occurrencesOf(num,5)==1 }
    *@return true se a sequência  de  dígitos  à  direita  de  5  representa  um  inteiro  positivo  e  o  primeiro  dígito  dessa
    *sequência é ímpar ouse a sequência de dígitos à direita de 5 representa um inteiro maior que 10 e o produto dos seus dois
    *primeiros dígitos não é múltiplo de 4. E falso se não ocorrer as condições
    */
    public static boolean ableToMoveRight(int num){

    int nDepoisDe5 = rightSubsequence(num , 5);
    int nDigitos = digits(nDepoisDe5);
    int aux = nDepoisDe5;
    int primDigitoDepoisDeN = 0; //primeiro digito depois de n
    int segundDigitoDepoisDeN = 0; //segundo digito depois de n

    if (nDigitos>=2) { //aux vai ter o valor dos 2 numeros depois de n
      for (int i = 0; i < nDigitos-2; i++) {
      aux /= 10;
    }
    primDigitoDepoisDeN = aux/10;
    segundDigitoDepoisDeN = aux%10;
  } else { //se só houver 1 digito
  primDigitoDepoisDeN = aux;
  }

    if ( (nDepoisDe5>0 && primDigitoDepoisDeN%2!=0) || ((nDepoisDe5>10) && ((primDigitoDepoisDeN*segundDigitoDepoisDeN) % 4 != 0)) ) {
      return true; //se a ou b, é movivel para a direita
    }
    return false;
  }
  
 /**
     * Verifica de o numero inteiro dado tem valor positivo com digitos de 1 a
     * 5 e com no maximo uma ocorrencia de 5 e se tem numDigits digitos
     *
     *@param num numero inteiro dado
     *@param numDigits numero inteiro que representa o numero de digitos
     *@requires {@code numDigits <= 9 && numDigits > 0}
     *@return retorna true se num tem valor positivo com digitos de 1 a
     * 5 e com no maximo uma ocorrencia de 5 e se tem numDigits digitos e
     * retorna false se não
     */
   public static boolean isValidForGrid (int num , int numDigits ){
     if (isValid(num) && numDigits==digits(num)) {
       return true;
     }
       else{
       return false;}
   }
   /**
     * Dá print ao numero e diz se é valido para numDigits, verifica
     * se o digito 5 ocorre e diz se é, ou não, movivel para a direita
     *
     * @param num numero inteiro dado
     * @param numDigits numero inteiro que representa o numero de digitos 
     */
   public static void Sokoban(int num, int numDigits){
      System.out.print("O numero " + num);
    if (isValidForGrid(num, numDigits)) {
      System.out.print(" valido, ");

      if (occurrencesOf(num, 5) == 1) {
        System.out.print(" 5 ocorre,");

        if (ableToMoveRight(num)) {
          System.out.print(" é movivel para a direita. \n");
        }
        else{
          System.out.print(" não é movivel para a direita. \n");
        }
      }
        else {
          System.out.print(" 5 não ocorre. \n");
        }
    }
    else
    System.out.println(" invalido.");
}
}
