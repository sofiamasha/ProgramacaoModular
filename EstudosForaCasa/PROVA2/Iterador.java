
Iterator<String> it = nomes.iterator();

while(it.hasNext()){
    String nome=it.next();
    if(nome.equals("Ana")){
        it.remove();
    }
}

ArrayList<Veiculo> veiculos = new ArrayList<>();

veiculos.add(new Moto("123", "honda"));
veiculos.add(new Drone("234", "bansai"));
veiculos.add(new Caminhao("345", "orndem"));

Iterator <Veiculo> it = veiculos.iterator();
while(it.hasNext()){
    Veiculo v=it.next();

    v.exibirInformacoes();

    if(v instanceof Moto){
        Moto m=(Moto) v;
        m.rastrearVeiculo();
    }

    if(v instaceof Caminhao){
        it.remove();
    }
}