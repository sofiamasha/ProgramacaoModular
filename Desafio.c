#include <stdio.h>

int main(void){

    char times[16] = {
        'A','B','C','D','E','F','G','H',
        'I','J','K','L','M','N','O','P'
    };

    char vencedores[16];

    int M, N;

    int quantidade = 16;

    for(int jogo = 0; jogo < 15; jogo++){

        scanf("%d %d", &M, &N);

        int pos = jogo % quantidade;

        if(M > N){
            vencedores[pos] = times[pos * 2];
        }
        else{
            vencedores[pos] = times[pos * 2 + 1];
        }

        if(pos == quantidade / 2 - 1){

            for(int i = 0; i < quantidade / 2; i++){
                times[i] = vencedores[i];
            }

            quantidade = quantidade / 2;
        }
    }

    printf("%c\n", times[0]);

    return 0;
}