
try{
    int divisao=a/b;
    System.out.println("Valor: " + divisao);
}catch(ArithmeticException e){
    System.out.println("Divisao por zero: " + e.getMessage());
}
System.out.println("FIM");