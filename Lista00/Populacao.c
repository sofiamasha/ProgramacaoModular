#include <stdio.h>

int main(void){

    char sexo;
    char olhos;
    char cabelos;
    int idade;

    int maior = 0;
    int menor = 0;
    int cont = 0;
    int primeiro = 1;

    while(1){

        scanf(" %c %c %c %d", &sexo, &olhos, &cabelos, &idade);

        if(idade == -1){
            break;
        }

        if(primeiro == 1){
            maior = idade;
            menor = idade;
            primeiro = 0;
        }
        else{
            if(idade > maior){
                maior = idade;
            }

            if(idade < menor){
                menor = idade;
            }
        }

        if(sexo == 'F' && idade >= 18 && idade <= 35 &&
           olhos == 'V' && cabelos == 'L'){
            cont++;
        }
    }

    printf("%d\n", maior);
    printf("%d\n", menor);
    printf("%d\n", cont);

    return 0;
}