
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RecipeProgram {

    public static void main(String args[]) throws FileNotFoundException {
        
        // レシピデータハンドリング系の変数には必ずrecipeとつける
        String recipe;
        String recipeFilePath = args[0];
        File recipeFile = new File(recipeFilePath);
        FileReader recipeFileReader = new FileReader(recipeFile);
        BufferedReader recipeBufferedReader =
                new BufferedReader(recipeFileReader);
        int recipeId=1;
        
        try{
            while(true){
                recipe = recipeBufferedReader.readLine();
                
                if(recipe == null){
                    break;
                }
                
                System.out.println(recipeId+":"+recipe);
                recipeId++;
            }
        } catch(IOException recipeReadException){
            recipeReadException.printStackTrace();
        }

    }

}
