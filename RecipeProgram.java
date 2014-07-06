import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Arrays;

public class RecipeProgram {

	private static String userInputedRecipeId;
	private static String recipeName;

    public static void main(String args[]) throws FileNotFoundException {
        
        // レシピデータハンドリング系の変数には必ずrecipeとつける        
        String recipeFilePath = args[0];

        // ユーザ入力変数を初期化
        userInputedRecipeId = 0;
        parseUserInputCommand(args);

        File recipeFile = new File(recipeFilePath);
        FileReader recipeFileReader = new FileReader(recipeFile);
        BufferedReader recipeBufferedReader = new BufferedReader(recipeFileReader);
        int recipeId = 1;        
        
        try{            
        	while (true) {

				recipeName = recipeBufferedReader.readLine();
				if(recipeName == null) {
                    break;
                }

				// 指定回数読み飛ばして表示する（まだエラー出てます。。）
        		if (recipeId != userInputedRecipeId || userInputedRecipeId != 0) {        			
 					// TODO: intとstringの変換をする。
        			continue;
				}

				// 追加
                Recipe recipeData = new Recipe(recipeId++, recipeName);
                System.out.println(recipeData.getId() + ":" + recipeData.getRecipeName());                
            }
        } catch (IOException recipeReadException) {
            recipeReadException.printStackTrace();
        }
    }

    // ユーザからのコマンドライン引数をファイルやIDなどに分離する処理を行う関数
    private static void parseUserInputCommand(String[] args) {
    	// @param1 : ファイル名
    	// @param2 : レシピID

    	Iterator itr = Arrays.asList(args).iterator();
		while (itr.hasNext()) {			
			// ファイル名は読み飛ばし
			itr.next();			
			userInputedRecipeId = (String) itr.next();
			System.out.println( userInputedRecipeId );
		}
    }

}
