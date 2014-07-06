public class Recipe {
	private int id;
	private String recipeName;
	private String recipeUrl;
	
	public Recipe(int _id, String _recipe_name) {
		id = _id;
		recipeName = _recipe_name;
	}
	
	public void setId(int _id) {
		id = _id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setRecipeName(String _recipeName) {
		recipeName = _recipeName;
	}
	
	public String getRecipeName() {
		return recipeName;
	}
}