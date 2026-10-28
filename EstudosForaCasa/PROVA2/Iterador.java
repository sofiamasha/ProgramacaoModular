
Iterator<String> it = nomes.iterator();

while(it.hasNext()){
    String nome=it.next();
    if(nome.equals("Ana")){
        it.remove();
    }
}