package model;

public class Restaurant extends Arrangement {

	private String name;
	private Integer stars;
	private String meal;
	private double mealPrice;

	public Restaurant(String name, int stars, String meal, double mealPrice) {
		super();
		this.name = name;
		this.stars = stars;
		this.meal = meal;
		this.mealPrice = mealPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getMealPrice() {
		return mealPrice;
	}

	public void setMealPrice(double mealPrice) {
		this.mealPrice = mealPrice;
	}

	public void sumPrices() {

	}

	public int toEvaluate() {
		return 2;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", stars=" + stars + ", meal=" + meal + ", mealPrice=" + mealPrice + "]";
	}

	@Override
	public void toPostpone() {

	}

	@Override
	public void antecipate() {

	}

	@Override
	public boolean cancel() {
		return true;
	}
}
