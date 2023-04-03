package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SharedMemory {
    private final ArrayList<Token> tokens;
    private final int n;

    SharedMemory(int n){
        this.n = n;
        var tokens = new ArrayList<Token>();
        for (int i = 1;i<=n*n*n;i++){
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
        this.tokens = tokens;
    }


    public synchronized ArrayList<Token> extractTokens(int count){
        var extracted = new ArrayList<Token>();
        Random rand = new Random();
        for(int i = 0;i<count;i++){
            if (tokens.isEmpty()){
                break;
            }
            int randomPosition = rand.nextInt(this.tokens.size());
            extracted.add(this.tokens.get(randomPosition));
            this.tokens.remove(randomPosition);
        }
        return extracted;
    }

    public int getN() {
        return n;
    }
}
